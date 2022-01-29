package irimi.springrestdemo.test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DbConnectionTest")
public class DbConnectionCheck
        extends HttpServlet {

    private static final long SERIAL_VERSION_UID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String dbUserName = "spring_rest_demo_user_name";
        String dbUserPassword = "spring_rest_demo_user_password";
        String dbUrl = "jdbc:mysql://localhost:3306/spring_rest_demo?useSSL=false&serverTimezone=UTC";
        String dbDriver = "com.mysql.cj.jdbc.Driver";

        try {
            System.out.println("Connecting to database...");
            Class.forName(dbDriver);
            Connection dbConnection = DriverManager.getConnection(dbUrl, dbUserName, dbUserPassword);
            System.out.println("Connecting to database... success!");
            dbConnection.close();
        } catch (Exception exception) {
            exception.printStackTrace();
            throw new ServletException(exception);
        }
    }
}
