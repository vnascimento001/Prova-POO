package web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import classe.Disciplina;


public class DbListener implements ServletContextListener {
    private static final String CLASS_NAME = "org.sqlite.JDBC";
    private static final String DB_URL = "jdbc:sqlite:C:\\Users\\Vinicius\\Desktop\\tasks-noturno.db";
    
    public static String exceptionMessage = null;
    
    public static Connection getConnection() throws Exception{
        return DriverManager.getConnection(DB_URL);
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Connection con = null;
        Statement stmt = null;
        try{
            Class.forName(CLASS_NAME);
            con = getConnection();
            stmt = con.createStatement();
            stmt.execute(Disciplina.getCreateStatement());
            
        }catch(Exception ex){
            exceptionMessage = ex.getLocalizedMessage();
        }finally{
            try{stmt.close();}catch(Exception ex2){}
            try{con.close();}catch(Exception ex2){}
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}
