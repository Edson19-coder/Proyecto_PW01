/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pw01_cinews.controllers;

import com.mycompany.pw01_cinews.dao.UserDAO;
import com.mycompany.pw01_cinews.models.UserModel;
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
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class LoginController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request,response);
    }

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
        processRequest(request, response);
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
        String userName = request.getParameter("user_name");
        String userPassword = request.getParameter("user_password");
        
        if(userName != "" && userPassword != ""){
            try {
                UserModel user_login = new UserModel(userName, userPassword);
                List<UserModel> user = UserDAO.SelectLoginUser(user_login);
                if (user.isEmpty() != true){
                    HttpSession session = request.getSession();
                    for (UserModel element : user){
                        session.setAttribute("name_user_session", element.getUser_name());
                        session.setAttribute("id_user_session", element.getIduser());
                        session.setAttribute("userType_user_session", element.getUser_type());
                        session.setAttribute("email_user_session", element.getEmail());
                        session.setAttribute("password_user_session", element.getPassword());
                        session.setAttribute("image_user_session", element.getPathImage());
                        session.setAttribute("facebook_user_session", element.getFacebook());
                        session.setAttribute("instagram_user_session", element.getInstragram());
                        session.setAttribute("descripcion_user_session", element.getSobreMi());
                    }
                    request.setAttribute("message_type", "Aviso");
                    request.setAttribute("message", "Ingresaste a tu cuenta");
                    request.getRequestDispatcher("Home").forward(request, response);
                }
                else{
                    request.setAttribute("message_type", "Error");
                    request.setAttribute("message", "Esta cuenta no existe");
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                }
            } catch (SQLException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            request.setAttribute("message_type", "Error");
            request.setAttribute("message", "Ingresa los datos faltantes");
            request.getRequestDispatcher("login.jsp").forward(request,response);
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
