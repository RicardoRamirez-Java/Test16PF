/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import ConexionesBD.PollDeConexiones;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 *
 * @author User
 */
@WebServlet(name = "Exportar_servlet", urlPatterns = {"/Exportar_servlet"})
public class Exportar_servlet extends HttpServlet {

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
              
            /* TODO output your page here. You may use following sample code. */
             String d =request.getParameter("codigoTest");

            Integer codigo = Integer.parseInt(d);
            Connection cn = null;
            ServletContext sc;
            sc = this.getServletContext();
            try {

                File reportFile = new File(sc.getRealPath("Reportes/ReporteRespuesta.jasper"));
                response.setHeader("Content-Disposition", "attachment; filename=\"reporte.XLS\";");
                response.setHeader("Cache-Control", "no-cache");
                response.setHeader("Pragma", "no-cache");
                response.setDateHeader("Expires", 0);
                response.setContentType("application/XLS");

                JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(reportFile.getPath());
                Map parameters = new HashMap();
                //parameters.put("nombre_del_parametro_jasper", "valor que se manda");
                parameters.put("codigo_test", codigo);
                cn = PollDeConexiones.getInstance().getConnection();

                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, cn);

                JRXlsExporter jrExporter = null;
                jrExporter = new JRXlsExporter();
                jrExporter.setParameter(JRXlsExporterParameter.JASPER_PRINT, jasperPrint);
                jrExporter.setParameter(JRXlsExporterParameter.OUTPUT_STREAM, response.getOutputStream()); 
                 jrExporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET,Boolean.FALSE);
                 jrExporter.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE ,Boolean.TRUE);
                 jrExporter.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND,Boolean.FALSE);
                 jrExporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS,Boolean.TRUE);
                 jrExporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_COLUMNS,Boolean.TRUE);
                  jrExporter.setParameter(JRXlsExporterParameter.IS_COLLAPSE_ROW_SPAN,Boolean.TRUE);
                   jrExporter.setParameter(JRXlsExporterParameter.IS_FONT_SIZE_FIX_ENABLED ,Boolean.TRUE);
                   
                  
                 
                if (jrExporter != null) {
                    try {
                        jrExporter.exportReport();
                    } catch (JRException e) {
                        e.printStackTrace();
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (cn != null) {
                    try {
                        PollDeConexiones.getInstance().closeConnection(cn);
                        response.getOutputStream().flush();
                        response.getOutputStream().close();
                    } catch (Exception e) {
                        e.printStackTrace();
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
