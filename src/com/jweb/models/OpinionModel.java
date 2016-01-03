package com.jweb.models;

import com.jweb.beans.Opinion;
import com.jweb.tools.SqlManager;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Objet permettant un interraction directe avec la table SQLLITE Opinions
 */
public class OpinionModel {

    private ArrayList<Opinion> _data;

    public OpinionModel(){
    }

    /**
     * Fonction permettant d'ajouter une opinion sur notre produit
     * @param opinion String contenant l'opinion de l'utilisateur
     * @return Boolean pour savoir si l'operation a réussi
     */
    public boolean addUserOpinion(Opinion opinion){
        SqlManager sm = SqlManager.getInstance();

        sm.openConnection();

        Boolean ret;

        try {
            PreparedStatement preparedStatement = sm.prepareStatement("INSERT INTO Opinions (IdUser, Opinion) VALUES(?,?)");

            preparedStatement.setInt(1,opinion.getIdUser());
            preparedStatement.setString(2, opinion.getOpinion());

            ret = sm.execute(preparedStatement);
        }
        catch (SQLException e){
            System.err.println("SQLExecption :"+e.getMessage());
            return false;
        }

        sm.openConnection();
        return (ret);
    }

    public ArrayList<Opinion> all(){
        SqlManager sm = SqlManager.getInstance();

        sm.openConnection();

        _data = new ArrayList<Opinion>();

        try {
            ResultSet res = sm.executeQuery("SELECT * FROM Opinions");

            while (res.next()){
                Opinion opinion = new Opinion();

                opinion.setId(res.getInt("IdOpinion"));
                opinion.setIdUser(res.getInt("IdUser"));
                opinion.setOpinion(res.getString("Opinion"));

                _data.add(opinion);
            }
        }
        catch (Exception e){
            System.err.println(e);
        }
        return _data;
    }

    /**
     * Fonction permettant de retourner une opinion de manière aléatoire
     * @return ResultSet contenant l'opinion
     */
    public Opinion getRandomOpinion(){

        System.out.println(_data.size());

        if (_data.size() != 0){
            Integer index = (int)(Math.random() * (_data.size()));
            return _data.get(index);
        }else {
            return null;
        }
    }
}