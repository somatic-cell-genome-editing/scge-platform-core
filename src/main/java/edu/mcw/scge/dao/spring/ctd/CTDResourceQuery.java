package edu.mcw.scge.dao.spring.ctd;

import edu.mcw.scge.datamodel.ctd.CTDResource;
import org.springframework.jdbc.object.MappingSqlQuery;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CTDResourceQuery extends MappingSqlQuery<CTDResource> {
    public CTDResourceQuery(DataSource ds, String query){
        super(ds,query);
    }
    @Override
    protected CTDResource mapRow(ResultSet rs, int rowNum) throws SQLException {
        CTDResource resource=new CTDResource();
        resource.setResourceDescription(rs.getString("resource_description"));
        resource.setResourceId(rs.getInt("resource_id"));
        resource.setResourceName(rs.getString("resource_name"));
        resource.setResourceUrl(rs.getString("resource_url"));
        resource.setCtdSection(rs.getString("ctd_section"));
        resource.setDateIssued(rs.getString("date_issued"));

        return resource;
    }
}
