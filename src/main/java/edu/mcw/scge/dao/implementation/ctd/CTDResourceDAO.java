package edu.mcw.scge.dao.implementation.ctd;

import edu.mcw.scge.dao.AbstractDAO;
import edu.mcw.scge.dao.spring.ctd.CTDResourceQuery;
import edu.mcw.scge.datamodel.ctd.CTDResource;

import java.util.List;

public class CTDResourceDAO extends AbstractDAO {
    public void insert(CTDResource resource) throws Exception {
        String sql="insert into ctd_resources(resource_id, resource_name, resource_url, resource_description, ctd_section, date_issued)" +
                "   values(NEXTVAL('ctd_resource_id_seq'),?,?,?,?,?)";
        update(sql,resource.getResourceName(), resource.getResourceUrl(), resource.getResourceDescription(), resource.getCtdSection(), resource.getDateIssued());
    }
    public List<CTDResource> getResourcesBySection(String sectionCode) throws Exception {
        String sql="select * from ctd_resources where ctd_section=?";
        CTDResourceQuery query=new CTDResourceQuery(this.getDataSource(), sql);
        return execute(query, sectionCode);
    }
}
