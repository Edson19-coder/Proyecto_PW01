/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.pw01_cinews.dao;

import com.mycompany.pw01_cinews.models.AnswerModel;
import com.mycompany.pw01_cinews.utils.DbConnection;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class AnswerDAO {
    
    public static int InsertAnswer(AnswerModel answer) throws SQLException{
        Connection con = DbConnection.getConnection();
        try{
            String sql = "CALL `cinenews_db`.`answer_procedure`(?, NULL, ?, ?, ?, ?, ?, ?);";
            CallableStatement statement = con.prepareCall(sql);
            statement.setString(1, "I");
            statement.setString(2, answer.getAnswerContent());
            statement.setInt(3, answer.getAnswerNews());
            statement.setInt(4, answer.getAnswerUser());
            statement.setInt(5, answer.getAnswerCommentary());
            statement.setInt(6, answer.getAnswerCountLike());
            statement.setString(7, answer.getAnswerDate());
            return statement.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            if(con != null){
                try{
                    con.close();
                } catch(SQLException ex){
                    System.out.println(ex);
                }
            }
        }
        return 0;
    }
    
    public static List<AnswerModel> SelectAnswerNews(int idn) throws SQLException{
        Connection con = DbConnection.getConnection();
        List<AnswerModel> comments = new ArrayList<>();
        try {
            String sql = "CALL `cinenews_db`.`answer_procedure`(?, NULL, NULL, ?, NULL, NULL, NULL, NULL);";
            CallableStatement statement = con.prepareCall(sql);
            statement.setString(1, "SN");
            statement.setInt(2, idn);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                int idanswer = result.getInt("idanswer");
                String answerContent = result.getString("answerContent");
                int answerNews = result.getInt("answerNews");
                int answerUser = result.getInt("answerUser");
                int answerCommentary = result.getInt("answerCommentary");
                int answerCountLike = result.getInt("answerCountLike");
                String answerDate = result.getString("answerDate");
                comments.add(new AnswerModel(idanswer, answerContent, answerNews, 
                            answerUser, answerCommentary, answerCountLike, answerDate));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }finally{
            if(con != null){
                try{
                    con.close();
                } catch(SQLException ex){
                    System.out.println(ex);
                }
            }
        }
        return comments;
    }
    
    public static int DeletAnswer(int idans) throws SQLException{
        Connection con = DbConnection.getConnection();
        try {
            String sql = "CALL `cinenews_db`.`answer_procedure`(?, ?, NULL, NULL, NULL, NULL, NULL, NULL);";
            CallableStatement statement = con.prepareCall(sql);
            statement.setString(1, "D");
            statement.setInt(2, idans);
            return statement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    System.out.println(ex);
                }
            }
        }
        return 0;
    }
    
    public static int DeletAnswersByComment(int idcom) throws SQLException{
        Connection con = DbConnection.getConnection();
        try {
            String sql = "CALL `cinenews_db`.`answer_procedure`(?, NULL, NULL, NULL, NULL, ?, NULL, NULL);";
            CallableStatement statement = con.prepareCall(sql);
            statement.setString(1, "DC");
            statement.setInt(2, idcom);
            return statement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    System.out.println(ex);
                }
            }
        }
        return 0;
    }
    
    public static int MasLikeAnswer(int idans) throws SQLException{
        Connection con = DbConnection.getConnection();
        try {
            String sql = "CALL `cinenews_db`.`answer_procedure`(?, ?, NULL, NULL, NULL, NULL, NULL, NULL);";
            CallableStatement statement = con.prepareCall(sql);
            statement.setString(1, "L");
            statement.setInt(2, idans);
            return statement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    System.out.println(ex);
                }
            }
        }
        return 0;
    }
    
    public static int MenosLikeAnswer(int idans) throws SQLException{
        Connection con = DbConnection.getConnection();
        try {
            String sql = "CALL `cinenews_db`.`answer_procedure`(?, ?, NULL, NULL, NULL, NULL, NULL, NULL);";
            CallableStatement statement = con.prepareCall(sql);
            statement.setString(1, "LD");
            statement.setInt(2, idans);
            return statement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    System.out.println(ex);
                }
            }
        }
        return 0;
    }
}
