<%@page import="modelo.dto.EntidadesFederativas"%>
<%@page import="java.util.List"%>
<%@page import="modelo.delegate.ClientesDelegate"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript" src="includes/js/funciones.js"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>

    </head>
    <body>
        <form name="formulario" 
              action="action.jsp" 
              method="POST" 
              id="formulario">
            <div id="estadosDep" class="form-group">
                <table>
                    <tr>
                        <td>
                            Entidad Federativa
                        </td>
                        <td>
                            <select class="form-control"
                                    name="txtEstado" id="estados" 
                                    onchange="procesaMunicipios()">

                                <option value="0" >ELIGE UN ESTADO</option>

                                <%
                                    ClientesDelegate del = new ClientesDelegate();

                                    List lista = del.listaEntidades();
                                    for (int i = 0; i < lista.size(); i++) {
                                        EntidadesFederativas listaCliente
                                                = (EntidadesFederativas) lista.get(i);

                                %>
                                <option 
                                    value="<%= listaCliente.getClaveEstado()%>">
                                    <%= listaCliente.getNombre()%></option>
                                    <%
                                        }
                                    %>

                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Municipio / Delegaci&oacute;n
                        </td>
                        <td>
                            <div id="municipiosDep">

                            </div>
                        </td>
                    </tr>
                </table>






            </div>
        </form>
    </body>
</html>
