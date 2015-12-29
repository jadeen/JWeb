package com.jweb.models;

import com.jweb.beans.User;
import com.jweb.tools.SqlManager;
import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.servlet.http.HttpSession;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by mickael on 12/19/2015.
 */
public class UserModel {
    public User currentUser;

    private Boolean _connected = false;

    private HttpSession _session;

    public UserModel(HttpSession session){
        _session = session;
        this.currentUser = new User();
        this.currentUser.setLogin((String) session.getAttribute("login"));
        if (this.currentUser.getLogin() == null){
            this.currentUser.setConnect(false);
            return ;
        }
        this.currentUser.setConnect(true);
    }

    public Boolean settingCurrentUserData(){
        SqlManager sm = SqlManager.getInstance();

        sm.openConnection();

        try {
            PreparedStatement preparedStatement = sm.prepareStatement("SELECT * FROM Users WHERE Login = ?");

            preparedStatement.setString(1, this.currentUser.getLogin());

            ResultSet res = sm.executeQuery(preparedStatement);

            if (!res.next()){
                throw new Exception("utilisateur non trouvé");
            }
            this.currentUser.setNom(res.getString("Nom"));
            this.currentUser.setPrenom(res.getString("Prenom"));
            this.currentUser.setPassword(res.getString("Password"));
            this.currentUser.setMail(res.getString("Mail"));
            this.currentUser.setId(res.getInt("IdUser"));
            this.currentUser.setAdmin(res.getInt("Admin"));
        }
        catch(Exception e){
            e.getMessage();
            return (false);
        }

        sm.closeConnection();
        return (true);
    }

    public void setCurrentUser(String login, String password){
        currentUser = new User();
        currentUser.setLogin(login);
        currentUser.setPassword(password);
    }

    public Boolean ConnectUser(){
        SqlManager sm = SqlManager.getInstance();

        sm.openConnection();
        try {

            PreparedStatement preparedStatement = sm.prepareStatement("SELECT * FROM Users WHERE login = ? AND password = ?");

            preparedStatement.setString(1, this.currentUser.getLogin());
            preparedStatement.setString(2, this.currentUser.getPassword());
            ResultSet res = sm.executeQuery(preparedStatement);
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

            PreparedStatement preparedStatement = sm.prepareStatement("SELECT IdUser FROM Users WHERE Login = ?");

            preparedStatement.setString(1, login);
            ResultSet res = sm.executeQuery(preparedStatement);
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

        Boolean ret;

        try {
            PreparedStatement preparedStatement = sm.prepareStatement("INSERT INTO Users (Nom, Prenom, Mail, Login, Password) VALUES(?,?,?,?,?)");

            preparedStatement.setString(1,nom);
            preparedStatement.setString(2,prenom);
            preparedStatement.setString(3,mail);
            preparedStatement.setString(4,login);
            preparedStatement.setString(5,password);
            ret = sm.execute(preparedStatement);

        }
        catch (SQLException e){
            System.err.println(e);
            return false;
        }

        sm.closeConnection();

        return (ret);
    }

    public ArrayList<User> all(){
        ArrayList<User> data = new ArrayList<User>();

        SqlManager sm = SqlManager.getInstance();

        sm.openConnection();

        try {
            ResultSet res = sm.executeQuery("SELECT * FROM Users");

            while (res.next()){
                User user = new User();

                user.setId(res.getInt("IdUser"));
                user.setNom(res.getString("Nom"));
                user.setPrenom(res.getString("Prenom"));
                user.setMail(res.getString("Mail"));
                user.setLogin(res.getString("Login"));
                user.setAdmin(res.getInt("Admin"));

                data.add(user);
            }
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }

        sm.closeConnection();

        return data;
    }

    public void delete(String Id){
        SqlManager sm = SqlManager.getInstance();

        sm.openConnection();

        try {
            PreparedStatement preparedStatement = sm.prepareStatement("DELETE FROM Users WHERE IdUser = ?");

            preparedStatement.setInt(1, Integer.parseInt(Id));

            sm.execute(preparedStatement);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        sm.closeConnection();
    }

    public void switchStatus(String id){
        SqlManager sm = SqlManager.getInstance();

        sm.openConnection();

        try {
            PreparedStatement preparedStatement = sm.prepareStatement("SELECT Admin FROM Users WHERE IdUser = ?");

            preparedStatement.setInt(1, Integer.parseInt(id));

            ResultSet res = sm.executeQuery(preparedStatement);

            if (res.next()) {
                preparedStatement = sm.prepareStatement("UPDATE Users SET Admin = ? WHERE IdUser = ?");

                preparedStatement.setInt(1, res.getString("Admin").equals("1") ? 0 : 1);

                preparedStatement.setInt(2, Integer.parseInt(id));

                sm.execute(preparedStatement);
            }
        }
        catch (Exception e){
            System.out.println("Error :"+e.getMessage());
        }

        sm.closeConnection();
    }

    public String getCompletName(){
        return this.currentUser.getPrenom() + " " + this.currentUser.getNom();
    }
}
