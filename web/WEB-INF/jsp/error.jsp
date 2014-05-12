<%-- 
    Document   : error
    Created on : 27-abr-2014, 21:31:15
    Author     : Vicente
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="${pageContext.request.contextPath}/css/estilos.css" rel="stylesheet">
        <title>Página de error</title>
    </head>
    <body>
        <div class="error wrapper">
            <p>${mensaje}</p>
            <div>
                <a class="btn btn-primary" 
                   href="${pageContext.request.contextPath}/index.html">Volver al Inicio</a>
            </div>
        </div>
    </body>
</html>
