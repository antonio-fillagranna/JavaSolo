// This program assumes directory cujosql exists.
import java.sql.*;
import javax.sql.*;
import javax.naming.*;

public class AccessPropertyTest {
    public String url = "jdbc:db2:*local";
    public Connection connection = null;

    public static void main(java.lang.String[] args) 
    throws Exception
    {
        AccessPropertyTest test = new AccessPropertyTest();

        test.setup();

        test.run();
        test.cleanup();
    }


/**
Set up the DataSource used in the testing.
**/
    public void setup()
    throws Exception
    {
        connection = DriverManager.getConnection(url);
        Statement s = connection.createStatement();
        try {
            s.executeUpdate("DROP TABLE CUJOSQL.TEMP");
        } catch (SQLException e) { // Ignore it - it doesn't exist
        }

        try {
            String sql = "CREATE PROCEDURE CUJOSQL.TEMP "
                  + " LANGUAGE SQL SPECIFIC CUJOSQL.TEMP "
                  + " MYPROC: BEGIN"
                  + "   RETURN 11;"
                  + " END MYPROC";
            s.executeUpdate(sql);
        } catch (SQLException e) {
            // Ignore it - it exists.
        }
        s.executeUpdate("create table cujosql.temp (col1 char(10))");
        s.executeUpdate("insert into cujosql.temp values ('compare')");
        s.close();
    }


    public void resetConnection(String property)
    throws SQLException
    {
        if (connection != null)
            connection.close();

        connection = DriverManager.getConnection(url + ";access=" + property);
    }


    public boolean canQuery() {
        Statement s = null;
        try {
            s = connection.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM cujosql.temp");
            if (rs == null)
                return false;

            rs.next();

            if (rs.getString(1).equals("compare   "))
                return true;

            return false;

        } catch (SQLException e) {
            // System.out.println("Exception: SQLState(" +
            //                    e.getSQLState() + ") " + e + " (" + e.getErrorCode() + ")");
            return false;
        } finally {
            if (s != null) {
                try { 
                    s.close();
                } catch (Exception e) {
                    // Ignore it.
                }
            }
        }
    }


    public boolean canUpdate() {
        Statement s = null;
        try {
            s = connection.createStatement();
            int count = s.executeUpdate("INSERT INTO CUJOSQL.TEMP VALUES('x')");
            if (count != 1)
                return false;
                
            return true;

        } catch (SQLException e) {
            //System.out.println("Exception: SQLState(" +
            //                   e.getSQLState() + ") " + e + " (" + e.getErrorCode() + ")");
            return false;
        } finally {
            if (s != null) {
                try { 
                    s.close();
                } catch (Exception e) {
                    // Ignore it.
                }
            }
        }
    }


    public boolean canCall() {
        CallableStatement s = null;
        try {
            s = connection.prepareCall("? = CALL CUJOSQL.TEMP()");
            s.registerOutParameter(1, Types.INTEGER);
            s.execute();
            if (s.getInt(1) != 11)
                return false;
                
            return true;

        } catch (SQLException e) {
            //System.out.println("Exception: SQLState(" +
            //                   e.getSQLState() + ") " + e + " (" + e.getErrorCode() + ")");
            return false;
        } finally {
            if (s != null) {
                try { 
                    s.close();
                } catch (Exception e) {
                    // Ignore it.
                }
            }
        }
    }


    public void run()
    throws SQLException
    {
        System.out.println("Set the connection access property to read only");
        resetConnection("read only");

        System.out.println("Can run queries  -->" + canQuery());
        System.out.println("Can run updates  -->" + canUpdate());
        System.out.println("Can run sp calls -->" + canCall());

        System.out.println("Set the connection access property to read call");
        resetConnection("read call");

        System.out.println("Can run queries  -->" + canQuery());
        System.out.println("Can run updates  -->" + canUpdate());
        System.out.println("Can run sp calls -->" + canCall());

        System.out.println("Set the connection access property to all");
        resetConnection("all");

        System.out.println("Can run queries  -->" + canQuery());
        System.out.println("Can run updates  -->" + canUpdate());
        System.out.println("Can run sp calls -->" + canCall());

    }


    public void cleanup() {
        try {
            connection.close();
        } catch (Exception e) {
            // Ignore it.
        }
    }
}