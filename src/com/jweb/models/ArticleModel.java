package com.jweb.models;

import com.jweb.beans.Article;
import com.jweb.tools.SqlManager;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by mickael on 12/21/2015.
 */
public class ArticleModel {
    ArrayList<Article> data;

    public ArticleModel()
    {
    }

    public ArrayList<Article> all() {
        SqlManager sm = SqlManager.getInstance();

        data = new ArrayList<Article>();
        
        sm.openConnection();

        try {
            ResultSet res = sm.executeQuery("SELECT Nom, Prenom,"
                    + "Title, Content, IdArticle FROM Articles AS a"
                    + " LEFT JOIN Users AS u ON u.IdUser = a.IdUser");

            while (res.next()){
                Article article = new Article();

                article.setTitle(res.getString("Title"));
                article.setId(res.getInt("IdArticle"));
                article.setAuthor(res.getString("Nom")+" "+res.getString("Prenom"));
                article.setContent(res.getString("Content"));
                data.add(article);
            }

        } catch(Exception e){
            System.out.println("plop "+e.getMessage());
        }

        sm.closeConnection();
        return this.data;
    }

    public void addArticle(Article element){
        SqlManager sm = SqlManager.getInstance();

        sm.openConnection();

        sm.execute("INSERT INTO Articles (Title, Content, IdUser) VALUES"
                + "('"+element.getTitle()+"',"
                + "'"+element.getContent()+"',"
                + ""+element.getIdAuthor()+")");

        sm.closeConnection();
    }
}
