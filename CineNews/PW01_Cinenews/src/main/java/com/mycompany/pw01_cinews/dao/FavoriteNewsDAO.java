/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pw01_cinews.dao;

import com.mycompany.pw01_cinews.models.FavoriteModel;
import com.mycompany.pw01_cinews.models.NewsModel;
import com.mycompany.pw01_cinews.models.UserModel;
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
public class FavoriteNewsDAO {

    public static int InsertFavoriteNews(int idnew, int iduser) throws SQLException {
        Connection con = DbConnection.getConnection();
        try {
            String sql = "CALL `cinenews_db`.`favoriteNews_procedure`(?, NULL, ?, ?);";
            CallableStatement statement = con.prepareCall(sql);
            statement.setString(1, "I");
            statement.setInt(2, idnew);
            statement.setInt(3, iduser);
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

    public static List<FavoriteModel> GetFavNewsByUser(int id) throws SQLException {
        Connection con = DbConnection.getConnection();
        List<FavoriteModel> favNews = new ArrayList<>();
        try {
            String sql = "CALL `cinenews_db`.`favoriteNews_procedure`(?, NULL, NULL, ?);";
            CallableStatement statement = con.prepareCall(sql);
            statement.setString(1, "US");
            statement.setInt(2, id);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                int idfavoritenews = result.getInt("idfavoritenews");
                int favoritenewsFkNews = result.getInt("favoritenewsFkNews");
                int favoritenewsFkUser = result.getInt("favoritenewsFkUser");
                NewsModel news = NewsDAO.GetNewsById(favoritenewsFkNews);
                UserModel user = UserDAO.UserSelectById(favoritenewsFkUser);
                favNews.add(new FavoriteModel(idfavoritenews, news, user));
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
        return favNews;
    }
    
    public static int DeleteFavNews(int iduser, int idnews) throws SQLException{
        Connection con = DbConnection.getConnection();
        try {
            String sql = "CALL `cinenews_db`.`favoriteNews_procedure`(?, NULL, ?, ?);";
            CallableStatement statement = con.prepareCall(sql);
            statement.setString(1, "D");
            statement.setInt(2, idnews);
            statement.setInt(3, iduser);
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
    
    public static Boolean IsFavNew(int idnew,int iduser) throws SQLException {
        Connection con = DbConnection.getConnection();
        try {
            String sql = "CALL `cinenews_db`.`favoriteNews_procedure`(?, NULL, ?, ?);";
            CallableStatement statement = con.prepareCall(sql);
            statement.setString(1, "UF");
            statement.setInt(2, idnew);
            statement.setInt(3, iduser);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                System.out.println("si hay");
                return true;
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
        return false;
    }
}
