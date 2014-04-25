<%-- 
    Document   : listaClientes.jsp
    Created on : 25-abr-2014, 22:04:17
    Author     : Vicente

    Utilizando : EL (Expesion Lenguaje) y
                 JSTL (Java standard tags lib) 
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>hola JSTL</title>
    </head>
    <body>
         
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
