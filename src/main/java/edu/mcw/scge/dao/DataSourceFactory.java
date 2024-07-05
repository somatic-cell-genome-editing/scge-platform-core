package edu.mcw.scge.dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 * Created by jthota on 8/16/2019.
 */
public class DataSourceFactory {
    private static DataSourceFactory dsf=new DataSourceFactory();
    private DataSourceFactory(){}
    public static DataSourceFactory getInstance(){return dsf;}
    public DataSource getDataSource() throws Exception {
        return getDataSource("scgeplatform");
    }
    public DataSource getDataSource(String domain) throws Exception{

        try{
            if (System.getProperty("spring.config") != null && !System.getProperty("spring.config").equals("")) {
                return (DataSource) (XmlBeanFactoryManager.getInstance().getBean(domain+"DataSource"));
            }else {
                Thread l_thread = Thread.currentThread();
                l_thread.setContextClassLoader(this.getClass().getClassLoader());
                Context initContext = new InitialContext();
                Context envContext  = (Context)initContext.lookup("java:/comp/env");
                String jdniContext = domain.isEmpty() ? "jdbc/scgeplatform" : "jdbc/"+domain.toLowerCase();
                return (DataSource)envContext.lookup(jdniContext);
            }
        }catch (Exception e){
            e.printStackTrace();
            return (DataSource) (XmlBeanFactoryManager.getInstance().getBean(domain+"DataSource"));
        }
    }

}
