package com.jweb.models;

import com.jweb.beans.Newsletter;
import com.jweb.tools.SqlManager;

import java.sql.PreparedStatement;

/**
 * Objet permettant un interraction directe avec la table SQLLITE Newsletters
 */
public class NewsletterModel {
    public NewsletterModel(){

    }

    /**
     * Fonction permettant l'ajout d'élement à la table newsletters
     * @param newsletter Newsletter contenant l'adresse mail à ajouter
     * @return Boolean pour indiquer si l'enregistrement en base de données a fonctionné
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
