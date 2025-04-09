package edu.mcw.scge.dao.spring;

import edu.mcw.scge.datamodel.ClinicalTrialRecord;
import org.apache.commons.lang.StringUtils;
import org.springframework.jdbc.object.MappingSqlQuery;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.stream.Collectors;

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
         record.setPhase(rs.getString("phases"));
        record.setEnrorllmentCount(rs.getInt("enrollment_count"));
        record.setLocation(rs.getString("locations"));
        record.setNumberOfLocations(rs.getInt("number_of_locations"));
        record.setEligibilitySex(rs.getString("eligibility_sex"));
        record.setElibilityMinAge(rs.getString("eligibility_min_age"));
        record.setElibilityMaxAge(rs.getString("eligibity_max_age"));

        record.setStandardAge(rs.getString("eligibility_std_age"));
        record.setIsFDARegulated(rs.getString("is_fda_regulated"));
       record.setBriefTitle(rs.getString("brief_title"));
       record.setOfficialTitle(rs.getString("official_title"));
       record.setNihReportLink(rs.getString("nih_report_link"));
       record.setStudyStatus(rs.getString("overall_status"));
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
        record.setDevelopmentStatus(rs.getString("development_status"));
        record.setIndicationDOID(rs.getString("indication_doid"));
        record.setCompoundDescription(rs.getString("compound_description"));
        try {
            if(rs.getString("with_has_results")!=null)
            record.setWithHasResults(rs.getString("with_has_results"));
            else  record.setWithHasResults("");
        }catch (Exception exception){}
            return formatRecordValue(record);
    }
    public ClinicalTrialRecord formatRecordValue(ClinicalTrialRecord record){
        try {
            record.setTargetGeneOrVariant(StringUtils.capitalize(record.getTargetGeneOrVariant()));
        }catch (Exception e){}
        try {
            record.setCompoundName(StringUtils.capitalize(record.getCompoundName()));
        }catch (Exception e){}
        try {
            record.setTherapyType(StringUtils.capitalize(record.getTherapyType()));
        }catch (Exception e){}
        try {
            record.setTherapyRoute(StringUtils.capitalize(record.getTherapyRoute()));
        }catch(Exception e){}
        try {
            record.setMechanismOfAction(StringUtils.capitalize(record.getMechanismOfAction()));
        }catch (Exception e){}
        try {
            record.setRouteOfAdministration(StringUtils.capitalize(record.getRouteOfAdministration()));
        }catch (Exception e){}
        try {
            record.setDrugProductType(StringUtils.capitalize(record.getDrugProductType()));
        }catch (Exception e){}
        try {
            record.setTargetTissueOrCell(StringUtils.capitalize(record.getTargetTissueOrCell()));
        }catch (Exception e){}
        try {
            record.setDeliverySystem(StringUtils.capitalize(record.getDeliverySystem()));
        }catch (Exception e){}
        try {
            if(!record.getDose1().equalsIgnoreCase("none"))
                record.setDose1(StringUtils.capitalize(record.getDose1()));
            else record.setDose1("");
        }catch (Exception e){}
        try {
            if(!record.getDose2().equalsIgnoreCase("none"))
                record.setDose2(StringUtils.capitalize(record.getDose2()));
            else record.setDose2("");
        }catch (Exception e){}
        try {
            if(!record.getDose3().equalsIgnoreCase("none"))
                record.setDose3(StringUtils.capitalize(record.getDose3()));
            else record.setDose3("");
        }catch (Exception e){}
        try {
            if(!record.getDose4().equalsIgnoreCase("none"))
                record.setDose4(StringUtils.capitalize(record.getDose4()));
            else record.setDose4("");
        }catch (Exception e){}
        try {
            if(!record.getDose5().equalsIgnoreCase("none"))
                record.setDose5(StringUtils.capitalize(record.getDose5()));
            else record.setDose5("");
        }catch (Exception e){}

        try {
            if(record.getIsFDARegulated()!=null && !record.getIsFDARegulated().equalsIgnoreCase("null"))
                record.setIsFDARegulated(StringUtils.capitalize(record.getIsFDARegulated()));
            else record.setIsFDARegulated("");
        }catch (Exception e){}
        try {
            if(record.getRecentUpdates()!=null && !record.getRecentUpdates().equalsIgnoreCase("null"))
                record.setRecentUpdates(StringUtils.capitalize(record.getRecentUpdates()));

        }catch (Exception e){}

        if(!record.getStudyStatus().equals("")) record.setStudyStatus(formatFieldVal(record.getStudyStatus()));
        if(!record.getSponsorClass().equals("") && !record.getSponsorClass().equalsIgnoreCase("NIH")) record.setSponsorClass(formatFieldVal(record.getSponsorClass()));
        if(!record.getPhase().equals("")) record.setPhase(formatFieldVal(record.getPhase()));
        if(!record.getStandardAge().equals("")) record.setStandardAge(formatFieldVal(record.getStandardAge()));
        if(!record.getWithHasResults().equals("")) record.setWithHasResults(formatFieldVal(record.getWithHasResults()));
    return record;
    }

    public String formatFieldVal(String fieldVal){
        return  Arrays.stream(fieldVal.split(",")).map(str->StringUtils.capitalize(str.toLowerCase().trim().replaceAll("_", " "))).collect(Collectors.joining(", "));
    }
}
