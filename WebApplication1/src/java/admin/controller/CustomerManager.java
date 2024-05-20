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
@WebServlet(name="CustomerManager", urlPatterns={"/admincustomer"})
public class CustomerManager extends HttpServlet {
   
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
        CustomerDAO daoCustomer = new CustomerDAO();
        Vector<Customer> listCustomer = daoCustomer.getAllCumstomer();
        String idCustomer = request.getParameter("idCustomer");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String balance = request.getParameter("balance");
        String action = request.getParameter("action");

        if (request.getSession().getAttribute("admin") == null) {
            request.setAttribute("errorAdmin", "Không phận sự miễn vào");
            request.getRequestDispatcher("login").forward(request, response);
        } else {
            if (action != null) {
               if (action.equals("edit")) {
                    Customer customer = new Customer();
                    customer = daoCustomer.getCustomerByID(Integer.parseInt(idCustomer));
                    customer.setCustomerID(Integer.parseInt(idCustomer));
                    customer.setFirstName(firstName);
                    customer.setLastName(lastName);
                    customer.setEmail(email);
                    customer.setCurrentBalance(Double.parseDouble(balance));
                    daoCustomer.editCustomer(customer);
                } else if (action.equals("delete")) {
                    daoCustomer.deleteCustomer(Integer.parseInt(idCustomer));
                }
            }
            request.setAttribute("listCustomer", listCustomer);
            request.getRequestDispatcher("./Admin/CumstomerManager.jsp").forward(request, response);
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
