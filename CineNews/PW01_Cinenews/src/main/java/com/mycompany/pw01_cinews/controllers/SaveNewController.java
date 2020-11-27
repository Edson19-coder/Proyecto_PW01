/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pw01_cinews.controllers;

import com.mycompany.pw01_cinews.dao.FavoriteNewsDAO;
import com.mycompany.pw01_cinews.models.FavoriteModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
@WebServlet(name = "SaveNew", urlPatterns = {"/SaveNew"})
public class SaveNewController extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Integer idUser = Integer.parseInt(request.getParameter("user"));
            Integer idNews = Integer.parseInt(request.getParameter("news"));
            String acc = request.getParameter("acc");
            switch (acc) {
                case "add": {
                    FavoriteNewsDAO.InsertFavoriteNews(idNews, idUser);
                    Boolean isFavNew = FavoriteNewsDAO.IsFavNew(idNews, idUser);
                    request.setAttribute("isFavNew", isFavNew);
                    request.getRequestDispatcher("ViewNew?Noticia=" + idNews).forward(request, response);
                    break;
                }
                case "delete":{
                    FavoriteNewsDAO.DeleteFavNews(idUser, idNews);
                    request.getRequestDispatcher("ViewNew?Noticia=" + idNews).forward(request, response);
                    break;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(SaveNewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //request.getRequestDispatcher("ViewNew?Noticia=" + idNews).forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
