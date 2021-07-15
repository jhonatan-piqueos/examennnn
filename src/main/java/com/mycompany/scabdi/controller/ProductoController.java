/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.scabdi.controller;

import com.google.gson.Gson;
import com.mycompany.scabdi.DAOImp.ProductoDAOImp;
import com.mycompany.scabdi.model.Producto;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mycompany.scabdi.DAO.ProductoDAO;

@WebServlet(name = "ProductoController", urlPatterns = {"/producto"})
public class ProductoController extends HttpServlet {

    private Gson gson = new Gson();
    private ProductoDAO productoDAO = new ProductoDAOImp();

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
        PrintWriter out = response.getWriter();
        int opcion = Integer.parseInt(request.getParameter("opc"));//opc='1'
        switch (opcion) {
            case 1://todos los roles                    
                out.println(gson.toJson(productoDAO.findproducto()));

                break;
            case 2:
                out.println(gson.toJson(productoDAO.readproducto(Integer.parseInt(request.getParameter("id_producto")))));
                break;
            case 3:

                out.println(gson.toJson(productoDAO.updateproducto(new Producto(Integer.parseInt(request.getParameter("id_producto")), request.getParameter("nombre"), Integer.parseInt(request.getParameter("precio")), Integer.parseInt(request.getParameter("stock")), Integer.parseInt(request.getParameter("id_categoria"))))));
                break;
            case 4:
                out.println(gson.toJson(productoDAO.createproducto(new Producto(0, request.getParameter("nombre"), Integer.parseInt(request.getParameter("precio")), Integer.parseInt(request.getParameter("stock")), Integer.parseInt(request.getParameter("id_categoria"))))));
                break;

            case 5:
                out.println(gson.toJson(productoDAO.deleteproducto(Integer.parseInt(request.getParameter("id_producto")))));
                break;
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
