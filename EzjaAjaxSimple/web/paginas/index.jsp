<%-- 
    Document   : clientes
    Created on : 17-ene-2012, 1:26:40
    Author     : asuncionez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ezja Ajax Simple</title>
        <script language="javascript" src="includes/js/funciones.js"></script>
        <link rel="stylesheet" type="text/css" href="../includes/estilos.css" media="screen"/>
    </head>
    <body>
    <center> 
        <form name="frmClientes" action="EntidadesFederativas.jsp" method="post">
            <table style="width:30%;border:solid 1px #000;" class="tabla">
                <tr>
                    <th>
                        Clave del Cliente:
                    </th>
                    <td>
                        <input type="text" name="txtClave" id="txtClave" class="caja" placeholder="algo"/>
                    </td>
                </tr>
                <tr>
                    <th>
                        Nombre del Cliente:
                    </th>
                    <td>
                        <input type="text" name="txtNombre" id="txtNombre" class="caja" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="button" name="Agrega" value="Agregar Cliente" onclick="agregaClientes()" />
                    </td>
                    <td>
                        <input type="button" name="Listar" value="Listado Cliente" onclick="listaClientes()" />
                    </td>
                </tr>
            </table>
        </form>
    </center>
</body>
</html>