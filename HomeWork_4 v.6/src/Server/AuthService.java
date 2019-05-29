package Server;

import java.sql.*;

public class AuthService {

    private static Connection connection;
    private static Statement statement;

    public static void connect() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:DBusers.db");
            statement = connection.createStatement();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void disconnect(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static String getNickByAuthorization(String login, String pass){
        String sql = String.format("SELECT nickname FROM users WHERE login = '%s' and password = '%s' ", login, pass);

        try {
            ResultSet resultSet = statement.executeQuery(sql);

            if(resultSet.next()){
                return resultSet.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
