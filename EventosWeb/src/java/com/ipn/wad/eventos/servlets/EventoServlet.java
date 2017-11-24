/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.wad.eventos.servlets;

import com.ipn.wad.eventos.dao.EventoDAO;
import com.ipn.wad.eventos.dto.EventoDTO;
import java.io.IOException;
import java.util.Collection;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author darkmac
 */
@WebServlet(name = "EventoServlet", urlPatterns = {"/EventoServlet"})
public class EventoServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion.equals("listaDeEventos")) {
            listaEventos(request, response);
        } else {
            if (accion.equals("nuevo")) {
                agregarEvento(request, response);
            } else {
                if (accion.equals("eliminar")) {
                    eliminarEvento(request, response);
                } else {
                    if (accion.equals("actualizar")) {
                        actualizarEvento(request, response);
                    } else {
                        if (accion.equals("guardar")) {
                            almacenarEvento(request, response);
                        }
                    }
                }
            }
        }
    }

    private void listaEventos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EventoDAO dao = new EventoDAO();
        Collection lista = dao.listar();
        request.setAttribute("listaDeEventos", lista);

        RequestDispatcher vista
                = request.getRequestDispatcher("listaEventos.jsp");
        vista.forward(request, response);
    }

    private void agregarEvento(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher vista
                = request.getRequestDispatcher("eventoForm.jsp");
        vista.forward(request, response);
    }

    private void eliminarEvento(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EventoDAO dao = new EventoDAO();
        EventoDTO dto = new EventoDTO();
        int idEvento = Integer.parseInt(
                request.getParameter("id"));
        dto.getEntidad().setId(idEvento);
        dto.setEntidad( dao.mostrarEvento(dto.getEntidad()));
        dao.borrar(dto.getEntidad());
        listaEventos(request, response);
    }

    private void actualizarEvento(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EventoDAO dao = new EventoDAO();
        EventoDTO dto = new EventoDTO();
        int idEvento = Integer.parseInt(
                request.getParameter("id"));
        dto.getEntidad().setId(idEvento);
        dto.setEntidad( dao.mostrarEvento(dto.getEntidad()));
        
        request.setAttribute("evento", dto.getEntidad());
        RequestDispatcher vista
                = request.getRequestDispatcher("eventoForm.jsp");
        vista.forward(request, response);

    }

    private void almacenarEvento(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EventoDTO dto = new EventoDTO();
        EventoDAO dao = new EventoDAO();
        if (request.getParameter("id") == null
                || request.getParameter("id").isEmpty()) {
            dto.getEntidad().setNombreEvento(
                    request.getParameter("nombreEvento"));
            dto.getEntidad().setDuracion(
                    Double.parseDouble(
                    request.getParameter("duracion")));
            dao.crear(dto.getEntidad());
            listaEventos(request, response);
        } else {
            dto.getEntidad().setId(
                    Integer.parseInt(
                    request.getParameter("id")));
           dto.getEntidad().setNombreEvento(
                    request.getParameter("nombreEvento"));
            dto.getEntidad().setDuracion(
                    Double.parseDouble(
                    request.getParameter("duracion")));
            dao.actualizar(dto.getEntidad());
            listaEventos(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
