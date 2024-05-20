/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;

import dals.CustomerDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author KieuVietPhuoc
 */
@WebServlet(name = "Signup", urlPatterns = {"/register"})
public class Signup extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            CustomerDAO dao = new CustomerDAO();
            String firstName = request.getParameter("txtFirstName");
            String lastName = request.getParameter("txtLastName");
            String email = request.getParameter("txtEmail");
            String username = request.getParameter("txtUserName");
            String password = request.getParameter("txtPassword");
            String rePassword = request.getParameter("txtPassword2");
            if (firstName != null && lastName != null && email != null && username != null && password != null && rePassword != null) {
                //check validate firstName by regex
                if (firstName.matches("^[a-zA-Z]{1,20}$")) {
                    //check validate lastName by regex
                    if (lastName.matches("^[a-zA-Z]{1,20}$")) {
                        //check validate email by regex
                        if (email.matches("^[a-zA-Z0-9]+@[a-zA-Z0-9]+(\\.[a-zA-Z0-9]+)+$")) {
                            //check validate username by regex
                            if (username.matches("^[a-zA-Z0-9]{1,20}$")) {

                                if (password.equals(rePassword)) {
                                    //check username exist
                                    if (!dao.checkUsername(username)) {
                                        //check email exist
                                        if (!dao.checkEmail(email)) {
                                            //insert customer
                                            if (dao.insertCustomer(firstName, lastName, email, username, password) > 0) {
                                                //send notify success to login page
                                                request.setAttribute("success", "Register success");
                                                request.getRequestDispatcher("sign-in.jsp").forward(request, response);

                                            } else {
                                                request.setAttribute("error", "Register fail");
                                                request.getRequestDispatcher("sign-up.jsp").forward(request, response);
                                            }
                                        } else {
                                            request.setAttribute("error", "Email is exist");
                                            request.getRequestDispatcher("sign-up.jsp").forward(request, response);
                                        }

                                    } else {
                                        request.setAttribute("error", "Username is exist");
                                        request.getRequestDispatcher("sign-up.jsp").forward(request, response);
                                    }
                                } else {
                                    request.setAttribute("error", "Password and Re-Password not match");
                                    request.getRequestDispatcher("sign-up.jsp").forward(request, response);
                                }
                            } else {
                                request.setAttribute("error", "Username is invalid");
                                request.getRequestDispatcher("sign-up.jsp").forward(request, response);

                            }
                        } else {
                            request.setAttribute("error", "Email is invalid");
                            request.getRequestDispatcher("sign-up.jsp").forward(request, response);
                        }
                    } else {
                        request.setAttribute("error", "Last name is invalid");
                        request.getRequestDispatcher("sign-up.jsp").forward(request, response);
                    }
                } else {
                    request.setAttribute("error", "First name is invalid");
                    request.getRequestDispatcher("sign-up.jsp").forward(request, response);
                }
            } else {

                request.getRequestDispatcher("sign-up.jsp").forward(request, response);
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
