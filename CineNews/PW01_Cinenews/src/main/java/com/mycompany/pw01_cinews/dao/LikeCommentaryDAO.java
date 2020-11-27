/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pw01_cinews.dao;

import com.mycompany.pw01_cinews.models.LikeCommentaryModel;
import com.mycompany.pw01_cinews.utils.DbConnection;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static jdk.nashorn.internal.runtime.Debug.id;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class LikeCommentaryDAO {

    public static int InsertLikeCommentary(LikeCommentaryModel like) throws SQLException {
        Connection con = DbConnection.getConnection();
        try {
            String sql = "CALL `cinenews_db`.`likeCommentary_procedure`(?, NULL, ?, ?, ?);";
            CallableStatement statement = con.prepareCall(sql);
            statement.setString(1, "I");
            statement.setInt(2, like.getPlikecommentsUser());
            statement.setInt(3, like.getPlikecommentsCommentary());
            statement.setInt(4, like.getPlikecommentsNew());
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

    public static int DeleteLikeCommentary(int id) throws SQLException {
        Connection con = DbConnection.getConnection();
        try {
            String sql = "CALL `cinenews_db`.`likeCommentary_procedure`(?, ?, NULL, NULL, NULL);";
            CallableStatement statement = con.prepareCall(sql);
            statement.setString(1, "D");
            statement.setInt(2, id);
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

    public static List<LikeCommentaryModel> GetLikesByNew(int idNew) throws SQLException {
        Connection con = DbConnection.getConnection();
        List<LikeCommentaryModel> likes = new ArrayList<>();
        try {
            String sql = "CALL `cinenews_db`.`likeCommentary_procedure`(?, NULL, NULL, NULL, ?);";
            CallableStatement statement = con.prepareCall(sql);
            statement.setString(1, "SN");
            statement.setInt(2, idNew);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                int idlikecomments = result.getInt("idlikecomments");
                int likecommentsUser = result.getInt("likecommentsUser");
                int likecommentsCommentary = result.getInt("likecommentsCommentary");
                int likecommentsNew = result.getInt("likecommentsNew");
                likes.add(new LikeCommentaryModel(idlikecomments, likecommentsUser, likecommentsCommentary, likecommentsNew));
            }
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
        return likes;
    }
}
