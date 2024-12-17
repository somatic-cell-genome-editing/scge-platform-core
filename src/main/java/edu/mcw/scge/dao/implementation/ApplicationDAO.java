package edu.mcw.scge.dao.implementation;

import edu.mcw.scge.dao.AbstractDAO;
import edu.mcw.scge.dao.spring.ApplicationQuery;
import edu.mcw.scge.datamodel.Application;


import java.util.List;


public class ApplicationDAO extends AbstractDAO {
    public void insert(Application application) throws Exception {
        String sql="insert into application (application_id," +
                "sponsor_name," +
                "application_number," +
                "submission_date," +
                "indication," +
                "route_of_administration," +
                "pharmaceutical_formulation," +
                "manufacturer_name," +
                "reference_standard," +
                "dosage_strength," +
                "description," +
                "product_name," +
                "submitted_by) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        update(sql,application.getApplicationId(),
                application.getSponsorName(),
                application.getApplicationNumber(),
                application.getSubmissionDate(),
                application.getIndication(),
                application.getRouteOfAdministration(),
                application.getPharmaceuticalFormulation(),
                application.getManufacturerName(),
                application.getReferenceStandard(),
                application.getDosageStrength(),
                application.getDescription(),
                application.getProductName(),
                application.getSubmittedBy());

    }

    public void delete(Application application){
        // TODO
    }
    public void update(Application application){
        // TODO
    }
    public Application getApplicationById(int applicationId) throws Exception {
      String sql="select * from application where application_id=?";
      ApplicationQuery query=new ApplicationQuery(this.getDataSource(), sql);
      List<Application> applicationList=execute(query, applicationId);
      return applicationList.size()>0?applicationList.get(0):null;
    }
    public List<Application> getApplicationBySponsorId(int sponsorId){
        // TODO
        return null;
    }
    public List<Application> getApplications() throws Exception {
     String sql="select * from application";
        ApplicationQuery query=new ApplicationQuery(this.getDataSource(), sql);
        return query.execute();
    }
}
