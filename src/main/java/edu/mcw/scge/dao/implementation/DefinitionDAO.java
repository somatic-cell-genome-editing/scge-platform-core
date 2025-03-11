package edu.mcw.scge.dao.implementation;

import edu.mcw.scge.dao.AbstractDAO;
import edu.mcw.scge.dao.spring.DefinitionQuery;
import edu.mcw.scge.dao.spring.StringListQuery;
import edu.mcw.scge.datamodel.Definition;

import java.util.List;

public class DefinitionDAO extends AbstractDAO {
    public List<Definition> getAllDefinitions() throws Exception {
        String sql="select * from definitions order by term";
        DefinitionQuery query=new DefinitionQuery(this.getDataSource(), sql);
        return query.execute();
    }
    public List<Definition> getDefinitionsByCategory(String category) throws Exception {
        String sql="select * from definitions where field=?";
        DefinitionQuery query=new DefinitionQuery(this.getDataSource(), sql);
        return execute(query, category);
    }
    public List<String> getAbbreviation(String term) throws Exception {
        String sql=" select term from definitions where field=? and definition=?";
       StringListQuery query=new StringListQuery(this.getDataSource(), sql);
        return execute(query, "Abbreviation",term);
    }

}
