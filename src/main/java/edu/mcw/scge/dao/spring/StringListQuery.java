package edu.mcw.scge.dao.spring;

import edu.mcw.scge.dao.AbstractDAO;
import org.springframework.jdbc.object.MappingSqlQuery;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by jthota on 9/3/2019.
 */
public class StringListQuery extends MappingSqlQuery {
    public StringListQuery(DataSource ds, String query) {
        super(ds, query);
    }
    @Override
    protected Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        return rs.getString(1);
    }
    /**
     * wrapper for execute()
     * @return list of strings
     */
    public List<String> getStringList() {
        return this.execute();
    }

    /**
     * wrapper for execute(Object[])
     * @param params array of params
     * @return list of strings
     */
    public List<String> getStringList(Object[] params) {
        return this.execute(params);
    }

    public static List<String> execute(AbstractDAO dao, String sql, Object... params) throws Exception {
        StringListQuery q = new StringListQuery(dao.getDataSource(), sql);
        return dao.execute(q, params);
    }
}
