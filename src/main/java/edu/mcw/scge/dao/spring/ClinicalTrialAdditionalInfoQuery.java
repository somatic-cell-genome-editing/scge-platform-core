package edu.mcw.scge.dao.spring;

import edu.mcw.scge.datamodel.ClinicalTrialAdditionalInfo;
import org.springframework.jdbc.object.MappingSqlQuery;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClinicalTrialAdditionalInfoQuery extends MappingSqlQuery<ClinicalTrialAdditionalInfo> {
    public ClinicalTrialAdditionalInfoQuery(DataSource ds, String sql){
        super(ds, sql);
    }
    @Override
    protected ClinicalTrialAdditionalInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
        ClinicalTrialAdditionalInfo info=new ClinicalTrialAdditionalInfo();
        info.setNctId(rs.getString("nct_id"));
        info.setPropertyName(rs.getString("property_name"));
        info.setPropertyValue(rs.getString("property_value"));
        return info;
    }
}
