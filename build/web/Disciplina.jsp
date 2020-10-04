<%@page import="java.util.ArrayList"%>
<%@page import="classe.Disciplina"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Disciplina teste = new Disciplina("teste","testre",5);

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Disciplina</title>
    </head>
    <body>
        <%@include file="WEB-INF/menu.jspf"%>
        <h1>P1 POO</h1>
        <table border="1">
            <tr>
                <th>Disciplina</th>
                <th>Ciclo</th>
                <th>Nota</th>
<               %for(int i=0; i<Disciplina.size(); i++){%>
                <th><%=Disciplina.getList() %></th>
                </tr>
 
    </body>
</html>
