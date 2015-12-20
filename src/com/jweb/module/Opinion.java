package com.jweb.module;

import com.jweb.sql.SqlManager;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Created by mickael on 12/20/2015.
 */
public class Opinion {

    private Integer _count;

    private ResultSet _data;

    public String _text;

    public Opinion(){
        _count = 0;
        _data = null;
    }

    public Boolean addUserOpinion(User user, String opinion){
        SqlManager sm = SqlManager.getInstance();

        sm.openConnection();

        Boolean ret = sm.execute("INSERT INTO Opinions (IdUser, Opinion) VALUES("
                + ""+user.get_id()+","
                + "'"+opinion+"')");

        System.out.println(user.get_id());

        sm.openConnection();
        return (ret);
    }

    public ResultSet countElement(){

        if (_data == null) {

            SqlManager sm = SqlManager.getInstance();

            sm.openConnection();

            try {
                _data = sm.executeQuery("SELECT * FROM Opinions "
                        + "LEFT JOIN Users ON Opinions.IdUser = Users.IdUser");
                while (_data.next()) {
                    _count += 1;
                    System.out.println("Count Inc :"+_count);
                }
            } catch (Exception e) {

            }
            sm.closeConnection();
        }
        return (_data);
    }

    public ResultSet getRandomOpinion(){
        ResultSet res = null;

        System.out.println("count :"+ _count);
        Integer index = (int)(Math.random() * (_count));

        try{
            SqlManager sm = SqlManager.getInstance();

            sm.openConnection();

            _data = sm.executeQuery("SELECT * FROM Opinions "
                    + "LEFT JOIN Users ON Opinions.IdUser = Users.IdUser");

            Integer i = 0;
            System.out.println(index);
            while (_data.next()){
                if (i.equals(index)){
                    _text = _data.getString("Opinion");
                }
                i++;
            }

            sm.closeConnection();
        }
        catch(Exception e){
            System.out.println("1"+e.getMessage());
        }
        return (res);
    }
}
