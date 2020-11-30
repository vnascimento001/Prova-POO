<%-- 
    Document   : Disciplina
    Created on : 5 de out de 2020, 11:08:55
    Author     : Computador
--%>
<%@page import="classe.Disciplina"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
   String exceptionMessage = null;
    
    if(request.getParameter("Cancelar")!=null){
        response.sendRedirect(request.getRequestURI());
    }
    
    if(request.getParameter("formInsert")!=null){
    try{
        String nome = request.getParameter("nome");
        String ementa = request.getParameter("descricao");
        int ciclo = Integer.parseInt(request.getParameter(""));
        double nota = Double.parseDouble(request.getParameter("d"));
        Disciplina.insert(nome, ementa, ciclo, nota);
        response.sendRedirect(request.getRequestURI());
    }catch(Exception ex){
        exceptionMessage = ex.getLocalizedMessage();
    }  
      
}
    
    if(request.getParameter("FormDelete")!=null){
    try{
        String nome = request.getParameter("nome");
        Disciplina.delete(nome); 
        response.sendRedirect(request.getRequestURI());   
    }catch(Exception ex){
        exceptionMessage = ex.getLocalizedMessage();
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
                
         <form>
            <input type="text" placeholder="Disciplina" name="nome">
            <input type="text" placeholder="Ementa" name="ementa">
            <input type="number" placeholder="Ciclo" name="ciclo">
            <input type="submit" name="cria" value="Criar">
        </form>
        <table border="1">
            <tr>
                <th>Nome</th>
                <th>Ementa</th>
                <th>Ciclo</th>
                <th>Nota</th>
                <th>Editar Nota</th>
                <th>Ação</th>
            </tr>
            <% for(Disciplina disciplina : Disciplina.getList()){ %>
                <tr>
                    <td><%=disciplina.getNome()%></td>
                    <td><%=disciplina.getEmenta()%></td>
                    <td><%=disciplina.getCiclo()%></td>
                    <td><%=disciplina.getNota()%></td>
                    <td>
                        <form>
                            <input type="hidden" name="id" value="<%=disciplina.getNome()%>">
                            <input type="number" name="nota" required>
                            <input type="submit" name="nt" value="Alterar">
                        </form> 
                    </td>
                    <td>
                        <form>
                            <input type="hidden" name="id" value="<%=disciplina.getNome()%>">
                            <input type="submit" name="excluir" value="Excluir">
                        </form> 
                    </td>
                </tr>
            <% } %>
        </table>
    </body>
</html>
