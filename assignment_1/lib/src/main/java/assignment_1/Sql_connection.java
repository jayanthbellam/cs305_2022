package assignment_1;
import java.sql.*;

public class Sql_connection{

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/sakila";

    // Database credentials
    static final String USER = "root";
    static final String PASS = "mysql";

    public static void main(String args[]) {
        Connection dbCon = null;
        Statement stmt = null;
        ResultSet rs = null;

        try{
            try{
                Class.forName(JDBC_DRIVER);
            }
            catch (Exception exception){
                System.out.println("Erorrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr yeaha h!");
                exception.printStackTrace();
            }
            //getting database connection to MySQL server
            dbCon = DriverManager.getConnection(DB_URL, USER, PASS);

            //getting PreparedStatment to execute query
            stmt = dbCon.createStatement();

            //Resultset returned by query
            rs = stmt.executeQuery("select * from payment limit 1;");
//            
            while (rs.next()) {
                int payment_id = rs.getInt(1);
                System.out.println("payment_id : " + payment_id);
            }
        }
        catch(SQLException e){
            System.out.println(e);
        }
        finally{
            //close connection ,stmt and resultset here
            try{
                rs.close();
                stmt.close();
                dbCon.close();
            }
            catch(Exception e){
                System.out.println("Error while closing connections: "+e);
            }
            finally{
                System.out.println("Database Connection closed");
            }
        }
    }
}