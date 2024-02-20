package KhalidSir;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class DatabaseOperations extends Portal{
    public static void createTable( Statement statement) throws SQLException {
        String createTableSQL = "CREATE TABLE student_marks (" +
                "enrollment VARCHAR2(20) PRIMARY KEY, " +
                "course1 NUMBER, " +
                "course2 NUMBER, " +
                "course3 NUMBER, " +
                "course4 NUMBER, " +
                "course5 NUMBER)";
        statement.executeUpdate(createTableSQL);

        System.out.println("Table 'student_marks' created successfully.");
    }

    static void menu(Connection connection, Statement statement) throws SQLException{
        int i = Integer.parseInt(JOptionPane.showInputDialog(null, "_________MENU________\n"+
                                                                    "1<--New Registration\n"+
                                                                    "2<--DeleteRow\n"+
                                                                    "3<--Update\n"+
                                                                    "4<--View Details\n"+
                                                                    "5<--View List\n"+
                                                                    "6<--Exit\n"+
                                                                    "Enter the corresponding serial number: ", 
                                                                    "MENU", 3));
        switch(i){
        case 1:
            insertValues(connection);
            menu(connection,statement); 
        break;
        case 2:
            deleteRow(connection);
            menu(connection,statement); 
        break;
        case 3:
            update(connection);
            menu(connection,statement); 
        break;
        case 4:
            viewDetails(connection);
            menu(connection,statement); 
        break;
        case 5:
            printResultSet(connection);
            menu(connection,statement); 
        break;
        case 6:
            connection.close();
            JOptionPane.showMessageDialog(null,"EXITED", "MENU", 1);
        break;
        default:
            JOptionPane.showMessageDialog(null,"Invalid Input!", "MENU", 0);
            menu(connection,statement); 
        }
    }

    public static void insertValues(Connection connection) throws SQLException {//case:1
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO student_marks VALUES (?, ?, ?, ?, ?, ?)");

        String enrollmentString = JOptionPane.showInputDialog(null, "Enter enrollment: ", "Enter the details for a single student", 3);
        int course1 = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter course1 marks: ", "Enter the details for a single student", 3));
        int course2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter course2 marks: ", "Enter the details for a single student",3));
        int course3 = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter course3 marks: ", "Enter the details for a single student",3));
        int course4 = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter course4 marks: ", "Enter the details for a single student",3));
        int course5 = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter course5 marks: ", "Enter the details for a single student", 3));

        preparedStatement.setString(1, enrollmentString);
        preparedStatement.setInt(2, course1);
        preparedStatement.setInt(3, course2);
        preparedStatement.setInt(4, course3);
        preparedStatement.setInt(5, course4);
        preparedStatement.setInt(6, course5);
        // Execute the insert statement
        preparedStatement.executeUpdate();
        JOptionPane.showMessageDialog(null, "Student added.\n", "Registration", 1);
        
        printResultSet(connection);
        preparedStatement.close();
    }

    static void deleteRow(Connection connection) throws SQLException{ //case:2
        String queryString = "DELETE FROM student_marks WHERE enrollment = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(queryString);

        String enrollmentString = JOptionPane.showInputDialog(null, "Enter Student Enrollment Number: ", "Updation of student attribute.", 1);

        preparedStatement.setString(1,enrollmentString);

        preparedStatement.executeUpdate();
        printResultSet(connection);
        preparedStatement.close();
    }

    static void update(Connection connection) throws SQLException{ //case:3
        String enrollmentString = JOptionPane.showInputDialog(null, "Enter Student Enrollment Number: ", "Updation of student attribute.", 1);
        String columnToupdate= JOptionPane.showInputDialog(null, "Enter attribute to change: \n-->enrollment\n-->course1\n-->course2\n-->course3\n-->course4\n-->course5", "Updation", 3);
        String newValueString= JOptionPane.showInputDialog(null, "Enter new value: ", "Updation", 3);
        
        String queryString = "UPDATE student_marks SET "+columnToupdate+" = ?  WHERE enrollment = ?" ;

        PreparedStatement queryPreparedStatement = connection.prepareStatement(queryString);
        queryPreparedStatement.setString(1,newValueString);
        queryPreparedStatement.setString(2,enrollmentString);

        queryPreparedStatement.executeUpdate();
        printResultSet(connection);
    }

    static void viewDetails(Connection connection) throws SQLException{ //case:4
        String queryString = "SELECT * FROM student_marks WHERE enrollment = ?" ;
        PreparedStatement queryPreparedStatement = connection.prepareStatement(queryString);
        String enrollmentString = JOptionPane.showInputDialog(null, "Enter Student Enrollment Number: ", "Updation of student attribute.", 1);
        queryPreparedStatement.setString(1,enrollmentString);
        ResultSet resultSet = queryPreparedStatement.executeQuery();
        printResultSet(resultSet);
    }
    
    public static void printResultSet(Connection connection) throws SQLException {//case:5
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM student_marks");
        ResultSet resultSet = preparedStatement.executeQuery();
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columns = metaData.getColumnCount();
        // Print header
        for (int i = 1; i <= columns; i++) {
            System.out.printf("%-15s", metaData.getColumnName(i));
        }
        System.out.println();
        // Print data
        while (resultSet.next()) {
            for (int i = 1; i <= columns; i++) {
                System.out.printf("%-15s", resultSet.getString(i));
            }
            System.out.println();
        }
        preparedStatement.close();
    }
    
    public static void printResultSet(ResultSet resultSet) throws SQLException {
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columns = metaData.getColumnCount();
        // Print header
        for (int i = 1; i <= columns; i++) {
            System.out.printf("%-15s", metaData.getColumnName(i));
        }
        System.out.println();
        // Print data
        while (resultSet.next()) {
            for (int i = 1; i <= columns; i++) {
                System.out.printf("%-15s", resultSet.getString(i));
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        final String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:XE";
        final String USERNAME = "system";
        final String PASSWORD = "123123";
        try {
            Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            // createTable(statement);
            menu(connection, statement);
        } catch (Exception e) {
            
        }
    }
}
