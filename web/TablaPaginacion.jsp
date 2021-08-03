<%-- 
    Document   : TablaPaginacion
    Created on : 01/03/2021, 9:33:56
    Author     : User
--%>
<%
    String usuario = (String)session.getAttribute("usuario");   
    if (usuario!=null)
   { 
%> 
<%@page import="Clases.BeanReporteGeneral"%>
<%@page import="java.util.Vector"%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
       <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdn.datatables.net/1.10.23/css/dataTables.bootstrap4.min.css">   
        <link rel="stylesheet" href="https://cdn.datatables.net/responsive/2.2.7/css/responsive.bootstrap4.min.css">
        <link rel="stylesheet" href="estilosCss/estiloReporteEncuestaRealizada.css">
        <title>Encuestas Realizadas</title>
    </head>
    <body>
        <header class="jumbotron">
            <div class="container-fluid">
                <div class="row">                                    
                    <img  width="350" src="Imagenes/logo2.png  " alt="" >                                                             
                </div>
                <br>

            </div>       
        </header>  
        <div class="container">
            <table  class="table table-striped table-bordered table-hover table-sm dt-responsive nowrap" style="width:100% " id="example">           
                <thead class="thead-green">
                    <tr>
                        <th>Fecha</th>
                        <th>Usuario</th>
                        <th>Nombre</th>
                        <th>Opción</th>                      
                    </tr>
                </thead>      
                <tbody>
                    <%
                        Vector vr = (Vector) session.getAttribute("vectorReporteGeneral");//recupero ell vetor lleno con lso datos de la base de datos
                        for (int i = 0; i < vr.size(); i++) {
                            BeanReporteGeneral re = (BeanReporteGeneral) vr.elementAt(i);// se recore el vector "v" y se va llenando la clase "Reporte"
                    %> 
                    <tr>
                        <td><%=re.fecha%></td>
                        <td><%=re.usuario%></td>
                        <td><%=re.nombre%></td>
                        <td><a href="Exportar_servlet?codigoTest=<%=re.codigo_test%>">Exportar</a></td>
                    </tr>
                    <%    }%>    
                </tbody>
            </table>
                 <a href="Dashboard_RRHH.jsp" class="btn btn-outline-success btn-block mt-3">Regresar a la página Principal</a>
        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
        <script src="https://cdn.datatables.net/1.10.23/js/jquery.dataTables.min.js"></script>
        <script src="https://cdn.datatables.net/1.10.23/js/dataTables.bootstrap4.min.js"></script> 
        <script src="https://cdn.datatables.net/responsive/2.2.7/js/dataTables.responsive.min.js"></script> 
        <script src="https://cdn.datatables.net/responsive/2.2.7/js/responsive.bootstrap4.min.js"></script>  
        <script>
            $(document).ready(function () {
                $('#example').DataTable();
            });
        </script>
    </body>
</html>
<%
  } else {
%>
   No se puede acceder a la información si no ingresa al sistema
<%
   }
%>