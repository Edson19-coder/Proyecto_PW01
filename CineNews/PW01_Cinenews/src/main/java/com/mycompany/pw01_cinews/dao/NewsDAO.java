/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.pw01_cinews.dao;

import com.mycompany.pw01_cinews.models.NewsModel;
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
public class NewsDAO {
    public static int InsertNews(NewsModel news) throws SQLException{
        Connection con = DbConnection.getConnection();
        try{
            String sql = "CALL `cinenews_db`.`news_procedure`(?, NULL, ?, ?, ?, ?, ?, ?, ?, ?, NULL, NULL);";
            CallableStatement statement = con.prepareCall(sql);
            statement.setString(1, "I");
            statement.setString(2, news.getNewsTitle());
            statement.setString(3, news.getNewsDescription());
            statement.setString(4, news.getNewsContent());
            statement.setInt(5, news.getNewsCategory());
            statement.setInt(6, news.getNewsAuthor());
            statement.setInt(7, news.getNewsStatus());
            statement.setString(8, news.getNewDate());
            statement.setString(9, null);
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
    
     public static int GetLastId() throws SQLException{
         Connection con = DbConnection.getConnection();
        try{
            String sql = "CALL `cinenews_db`.`news_procedure`(?, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);";
            CallableStatement statement = con.prepareCall(sql);
            statement.setString(1, "UI");
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                int id = result.getInt("id");
                return id;
            }
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
     
    public static List<NewsModel> GetNews() throws SQLException{
        List<NewsModel> news = new ArrayList<>();
        Connection con = DbConnection.getConnection();
        try {
        String sql = "CALL `cinenews_db`.`news_procedure`(?, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);";
            CallableStatement statement = con.prepareCall(sql);
            statement.setString(1, "AS");
            ResultSet result = statement.executeQuery();
            while     (result.next()) {
                Integer id = result.getInt("idnews");
                String title = result.getString("newsTitle");
                String Description = result.getString("newsDescription");
                String Content = result.getString("newsContent");
                Integer Category = result.getInt("newsCategory");
                Integer Author = result.getInt("newAuthor");
                Integer Status = result.getInt("newStatus");
                String Date = result.getString("newDate");
                news.add(new NewsModel(id, title, Description, Content, Category, Author, Status, Date));
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
        return news;
    }
    
    public static NewsModel GetNewsById(int idn) throws SQLException{
        Connection con = DbConnection.getConnection();
        try {
            String sql = "CALL `cinenews_db`.`news_procedure`(?, ?, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);";
            CallableStatement statement = con.prepareCall(sql);
            statement.setString(1, "S");
            statement.setInt(2, idn);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                Integer id = result.getInt("idnews");
                String title = result.getString("newsTitle");
                String Description = result.getString("newsDescription");
                String Content = result.getString("newsContent");
                Integer Category = result.getInt("newsCategory");
                Integer Author = result.getInt("newAuthor");
                Integer Status = result.getInt("newStatus");
                String Date = result.getString("newDate");
                Integer LikeCount = result.getInt("newsLikeCount");
                Integer DislikeCount = result.getInt("newsDislikeCount");
                NewsModel nm = new NewsModel(id, title, Description, Content, Category, Author, Status, Date, LikeCount, DislikeCount);
                return nm;
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
        return null;
    }
    
    public static List<NewsModel> GetNewsByIdUser(int idu) throws SQLException{
        List<NewsModel> news = new ArrayList<>();
        Connection con = DbConnection.getConnection();
        try {
        String sql = "CALL `cinenews_db`.`news_procedure`(?, NULL, NULL, NULL,	NULL, NULL, ?, NULL, NULL, NULL, NULL, NULL);";
            CallableStatement statement = con.prepareCall(sql);
            statement.setString(1, "US");
            statement.setInt(2, idu);
            ResultSet result = statement.executeQuery();
            while     (result.next()) {
                Integer id = result.getInt("idnews");
                String title = result.getString("newsTitle");
                String Description = result.getString("newsDescription");
                String Content = result.getString("newsContent");
                Integer Category = result.getInt("newsCategory");
                Integer Author = result.getInt("newAuthor");
                Integer Status = result.getInt("newStatus");
                String Date = result.getString("newDate");
                String motivo = result.getString("newsMotivo");
                news.add(new NewsModel(id, title, Description, Content, Category, Author, Status, Date, motivo));
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
        return news;
    }
    
    public static int UpdateStatus(Integer idNews, String comentario, Integer status) throws SQLException{
        Connection con = DbConnection.getConnection();
        try{
            String sql = "CALL `cinenews_db`.`news_procedure`(?, ?, NULL, NULL, NULL, NULL, NULL, ?, NULL,?, NULL, NULL);";
            CallableStatement statement = con.prepareCall(sql);
            statement.setString(1, "ST");
            statement.setInt(2, idNews);
            statement.setInt(3, status);
            statement.setString(4, comentario);
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
    
    public static int LikeInteraction(String op, Integer idNews) throws SQLException{
        Connection con = DbConnection.getConnection();
        try{
            String sql = "CALL `cinenews_db`.`news_procedure`(?, ?, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);";
            CallableStatement statement = con.prepareCall(sql);
            statement.setString(1, op);
            statement.setInt(2, idNews);
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
    
    public static int UpdateNew(NewsModel news) throws SQLException{
        Connection con = DbConnection.getConnection();
        try{
            String sql = "CALL `cinenews_db`.`news_procedure`( ?, ?, ?, ?, ?, ?, NULL, ?, ?, NULL, NULL, NULL);";
            CallableStatement statement = con.prepareCall(sql);
            statement.setString(1, "U");
            statement.setInt(2, news.getIdnews());
            statement.setString(3, news.getNewsTitle());
            statement.setString(4, news.getNewsDescription());
            statement.setString(5, news.getNewsContent());
            statement.setInt(6, news.getNewsCategory());
            statement.setInt(7, news.getNewsStatus());
            statement.setString(8, news.getNewDate());
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
    
    public static List<NewsModel> GetNewsMostLiked() throws SQLException{
        List<NewsModel> news = new ArrayList<>();
        Connection con = DbConnection.getConnection();
        try {
        String sql = "CALL `cinenews_db`.`news_procedure`(?, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);";
            CallableStatement statement = con.prepareCall(sql);
            statement.setString(1, "TT");
            ResultSet result = statement.executeQuery();
            while     (result.next()) {
                Integer id = result.getInt("idnews");
                String title = result.getString("newsTitle");
                String Description = result.getString("newsDescription");
                String Content = result.getString("newsContent");
                Integer Category = result.getInt("newsCategory");
                Integer Author = result.getInt("newAuthor");
                Integer Status = result.getInt("newStatus");
                String Date = result.getString("newDate");
                news.add(new NewsModel(id, title, Description, Content, Category, Author, Status, Date));
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
        return news;
    }
    
    public static List<NewsModel> GetNewsCategory(int category) throws SQLException{
        List<NewsModel> news = new ArrayList<>();
        Connection con = DbConnection.getConnection();
        try {
        String sql = "CALL `cinenews_db`.`news_procedure`(?, NULL, NULL, NULL, NULL, ?, NULL, NULL, NULL, NULL, NULL, NULL);";
            CallableStatement statement = con.prepareCall(sql);
            statement.setString(1, "C");
            statement.setInt(2, category);
            ResultSet result = statement.executeQuery();
            while     (result.next()) {
                Integer id = result.getInt("idnews");
                String title = result.getString("newsTitle");
                String Description = result.getString("newsDescription");
                String Content = result.getString("newsContent");
                Integer Category = result.getInt("newsCategory");
                Integer Author = result.getInt("newAuthor");
                Integer Status = result.getInt("newStatus");
                String Date = result.getString("newDate");
                news.add(new NewsModel(id, title, Description, Content, Category, Author, Status, Date));
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
        return news;
    }
    
    public static List<NewsModel> GetNewsSearch(String texto) throws SQLException{
        List<NewsModel> news = new ArrayList<>();
        Connection con = DbConnection.getConnection();
        try {
        String sql = "CALL `cinenews_db`.`search_procedure`(?);";
            CallableStatement statement = con.prepareCall(sql);
            statement.setString(1, texto);
            ResultSet result = statement.executeQuery();
            while     (result.next()) {
                Integer id = result.getInt("idnews");
                String title = result.getString("newsTitle");
                String Description = result.getString("newsDescription");
                String Content = result.getString("newsContent");
                Integer Category = result.getInt("newsCategory");
                Integer Author = result.getInt("newAuthor");
                Integer Status = result.getInt("newStatus");
                String Date = result.getString("newDate");
                news.add(new NewsModel(id, title, Description, Content, Category, Author, Status, Date));
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
        return news;
    }
}
