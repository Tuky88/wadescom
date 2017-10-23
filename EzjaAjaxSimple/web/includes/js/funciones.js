/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 *  Author     : asuncionez
*/
function nuevoAjax(){
    xmlhttp=false;
    this.encodeURIString = true;
    this.execute = false;
    if (window.XMLHttpRequest) {
        this.xmlhttp = new XMLHttpRequest();
        if (this.xmlhttp.overrideMimeType) {
            this.xmlhttp.overrideMimeType('text/xml');
        }
    }
    else if (window.ActiveXObject) {
        try {
            this.xmlhttp = new ActiveXObject("Msxml2.XMLHTTP");
        }catch (e) {
            try {
                this.xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
            } catch (e) {
                this.xmlhttp = null;
            }
        }
        if (!this.xmlhttp && typeof XMLHttpRequest!='undefined') {
            this.xmlhttp = new XMLHttpRequest();
            if (!this.xmlhttp){
                this.failed = true;
            }
        }
    }
    return this.xmlhttp;
}

function procesaPost(destino,parametros,mensaje){
    var ajax=ezjaAjax();
    var capaContenedora=document.getElementById('respuesta');
    ajax.open ('POST',destino, true);
    ajax.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    ajax.setRequestHeader("Content-length", parametros.length);
    ajax.setRequestHeader("Connection", "close");

    ajax.onreadystatechange = function() {
        if (ajax.readyState==1) {
            capaContenedora.innerHTML="<b><font face='Arial' size='2'>"+mensaje+"</font></b>";
        }
        else if (ajax.readyState==4){
            if(ajax.status==200){
                capaContenedora.innerHTML=ajax.responseText;
            }
            else if(ajax.status==404){
                capaContenedora.innerHTML = "<center>\n\
                    <br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><b><font face='Arial' size='2'>La direcci&oacute;n no existe.</font></b></center>";
            }
            else{
                capaContenedora.innerHTML = "Error: "+ajax.status;
            }
        }
    }
    ajax.send(parametros);
}

function agregaClientes(){
    parametros="claveDelCliente=" + encodeURI(document.getElementById("txtClave").value)+
    "&nombreDelCliente=" + encodeURI(document.getElementById("txtNombre").value);
    procesaPost("UsuariosAccion.jsp",parametros,"Agregando Cliente...");
    document.getElementById("txtClave").value="";
    document.getElementById("txtNombre").value="";
    
}
function listaClientes(){
    parametros="";
    procesaPost("ListadoAccion.jsp",parametros,"Listando Clientes...");
}

/*
function actualizaUsuario(){
    parametros="Usuario=" + encodeURI(document.getElementById("Usuario").value)+
    "&Password=" + encodeURI(document.getElementById("Password").value);
    procesaPost("UsuariosAccion.php?accion=actualizar",parametros,"Actualizando usuario...");
}

function eliminaUsuario(){
    parametros="Usuario=" + encodeURI(document.getElementById("Usuario").value);
    procesaPost("UsuariosAccion.php?accion=eliminar",parametros,"Actualizando usuario...");
}*/


function procesa(destino, capa, tipo){
    var ajax=nuevoAjax();
    var capaContenedora=document.getElementById(capa);

    ajax.open ('POST',destino, true);
    ajax.setRequestHeader('Content-Type','application/x-www-form-urlencoded');
    ajax.onreadystatechange = function() {
        if (ajax.readyState==1) {
            capaContenedora.innerHTML="buscando...";
        }
        else if (ajax.readyState==4){
            if(ajax.status==200){
                capaContenedora.innerHTML=ajax.responseText;
            }
            else if(ajax.status==404){
                capaContenedora.innerHTML = "<center><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><b><font face='Arial' size='2'>La direcci&oacute;n no existe.</font></b></center>";               
            }
            else{
                capaContenedora.innerHTML = "Error: "+ajax.status;
            }
        }
    }
    ajax.send(null);
}

/**
 * Procesa municipios
 */
function procesaMunicipios() {
    destino = 'listaMunicipios.jsp?id_estado=' 
            +document.getElementById('estados').value;
    procesa(destino,'municipiosDep','div');
}

