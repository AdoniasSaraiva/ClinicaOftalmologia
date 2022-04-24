package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConnectionSingleton {
    private Connection connection;
    private String URL = "jdbc:sqlite:..\\ClinicaOftalmologia\\src\\Resources\\Database\\oftalmologia.db";
    private String user = "root";
    private String password = "";
    private static ConnectionSingleton instancy;
    
    private ConnectionSingleton(){
        try{
            this.connection = DriverManager.getConnection(URL,user,password);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Não conexão");
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }
}
        public static ConnectionSingleton getInstancy(){
            if(instancy == null){
                instancy = new ConnectionSingleton();
            }
            return instancy;
        }
        
        public Connection getConexao(){
            return this.connection;
        }    
    }
