package classe;

import java.util.ArrayList;


public class Disciplina {
    private String nome;
    private String ementa;
    private int ciclo;
    private double nota;
    
    
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

    public double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public static ArrayList<Disciplina> getList(ArrayList disciplinas){ 
        ArrayList<Disciplina> mat = disciplinas;
    return mat;
    }
    
}
