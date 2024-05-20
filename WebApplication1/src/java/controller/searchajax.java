/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dals.ProductDAO;
import entities.Product;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Vector;

/**
 *
 * @author KieuVietPhuoc
 */
@WebServlet(name="searchajax", urlPatterns={"/searchajax"})
public class searchajax extends HttpServlet {
   
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
            Vector<Product> listProduct = new Vector<Product>();
            String searchName = request.getParameter("searchInput");
            ProductDAO daoProduct = new ProductDAO();
            listProduct = daoProduct.searchProductByName(searchName);
            int index=-1;
            for (Product product : listProduct) {
                index++;
                out.println("<tr>");
                out.println("    <td class=\"active1\">" + product.getProductName() + "</td>");
                out.println("    <td><input class=\"active2 getValue hide\" type=\"text\" value=\"" + product.getProductName() + "\" name=\"productName\"></td>");
                out.println("    <td class=\"active1\">" + product.getProductType().getTypeName() + "</td>");
                out.println("    <td><input class=\"active2 getValue hide\" value=\"" + product.getProductType().getTypeName() + "\" type=\"text\" name=\"typeProduct\"></td>");
                out.println("    <td class=\"active1\">" + product.getDescription() + "</td>");
                out.println("    <td><input class=\"active2 getValue hide\" type=\"text\" value=\"" + product.getDescription() + "\" name=\"descriptionProduct\"></td>");
                out.println("    <td class=\"active1\">" + product.getPrice() + "</td>");
                out.println("    <td><input class=\"active2 getValue hide\" type=\"text\" value=\"" + product.getPrice() + "\" name=\"priceProduct\"></td>");
                out.println("    <td class=\"active1\"><img src=\"" + product.getThumbnailURL() + "\" alt=\"picture\" width=\"100px\" height=\"100px\"></td>");
                out.println("    <td><input class=\"active2 getValue hide\" type=\"text\" value=\"" + product.getThumbnailURL() + "\" name=\"thumbnailProduct\"></td>");
                out.println("    <td>");
                out.println("        <button class=\"active1 btn btn--rounded\" style=\"background-color:red;color: white\" onclick=\"deleteProduct(" + product.getProductID() + ")\">Delete</button>");
                out.println("        <button class=\"active1 btn\" style=\"background-color:green;color: white\" onclick=\"unhideUpdate()\">Update</button>");
                out.println("        <button class=\"active2 hide btn\" style=\"background-color:green;color: white\" onclick=\"updateProduct(" + index + "," + product.getProductID() + ")\">Save</button>");
                out.println("    </td>");
                out.println("</tr>");
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
