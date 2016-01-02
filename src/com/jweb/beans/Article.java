package com.jweb.beans;

import java.util.Date;

/**
 * Article est un classe JAVA de type beans,
 * elle a été construite de manière à ne contenir que des getter/setter
 * au sein du projet elle nous sert de conteneur pour nos articles facilitant le travail des différentes autres parties du programme
 */
public class Article {

    private Integer id;

    private String title;

    private String content;

    private String author;

    private Integer idAuthor;

    private Date date;

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getContent(){
        return content;
    }

    public void setContent(String content){
        this.content = content;
    }

    public String getAuthor(){
        return author;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public void setIdAuthor(Integer idAuthor) {
        this.idAuthor = idAuthor;
    }

    public Integer getIdAuthor() {
        return idAuthor;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
