package com.jweb.models;

import com.jweb.tools.SqlManager;

import java.sql.PreparedStatement;

/**
 * Created by mickael on 12/20/2015.
 */
public class NewsletterModel {
    public NewsletterModel(){

    }

    public boolean subscribeNewsletter(String mail){
        SqlManager sm = SqlManager.getInstance();

        sm.openConnection();

        Boolean res;
        try {
            PreparedStatement preparedStatement = sm.prepareStatement("INSERT INTO Newsletters (Mail) VALUES(?)");

            preparedStatement.setString(1, mail);

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
