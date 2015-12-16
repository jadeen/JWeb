package com.jweb.sql;

import java.sql.*;

/**
 * Created by Kevin Marrec on 12/15/2015.
 */
public class SqlManager {

    private static String defaultConnection = "jdbc:sqlite:D:/Projects/JWeb/test.db";

    public static boolean executeUpdate(String query)
    {
        try
        { Class.forName( "org.sqlite.JDBC" ); }
        catch ( ClassNotFoundException e ) { return false; }

        Connection connection = null;

        try
        {
            connection = DriverManager.getConnection(defaultConnection);
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        }
        catch(SQLException e)
        {
            return false;
        }

        finally
        {
            try
            {
                if(connection != null)
                    connection.close();
            }
            catch(SQLException e)
            {
                System.err.println(e);
                return false;
            }
        }
        return true;
    }

    public static ResultSet executeQuery(String query)
    {
        try
        { Class.forName( "org.sqlite.JDBC" ); }
        catch ( ClassNotFoundException e ) { return null; }

        Connection connection = null;
        ResultSet result = null;

        try
        {
            connection = DriverManager.getConnection(defaultConnection);
            Statement statement = connection.createStatement();
            result = statement.executeQuery(query);
        }
        catch(SQLException e)
        {
            return null;
        }

        finally
        {
            try
            {
                if(connection != null)
                    connection.close();
            }
            catch(SQLException e)
            {
                System.err.println(e);
                return null;
            }
        }
        return result;
    }
}
