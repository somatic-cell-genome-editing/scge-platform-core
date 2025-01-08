package edu.mcw.scge.dao.implementation;

import edu.mcw.scge.dao.AbstractDAO;
import edu.mcw.scge.dao.spring.DocumentQuery;
import edu.mcw.scge.datamodel.Application;
import edu.mcw.scge.datamodel.Document;

import java.util.List;

public class DocumentDAO extends AbstractDAO {
    public void insert(Document document) throws Exception {
        String sql="insert into document (document_id," +
                "application_id," +
                "document_type," +
                "document_name," +
                "sponsor_name," +
                "module," +
                "section," +
                "upload_date," +
                "version," +
                "status," +
                "tier," +
                "uploaded_by) values(?,?,?,?,?,?,?,?,?,?,?,?)";
        update(sql,document.getDocumentId(),
                document.getApplicationId(),
                document.getDocumentType(),
                document.getDocumentName(),
                document.getSponsorName(),
                document.getModule(),
                document.getSection(),
                document.getUploadDate(),
                document.getVersion(),
                document.getStatus(),
                document.getTier(),
                document.getUploadedBy());

    }
    public void delete(Document document){}
    public void update(Document document){}
    public List<Document> getApplicationDocuments(Application application){
        return null;
    }
    public List<Document> getDocumentsByApplicationId(int applicationId) throws Exception {
        String sql="select * from document where application_id=?";
        DocumentQuery query=new DocumentQuery(this.getDataSource(), sql);

        return execute(query, applicationId);
    }
    public Document getActiveDocumentByName(String docName, int applicationId, String sponsorName, int module) throws Exception {
        String sql="select * from document where  application_id=? and sponsor_name=? and module=? and document_name=? and status=? and version in ( " +
                "select max(version) from document where application_id=? and sponsor_name=? and module=? and document_name=? and status=?)" ;
        DocumentQuery query=new DocumentQuery(this.getDataSource(), sql);
        List<Document> documents=execute(query, applicationId, sponsorName, module, docName ,"ACTIVE", applicationId, sponsorName, module, docName, "ACTIVE");
        return documents.size()>0?documents.get(0):null;

    }
    public Document getDocumentByName(String docName, int applicationId, String sponsorName, int module) throws Exception {
        String sql="select * from document where  application_id=? and sponsor_name=? and module=? and document_name=?  and version in ( " +
                "select max(version) from document where application_id=? and sponsor_name=? and module=? and document_name=?)" ;
        DocumentQuery query=new DocumentQuery(this.getDataSource(), sql);
        List<Document> documents=execute(query, applicationId, sponsorName, module, docName , applicationId, sponsorName, module, docName);
        return documents.size()>0?documents.get(0):null;

    }
}
