/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pw01_cinews.controllers;

import com.mycompany.pw01_cinews.dao.CategoryDAO;
import com.mycompany.pw01_cinews.dao.MediaDAO;
import com.mycompany.pw01_cinews.dao.NewsDAO;
import com.mycompany.pw01_cinews.models.CategoryModel;
import com.mycompany.pw01_cinews.models.MediaModel;
import com.mycompany.pw01_cinews.models.NewsModel;
import com.mycompany.pw01_cinews.utils.FileUtils;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
@WebServlet(name = "CreateNew", urlPatterns = {"/CreateNew"})
@MultipartConfig(maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 25)
public class CreateNewController extends HttpServlet {

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
            List<CategoryModel> categories = null;
            categories = CategoryDAO.GetCategories();
            request.setAttribute("Categories", categories);
            request.getRequestDispatcher("createnew.jsp").forward(request,response);
        } catch (SQLException ex) {
            Logger.getLogger(CreateNewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.getRequestDispatcher("createnew.jsp").forward(request,response);
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
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String content = request.getParameter("content");
        String stringCategory = request.getParameter("category");
        int category = Integer.parseInt(stringCategory, 10);
        //Media 1
        Part file = request.getPart("image");
        String nameImage = file.getName() + System.currentTimeMillis() + FileUtils.GetExtension(file.getContentType());
        String path = request.getServletContext().getRealPath("");
        String fullPath = path + FileUtils.RUTE_USER_IMAGE + "/" + nameImage;
        file.write(fullPath);
        fullPath = FileUtils.RUTE_USER_IMAGE + "/" + nameImage;
        //Media 2
        Part file2 = request.getPart("image2");
        String nameImage2 = file2.getName() + System.currentTimeMillis() + FileUtils.GetExtension(file2.getContentType());
        String path2 = request.getServletContext().getRealPath("");
        String fullPath2 = path2 + FileUtils.RUTE_USER_IMAGE + "/" + nameImage2;
        file2.write(fullPath2);
        fullPath2 = FileUtils.RUTE_USER_IMAGE + "/" + nameImage2;
        //Media 3  
        Part file3 = request.getPart("image3");
        String nameImage3 = file3.getName() + System.currentTimeMillis() + FileUtils.GetExtension(file3.getContentType());
        String path3 = request.getServletContext().getRealPath("");
        String fullPath3 = path3 + FileUtils.RUTE_USER_IMAGE + "/" + nameImage3;
        file3.write(fullPath3);
        fullPath3 = FileUtils.RUTE_USER_IMAGE + "/" + nameImage3;  
        
        HttpSession session = request.getSession();
        String user_id_string = session.getAttribute("id_user_session").toString();
        Integer user_id = Integer.parseInt(user_id_string);
        java.util.Date dt = new java.util.Date(); 
        java.text.SimpleDateFormat sdf = 
        new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = sdf.format(dt); 
        if(title != null || description != null || content != null){
            if((title != null && description != null && content != null) && (!"".equals(title) && !"".equals(description) && !"".equals(content))){
                try {
                    NewsModel news = new NewsModel(title, description, content, category, user_id, 1, currentTime);
                    NewsDAO.InsertNews(news);
                    int id = NewsDAO.GetLastId();
                    MediaModel media = new MediaModel(fullPath, id);
                    MediaDAO.InsertMedia(media);
                    media.setMediaUrl(fullPath2);
                    MediaDAO.InsertMedia(media);
                    media.setMediaUrl(fullPath3);
                    MediaDAO.InsertMedia(media);
                    request.getRequestDispatcher("Home").forward(request,response);
                } catch (SQLException ex) {
                    Logger.getLogger(CreateNewController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else{
                try {
                    NewsModel news = new NewsModel(title, description, content, category, user_id, 0, currentTime);
                    NewsDAO.InsertNews(news);
                } catch (SQLException ex) {
                    Logger.getLogger(CreateNewController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        request.getRequestDispatcher("Home").forward(request,response);
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
