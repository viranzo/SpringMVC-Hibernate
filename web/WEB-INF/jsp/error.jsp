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
        <title>Página de errores</title>
    </head>
    <body>
         <div class="error">
             <p>${mensaje}</p>
         <div>
        <a href="${pageContext.request.contextPath}/index.html">Volver al inicio</a>
    </body>
</html>
