<%-- 
    Document   : Disciplina
    Created on : 5 de out de 2020, 11:08:55
    Author     : Computador
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="classe.Disciplina"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    ArrayList<Disciplina> mat = (ArrayList<Disciplina>)application.getAttribute("mat");
    if(mat==null){
        mat = Disciplina.getList();
        application.setAttribute("mat", mat);
    }
    
    Exception requestException = null;
    if(request.getParameter("mudar")!=null){
     try{
         int i = Integer.parseInt(request.getParameter("i"));
         double nota = Double.parseDouble(request.getParameter("nota"));
         mat.get(i).setNota(nota);
         response.sendRedirect(request.getRequestURI());
     }catch(Exception ex){
            requestException = ex;
            }
    }

%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
                <%@include file="WEB-INF/menu/menu.jspf"%>
        <%if(requestException!=null){ %>
        <div style="color:red">Erro ao alterar nota</div>
        <%}%>
        <table border="1">
            <tr>
                <th>Disciplina</th>
                <th>Ciclo</th>
                <th>Ementa</th>
                <th>Nota</th>
                <th>Mudar nota</th>
            </tr>
            <%for(int i=0; i<mat.size(); i++){%>
                <tr>  
                    <td><%= mat.get(i).getNome() %></td>
                    <td><%= mat.get(i).getCiclo() %></td>
                    <td><%= mat.get(i).getEmenta() %></td>
                    <td><%= mat.get(i).getNota() %></td>
                    <td>
                        <form>
                            <input type="number" name="nota" />
                            <input type="submit" name="mudar" value="Alterar"/>
                            <input type="hidden" name="i" value="<%= i %>"/>
                        </form>
                    </td>
                </tr>
            <%}%>
        </table>
    </body>
</html>
