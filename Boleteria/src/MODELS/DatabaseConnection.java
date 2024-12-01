/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELS;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author Manuel
 */
public class DatabaseConnection {
    private static DatabaseConnection instance; // Instancia única
    private Connection connection;

    private DatabaseConnection() {
        try {
            // Cargar el archivo de configuración
            Properties properties = new Properties();
            FileInputStream input = new FileInputStream("config.properties");
            properties.load(input);

            // Leer propiedades del archivo
            String url = properties.getProperty("db.url");
            String user = properties.getProperty("db.user");
            String password = properties.getProperty("db.password");

            // Crear la conexión
            this.connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión establecida con la base de datos.");

        } catch (IOException | SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
            throw new RuntimeException("Error al conectar a la base de datos.", e);
        }
    }

    // Método estático para obtener la instancia única
    public static DatabaseConnection getInstance() {
        if (instance == null) {
            synchronized (DatabaseConnection.class) {
                if (instance == null) {
                    instance = new DatabaseConnection();
                }
            }
        }
        return instance;
    }

    // Obtener la conexión
    public Connection getConnection() {
        return connection;
    }
}
