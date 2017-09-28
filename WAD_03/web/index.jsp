<%-- 
    Document   : index
    Created on : 28-sep-2017, 14:38:18
    Author     : darkmac
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <center>
        <fieldset>
            <legend>Envio de Correos Electr&Oacute;nicos</legend>
            <form method="post" action="MailServlet">
                <table>
                    <tr>
                        <td>
                            Destinatario
                        </td>
                        <td>
                            <input id="txtDestinatario" 
                                   name="txtDestinatario"
                                   type="text" 
                                   placeholder="coreo@destinatario.com"
                                   required="required" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="txtAsunto">
                                Asunto
                            </label>
                        </td>
                        <td>
                            <input id="txtAsunto" 
                                   name="txtAsunto"
                                   type="text" 
                                   placeholder="Asunto del Correo"
                                   required="required" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="txtTexto">
                                Mensaje
                            </label>
                        </td>
                        <td>
                            <textarea id="txtTexto" name="txtTexto" rows="6" cols="20" wrap="hard">
                            </textarea>
                        </td>
                    </tr>
                    
                    <tr>
                        <td colspan="2" >
                            <input id="boton" type="submit" value="Enviar" />
                        </td>
                    </tr>
                </table>
            </form>
        </fieldset>
    </center>
</body>
</html>
