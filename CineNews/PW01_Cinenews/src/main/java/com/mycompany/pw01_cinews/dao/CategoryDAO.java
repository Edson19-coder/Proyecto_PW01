/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.pw01_cinews.dao;
import com.mycompany.pw01_cinews.models.CategoryModel;
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
public class CategoryDAO {
    public static List<CategoryModel> GetCategories() throws SQLException{
       List<CategoryModel> categories = new ArrayList<>();
       Connection con = DbConnection.getConnection();
        try {
            String sql = "CALL `cinenews_db`.`select_categories`();";
            CallableStatement statement = con.prepareCall(sql);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                int id = result.getInt("idcategory");
                String name = result.getString("name");
                categories.add(new CategoryModel(id,name));
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
        return categories;
   }
}
