package edu.mcw.scge.dao.implementation;

import edu.mcw.scge.datamodel.Person;
import edu.mcw.scge.dao.AbstractDAO;
import edu.mcw.scge.dao.spring.ProjectQuery;
import edu.mcw.scge.dao.spring.PersonQuery;
import edu.mcw.scge.dao.spring.StringListQuery;
import edu.mcw.scge.datamodel.Project;

import java.util.List;

public class ProjectDao extends AbstractDAO {
    public void insert(Project g) throws Exception {
        String sql="insert into projects (project_id, project_title, project_title_lc) values(?,?,?)";
        update(sql,g.getProjectId(), g.getProjectTitle(), g.getProjectTitleLc());
    }
    public Project getProjectByTitle(String title) throws Exception {
        String sql="select * from projects where project_title_lc=?" ;
        ProjectQuery q=new ProjectQuery(this.getDataSource(), sql);
        List<Project> grantList=execute(q, title);
        return (grantList!=null && grantList.size()>0)?grantList.get(0):null;
    }

    public Project getProjectById(int projectId) throws Exception {
        String sql="select * from projects where project_id=?" ;
        ProjectQuery q=new ProjectQuery(this.getDataSource(), sql);
        List<Project> grantList=execute(q, projectId);
        return (grantList!=null && grantList.size()>0)?grantList.get(0):null;
    }

}
