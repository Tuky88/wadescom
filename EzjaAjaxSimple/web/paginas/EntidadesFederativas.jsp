<%@page import="modelo.dto.EntidadesFederativas"%>
<%@page import="java.util.List"%>
<%@page import="modelo.delegate.ClientesDelegate"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript" src="../includes/js/funciones.js"></script>
    </head>
    <body>
        <form name="formulario" action="action.jsp" method="POST" id="formulario">
            <div id="estadosDep">
                <select name="txtEstado" id="estados" onchange="procesaMunicipios()">
                    <option value="0" >ELIGE UN ESTADO</option>

                    <%
                        ClientesDelegate del = new ClientesDelegate();

                        List lista = del.listaEntidades();
                        for (int i = 0; i < lista.size(); i++) {
                            EntidadesFederativas listaCliente = (EntidadesFederativas) lista.get(i);

                    %>
                    <option value="<%= listaCliente.getClaveEstado()%>"><%= listaCliente.getNombre()%></option>
                    <%
                        }
                    %>

                </select>

                Municipio / Delegaci&oacute;n
                <div id="municipiosDep">
                    
                </div>

            </div>
        </form>
    </body>
</html>
