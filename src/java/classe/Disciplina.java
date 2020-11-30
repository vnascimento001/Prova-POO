package classe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import web.DbListener;

public class Disciplina {
    private String nome;
    private String ementa;
    private int ciclo;
    private int nota;
    
    public Disciplina(){
    
    }

    public Disciplina(String nome, String ementa, int ciclo, int nota) {
        this.nome = nome;
        this.ementa = ementa;
        this.ciclo = ciclo;
        this.nota = nota;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmenta() {
        return ementa;
    }

    public void setEmenta(String ementa) {
        this.ementa = ementa;
    }

    public int getCiclo() {
        return ciclo;
    }

    public void setCiclo(int ciclo) {
        this.ciclo = ciclo;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }
   
    
        public static ArrayList<Disciplina> getList() throws Exception{
        ArrayList<Disciplina> list = new ArrayList<>();
        Connection con = null; Statement stmt = null; ResultSet rs = null;
        Exception methodException = null;
        try{
            con = DbListener.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM disciplinas");
            
            while(rs.next()){
                list.add(new Disciplina(
                        rs.getString("nome"),
                        rs.getString("ementa"),
                        rs.getInt("ciclo"),
                        rs.getInt("nota")
                ));
            }
        }catch(Exception ex){
            methodException = ex;
        }finally{
            try{rs.close();}catch(Exception ex2){}
            try{stmt.close();}catch(Exception ex2){}
            try{con.close();}catch(Exception ex2){}
        }
        if(methodException!=null) throw methodException;
        return list;
    }

        public static void insert(String nome, String ementa, int ciclo, double nota) throws Exception{
        Connection con = null; PreparedStatement stmt = null; ResultSet rs = null;
        Exception methodException = null;
        try{
            con = DbListener.getConnection();
            stmt = con.prepareStatement("INSERT INTO disciplinas(nome, ementa, ciclo, nota) values(?,?,?,?)");
            stmt.setString(1, nome);
            stmt.setString(2, ementa);
            stmt.setInt(3, ciclo);
            stmt.setDouble(4, nota);
            stmt.execute();
        }catch(Exception ex){
            methodException = ex;
        }finally{
            try{rs.close();}catch(Exception ex2){}
            try{stmt.close();}catch(Exception ex2){}
            try{con.close();}catch(Exception ex2){}
        }
        if(methodException!=null) throw methodException;
    }

        public static void delete(String nome) throws Exception{
        Connection con = null; PreparedStatement stmt = null; ResultSet rs = null;
        Exception methodException = null;
        try{
            con = DbListener.getConnection();
            stmt = con.prepareStatement("DELETE FROM disciplinas WHERE nome=?");
            stmt.setString(1, nome);
            stmt.execute();

        }catch(Exception ex){
            methodException = ex;
        }finally{
            try{rs.close();}catch(Exception ex2){}
            try{stmt.close();}catch(Exception ex2){}
            try{con.close();}catch(Exception ex2){}
        }
        if(methodException!=null) throw methodException;
    }
    
    public static String getCreateStatement(){
        return "CREATE TABLE IF NOT EXISTS disciplinas("
                    +"nome VARCHAR(100) PRIMARY KEY,"
                    +"ementa VARCHAR(200) NOT NULL,"
                    +"ciclo INTEGER NOT NULL,"
                    +"nota INTEGER DEFAULT 0"
                +")";
    }
}
