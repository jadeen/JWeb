package com.jweb.beans;

/**
 * Created by mickael on 12/21/2015.
 */
public class User {
    private String login;

    private Integer id;

    private String nom;

    private String prenom;

    private String password;

    private String mail;

    private Integer admin;

    private Boolean connect;

    public Boolean getAdmin() {
        return admin == 1;
    }

    public void setAdmin(Integer admin) {
        this.admin = admin;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setConnect(Boolean connect) {
        this.connect = connect;
    }

    public Integer getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getMail() {
        return mail;
    }

    public String getNom() {
        return nom;
    }

    public String getPassword() {
        return password;
    }

    public String getPrenom() {
        return prenom;
    }

    public Boolean getConnect() {
        return connect;
    }
}
