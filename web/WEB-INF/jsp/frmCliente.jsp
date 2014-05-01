<%-- 
    Document   : frmCliente
    Created on : 27-abr-2014, 18:39:55
    Author     : Vicente
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario de Cliente</title>
        <link href="${pageContext.request.contextPath}/css/estilos.css" rel="stylesheet">
    </head>
    <body>
        
        <form action="${urlAction}" method="post" >
            <p class="titulo">Formulario de Cliente</p>
            <div class="error">
                <p>${mensaje}</p>
            <div>
            <label for="DNI">DNI:</label>
            <input id="dni" name="DNI" type="text" value="${cliente.dni}" >
            <label for="Nombre">Nombre:</label>
            <input id="nombre" name="Nombre" type="text" value="${cliente.nombre}" >
            <label for="Ape1">Primer Apellido:</label>
            <input id="ape1" type="text" name="Ape1" value="${cliente.ape1}" >
            <label for="Ape2">Segundo Apellido:</label>
            <input id="ape2" type="text" name="Ape2" value="${cliente.ape2}" >
            <label for="Nick">Nick:</label>
            <input id="nick" type="text" name="Nick" value="${cliente.nick}" >
            <label for="Passwd">passwd:</label>
            <input id="passwd" type="text" name="Passwd" value="${cliente.passwd}" >
            <div class="botones">
                <c:if test="${cliente.dni !=null}" >
                    <input class="btn btn-primary" type="button" value="Eliminar"
                           onclick="location.href='Eliminar.html?id=${cliente.dni}'">
                </c:if>    
                <input class="btn btn-primary" type="submit" value="Guardar">
                <input class="btn btn-primary" type="button" value="Cancelar" 
                       onclick="location.href='${pageContext.request.contextPath}/index.html'">
            </div>
     </form>
    </body>
</html>
