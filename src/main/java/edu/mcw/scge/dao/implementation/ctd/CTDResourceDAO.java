package edu.mcw.scge.dao.implementation.ctd;

import edu.mcw.scge.dao.AbstractDAO;
import edu.mcw.scge.dao.spring.ctd.CTDResourceQuery;
import edu.mcw.scge.datamodel.ctd.CTDResource;

import java.util.List;

public class CTDResourceDAO extends AbstractDAO {
    public void insert(CTDResource resource) throws Exception {
        String sql="insert into ctd_resources(resource_id, resource_name, resource_url, resource_description, ctd_section, date_issued,source, type, file_path, last_modified_date)" +
                "   values(NEXTVAL('ctd_resource_id_seq'),?,?,?,?,?,?,?,?, NOW())";
        update(sql,resource.getResourceName(), resource.getResourceUrl(), resource.getResourceDescription(), resource.getCtdSection(), resource.getDateIssued()
        ,resource.getSource(), resource.getType(),resource.getFilePath());
    }
    public void update(CTDResource resource) throws Exception {
        String sql="update ctd_resources set " +
                "resource_name=?, " +
                "resource_url=?, " +
                "resource_description=?, " +
                "date_issued=?," +
                "source=?, " +
                "type=?, " +
                "file_path=?," +
                "last_modified_date=NOW()," +
                "where ctd_section=?   ";
        update(sql,resource.getResourceName(), resource.getResourceUrl(), resource.getResourceDescription(),  resource.getDateIssued()
                ,resource.getSource(), resource.getType(),resource.getFilePath(), resource.getCtdSection());
    }
    public List<CTDResource> getResourcesBySection(String sectionCode) throws Exception {
        String sql="select * from ctd_resources where ctd_section=?";
        CTDResourceQuery query=new CTDResourceQuery(this.getDataSource(), sql);
        return execute(query, sectionCode);
    }
    public List<CTDResource> getAllResources() throws Exception {
        String sql = "SELECT * FROM ctd_resources ORDER BY ctd_section, type, resource_name";
        CTDResourceQuery query = new CTDResourceQuery(this.getDataSource(), sql);
        return execute(query);
    }
    public List<CTDResource> getCTDResource(CTDResource resource) throws Exception {
        // resource_url and file_path are optional and historically stored inconsistently
        // (SQL NULL, the literal text 'null'/'(null)', '' or blanks). Collapse all of those
        // to NULL on both the column and the bound parameter so duplicates are detected.
        String urlExpr="(CASE WHEN TRIM(LOWER(COALESCE(resource_url,''))) IN ('','null','(null)') THEN NULL ELSE TRIM(resource_url) END)";
        String filePathExpr="(CASE WHEN TRIM(LOWER(COALESCE(file_path,''))) IN ('','null','(null)') THEN NULL ELSE TRIM(file_path) END)";
        String sql="select * from ctd_resources where ctd_section IS NOT DISTINCT FROM ?" +
                "   and resource_name IS NOT DISTINCT FROM ? " +
                "   and " + urlExpr + " IS NOT DISTINCT FROM ? " +
                "   and resource_description IS NOT DISTINCT FROM ? " +
                "   and date_issued IS NOT DISTINCT FROM ?" +
                "   and source IS NOT DISTINCT FROM ? " +
                "   and type IS NOT DISTINCT FROM ? " +
                "   and " + filePathExpr + " IS NOT DISTINCT FROM ?" ;
        CTDResourceQuery query=new CTDResourceQuery(this.getDataSource(), sql);
        return execute(query,resource.getCtdSection() ,resource.getResourceName(), normalizeEmpty(resource.getResourceUrl()), resource.getResourceDescription(),  resource.getDateIssued()
                ,resource.getSource(), resource.getType(),normalizeEmpty(resource.getFilePath()));
    }

    /**
     * Normalizes the various "empty" representations (null, "", blanks, the literal
     * "null"/"(null)") to a real null so they compare equal to a normalized column.
     */
    private String normalizeEmpty(String value){
        if(value==null){
            return null;
        }
        String v=value.trim();
        if(v.isEmpty() || v.equalsIgnoreCase("null") || v.equalsIgnoreCase("(null)")){
            return null;
        }
        return v;
    }
}
