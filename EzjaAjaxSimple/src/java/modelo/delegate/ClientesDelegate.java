/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.delegate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import modelo.dto.Clientes;
import modelo.facade.EntidadesFederativasFacade;
import modelo.facade.MunicipiosFacade;

/**
 *
 * @author asuncionez
 */
public class ClientesDelegate {

    private Connection cnn;
    private EntidadesFederativasFacade entFedFacade;
    private MunicipiosFacade muniFacade;

    public ClientesDelegate() {
        String user = "root";
        String pwd = "admin";
        String url = "jdbc:mysql://localhost:3306/entidadesFederativas";
        String mySqlDriver = "com.mysql.jdbc.Driver";
        try {
            Class.forName(mySqlDriver);
            cnn = DriverManager.getConnection(url, user, pwd);
            //DataSource ds = getDataSource("db/test");
            //cnn = getConnection(ds);
        } catch (Exception e) {
            e.printStackTrace();
        }
        entFedFacade = new EntidadesFederativasFacade(cnn);
        muniFacade = new MunicipiosFacade(cnn);
    }

  

    //Para Entidades Federativas
    public List listaEntidades() throws SQLException {
        return entFedFacade.mostrarTodo();
    }

    public List listaMunicipios(int id) throws SQLException {
        return muniFacade.mostrarTodo(id);
    }

    public static void main(String[] args) {
        ClientesDelegate del = new ClientesDelegate();
        try {
            System.out.println(del.listaMunicipios(9));
        } catch (SQLException ex) {
            Logger.getLogger(ClientesDelegate.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Data Sourse
    private DataSource getDataSource(String dataSourceLocation) throws NamingException {
        // Get a context for the JNDI look up
        Context ctx = new InitialContext();
        Context envContext = (Context) ctx.lookup("java:/comp/env");

        // Look up a data source
        javax.sql.DataSource ds = (javax.sql.DataSource) envContext.lookup(dataSourceLocation);

        return ds;
    }

    private Connection getConnection(DataSource ds) throws SQLException {
        Connection conn = null;
        // Get a connection object
        conn = ds.getConnection();

        return conn;
    }
}
