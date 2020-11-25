/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.pw01_cinews.dao;

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
public class UserDAO { 
    public static int InserUser(UserModel newUser) throws SQLException{
            Connection con = DbConnection.getConnection();
        try{
            String sql = "CALL `cinenews_db`.`insert_user`(?, ?, ?, ?);";
            CallableStatement statement = con.prepareCall(sql);
            statement.setString(1, newUser.getUser_name());
            statement.setString(2, newUser.getPassword());
            statement.setInt(3, newUser.getUser_type());
            statement.setString(4, newUser.getEmail());
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
    
    public static Boolean userExistsByName(String name) throws SQLException{
            Connection con = DbConnection.getConnection();
        try{
            String sql = "CALL `cinenews_db`.`select_user_userName`(?);";
            CallableStatement statement = con.prepareCall(sql);
            statement.setString(1, name);
            ResultSet result = statement.executeQuery();
            while(result.next()){
                System.out.println("No se puede");
                return true;
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
        return false;
    }
    
     public static Boolean userExistsByEmail(String email) throws SQLException{
            Connection con = DbConnection.getConnection();
        try{
            String sql = "CALL `cinenews_db`.`select_user_userEmail`(?);";
            CallableStatement statement = con.prepareCall(sql);
            statement.setString(1, email);
            ResultSet result = statement.executeQuery();
            while(result.next()){
                System.out.println("No se puede");
                return true;
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
        return false;
    }
     
     public static List<UserModel> SelectLoginUser(UserModel user) throws SQLException{
             List<UserModel> users = new ArrayList<>();
            Connection con = DbConnection.getConnection();
         try{
            String sql = "CALL `cinenews_db`.`select_login_user`(?,?);";
            CallableStatement statement = con.prepareCall(sql);
            statement.setString(1, user.getUser_name());
            statement.setString(2, user.getPassword());
            ResultSet result = statement.executeQuery();
            while(result.next()){
                Integer id = Integer.parseInt(result.getString("iduser"));
                String name = result.getString("userName");
                String password = result.getString("userPassword");
                Integer userType = Integer.parseInt(result.getString("userType"));
                String email = result.getString("userEmail");
                // Agregamos el usuario a la lista
                users.add(new UserModel(id, name, password, userType, email));
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
        return users;
     }
     
     public static List<UserModel> SelectAllUsers() throws SQLException{
         List<UserModel> users = new ArrayList<>();
         Connection con = DbConnection.getConnection();
         try{
            String sql = "CALL `cinenews_db`.`select_all_users`();";
            CallableStatement statement = con.prepareCall(sql);
            ResultSet result = statement.executeQuery();
            while(result.next()){
                Integer id = Integer.parseInt(result.getString("iduser"));
                String name = result.getString("userName");
                Integer userType = Integer.parseInt(result.getString("userType"));
                String email = result.getString("userEmail");
                // Agregamos el usuario a la lista
                users.add(new UserModel(id, name, userType, email));
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
        return users;
     }
     
     public static int UserTypeUpdate(Integer id, Integer userType) throws SQLException{
            Connection con = DbConnection.getConnection();
         try{
             String sql = "CALL `cinenews_db`.`alter_user`(?, ?, NULL, NULL, ?, NULL, NULL, NULL, NULL, NULL);";
             CallableStatement statement = con.prepareCall(sql);
             statement.setString(1, "TP");
            statement.setInt(2, id);
            statement.setInt(3, userType);
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
     
     public static UserModel UserSelectById(int idnew) throws SQLException{
            Connection con = DbConnection.getConnection();
        try{
            String sql = "CALL `cinenews_db`.`user_procedure`(?, ?, NULL, NULL, NULL, NULL, NULL, NULL, NULL);";
            CallableStatement statement = con.prepareCall(sql);
            statement.setString(1, "S");
            statement.setInt(2, idnew);
            ResultSet result = statement.executeQuery();
            while(result.next()){
                Integer id = Integer.parseInt(result.getString("iduser"));
                String name = result.getString("userName");
                Integer userType = Integer.parseInt(result.getString("userType"));
                String email = result.getString("userEmail");
                String facebook = result.getString("userFacebook");
                String instagram = result.getString("userInstagram");
                String pathImage = result.getString("pathImage");
                return new UserModel(id, name, userType, email, facebook, instagram, pathImage);
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
        return null;
    }
}
