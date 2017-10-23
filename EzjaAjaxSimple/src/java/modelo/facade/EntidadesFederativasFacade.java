/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.facade;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import modelo.dao.EntidadesFederativasDAO;

/**
 *
 * @author asuncionez
 */
public class EntidadesFederativasFacade {
   private Connection cnn;
    private EntidadesFederativasDAO dao ;


    public EntidadesFederativasFacade(Connection cnn) {
        this.cnn = cnn;
        dao = new EntidadesFederativasDAO();
    }
    
    public List mostrarTodo() throws SQLException{
        return dao.readAll(cnn);
    }

   
}
