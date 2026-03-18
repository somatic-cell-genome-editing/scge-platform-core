package edu.mcw.scge.dao.implementation;

import edu.mcw.scge.dao.AbstractDAO;
import edu.mcw.scge.dao.DataSourceFactory;
import edu.mcw.scge.dao.spring.CountQuery;
import edu.mcw.scge.dao.spring.DocumentEmbeddingSummaryQuery;
import edu.mcw.scge.dao.spring.StringListQuery;
import edu.mcw.scge.datamodel.DocumentEmbeddingSummary;

import javax.sql.DataSource;
import java.util.List;

public class DocumentEmbeddingDAO extends AbstractDAO {

    @Override
    public DataSource getDataSource() throws Exception {
        return DataSourceFactory.getInstance().getScgeRagDataSource();
    }

    public List<DocumentEmbeddingSummary> getFileSummaries() throws Exception {
        String sql = "SELECT file_name, COUNT(*) as chunk_count, MIN(created_at) as uploaded_at " +
                "FROM document_embeddings " +
                "GROUP BY file_name " +
                "ORDER BY file_name";
        DocumentEmbeddingSummaryQuery query = new DocumentEmbeddingSummaryQuery(this.getDataSource(), sql);
        return execute(query);
    }

    public int deleteByFileName(String fileName) throws Exception {
        String sql = "DELETE FROM document_embeddings WHERE file_name = ?";
        return update(sql, fileName);
    }

    public int getTotalChunkCount() throws Exception {
        String sql = "SELECT COUNT(*) FROM document_embeddings";
        return getCount(sql);
    }

    public int getChunkCountByFileName(String fileName) throws Exception {
        String sql = "SELECT COUNT(*) FROM document_embeddings WHERE file_name = ?";
        return getCount(sql, fileName);
    }

    public boolean fileExists(String fileName) throws Exception {
        return getChunkCountByFileName(fileName) > 0;
    }

    public List<String> getChunksByFileName(String fileName) throws Exception {
        String sql = "SELECT chunk FROM document_embeddings WHERE file_name = ? ORDER BY id";
        StringListQuery query = new StringListQuery(this.getDataSource(), sql);
        return execute(query, fileName);
    }
}
