package com.jweb.beans;

/**
 * Created by mickael on 1/1/2016.
 */
public class Opinion {
    private Integer id;

    private Integer idUser;

    private String Opinion;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public void setOpinion(String opinion) {
        Opinion = opinion;
    }

    public Integer getId() {
        return id;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public String getOpinion() {
        return Opinion;
    }
}
