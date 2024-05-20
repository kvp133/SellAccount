/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package admin.controller;

import dals.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import dals.ProductTypeDAO;
import entities.Product;
import entities.ProductType;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author KieuVietPhuoc
 */
@WebServlet(name = "ProductManager", urlPatterns = {"/adminproduct"})
public class ProductManager extends HttpServlet {

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
        ProductDAO daoProduct = new ProductDAO();
        ProductTypeDAO daoProductType = new ProductTypeDAO();
        Vector<Product> listProduct = daoProduct.getAllProduct();
        Vector<ProductType> listProductType = daoProductType.getAllProductType();
        if (request.getSession().getAttribute("admin") == null) {
            request.setAttribute("errorAdmin", "Không phận sự miễn vào");
            request.getRequestDispatcher("login").forward(request, response);
        } else {
            request.setAttribute("listProduct", listProduct);
            request.setAttribute("listProductType", listProductType);
        }

        ProductDAO dao = new ProductDAO();

//                    int n = dao.insertProduct(new Product(dao.getLastProductID(), nameProdct, Double.parseDouble(price), thumbnail, description,new ProductTypeDAO().getProductTypeByID(Integer.parseInt(typeProduct)), false, true));
        String action = request.getParameter("action");
        if (action != null) {
            if (action.equals("addProduct")) {
                String nameProduct = request.getParameter("txtProductName");
                String typeProduct = request.getParameter("txtType");
                String description = request.getParameter("txtDescription");
                String price = request.getParameter("txtPrice");
                String thumbnail = request.getParameter("txtThumbnail");
                if (nameProduct != null && typeProduct != null && description != null && price != null && thumbnail != null) {
                    int n = dao.insertProduct(new Product(dao.getLastProductID()+1, nameProduct, Double.parseDouble(price), thumbnail, description, new ProductTypeDAO().getProductTypeByID(Integer.parseInt(typeProduct)), false, true));
                    if (n > 0) {
                        request.setAttribute("notify", "Thêm sản phẩm thành công");
                        request.getRequestDispatcher("./Admin/ManagerProduct.jsp").forward(request, response);
                    } else {
                        request.setAttribute("notify", "Thêm sản phẩm thất bại");
                        request.getRequestDispatcher("./Admin/ManagerProduct.jsp").forward(request, response);
                    }
                } else {
                    request.setAttribute("notify", "Thêm sản phẩm thất bại");
                    request.getRequestDispatcher("./Admin/ManagerProduct.jsp").forward(request, response);
                }
            }else if (action.equals("deleteProduct")){
                String idProduct = request.getParameter("idProduct");
                if(idProduct != null){
                    int n = dao.deleteProduct(Integer.parseInt(idProduct));
                    if(n > 0){
                        request.setAttribute("notify2", "Xóa sản phẩm thành công");
                        request.getRequestDispatcher("./Admin/ManagerProduct.jsp").forward(request, response);
                    }else{
                        request.setAttribute("notify2", "Xóa sản phẩm thất bại");
                        request.getRequestDispatcher("./Admin/ManagerProduct.jsp").forward(request, response);
                    }
                }else{
                    request.setAttribute("notify2", "Xóa sản phẩm thất bại");
                    request.getRequestDispatcher("./Admin/ManagerProduct.jsp").forward(request, response);
                }
            } else if (action.equals("updateProduct")) {
                String idProduct = request.getParameter("txtIDProduct");
                String nameProduct = request.getParameter("txtProductName");
                String typeProduct = request.getParameter("txtType");
                String description = request.getParameter("txtDescription");
                String price = request.getParameter("txtPrice");
                String thumbnail = request.getParameter("txtThumbnail");
                if (idProduct != null && nameProduct != null && typeProduct != null && description != null && price != null && thumbnail != null) {
                    int n = dao.updateProduct(new Product(Integer.parseInt(idProduct), nameProduct, Double.parseDouble(price), thumbnail, description, new ProductTypeDAO().getProductTypeByName(typeProduct), false, true));
                    if (n > 0) {
                        request.setAttribute("notify", "Cập nhật sản phẩm thành công");
                        request.getRequestDispatcher("./Admin/ManagerProduct.jsp").forward(request, response);
                    } else {
                        request.setAttribute("notify", "Cập nhật sản phẩm thất bại");
                        request.getRequestDispatcher("./Admin/ManagerProduct.jsp").forward(request, response);
                    }
                } else {
                    request.setAttribute("notify", "Cập nhật sản phẩm thất bại");
                    request.getRequestDispatcher("./Admin/ManagerProduct.jsp").forward(request, response);
                }

            }
        }else {
            request.getRequestDispatcher("./Admin/ManagerProduct.jsp").forward(request, response);
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
