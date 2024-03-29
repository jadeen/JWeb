package com.jweb.models;

import com.jweb.beans.Article;
import com.jweb.tools.SqlManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

/**
 * Objet permettant un interraction directe avec la table SQLLITE articles
 */
public class ArticleModel {
    /**
     * Variable permettant de ne récupérer qu'une seule fois les articles par requête(si besoin)
     */
    public ArrayList<Article> data;

    public ArticleModel()
    {
    }

    /**
     * Fonction permettant de récupérer tous les articles en base de données
     * @return Une liste complète de beans article
     */
    public ArrayList<Article> all() {
        SqlManager sm = SqlManager.getInstance();

        data = new ArrayList<Article>();
        
        sm.openConnection();

        try {
            ResultSet res = sm.executeQuery("SELECT Nom, Prenom,"
                    + "Title, Content, date, IdArticle FROM Articles AS a"
                    + " LEFT JOIN Users AS u ON u.IdUser = a.IdUser ORDER By IdArticle desc");

            while (res.next()){
                Article article = new Article();

                article.setTitle(res.getString("Title"));
                article.setId(res.getInt("IdArticle"));
                article.setAuthor(res.getString("Nom")+" "+res.getString("Prenom"));
                article.setContent(res.getString("Content"));
                article.setDate(new Date(res.getLong("date")));
                data.add(article);
            }

        } catch(Exception e){
            System.out.println("plop "+e.getMessage());
        }

        sm.closeConnection();
        return this.data;
    }

    /**
     * Fonction permettant l'ajout d'article en base de données
     * @param element Article à ajouter
     */
    public void addArticle(Article element){
        SqlManager sm = SqlManager.getInstance();

        sm.openConnection();

        try {
            PreparedStatement preparedStatement = sm.prepareStatement("INSERT INTO Articles (Title, Content, date, IdUser) VALUES(?,?,?,?)");

            preparedStatement.setString(1, element.getTitle());
            preparedStatement.setString(2, element.getContent());
            preparedStatement.setDate(3, new java.sql.Date(new Date().getTime()));
            preparedStatement.setInt(4, element.getIdAuthor());

            sm.execute(preparedStatement);
        }
        catch (Exception e){
            System.err.println(e);
        }
        sm.closeConnection();
    }
}
