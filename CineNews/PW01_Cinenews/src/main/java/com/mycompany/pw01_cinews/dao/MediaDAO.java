/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.pw01_cinews.dao;

import com.mycompany.pw01_cinews.models.MediaModel;
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
public class MediaDAO {
    public static int InsertMedia(MediaModel media) throws SQLException{
        Connection con = DbConnection.getConnection();
        try{
            String sql = "CALL `cinenews_db`.`media_procedure`(?, NULL, ?, ?);";
            CallableStatement statement = con.prepareCall(sql);
            statement.setString(1, "I");
            statement.setString(2, media.getMediaUrl());
            statement.setInt(3, media.getMediNoticia());
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
    
    public static List<MediaModel> GetMedia() throws SQLException{
        List<MediaModel> news = new ArrayList<>();
        Connection con = DbConnection.getConnection();
        try {
            String sql = "CALL `cinenews_db`.`media_procedure`(?, NULL, NULL, NULL);";
            CallableStatement statement = con.prepareCall(sql);
            statement.setString(1, "AS");
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                Integer mediaNoticia = result.getInt("idnews");
                String mediaUrl = result.getString("urlImagen");
                news.add(new MediaModel(mediaUrl, mediaNoticia));
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
    
    public static List<MediaModel> GetMediaById(int idu) throws SQLException{
        List<MediaModel> news = new ArrayList<>();
        Connection con = DbConnection.getConnection();
        try {
            String sql = "CALL `cinenews_db`.`media_procedure`(?, NULL, NULL, ?);";
            CallableStatement statement = con.prepareCall(sql);
            statement.setString(1, "S");
            statement.setInt(2, idu);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                String mediaUrl = result.getString("mediaUrl");
                news.add(new MediaModel(mediaUrl));
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
