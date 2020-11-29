/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pw01_cinews.controllers;

import com.mycompany.pw01_cinews.dao.UserDAO;
import com.mycompany.pw01_cinews.models.UserModel;
import com.mycompany.pw01_cinews.utils.FileUtils;
import java.io.IOException;
import java.io.InputStream;
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
@WebServlet(name = "MySettings", urlPatterns = {"/MySettings"})
@MultipartConfig(maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 25)
public class MySettingsController extends HttpServlet {


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
        
        request.getRequestDispatcher("mysettings.jsp").forward(request, response);
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
            HttpSession session = request.getSession();
            Integer iduser = (Integer) session.getAttribute("id_user_session");
            String userName = request.getParameter("userName");
            Boolean isUser = UserDAO.userExistsByName(userName);
            if (isUser == false || userName.equals((String) session.getAttribute("name_user_session"))) {
                String userEmail = request.getParameter("userEmail");
                String userPass = request.getParameter("userPass");
                String userFace = request.getParameter("userFace");
                String userInsta = request.getParameter("userInsta");
                String userSobrMy = request.getParameter("content");
                Part file = request.getPart("image");
                InputStream inputStream = file.getInputStream();
                String fullPath = null;
                if (inputStream.available() != 0) {
                    String nameImage = file.getName() + System.currentTimeMillis() + FileUtils.GetExtension(file.getContentType());
                    String path = request.getServletContext().getRealPath("");
                    fullPath = path + FileUtils.RUTE_USER_IMAGE + "/" + nameImage;
                    file.write(fullPath);
                    fullPath = FileUtils.RUTE_USER_IMAGE + "/" + nameImage;
                }

                if ((userName != null && userEmail != null && userPass != null) && (!"".equals(userName) && !"".equals(userEmail) && !"".equals(userPass))) {
                    try {
                        UserModel edit = null;
                        if(inputStream.available() != 0){
                            edit = new UserModel(iduser, userName, userPass, userEmail, userFace, userInsta, fullPath, userSobrMy);
                        }else{
                            edit = new UserModel(iduser, userName, userPass, userEmail, userFace, userInsta,(String) session.getAttribute("image_user_session"), userSobrMy);
                        }
                        UserDAO.UserUpdate(edit);
                        UserModel user_login = new UserModel(edit.getUser_name(), edit.getPassword());
                        List<UserModel> user = UserDAO.SelectLoginUser(user_login);
                        if (user.isEmpty() != true){
                            for (UserModel element : user){
                                session.setAttribute("name_user_session", element.getUser_name());
                                session.setAttribute("id_user_session", element.getIduser());
                                session.setAttribute("userType_user_session", element.getUser_type());
                                session.setAttribute("email_user_session", element.getEmail());
                                session.setAttribute("password_user_session", element.getPassword());
                                if (inputStream.available() != 0) {
                                session.setAttribute("image_user_session", element.getPathImage());
                                }
                                session.setAttribute("facebook_user_session", element.getFacebook());
                                session.setAttribute("instagram_user_session", element.getInstragram());
                                session.setAttribute("descripcion_user_session", element.getSobreMi());
                            }
                    }
                        
                    } catch (SQLException ex) {
                        Logger.getLogger(MySettingsController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }else{
                request.setAttribute("message_type", "Error");
                request.setAttribute("message", "User name not available");
            }
            request.getRequestDispatcher("mysettings.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(MySettingsController.class.getName()).log(Level.SEVERE, null, ex);
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
