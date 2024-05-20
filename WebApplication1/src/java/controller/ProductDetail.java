/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import dals.ProductDAO;
import entities.Cart;
import entities.Item;
import entities.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author KieuVietPhuoc
 */
@WebServlet(name = "ProductDetail", urlPatterns = {"/product"})
public class ProductDetail extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        ProductDAO dao = new ProductDAO();
        if (session.getAttribute("customer") == null) {
            response.sendRedirect("home");
        } else {
            String action = request.getParameter("action");
            if (action.equals("view")) {
                
                try {
                    int id = Integer.parseInt(request.getParameter("id"));
                    Product product = dao.getProductByID(id);
                    request.setAttribute("p", product);
                    request.getRequestDispatcher("product-detail.jsp").forward(request, response);
                } catch (Exception e) {
                    response.sendRedirect("home");
                }
            }else if(action.equals("add")) {
                //request array Cookies
                Cookie[] cookies = request.getCookies();
                //add cart to list cookie name "cart" with parameter idProduct and quantity
                if (request.getParameter("idCustomer") != null && request.getParameter("quantity") != null) {

                    int idProduct = Integer.parseInt(request.getParameter("idCustomer"));
                    int quantity = Integer.parseInt(request.getParameter("quantity"));
                    String txtCookie = "";
                    if (cookies != null) {
                        for (Cookie cookie : cookies) {
                            if (cookie.getName().equals("cart")) {
                                txtCookie += cookie.getValue();
                            }
                        }
                    }
                    Cart cart = new Cart();
                    Vector<Item> listCart = cart.getItems();
                    int n;
                    if (txtCookie != "" ) {
                        String[] txtCookieSplit = txtCookie.split("-");
                        for (int i = 0; i < txtCookieSplit.length; i++) {
                            String[] txtCookieSplit2 = txtCookieSplit[i].split(":");
                            int id = Integer.parseInt(txtCookieSplit2[0]);
                            int quantity1 = Integer.parseInt(txtCookieSplit2[1]);
                            Product product = dao.getProductByID(id);
                            Item item = new Item(product, quantity1);
                            cart.addItem(item);
                        }
                    }
                    Product product = dao.getProductByID(idProduct);
                    Item item = new Item(product, quantity);
                    cart.addItem(item);
                    listCart = cart.getItems();
                    String txtCookie1 = "";
                    for (Item item1 : listCart) {
                        txtCookie1 += item1.getProduct().getProductID() + ":" + item1.getQuantity() + "-";
                    }
                    Cookie cookie = new Cookie("cart", txtCookie1);
                    cookie.setMaxAge(60 * 60 * 24 * 30);
                    response.addCookie(cookie);
                    response.sendRedirect("home");

                }
            }




        }

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
        processRequest(request, response);
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
