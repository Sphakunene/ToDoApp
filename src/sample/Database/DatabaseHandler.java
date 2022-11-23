package sample.Database;

import sample.model.Task;
import sample.model.User;

import java.sql.*;

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

    public ResultSet getUser(User user) throws SQLException {

        ResultSet resultSet = null;

        if (!user.getUserName().equals("") && ! user.getPassword().equals("")){

            String query = "SELECT * FROM "+Const.USERS_TABLE+ " WHERE "+ Const.USERS_USERNAME + " = ?" + "" +
                    " AND "+ Const.USERS_PASSWORD +" =?";
            PreparedStatement statement = getConnection().prepareStatement(query);
            statement.setString(1,user.getUserName());
            statement.setString(2,user.getPassword());

            resultSet = statement.executeQuery();

        }
        else{
            System.out.println("Please enter your credentials");
        }

        return resultSet;
    }
    public void insertTask(Task task) throws SQLException {

        String insert = "INSERT" +
                " INTO "+Const.TASKS_TABLE+"("+ Const.TASK_DATE+","+ Const.TASK_DESCRIPTION+","+ Const.TASK_TASK+")"+" VALUES(?,?,?)";
        PreparedStatement statement = getConnection().prepareStatement(insert);
        statement.setLong(1,task.getDatecreated());
        statement.setString(2, task.getDescription());
        statement.setString(3, task.getTask());
        statement.executeUpdate();

    }
}
