<%-- 
    Document   : UsuariosAccion
    Created on : 17-ene-2012, 1:28:33
    Author     : asuncionez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.dto.Clientes"%>
<%@page import="modelo.delegate.ClientesDelegate"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
      
        <%
             ClientesDelegate del = new ClientesDelegate();
             Clientes dto= new Clientes();
             dto.setClave(Integer.parseInt(request.getParameter("claveDelCliente")));
             dto.setNombre(request.getParameter("nombreDelCliente"));
             del.crearCliente(dto);
             out.print("Exito");
        %>
    </body>
</html>
