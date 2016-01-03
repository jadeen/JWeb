package com.jweb.beans;

/**
 * Newsletter est une classe JAVA de type beans,
 * elle a été construite de manière à ne contenir que des getter/setter
 * au sein du projet elle nous sert de conteneur pour nos articles facilitant le travail des différentes autres parties du programme
 */
public class Newsletter {
    private Integer id;

    private String mail;

    public String getMail() {
        return mail;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
