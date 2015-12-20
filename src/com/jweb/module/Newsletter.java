package com.jweb.module;

import com.jweb.sql.SqlManager;
import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * Created by mickael on 12/20/2015.
 */
public class Newsletter {
    public Newsletter(){

    }

    public boolean subscribeNewsletter(String mail){
        SqlManager sm = SqlManager.getInstance();

        sm.openConnection();

        Boolean res = sm.execute("INSERT INTO Newsletters (Mail) VALUES('"+mail+"')");

        sm.closeConnection();

        return (res);
    }
}
