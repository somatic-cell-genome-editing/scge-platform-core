package edu.mcw.scge.dao.implementation;

import edu.mcw.scge.dao.AbstractDAO;
import edu.mcw.scge.dao.spring.ClinicalTrialCuratedDataQuery;
import edu.mcw.scge.dao.spring.ClinicalTrialExternalLinksQuery;
import edu.mcw.scge.dao.spring.ClinicalTrialQuery;
import edu.mcw.scge.datamodel.ClinicalTrialCuratedData;
import edu.mcw.scge.datamodel.ClinicalTrialExternalLink;
import edu.mcw.scge.datamodel.ClinicalTrialRecord;

import java.util.List;

public class ClinicalTrailDAO extends AbstractDAO {
    public void insert(ClinicalTrialRecord record) throws Exception {
        String sql="insert into clinical_trial_record (nctid, " +
                "description," +
                "intervention_name," +
                "intervention_description," +
                "sponsor," +
                "sponsor_class," +
                "indication," +
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
                "browse_condition_terms) " +
                "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        update(sql,record.getNctId(),
                record.getDescription(),
                record.getInterventionName(),
                record.getInterventionDescription(),
                record.getSponsor(),
                record.getSponsorClass(),
                record.getIndication(),
                record.getPhases(),
                record.getEnrorllmentCount(),
                record.getLocations(),
                record.getNumberOfLocations(),
                record.getEligibilitySex(),
                record.getElibilityMinAge(),
                record.getElibilityMaxAge(),
                record.getStandardAges(),
                record.getIsFDARegulated(),
                record.getBriefTitle(),
                record.getOfficialTitle(),
                record.getNihReportLink(),
                record.getStatus(),
                record.getFirstSubmitDate(),
                record.getEstimatedCompleteDate(),
                record.getLastUpdatePostDate(),
                record.getBrowseConditionTerms());
    }

    public void insertClinicalTrailCuratedData(ClinicalTrialCuratedData record) throws Exception {
        String sql="insert into clinical_trial_curated_data (" +
                "nctid\n," +
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
                "patents" +
                ") values (" +
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
        update(sql, record.getnCTNumber(),
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
                record.getPatents()
        );
    }
    public void insertExternalLink(ClinicalTrialExternalLink link) throws Exception {
        String sql="insert into clinical_trial_ext_links( " +
                "link_name\n," +
                "link_type\n," +
                "link\n," +
                "nctid" +
                ") values (" +
                "?," +
                "?," +
                "?," +
                "?" +
                ")";
        update(sql, link.getName(), link.getType(), link.getLink(), link.getNctId());
    }
    public List<ClinicalTrialCuratedData> getAllClinicalTrailRecords() throws Exception {
        String sql="select * from clinical_trial_record t " +
                "left join clinical_trial_curated_data ct on t.nctid=ct.nctid ";
        ClinicalTrialQuery query=new ClinicalTrialQuery(this.getDataSource(), sql);
        return query.execute();
    }
    public ClinicalTrialCuratedData getCuratedDataByNctId(String nctId) throws Exception {
        String sql="select * from  clinical_trial_curated_data  where nctid=?";
        ClinicalTrialCuratedDataQuery query=new ClinicalTrialCuratedDataQuery(this.getDataSource(), sql);
       List<ClinicalTrialCuratedData> curatedData= execute(query, nctId);
       return curatedData.size()>0?curatedData.get(0):null;
    }
    public List<ClinicalTrialCuratedData> getClinicalTrailRecordByNctId(String nctId) throws Exception {
        String sql="select * from clinical_trial_record t left join clinical_trial_curated_data ct on t.nctid=ct.nctid where t.nctid=?";
        ClinicalTrialQuery query=new ClinicalTrialQuery(this.getDataSource(), sql);
        return execute(query, nctId);
    }
    public List<ClinicalTrialExternalLink> getExtLinksByNctId(String nctId) throws Exception {
        String sql="select * from clinical_trial_ext_links where nctid=?";
        ClinicalTrialExternalLinksQuery query=new ClinicalTrialExternalLinksQuery(this.getDataSource(), sql);
        return execute(query, nctId);
    }
}
