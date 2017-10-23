/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dto;

/**
 *
 * @author asuncionez
 */
public class Clientes {

    private int clave;
    private String nombre;

    public Clientes() {
    }

    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Clave = ").append(getClave()).append("\n");
        sb.append("Nombre = ").append(getNombre()).append("\n");
        return sb.toString();
    }
}
