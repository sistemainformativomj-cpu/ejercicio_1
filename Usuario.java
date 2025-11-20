package Usuario;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Usuario {

    public static void main(String[] args) throws SQLException {

        String usuario = "root";
        String password = "";
        String url = "jdbc:mysql://localhost:3306/cuentas";

        Connection conexion;
        Statement statement;
        ResultSet rs;

       
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver cargado correctamente.");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {

      
            conexion = DriverManager.getConnection(url, usuario, password);
            System.out.println("Conexión exitosa.");

            statement = conexion.createStatement();

      
            try {
                statement.executeUpdate(
                    "UPDATE paciente SET apellido='Ramírez' WHERE idPaciente='123456789'"
                );
                System.out.println("Paciente actualizado.");
            } catch (SQLException e) {
                System.out.println("Error UPDATE: " + e.getMessage());
            }

        } catch (SQLException sQLException) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, sQLException);
        }
    }
}

    

