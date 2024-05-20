/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import java.io.IOException;
import java.io.PrintWriter;

import dals.AccountProductDAO;
import dals.OrderDAO;
import dals.PaymentDAO;
import entities.Cart;
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
@WebServlet(name="payment", urlPatterns={"/payment"})
public class payment extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        PaymentDAO paymentDAO = new PaymentDAO();
        OrderDAO orderDAO = new OrderDAO();
        AccountProductDAO accountProductDAO = new AccountProductDAO();
        Customer customer = (Customer) request.getSession().getAttribute("customer");
        int customerID = customer.getCustomerID();
        String action = request.getParameter("action");
        Cart cart = new Cart();
        cart = (Cart) request.getSession().getAttribute("cart");
        int orderID = request.getParameter("orderID") == null ? 0 : Integer.parseInt(request.getParameter("orderID"));
        if (cart == null&& action == null) {
            response.sendRedirect("home");
        } else if(cart != null) {
            orderID = orderDAO.addOrderandOrderLine(cart, customer.getCustomerID());
            cart.clear();
            request.getSession().setAttribute("cart", cart);
        }


        //send total price to payment page
        request.setAttribute("orderID", orderID);
        double totalPrice = orderDAO.getTotalPrice(orderID);
        request.setAttribute("totalPrice", totalPrice);
        int subItem = orderDAO.getSubItem(orderID);
        request.setAttribute("subItem", subItem);
        if (action != null && action.equals("pay")) {
            orderID = Integer.parseInt(request.getParameter("orderID"));
            totalPrice = orderDAO.getTotalPrice(orderID);
            subItem = orderDAO.getSubItem(orderID);
            request.setAttribute("orderID", orderID);
            request.setAttribute("totalPrice", totalPrice);
            request.setAttribute("subItem", subItem);
            if (paymentDAO.checkTotalAccountProductStock(orderID)) {
                if (paymentDAO.checkAmountOfMoney(customerID, totalPrice)) {

                    paymentDAO.updateStatusPayment(orderID);
                    paymentDAO.updateHistoryOrder(orderID,"Paid");
                    if(accountProductDAO.updateAccountProductStatusSell(orderID)>0)paymentDAO.updateAmountOfMoney(customerID, totalPrice);
                    response.sendRedirect("orderhistory");
                } else {
                    request.setAttribute("message", "Not enough money");
                }
            


            }else {
                request.setAttribute("message", "Not enough stock");
            }
        }else if (action != null && action.equals("delete")) {
            orderID = Integer.parseInt(request.getParameter("orderID"));
            orderDAO.deleteOrder(orderID);
            response.sendRedirect("orderhistory");
        }
            request.getRequestDispatcher("payment.jsp").forward(request, response);

        
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

