/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pw01_cinews.controllers;

import com.mycompany.pw01_cinews.dao.MediaDAO;
import com.mycompany.pw01_cinews.dao.NewsDAO;
import com.mycompany.pw01_cinews.models.MediaModel;
import com.mycompany.pw01_cinews.models.NewsModel;
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
@WebServlet(name = "Reviews", urlPatterns = {"/Reviews"})
public class ReviewsController extends HttpServlet {

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
            List<NewsModel> news = null;
            news = NewsDAO.GetNews();
            request.setAttribute("News", news);
            List<MediaModel> media = null;
            media = MediaDAO.GetMedia();
            request.setAttribute("Medias", media);
            request.getRequestDispatcher("reviewsnews.jsp").forward(request,response);
        } catch (SQLException ex) {
            Logger.getLogger(ReviewsController.class.getName()).log(Level.SEVERE, null, ex);
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
        try {
            String accion = request.getParameter("accion");
            String comentario = request.getParameter("content");
            Integer idNews =Integer.parseInt(request.getParameter("NewId"));
            switch(accion){
                case "aceptado":{
                    try {
                        NewsDAO.UpdateStatus(idNews, comentario, 2);
                    } catch (SQLException ex) {
                        Logger.getLogger(ReviewsController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                }
                
                case "rechazado":{
                    try {
                        NewsDAO.UpdateStatus(idNews, comentario, 3);
                    } catch (SQLException ex) {
                        Logger.getLogger(ReviewsController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                }
            }
            List<NewsModel> news = NewsDAO.GetNews();
            request.setAttribute("News", news);
            List<MediaModel> media = MediaDAO.GetMedia();
            request.setAttribute("Medias", media);
            request.getRequestDispatcher("reviewsnews.jsp").forward(request,response);
        } catch (SQLException ex) {
            Logger.getLogger(ReviewsController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
