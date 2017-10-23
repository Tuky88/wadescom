<%@page import="modelo.dto.Municipios"%>
<%@page import="java.util.List"%>
<%@page import="modelo.delegate.ClientesDelegate"%>

<select 
    name="txtMunicipio"
    id="municipios"
    class="form-control">
    <option value="0">ELIGE UN MUNICIPIO</option>
    <%
        int id_estado = Integer.parseInt(request.getParameter("id_estado"));
        if (id_estado != 0) {
            ClientesDelegate del = new ClientesDelegate();

            List lista = del.listaMunicipios(id_estado);
            System.out.println(id_estado);
            System.out.println(del.listaMunicipios(id_estado));
            for (int i = 0; i < lista.size(); i++) {
                Municipios listaCliente = (Municipios) lista.get(i);
                out.print("<option value='" + listaCliente.getCv_municipio() + "'>"
                        + listaCliente.getNombre() + "</option>");

            }
        }
    %>
</select>