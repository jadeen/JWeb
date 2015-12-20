package com.jweb.module;

import com.jweb.sql.SqlManager;

import javax.servlet.http.HttpSession;
import java.sql.ResultSet;

/**
 * Created by mickael on 12/19/2015.
 */
public class User {
    public String _login;

    private String _id;

    private String _nom;

    private String _prenom;

    public String _password;

    private String _mail;

    private Boolean _connected = false;

    private HttpSession _session;

    public User(HttpSession session){
        _session = session;
        _login = (String) session.getAttribute("login");
        if (_login == null){
            _connected = false;
            return ;
        }
        _connected = true;
    }

    public String get_id() {
        return _id;
    }

    public Boolean getUserData(){
        SqlManager sm = SqlManager.getInstance();

        sm.openConnection();

        ResultSet res = sm.executeQuery("SELECT * FROM Users WHERE Login = '"+_login+"'");

        try {
            if (!res.next()){
                throw new Exception("utilisateur non trouvé");
            }
            _nom = res.getString("Nom");
            _prenom = res.getString("Prenom");
            _password = res.getString("Password");
            _mail = res.getString("Mail");
            _id = res.getString("IdUser");
        }
        catch(Exception e){
            e.getMessage();
            return (false);
        }

        sm.closeConnection();
        return (true);
    }

    public Boolean ConnectUser(){
        SqlManager sm = SqlManager.getInstance();

        sm.openConnection();
        try {
            ResultSet res = sm.executeQuery("SELECT * FROM Users WHERE login = '" + _login + "' AND password = '"+_password+"'");
            if (!res.next()){
                throw new Exception("Connection Impossible");
            }else {
                _session.setAttribute("login", res.getString("Login"));

                sm.closeConnection();
            }
        } catch(Exception e){
            System.out.println(e.getMessage());
            sm.closeConnection();
            return (false);
        }
        return (true);
    }

    public Boolean isExist(String login){
        SqlManager sm = SqlManager.getInstance();

        sm.openConnection();
        try {
            ResultSet res = sm.executeQuery("SELECT IdUser FROM Users WHERE Login = '"+login+"'");
            if (!res.next()){
                System.out.println("user find");
                sm.closeConnection();
                throw new Exception("utilisateur non trouvé");
            }
            sm.closeConnection();
        } catch(Exception e){
            System.out.println(e.getMessage());
            return (true);
        }
        return (false);
    }

    public Boolean createUser(String nom, String prenom, String mail, String login, String password){
        SqlManager sm = SqlManager.getInstance();

        sm.openConnection();

        Boolean ret = sm.execute("INSERT INTO Users (Nom, Prenom, Mail, Login, Password) VALUES("
                + "'"+nom+"',"
                + "'"+prenom+"',"
                + "'"+mail+"',"
                + "'"+login+"',"
                + "'"+password+"')");
        sm.closeConnection();

        System.out.println(ret);

        return (ret);
    }

    public Boolean isConnect(){
        return _connected;
    }

    public String getCompletName(){
        return _prenom + " " + _nom;
    }

}
