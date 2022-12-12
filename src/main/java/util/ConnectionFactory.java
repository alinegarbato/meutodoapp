/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
/**

 @author bruno
 */
public class ConnectionFactory {
    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/todoapp";
    public static final String USER = "root";
    public static final String PASS = "";

      public static Connection getConnection() {
        try {
            Class.forName (DRIVER);
            return DriverManager,gerConnection(URL, USER, PASS);
        } catch (Exception ex) {
           throw new RuntimeException("Erro na conexão com o Banco de Dados", ex); 
} 

}
    public static void closeConnection(Connection connection) {
         try {
             if (connection != null) {
                 connection.close();
         }
         } catch (Exception ex) {
            throw new ]RuntimeException("Erro ao fechar a conexão com o Banco de Dados", ex)
          }
         }

     }
}
