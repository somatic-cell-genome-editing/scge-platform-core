package edu.mcw.scge.dao.spring;

import edu.mcw.scge.datamodel.Definition;
import org.springframework.jdbc.object.MappingSqlQuery;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DefinitionQuery extends MappingSqlQuery<Definition> {
    public DefinitionQuery(DataSource ds, String sql){
        super(ds, sql);
    }
    @Override
    protected Definition mapRow(ResultSet rs, int rowNum) throws SQLException {
        Definition definition=new Definition();
        definition.setDefinition(rs.getString("definition"));
        definition.setTerm(rs.getString("term"));
        definition.setField(rs.getString("field"));
        return definition;
    }
}
