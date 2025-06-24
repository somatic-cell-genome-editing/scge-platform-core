package edu.mcw.scge.dao.spring.ctd;

import edu.mcw.scge.datamodel.ctd.Section;
import org.springframework.jdbc.object.MappingSqlQuery;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SectionQuery extends MappingSqlQuery<Section> {

    public SectionQuery(DataSource ds, String sql){
        super(ds,sql);
    }
    @Override
    protected Section mapRow(ResultSet rs, int rowNum) throws SQLException {
        Section section=new Section();
        section.setSectionId(rs.getInt("section_id"));
        section.setSectionCode(rs.getString("section_code"));
        section.setSectionName(rs.getString("section_name"));
        section.setParentId(rs.getString("parent_id"));
        section.setLevel(rs.getInt("level"));
        section.setModuleCode(rs.getInt("module"));
        section.setRequiredForInitialIND(rs.getString("required_initial_ind"));
        section.setNotes(rs.getString("notes"));
        section.setSectionDescription(rs.getString("description"));
        section.setExampleLinkText(rs.getString("example_link_text"));
        section.setTemplateLinkText(rs.getString("template_link_text"));
        section.setResources(rs.getString("resources"));
        section.setSubmissionFormat(rs.getString("submission_format"));
        section.setSubmissionTiming(rs.getString("submission_timing"));
        section.setRequiredForMarketingApplicationOnly(rs.getString("required_for_marketing_application"));
        return section;
    }
}
