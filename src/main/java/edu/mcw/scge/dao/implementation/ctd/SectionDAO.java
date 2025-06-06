package edu.mcw.scge.dao.implementation.ctd;

import edu.mcw.scge.dao.spring.ctd.SectionQuery;
import edu.mcw.scge.datamodel.ctd.Section;
import edu.mcw.scge.dao.AbstractDAO;
import edu.mcw.scge.dao.spring.StringListQuery;
import edu.mcw.scge.datamodel.ctd.Module;

import java.util.List;

public class SectionDAO extends AbstractDAO {

    public void insert(Section section) throws Exception {
        String sql="insert into ctd_sections(section_id," +
                "section_code," +
                "section_name," +
                "parent_id," +
                "module," +
                "level)" +
                " values(?,?,?,?,?,?)";
        update(sql,
                section.getSectionId(), section.getSectionCode(), section.getSectionName(), section.getParentId(), section.getModuleCode(),section.getLevel()
        );

    }
    public List<Module> getAllCTDModules(){
        return null;
    }
    public Module getModule(int moduleCode){
        return null;
    }
    public String getModuleDescription(int moduleCode) throws Exception {
        String sql="select description from ctd_modules where module_id=?";
        StringListQuery query=new StringListQuery(this.getDataSource(), sql);
        List<String> results=execute(query, moduleCode);
        return results.size()>0?results.get(0):null;
    }
    public List<Section> getTopLevelSectionsOfAllModules(){
        return null;
    }
    public List<Section> getTopLevelSectionsOfModule(int moduleCode) throws Exception {
        String sql="select * from ctd_sections where module=? and level=?";
        SectionQuery query=new SectionQuery(this.getDataSource(), sql);
        return execute(query, moduleCode, 1);
    }


//    public List<Section> getLevel2SectionsOfModule(int moduleCode) throws Exception {
//        String sql="select * from ctd_sections where module=? and level=?";
//        SectionQuery query=new SectionQuery(this.getDataSource(), sql);
//        return execute(query, moduleCode, 2);
//    }
//    public List<Section> getLevel3SectionsOfModule(int moduleCode) throws Exception {
//        String sql="select * from ctd_sections where module=? and level=?";
//        SectionQuery query=new SectionQuery(this.getDataSource(), sql);
//        return execute(query, moduleCode, 3);
//    }
//    public List<Section> getLevel4SectionsOfModule(int moduleCode) throws Exception {
//        String sql="select * from ctd_sections where module=? and level=?";
//        SectionQuery query=new SectionQuery(this.getDataSource(), sql);
//        return execute(query, moduleCode, 4);
//    }
public List<Section> getSectionsOfModuleByLevel(int moduleCode, int level) throws Exception {
    String sql="select * from ctd_sections where module=? and level=? order by section_code";
    SectionQuery query=new SectionQuery(this.getDataSource(), sql);
    List<Section> sections=execute(query, moduleCode, level);
    return sort(sections);
}
    public List<Section> sort(List<Section> sections){
        sections.sort((s1,s2)->{
            String[] parts1=s1.getSectionCode().split("\\.");
            String[] parts2=s2.getSectionCode().split("\\.");
            int len=Math.max(parts1.length, parts2.length);
            for(int i=0;i<len;i++){
                try {
                    int num1 = i < parts1.length ? Integer.parseInt(parts1[i]) : 0;
                    int num2 = i < parts2.length ? Integer.parseInt(parts2[i]) : 0;
                    if (num1 != num2) {
                        return Integer.compare(num1, num2);
                    }
                }catch (Exception ignored){

                }
            }
            return 0;
        });
        return sections;
    }
}
