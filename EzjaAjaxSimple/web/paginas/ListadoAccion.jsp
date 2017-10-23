<%-- 
    Document   : ListadoAccion
    Created on : 17-ene-2012, 2:39:58
    Author     : asuncionez
--%>


<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.dto.Clientes"%>
<%@page import="modelo.delegate.ClientesDelegate"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de Clientes</title>
        <link rel="stylesheet" type="text/css" href="includes/estilos.css" media="screen"/>
    </head>
    <body>
        <table border="1" style="width:30%;border:solid 1px #000;" class="tabla">
            <tr>
                <td>Clave del Cliente</td>
                <td>Nombre</td>
            </tr>
            <%
                ClientesDelegate del = new ClientesDelegate();
                List lista = del.listarClientes();
                for (int i = 0; i < lista.size(); i++) {
                    Clientes listaCliente = (Clientes) lista.get(i);
            %>
            <tr>
                <td> <%= listaCliente.getClave()%> </td>
                <td> <%= listaCliente.getNombre()%> </td>
            </tr>
            <%
                }


            %>
        </table>
    </body>
</html>
