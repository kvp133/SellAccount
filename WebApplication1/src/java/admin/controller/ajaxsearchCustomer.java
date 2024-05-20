/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package admin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

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
@WebServlet(name="ajaxsearchCustomer", urlPatterns={"/ajaxsearchCustomer"})
public class ajaxsearchCustomer extends HttpServlet {
   
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
        PrintWriter out = response.getWriter();
        String idSearch = request.getParameter("idSearch");
        CustomerDAO daoCustomer = new CustomerDAO();
        Vector<Customer> listCustomer = daoCustomer.searchCustomer(idSearch);
        int index=-1;
        for (Customer product : listCustomer) {
            index++;
            out.println("<tr>");
            out.println("<td class=\"active1\">" + product.getCustomerID() + "</td>");
            out.println("<td class=\"active2 getValue hide\"><input type=\"text\" value=\"" + product.getCustomerID() + "\" name=\"idCustomer\" readonly></td>");
            out.println("<td class=\"active1\">" + product.getFirstName() + "</td>");
            out.println("<td class=\"active2 getValue hide\"><input value=\"" + product.getFirstName() + "\" type=\"text\" name=\"firstName\"></td>");
            out.println("<td class=\"active1\">" + product.getLastName() + "</td>");
            out.println("<td class=\"active2 getValue hide\"><input value=\"" + product.getLastName() + "\" type=\"text\" name=\"lastName\"></td>");
            out.println("<td class=\"active1\">" + product.getEmail() + "</td>");
            out.println("<td class=\"active2 getValue hide\"><input type=\"text\" value=\"" + product.getEmail() + "\" name=\"email\"></td>");
            out.println("<td class=\"active1\">" + product.getCurrentBalance() + "</td>");
            out.println("<td class=\"active2 getValue hide\"><input type=\"text\" value=\"" + product.getCurrentBalance() + "\" name=\"balance\"></td>");
            out.println("<td><button class=\"active1 btn btn--rounded\" style=\"background-color:red;color: white\" onclick=\"deleteProduct(" + product.getCustomerID() + ")\">Delete</button>");
            out.println("<button class=\"active1 btn\" style=\"background-color:green;color: white\" onclick=\"unhideUpdate()\">Update</button>");
            out.println("<button class=\"active2 hide btn\" style=\"background-color:green;color: white\" onclick=\"updateProduct(" + index + "," + product.getCustomerID() + ")\">Save</button></td>");
            out.println("</tr>");
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
