package edu.mcw.scge.dao.spring;

import edu.mcw.scge.datamodel.Alias;
import org.springframework.jdbc.object.MappingSqlQuery;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AliasQuery extends MappingSqlQuery<Alias> {
    public AliasQuery(DataSource ds, String sql){
        super(ds,sql);
    }
    @Override
    protected Alias mapRow(ResultSet rs, int rowNum) throws SQLException {
        Alias alias=new Alias();
        alias.setKey(rs.getInt("key"));
        alias.setAliasTypeLC(rs.getString("alias_type_lc"));
        alias.setIdentifier(rs.getString("identifier"));
        alias.setCreatedDate(rs.getDate("created_date"));
        alias.setAlias(rs.getString("alias"));
        alias.setNotes(rs.getString("notes"));
        alias.setFieldName(rs.getString("field_name"));
        return alias;
    }
}
