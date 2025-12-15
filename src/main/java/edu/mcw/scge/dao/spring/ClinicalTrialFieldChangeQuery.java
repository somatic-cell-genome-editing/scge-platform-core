package edu.mcw.scge.dao.spring;

import edu.mcw.scge.datamodel.ClinicalTrialFieldChange;
import org.springframework.jdbc.object.MappingSqlQuery;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClinicalTrialFieldChangeQuery extends MappingSqlQuery<ClinicalTrialFieldChange> {

    public ClinicalTrialFieldChangeQuery(DataSource ds, String sql) {
        super(ds, sql);
    }

    @Override
    protected ClinicalTrialFieldChange mapRow(ResultSet rs, int rowNum) throws SQLException {
        ClinicalTrialFieldChange change = new ClinicalTrialFieldChange();
        change.setId(rs.getInt("id"));
        change.setNctId(rs.getString("nct_id"));
        change.setFieldName(rs.getString("field_name"));
        change.setOldValue(rs.getString("old_value"));
        change.setNewValue(rs.getString("new_value"));
        change.setChangedAt(rs.getTimestamp("changed_at"));
        change.setUpdateDate(rs.getString("update_date"));
        change.setUpdateBy(rs.getString("update_by"));
        int extLinkId = rs.getInt("ext_link_id");
        if (!rs.wasNull()) {
            change.setExtLinkId(extLinkId);
        }
        return change;
    }
}
