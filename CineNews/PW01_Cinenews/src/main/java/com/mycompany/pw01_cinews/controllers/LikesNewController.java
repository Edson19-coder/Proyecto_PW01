/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pw01_cinews.controllers;

import com.mycompany.pw01_cinews.dao.LikeDislikesNewsDAO;
import com.mycompany.pw01_cinews.dao.NewsDAO;
import com.mycompany.pw01_cinews.models.LikeDislikeNewsModel;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
@WebServlet(name = "LikesNew", urlPatterns = {"/LikesNew"})
public class LikesNewController extends HttpServlet {

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
        Integer idNews = Integer.parseInt(request.getParameter("not"));
        String acc = request.getParameter("acc");
        HttpSession session = request.getSession();
        Integer idUser = (Integer) session.getAttribute("id_user_session");
        switch (acc) {
            case "likeNew": {
                try {
                    LikeDislikeNewsModel likeUser = LikeDislikesNewsDAO.GetLikesByUser(idUser, idNews);
                    if(likeUser != null && likeUser.getPlikedislikenewsType() == 2){
                        likeUser.setPlikedislikenewsType(1);
                        LikeDislikesNewsDAO.UpdateLikeDislikeNew(likeUser);
                        NewsDAO.LikeInteraction("DD", idNews);
                        NewsDAO.LikeInteraction("L", idNews);
                    }
                    else if(likeUser != null && likeUser.getPlikedislikenewsType() == 1){
                        LikeDislikesNewsDAO.DeleteLikeDislikeNew(likeUser);
                        NewsDAO.LikeInteraction("LD", idNews);
                    }
                    else{
                        LikeDislikeNewsModel LikeDeslikeNew = new LikeDislikeNewsModel(idUser, idNews, 1);
                        LikeDislikesNewsDAO.InsertLikeDislikeNew(LikeDeslikeNew);
                        NewsDAO.LikeInteraction("L", idNews);
                    }
                    List<LikeDislikeNewsModel> listLikeDislike = LikeDislikesNewsDAO.GetLikesByNew(idNews);
                    request.setAttribute("listLikeDislike", listLikeDislike);
                    request.getRequestDispatcher("ViewNew?Noticia=" + idNews).forward(request, response);
                } catch (SQLException ex) {
                    Logger.getLogger(LikesNewController.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            }

            case "dislikeNew": {
                try {
                    LikeDislikeNewsModel likeUser = LikeDislikesNewsDAO.GetLikesByUser(idUser, idNews);
                    if(likeUser != null && likeUser.getPlikedislikenewsType() == 1){
                        likeUser.setPlikedislikenewsType(2);
                        LikeDislikesNewsDAO.UpdateLikeDislikeNew(likeUser);
                        NewsDAO.LikeInteraction("LD", idNews);
                        NewsDAO.LikeInteraction("DL", idNews);
                    }
                    else if(likeUser != null && likeUser.getPlikedislikenewsType() == 2){
                        LikeDislikesNewsDAO.DeleteLikeDislikeNew(likeUser);
                        NewsDAO.LikeInteraction("DD", idNews);
                    }
                    else{
                        LikeDislikeNewsModel LikeDeslikeNew = new LikeDislikeNewsModel(idUser, idNews, 2);
                        LikeDislikesNewsDAO.InsertLikeDislikeNew(LikeDeslikeNew);
                        NewsDAO.LikeInteraction("DL", idNews);
                    }
                    request.getRequestDispatcher("ViewNew?Noticia=" + idNews).forward(request, response);
                } catch (SQLException ex) {
                    Logger.getLogger(LikesNewController.class.getName()).log(Level.SEVERE, null, ex);
                }
                 break;
            }

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
        Integer idNews = Integer.parseInt(request.getParameter("not"));
        request.getRequestDispatcher("ViewNew?Noticia=" + idNews).forward(request, response);
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
