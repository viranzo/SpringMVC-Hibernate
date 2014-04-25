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
        <style type="text/css">
            h1 { text-align: center; color: #385e98;}
            table { width: 80%;margin: 0 auto;border: 1px solid #009999; border-radius: 4px;}
            td {padding: 0 5px;}
            th{  background-color: #0066ff; color: #fff;}
            tr:nth-child(odd) {  background-color: #def;}
            tr:nth-child(even) {  background-color: #fff;}
            .num{ text-align: right;}
        </style>

    </head>
    <body>
        <h1>${mensaje}</h1>
        <table>
            <tr>
                <th>dni</th>
                <th>nombre</th>
                <th>ape1</th>
                <th>ape2</th>
                <th>nick</th>
            </tr>
            <c:forEach items="${listaClientes}" var="cli">
                <tr>
                    <td class="num"><c:out value="${cli.dni}" /></td>
                    <td><c:out value="${cli.nombre}"/></td>
                    <td><c:out value="${cli.ape1}"/></td>
                    <td><c:out value="${cli.ape2}"/></td>
                    <td><c:out value="${cli.nick}"/></td>
                </tr>
            </c:forEach>
        </table>        
    </body>
</html>
