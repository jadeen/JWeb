package com.jweb.models;

import com.jweb.tools.SqlManager;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by mickael on 12/20/2015.
 */
public class OpinionModel {

    private Integer _count;

    private ResultSet _data;

    public String _text;

    public OpinionModel(){
        _count = 0;
        _data = null;
    }

    public Boolean addUserOpinion(UserModel user, String opinion){
        SqlManager sm = SqlManager.getInstance();

        sm.openConnection();

        Boolean ret;

        try {
            PreparedStatement preparedStatement = sm.prepareStatement("INSERT INTO Opinions (IdUser, Opinion) VALUES(?,?)");

            preparedStatement.setInt(1,user.currentUser.getId());
            preparedStatement.setString(2, opinion);

            ret = sm.execute(preparedStatement);
        }
        catch (SQLException e){
            System.err.println("SQLExecption :"+e.getMessage());
            return false;
        }

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
                }
            } catch (Exception e) {

            }
            sm.closeConnection();
        }
        return (_data);
    }

    public ResultSet getRandomOpinion(){
        ResultSet res = null;

        Integer index = (int)(Math.random() * (_count));

        try{
            SqlManager sm = SqlManager.getInstance();

            sm.openConnection();

            _data = sm.executeQuery("SELECT * FROM Opinions "
                    + "LEFT JOIN Users ON Opinions.IdUser = Users.IdUser");

            Integer i = 0;
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