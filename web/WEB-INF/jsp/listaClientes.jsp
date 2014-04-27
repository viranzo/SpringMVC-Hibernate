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
        <title>Lista de clientes utilizando EL y JSTL</title>
        <link href="css/estilos.css" rel="stylesheet">
    </head>
    <body>
        <div class="wrapper">
            <h1>Listado de clientes</h1>
            <div >
               <a id="btnNuevo" href="Cliente/Nuevo.html">Nuevo Cliente</a>
            </div>
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
                        <td class="num">
                            <a href="${pageContext.request.contextPath}/Cliente/Editar.html?dni=${cli.dni}" 
                               />${cli.dni}</a>   
                        </td>
                        <td>${cli.nombre}</td>
                        <td>${cli.ape1}</td>
                        <td>${cli.ape2}</td>
                        <td>${cli.nick}</td>
                    </tr>
                </c:forEach>
            </table>       
        </div>
    </body>
</html>
