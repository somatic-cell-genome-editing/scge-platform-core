package edu.mcw.scge.dao.spring;

import edu.mcw.scge.datamodel.ClinicalTrialCuratedData;
import org.springframework.jdbc.object.MappingSqlQuery;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClinicalTrialCuratedDataQuery extends MappingSqlQuery<ClinicalTrialCuratedData> {
    public ClinicalTrialCuratedDataQuery(DataSource ds, String sql){
        super(ds, sql);
    }
    @Override
    protected ClinicalTrialCuratedData mapRow(ResultSet rs, int rowNum) throws SQLException {
        ClinicalTrialCuratedData record=new ClinicalTrialCuratedData();
        record.setnCTNumber(rs.getString("nctid"));
        record.setTargetGeneOrVariant(rs.getString("target_gene"));
        record.setTherapyType(rs.getString("therapy_type"));
        record.setTherapyRoute(rs.getString("therapy_route"));
        record.setMechanismOfAction(rs.getString("mechanism_of_action"));
        record.setRouteOfAdministration(rs.getString("route_of_administration"));
        record.setDrugProductType(rs.getString("drug_product_type"));
        record.setTargetTissueOrCell(rs.getString("target_tissue"));
        record.setDeliverySystem(rs.getString("delivery_system"));
        record.setVectorType(rs.getString("vector_type"));
        record.setEditorType(rs.getString("editor_type"));
        record.setDose1(rs.getString("dose_1"));
        record.setDose2(rs.getString("dose_2"));
        record.setDose3(rs.getString("dose_3"));
        record.setDose4(rs.getString("dose_4"));
        record.setDose5(rs.getString("dose_5"));
        record.setRecentUpdates(rs.getString("recent_updates"));
        record.setPatents(rs.getString("patents"));
        return record;
    }
}
