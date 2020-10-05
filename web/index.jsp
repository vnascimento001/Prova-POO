
<%@page import="java.util.ArrayList"%>
<%@page import="classe.Disciplina"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

  <% ArrayList<Disciplina> disciplina = (ArrayList) application.getAttribute("disciplina");
    if(disciplina == null){
        disciplina = new ArrayList<>();
        disciplina.add(new Disciplina("Banco de Dados","Conceitos de Base de Dados. Modelos conceituais de informações.",4));
        disciplina.add(new Disciplina("Engenharia de Software III","Conceitos, evolução e importância de arquitetura de software.",4));
        disciplina.add(new Disciplina("Programação Orientada a Objetos","Conceitos e evolução da tecnologia de orientação a objetos.",4));
        disciplina.add(new Disciplina("Linguagem de Programação IV","Comandos de linguagens usadas na construção e estruturação de sites.",4));
        disciplina.add(new Disciplina("Sistemas Operacionais II","Apresentação de um sistema operacional específico utilizado em ambiente corporativo.",4));
        disciplina.add(new Disciplina("Segurança da Informação","ttt.",4));
        disciplina.add(new Disciplina("Metodologia da Pesquisa Científico-Tecnológica","O Papel da ciência e da tecnologia. Tipos de conhecimento. Método e técnica.",4));
        application.setAttribute("disciplina", disciplina);
    }
    %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index</title>
    </head>
    <body>
         <%@include file="WEB-INF/menu/menu.jspf"%>
        <h1>P1 POO</h1>
        <h2>Nome: Vinicius da Silva Nascimento</h2>
        <h2>Matrícula: 1290481913036</h2>
        <h2>Cursando <%= Disciplina.getList(disciplina).size() %> disciplinas  </h2>

    </body>
</html>
