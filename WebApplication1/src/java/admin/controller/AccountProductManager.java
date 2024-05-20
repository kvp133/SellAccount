/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package admin.controller;

import java.io.IOException;
import java.io.PrintWriter;

import dals.AccountProductDAO;
import dals.ProductDAO;
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
@WebServlet(name="AccountProductManager", urlPatterns={"/adminaccountproduct"})
public class AccountProductManager extends HttpServlet {
   
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
        AccountProductDAO dao = new AccountProductDAO();
        ProductDAO daoProduct = new ProductDAO();

        String id = request.getParameter("idaccproduct");
        String infoAcc  = request.getParameter("infoacc");
        String nameProduct = request.getParameter("nameproduct");
        String statusSell = request.getParameter("statussell");
        String action = request.getParameter("action");
        //helo

        if(action != null){
            if(action.equals("add")){
                String getProductName = request.getParameter("productNameadd");
                String getInfoAccount = request.getParameter("listaccount");
                System.out.println(getInfoAccount);
                if(getProductName!=null&&getInfoAccount!=null){
                    //split getInfoAccount to vector one value one line
                    String[] arrInfoAccount = getInfoAccount.split("\n");
                    for(String infoAccount : arrInfoAccount){
                        dao.addAccountProduct(getProductName, infoAccount);
                    }
                    request.setAttribute("message", "Add success!");
                }
            }else if(action.equals("update")){
                boolean statusSell1 = true;
                if(statusSell.equals("0")||statusSell.equals("false")){
                    statusSell1 = false;
                }
                int idAccProduct = Integer.parseInt(id);

                if(id!=null&&infoAcc!=null&&nameProduct!=null&&statusSell!=null) {
                    AccountProduct accProduct = dao.getAccountProduct(idAccProduct);
                    accProduct.setInfoAccount(infoAcc);
                    accProduct.getProduct().setProductName(nameProduct);
                    accProduct.setStatusSell(statusSell1);
                    dao.updateAccountProduct(accProduct);

                }
            } else if(action.equals("delete")){
                int idAccProduct = Integer.parseInt(id);
                dao.deleteAccountProduct(idAccProduct);
            }
        }
        request.setAttribute("list", dao.getAll());
        request.setAttribute("listProduct", daoProduct.getAllProduct());
        request.getRequestDispatcher("./Admin/AccountProduct.jsp").forward(request, response);
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
