package classe;

import java.util.ArrayList;

/**
 *
 * @author Computador
 */
public class Disciplina {
    public String nome;
    public String ementa;
    public int ciclo;
    public int nota;
    
    
    public Disciplina(String nome, String ementa, int ciclo) {
        this.nome = nome;
        this.ementa = ementa;
        this.ciclo = ciclo;
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

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }
   
    public static ArrayList getList(){
        ArrayList<Disciplina> dList = new ArrayList();
        dList.add(new Disciplina("Materia1", "Ementa", 4));

        return dList;
        
    }   
}
