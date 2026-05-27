package edu.mcw.scge.dao.spring;

import edu.mcw.scge.datamodel.ClinicalTrialFieldOption;
import org.springframework.jdbc.object.MappingSqlQuery;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClinicalTrialFieldOptionQuery extends MappingSqlQuery<ClinicalTrialFieldOption> {
    public ClinicalTrialFieldOptionQuery(DataSource ds, String sql){
        super(ds, sql);
    }
    @Override
    protected ClinicalTrialFieldOption mapRow(ResultSet rs, int rowNum) throws SQLException {
        ClinicalTrialFieldOption fieldOption=new ClinicalTrialFieldOption();
        fieldOption.setActive(rs.getBoolean("is_active"));
        fieldOption.setFieldName(rs.getString("field_name"));
        fieldOption.setValue(rs.getString("value"));
        fieldOption.setDefinition(rs.getString("definition"));
        fieldOption.setId(rs.getInt("id"));
        fieldOption.setCreatedDate(rs.getDate("created_date"));
        fieldOption.setModifiedDate(rs.getDate("modified_date"));
        fieldOption.setDisplayOrder(rs.getInt("display_order"));
        return fieldOption;
    }
}
