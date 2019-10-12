/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classactivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author 1895915
 */
@Path("generic")
public class Myapp {

   
    @GET
    @Path("mypath")
    @Produces(MediaType.APPLICATION_JSON)
    public String getXml1() {
        String department_name;
              int department_id,manager_id,location_id;
        try {
              Class.forName("oracle.jdbc.OracleDriver");
              Connection con= DriverManager.getConnection("jdbc:oracle:thin:@144.217.163.57:1521:XE", "hr", "inf5180");
              Statement st= con.createStatement();
              String sql= "SELECT * FROM DEPARTMENTS";
              ResultSet rs = st.executeQuery(sql);
              
              while(rs.next())
              {
               department_id=rs.getInt("department_id");
               department_name=rs.getString("department_name");
               manager_id=rs.getInt("manager_id");
               location_id=rs.getInt("location_id");
              } 
            }
        catch (ClassNotFoundException ex) {
            Logger.getLogger(Myapp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Myapp.class.getName()).log(Level.SEVERE, null, ex);
        }
          return " ";
    }

   
  
}
