package edu.mcw.scge.dao.spring;

import edu.mcw.scge.datamodel.ClinicalTrialRecord;
import org.springframework.jdbc.object.MappingSqlQuery;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClinicalTrialQuery extends MappingSqlQuery<ClinicalTrialRecord> {

    public ClinicalTrialQuery(DataSource ds, String sql){
        super(ds, sql);
    }
    @Override
    protected ClinicalTrialRecord mapRow(ResultSet rs, int rowNum) throws SQLException {
        ClinicalTrialRecord record=new ClinicalTrialRecord();
       record.setNctId(rs.getString("nctid"));
       record.setDescription(rs.getString("description"));
        record.setInterventionName(rs.getString("intervention_name")) ;
         record.setInterventionDescription(rs.getString("intervention_description"));
        record.setSponsor(rs.getString("sponsor"));
          record.setSponsorClass(rs.getString("sponsor_class"));
        record.setIndication(rs.getString("indication"));
         record.setPhases(rs.getString("phases"));
        record.setEnrorllmentCount(rs.getInt("enrollment_count"));
        record.setLocations(rs.getString("locations"));
        record.setNumberOfLocations(rs.getInt("number_of_locations"));
        record.setEligibilitySex(rs.getString("eligibility_sex"));
        record.setElibilityMinAge(rs.getString("eligibility_min_age"));
        record.setElibilityMaxAge(rs.getString("eligibity_max_age"));

        record.setStandardAges(rs.getString("eligibility_std_age"));
        record.setIsFDARegulated(rs.getString("is_fda_regulated"));
       record.setBriefTitle(rs.getString("brief_title"));
       record.setOfficialTitle(rs.getString("official_title"));
       record.setNihReportLink(rs.getString("nih_report_link"));
       record.setStatus(rs.getString("overall_status"));
       record.setFirstSubmitDate(rs.getString("first_submit_date"));
       record.setEstimatedCompleteDate(rs.getString("estimated_completion_date"));
       record.setLastUpdatePostDate(rs.getString("last_update_post_date"));
        record.setBrowseConditionTerms(rs.getString("browse_condition_terms"));
        /** CURATED FIELDS **/
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
        record.setCompoundName(rs.getString("compound_name"));
            return record;
    }
}
