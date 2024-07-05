package edu.mcw.scge.dao.implementation;

import edu.mcw.scge.dao.AbstractDAO;

import java.util.Date;

public class FeedbackDao extends AbstractDAO {
    public void insert(String email, String message, String page) throws Exception {

        int id = this.getNextKeyFromSequence("feedback_seq");

        String sql="insert into feedback (date, message, email,page,id) values(?,?,?,?,?)";
        update(sql,new java.sql.Date(new Date().getTime()), message, email, page, id);
    }

}
