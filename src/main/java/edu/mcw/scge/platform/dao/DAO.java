package edu.mcw.scge.platform.dao;

import java.sql.Connection;

/**
 * Created by jthota on 8/16/2019.
 */
public interface DAO {

    public Connection getConnection() throws Exception;
}

