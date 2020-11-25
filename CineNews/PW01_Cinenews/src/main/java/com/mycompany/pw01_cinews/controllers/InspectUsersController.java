/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pw01_cinews.controllers;

import com.mycompany.pw01_cinews.dao.UserDAO;
import com.mycompany.pw01_cinews.models.UserModel;
import com.mycompany.pw01_cinews.utils.TypeClass;
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
@WebServlet(name = "InspectUsers", urlPatterns = {"/InspectUsers"})
public class InspectUsersController extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
         List<UserModel> users = UserDAO.SelectAllUsers();
        request.setAttribute("Users", users);
        request.getRequestDispatcher("inspectusers.jsp").forward(request,response);
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(InspectUsersController.class.getName()).log(Level.SEVERE, null, ex);
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
        Integer id = Integer.parseInt(request.getParameter("idu"));
        String uts = request.getParameter("ut");
        String accion = request.getParameter("acc");
        Integer ut = TypeClass.GetUserTypeByString(uts);
        if(accion.equals("ascend") && ut < 4){
            ut = ut + 1;
            try {
                UserDAO.UserTypeUpdate(id, ut);
            } catch (SQLException ex) {
                Logger.getLogger(InspectUsersController.class.getName()).log(Level.SEVERE, null, ex);
            }
            request.getRequestDispatcher("Home").forward(request, response);
        }
        else if(accion.equals("descend") && ut > 0){
            ut = ut - 1;
            try {
                UserDAO.UserTypeUpdate(id, ut);
            } catch (SQLException ex) {
                Logger.getLogger(InspectUsersController.class.getName()).log(Level.SEVERE, null, ex);
            }
            request.getRequestDispatcher("Home").forward(request, response);
        }
        else if(ut <= 0)
            System.out.println("Ya no es posible descender mas");
        else if(ut >= 4)
            System.out.println("Ya no es posible ascender mas");
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
