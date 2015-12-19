package com.jweb.sql;

import java.sql.*;

/**
 * Created by Kevin Marrec on 12/15/2015.
 */
public class SqlManager {

    private static String defaultConnection = "jdbc:sqlite:D:/Projects/JWeb/JWeb.db";

    private Connection _connection = null;

    private static SqlManager _instance = null;
    protected SqlManager() {
        // Exists only to defeat instantiation.
    }
    public static SqlManager getInstance() {
        if(_instance == null) {
            _instance = new SqlManager();
        }
        return _instance;
    }

    public boolean openConnection()
    {
        try
        {
            Class.forName( "org.sqlite.JDBC" );
            _connection = DriverManager.getConnection(defaultConnection);
        }
        catch ( ClassNotFoundException e )
        {
            System.err.println(e);
            return false;
        }
        catch ( SQLException e )
        {
            System.err.println(e);
            return false;
        }

        return true;
    }

    public boolean closeConnection()
    {
        try
        {
            if(_connection != null)
                _connection.close();
        }
        catch(SQLException e)
        {
            System.err.println(e);
            return false;
        }

        return true;
    }

    public boolean executeUpdate(String query)
    {
        if (_connection == null)
            return false;

        try
        {
            Statement statement = _connection.createStatement();
            statement.executeUpdate(query);
        }
        catch(SQLException e)
        {
            System.err.println(e);
            return false;
        }

        return true;
    }

    public ResultSet executeQuery(String query)
    {
        if (_connection == null)
            return null;

        ResultSet result;

        try
        {
            Statement statement = _connection.createStatement();
            result = statement.executeQuery(query);
        }
        catch(SQLException e)
        {
            System.err.println(e);
            return null;
        }

        return result;
    }
}
