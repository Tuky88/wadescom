/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.wad.eventos.dto;

import com.ipn.wad.eventos.entidades.Evento;
import java.io.Serializable;

/**
 *
 * @author darkmac
 */
public class EventoDTO implements Serializable{
    private Evento entidad = new Evento();

    public EventoDTO() {
    }

    
    public EventoDTO(Evento entidad) {
        this.entidad = entidad;
    }

    public Evento getEntidad() {
        return entidad;
    }

    public void setEntidad(Evento entidad) {
        this.entidad = entidad;
    }
    
    
    
}
