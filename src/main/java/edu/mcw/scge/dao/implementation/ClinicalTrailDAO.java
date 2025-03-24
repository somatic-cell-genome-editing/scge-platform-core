package edu.mcw.scge.dao.implementation;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.mcw.scge.dao.AbstractDAO;
import edu.mcw.scge.dao.spring.*;
import edu.mcw.scge.datamodel.Alias;
import edu.mcw.scge.datamodel.ClinicalTrialAdditionalInfo;
import edu.mcw.scge.datamodel.ClinicalTrialExternalLink;
import edu.mcw.scge.datamodel.ClinicalTrialRecord;

import edu.mcw.scge.datamodel.clinicalTrialModel.Intervention;
import edu.mcw.scge.datamodel.clinicalTrialModel.Location;
import edu.mcw.scge.datamodel.clinicalTrialModel.Study;
import org.json.JSONObject;
import org.springframework.web.client.RestTemplate;


import java.util.*;
import java.util.stream.Collectors;

public class ClinicalTrailDAO extends AbstractDAO {
    public void insert(ClinicalTrialRecord record) throws Exception {
        String sql="insert into clinical_trial_record (nctid, " +
                "description," +
                "intervention_name," +
                "intervention_description," +
                "sponsor," +
                "sponsor_class," +
                "phases," +
                "enrollment_count," +
                "locations," +
                "number_of_locations," +
                "eligibility_sex," +
                "eligibility_min_age," +
                "eligibity_max_age," +
                "eligibility_std_age," +
                "is_fda_regulated," +
                "brief_title," +
                "official_title," +
                "nih_report_link," +
                "overall_status," +
                "first_submit_date," +
                "estimated_completion_date," +
                "last_update_post_date," +
                "browse_condition_terms, " +
                "target_gene\n," +
                "therapy_type\n," +
                "therapy_route\n," +
                "mechanism_of_action\n," +
                "route_of_administration\n," +
                "drug_product_type\n," +
                "target_tissue\n," +
                "delivery_system\n," +
                "vector_type\n," +
                "editor_type\n," +
                "dose_1\n," +
                "dose_2\n," +
                "dose_3\n," +
                "dose_4\n," +
                "dose_5\n," +
                "recent_updates, " +
                "patents, " +
                "compound_name, " +
                "indication," +
                "record_creation_date, record_modified_date, " +
                "development_status, " +
                "indication_doid, " +
                "compound_description) " +
                "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?," +
                "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," +
                "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," +
                "NOW()," + "NOW()," +
                "?," + "?," + "?" +
                ")";
        update(sql,record.getNctId(),
                record.getDescription(),
                record.getInterventionName(),
                record.getInterventionDescription(),
                record.getSponsor(),
                record.getSponsorClass(),
                record.getPhase(),
                record.getEnrorllmentCount(),
                record.getLocation(),
                record.getNumberOfLocations(),
                record.getEligibilitySex(),
                record.getElibilityMinAge(),
                record.getElibilityMaxAge(),
                record.getStandardAge(),
                record.getIsFDARegulated(),
                record.getBriefTitle(),
                record.getOfficialTitle(),
                record.getNihReportLink(),
                record.getStudyStatus(),
                record.getFirstSubmitDate(),
                record.getEstimatedCompleteDate(),
                record.getLastUpdatePostDate(),
                record.getBrowseConditionTerms(),
                record.getTargetGeneOrVariant(),
                record.getTherapyType(),
                record.getTherapyRoute(),
                record.getMechanismOfAction(),
                record.getRouteOfAdministration(),
                record.getDrugProductType(),
                record.getTargetTissueOrCell(),
                record.getDeliverySystem(),
                record.getVectorType(),
                record.getEditorType(),
                record.getDose1(),
                record.getDose2(),
                record.getDose3(),
                record.getDose4(),
                record.getDose5(),
                record.getRecentUpdates(),
                record.getPatents(),
                record.getCompoundName(),
                record.getIndication(),
                record.getDevelopmentStatus(),
                record.getIndicationDOID(),
                record.getCompoundDescription()
                );

    }

    public void updateCuratedDataFields(ClinicalTrialRecord record) throws Exception {
        String sql = "update clinical_trial_record set target_gene=?,therapy_type=?,therapy_route=?,mechanism_of_action=?,route_of_administration=?,drug_product_type=?,target_tissue=?,delivery_system=?,vector_type=?,editor_type=?,dose_1=?,dose_2=?,dose_3=?,dose_4=?,dose_5=?,recent_updates=?, patents=?, compound_name=?, indication=?, record_modified_date=NOW() where nctid=? ";
        this.update(sql, record.getTargetGeneOrVariant(), record.getTherapyType(), record.getTherapyRoute(), record.getMechanismOfAction(), record.getRouteOfAdministration(), record.getDrugProductType(), record.getTargetTissueOrCell(), record.getDeliverySystem(), record.getVectorType(), record.getEditorType(), record.getDose1(), record.getDose2(), record.getDose3(), record.getDose4(), record.getDose5(), record.getRecentUpdates(), record.getPatents(), record.getCompoundName(), record.getIndication(),record.getnCTNumber().trim());
    }
    public void updateSomeNewFieldsDataFields(ClinicalTrialRecord record) throws Exception {
        String sql = "update clinical_trial_record " +
                "set development_status=?," +
                "indication_doid=?, compound_name=?, compound_description=?, record_modified_date=NOW() where nctid=? ";
        this.update(sql, record.getDevelopmentStatus(),
                record.getIndicationDOID(),record.getCompoundName(),record.getCompoundDescription(),record.getNctId().trim());
    }
    public void updateAPIDataFields(ClinicalTrialRecord record) throws Exception {
        String sql = "update clinical_trial_record set description=?,intervention_name=?,intervention_description=?,sponsor=?,sponsor_class=?,indication=?,phases=?,enrollment_count=?,locations=?,number_of_locations=?,eligibility_sex=?,eligibility_min_age=?,eligibity_max_age=?,eligibility_std_age=?,is_fda_regulated=?,brief_title=?,official_title=?,nih_report_link=?,overall_status=?,first_submit_date=?,estimated_completion_date=?,last_update_post_date=?,browse_condition_terms=?, record_modified_date=NOW() where nctid=?";
        this.update(sql, record.getDescription(), record.getInterventionName(), record.getInterventionDescription(), record.getSponsor(), record.getSponsorClass(), record.getIndication(), record.getPhase(), record.getEnrorllmentCount(), record.getLocation(), record.getNumberOfLocations(), record.getEligibilitySex(), record.getElibilityMinAge(), record.getElibilityMaxAge(), record.getStandardAge(), record.getIsFDARegulated(), record.getBriefTitle(), record.getOfficialTitle(), record.getNihReportLink(), record.getStudyStatus(), record.getFirstSubmitDate(), record.getEstimatedCompleteDate(), record.getLastUpdatePostDate(), record.getBrowseConditionTerms(),record.getNctId().trim());
    }

   public void insertExternalLink(ClinicalTrialExternalLink link) throws Exception {
        String sql="insert into clinical_trial_ext_links( " +
                "link_name\n," +
                "link_type\n," +
                "link\n," +
                "nctid, " +
                "id" +
                ") values (" +
                "?," +
                "?," +
                "?," +
                "?," +
                "?" +
                ")";
        update(sql, link.getName(), link.getType(), link.getLink(), link.getNctId(),link.getId());
    }

    public void updateExternalLink(ClinicalTrialExternalLink link) throws Exception{
        String sql = "Update clinical_trial_ext_links set link_name=?,link_type=?,link=?,nctid=? where id=?";
        this.update(sql,link.getName(),link.getType(),link.getLink(),link.getNctId(),link.getId());
    }
    public void deleteExternalLink(int linkId) throws Exception{
        String sql = "Delete from clinical_trial_ext_links where id=?";
        this.update(sql,linkId);
    }
    public boolean existsExternalLink(ClinicalTrialExternalLink link) throws Exception {
        String sql="select * from clinical_trial_ext_links where link_name=? and link_type=? and nctid=?";
        ClinicalTrialExternalLinksQuery query=new ClinicalTrialExternalLinksQuery(this.getDataSource(), sql);
        List<ClinicalTrialExternalLink> links=execute(query, link.getName(), link.getType(), link.getNctId());
        return links.size()>0;
    }
    public boolean existsAlias(Alias alias) throws Exception {
        String sql="select * from alias where identifier=? and alias=? ";
        AliasQuery query=new AliasQuery(this.getDataSource(), sql);
        List<Alias> aliases=execute(query, alias.getIdentifier(), alias.getAlias());
        return aliases.size()>0;
    }
    public boolean existsInfo(ClinicalTrialAdditionalInfo info) throws Exception {
        String sql="select * from clinical_trial_additional_info where nct_id=? and property_name=? and property_value=? ";
        ClinicalTrialAdditionalInfoQuery query=new ClinicalTrialAdditionalInfoQuery(this.getDataSource(), sql);
        List<ClinicalTrialAdditionalInfo> additionalInfos=execute(query, info.getNctId(), info.getPropertyName(), info.getPropertyValue());
        return additionalInfos.size()>0;
    }
    public List<ClinicalTrialRecord> getAllClinicalTrailRecords() throws Exception {
        String sql="select * from clinical_trial_record ";
        ClinicalTrialQuery query=new ClinicalTrialQuery(this.getDataSource(), sql);
        return query.execute();
    }

    public List<ClinicalTrialRecord> getClinicalTrailRecordByNctId(String nctId) throws Exception {
        String sql="select * from clinical_trial_record where nctid=?";
        ClinicalTrialQuery query=new ClinicalTrialQuery(this.getDataSource(), sql);
        return execute(query, nctId);
    }

    public ClinicalTrialRecord getSingleClinicalTrailRecordByNctId(String nctId) throws Exception{
        String sql="select * from clinical_trial_record where nctid=?";
        ClinicalTrialQuery query=new ClinicalTrialQuery(this.getDataSource(), sql);
        List<ClinicalTrialRecord> ctRecord = execute(query, nctId);
        return ctRecord.size()>0?ctRecord.get(0):null;
    }
    public List<ClinicalTrialExternalLink> getExtLinksByNctId(String nctId) throws Exception {
        String sql="select * from clinical_trial_ext_links where nctid=?";
        ClinicalTrialExternalLinksQuery query=new ClinicalTrialExternalLinksQuery(this.getDataSource(), sql);
        return execute(query, nctId);
    }

    public List<ClinicalTrialExternalLink> getExtLinksByNctIdSorted(String nctId) throws Exception {
        String sql="select * from clinical_trial_ext_links where nctid=? order by link_type";
        ClinicalTrialExternalLinksQuery query=new ClinicalTrialExternalLinksQuery(this.getDataSource(), sql);
        return execute(query, nctId);
    }

    public String getResponseStr(String fetchUri){
        RestTemplate restTemplate=new RestTemplate();
        return restTemplate.getForObject(fetchUri, String.class);
    }
    public boolean existsRecord(String nctId) throws Exception {
        List<ClinicalTrialRecord> records= getClinicalTrailRecordByNctId(nctId);
        return records.size() > 0;
    }

    public String downloadClinicalTrailByNctId(String nctId) {
        String baseURI = "https://clinicaltrials.gov/api/v2/studies/";
        ObjectMapper mapper = new ObjectMapper();
        String fetchUri = baseURI + nctId;

        try {
            String responseStr = this.getResponseStr(fetchUri);
            if (responseStr != null) {
                JSONObject jsonObject = new JSONObject(responseStr);
                Study study = (Study)mapper.readValue(jsonObject.toString(), Study.class);
                ClinicalTrialRecord record = new ClinicalTrialRecord();
                record.setNctId(nctId.trim());
                record.setDescription(study.getProtocolSection().getDescriptionModule().getBriefSummary());
                StringBuilder interventions = new StringBuilder();
                StringBuilder interventionDescription = new StringBuilder();
                Iterator var11 = study.getProtocolSection().getArmsInterventionsModule().getInterventions().iterator();
                boolean first=true;
                while(var11.hasNext()) {
                    Intervention intervention = (Intervention)var11.next();
                    Map<String, Object> otherProps = intervention.getAdditionalProperties();
                    interventions.append(intervention.getName());
                    if(first) {
                        first=false;
                    }else {
                        interventions.append(", ");
                    }
                    interventionDescription.append(otherProps.get("description"));
                }

                record.setInterventionName(interventions.toString());
                record.setInterventionDescription(interventionDescription.toString());
                record.setSponsor(study.getProtocolSection().getSponsorCollaboratorsModule().getLeadSponsor().getName());
                record.setSponsorClass(study.getProtocolSection().getSponsorCollaboratorsModule().getLeadSponsor().getClass_());
                record.setIndication(String.join(", ", study.getProtocolSection().getConditionsModule().getConditions()));
                ArrayList<String> conditionKeywords = (ArrayList)study.getProtocolSection().getConditionsModule().getAdditionalProperties().get("keywords");
                if (conditionKeywords != null && !conditionKeywords.isEmpty()) {
                    record.setBrowseConditionTerms((String)conditionKeywords.stream().collect(Collectors.joining(", ")));
                }

                record.setPhase(String.join(", ", study.getProtocolSection().getDesignModule().getPhases()));
                record.setEnrorllmentCount(study.getProtocolSection().getDesignModule().getEnrollmentInfo().getCount());
                if (study.getProtocolSection().getContactsLocationsModule() != null) {
                    record.setLocation(String.join(",", (Iterable)study.getProtocolSection().getContactsLocationsModule().getLocations().stream().map(Location::getCountry).collect(Collectors.toSet())));
                    record.setNumberOfLocations(study.getProtocolSection().getContactsLocationsModule().getLocations().size());
                }

                record.setEligibilitySex(study.getProtocolSection().getEligibilityModule().getSex());
                record.setElibilityMinAge(study.getProtocolSection().getEligibilityModule().getMinimumAge());
                record.setElibilityMaxAge(study.getProtocolSection().getEligibilityModule().getMaximumAge());
                record.setHealthyVolunteers(study.getProtocolSection().getEligibilityModule().getHealthyVolunteers().toString());
                record.setStandardAge(String.join(",", study.getProtocolSection().getEligibilityModule().getStdAges()));
                String isFDARegulatedDrug="";
                String isFDARegulatedDevice="";
                if(study.getProtocolSection().getOversightModule().getIsFdaRegulatedDrug()!=null)
                     isFDARegulatedDrug+=String.valueOf(study.getProtocolSection().getOversightModule().getIsFdaRegulatedDrug());
                if(study.getProtocolSection().getOversightModule().getIsFdaRegulatedDevice()!=null)
                    isFDARegulatedDevice+=String.valueOf(study.getProtocolSection().getOversightModule().getIsFdaRegulatedDevice());
                String containsUSLocation=null;
                if(record.getLocation()!=null && record.getLocation().toLowerCase().contains("united states")){
                    containsUSLocation="true";
                }
                String isFDARegulated=null;
                if(isFDARegulatedDrug.equalsIgnoreCase("true") || isFDARegulatedDevice.equalsIgnoreCase("true") || (containsUSLocation!=null)){
                    isFDARegulated="true";
                }else{
                    if(isFDARegulatedDrug.equalsIgnoreCase("false") || isFDARegulatedDevice.equalsIgnoreCase("false"))
                    isFDARegulated="false";
                }
                record.setIsFDARegulated(isFDARegulated);
                record.setBriefTitle(study.getProtocolSection().getIdentificationModule().getBriefTitle());
                record.setOfficialTitle(study.getProtocolSection().getIdentificationModule().getOfficialTitle());
                if (study.getProtocolSection().getIdentificationModule().getAdditionalProperties().get("secondaryIdInfos") != null) {
                    ArrayList object = (ArrayList)study.getProtocolSection().getIdentificationModule().getAdditionalProperties().get("secondaryIdInfos");
                    StringBuilder builder = new StringBuilder();
                    Iterator var14 = object.iterator();

                    while(var14.hasNext()) {
                        Object o = var14.next();
                        String link = (String)((Map)o).get("link");
                        if (link != null) {
                            builder.append(link).append(";");
                        }
                    }

                    record.setNihReportLink(builder.toString());
                }

                record.setStudyStatus(study.getProtocolSection().getStatusModule().getOverallStatus());
                record.setFirstSubmitDate(study.getProtocolSection().getStatusModule().getStudyFirstSubmitDate());
                record.setEstimatedCompleteDate(study.getProtocolSection().getStatusModule().getCompletionDateStruct().getDate());
                record.setLastUpdatePostDate(study.getProtocolSection().getStatusModule().getLastUpdatePostDateStruct().getDate());
                if (!this.existsRecord(record.getNctId())) {
                    this.insert(record);
                    return "inserted";

                } else {
                    this.updateAPIDataFields(record);
                    return "updated";
                }
            }
            return "error_no_response";
        }
        catch (Exception var17) {
            System.out.println("NCTID:" + nctId);
            var17.printStackTrace();
            return "error_" + var17.getClass().getSimpleName();
        }

    }

    public void downloadClinicalTrails(List<String> nctIds) throws Exception {
        if (nctIds.size() > 0) {
            Iterator var2 = nctIds.iterator();

            while(var2.hasNext()) {
                String nctId = (String)var2.next();
                if (nctId != null && !nctId.equals("") && !nctId.equals("null")) {
                    this.downloadClinicalTrailByNctId(nctId);
                }
            }
        }

    }

    public void insertAlias(Alias alias) throws Exception {
        String sql="insert into alias(key, identifier, created_date, notes, alias_type_lc, alias,field_name)" +
                "   values(NEXTVAL('alias_key_seq'),?,NOW(),?,?,?,?)";
        update(sql, alias.getIdentifier(), alias.getNotes(), alias.getAliasTypeLC(), alias.getAlias(), alias.getFieldName());
    }

    public void updateAlias(Alias alias) throws Exception {
        String sql = "update alias set " +
                "identifier=?, " +
                "notes=?, " +
                "alias_type_lc=?, " +
                "alias=?, " +
                "field_name=? " +
                "where key=?";

        update(sql,
                alias.getIdentifier(),
                alias.getNotes(),
                alias.getAliasTypeLC(),
                alias.getAlias(),
                alias.getFieldName(),
                alias.getKey());
    }

    public List<Alias> getAliases(String identifier, String fieldName) throws Exception {
        String sql="select * from alias where identifier=? and field_name=?";
        AliasQuery query=new AliasQuery(this.getDataSource(), sql);
        return execute(query, identifier, fieldName.toLowerCase());
    }

    public void deleteAlias(int key) throws Exception{
        String sql = "Delete from alias where key=?";
        update(sql,key);
    }
    public void insertAdditionalInfo(ClinicalTrialAdditionalInfo info) throws Exception {
        String sql="insert into clinical_trial_additional_info(nct_id, property_name,property_value)" +
                "   values(?,?,?)";
        update(sql, info.getNctId(),info.getPropertyName(),info.getPropertyValue());
    }
    public List<ClinicalTrialAdditionalInfo> getAdditionalInfo(String nctId, String propertyName) throws Exception {
        String sql="select * from clinical_trial_additional_info where nct_id=? and property_name=? order by property_value";
        ClinicalTrialAdditionalInfoQuery query=new ClinicalTrialAdditionalInfoQuery(this.getDataSource(), sql);
        return execute(query, nctId, propertyName.toLowerCase());
    }

    public List<String> getDistinctPropertyValues(String propertyName) throws Exception{
        String sql = "select distinct property_value from clinical_trial_additional_info where property_name=? order by property_value";
        return StringListQuery.execute(this,sql,propertyName);
    }

    public void deleteAdditionalInfo(String nctId, String propertyName, String propertyValue) throws Exception{
        String sql = "delete from clinical_trial_additional_info where nct_id=? and property_name=? and property_value=?";
        update(sql, nctId, propertyName, propertyValue);
    }

}
