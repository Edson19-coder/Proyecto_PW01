/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pw01_cinews.controllers;

import com.mycompany.pw01_cinews.dao.AnswerDAO;
import com.mycompany.pw01_cinews.dao.CommentaryDAO;
import com.mycompany.pw01_cinews.dao.LikeAnswerDAO;
import com.mycompany.pw01_cinews.dao.LikeCommentaryDAO;
import com.mycompany.pw01_cinews.models.LikeAnswerModel;
import com.mycompany.pw01_cinews.models.LikeCommentaryModel;
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
@WebServlet(name = "Commentary", urlPatterns = {"/Commentary"})
public class CommentaryController extends HttpServlet {

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
        String acc = request.getParameter("acc");
        Integer idNews = Integer.parseInt(request.getParameter("not"));
        switch (acc) {

            case "deleteCom": {
                try {
                    Integer idCom = Integer.parseInt(request.getParameter("comid"));
                    AnswerDAO.DeletAnswersByComment(idCom);
                    CommentaryDAO.DeleteCommentary(idCom);
                    request.getRequestDispatcher("ViewNew?Noticia=" + idNews).forward(request, response);
                    break;
                } catch (SQLException ex) {
                    Logger.getLogger(CommentaryController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            case "deleteAns": {
                try {
                    Integer idAns = Integer.parseInt(request.getParameter("ansid"));
                    AnswerDAO.DeletAnswer(idAns);
                    request.getRequestDispatcher("ViewNew?Noticia=" + idNews).forward(request, response);
                    break;
                } catch (SQLException ex) {
                    Logger.getLogger(CommentaryController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            case "likeCom": {
                try {
                    HttpSession session = request.getSession();
                    Integer idUserSession = (Integer) session.getAttribute("id_user_session");
                    Integer idCom = Integer.parseInt(request.getParameter("comid"));
                    LikeCommentaryModel like = new LikeCommentaryModel(idUserSession, idCom, idNews);
                    LikeCommentaryDAO.InsertLikeCommentary(like);
                    CommentaryDAO.MasLikeCommentary(idCom);
                    List<LikeCommentaryModel> likeNews = LikeCommentaryDAO.GetLikesByNew(idNews);
                    request.setAttribute("likeNews", likeNews);
                    request.getRequestDispatcher("ViewNew?Noticia=" + idNews).forward(request, response);
                    break;
                } catch (SQLException ex) {
                    Logger.getLogger(CommentaryController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            case "deleteLike": {
                try {
                    Integer idLike = Integer.parseInt(request.getParameter("likeid"));
                    Integer idCom = Integer.parseInt(request.getParameter("comid"));
                    LikeCommentaryDAO.DeleteLikeCommentary(idLike);
                    CommentaryDAO.MenosLikeCommentary(idCom);
                    request.getRequestDispatcher("ViewNew?Noticia=" + idNews).forward(request, response);
                    break;
                } catch (SQLException ex) {
                    Logger.getLogger(CommentaryController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }


            case "likeAns": {
                try {
                    HttpSession session = request.getSession();
                    Integer idUserSession = (Integer) session.getAttribute("id_user_session");
                    Integer idAns = Integer.parseInt(request.getParameter("ansid"));
                    LikeAnswerModel like = new LikeAnswerModel(idUserSession, idAns, idNews);
                    LikeAnswerDAO.InsertLikeAnswer(like);
                    AnswerDAO.MasLikeAnswer(idAns);
                    List<LikeAnswerModel> likeAnswerNews = LikeAnswerDAO.GetLikesAnswerByNew(idNews);
                    request.setAttribute("likeAnswerNews", likeAnswerNews);
                    request.getRequestDispatcher("ViewNew?Noticia=" + idNews).forward(request, response);
                    break;
                } catch (SQLException ex) {
                    Logger.getLogger(CommentaryController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            
            case "deleteLikeAns": {
                try {
                    Integer idLike = Integer.parseInt(request.getParameter("likeid"));
                     Integer idAns = Integer.parseInt(request.getParameter("ansid"));
                    LikeAnswerDAO.DeleteLikeAnswer(idLike);
                    AnswerDAO.MenosLikeAnswer(idAns);
                    request.getRequestDispatcher("ViewNew?Noticia=" + idNews).forward(request, response);
                    break;
                } catch (SQLException ex) {
                    Logger.getLogger(CommentaryController.class.getName()).log(Level.SEVERE, null, ex);
                }
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
