package edu.mcw.scge.dao.implementation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import edu.mcw.scge.dao.AbstractDAO;
import edu.mcw.scge.dao.spring.ClinicalTrialExternalLinksQuery;
import edu.mcw.scge.dao.spring.ClinicalTrialQuery;
import edu.mcw.scge.dao.spring.IntListQuery;
import edu.mcw.scge.datamodel.ClinicalTrialExternalLink;
import edu.mcw.scge.datamodel.ClinicalTrialRecord;

import edu.mcw.scge.datamodel.clinicalTrialModel.ClinicalTrialIndexObject;
import edu.mcw.scge.datamodel.clinicalTrialModel.Intervention;
import edu.mcw.scge.datamodel.clinicalTrialModel.Location;
import edu.mcw.scge.datamodel.clinicalTrialModel.Study;
import org.elasticsearch.common.recycler.Recycler;
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

    public void downloadClinicalTrailByNctId(String nctId) {
        String baseURI = "https://clinicaltrials.gov/api/v2/studies/";
        ObjectMapper mapper = new ObjectMapper();
        String fetchUri = baseURI + nctId;

        try {
            String responseStr = this.getResponseStr(fetchUri);
            if (responseStr != null) {
                JSONObject jsonObject = new JSONObject(responseStr);
                Study study = (Study)mapper.readValue(jsonObject.toString(), Study.class);
                ClinicalTrialRecord record = new ClinicalTrialRecord();
                record.setNctId(nctId);
                record.setDescription(study.getProtocolSection().getDescriptionModule().getBriefSummary());
                StringBuilder interventions = new StringBuilder();
                StringBuilder interventionDescription = new StringBuilder();
                Iterator var11 = study.getProtocolSection().getArmsInterventionsModule().getInterventions().iterator();

                while(var11.hasNext()) {
                    Intervention intervention = (Intervention)var11.next();
                    Map<String, Object> otherProps = intervention.getAdditionalProperties();
                    interventions.append(intervention.getName());
                    interventions.append(", ");
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
                record.setIsFDARegulated(String.valueOf(study.getProtocolSection().getOversightModule().getIsFdaRegulatedDrug()));
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
                } else {
                    this.updateAPIDataFields(record);
                }
            }
        } catch (Exception var17) {
            System.out.println("NCTID:" + nctId);
            var17.printStackTrace();
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


//    public void downloadClinicalTrails(List<String> nctIds) throws Exception {
//        Gson gson=new Gson();
//        if(nctIds.size()>0) {
//            String baseURI="https://clinicaltrials.gov/api/v2/studies/";
//            ObjectMapper mapper= new ObjectMapper();
//            loop:  for (String nctId : nctIds) {
//                if (nctId == null || nctId.equals("") || nctId.equals("null"))
//                    continue loop;
//                String fetchUri = baseURI + nctId;
//                try {
//                        String responseStr=getResponseStr(fetchUri);
//                        if (responseStr != null) {
//                            JSONObject jsonObject = new JSONObject(responseStr);
//                            Study study = mapper.readValue(jsonObject.toString(), Study.class);
//                            ClinicalTrialIndexObject record = new ClinicalTrialIndexObject();
//                            record.setNctId(nctId);
//                            record.setDescription(study.getProtocolSection().getDescriptionModule().getBriefSummary());
//                            if(study.getProtocolSection().getArmsInterventionsModule().getInterventions()!=null) {
//                                String interventions = study.getProtocolSection().getArmsInterventionsModule().getInterventions().stream().map(Intervention::getName).filter(Objects::nonNull).collect(Collectors.joining(", "));
//                                record.setInterventionName(interventions);
//                                String interventionDescription=study.getProtocolSection().getArmsInterventionsModule().getInterventions().stream()
//                                        .map(i->i.getAdditionalProperties().get("description").toString()).filter(Objects::nonNull).collect(Collectors.joining(", "));
//                                record.setInterventionDescription(interventionDescription);
//                            }
//                            //   System.out.println("Sponsor:"+study.getProtocolSection().getSponsorCollaboratorsModule().getLeadSponsor().getName()+"\tCLASS:"+study.getProtocolSection().getSponsorCollaboratorsModule().getLeadSponsor().getClass_());
//                            if(study.getProtocolSection().getSponsorCollaboratorsModule()!=null) {
//                                record.setSponsor(study.getProtocolSection().getSponsorCollaboratorsModule().getLeadSponsor().getName());
//                                record.setSponsorClass(study.getProtocolSection().getSponsorCollaboratorsModule().getLeadSponsor().getClass_());
//                            }
//                            //   System.out.println("Indication:"+ study.getProtocolSection().getConditionsModule().getConditions()+"\tKEYWORDS:"+study.getProtocolSection().getConditionsModule().getAdditionalProperties().get("keywords") );
//                           if(study.getProtocolSection().getConditionsModule()!=null && study.getProtocolSection().getConditionsModule().getConditions()!=null)
//                            record.setIndication(String.join(", ", study.getProtocolSection().getConditionsModule().getConditions()));
//                            if(study.getProtocolSection().getConditionsModule()!=null && study.getProtocolSection().getConditionsModule().getAdditionalProperties()!=null) {
//                                ArrayList<String> conditionKeywords = (ArrayList<String>) study.getProtocolSection().getConditionsModule().getAdditionalProperties().get("keywords");
//                                if (conditionKeywords != null && !conditionKeywords.isEmpty())
//                                    record.setBrowseConditionTerms(conditionKeywords.stream().collect(Collectors.joining(", ")));
//                                //    System.out.println("Phases:"+study.getProtocolSection().getDesignModule().getPhases()+"\tEnrollmentCount:"+study.getProtocolSection().getDesignModule().getEnrollmentInfo().getCount());
//
//                            }
//                            if(study.getProtocolSection().getDesignModule()!=null && study.getProtocolSection().getDesignModule().getPhases()!=null) {
//                                record.setPhase(String.join(", ", study.getProtocolSection().getDesignModule().getPhases()));
//                                record.setPhases(study.getProtocolSection().getDesignModule().getPhases().stream().collect(Collectors.toSet()));
//                            }
//                            if(study.getProtocolSection().getDesignModule()!=null && study.getProtocolSection().getDesignModule().getEnrollmentInfo()!=null) {
//                                record.setEnrorllmentCount(study.getProtocolSection().getDesignModule().getEnrollmentInfo().getCount());
//                            }
//                            //   indexer.indexDocuments(object);
//                            //   System.out.println("locations:"+ study.getProtocolSection().getContactsLocationsModule().getLocations().size());
//                            if (study.getProtocolSection().getContactsLocationsModule() != null) {
//                                record.setLocations(study.getProtocolSection().getContactsLocationsModule().getLocations().stream().map(Location::getCountry).collect(Collectors.toSet()).stream().collect(Collectors.toSet()));
//                                record.setNumberOfLocations(study.getProtocolSection().getContactsLocationsModule().getLocations().size());
//                            }
////                        System.out.print("Centers in USA:");
////                        for(Location location:study.getProtocolSection().getContactsLocationsModule().getLocations()){
////                            if(location.getCountry().equalsIgnoreCase("United States")){
////                                System.out.print("Yes"+"\t");
////                            }
////                        }
////                        System.out.println("\n");
////                        System.out.println("Eligibility: \tSEX:"+study.getProtocolSection().getEligibilityModule().getSex()+"\tMin AGE:"+ study.getProtocolSection().getEligibilityModule().getMinimumAge()+"\t" +
////                                "MAX AGE:"+study.getProtocolSection().getEligibilityModule().getMaximumAge() +"\tHEALTHY VOLUNTEERS:"+ study.getProtocolSection().getEligibilityModule().getHealthyVolunteers()+"\n" +
////                                "Standard Age:"+ study.getProtocolSection().getEligibilityModule().getStdAges());
//
//                                if(study.getProtocolSection().getEligibilityModule()!=null) {
//                                    if(study.getProtocolSection().getEligibilityModule().getSex()!=null)
//                                        record.setEligibilitySex(study.getProtocolSection().getEligibilityModule().getSex());
//                                    if(study.getProtocolSection().getEligibilityModule().getMinimumAge()!=null)
//                                    record.setElibilityMinAge(study.getProtocolSection().getEligibilityModule().getMinimumAge());
//                                    if(study.getProtocolSection().getEligibilityModule().getMaximumAge()!=null)
//                                    record.setElibilityMaxAge(study.getProtocolSection().getEligibilityModule().getMaximumAge());
//                                    if(study.getProtocolSection().getEligibilityModule().getHealthyVolunteers()!=null)
//                                    record.setHealthyVolunteers(study.getProtocolSection().getEligibilityModule().getHealthyVolunteers().toString());
//                                    if(study.getProtocolSection().getEligibilityModule().getStdAges()!=null)
//                                    record.setStandardAges(study.getProtocolSection().getEligibilityModule().getStdAges().stream().collect(Collectors.toSet()));
//
//                                }
//                                if(study.getProtocolSection().getOversightModule()!=null && study.getProtocolSection().getOversightModule().getIsFdaRegulatedDrug()!=null)
//                                    record.setIsFDARegulated(String.valueOf(study.getProtocolSection().getOversightModule().getIsFdaRegulatedDrug()));
//                            if(study.getProtocolSection().getIdentificationModule()!=null) {
//
//
//                                if(study.getProtocolSection().getIdentificationModule().getBriefTitle()!=null)
//                                record.setBriefTitle(study.getProtocolSection().getIdentificationModule().getBriefTitle());
//                                if(study.getProtocolSection().getIdentificationModule().getOfficialTitle()!=null)
//                                record.setOfficialTitle(study.getProtocolSection().getIdentificationModule().getOfficialTitle());
//                                if (study.getProtocolSection().getIdentificationModule().getAdditionalProperties()!=null && study.getProtocolSection().getIdentificationModule().getAdditionalProperties().get("secondaryIdInfos") != null) {
//                                    ArrayList object = (ArrayList) study.getProtocolSection().getIdentificationModule().getAdditionalProperties().get("secondaryIdInfos");
//                                    StringBuilder builder = new StringBuilder();
//                                    for (Object o : object) {
//                                        String link = ((Map<String, String>) o).get("link");
//                                        if (link != null)
//                                            builder.append(link).append(";");
//
//                                    }
//
//                                    record.setNihReportLink(builder.toString());
//                                }
//                            }
//                            if(study.getProtocolSection().getStatusModule()!=null) {
//                                if(study.getProtocolSection().getStatusModule().getOverallStatus()!=null)
//
//                                record.setStatus(Collections.singleton(study.getProtocolSection().getStatusModule().getOverallStatus()));
//                                if(study.getProtocolSection().getStatusModule().getStudyFirstSubmitDate()!=null)
//                                record.setFirstSubmitDate((study.getProtocolSection().getStatusModule().getStudyFirstSubmitDate()));
//                                if(study.getProtocolSection().getStatusModule().getCompletionDateStruct()!=null)
//                                record.setEstimatedCompleteDate((study.getProtocolSection().getStatusModule().getCompletionDateStruct().getDate()));
//                                if(study.getProtocolSection().getStatusModule().getLastUpdatePostDateStruct()!=null)
//                                record.setLastUpdatePostDate((study.getProtocolSection().getStatusModule().getLastUpdatePostDateStruct().getDate()));
//                            }
////                        System.out.println("Derived Section Browse Branches:");
////                        for(BrowseBranch branch:study.getDerivedSection().getConditionBrowseModule().getBrowseBranches()){
////                            System.out.print(branch.getName()+",\t");
////                        }
////                        System.out.println("\nDerived Section Browse Leaf:");
////                        for(Browseleaf branch:study.getDerivedSection().getConditionBrowseModule().getBrowseLeaves()){
////                            System.out.print(branch.getName()+",\t");
////                        }
////                        System.out.println("\nDerived Section Browse Ancestors:");
////                        for(Ancestor branch:study.getDerivedSection().getConditionBrowseModule().getAncestors()){
////                            System.out.print(branch.getTerm()+",\t");
////                        }
////                        System.out.println("\nDerived Section Browse MEshes:");
////                        for(Mesh branch:study.getDerivedSection().getConditionBrowseModule().getMeshes()){
////                            System.out.print(branch.getTerm()+",\t");
////                        }
////
////                        System.out.println("Derived Section Browse intervention Branches:");
////                        for(Map.Entry branch:((Map<String, Object>)study.getDerivedSection().getAdditionalProperties().get("interventionBrowseModule")).entrySet()){
////                            System.out.print(branch.getValue()+",\t");
////                        }
//                            if(!existsRecord(nctId))
//                                insert(record);
//                            else
//                                updateAPIDataFields(record);
//
//                            System.out.println("RECORD:"+gson.toJson(record));
//                        }
//                    } catch (Exception exception) {
//                        System.out.println("NCTID:" + nctId);
//                        exception.printStackTrace();
//                    }
//
//            }
//        }
//    }

}
