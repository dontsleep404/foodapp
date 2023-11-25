package dontsleep.application.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class DatabaseManager {
    private static Connection connection;
    public static Connection getConnection() {
        return connection;
    }
    public static boolean connectDatabase(){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/foodapp", "root", "");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public static void closeDatabase(){
        try {
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static ResultSet executeQuery(String query, Object... params){
        try{
            var preparedStatement = connection.prepareStatement(query);
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i+1, params[i]);
            }
            return preparedStatement.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public static boolean executeUpdate(String query, Object... params){
        try{
            var preparedStatement = connection.prepareStatement(query);
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i+1, params[i]);
            }
            return preparedStatement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
