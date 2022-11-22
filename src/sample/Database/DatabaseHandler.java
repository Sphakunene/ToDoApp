package sample.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseHandler extends Configs {

    Connection conn;


    public Connection getConnection() throws SQLException {

        String connectionString = "jdbc:mysql://"+ dbHost+":"+dbPort+ "/"+ dbName+"?verifyServerCertificate=false&useSSL=true";

        conn = DriverManager.getConnection(connectionString,dbUser,dbPass);

        return conn;
    }
    public void signUpUser(String firstName, String lastName, String userName,String password,String location, String gender) throws SQLException {
        String insert = "INSERT" +
                " INTO "+Const.USERS_TABLE+"("+ Const.USERS_FIRSTNAME+","+ Const.USERS_LASTNAME+","+ Const.USERS_USERNAME+","+Const.USERS_PASSWORD
                +","+ Const.USERS_LOCATION+","+ Const.USERS_GENDER+")"+" VALUES(?,?,?,?,?,?)";
        PreparedStatement statement = getConnection().prepareStatement(insert);
        statement.setString(1,firstName);
        statement.setString(2,lastName);
        statement.setString(3,userName);
        statement.setString(4,password);
        statement.setString(5,location);
        statement.setString(6,gender);
        statement.executeUpdate();

    }
}
