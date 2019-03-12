package main.java;

import java.sql.*;

public class Main {
    // JDBC driver name and database URL
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/training";

    //  Database credentials
    private static final String USER = "root";
    private static final String PASS = "root";


    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection conn;
        Statement stmt;
        //STEP 2: Register JDBC driver
        Class.forName(JDBC_DRIVER);

        //STEP 3: Open a connection
        System.out.println("Connecting to database...");
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
        stmt = conn.createStatement();
//        createData(stmt);
//        updateData(stmt);
//        deleteData(stmt);
//        readData(stmt);

        //STEP 6: Clean-up environment
        cleanUpEnvironment(stmt, conn);
    }

    //STEP 4: Execute an adding data query
    private static void createData(Statement stmt) throws SQLException {
        System.out.println("Creating a new data...");
        String sq1;
        sq1 = "INSERT INTO child VALUES (6, \"fdsf\", \"dfdfd\", 20);";
        stmt.executeUpdate(sq1);
    }

    //STEP 4.1 Execute an update query
    private static void updateData(Statement stmt) throws SQLException {
        System.out.println("Updating an existing data field");
        String sq2;
        sq2 = ("UPDATE child SET firstName = \"Jenifer\", lastName = \"Smith\"  WHERE id=6");
        stmt.executeUpdate(sq2);
    }

    //STEP 4.2 Execute an delete query
    private static void deleteData(Statement stmt) throws SQLException {
        System.out.println("Deleting and existing data field");
        String sq3;
        sq3 = ("DELETE FROM child WHERE id=6");
        stmt.executeUpdate(sq3);
    }

    //STEP 4.3: Execute a read query
    private static void readData(Statement stmt) throws SQLException {
        System.out.println("Creating statement...");
        String sq4;
        sq4 = "SELECT id, firstName, lastName, age FROM child";
        ResultSet rs = stmt.executeQuery(sq4);

        //STEP 5: Extract data from result set
        while (rs.next()) {
            //Retrieve by column name
            int id = rs.getInt("id");
            String first = rs.getString("firstName");
            String last = rs.getString("lastName");
            int age = rs.getInt("age");

            //Display values
            System.out.print("ID: " + id);
            System.out.print(", FirstName: " + first);
            System.out.print(", LastName: " + last);
            System.out.println(", age: " + age);
        }
        rs.close();
    }

    private static void cleanUpEnvironment(Statement stmt, Connection conn) throws SQLException {
        stmt.close();
        conn.close();
        System.out.println("Goodbye!");
    }
}

