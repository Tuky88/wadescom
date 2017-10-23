/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dto;

/**
 *
 * @author asuncionez
 */
public class Municipios {
    private int cv_municipio;
    private String nombre;
    private int cv_entidad;

    public Municipios() {
    }

    public int getCv_entidad() {
        return cv_entidad;
    }

    public void setCv_entidad(int cv_entidad) {
        this.cv_entidad = cv_entidad;
    }

    public int getCv_municipio() {
        return cv_municipio;
    }

    public void setCv_municipio(int cv_municipio) {
        this.cv_municipio = cv_municipio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("id_mun").append(getCv_municipio()).append("\n");
        sb.append("nombre").append(getNombre()).append("\n");
        sb.append("id").append(getCv_entidad()).append("\n");
        return sb.toString();
    }
    
    
}
