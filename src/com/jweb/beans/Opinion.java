package com.jweb.beans;

/**
 * Opinion est une classe JAVA de type beans,
 * elle a été construite de manière à ne contenir que des getter/setter
 * au sein du projet elle nous sert de conteneur pour nos articles facilitant le travail des différentes autres parties du programme
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
