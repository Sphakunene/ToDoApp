package sample.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseHandler extends Configs {

    Connection conn;


    public Connection getConnection() throws SQLException {

        String connectionString = "jdbc:mysql://"+ dbHost+":"+dbPort+ "/"+ dbName;

        conn = DriverManager.getConnection(connectionString,dbUser,dbPass);

        return conn;
    }
    public void signUpUser(String firstName, String lastName, String userName,String password,String location, String gender) throws SQLException {
        String insert = "INSERT" +
                " INTO"+Const.USERS_TABLE+"("+ Const.USERS_FIRTSNAME+","+ Const.USERS_LASTNAME+","+ Const.USERS_USERNAME+","+Const.USERS_PASSWORD
                +","+ Const.USERS_LOCATION+","+ Const.USERS_GENDER+")"+" VALUES(?,?,?,?,?,?)";
        PreparedStatement statement = getConnection().prepareStatement(insert);
    }
}
