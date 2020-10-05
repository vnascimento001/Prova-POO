<%@page import="java.util.ArrayList"%>
<%@page import="classe.Disciplina"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    
    ArrayList<Disciplina> disciplinas = Disciplina.getList((ArrayList)application.getAttribute("disciplina"));
    
    if(request.getParameter("mudar")!= null){
        int i = Integer.parseInt(request.getParameter("i"));
        double nota = Double.parseDouble(request.getParameter("nota"));
        if(nota >= 0 && nota < 11){
            disciplinas.get(i).setNota(nota);
            response.sendRedirect(request.getRequestURI());
        } else {
 
        }
    }

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Disciplina</title>
    </head>
    <body>
        <%@include file="WEB-INF/menu/menu.jspf"%>
        <h1>P1 POO</h1>
        
                        <table border="1">
            <tr>
                <th>Disciplina</th>
                <th>Ciclo</th>
                <th>Ementa</th>
                <th>Nota</th>
                <th>Mudar Nota</th>
            </tr>
            <%for(int i=0; i<disciplinas.size(); i++){%>
                <% Disciplina disciplina = disciplinas.get(i); %>
                <tr>
                    <td><%= disciplina.getNome() %></td>
                    <td><%= disciplina.getCiclo() %></td>
                    <td><%= disciplina.getEmenta() %></td>
                    <td><%= disciplina.getNota() %></td>
                    <td>
                        <form>
                            <input type="text" name="nota" />
                            <input type="submit" name="mudar" value="Alterar"/>
                            <input type="hidden" name="i" value="<%= i %>"/>
                        </form>
                    </td>
                </tr>
            <%}%>
        </table>
    </body>
</html>
