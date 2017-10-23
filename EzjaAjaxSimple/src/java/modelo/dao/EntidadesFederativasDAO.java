/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.dto.EntidadesFederativas;

/**
 *
 * @author asuncionez
 */
public class EntidadesFederativasDAO {
    /*
     function readall($complemento) {
        $conexion = parent::conecta();
        mysql_select_db(parent::getDb_name(),$conexion) or die("No se encuentra la base de datos: " . mysql_error());

        $sql="select  * from cat_entidad ".$complemento;
        return mysql_query($sql,$conexion);
    }
     */
    
    public static final String SQL_LOAD_ALL="select  * from cat_entidad";
    
    public List readAll(Connection cnn)throws SQLException{
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps = cnn.prepareStatement(SQL_LOAD_ALL);
            rs = ps.executeQuery();
            List results = getResults(rs);
            if (results.size() > 0) {
                return results;
            } else {
                return null;
            }
        }finally{
            
        }
    }
    
     private List getResults(ResultSet rs) throws SQLException {
        List results = new ArrayList();
        while (rs.next()) {
            EntidadesFederativas dto = new EntidadesFederativas();
            dto.setClaveEstado(rs.getInt("cv_entidad"));
            dto.setNombre(rs.getString("nombre"));
           
            results.add(dto);
        }
        return results;
    }
}
