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
import modelo.dto.Municipios;

/**
 *
 * @author asuncionez
 */
public class MunicipiosDAO {
    public static final String SQL_LOAD_ALL="SELECT * FROM cat_municipio where cv_entidad=?";
    
    public List readAll(int id, Connection cnn)throws SQLException{
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps = cnn.prepareStatement(SQL_LOAD_ALL);
            ps.setInt(1, id);
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
            Municipios dto = new Municipios();
            dto.setCv_municipio(rs.getInt("cv_municipio"));
            dto.setNombre(rs.getString("nombre"));
            dto.setCv_entidad(rs.getInt("cv_entidad"));
            
           
            results.add(dto);
        }
        return results;
    }
}
