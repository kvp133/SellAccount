/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dals.AccountProductDAO;
import dals.OrderDAO;
import dals.ProductDAO;
import entities.Cart;
import java.io.IOException;
import java.io.PrintWriter;

import entities.Customer;
import entities.Item;
import entities.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author KieuVietPhuoc
 */
@WebServlet(name="checkout2", urlPatterns={"/checkout"})
public class checkout2 extends HttpServlet {
   
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
        Customer customer = (Customer) request.getSession().getAttribute("customer");
       Cookie[] cookies = request.getCookies();
       Cart cart = new Cart();
       ProductDAO daoProduct = new ProductDAO();
       OrderDAO daoOrder = new OrderDAO();
       AccountProductDAO accountProductDAO = new AccountProductDAO();
       if (cookies != null) {
              for (Cookie cookie : cookies) {
                if (cookie.getName().equals("cart")) {
                     String value = cookie.getValue();
                     String[] list = value.split("-");
                     for (String s : list) {
                          String[] item = s.split(":");
                          if (item.length == 2) {
                            int id = Integer.parseInt(item[0]);
                            int quantity = Integer.parseInt(item[1]);
                            Item i = new Item(daoProduct.getProductByID(id), quantity);
                            cart.addItem(i);
                          }
                     }
                }
              }
              
       }
       if(cart.getSize() == 0){
           response.sendRedirect("home");
       }
       String action = request.getParameter("action");
       boolean check = false;
       // if action is not null and equal to checkout then add all items in cart to database
       if(action != null && action.equals("checkout")){
           // check account in stock or not if not then return to home page
                for(Item item: cart.getItems()){
                    if(!accountProductDAO.checkAccountInStock(item.getQuantity(), item.getProduct().getProductID())){
                        request.setAttribute("error", "Product "+item.getProduct().getProductName()+" is out of stock");
                        item.setQuantity(accountProductDAO.getQuantityInStock(item.getProduct().getProductID()));
                        request.setAttribute("cartInfo", cart);
                        check = true;
                    }
                    String value="";

                        value += item.getProduct().getProductID() + ":" + item.getQuantity() + "-";

                    if (value.length() > 0) {
                        value = value.substring(0, value.length() - 1);
                    }
                    if (value.length() > 0) {
                        Cookie c = new Cookie("cart", value);
                        c.setMaxAge(60 * 60 * 24);
                        response.addCookie(c);
                    }
                }
                if(check){
                    request.getRequestDispatcher("checkout.jsp").forward(request, response);
                    return;
                }
         //set session cart
           if (!check) {
               Cookie cookie = new Cookie("cart", "");
               cookie.setMaxAge(0);
               response.addCookie(cookie);
           }
         request.getSession().setAttribute("cart", cart);
         response.sendRedirect("payment?orderID="+(daoOrder.getLastIndex()+1));
         return;
                
       }else if (action != null && action.equals("remove")) {
           int id = Integer.parseInt(request.getParameter("id"));
           cart.removeItemById(id);
           String value = "";
           for (Item item : cart.getItems()) {
               value += item.getProduct().getProductID() + ":" + item.getQuantity() + "-";
           }
           if (value.length() > 0) {
               value = value.substring(0, value.length() - 1);
           }
           if (value.length() > 0) {
               Cookie c = new Cookie("cart", value);
               c.setMaxAge(60 * 60 * 24);
               response.addCookie(c);
           } else {
               Cookie c = new Cookie("cart", "");
               c.setMaxAge(0);
               response.addCookie(c);
           }

       } else if (action != null && action.equals("plus")) {
           //minus 1 quantity
           int id = Integer.parseInt(request.getParameter("id"));
           int quantity = Integer.parseInt(request.getParameter("quantity"));
           if (quantity > 1) {
               cart.updateItem(id, quantity - 1);
               String value = "";
               for (Item item : cart.getItems()) {
                   value += item.getProduct().getProductID() + ":" + item.getQuantity() + "-";
               }
               if (value.length() > 0) {
                   value = value.substring(0, value.length() - 1);
               }
               if (value.length() > 0) {
                   Cookie c = new Cookie("cart", value);
                   c.setMaxAge(60 * 60 * 24);
                   response.addCookie(c);
               } else {
                   Cookie c = new Cookie("cart", "");
                   c.setMaxAge(0);
                   response.addCookie(c);
               }
           }

       } else if (action != null && action.equals("minus")) {
           //plus 1 quantity
           int id = Integer.parseInt(request.getParameter("id"));
           int quantity = Integer.parseInt(request.getParameter("quantity"));
           cart.updateItem(id, quantity + 1);
           String value = "";
           for (Item item : cart.getItems()) {
               value += item.getProduct().getProductID() + ":" + item.getQuantity() + "-";
           }
           if (value.length() > 0) {
               value = value.substring(0, value.length() - 1);
           }
           if (value.length() > 0) {
               Cookie c = new Cookie("cart", value);
               c.setMaxAge(60 * 60 * 24);
               response.addCookie(c);
           } else {
               Cookie c = new Cookie("cart", "");
               c.setMaxAge(0);
               response.addCookie(c);
           }
       }
       request.setAttribute("cartInfo", cart);
       request.getRequestDispatcher("checkout.jsp").forward(request, response);



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
