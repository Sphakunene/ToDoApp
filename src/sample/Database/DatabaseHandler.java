package sample.Database;

import sample.model.User;

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
    public void signUpUser(User user) throws SQLException {
        String insert = "INSERT" +
                " INTO "+Const.USERS_TABLE+"("+ Const.USERS_FIRSTNAME+","+ Const.USERS_LASTNAME+","+ Const.USERS_USERNAME+","+Const.USERS_PASSWORD
                +","+ Const.USERS_LOCATION+","+ Const.USERS_GENDER+")"+" VALUES(?,?,?,?,?,?)";
        PreparedStatement statement = getConnection().prepareStatement(insert);
        statement.setString(1,user.getFirstName());
        statement.setString(2,user.getLastName());
        statement.setString(3,user.getUserName());
        statement.setString(4,user.getPassword());
        statement.setString(5,user.getLocation());
        statement.setString(6,user.getGender());
        statement.executeUpdate();

    }

    public boolean isUserLoggedIn(User user) throws SQLException {

        if (!user.getUserName().equals("") && ! user.getPassword().equals("")){

            String query = "SELECT * FROM "+Const.USERS_TABLE+ " WHERE "+ Const.USERS_USERNAME + " = ?" + "" +
                    " AND "+ Const.USERS_PASSWORD +" =?";
            PreparedStatement statement = getConnection().prepareStatement(query);
            statement.setString(1,user.getUserName());
            statement.setString(2,user.getPassword());

        }

        return false;
    }
}
