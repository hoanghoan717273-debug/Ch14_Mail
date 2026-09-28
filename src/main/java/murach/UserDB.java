package murach;

import murach.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UserDB {

    private static final String URL =
            "jdbc:sqlserver://HOANPC:1433;"
                    + "databaseName=Chapter14Mail;"
                    + "encrypt=false;"
                    + "trustServerCertificate=true";


    private static final String USERNAME = "sa";

    private static final String PASSWORD = "123456";


    public static void insert(User user)
            throws Exception {

        Class.forName(
                "com.microsoft.sqlserver.jdbc.SQLServerDriver"
        );


        String sql =
                "INSERT INTO EmailList "
                        + "(Email, FirstName, LastName) "
                        + "VALUES (?, ?, ?)";


        try (
                Connection connection =
                        DriverManager.getConnection(
                                URL,
                                USERNAME,
                                PASSWORD
                        );

                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {

            statement.setString(
                    1,
                    user.getEmail()
            );


            statement.setString(
                    2,
                    user.getFirstName()
            );


            statement.setString(
                    3,
                    user.getLastName()
            );


            statement.executeUpdate();
        }
    }
}