/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.pw01_cinews.dao;

import com.mycompany.pw01_cinews.models.LikeAnswerModel;
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
public class LikeAnswerDAO {
    public static int InsertLikeAnswer(LikeAnswerModel like) throws SQLException {
            Connection con = DbConnection.getConnection();
            try {
                String sql = "CALL `cinenews_db`.`likeAnswer_procedure`(?, NULL, ?, ?, ?);";
                CallableStatement statement = con.prepareCall(sql);
                statement.setString(1, "I");
                statement.setInt(2, like.getLikeanswerUser());
                statement.setInt(3, like.getLikeanswerAnswer());
                statement.setInt(4, like.getLikeanswerNew());
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

        public static int DeleteLikeAnswer(int id) throws SQLException{
            Connection con = DbConnection.getConnection();
            try {
                String sql = "CALL `cinenews_db`.`likeAnswer_procedure`(?, ?, NULL, NULL, NULL);";
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

        public static List<LikeAnswerModel> GetLikesAnswerByNew(int idNew) throws SQLException{
            Connection con = DbConnection.getConnection();
            List<LikeAnswerModel> likes = new ArrayList<>();
            try {
                String sql = "CALL `cinenews_db`.`likeAnswer_procedure`(?, NULL, NULL, NULL, ?);";
                CallableStatement statement = con.prepareCall(sql);
                statement.setString(1, "SN");
                statement.setInt(2, idNew);
                ResultSet result = statement.executeQuery();
                while (result.next()) {
                    int idlikeanswer = result.getInt("idlikeanswer");
                    int likeanswerUser = result.getInt("likeanswerUser");
                    int likeanswerAnswer = result.getInt("likeanswerAnswer");
                    int likeanswerNew = result.getInt("likeanswerNew");
                    likes.add(new LikeAnswerModel(idlikeanswer, likeanswerUser, likeanswerAnswer, likeanswerNew));
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
