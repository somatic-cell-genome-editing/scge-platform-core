package edu.mcw.scge.dao.implementation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import edu.mcw.scge.dao.AbstractDAO;
import edu.mcw.scge.dao.spring.ClinicalTrialExternalLinksQuery;
import edu.mcw.scge.dao.spring.ClinicalTrialQuery;
import edu.mcw.scge.dao.spring.IntListQuery;
import edu.mcw.scge.datamodel.ClinicalTrialExternalLink;
import edu.mcw.scge.datamodel.ClinicalTrialRecord;
import edu.mcw.scge.datamodel.clinicalTrialAPIModel.Intervention;
import edu.mcw.scge.datamodel.clinicalTrialAPIModel.Location;
import edu.mcw.scge.datamodel.clinicalTrialAPIModel.Study;
import org.json.JSONObject;
import org.springframework.web.client.RestTemplate;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
                "indication) " +
                "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?," +
                "?," +
                "?," +
                "?," +
                "?," +
                "?," +
                "?," +
                "?," +
                "?," +
                "?," +
                "?," +
                "?," +
                "?," +
                "?," +
                "?," +
                "?," +
                "?," +
                "?," +
                "?," +
                "?" +
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
                record.getIndication()
                );

    }

    public void updateCuratedDataFields(ClinicalTrialRecord record) throws Exception {
        String sql = "update clinical_trial_record set target_gene=?,therapy_type=?,therapy_route=?,mechanism_of_action=?,route_of_administration=?,drug_product_type=?,target_tissue=?,delivery_system=?,vector_type=?,editor_type=?,dose_1=?,dose_2=?,dose_3=?,dose_4=?,dose_5=?,recent_updates=?, patents=?, compound_name=?, indication=? where nctid=? ";
        this.update(sql, record.getTargetGeneOrVariant(), record.getTherapyType(), record.getTherapyRoute(), record.getMechanismOfAction(), record.getRouteOfAdministration(), record.getDrugProductType(), record.getTargetTissueOrCell(), record.getDeliverySystem(), record.getVectorType(), record.getEditorType(), record.getDose1(), record.getDose2(), record.getDose3(), record.getDose4(), record.getDose5(), record.getRecentUpdates(), record.getPatents(), record.getCompoundName(), record.getIndication(),record.getnCTNumber());
    }
    public void updateAPIDataFields(ClinicalTrialRecord record) throws Exception {
        String sql = "update clinical_trial_record set description=?,intervention_name=?,intervention_description=?,sponsor=?,sponsor_class=?,indication=?,phases=?,enrollment_count=?,locations=?,number_of_locations=?,eligibility_sex=?,eligibility_min_age=?,eligibity_max_age=?,eligibility_std_age=?,is_fda_regulated=?,brief_title=?,official_title=?,nih_report_link=?,overall_status=?,first_submit_date=?,estimated_completion_date=?,last_update_post_date=?,browse_condition_terms=? where nctid=?";
        this.update(sql, record.getDescription(), record.getInterventionName(), record.getInterventionDescription(), record.getSponsor(), record.getSponsorClass(), record.getIndication(), record.getPhase(), record.getEnrorllmentCount(), record.getLocation(), record.getNumberOfLocations(), record.getEligibilitySex(), record.getElibilityMinAge(), record.getElibilityMaxAge(), record.getStandardAge(), record.getIsFDARegulated(), record.getBriefTitle(), record.getOfficialTitle(), record.getNihReportLink(), record.getStudyStatus(), record.getFirstSubmitDate(), record.getEstimatedCompleteDate(), record.getLastUpdatePostDate(), record.getBrowseConditionTerms(),record.getNctId());
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
    public boolean existsExternalLink(ClinicalTrialExternalLink link) throws Exception {
        String sql="select * from clinical_trial_ext_links where link_name=? and link_type=? and nctid=?";
        ClinicalTrialExternalLinksQuery query=new ClinicalTrialExternalLinksQuery(this.getDataSource(), sql);
        List<ClinicalTrialExternalLink> links=execute(query, link.getName(), link.getType(), link.getNctId());
        return links.size()>0;
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
    public List<ClinicalTrialExternalLink> getExtLinksByNctId(String nctId) throws Exception {
        String sql="select * from clinical_trial_ext_links where nctid=?";
        ClinicalTrialExternalLinksQuery query=new ClinicalTrialExternalLinksQuery(this.getDataSource(), sql);
        return execute(query, nctId);
    }
    public void downloadClinicalTrailByNctId(String nctId){
        String baseURI="https://clinicaltrials.gov/api/v2/studies/";
        ObjectMapper mapper= new ObjectMapper();
        String fetchUri = baseURI + nctId;
        try {

            String responseStr=getResponseStr(fetchUri);
            if (responseStr != null) {
                JSONObject jsonObject = new JSONObject(responseStr);
                Study study = mapper.readValue(jsonObject.toString(), Study.class);
                ClinicalTrialRecord record = new ClinicalTrialRecord();
                record.setNctId(nctId);
                record.setDescription(study.getProtocolSection().getDescriptionModule().getBriefSummary());
                StringBuilder interventions = new StringBuilder();
                StringBuilder interventionDescription = new StringBuilder();

                // System.out.println("Interventions");
                for (Intervention intervention : study.getProtocolSection().getArmsInterventionsModule().getInterventions()) {
                    Map<String, Object> otherProps = intervention.getAdditionalProperties();
                    interventions.append(intervention.getName());
                    interventions.append(", ");
                    interventionDescription.append(otherProps.get("description"));
                    //  System.out.print(intervention.getName()+"\tOtherName:"+otherProps.get("otherNames")+"\tDosage:"+otherProps.get("description")+"\n");
                }
                record.setInterventionName(interventions.toString());
                record.setInterventionDescription(interventionDescription.toString());
                //   System.out.println("Sponsor:"+study.getProtocolSection().getSponsorCollaboratorsModule().getLeadSponsor().getName()+"\tCLASS:"+study.getProtocolSection().getSponsorCollaboratorsModule().getLeadSponsor().getClass_());
                record.setSponsor(study.getProtocolSection().getSponsorCollaboratorsModule().getLeadSponsor().getName());
                record.setSponsorClass(study.getProtocolSection().getSponsorCollaboratorsModule().getLeadSponsor().getClass_());
                //   System.out.println("Indication:"+ study.getProtocolSection().getConditionsModule().getConditions()+"\tKEYWORDS:"+study.getProtocolSection().getConditionsModule().getAdditionalProperties().get("keywords") );
                record.setIndication(String.join(", ", study.getProtocolSection().getConditionsModule().getConditions()));
                ArrayList<String> conditionKeywords = (ArrayList<String>) study.getProtocolSection().getConditionsModule().getAdditionalProperties().get("keywords");
                if (conditionKeywords != null && !conditionKeywords.isEmpty())
                    record.setBrowseConditionTerms(conditionKeywords.stream().collect(Collectors.joining(", ")));
                //    System.out.println("Phases:"+study.getProtocolSection().getDesignModule().getPhases()+"\tEnrollmentCount:"+study.getProtocolSection().getDesignModule().getEnrollmentInfo().getCount());
                record.setPhase(String.join(", ", study.getProtocolSection().getDesignModule().getPhases()));
                record.setEnrorllmentCount(study.getProtocolSection().getDesignModule().getEnrollmentInfo().getCount());

                //   indexer.indexDocuments(object);
                //   System.out.println("locations:"+ study.getProtocolSection().getContactsLocationsModule().getLocations().size());
                if (study.getProtocolSection().getContactsLocationsModule() != null) {
                    record.setLocation(String.join(",", study.getProtocolSection().getContactsLocationsModule().getLocations().stream().map(Location::getCountry).collect(Collectors.toSet())));
                    record.setNumberOfLocations(study.getProtocolSection().getContactsLocationsModule().getLocations().size());
                }

                record.setEligibilitySex(study.getProtocolSection().getEligibilityModule().getSex());
                record.setElibilityMinAge(study.getProtocolSection().getEligibilityModule().getMinimumAge());
                record.setElibilityMaxAge(study.getProtocolSection().getEligibilityModule().getMaximumAge());
                record.setHealthyVolunteers(study.getProtocolSection().getEligibilityModule().getHealthyVolunteers().toString());
                record.setStandardAge(String.join(",", study.getProtocolSection().getEligibilityModule().getStdAges()));


                record.setIsFDARegulated(String.valueOf(study.getProtocolSection().getOversightModule().getIsFdaRegulatedDrug()));
                record.setBriefTitle(study.getProtocolSection().getIdentificationModule().getBriefTitle());
                record.setOfficialTitle(study.getProtocolSection().getIdentificationModule().getOfficialTitle());
                if (study.getProtocolSection().getIdentificationModule().getAdditionalProperties().get("secondaryIdInfos") != null) {
                    ArrayList object = (ArrayList) study.getProtocolSection().getIdentificationModule().getAdditionalProperties().get("secondaryIdInfos");
                    StringBuilder builder = new StringBuilder();
                    for (Object o : object) {
                        String link = ((Map<String, String>) o).get("link");
                        if (link != null)
                            builder.append(link).append(";");

                    }

                    record.setNihReportLink(builder.toString());
                }
                record.setStudyStatus(study.getProtocolSection().getStatusModule().getOverallStatus());
                record.setFirstSubmitDate((study.getProtocolSection().getStatusModule().getStudyFirstSubmitDate()));
                record.setEstimatedCompleteDate((study.getProtocolSection().getStatusModule().getCompletionDateStruct().getDate()));
                record.setLastUpdatePostDate((study.getProtocolSection().getStatusModule().getLastUpdatePostDateStruct().getDate()));
//                        System.out.println("Derived Section Browse Branches:");
//                        for(BrowseBranch branch:study.getDerivedSection().getConditionBrowseModule().getBrowseBranches()){
//                            System.out.print(branch.getName()+",\t");
//                        }
//                        System.out.println("\nDerived Section Browse Leaf:");
//                        for(Browseleaf branch:study.getDerivedSection().getConditionBrowseModule().getBrowseLeaves()){
//                            System.out.print(branch.getName()+",\t");
//                        }
//                        System.out.println("\nDerived Section Browse Ancestors:");
//                        for(Ancestor branch:study.getDerivedSection().getConditionBrowseModule().getAncestors()){
//                            System.out.print(branch.getTerm()+",\t");
//                        }
//                        System.out.println("\nDerived Section Browse MEshes:");
//                        for(Mesh branch:study.getDerivedSection().getConditionBrowseModule().getMeshes()){
//                            System.out.print(branch.getTerm()+",\t");
//                        }
//
//                        System.out.println("Derived Section Browse intervention Branches:");
//                        for(Map.Entry branch:((Map<String, Object>)study.getDerivedSection().getAdditionalProperties().get("interventionBrowseModule")).entrySet()){
//                            System.out.print(branch.getValue()+",\t");
//                        }
                if(!existsRecord(record.getNctId()))
                    insert(record);
                else{
                    updateAPIDataFields(record);
                }
            }
        } catch (Exception exception) {
            System.out.println("NCTID:" + nctId);
            exception.printStackTrace();
        }
    }
    public void downloadClinicalTrails(List<String> nctIds) throws Exception {
            if(nctIds.size()>0) {

            loop:  for (String nctId : nctIds) {
                if (nctId == null || nctId.equals("") || nctId.equals("null"))
                    continue loop;
                //  String nctId="NCT02852213";
                    downloadClinicalTrailByNctId(nctId);

            }
        }
    }
    public String getResponseStr(String fetchUri){
        RestTemplate restTemplate=new RestTemplate();
        return restTemplate.getForObject(fetchUri, String.class);
    }
    public boolean existsRecord(String nctId) throws Exception {
        List<ClinicalTrialRecord> records= getClinicalTrailRecordByNctId(nctId);
        return records.size() > 0;
    }
}
