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

    public void setNota(double nota) {
        this.nota = nota;
    }
    
    public static ArrayList<Disciplina> getList(){
        ArrayList<Disciplina> mat = new ArrayList<>();
        mat.add(new Disciplina("Banco de Dados","Conceitos de Base de Dados.",4));
        mat.add(new Disciplina("Engenharia de Software III","Conceitos, evolução e importância de arquitetura de software.",4));
        mat.add(new Disciplina("Programação Orientada a Objetos","Conceitos e evolução da tecnologia de orientação a objetos.",4));
        mat.add(new Disciplina("Linguagem de Programação IV","Comandos de linguagens usadas na construção e estruturação de sites.",4));
        mat.add(new Disciplina("Segurança da Informação","Requisitos de segurança de aplicações, de base de dados e de comunicações.",5));
        mat.add(new Disciplina("Metodologia da Pesquisa Científico-Tecnológica","O Papel da ciência e da tecnologia. Tipos de conhecimento. Método e técnica.",4));
        return mat;
    }
}
