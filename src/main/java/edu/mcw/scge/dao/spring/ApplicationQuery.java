package edu.mcw.scge.dao.spring;

import edu.mcw.scge.datamodel.Application;
import org.springframework.jdbc.object.MappingSqlQuery;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ApplicationQuery extends MappingSqlQuery<Application> {
    public ApplicationQuery(DataSource ds, String query){
         super(ds, query);
    }

    @Override
    protected Application mapRow(ResultSet rs, int rowNum) throws SQLException {
        Application application=new Application();
        application.setApplicationId(rs.getInt("application_id"));
        application.setSponsorName(rs.getString("sponsor_name"));
        application.setApplicationNumber(rs.getString("application_number"));
        application.setSubmissionDate(rs.getDate("submission_date"));
        application.setIndication(rs.getString("indication"));
        application.setRouteOfAdministration(rs.getString("route_of_administration"));
        application.setPharmaceuticalFormulation(rs.getString("pharmaceutical_formulation"));
        application.setManufacturerName(rs.getString("manufacturer_name"));
        application.setReferenceStandard(rs.getString("reference_standard"));
        application.setDosageStrength(rs.getString("dosage_strength"));
        application.setDescription(rs.getString("description"));
        application.setProductName(rs.getString("product_name"));
        application.setSubmittedBy(rs.getString("submitted_by"));
        return application;
    }
}
