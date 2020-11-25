/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.pw01_cinews.utils;

import java.sql.Connection;
import java.sql.SQLException;
import org.apache.commons.dbcp.BasicDataSource;
/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class DbConnection {
        //Creamos un obj de la conexion
    private static final BasicDataSource dataSource = new BasicDataSource();
    
    //Inicializamos la conexion
    static {
        dataSource.setDriverClassName("com.mysql.jdbc.Driver"); //Mas de uso general
        //dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver"); //SOLO PARA JAVA 
        dataSource.setUrl("jdbc:mysql://localhost:3306/cineNews_db?useUnicode=true&useJDBCCompliantTimeZoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
        dataSource.setUsername("root");
        dataSource.setPassword("solido20");
    }
    
     /**
     * *
     * Metodo para obtener la conexion
     *
     * @return Conexion a Base de datos
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException{
        return dataSource.getConnection();
    }
    
    /**
     * Metodo para cerrar la conexion
     *
     * @throws SQLException
     */
    public static void closeConnection() throws SQLException{
        dataSource.close();
    }
}
