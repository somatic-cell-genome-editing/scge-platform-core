package edu.mcw.scge.dao.implementation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import edu.mcw.scge.dao.AbstractDAO;
import edu.mcw.scge.dao.spring.ClinicalTrialExternalLinksQuery;
import edu.mcw.scge.dao.spring.ClinicalTrialQuery;
import edu.mcw.scge.dao.spring.IntListQuery;
import edu.mcw.scge.datamodel.ClinicalTrialExternalLink;
import edu.mcw.scge.datamodel.ClinicalTrialRecord;

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

    public String getResponseStr(String fetchUri){
        RestTemplate restTemplate=new RestTemplate();
        return restTemplate.getForObject(fetchUri, String.class);
    }
    public boolean existsRecord(String nctId) throws Exception {
        List<ClinicalTrialRecord> records= getClinicalTrailRecordByNctId(nctId);
        return records.size() > 0;
    }
}
