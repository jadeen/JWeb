package com.jweb.models;

import com.jweb.beans.Newsletter;
import com.jweb.tools.SqlManager;

import java.sql.PreparedStatement;

/**
 * Object permettant un interraction directe avec la table SQLLITE Newsletters
 */
public class NewsletterModel {
    public NewsletterModel(){

    }

    /**
     * fonction permettant l'ajout d'element a la table newsletters
     * @param newsletter class Newsletter contenant l'adresse mail a ajouter
     * @return Boolean pour indiquer si l'enregistrement en base de donnée a marche
     */
    public boolean subscribeNewsletter(Newsletter newsletter){
        SqlManager sm = SqlManager.getInstance();

        sm.openConnection();

        Boolean res;
        try {
            PreparedStatement preparedStatement = sm.prepareStatement("INSERT INTO Newsletters (Mail) VALUES(?)");

            preparedStatement.setString(1, newsletter.getMail());

            res = sm.execute(preparedStatement);
        }
        catch (Exception e){
            System.err.println(e);
            return false;
        }
        sm.closeConnection();

        return (res);
    }
}
