package com.jweb.beans;

/**
 * Created by mickael on 1/1/2016.
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
