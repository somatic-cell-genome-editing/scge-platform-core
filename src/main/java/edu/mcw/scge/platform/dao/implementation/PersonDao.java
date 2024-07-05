package edu.mcw.scge.platform.dao.implementation;

import edu.mcw.scge.platform.dao.AbstractDAO;
import edu.mcw.scge.platform.dao.spring.IntListQuery;
import edu.mcw.scge.platform.dao.spring.PersonInfoQuery;
import edu.mcw.scge.platform.dao.spring.PersonQuery;
import edu.mcw.scge.platform.dao.spring.StringListQuery;
import edu.mcw.scge.platform.datamodel.Person;

import edu.mcw.scge.platform.datamodel.PersonInfo;
import edu.mcw.scge.platform.datamodel.SCGEGroup;


import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by jthota on 8/20/2019.
 */
public class PersonDao extends AbstractDAO {
        GroupDAO gdao=new GroupDAO();

        public boolean isAdmin(Person person) throws Exception {
            String sql="select * from person p , person_info pi where " +
                    " p.person_id=pi.person_id and" +
                    " p.email_lc=?" +
                    " and role_key in (select role_key from scge_roles where role=?)";
            PersonQuery personQuery=new PersonQuery(this.getDataSource(), sql);
            List<Person> personList=personQuery.execute(sql, person.getEmail_lc(), "admin");
            return personList.size() > 0;

        }
    public boolean isDeveloper(Person person) throws Exception {
        String sql="select * from person p , person_info pi where " +
                " p.person_id=pi.person_id and" +
                " p.email_lc=?" +
                " and role_key in (select role_key from scge_roles where role=?)";
        PersonQuery personQuery=new PersonQuery(this.getDataSource(), sql);
        List<Person> personList=personQuery.execute(sql, person.getEmail_lc(), "developer");
        return personList.size() > 0;
    }
    public void insert(Person p) throws Exception {

        int newId = 0;
        if (p.getId() == 0) {
            newId = getNextKey("person_seq");
        } else {
            newId = p.getId();
        }

        String sql="insert into person(person_id,name, name_lc, institution_id, email, email_lc," +
                "phone, address, google_id,status, created_date, modified_date, modified_by, other_id, " +
                "first_name," +
                "last_name)" +
                " values(?,?,?,?,?,?,?,?,?,?,current_date,current_date,?,?,?,?)";
        update(sql,
                newId, p.getName(),p.getName().toLowerCase(),
                p.getInstitution(),
                p.getEmail(),p.getEmail().toLowerCase(),
                p.getPhone(), p.getAddress(), p.getGoogleSub(),
                p.getStatus(),
            //    p.getGrantId(),
                p.getModifiedBy(),
                p.getOtherId(),
                p.getFirstName(),p.getLastName()
        );

    }
    public void update(Person p) throws Exception {
        String sql="update person set name=?, first_name=?, last_name=?, name_lc=?,institution_id=?,email=?,email_lc=?,status=?, other_id=?, modified_date=current_date where person_id=?";

        update(sql, p.getName(), p.getFirstName(), p.getLastName(), p.getName().toLowerCase(), p.getInstitution(),p.getEmail(), p.getEmail().toLowerCase(),p.getStatus(),p.getOtherId(), p.getId());
    }

    public List<Person> getPerson(Person p) throws Exception{
      //  String sql="select * from person where name_lc=? and email_lc=? and status='ACTIVE' ";
        String sql="select * from person where email_lc=? and status='ACTIVE' ";
        PersonQuery query=new PersonQuery(this.getDataSource(), sql);
         return execute(query, p.getEmail().toLowerCase());
    }


    public List<Person> getPersonByEmailId(Person p) throws Exception{
        //  String sql="select * from person where name_lc=? and email_lc=? and status='ACTIVE' ";
        String sql="select * from person where email_lc=? ";
        PersonQuery query=new PersonQuery(this.getDataSource(), sql);
        return execute(query, p.getEmail().toLowerCase());
    }
    public List<Person> getPersonById(int id) throws Exception{
        String sql="select * from person where person_id=? ";
        PersonQuery query=new PersonQuery(this.getDataSource(), sql);
        return execute(query,id);
    }
    public List<Person> getPersonByGoogleId(String id) throws Exception{
        String sql="select * from person where google_id=?  ";
        PersonQuery query=new PersonQuery(this.getDataSource(), sql);
        return execute(query,id);
    }
    public List<Person> getPersonByLastName(String lastName) throws Exception{
        String sql="select * from person where name like '%"+lastName+"%'  " ;
        PersonQuery query=new PersonQuery(this.getDataSource(), sql);
        return execute(query);
    }
    public String getPersonStatus(String subject) throws Exception{
        String sql="select status from person where google_id=?";
       // String sql="select status from person where email=?";
        StringListQuery query= new StringListQuery(this.getDataSource(), sql);
        return (String) execute(query, subject).get(0);
    }
    public List<Person> getPersonByEmail(String email) throws Exception{
        String sql="select * from person where email_lc=? or other_id=? or email=? ";
        PersonQuery query=new PersonQuery(this.getDataSource(), sql);
        return execute(query, email.toLowerCase(), email, email);
    }
    public List<Person> getAllActiveMembers() throws Exception{
        String sql="select * from person where status='ACTIVE' order by name ";
        PersonQuery query=new PersonQuery(this.getDataSource(), sql);
        return query.execute();
    }
    public List<Person> getAllMembers() throws Exception{
        String sql="select * from person order by name ";
        PersonQuery query=new PersonQuery(this.getDataSource(), sql);
        return query.execute();
    }

    public List<String> getPersonGroups(Person p) throws Exception {
        String sql="select g.group_name from scge_group g, person_info r, person p " +
                "where g.group_id=r.group_id " +
                "and r.person_id=p.person_id " +
                "and p.status='ACTIVE' " +
                "and p.person_id=?";
        StringListQuery q=new StringListQuery(this.getDataSource(), sql);
        return execute(q,p.getId());
    }
    public List<String> getGroups(Person p) throws Exception {
        String sql="select g.group_name from scge_group g , person_info pg where " +
                "g.group_id=pg.group_id and person_id=?";
        StringListQuery q=new StringListQuery(this.getDataSource(), sql);
        return execute(q, p.getId());
    }
    public List<Integer> getGroupIds(Person p) throws Exception {
        String sql="select group_id from  person_info  where " +
                " person_id=?";
        IntListQuery q=new IntListQuery(this.getDataSource(), sql);
        return execute(q, p.getId());
    }

    public void updateStatus(Person person) throws Exception {
        String sql="update person set status=? where email_lc=?";
            update(sql, person.getStatus(), person.getEmail().trim().toLowerCase());
    }
    public void updateStatusToInactive(String status) throws Exception {
        String sql="update person set status=?";
        update(sql, status);
    }
    public void updateGoogleId(String googleId, int personId) throws Exception {
        String sql="update person set google_id=? where person_id=? ";
        update(sql, googleId, personId);
    }
    public void updatePersonNewAttributes(Person person) throws Exception {
        String sql="update person set first_name=?, last_name=?, google_id=?, other_id=? where email=? or email_lc=?";
        update(sql,  person.getFirstName(), person.getLastName(), person.getGoogleSub(), person.getOtherId() ,person.getEmail(),person.getEmail().toLowerCase());
    }

    public List<String> getRolesByPersonId(int personId, String groupName) throws Exception {
        String sql="select r.role from scge_roles r, person p, person_info pi, scge_group g where " +
                "r.role_key=pi.role_key " +
                "and p.person_id=pi.person_id " +
                "and g.group_id=pi.group_id " +
                "and p.status='ACTIVE' "  +
                "and p.person_id=? " +
                "and g.group_name=?"
                ;
        StringListQuery query=new StringListQuery(this.getDataSource(), sql);
        return execute(query, personId, groupName);

    }


    public void insertInstitution(int id,String name) throws Exception {

        String sql="insert into institution values(?,?,?)";
        try {
            update(sql, id, name, name.toLowerCase());
        }catch (Exception e){
            System.err.println("Institution: "+ name);
            e.printStackTrace();
        }

    }
    public int insertOrUpdateInstitution(String name) throws Exception {
        String sql="select institution_id from institution where institution_name=?";
        IntListQuery query=new IntListQuery(this.getDataSource(), sql);
        List<Integer> ids= execute(query, name);
        int id= 0;
        if(ids==null || ids.size()==0){
            id= getNextKey("institution_seq");
            insertInstitution(id, name);
        }else{
            id=ids.get(0);
        }
        return id;
    }

    public void insertGrant(int grant_id, String grantTitle, int groupId) throws Exception {

        String sql="insert into scge_grants values(?,?,?,?)";
        try {
            update(sql, grant_id, grantTitle, grantTitle.toLowerCase(),groupId);
        }catch (Exception e){
            System.err.println("Grant TITLE:"+grantTitle);
        }

    }

    public int getGroupId(String groupName, String groupType) throws Exception {
        String sql = "select group_id from scge_group where group_name_lc=? and group_type=?";
        IntListQuery query = new IntListQuery(this.getDataSource(), sql);
        List<Integer> ids = execute(query, groupName.toLowerCase().trim(), groupType);
        int id = 0;
        if (ids != null && ids.size() > 0) {

           gdao.updateGroupName(ids.get(0), groupName.trim());
            return ids.get(0);
        }else{
            id=getNextKey("group_seq");
            SCGEGroup group=new SCGEGroup();
            group.setGroupId(id);
            group.setGroupName(groupName.trim());
            group.setGroupType(groupType);
            group.setGroupNameLC(groupName.toLowerCase().trim());
            gdao.insert(group);
        }
        return id;

    }
    public List<Integer> getRolesIds(List<String> roles) throws Exception {

        String sql="select role_key from scge_roles where role in (";
        boolean first=true;
        for(String role: roles){
        if(first){
            sql=sql+"'"+role+"'";
            first=false;
        }else{
            sql=sql+","+"'"+role+"'";
        }
        }
        sql=sql+")";
    //    System.out.println("SQL:"+ sql);
        IntListQuery query=new IntListQuery(this.getDataSource(), sql);

        return query.execute();
    }


    public void delete(Person person) throws Exception{
        deletePersonInfo(person);
        String sql="delete from person where person_id=?" ;
        update(sql, person.getId() );


    }
    public void deletePersonInfo(Person person) throws Exception{

        String sql="delete from person_info where person_id=?" ;
        update(sql, person.getId() );


    }

    public void removeGroup(Person person, int groupId) throws Exception{
        String sql="delete from person_info where person_id=? and group_id=?" ;
        update(sql, person.getId(),groupId );

    }
    public int getRoleId(String role) throws Exception {
        int roleKey=0;
        String sql="select role_key from scge_roles where role=?";
        IntListQuery query=new IntListQuery(this.getDataSource(), sql);
        List<Integer> roles=execute(query, role);
        if(roles!=null && roles.size()>0){
            return roles.get(0);
        }else{
            roleKey=getNextKey("role_seq");
           insertRole(role, roleKey);
        }
        return roleKey;
    }
    public void insertRole(String role, int roleKey) throws Exception {
        String sql="insert into scge_roles (role_key, role) values (?,?)";
        update(sql, roleKey, role);
    }
    public String getRole(String role) throws Exception {
        String sql="select role from scge_roles where role=?";
        StringListQuery query=new StringListQuery(this.getDataSource(), sql);
        List<String> roles=execute(query, role);
        if(roles!=null && roles.size()>0){
            return roles.get(0);
        }else{
            return "member";
        }
    }
    public int getDefaultGroupId(String defaultGroupName) throws Exception {
        String sql="select group_id from scge_group where group_name=?";
        IntListQuery query=new IntListQuery(this.getDataSource(), sql);
        List<Integer> ids=execute(query, defaultGroupName);
        int id=0;
        if(ids!=null && ids.size()>0){
           id= ids.get(0);
        }else{
            id=getNextKey("group_seq");
            SCGEGroup group=new SCGEGroup();
            group.setGroupName(defaultGroupName);
            group.setGroupId(id);
            group.setGroupShortName("CG");
            gdao.insert(group);
        }
        return id;
    }
    public void insertPersonInfo(int personId, List<Integer> roleIds,int groupId ) throws Exception {
       for(int role:roleIds){
           if(!isPersonInfoExists(personId, groupId)){
               insertPersonInfo(personId, role, groupId);
           }
       }
    }
   public boolean isPersonInfoExists(int personId, int groupId) throws Exception {
      List<Integer> personInfo= getPersonInfo(personId, groupId);
       if(personInfo!=null && personInfo.size()>0){
           return true;
       }else
           return false;
   }

    public List<Integer> getPersonInfo(int personId,  int groupId) throws Exception {
        String sql="select person_id from person_info where person_id=?  and group_id=?";
        IntListQuery query=new IntListQuery(this.getDataSource(), sql);
        return execute(query, personId,  groupId);
    }

    public void insertPersonInfo(int personId, int roleId,int groupId) throws Exception {

            String sql="insert into person_info(person_id, " +
                    "group_id," +
                    "role_key" +
                    ") values(?,?,?)";
            update(sql, personId,  groupId, roleId);


    }

    public void deletePersonInfo(int personId, int groupId) throws Exception {
        String sql="delete from person_info where person_id=? and group_id=?";
        update(sql, personId,  groupId);
    }

    public  List<Person> getPersonRecords(Person p) throws Exception {
        List<Person> members=new ArrayList<>();
        String name=p.getName().replaceAll("[,.]", "");
        for(Person person:   getAllActiveMembers()){
            try {
                String str1 = person.getName().replaceAll("[,.]", "");
                if (name.equalsIgnoreCase(str1) ||
                        p.getEmail().toLowerCase().equalsIgnoreCase(person.getEmail().toLowerCase())) {
                    members.add(person);
                }

            }catch (Exception e){e.printStackTrace();}
        }
        return members;
    }
    public List<Person> getPersonByName(String name) throws Exception{
        String sql="select * from person where name_lc=? " ;
        PersonQuery query=new PersonQuery(this.getDataSource(), sql);
        return execute(query,name);
    }

    public boolean exists(Person p) throws Exception {
        List<Person> members=new ArrayList<>();
        members=getPersonByName(p.getName().toLowerCase().trim());
        if(members==null || members.size()==0){
            members=getPersonRecords(p);

            return members != null && members.size() != 0;
        }

        return true;

    }



    public int insertOrUpdate(Person p) throws Exception {
        int id=0;
        List<Person> members=new ArrayList<>();
        members=getPersonByName(p.getName().toLowerCase().trim());
        if(members==null || members.size()==0){
            members=getPersonRecords(p);

            if (members==null || members.size()==0) {

                id= getNextKey("person_seq");
                p.setId(id);
                try{
                    insert(p);
                }catch (Exception e){
                    e.printStackTrace();
                    return 0;
                }
            }
        }
        if(members!=null && members.size()>0){
            boolean active=false;
            for(Person person: members){
                if(person.getStatus().equalsIgnoreCase("ACTIVE")){
                    active=true;
                    id=person.getId();
                    break;
                }
            }
            if(!active) {
                p.setId(members.get(0).getId());

            }else{
                p.setId(id);

            }
            update(p);
        }

        return id;
    }


    public String getInstitutionName(int id) throws Exception {
        String sql="select institution_name from institution where institution_id=?";
        StringListQuery query= new StringListQuery(this.getDataSource(), sql);
        List<String> names=execute(query, id);
        if(names!=null && names.size()>0){
            return names.get(0);
        }else{
            return "";
        }
    }
    public List<PersonInfo> getPersonInfo(int personId) throws Exception {
            String sql = "select p.person_id, g.group_name,g.group_id, g.group_type, r.role , grnt.grant_title, grnt.grant_initiative,grnt.grant_id " +
            "from scge_group g , person_info i, person p, scge_roles r, scge_grants grnt where p.person_id=i.person_id " +
            "and g.group_id=i.group_id and r.role_key=i.role_key and p.status='ACTIVE' and p.person_id =? and grnt.group_id=g.group_id ";


            PersonInfoQuery q = new PersonInfoQuery(this.getDataSource(), sql);
            return execute(q, personId);

    }
    public Map<String, String> getFirstAndLastName(String name){
        Map<String, String> splitMap=new HashMap<>();
        if(name!=null) {
            if (name.contains(",")) {
                Pattern p = Pattern.compile("[^,]*,(.*)");
                Matcher m = p.matcher(name);
                if (m.find()) {
                    name = name.replace(m.group(1), "").replace(",", "");

                    //      System.out.println(m.group(1)+"\t" +name +"\tLast Name:"+ name.trim().substring(name.trim().lastIndexOf(" ") + 1));
              /* System.out.println("LAST NAME:"+ (name.trim().substring(name.trim().lastIndexOf(" ") + 1))
                        +", First Name:"
                        +name.substring(0,name.trim().lastIndexOf(" "))) ;*/
                   try {
                       splitMap.put("firstName", name.substring(0, name.trim().lastIndexOf(" ")));
                       splitMap.put("lastName", name.trim().substring(name.trim().lastIndexOf(" ") + 1));
                   }catch (Exception e){
                       System.err.println("Name:"+ name);
                       e.printStackTrace();
                   }
                } else {
                    try {
                        splitMap.put("firstName", name.substring(0, name.trim().lastIndexOf(" ")));
                        splitMap.put("lastName", name.trim().substring(name.trim().lastIndexOf(" ") + 1));
                    }catch (Exception e){
                        System.err.println("Name:"+ name);
                        e.printStackTrace();
                    }
                    }
            } else {
                try {
                    splitMap.put("firstName", name.substring(0, name.trim().lastIndexOf(" ")));
                    splitMap.put("lastName", name.trim().substring(name.trim().lastIndexOf(" ") + 1));
                }catch (Exception e){
                    System.err.println("Name:"+ name);
                    e.printStackTrace();
                }

            }
        }
        return splitMap;
    }
    public static void main(String[] args) throws Exception {
        PersonDao personDao=new PersonDao();
        List<Person> personList=personDao.getAllActiveMembers();
       for(Person person:personList){
            String personFullName=person.getName();
            Map<String, String> nameMap=personDao.getFirstAndLastName(personFullName);
            String firstName=nameMap.get("firstName");
            String lastName=nameMap.get("lastName");
            System.out.println("FULLNAME:"+ personFullName+"\tFIRST:"+ nameMap.get("firstName") +"\tLAST:"+ nameMap.get("lastName"));
            person.setFirstName(firstName);
            person.setLastName(lastName);
            personDao.update(person);
      }
       System.out.println("DONE!!");
    }
}
