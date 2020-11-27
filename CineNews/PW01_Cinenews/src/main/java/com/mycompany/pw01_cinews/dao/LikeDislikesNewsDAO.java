/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pw01_cinews.dao;

import com.mycompany.pw01_cinews.models.LikeDislikeNewsModel;
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
public class LikeDislikesNewsDAO {

    public static int InsertLikeDislikeNew(LikeDislikeNewsModel nuevo) throws SQLException {
        Connection con = DbConnection.getConnection();
        try {
            String sql = "CALL `cinenews_db`.`likeDislike_procedure`(?, NULL, ?, ?, ?);";
            CallableStatement statement = con.prepareCall(sql);
            statement.setString(1, "I");
            statement.setInt(2, nuevo.getPlikedislikenewsIdUser());
            statement.setInt(3, nuevo.getPlikedislikenewsIdNew());
            statement.setInt(4, nuevo.getPlikedislikenewsType());
            return statement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
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
    
    public static int DeleteLikeDislikeNew(LikeDislikeNewsModel delete) throws SQLException{
        Connection con = DbConnection.getConnection();
        try {
            String sql = "CALL `cinenews_db`.`likeDislike_procedure`(?, NULL, ?, ?, NULL);";
            CallableStatement statement = con.prepareCall(sql);
            statement.setString(1, "D");
            statement.setInt(2, delete.getPlikedislikenewsIdUser());
            statement.setInt(3, delete.getPlikedislikenewsIdNew());
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
    
    public static List<LikeDislikeNewsModel> GetLikesByNew(int idNew) throws SQLException {
        Connection con = DbConnection.getConnection();
        List<LikeDislikeNewsModel> likes = new ArrayList<>();
        try {
            String sql = "CALL `cinenews_db`.`likeDislike_procedure`(?, NULL, NULL, ?, NULL);";
            CallableStatement statement = con.prepareCall(sql);
            statement.setString(1, "SN");
            statement.setInt(2, idNew);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                int idlikedislikenews = result.getInt("idlikedislikenews");
                int likedislikenewsIdUser = result.getInt("likedislikenewsIdUser");
                int likedislikenewsIdNew = result.getInt("likedislikenewsIdNew");
                int likedislikenewsType = result.getInt("likedislikenewsType");
                likes.add(new LikeDislikeNewsModel(idlikedislikenews, likedislikenewsIdUser, likedislikenewsIdNew, likedislikenewsType));
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
    
    public static LikeDislikeNewsModel GetLikesByUser(int id, int idN) throws SQLException {
        Connection con = DbConnection.getConnection();
        try {
            String sql = "CALL `cinenews_db`.`likeDislike_procedure`(?, NULL, ?, ?, NULL);";
            CallableStatement statement = con.prepareCall(sql);
            statement.setString(1, "S");
            statement.setInt(2, id);
            statement.setInt(3, idN);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                int idlikedislikenews = result.getInt("idlikedislikenews");
                int likedislikenewsIdUser = result.getInt("likedislikenewsIdUser");
                int likedislikenewsIdNew = result.getInt("likedislikenewsIdNew");
                int likedislikenewsType = result.getInt("likedislikenewsType");
                LikeDislikeNewsModel likes = new LikeDislikeNewsModel(idlikedislikenews, likedislikenewsIdUser, likedislikenewsIdNew, likedislikenewsType);
                return likes;
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
        return null;
    }
    
    public static int UpdateLikeDislikeNew(LikeDislikeNewsModel update) throws SQLException{
        Connection con = DbConnection.getConnection();
        try {
            String sql = "CALL `cinenews_db`.`likeDislike_procedure`(?, NULL, ?, ?, ?);";
            CallableStatement statement = con.prepareCall(sql);
            statement.setString(1, "U");
            statement.setInt(2, update.getPlikedislikenewsIdUser());
            statement.setInt(3, update.getPlikedislikenewsIdNew());
            statement.setInt(4, update.getPlikedislikenewsType());
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
