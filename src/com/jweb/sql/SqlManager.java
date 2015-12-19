package com.jweb.sql;

import java.sql.*;

/**
 * Created by Kevin Marrec on 12/15/2015.
 */
public class SqlManager {

    private static String defaultConnection = "jdbc:sqlite:JWeb.db";

    private Connection _connection = null;

    private static SqlManager _instance = null;

    protected SqlManager() {
        initDatabase();
    }

    public static SqlManager getInstance() {
        if(_instance == null) {
            _instance = new SqlManager();
        }
        return _instance;
    }

    private void initDatabase()
    {
        openConnection();

        String articlesTable = "CREATE TABLE IF NOT EXISTS " + "`Articles`"
                + "  (`IdArticle` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
                + "   `Title` VARCHAR(150) NOT NULL,"
                + "   `Content` TEXT NOT NULL,"
                + "   `IdUser` INTEGER NOT NULL)";

        execute(articlesTable);

        closeConnection();
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

    public boolean execute(String query)
    {
        if (_connection == null)
            return false;

        try
        {
            Statement statement = _connection.createStatement();
            statement.execute(query);
            return true;
        }
        catch(SQLException e)
        {
            System.err.println(e);
            return false;
        }
    }

    public int executeUpdate(String query)
    {
        if (_connection == null)
            return -1;

        try
        {
            Statement statement = _connection.createStatement();
            return statement.executeUpdate(query);
        }
        catch(SQLException e)
        {
            System.err.println(e);
            return -1;
        }
    }

    public ResultSet executeQuery(String query)
    {
        if (_connection == null)
            return null;

        try
        {
            Statement statement = _connection.createStatement();
            return statement.executeQuery(query);
        }
        catch(SQLException e)
        {
            System.err.println(e);
            return null;
        }
    }
}
