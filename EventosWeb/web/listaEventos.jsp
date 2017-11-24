<%-- 
    Document   : listaEventos
    Created on : 24-nov-2017, 11:32:59
    Author     : darkmac
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" 
          prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table>
            <tr>
                <th>
                    clave del evento
                </th>
                <th>
                    nombre del evento
                </th>
                <th>
                    duracion del evento
                </th>
                <th colspan="2">
                    Acciones
                </th>
            </tr>
            <c:forEach var="eventos"
                       items="${listaDeEventos}">
                <tr>
                    <td>
                <c:out value="${eventos.id}"/>
                </td>
                <td>
                <c:out value="${eventos.nombreEvento}"/>
                </td>
                <td>
                <c:out value="${eventos.duracion}"/>
                </td>
                <td>
                    <a href="EventoServlet?accion=eliminar&id=${eventos.id}">
                        Eliminar
                    </a>
                </td>
                <td>
                    <a href="EventoServlet?accion=actualizar&id=${eventos.id}">
                        Actualizar
                    </a>
                </td>
                </tr>
            </c:forEach>
        </table>
        <a href="EventoServlet?accion=nuevo">
            Agregar Evento
        </a>
    </body>
</html>
