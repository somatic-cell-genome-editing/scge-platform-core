package edu.mcw.scge.dao.implementation;

import edu.mcw.scge.dao.AbstractDAO;
import edu.mcw.scge.dao.DataSourceFactory;
import edu.mcw.scge.dao.spring.CountQuery;
import edu.mcw.scge.dao.spring.DocumentEmbeddingSummaryQuery;
import edu.mcw.scge.dao.spring.StringListQuery;
import edu.mcw.scge.datamodel.DocumentEmbeddingSummary;

import javax.sql.DataSource;
import java.util.ArrayList;
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

    public List<DocumentEmbeddingSummary> getFileSummariesPaginated(String type, String search, int limit, int offset) throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT file_name, COUNT(*) as chunk_count, MIN(created_at) as uploaded_at FROM document_embeddings WHERE ");

        List<Object> params = new ArrayList<>();

        if ("clinicalTrials".equals(type)) {
            sql.append("file_name LIKE 'CLINICAL TRIAL:%' ");
        } else {
            sql.append("file_name NOT LIKE 'CLINICAL TRIAL:%' ");
        }

        if (search != null && !search.trim().isEmpty()) {
            sql.append("AND file_name ILIKE ? ");
            params.add("%" + search.trim() + "%");
        }

        sql.append("GROUP BY file_name ORDER BY file_name LIMIT ? OFFSET ?");
        params.add(limit);
        params.add(offset);

        DocumentEmbeddingSummaryQuery query = new DocumentEmbeddingSummaryQuery(this.getDataSource(), sql.toString());
        return execute(query, params.toArray());
    }

    public int getFileCount(String type, String search) throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT COUNT(DISTINCT file_name) FROM document_embeddings WHERE ");

        List<Object> params = new ArrayList<>();

        if ("clinicalTrials".equals(type)) {
            sql.append("file_name LIKE 'CLINICAL TRIAL:%' ");
        } else {
            sql.append("file_name NOT LIKE 'CLINICAL TRIAL:%' ");
        }

        if (search != null && !search.trim().isEmpty()) {
            sql.append("AND file_name ILIKE ? ");
            params.add("%" + search.trim() + "%");
        }

        return getCount(sql.toString(), params.toArray());
    }

    public List<String> getChunksByFileName(String fileName) throws Exception {
        String sql = "SELECT chunk FROM document_embeddings WHERE file_name = ? ORDER BY id";
        StringListQuery query = new StringListQuery(this.getDataSource(), sql);
        return execute(query, fileName);
    }
}
