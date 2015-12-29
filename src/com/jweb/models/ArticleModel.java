package com.jweb.models;

import com.jweb.beans.Article;
import com.jweb.tools.SqlManager;

import java.lang.annotation.ElementType;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
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
