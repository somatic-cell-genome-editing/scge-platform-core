package edu.mcw.scge.dao.spring;

import edu.mcw.scge.datamodel.ClinicalTrialExternalLink;
import org.springframework.jdbc.object.MappingSqlQuery;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClinicalTrialExternalLinksQuery extends MappingSqlQuery<ClinicalTrialExternalLink> {
    public ClinicalTrialExternalLinksQuery(DataSource ds, String sql){
        super(ds,sql);
    }
    @Override
    protected ClinicalTrialExternalLink mapRow(ResultSet rs, int rowNum) throws SQLException {
        ClinicalTrialExternalLink link=new ClinicalTrialExternalLink();
        link.setName(rs.getString("link_name"));
        link.setType(rs.getString("link_type"));
        link.setLink(rs.getString("link"));
        link.setNctId(rs.getString("nctid"));
        return link;
    }
}
