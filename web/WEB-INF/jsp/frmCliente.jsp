<%-- 
    Document   : frmCliente
    Created on : 27-abr-2014, 18:39:55
    Author     : Vicente
--%>

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
            <input class="disabled" id="dni" name="dni" type="text" 
                   value="${cliente.dni}" readonly="readonly">
            <label for="nombre">Nombre:</label>
            <input id="nombre" name="nombre" type="text"  
                   value="${cliente.nombre}" >
            <label for="ape1">Primer Apellido:</label>
            <input id="ape1" type="text" name="ape1" 
                   value="${cliente.ape1}" >
            <label for="ape2">Segundo Apellido:</label>
            <input id="ape2" type="text" name="ape2" 
                   value="${cliente.ape2}" >
            <label for="nick">Nick:</label>
            <input id="nick" type="text" name="nick" 
                   value="${cliente.nick}" >
            <div class="botones">
                <input type="submit" value="Guardar">
                <input type="button" value="Cancelar" 
                       onclick="location.href='${pageContext.request.contextPath}/index.html'">
            </div>
     </form>
    </body>
</html>
