<%@page import="java.util.List"%>
<%@page import="holaHibernate.entidades.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
    List<Cliente> clientes = (List<Cliente>) 
            request.getAttribute("listaClientes");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Spring Web MVC Hola Mundo by Vicente Iranzo</title>
    </head>
    <body>
        <p>Hola Mundo by Vicente Iranzo Gómez</p>
        
        <table>
            <p><%=request.getAttribute("mensaje")%></p>    
        <%
            for(Cliente cli : clientes)  {
        %>
        <tr>
            <td><%=cli.getNombre()%></td>
            <td>${cli.nombre}</td>
        </tr>
        <%
            }
        %>
        </table>        
        
        <!-- Utilizando jstl (Java standard tags lib) -->
        <p>${mensaje}</p>
        <table>
            <c:forEach items="${listaClientes}" var="cli">
                <tr>
                  <td><c:out value="${cli.dni}" /></td>
                  <td><c:out value="${cli.nombre}"/></td>
                </tr>
            </c:forEach>
        </table>        
    </body>
</html>
