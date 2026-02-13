package edu.mcw.scge.dao.implementation.ctd;

import edu.mcw.scge.dao.AbstractDAO;
import edu.mcw.scge.dao.spring.ctd.CTDResourceQuery;
import edu.mcw.scge.datamodel.ctd.CTDResource;

import java.util.List;

public class CTDResourceDAO extends AbstractDAO {
    public void insert(CTDResource resource) throws Exception {
        String sql="insert into ctd_resources(resource_id, resource_name, resource_url, resource_description, ctd_section, date_issued,source, type, file_path)" +
                "   values(NEXTVAL('ctd_resource_id_seq'),?,?,?,?,?,?,?,?)";
        update(sql,resource.getResourceName(), resource.getResourceUrl(), resource.getResourceDescription(), resource.getCtdSection(), resource.getDateIssued()
        ,resource.getSource(), resource.getType(),resource.getFilePath());
    }
    public void update(CTDResource resource) throws Exception {
        String sql="update ctd_resources set " +
                "resource_name=?, " +
                "resource_url=?, " +
                "resource_description=?, " +
                "date_issued=?," +
                "source=?, " +
                "type=?, " +
                "file_path=?" +
                "where ctd_section=?   ";
        update(sql,resource.getResourceName(), resource.getResourceUrl(), resource.getResourceDescription(),  resource.getDateIssued()
                ,resource.getSource(), resource.getType(),resource.getFilePath(),resource.getCtdSection());
    }
    public List<CTDResource> getResourcesBySection(String sectionCode) throws Exception {
        String sql="select * from ctd_resources where ctd_section=?";
        CTDResourceQuery query=new CTDResourceQuery(this.getDataSource(), sql);
        return execute(query, sectionCode);
    }
    public List<CTDResource> getAllResources() throws Exception {
        String sql = "SELECT * FROM ctd_resources ORDER BY ctd_section, type, resource_name";
        CTDResourceQuery query = new CTDResourceQuery(this.getDataSource(), sql);
        return execute(query);
    }
    public List<CTDResource> getCTDResource(CTDResource resource) throws Exception {
        String sql="select * from ctd_resources where ctd_section=?" +
                "   and resource_name=? " +
                "   and resource_url=? " +
                "   and resource_description=? " +
                "   and date_issued=?" +
                "   and source=? " +
                "   and type=? " +
                "   and file_path=?" ;
        CTDResourceQuery query=new CTDResourceQuery(this.getDataSource(), sql);
        return execute(query,resource.getCtdSection() ,resource.getResourceName(), resource.getResourceUrl(), resource.getResourceDescription(),  resource.getDateIssued()
                ,resource.getSource(), resource.getType(),resource.getFilePath());
    }
}
