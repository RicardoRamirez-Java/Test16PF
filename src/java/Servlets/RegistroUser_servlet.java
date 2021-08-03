/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import ConexionesBD.RegistroUsuario_BD;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author User
 */
@WebServlet(name = "RegistroUser_servlet", urlPatterns = {"/RegistroUser_servlet"})
public class RegistroUser_servlet extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
           String user=request.getParameter("usuario");
           String nomb=request.getParameter("nombre");
           String ape=request.getParameter("apellido");
           String tipo=request.getParameter("tipoUser");          
           String clave=request.getParameter("contraseña");
           String confirm=request.getParameter("confirma");
           
             Integer tipoUser= Integer.parseInt(tipo); // cambiamos el tipo de variable para enviar a la base
             
           // Se instancia la clase para conectar a la base y hacer la consulta 
           
          RegistroUsuario_BD obj= new RegistroUsuario_BD();
        
           if(!obj.existeUsuario(user)){     // se valida si el usuario ya existe en la base         
               if(clave.equals(confirm)){   // se valida que las contraseñas sean iguales
                 obj.registrarUsuario(user, nomb, ape, tipoUser, clave,2);  // se registra en la base
                String mOk ="Usuario registrado con exito";
                response.sendRedirect("RegistroUsuarios.jsp?msj=" + mOk);// se redireccion a la pagina de informaicon
               }else{
                   String error = "Claves no coinciden";
                    response.sendRedirect("RegistroUsuarios.jsp?msj=" + error);  
               }
                                                                
           }  else{
                    String error = "Usuario Existe";
              response.sendRedirect("RegistroUsuarios.jsp?msj=" + error);
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
