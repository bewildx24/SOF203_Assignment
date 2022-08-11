package poly.edu.repository;

import java.sql.*;

/**
 *
 * @author Vũ Nguyên Hướng
 */
public class DBContext {

    public static void main(String[] args) throws SQLException {
        Connection connection = getConnection();
        DatabaseMetaData data = connection.getMetaData();
        String productName = data.getDatabaseProductName();
        String productVersion = data.getDatabaseProductVersion();
        System.out.println("Database: " + productName);
        System.out.println("Version: " + productVersion);
    }
    private static final String USERNAME = "sa";
    private static final String PASSWORD = "123";
    private static final String SERVER = "localhost";
    private static final String PORT = "1433";
    private static final String DATABASE_NAME = "FPL_DAOTAO";
    private static final boolean USING_SSL = true;

    private static String CONNECT_STRING;

    static {
        try {

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            StringBuilder sb = new StringBuilder();
//            jdbc:sqlserver://localhost:1433;databaseName=FPL_DAOTAO;username=sa;password=123;encrypt=true;trustServerCertificate=true
            sb.append("jdbc:sqlserver://")
                    .append(SERVER).append(":").append(PORT).append(";")
                    .append("databaseName=").append(DATABASE_NAME).append(";")
                    .append("user=").append(USERNAME).append(";")
                    .append("password=").append(PASSWORD).append(";");
            if (USING_SSL) {
                sb.append("encypt=true;trustServerCertificate=true;");
            }
            CONNECT_STRING = sb.toString();
            System.out.println("Connect String có dạng: " + CONNECT_STRING);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(CONNECT_STRING);
    }
}
