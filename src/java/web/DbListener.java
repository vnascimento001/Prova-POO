/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
        String etapa = "Inicialização";
        Connection con = null;
        Statement stmt = null;
        try{
            etapa = "Registro a classe do driver";
            Class.forName(CLASS_NAME);
            etapa = "Conectar com o banco de dados";
            con = getConnection();
            etapa = "Preparando o statement";
            stmt = con.createStatement();
            etapa = "Criar a tabela de disciplinas";
            stmt.execute(Disciplina.getCreateStatement());
            etapa = "Desconectar do banco de dados";
        }catch(Exception ex){
            exceptionMessage = etapa+": "+ex.getLocalizedMessage();
        }finally{
            try{stmt.close();}catch(Exception ex2){}
            try{con.close();}catch(Exception ex2){}
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}
