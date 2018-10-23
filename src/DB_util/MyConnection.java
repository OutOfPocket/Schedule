/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB_util;

/**
 *
 * @author AppleSauce
 */

import java.sql.Connection;
import java.sql.DriverManager;

public class MyConnection {
    
        public static Connection getConnection() {

        Connection con = null;

        try {
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/testDB;create=true");
        }catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return con;
    }
    
}
