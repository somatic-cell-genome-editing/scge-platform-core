package edu.mcw.scge.platform.dao.spring;

import edu.mcw.scge.platform.dao.implementation.PersonDao;
import edu.mcw.scge.platform.datamodel.Person;
import org.springframework.jdbc.object.MappingSqlQuery;


import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by jthota on 8/20/2019.
 */
public class PersonQuery extends MappingSqlQuery<Person> {
    PersonDao pdao=new PersonDao();
    public PersonQuery(DataSource ds, String query){

        super(ds,query);
    }
    @Override
    protected Person mapRow(ResultSet rs, int rowNum) throws SQLException {
     //   int institution_id=rs.getInt("institution_id");

       return new Person.Builder().
       id(rs.getInt("person_id"))
        .name(rs.getString("name"))
               .firstName(rs.getString("first_name"))
               .lastName(rs.getString("last_name"))
      //         .institution(institution_id)
      //  .institutionName(getInstitution(institution_id))
        .email(rs.getString("email"))
               .email_lc(rs.getString("email_lc"))
        .otherId(rs.getString("other_id"))
        .googleSub(rs.getString("google_id"))
        .address(rs.getString("address"))
        .phone(rs.getString("phone"))
      //  .grantId(rs.getInt("grant_id"))
        .createdDate(rs.getString("created_date"))
        .modifiedBy(rs.getString("modified_by"))
        .status(rs.getString("status"))
        .modifiedDate(rs.getString("modified_date")).build();
    }

}
