package com.jweb.models;

import com.jweb.tools.SqlManager;

/**
 * Created by mickael on 12/20/2015.
 */
public class NewsletterModel {
    public NewsletterModel(){

    }

    public boolean subscribeNewsletter(String mail){
        SqlManager sm = SqlManager.getInstance();

        sm.openConnection();

        Boolean res = sm.execute("INSERT INTO Newsletters (Mail) VALUES('"+mail+"')");

        sm.closeConnection();

        return (res);
    }
}
