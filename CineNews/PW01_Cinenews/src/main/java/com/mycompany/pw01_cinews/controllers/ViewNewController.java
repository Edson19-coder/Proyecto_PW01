/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pw01_cinews.controllers;

import com.mycompany.pw01_cinews.dao.AnswerDAO;
import com.mycompany.pw01_cinews.dao.CommentaryDAO;
import com.mycompany.pw01_cinews.dao.FavoriteNewsDAO;
import com.mycompany.pw01_cinews.dao.LikeAnswerDAO;
import com.mycompany.pw01_cinews.dao.LikeCommentaryDAO;
import com.mycompany.pw01_cinews.dao.LikeDislikesNewsDAO;
import com.mycompany.pw01_cinews.dao.MediaDAO;
import com.mycompany.pw01_cinews.dao.NewsDAO;
import com.mycompany.pw01_cinews.dao.UserDAO;
import com.mycompany.pw01_cinews.models.AnswerModel;
import com.mycompany.pw01_cinews.models.CommentaryModel;
import com.mycompany.pw01_cinews.models.FavoriteModel;
import com.mycompany.pw01_cinews.models.LikeAnswerModel;
import com.mycompany.pw01_cinews.models.LikeCommentaryModel;
import com.mycompany.pw01_cinews.models.LikeDislikeNewsModel;
import com.mycompany.pw01_cinews.models.MediaModel;
import com.mycompany.pw01_cinews.models.NewsModel;
import com.mycompany.pw01_cinews.models.UserModel;
import java.io.IOException;
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
@WebServlet(name = "ViewNew", urlPatterns = {"/ViewNew"})
public class ViewNewController extends HttpServlet {
    Integer idu = 0;
    UserModel author = null;
    NewsModel news = null;
    List<MediaModel> media = null;
    List<CommentaryModel> comments = null;
    List<AnswerModel> answers = null;
    Boolean isFavNew = null;
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
            HttpSession session = request.getSession();
            String id = request.getParameter("Noticia");
            idu = Integer.parseInt(id);
            news = NewsDAO.GetNewsById(idu);
            media = MediaDAO.GetMediaById(idu);
            author = UserDAO.UserSelectById(news.getNewsAuthor());
            comments = CommentaryDAO.SelectCommentsNews(idu);
            answers = AnswerDAO.SelectAnswerNews(idu);
            isFavNew = FavoriteNewsDAO.IsFavNew(idu, (Integer) session.getAttribute("id_user_session"));
            List<LikeCommentaryModel> likeNews = LikeCommentaryDAO.GetLikesByNew(idu);
            List<LikeAnswerModel> likeAnswerNews = LikeAnswerDAO.GetLikesAnswerByNew(idu);
            List<LikeDislikeNewsModel> listLikeDislike = LikeDislikesNewsDAO.GetLikesByNew(idu);
            request.setAttribute("listLikeDislike", listLikeDislike);
            request.setAttribute("likeAnswerNews", likeAnswerNews);
            request.setAttribute("likeNews", likeNews);
            request.setAttribute("isFavNew", isFavNew);
            request.setAttribute("News", news);
            request.setAttribute("Medias", media);
            request.setAttribute("User", author);
            request.setAttribute("Comments", comments);
            request.setAttribute("Answers", answers);
            request.getRequestDispatcher("viewnew.jsp").forward(request,response);
        } catch (SQLException ex) {
            Logger.getLogger(ViewNewController.class.getName()).log(Level.SEVERE, null, ex);
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
        String action = request.getParameter("accion");
        switch(action){
            case "Comentar":{
                String commentaryContent = request.getParameter("content");
                if(commentaryContent != null && commentaryContent != ""){
                    try {
                        HttpSession session = request.getSession();
                        Integer idNews = idu;
                        Integer idUser =(Integer) session.getAttribute("id_user_session");
                        java.util.Date dt = new java.util.Date();
                        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        String currentTime = sdf.format(dt);
                        CommentaryModel com = new CommentaryModel(commentaryContent, idNews, idUser, 0,currentTime);
                        CommentaryDAO.InsertCommentary(com);
                        comments = CommentaryDAO.SelectCommentsNews(idu);
                    } catch (SQLException ex) {
                        Logger.getLogger(ViewNewController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
            }
            
            case "Responder":{
                String commentaryContent = request.getParameter("content");
                if(commentaryContent != null && commentaryContent != ""){
                    try {
                        Integer commentaryId =Integer.parseInt(request.getParameter("comentario"));
                        HttpSession session = request.getSession();
                        Integer idNews = idu;
                        Integer idUser =(Integer) session.getAttribute("id_user_session");
                        java.util.Date dt = new java.util.Date();
                        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        String currentTime = sdf.format(dt);
                        AnswerDAO.InsertAnswer(new AnswerModel(commentaryContent, idNews, idUser, commentaryId, 0, currentTime));
                        answers = AnswerDAO.SelectAnswerNews(idu);
                    } catch (SQLException ex) {
                        Logger.getLogger(ViewNewController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
            }
        }
        request.setAttribute("isFavNew", isFavNew);
        request.setAttribute("Answers", answers);
        request.setAttribute("News", news);
        request.setAttribute("Medias", media);
        request.setAttribute("User", author);
        request.setAttribute("Comments", comments);
        request.getRequestDispatcher("viewnew.jsp").forward(request,response);
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
