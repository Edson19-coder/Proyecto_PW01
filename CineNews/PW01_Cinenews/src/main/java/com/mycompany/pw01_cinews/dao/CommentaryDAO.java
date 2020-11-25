/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.pw01_cinews.dao;

import com.mycompany.pw01_cinews.models.CommentaryModel;
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
public class CommentaryDAO {
    
    public static int InsertCommentary(CommentaryModel commentary) throws SQLException{
        Connection con = DbConnection.getConnection();
        try{
            String sql = "CALL `cinenews_db`.`commentary_procedure`(?, NULL, ?, ?, ?, ?, ?);";
            CallableStatement statement = con.prepareCall(sql);
            statement.setString(1, "I");
            statement.setString(2, commentary.getCommentaryContent());
            statement.setInt(3, commentary.getCommentaryNews());
            statement.setInt(4, commentary.getCommentaryUser());
            statement.setInt(5, commentary.getCommentaryCountLikes());
            statement.setString(6, commentary.getCommentaryDate());
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
    
    public static List<CommentaryModel> SelectCommentsNews(int idn) throws SQLException{
        Connection con = DbConnection.getConnection();
        List<CommentaryModel> comments = new ArrayList<>();
        try {
            String sql = "CALL `cinenews_db`.`commentary_procedure`(?, NULL, NULL, ?, NULL, NULL, NULL);";
            CallableStatement statement = con.prepareCall(sql);
            statement.setString(1, "SN");
            statement.setInt(2, idn);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                int idcommentary = result.getInt("idcommentary");
                String commentaryContent = result.getString("commentaryContent");
                int commentaryNews = result.getInt("commentaryNews");
                int commentaryUser = result.getInt("commentaryUser");
                int commentaryCountLikes = result.getInt("commentaryCountLikes");
                String commentaryDate = result.getString("commentaryDate");
                comments.add(new CommentaryModel(idcommentary, commentaryContent, commentaryNews, 
                            commentaryUser, commentaryCountLikes, commentaryDate));
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
}
