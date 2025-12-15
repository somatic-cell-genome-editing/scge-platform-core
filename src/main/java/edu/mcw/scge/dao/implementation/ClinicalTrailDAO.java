package edu.mcw.scge.dao.implementation;


import com.fasterxml.jackson.databind.ObjectMapper;
import edu.mcw.scge.dao.AbstractDAO;
import edu.mcw.scge.dao.spring.*;
import edu.mcw.scge.datamodel.Alias;
import edu.mcw.scge.datamodel.ClinicalTrialAdditionalInfo;
import edu.mcw.scge.datamodel.ClinicalTrialExternalLink;
import edu.mcw.scge.datamodel.ClinicalTrialFieldChange;
import edu.mcw.scge.datamodel.ClinicalTrialRecord;

import edu.mcw.scge.datamodel.clinicalTrialModel.Intervention;
import edu.mcw.scge.datamodel.clinicalTrialModel.Location;
import edu.mcw.scge.datamodel.clinicalTrialModel.Study;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;

import org.springframework.web.client.RestTemplate;


import javax.sql.DataSource;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class ClinicalTrailDAO extends AbstractDAO {
    public Logger logger= LogManager.getLogger("clinicalTrials");
    private DataSource customDataSource = null;

    public ClinicalTrailDAO() {
        super();
    }

    // Constructor with custom datasource
    public ClinicalTrailDAO(DataSource dataSource) {
        this.customDataSource = dataSource;
    }

    @Override
    public DataSource getDataSource() throws Exception {
        return customDataSource != null ? customDataSource : super.getDataSource();
    }

    public void insert(ClinicalTrialRecord record) throws Exception {
        String sql="insert into clinical_trial_record (nctid, " +
                "description," +
                "intervention_name," +
                "intervention_description," +
                "sponsor," +
                "sponsor_class," +
                "phases," +
                "enrollment_count," +
                "enrollment_type," +
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
                "compound_description, " +
                "with_has_results, " +
                "record_status)"+
                "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?," +
                "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," +
                "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," +"?," +
                "NOW()," + "NOW()," +
                "?," + "?," + "?, ?," +"?"+
                ")";
        update(sql,record.getNctId(),
                record.getDescription(),
                record.getInterventionName(),
                record.getInterventionDescription(),
                record.getSponsor(),
                record.getSponsorClass(),
                record.getPhase(),
                record.getEnrorllmentCount(),
                record.getEnrollmentType(),
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
                record.getCompoundDescription(),
                record.getWithHasResults(),
                record.getRecordStatus()
                );

    }

    public void updateCuratedDataFields(ClinicalTrialRecord record) throws Exception {
        // Track changes before updating
        String nctId = record.getnCTNumber() != null ? record.getnCTNumber().trim() : record.getNctId().trim();
        ClinicalTrialRecord existingRecord = getSingleClinicalTrailRecordByNctId(nctId);

        if (existingRecord != null) {
            List<ClinicalTrialFieldChange> changes = compareCuratedFields(existingRecord, record, "curator");
            if (!changes.isEmpty()) {
                insertFieldChanges(changes);
            }
        }

        // Perform the update
        String sql = "update clinical_trial_record set target_gene=?,therapy_type=?,therapy_route=?,mechanism_of_action=?,route_of_administration=?,drug_product_type=?,target_tissue=?,delivery_system=?,vector_type=?,editor_type=?,dose_1=?,dose_2=?,dose_3=?,dose_4=?,dose_5=?,recent_updates=?, patents=?, compound_name=?, indication=?, record_modified_date=NOW(), record_status=? where nctid=? ";
        this.update(sql, record.getTargetGeneOrVariant(), record.getTherapyType(), record.getTherapyRoute(), record.getMechanismOfAction(), record.getRouteOfAdministration(), record.getDrugProductType(), record.getTargetTissueOrCell(), record.getDeliverySystem(), record.getVectorType(), record.getEditorType(), record.getDose1(), record.getDose2(), record.getDose3(), record.getDose4(), record.getDose5(), record.getRecentUpdates(), record.getPatents(), record.getCompoundName(), record.getIndication(),record.getRecordStatus(),nctId);
    }


    public void updateAPIDataFields(ClinicalTrialRecord record) throws Exception {
        String sql = "update clinical_trial_record set description=?,intervention_name=?,intervention_description=?,sponsor=?,sponsor_class=?,phases=?,enrollment_count=?,enrollment_type=?,locations=?,number_of_locations=?,eligibility_sex=?,eligibility_min_age=?,eligibity_max_age=?,eligibility_std_age=?,is_fda_regulated=?,brief_title=?,official_title=?,nih_report_link=?,overall_status=?,first_submit_date=?,estimated_completion_date=?,last_update_post_date=?,browse_condition_terms=?, record_modified_date=NOW(), with_has_results=? where nctid=?";
        this.update(sql, record.getDescription(), record.getInterventionName(), record.getInterventionDescription(), record.getSponsor(), record.getSponsorClass(),  record.getPhase(), record.getEnrorllmentCount(),record.getEnrollmentType(), record.getLocation(), record.getNumberOfLocations(), record.getEligibilitySex(), record.getElibilityMinAge(), record.getElibilityMaxAge(), record.getStandardAge(), record.getIsFDARegulated(), record.getBriefTitle(), record.getOfficialTitle(), record.getNihReportLink(), record.getStudyStatus(), record.getFirstSubmitDate(), record.getEstimatedCompleteDate(), record.getLastUpdatePostDate(), record.getBrowseConditionTerms(), record.getWithHasResults(),record.getNctId().trim());
    }
    public void updateSomeNewFieldsDataFields(ClinicalTrialRecord record) throws Exception {
        String sql = "update clinical_trial_record " +
                "set development_status=?," +
                "indication_doid=?, compound_name=?, compound_description=?, record_modified_date=NOW() where nctid=? ";
        this.update(sql, record.getDevelopmentStatus(),
                record.getIndicationDOID(),record.getCompoundName(),record.getCompoundDescription(),record.getNctId().trim());
    }
   public void insertExternalLink(ClinicalTrialExternalLink link) throws Exception {
        String today = java.time.LocalDate.now().toString();
        String fieldName = "ext_link_" + link.getId();
        String newValue = link.getType() + " | " + link.getName() + " | " + link.getLink();
        ClinicalTrialFieldChange change = new ClinicalTrialFieldChange(link.getNctId(), fieldName, null, newValue, "curator");
        change.setUpdateDate(today);
        List<ClinicalTrialFieldChange> changes = new ArrayList<>();
        changes.add(change);
        insertFieldChanges(changes);

        // Perform the insert
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
        // Track changes before updating
        ClinicalTrialExternalLink existingLink = getExternalLinkById(link.getId());
        if (existingLink != null) {
            String today = java.time.LocalDate.now().toString();
            String fieldName = "ext_link_" + link.getId();
            String oldValue = existingLink.getType() + " | " + existingLink.getName() + " | " + existingLink.getLink();
            String newValue = link.getType() + " | " + link.getName() + " | " + link.getLink();

            if (!oldValue.equals(newValue)) {
                ClinicalTrialFieldChange change = new ClinicalTrialFieldChange(link.getNctId(), fieldName, oldValue, newValue, "curator");
                change.setUpdateDate(today);
                List<ClinicalTrialFieldChange> changes = new ArrayList<>();
                changes.add(change);
                insertFieldChanges(changes);
            }
        }

        // Perform the update
        String sql = "Update clinical_trial_ext_links set link_name=?,link_type=?,link=?,nctid=? where id=?";
        this.update(sql,link.getName(),link.getType(),link.getLink(),link.getNctId(),link.getId());
    }
    public void deleteExternalLink(int linkId) throws Exception{
        // Track deletion before deleting (new_value = null)
        ClinicalTrialExternalLink existingLink = getExternalLinkById(linkId);
        if (existingLink != null) {
            String today = java.time.LocalDate.now().toString();
            String fieldName = "ext_link_" + linkId;
            String oldValue = existingLink.getType() + " | " + existingLink.getName() + " | " + existingLink.getLink();
            ClinicalTrialFieldChange change = new ClinicalTrialFieldChange(existingLink.getNctId(), fieldName, oldValue, null, "curator");
            change.setUpdateDate(today);
            List<ClinicalTrialFieldChange> changes = new ArrayList<>();
            changes.add(change);
            insertFieldChanges(changes);
        }

        // Perform the delete
        String sql = "Delete from clinical_trial_ext_links where id=?";
        this.update(sql,linkId);
    }

    public ClinicalTrialExternalLink getExternalLinkById(int id) throws Exception {
        String sql = "select * from clinical_trial_ext_links where id=?";
        ClinicalTrialExternalLinksQuery query = new ClinicalTrialExternalLinksQuery(this.getDataSource(), sql);
        List<ClinicalTrialExternalLink> links = execute(query, id);
        return links.isEmpty() ? null : links.get(0);
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
    public List<ClinicalTrialRecord> getTodayModifiedRecords() throws Exception {
        String sql= """
                SELECT *
                FROM clinical_trial_record
                WHERE record_modified_date > record_creation_date
                  AND record_modified_date = CURRENT_DATE;
                """;
        ClinicalTrialQuery query=new ClinicalTrialQuery(this.getDataSource(), sql);
        return query.execute();
    }
    public List<String> getClinicalTrialLogMessages() throws Exception {
        String sql= """
                SELECT message
                FROM clinical_trial_log_events
                WHERE timestamp::date = CURRENT_DATE and level='INFO'
                """;
        StringListQuery query=new StringListQuery(this.getDataSource(), sql);
                return query.execute();
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

        String fetchUri = baseURI + nctId;

        try {
            String responseStr = this.getResponseStr(fetchUri);
            if (responseStr != null) {
                JSONObject jsonObject = new JSONObject(responseStr);
               return insertClinicalTrialAPIObject(jsonObject.toString(), nctId, "curator");
            }
            return "error_no_response";
        }
        catch (Exception var17) {
            logger.error("NCTID:" + nctId);
            var17.printStackTrace();
            return "error_" + var17.getClass().getSimpleName();
        }

    }
    public String insertClinicalTrialAPIObject(String clinicalTrialAPIObject, String nctId, String updateBy) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        Study study = (Study)mapper.readValue(clinicalTrialAPIObject, Study.class);
        ClinicalTrialRecord record = new ClinicalTrialRecord();
        record.setNctId(nctId.trim());
        try {
            record.setDescription(study.getProtocolSection().getDescriptionModule().getBriefSummary());
        }catch (Exception ignored){}
        StringBuilder interventions = new StringBuilder();
        StringBuilder interventionDescription = new StringBuilder();
        try {
            Iterator var11 = study.getProtocolSection().getArmsInterventionsModule().getInterventions().iterator();
            boolean first = true;
            while (var11.hasNext()) {
                Intervention intervention = (Intervention) var11.next();
                Map<String, Object> otherProps = intervention.getAdditionalProperties();

                if (first) {
                    first = false;
                } else {
                    interventions.append(", ");
                }
                interventions.append(intervention.getName());
                interventionDescription.append(otherProps.get("description"));
            }
        }catch (Exception ignored){}
        record.setInterventionName(interventions.toString());
        record.setInterventionDescription(interventionDescription.toString());
        try {
            record.setSponsor(study.getProtocolSection().getSponsorCollaboratorsModule().getLeadSponsor().getName());
        }catch (Exception ignored){}
        try {
            record.setSponsorClass(study.getProtocolSection().getSponsorCollaboratorsModule().getLeadSponsor().getClass_());
        }catch (Exception ignored){}
        try {
            record.setIndication(String.join(", ", study.getProtocolSection().getConditionsModule().getConditions()));
        }catch (Exception ignored){}
        try {
            ArrayList<String> conditionKeywords = (ArrayList) study.getProtocolSection().getConditionsModule().getAdditionalProperties().get("keywords");
            if (conditionKeywords != null && !conditionKeywords.isEmpty()) {
                record.setBrowseConditionTerms((String) conditionKeywords.stream().collect(Collectors.joining(", ")));
            }
        }catch (Exception ignored){}
        try {
            record.setPhase(String.join(", ", study.getProtocolSection().getDesignModule().getPhases()));
        }catch (Exception ignored){}
        try {
            record.setEnrorllmentCount(study.getProtocolSection().getDesignModule().getEnrollmentInfo().getCount());
        }catch (Exception ignored){}
        try {
            record.setEnrollmentType(study.getProtocolSection().getDesignModule().getEnrollmentInfo().getType());
        }catch (Exception ignored){}
        try {
            if (study.getProtocolSection().getContactsLocationsModule() != null) {
                record.setLocation(String.join(",", (Iterable) study.getProtocolSection().getContactsLocationsModule().getLocations().stream().map(Location::getCountry).collect(Collectors.toSet())));
                record.setNumberOfLocations(study.getProtocolSection().getContactsLocationsModule().getLocations().size());
            }
        }catch (Exception ignored){}
        try {
            record.setEligibilitySex(study.getProtocolSection().getEligibilityModule().getSex());
        }catch (Exception ignored){}
        try {
            record.setElibilityMinAge(study.getProtocolSection().getEligibilityModule().getMinimumAge());
        }catch (Exception ignored){}
        try {
            record.setElibilityMaxAge(study.getProtocolSection().getEligibilityModule().getMaximumAge());
        }catch (Exception ignored){}
        try {
            record.setHealthyVolunteers(study.getProtocolSection().getEligibilityModule().getHealthyVolunteers().toString());
        }catch (Exception ignored){}
        try {
            record.setStandardAge(String.join(",", study.getProtocolSection().getEligibilityModule().getStdAges()));
        }catch (Exception ignored){}
        String isFDARegulatedDrug="";
        String isFDARegulatedDevice="";
        try {
            if (study.getProtocolSection().getOversightModule() != null && study.getProtocolSection().getOversightModule().getIsFdaRegulatedDrug() != null)
                isFDARegulatedDrug += String.valueOf(study.getProtocolSection().getOversightModule().getIsFdaRegulatedDrug());
        }catch (Exception ignored){}
        try {
            if (study.getProtocolSection().getOversightModule() != null && study.getProtocolSection().getOversightModule().getIsFdaRegulatedDevice() != null)
                isFDARegulatedDevice += String.valueOf(study.getProtocolSection().getOversightModule().getIsFdaRegulatedDevice());
        }catch (Exception ignored){}
        String containsUSLocation = null;
        try {

            if (record.getLocation() != null && record.getLocation().toLowerCase().contains("united states")) {
                containsUSLocation = "true";
            }
        }catch (Exception ignored){}
        try {
            String isFDARegulated = null;
            if (isFDARegulatedDrug.equalsIgnoreCase("true") || isFDARegulatedDevice.equalsIgnoreCase("true") || (containsUSLocation != null)) {
                isFDARegulated = "true";
            } else {
                if (isFDARegulatedDrug.equalsIgnoreCase("false") || isFDARegulatedDevice.equalsIgnoreCase("false"))
                    isFDARegulated = "false";
            }
            record.setIsFDARegulated(isFDARegulated);
        }catch (Exception ignored){}
        if(study.getProtocolSection().getIdentificationModule()!=null) {
            try {
                record.setBriefTitle(study.getProtocolSection().getIdentificationModule().getBriefTitle());
            } catch (Exception ignored) {
            }
            try {
                record.setOfficialTitle(study.getProtocolSection().getIdentificationModule().getOfficialTitle());
            } catch (Exception ignored) {
            }
            try {
                if (study.getProtocolSection().getIdentificationModule().getAdditionalProperties() != null && study.getProtocolSection().getIdentificationModule().getAdditionalProperties().get("secondaryIdInfos") != null) {
                    ArrayList object = (ArrayList) study.getProtocolSection().getIdentificationModule().getAdditionalProperties().get("secondaryIdInfos");
                    StringBuilder builder = new StringBuilder();
                    Iterator var14 = object.iterator();

                    while (var14.hasNext()) {
                        Object o = var14.next();
                        String link = (String) ((Map) o).get("link");
                        if (link != null) {
                            builder.append(link).append(";");
                        }
                    }

                    record.setNihReportLink(builder.toString());
                }
            }catch (Exception ignored){}
        }
        if(study.getProtocolSection().getStatusModule()!=null) {
            try {
                record.setStudyStatus(study.getProtocolSection().getStatusModule().getOverallStatus());
            }catch (Exception ignored){}
            try {
                record.setFirstSubmitDate(study.getProtocolSection().getStatusModule().getStudyFirstSubmitDate());
            }catch (Exception ignored){}
            try {
                record.setEstimatedCompleteDate(study.getProtocolSection().getStatusModule().getCompletionDateStruct().getDate());
            }catch (Exception ignored){}
            try {
                record.setLastUpdatePostDate(study.getProtocolSection().getStatusModule().getLastUpdatePostDateStruct().getDate());
            }catch (Exception ignored){}
        }
        try {
            record.setWithHasResults(String.valueOf(study.getHasResults()));
        }catch (Exception ignored){}
        ClinicalTrialRecord formattedRecord=record.formatRecordValue(record);
        if (!this.existsRecord(record.getNctId())) {
            formattedRecord.setRecordStatus("Provisional");
            this.insert(formattedRecord);
            return "inserted";

        } else {
        this.updateAPIFieldsWithTracking(formattedRecord, updateBy);
            return "updated";

        }
    }
    public List<ClinicalTrialFieldChange> getClinicalTrialFieldChangeRecord(ClinicalTrialFieldChange fieldRecord) throws Exception {
        String sql="select * from clinical_trial_field_history where nct_id=? and field_name=?";
        ClinicalTrialFieldChangeQuery query=new ClinicalTrialFieldChangeQuery(this.getDataSource(), sql);
        return execute(query, fieldRecord.getNctId(), fieldRecord.getFieldName());

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
        // Track new alias (old_value = null)
        List<ClinicalTrialFieldChange> changes = compareAliasFields(null, alias, "curator");
        if (!changes.isEmpty()) {
            insertFieldChanges(changes);
        }

        // Perform the insert
        String sql="insert into alias(key, identifier, created_date, notes, alias_type_lc, alias,field_name)" +
                "   values(NEXTVAL('alias_key_seq'),?,NOW(),?,?,?,?)";
        update(sql, alias.getIdentifier(), alias.getNotes(), alias.getAliasTypeLC(), alias.getAlias(), alias.getFieldName());
    }

    public void updateAlias(Alias alias) throws Exception {
        // Track changes before updating
        Alias existingAlias = getAliasByKey(alias.getKey());
        if (existingAlias != null) {
            List<ClinicalTrialFieldChange> changes = compareAliasFields(existingAlias, alias, "curator");
            if (!changes.isEmpty()) {
                insertFieldChanges(changes);
            }
        }

        // Perform the update
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

    public Alias getAliasByKey(int key) throws Exception {
        String sql = "select * from alias where key=?";
        AliasQuery query = new AliasQuery(this.getDataSource(), sql);
        List<Alias> aliases = execute(query, key);
        return aliases.isEmpty() ? null : aliases.get(0);
    }

    public void deleteAlias(int key) throws Exception{
        // Track deletion before deleting (new_value = null)
        Alias existingAlias = getAliasByKey(key);
        if (existingAlias != null) {
            List<ClinicalTrialFieldChange> changes = compareAliasFields(existingAlias, null, "curator");
            if (!changes.isEmpty()) {
                insertFieldChanges(changes);
            }
        }

        // Perform the delete
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

    public List<String>getAllNctIds() throws Exception{
        String sql = """
                select nctid from clinical_trial_record
                """;
        return StringListQuery.execute(this,sql);
    }

    // ==========================================
    // FIELD CHANGE TRACKING METHODS
    // ==========================================

    /**
     * Insert a single field change record into the history table
     */
    public void insertFieldChange(ClinicalTrialFieldChange change) throws Exception {
        String sql = """
            INSERT INTO clinical_trial_field_history
            (nct_id, field_name, old_value, new_value, changed_at, update_date, update_by)
            VALUES (?, ?, ?, ?, NOW(), CAST(NULLIF(?, '') AS DATE), ?)
            """;
        update(sql,
            change.getNctId(),
            change.getFieldName(),
            change.getOldValue(),
            change.getNewValue(),
            change.getUpdateDate(),
            change.getUpdateBy()
        );
    }
    /**
     * update a single field change record into the history table
     */
    public void updateFieldChange(ClinicalTrialFieldChange change) throws Exception {
        String sql = """
            UPDATE clinical_trial_field_history
            SET old_value=?, new_value=?, changed_at=NOW(), update_date=?, update_by=?
            WHERE nct_id=? AND field_name=?
            """;
        update(sql,
                change.getOldValue(),
                change.getNewValue(),
                parseDate(change.getUpdateDate()),
                change.getUpdateBy(),
                change.getNctId(),
                change.getFieldName());
    }
    private java.sql.Date parseDate(String date) {
        if (date == null || date.isBlank()) {
            return null;
        }
        try {
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("MMM dd, yyyy", Locale.ENGLISH);
            LocalDate ld = LocalDate.parse(date, fmt);
            return java.sql.Date.valueOf(ld);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid date format: " + date, e);
        }
    }
    /**
     * Insert multiple field changes in batch
     */
    public void insertFieldChanges(List<ClinicalTrialFieldChange> changes) throws Exception {
        for (ClinicalTrialFieldChange change : changes) {
            List<ClinicalTrialFieldChange> changeRecords=getClinicalTrialFieldChangeRecord(change);
            if(changeRecords.size()>0) {
               updateFieldChange(change);
            }else{
                insertFieldChange(change);
            }
        }
    }

    /**
     * Get all field changes for a specific NCT ID
     */
    public List<ClinicalTrialFieldChange> getFieldChangesByNctId(String nctId) throws Exception {
        String sql = """
            SELECT * FROM clinical_trial_field_history
            WHERE nct_id = ?
            ORDER BY changed_at DESC
            """;
        ClinicalTrialFieldChangeQuery query = new ClinicalTrialFieldChangeQuery(this.getDataSource(), sql);
        return execute(query, nctId);
    }

    /**
     * Get field changes for a specific field across all records
     */
    public List<ClinicalTrialFieldChange> getFieldChangesByFieldName(String fieldName) throws Exception {
        String sql = """
            SELECT * FROM clinical_trial_field_history
            WHERE field_name = ?
            ORDER BY changed_at DESC
            """;
        ClinicalTrialFieldChangeQuery query = new ClinicalTrialFieldChangeQuery(this.getDataSource(), sql);
        return execute(query, fieldName);
    }

    /**
     * Get recent field changes (within last N days)
     */
    public List<ClinicalTrialFieldChange> getRecentFieldChanges(int days) throws Exception {
        String sql = """
            SELECT * FROM clinical_trial_field_history
            WHERE changed_at >= NOW() - INTERVAL '%d days'
            ORDER BY changed_at DESC
            """.formatted(days);
        ClinicalTrialFieldChangeQuery query = new ClinicalTrialFieldChangeQuery(this.getDataSource(), sql);
        return query.execute();
    }

    /**
     * Get field changes for a specific NCT ID and field name
     */
    public List<ClinicalTrialFieldChange> getFieldChanges(String nctId, String fieldName) throws Exception {
        String sql = """
            SELECT * FROM clinical_trial_field_history
            WHERE nct_id = ? AND field_name = ?
            ORDER BY changed_at DESC
            """;
        ClinicalTrialFieldChangeQuery query = new ClinicalTrialFieldChangeQuery(this.getDataSource(), sql);
        return execute(query, nctId, fieldName);
    }

    /**
     * Compare two records and return list of manually curated field changes
     */
    public List<ClinicalTrialFieldChange> compareCuratedFields(ClinicalTrialRecord existing, ClinicalTrialRecord newRecord, String updateBy) {
        List<ClinicalTrialFieldChange> changes = new ArrayList<>();
        String nctId = newRecord.getNctId();
        String today = java.time.LocalDate.now().toString();

        // Fields from updateCuratedDataFields()
        compareField(changes, nctId, "target_gene", existing.getTargetGeneOrVariant(), newRecord.getTargetGeneOrVariant(), today, updateBy);
        compareField(changes, nctId, "therapy_type", existing.getTherapyType(), newRecord.getTherapyType(), today, updateBy);
        compareField(changes, nctId, "therapy_route", existing.getTherapyRoute(), newRecord.getTherapyRoute(), today, updateBy);
        compareField(changes, nctId, "mechanism_of_action", existing.getMechanismOfAction(), newRecord.getMechanismOfAction(), today, updateBy);
        compareField(changes, nctId, "route_of_administration", existing.getRouteOfAdministration(), newRecord.getRouteOfAdministration(), today, updateBy);
        compareField(changes, nctId, "drug_product_type", existing.getDrugProductType(), newRecord.getDrugProductType(), today, updateBy);
        compareField(changes, nctId, "target_tissue", existing.getTargetTissueOrCell(), newRecord.getTargetTissueOrCell(), today, updateBy);
        compareField(changes, nctId, "delivery_system", existing.getDeliverySystem(), newRecord.getDeliverySystem(), today, updateBy);
        compareField(changes, nctId, "vector_type", existing.getVectorType(), newRecord.getVectorType(), today, updateBy);
        compareField(changes, nctId, "editor_type", existing.getEditorType(), newRecord.getEditorType(), today, updateBy);
        compareField(changes, nctId, "dose_1", existing.getDose1(), newRecord.getDose1(), today, updateBy);
        compareField(changes, nctId, "dose_2", existing.getDose2(), newRecord.getDose2(), today, updateBy);
        compareField(changes, nctId, "dose_3", existing.getDose3(), newRecord.getDose3(), today, updateBy);
        compareField(changes, nctId, "dose_4", existing.getDose4(), newRecord.getDose4(), today, updateBy);
        compareField(changes, nctId, "dose_5", existing.getDose5(), newRecord.getDose5(), today, updateBy);
        compareField(changes, nctId, "recent_updates", existing.getRecentUpdates(), newRecord.getRecentUpdates(), today, updateBy);
        //compareField(changes, nctId, "patents", existing.getPatents(), newRecord.getPatents(), today, updateBy);
        compareField(changes, nctId, "compound_name", existing.getCompoundName(), newRecord.getCompoundName(), today, updateBy);
        compareField(changes, nctId, "indication", existing.getIndication(), newRecord.getIndication(), today, updateBy);
        compareField(changes, nctId, "record_status", existing.getRecordStatus(), newRecord.getRecordStatus(), today, updateBy);

        // Fields from updateSomeNewFieldsDataFields()
        compareField(changes, nctId, "development_status", existing.getDevelopmentStatus(), newRecord.getDevelopmentStatus(), today, updateBy);
        compareField(changes, nctId, "indication_doid", existing.getIndicationDOID(), newRecord.getIndicationDOID(), today, updateBy);
        compareField(changes, nctId, "compound_description", existing.getCompoundDescription(), newRecord.getCompoundDescription(), today, updateBy);

        return changes;
    }

    /**
     * Compare two alias records and return list of field changes
     */
    public List<ClinicalTrialFieldChange> compareAliasFields(Alias existing, Alias newAlias, String updateBy) {
        List<ClinicalTrialFieldChange> changes = new ArrayList<>();
        String nctId = newAlias != null ? newAlias.getIdentifier() : (existing != null ? existing.getIdentifier() : null);
        String today = java.time.LocalDate.now().toString();

        String oldValue = existing != null ? existing.getAlias() : null;
        String newValue = newAlias != null ? newAlias.getAlias() : null;
        compareField(changes, nctId, "alias_value", oldValue, newValue, today, updateBy);

        oldValue = existing != null ? existing.getAliasTypeLC() : null;
        newValue = newAlias != null ? newAlias.getAliasTypeLC() : null;
        compareField(changes, nctId, "alias_type", oldValue, newValue, today, updateBy);

        oldValue = existing != null ? existing.getNotes() : null;
        newValue = newAlias != null ? newAlias.getNotes() : null;
        compareField(changes, nctId, "alias_notes", oldValue, newValue, today, updateBy);

        return changes;
    }

    /**
     * Compare two records and return list of field changes
     */
    public List<ClinicalTrialFieldChange> compareRecordsAPIFields(ClinicalTrialRecord existing, ClinicalTrialRecord newRecord, String updateBy) {
        List<ClinicalTrialFieldChange> changes = new ArrayList<>();
        String nctId = newRecord.getNctId();
        String updateDate = newRecord.getLastUpdatePostDate();

        // Compare each tracked field
        compareField(changes, nctId, "description", existing.getDescription(), newRecord.getDescription(), updateDate, updateBy);
        compareField(changes, nctId, "intervention_name", existing.getInterventionName(), newRecord.getInterventionName(), updateDate, updateBy);
        compareField(changes, nctId, "intervention_description", existing.getInterventionDescription(), newRecord.getInterventionDescription(), updateDate, updateBy);
        compareField(changes, nctId, "sponsor", existing.getSponsor(), newRecord.getSponsor(), updateDate, updateBy);
        compareField(changes, nctId, "sponsor_class", existing.getSponsorClass(), newRecord.getSponsorClass(), updateDate, updateBy);
        compareField(changes, nctId, "phases", existing.getPhase(), newRecord.getPhase(), updateDate, updateBy);
        compareField(changes, nctId, "enrollment_count", String.valueOf(existing.getEnrorllmentCount()), String.valueOf(newRecord.getEnrorllmentCount()), updateDate, updateBy);
        compareField(changes, nctId, "enrollment_type", existing.getEnrollmentType(), newRecord.getEnrollmentType(), updateDate, updateBy);
        compareField(changes, nctId, "locations", existing.getLocation(), newRecord.getLocation(), updateDate, updateBy);
        compareField(changes, nctId, "number_of_locations", String.valueOf(existing.getNumberOfLocations()), String.valueOf(newRecord.getNumberOfLocations()), updateDate, updateBy);
        compareField(changes, nctId, "eligibility_sex", existing.getEligibilitySex(), newRecord.getEligibilitySex(), updateDate, updateBy);
        compareField(changes, nctId, "eligibility_min_age", existing.getElibilityMinAge(), newRecord.getElibilityMinAge(), updateDate, updateBy);
        compareField(changes, nctId, "eligibility_max_age", existing.getElibilityMaxAge(), newRecord.getElibilityMaxAge(), updateDate, updateBy);
        compareField(changes, nctId, "eligibility_std_age", existing.getStandardAge(), newRecord.getStandardAge(), updateDate, updateBy);
        compareField(changes, nctId, "is_fda_regulated", existing.getIsFDARegulated(), newRecord.getIsFDARegulated(), updateDate, updateBy);
        compareField(changes, nctId, "brief_title", existing.getBriefTitle(), newRecord.getBriefTitle(), updateDate, updateBy);
        compareField(changes, nctId, "official_title", existing.getOfficialTitle(), newRecord.getOfficialTitle(), updateDate, updateBy);
        compareField(changes, nctId, "overall_status", existing.getStudyStatus(), newRecord.getStudyStatus(), updateDate, updateBy);
        compareField(changes, nctId, "first_submit_date", existing.getFirstSubmitDate(), newRecord.getFirstSubmitDate(), updateDate, updateBy);
        compareField(changes, nctId, "estimated_completion_date", existing.getEstimatedCompleteDate(), newRecord.getEstimatedCompleteDate(), updateDate, updateBy);
        compareField(changes, nctId, "last_update_post_date", existing.getLastUpdatePostDate(), newRecord.getLastUpdatePostDate(), updateDate, updateBy);
        compareField(changes, nctId, "browse_condition_terms", existing.getBrowseConditionTerms(), newRecord.getBrowseConditionTerms(), updateDate, updateBy);
        compareField(changes, nctId, "with_has_results", existing.getWithHasResults(), newRecord.getWithHasResults(), updateDate, updateBy);
//        compareField(changes, nctId, "indication", existing.getIndication(), newRecord.getIndication(), updateDate, updateBy);

        return changes;
    }

    /**
     * Helper method to compare a single field and add to changes list if different
     */
    private void compareField(List<ClinicalTrialFieldChange> changes, String nctId, String fieldName,
                              String oldValue, String newValue, String updateDate, String updateBy) {
        // Normalize null and empty strings for comparison
        String normalizedOld = normalizeValue(oldValue);
        String normalizedNew = normalizeValue(newValue);

        if (!Objects.equals(normalizedOld, normalizedNew)) {
            ClinicalTrialFieldChange change = new ClinicalTrialFieldChange(nctId, fieldName, oldValue, newValue, updateBy);
            change.setUpdateDate(updateDate);
            change.setUpdateBy(updateBy);
            changes.add(change);
        }
    }

    /**
     * Normalize value for comparison (treat null and empty as equivalent)
     */
    private String normalizeValue(String value) {
        if (value == null || value.trim().isEmpty() || value.equalsIgnoreCase("null")) {
            return null;
        }
        return value.trim().toLowerCase();
    }

    /**
     * Update API fields with change tracking - enhanced version
     */
    public String updateAPIFieldsWithTracking(ClinicalTrialRecord record, String updateBy) throws Exception {
        List<ClinicalTrialRecord> records = getClinicalTrailRecordByNctId(record.getNctId());
        if (records.size() > 0) {
            ClinicalTrialRecord existingRecord = records.get(0);

            // Compare and get changes
            List<ClinicalTrialFieldChange> changes = compareRecordsAPIFields(existingRecord, record, updateBy);

            if (!changes.isEmpty()) {

                // Log changes to history table
                insertFieldChanges(changes);

                // Build differences string for logging
                StringBuilder differences = new StringBuilder();
                for (ClinicalTrialFieldChange change : changes) {
                    differences.append(change.getFieldName()).append(": ")
                              .append(truncateForLog(change.getOldValue())).append(" -> ")
                              .append(truncateForLog(change.getNewValue())).append("; ");
                }

                logger.info("UPDATES: " + record.getNctId() + "\t>>>\t" + differences);

                // Update the main record
                updateAPIDataFields(record);

                return differences.toString();
            }
        }
        return "";
    }

    /**
     * Truncate value for logging
     */
    private String truncateForLog(String value) {
        if (value == null) return "null";
        return value.length() > 100 ? value.substring(0, 100) + "..." : value;
    }

    /**
     * Get count of changes by field name (useful for analytics)
     */
    public int getFieldChangeCount(String fieldName) throws Exception {
        String sql = "SELECT COUNT(*) FROM clinical_trial_field_history WHERE field_name = ?";
        return getCount(sql, fieldName);
    }

    /**
     * Get distinct NCT IDs that have had changes
     */
    public List<String> getNctIdsWithChanges() throws Exception {
        String sql = "SELECT DISTINCT nct_id FROM clinical_trial_field_history ORDER BY nct_id";
        return StringListQuery.execute(this, sql);
    }

    /**
     * Delete old change history (for maintenance)
     */
    public int deleteOldFieldChanges(int daysToKeep) throws Exception {
        String sql = "DELETE FROM clinical_trial_field_history WHERE changed_at < NOW() - INTERVAL '%d days'".formatted(daysToKeep);
        return update(sql);
    }

}
