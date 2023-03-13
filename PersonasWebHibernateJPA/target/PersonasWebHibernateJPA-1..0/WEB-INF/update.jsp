<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actualizar persona</title>
    </head>
    <body>
        <h1>Actualizar Persona</h1>
        <form action="/PersonasWebHibernateJPA/ServletUpdate" method="POST">
            <label for="nombre">Nombre: </label><input type="text" name="nombre" id="nombre" value="${personaUpd.nombre}">
            <label for="apellido">Apellido: </label><input type="text" name="apellido" id="apellido"  value="${personaUpd.apellido}">
            <label for="email">Email:  </label><input type="text" name="email" id="email" value="${personaUpd.email}">
            <label for="telefono">Telefono: </label><input type="text" name="telefono" id="telefono"  value="${personaUpd.telefono}">
            <input type="hidden" name="idpersona" value="${idPersona}">
            <input type="submit" value="Enviar">
        </form>
    </body>
</html>
