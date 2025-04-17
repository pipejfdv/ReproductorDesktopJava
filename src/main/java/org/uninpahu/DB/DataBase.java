package org.uninpahu.DB;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataBase {
    private static final String url = "jdbc:mysql://localhost:3306/SpotifyDB";
    private static final String usuario = "root";
    private static final String contrasena = "ProgramadorDB";
            

    public static Connection getConnection() {
        /*
         * Establece y devuelve una conexión a la base de datos utilizando las credenciales
         * almacenadas en el archivo config.properties.
         *
         * El método realiza las siguientes operaciones:
         *
         *  - Carga las propiedades de conexión desde config.properties
         *  - Registra el driver JDBC de MySQL
         *  - Establece la conexión usando DriverManager
         *
         *
         * @return Un objeto Connection válido si la conexión es exitosa, null en caso de error
         * @throws RuntimeException implícita si ocurren errores al cargar el driver o las propiedades
         *
         * @see DriverManager
         * @see Properties
         *
         *
         * @implNote El archivo config.properties debe contener:
         *
         * db.url=jdbc:mysql://host:puerto/nombre_bd
         * db.user=usuario
         * db.password=contraseña
         *
         */
        Connection conexion = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url,usuario,contrasena);
            System.out.println("Conexion exitosa");
        }catch(ClassNotFoundException ex){
            System.out.println("DRIVER FALLO Clase no encontrada ");
            ex.printStackTrace();
        }catch(SQLException ex){
            System.out.println("Error de conexion ");
            ex.printStackTrace();
        }
        return conexion;
    }

    public static void closeConnection(Connection conexion) {
        /*
        * Está función se encarga de cerrar la conexión de la base de datos despues de haber
        * realizado la consulta correspondiente.
        *
        * Es realiza una validación si el objeto "conexion" no este vació
        */
        if (conexion != null) {
            try {
                conexion.close();
                System.out.println("Conexion cerrada exitosamente");
            }
            catch (SQLException e) {
                System.out.println("No se ha podido cerrar conexion");
            }
        }
    }
}
