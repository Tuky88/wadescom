/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.dao;

import com.ipn.mx.entidad.Rol;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author darkmac
 */
public class RolDAO {

    private static final String SQL_INSERT
            = "insert into roles(nombre) values (?)";
    private static final String SQL_UPDATE
            = "update roles set nombre = ? where id =?";
    private static final String SQL_DELETE
            = "delete from roles where id =?";
    private static final String SQL_SELECT
            = "select * from roles where id =?";
    private static final String SQL_SELECT_ALL
            = "select * from roles";

    private Connection con;

    private void obtenerConexion() {
        try {
            Class.forName(
                    "com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/demobd",
                    "root", "admin");
        } catch (ClassNotFoundException
                | SQLException ex) {
            ex.printStackTrace();
        }

    }

    public void create(Rol rol) {
        obtenerConexion();
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(SQL_INSERT);
            ps.setString(1, rol.getNombre());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {

                }
            }
        }
    }

    public List<Rol> readAll() {
        obtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Rol> resultados = new ArrayList<>();
        try {
            ps = con.prepareStatement(SQL_SELECT_ALL);
            rs = ps.executeQuery();
            resultados = obtenerResultados(rs);
            if (resultados.size() > 0) {
                return resultados;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //Liberar los recursos
        }
        return resultados;
    }

    private List<Rol> obtenerResultados(ResultSet rs) throws SQLException {
        List<Rol> resultados = new ArrayList<>();
        while (rs.next()) {
            Rol r = new Rol();
            r.setId(rs.getInt("id"));
            r.setNombre(rs.getString("nombre"));
            resultados.add(r);
        }
        return resultados;
    }

    public static void main(String[] args) {
        RolDAO d = new RolDAO();
        Rol r = new Rol();
        r.setNombre("x cosa");

        d.create(r);
        System.out.println(d.readAll());
    }
}
