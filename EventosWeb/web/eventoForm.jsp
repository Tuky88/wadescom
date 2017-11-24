<%-- 
    Document   : eventoForm
    Created on : 24-nov-2017, 11:34:04
    Author     : darkmac
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <fieldset>
            <legend>Datos del Evento</legend>
            <form name="eventoForm" method="post"
                  action="EventoServlet?accion=guardar">
                <table>
                    <tr>
                        <td>
                            id Evento
                        </td>
                        <td>
                            <input type="text"
                                   name="id"
                                   readonly
                                   value="<c:out value="${evento.id}"/>"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            nombre Evento
                        </td>
                        <td>
                            <input type="text"
                                   name="nombreEvento"   
                                   value="<c:out value="${evento.nombreEvento}"/>"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            duracion Evento
                        </td>
                        <td>
                            <input type="text"
                                   name="duracion"   
                                   value="<c:out value="${evento.duracion}"/>"/>
                        </td>
                    </tr>
                    <tr>

                        <td colspan="2">
                            <input type="submit"
                                   name="enviar"   
                                   value="Enviar"/>
                        </td>
                    </tr>
                </table>
            </form>
        </fieldset>
    </body>
</html>
