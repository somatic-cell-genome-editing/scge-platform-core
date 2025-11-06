package edu.mcw.scge.dao.spring;

import edu.mcw.scge.dao.implementation.ProjectDao;
import edu.mcw.scge.datamodel.Project;
import org.springframework.jdbc.object.MappingSqlQuery;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProjectQuery extends MappingSqlQuery {
    ProjectDao grantDao=new ProjectDao();
    public ProjectQuery(DataSource ds, String sql){
        super(ds,sql);
    }
    @Override
    protected Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        Project g= new Project();
        g.setProjectId(rs.getInt("project_id"));
        g.setProjectTitle(rs.getString("project_title"));
        g.setProjectTitleLc(rs.getString("project_title_lc"));
        g.setDescription(rs.getString("description"));

        return g;
    }


}
