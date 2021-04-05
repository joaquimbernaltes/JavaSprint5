package config;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionSql {
    Connection conectar =null;
    public Connection conexion(){

        try{
            Class.forName("com.mysql.jdbc.Driver");
            conectar=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/proiectussprint4","josep","*Deltebre43580");

            JOptionPane.showMessageDialog(null,"Connexio exitosa.");
        }
        catch(Exception e){

            JOptionPane.showMessageDialog(null,"Error de conexio."+ e.getMessage());
        }
            return conectar;

    }

}
