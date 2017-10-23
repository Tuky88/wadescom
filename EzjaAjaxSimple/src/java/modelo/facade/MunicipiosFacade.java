/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.facade;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import modelo.dao.MunicipiosDAO;

/**
 *
 * @author asuncionez
 */
public class MunicipiosFacade {
   private Connection cnn;
    private MunicipiosDAO dao ;


    public MunicipiosFacade(Connection cnn) {
        this.cnn = cnn;
        dao = new MunicipiosDAO();
    }
    
    public List mostrarTodo(int id) throws SQLException{
        return dao.readAll(id, cnn);
    }

   
}
