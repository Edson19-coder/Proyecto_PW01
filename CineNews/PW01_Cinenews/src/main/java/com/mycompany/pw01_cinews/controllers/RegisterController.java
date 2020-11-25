/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pw01_cinews.controllers;

import com.mycompany.pw01_cinews.dao.UserDAO;
import com.mycompany.pw01_cinews.models.UserModel;
import com.mycompany.pw01_cinews.utils.Validaciones;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
@WebServlet(name = "Register", urlPatterns = {"/Register"})
public class RegisterController extends HttpServlet {

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
        request.getRequestDispatcher("register.jsp").forward(request,response);
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
        try {
            String userName = request.getParameter("user_name");
            String userEmail = request.getParameter("user_email");
            String userPassword = request.getParameter("user_password");
            String userPasswordConf = request.getParameter("user_password_conf");
            Validaciones val = new Validaciones();
            Boolean isEmail = val.email_val(userEmail);
            Boolean isPassword = val.password_val(userPassword, userPasswordConf);
            Boolean isUser = UserDAO.userExistsByName(userName);
            Boolean isEmail2 = UserDAO.userExistsByEmail(userEmail);
            if(userName != "" && userEmail != "" && userPassword != "" && userPasswordConf != ""){
                if(isEmail == true && isPassword == true && isUser == false && isEmail2 == false){
                    UserModel usernew = new UserModel(userName, userPassword, 0, userEmail);
                    Integer insert = UserDAO.InserUser(usernew);
                    if(insert == 1)
                        System.out.println("Registrado");
                    else
                        request.setAttribute("message_type", "Error");
                    request.setAttribute("message", "Error fatal , no registrado");
                    request.getRequestDispatcher("home.jsp").forward(request,response);
                }
                else if(isUser == true){
                    request.setAttribute("message_type", "Error");
                    request.setAttribute("message", "User name not available");
                    request.getRequestDispatcher("register.jsp").forward(request,response);
                }
                else if(isEmail2 == true){
                    request.setAttribute("message_type", "Error");
                    request.setAttribute("message", "Mail not available");
                    request.getRequestDispatcher("register.jsp").forward(request,response);
                }
                else if(isEmail == false){
                    request.setAttribute("message_type", "Error");
                    request.setAttribute("message", "Mail not valid");
                    request.getRequestDispatcher("register.jsp").forward(request,response);
                }
                else if(isPassword == false){
                    request.setAttribute("message_type", "Error");
                    request.setAttribute("message", "The passwords do not match");
                    request.getRequestDispatcher("register.jsp").forward(request,response);
                }
            }
            else{
                request.setAttribute("message_type", "Error");
                request.setAttribute("message", "Enter the missing data");
                request.getRequestDispatcher("register.jsp").forward(request,response);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegisterController.class.getName()).log(Level.SEVERE, null, ex);
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
