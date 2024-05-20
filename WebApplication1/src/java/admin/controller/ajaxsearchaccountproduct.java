/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package admin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import dals.AccountProductDAO;
import entities.AccountProduct;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author KieuVietPhuoc
 */
@WebServlet(name="ajaxsearchaccountproduct", urlPatterns={"/ajaxsearchaccountproduct"})
public class ajaxsearchaccountproduct extends HttpServlet {
   
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
    AccountProductDAO apd = new AccountProductDAO();
    String nameProductsearch = request.getParameter("nameProductsearch");
    Vector<AccountProduct> listAccountProduct = apd.searchAccountProductByName(nameProductsearch);
    int index = -1;
    for (AccountProduct accountProduct : listAccountProduct) {
        index++;
        out.println("<tr>");
        out.println("<td class=\"active1\">" + accountProduct.getAccountProductID() + "</td>");
        out.println("<td class=\"active2 getValue hide\"><input  type=\"text\" value=\"" + accountProduct.getAccountProductID() + "\" name=\"idaccproduct\"></td>");
        out.println("<td class=\"active1\">" + accountProduct.getInfoAccount() + "</td>");
        out.println("<td class=\"active2 getValue hide\"><input  value=\"" + accountProduct.getInfoAccount() + "\" type=\"text\"  name=\"infoacc\"></td>");
        out.println("<td class=\"active1\">" + accountProduct.getProduct().getProductName() + "</td>");
        out.println("<td class=\"active2 getValue hide\"><input  type=\"text\" value=\"" + accountProduct.getProduct().getProductName() + "\" name=\"nameproduct\"></td>");
        out.println("<td class=\"active1\">" + (accountProduct.isStatusSell() ? "Sell" : "Not Sell") + "</td>");
        out.println("<td class=\"active2 getValue hide\"><input  type=\"text\" value=\"" + accountProduct.isStatusSell() + "\" name=\"statussell\"></td>");
        out.println("<td class=\"active1\">" + accountProduct.getOrderDetail().getOrder().getOrderID() + "</td>");
        out.println("<td class=\"active2 getValue hide\"><input  type=\"text\" value=\"" + accountProduct.getOrderDetail().getOrder().getOrderID() + "\" name=\"orderID\"></td>");
        out.println("<td>");
        out.println("<button class=\"active1 btn btn--rounded\" style=\"background-color:red;color: white\" onclick=\"deleteProduct(" + accountProduct.getAccountProductID() + ")\">Delete</button>");
        out.println("<button class=\"active1 btn \" style=\"background-color:green;color: white\" onclick=\"unhideUpdate()\">Update</button>");
        out.println("<button class=\"active2 hide btn \" style=\"background-color:green;color: white\" onclick=\"updateProduct(" + index + "," + accountProduct.getAccountProductID() + ")\">Save</button>");
        out.println("</td>");
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
