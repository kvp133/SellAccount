/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import java.io.IOException;
import java.io.PrintWriter;

import dals.CustomerDAO;
import entities.Customer;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author KieuVietPhuoc
 */
@WebServlet(name="Signin", urlPatterns={"/login"})
public class Signin extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            CustomerDAO dao = new CustomerDAO();
            String username = request.getParameter("txtUsername");
            String password = request.getParameter("txtPassword");

            //check username is email or username if username using method login getCustomerByUsername
            if(username!=null&&password!=null){
                if(username.matches("^[a-zA-Z0-9]+@[a-zA-Z0-9]+(\\.[a-zA-Z0-9]+)+$")){
                    Customer customer = dao.getCustomerByEmail(username, password);
                    if(customer!=null){
                        request.getSession().setAttribute("customer", customer);
                        response.sendRedirect("home");
                    }else{
                        request.setAttribute("error", "Username or password is incorrect");
                        request.getRequestDispatcher("sign-in.jsp").forward(request, response);
                    }
                }else{
                    Customer customer = dao.getCustomerByUsername(username, password);
                    if(customer!=null){
                        request.getSession().setAttribute("customer", customer);
                        response.sendRedirect("home");
                    }else{
                        request.setAttribute("error", "Username or password is incorrect");
                        request.getRequestDispatcher("sign-in.jsp").forward(request, response);
                    }
                }
            }else {
                request.getRequestDispatcher("sign-in.jsp").forward(request, response);
            }
        }

    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
