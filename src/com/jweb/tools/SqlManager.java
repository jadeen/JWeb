package com.jweb.tools;

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
                + "   `date` DATE NOT NULL,"
                + "   `IdUser` INTEGER NOT NULL)";

        execute(articlesTable);

        String usersTable = "CREATE TABLE IF NOT EXISTS "+ "`Users`"
                + "(`IdUser` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
                + "`Nom` VARCHAR(40) NOT NULL,"
                + "`Prenom` VARCHAR(40) NOT NULL,"
                + "`Mail` VARCHAR(150) NOT NULL,"
                + "`Login` VARCHAR(15) NOT NULL,"
                + "`Password` VARCHAR(33) NOT NULL,"
                + "`Admin` int(1) DEFAULT (0))";

        execute(usersTable);

        String newsletterTable = "CREATE TABLE IF NOT EXISTS "+ "`Newsletters`"
                + "(`IdNewsletter` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
                + "`Mail` VARCHAR(150) NOT NULL)";

        execute(newsletterTable);

        String opinionTable = "CREATE TABLE IF NOT EXISTS "+ "`Opinions`"
                + "(`IdOpinion` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
                + "`IdUser` INTEGER NOT NULL,"
                + "`Opinion` TEXT NOT NULL)";

        execute(opinionTable);

        closeConnection();
    }

    public PreparedStatement prepareStatement(String sql){
        if (_connection == null){
            return null;
        }

        try {
            return _connection.prepareStatement(sql);
        }
        catch (SQLException e){
            System.err.println(e);
            return null;
        }
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


    public ResultSet executeQuery(PreparedStatement preparedStatement)
    {
        if (_connection == null)
            return null;

        try
        {
            return preparedStatement.executeQuery();
        }
        catch(SQLException e)
        {
            System.err.println(e);
            return null;
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

    public boolean execute(PreparedStatement preparedStatement){
        if (_connection == null){
            return false;
        }

        try {
            preparedStatement.execute();
            return true;
        }
        catch (SQLException e){
            System.err.println(e);
            System.out.println("pas d'erreur");
            return false;
        }
    }
}
