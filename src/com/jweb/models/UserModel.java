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
 * Objet permettant un interraction directe avec la table SQLLITE UserModel
 */
public class UserModel {
    /**
     * Contient l'utilisateur actif sur le site
     */
    public User currentUser;

    /**
     * Contient une instance de HttpSession nous permettant de recupérer l'utilisateur actif
     */
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

    /**
     * Permet de recupérer les informations de l'utilisateur actif sur le site
     * @return Boolean pour savoir si l'operation a réussi ou non
     */
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

    /**
     * Fonction permettant de setter les informations de base du l'utilisateur courant
     * @param login String contenant le login à setter
     * @param password String contenant le mot de passe à setter
     */
    public void setCurrentUser(String login, String password){
        currentUser = new User();
        currentUser.setLogin(login);
        currentUser.setPassword(password);
    }

    /**
     * Permet de connecter un utilisateur à notre site internet
     * @return Boolean pour savoir si l'operation a réussi ou non
     */
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

    /**
     * Permet de savoir si le login n'existe pas déjà
     * @param login String contenant le login a tester
     * @return Boolean contenant le resultat du test
     */
    public Boolean isExist(String login){
        SqlManager sm = SqlManager.getInstance();

        sm.openConnection();
        try {

            PreparedStatement preparedStatement = sm.prepareStatement("SELECT IdUser FROM Users WHERE Login = ?");

            preparedStatement.setString(1, login);
            ResultSet res = sm.executeQuery(preparedStatement);
            if (!res.next()){
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

    /**
     * FOnction permettent de cree un nouveau utilisateur dans la base de donnée
     * @param user class User contenant les informations de l'utilisateur
     * @return Boolean contenant le resultat de l'ajout en base de donnée
     */
    public Boolean createUser(User user){
        SqlManager sm = SqlManager.getInstance();

        sm.openConnection();

        try {
            PreparedStatement preparedStatement = sm.prepareStatement("INSERT INTO Users (Nom, Prenom, Mail, Login, Password) VALUES(?,?,?,?,?)");

            preparedStatement.setString(1,user.getNom());
            preparedStatement.setString(2,user.getPrenom());
            preparedStatement.setString(3,user.getMail());
            preparedStatement.setString(4,user.getLogin());
            preparedStatement.setString(5,user.getPassword());
            Boolean ret = sm.execute(preparedStatement);
            sm.closeConnection();
            return ret;

        }
        catch (SQLException e){
            System.err.println("Create User"+e);
            return false;
        }
    }

    /**
     * Fonction permettent de retourne la liste des utilisateur
     * @return Liste de tout les utilisateurs
     */
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

    /**
     * Fonctin permettant de suprimer un utilisateur
     * @param Id String contenant l'id de l'utilisateur
     */
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

    /**
     * fonction permettant de changer le status de l'utilisateur simple utilisateur/administrateur
     * @param id String contenant l'id de l'utilisateur qui a besoin de changer de status
     */
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
}
