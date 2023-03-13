<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Listado de personas</title>
    </head>
    <body>
        <h1>Listado de personas</h1>
        
        <table border="1">
            <caption>Listado de Personas</caption>
            <tr>
                <th>Id Persona</th>
                <th>Nombre></th>
                <th>Apellido</th>
                <th>Emali</th>
                <th>Telefono</th>
            </tr>
            <c:forEach var="persona" items="${personas}">
                <tr>
                <td>${persona.idPersona}</td>
                <td>${persona.nombre}</td>
                <td>${persona.apellido}</td>
                <td>${persona.email}</td>
                <td>${persona.telefono}</td>
                <td><button><a href="/PersonasWebHibernateJPA/ServletUpdate?idPersona=${persona.idPersona}">Actualizar</a></button></td>
                <td><button onclick="confirmar()"><a href="/PersonasWebHibernateJPA/ServletDelete?idPersona=${persona.idPersona}">Eliminar</a></button></td>
                </tr>
            </c:forEach>
        </table>
    </body>
<script>
function confirmar() {
  if (confirm("¿Seguro que deseas eliminar a la persona?")) {
    // Si el usuario hace clic en "Aceptar"
    alert("¡Usuario eliminado!");
  } else {
    // Si el usuario hace clic en "Cancelar"
    alert("Cancelado");
  }
}
</script>

</html>
