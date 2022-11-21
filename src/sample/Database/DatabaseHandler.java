package sample.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseHandler extends Configs {

    Connection conn;

    public Connection getConnection() throws SQLException {

        String connectionString = "jdbc:mysql://"+ dbHost+":"+dbPort+ "/"+ dbName;

        conn = DriverManager.getConnection(connectionString,dbUser,dbPass);

        return conn;
    }
}
