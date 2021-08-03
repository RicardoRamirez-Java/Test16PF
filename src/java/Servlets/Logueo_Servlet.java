/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import ConexionesBD.Login;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ricardo Ramirez
 */
@WebServlet(name = "Logueo_Servlet", urlPatterns = {"/Logueo_Servlet"})
public class Logueo_Servlet extends HttpServlet {

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
            String u = request.getParameter("usuario"); // SE OBTIENE LOS DATOS(COMO PARAMETROS) QUE MANDA EL FORMULAROS O CUALQUIER INPUT (UN REQUEST ES UNA PETICION HTTP ES DECIR EN LA URL DE SU NAVEGADOR PONE UNA DIRECCION REALIZANDO UNA PETICION
            String c = request.getParameter("contraseña");// SE OBTIENE LOS DATOS (COMO PARAMETROS) QUE MANDA EL FORMULAROS O CUALQUIER INPUT 

            HttpSession session = request.getSession(); // SE DECLARA LA VARIABLE DE SESION ( HttpSession)PARA ESTABLECER NUEVOS ATRIBUTOS 
            session.setMaxInactiveInterval(-1);
            
            Login obj = new Login(); // INSTANCIAMOS LA CLASE LOGUEO PARA CONECTAR A LA BASE
            if (obj.existeUsuario(u)) // Se verifica si el Usuario existe
            {
                if (obj.claveCorrecta(u, c))//se llama al metodo para verificar la contraseña
                {
                    if (obj.getTipoUsuario(u) == 1) {
                        session.setAttribute("usuario", u);
                        response.sendRedirect("Dashboard_RRHH.jsp"); // se redirecciona al formulario o pagona JSP deseada    
                    } else {
                        if (obj.getEstadoEncuesta(u) == 1) {
                            String error = "Usted Ya Ha Realizado EL Test";
                            response.sendRedirect("Login.jsp?msj=" + error);
                        } else {
                            session.setAttribute("usuario", u); //se establece el atributo "usuario" con el valor "u"obtenido del formulario para hacerlo viajer a cualquer otro formulario que lo necesite 
                            Integer cod = obj.getCodigoUsuario(u); // se busca el nombre en la base por medio del usuario 
                            String co = cod.toString();  // se cambia a String el integer para pasarle por la la variable session
                            session.setAttribute("codigoU", co);//se establce el atributo "nombre" del servlet para hacerlo viajer a cualquer otro formulario que lo necesite
                            response.sendRedirect("Preguntas_servlet"); // se redirecciona al formulario o pagona JSP deseada                       
                        }
                    }
                } else {
                    String error = "Clave Incorrecta";
                    response.sendRedirect("Login.jsp?msj=" + error);

                }
            } else {
                String error = "Usuario no existe";
                response.sendRedirect("Login.jsp?msj=" + error);

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
