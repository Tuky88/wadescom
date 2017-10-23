/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dto;

/**
 *
 * @author asuncionez
 */
public class EntidadesFederativas {

    private int claveEstado;
    private String nombre;


    public EntidadesFederativas() {
    }


    public int getClaveEstado() {
        return claveEstado;
    }

    public void setClaveEstado(int claveEstado) {
        this.claveEstado = claveEstado;
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
        sb.append("clave").append(getClaveEstado()).append("\n");
        sb.append("nombre").append(getNombre()).append("\n");
        return sb.toString();
        
    }
    
    
}
