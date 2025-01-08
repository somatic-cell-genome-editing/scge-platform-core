package edu.mcw.scge.dao.spring;

import edu.mcw.scge.datamodel.Document;
import org.springframework.jdbc.object.MappingSqlQuery;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DocumentQuery extends MappingSqlQuery<Document> {
    public DocumentQuery(DataSource ds, String query){
        super(ds, query);
    }
    @Override
    protected Document mapRow(ResultSet rs, int rowNum) throws SQLException {
        Document document=new Document();
        document.setDocumentId(rs.getInt("document_id"));
        document.setApplicationId(rs.getInt("application_id"));
        document.setDocumentType(rs.getString("document_type"));
        document.setDocumentName(rs.getString("document_name"));
        document.setSponsorName(rs.getString("sponsor_name"));
        document.setSection(rs.getString("section"));
        document.setModule(rs.getInt("module"));
        document.setUploadDate(rs.getDate("upload_date"));
        document.setVersion(rs.getString("version"));

        document.setStatus(rs.getString("status"));
        document.setTier(rs.getInt("tier"));
        document.setUploadedBy(rs.getString("uploaded_by"));


        return document;
    }
}
