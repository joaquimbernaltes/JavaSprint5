/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Ximo
 */
public class Conexio {
    Connection con;
    public Conexio(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            //Intentar fer la conexió
            String user = "josep";
            String psswd = "*Deltebre43580";
            String URL = "jdbc:mysql://localhost:3306/proiectussprint4";
            con=DriverManager.getConnection(URL,user,psswd);
            JOptionPane.showMessageDialog(null, "Connexió realitzada");
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error connexió " + e.getMessage());
        }
    }
    public Connection getConnection(){
        return con;
    }
    
}
