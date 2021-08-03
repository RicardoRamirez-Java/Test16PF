<%-- 
    Document   : Dashboard_RRHH
    Created on : 22/02/2021, 10:48:54
    Author     : User
--%>
<%
    String usuario = (String)session.getAttribute("usuario");    
    if (usuario!=null)
   {  
%> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">      
        <!--Bootsrap 4 CDN-->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous" >
        <!--Fontawesome CDN-->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous" >
        <!--Custom styles-->
        <link rel="stylesheet"type="text/css" href="estilosCss/estiloDashboard.css">          
        <title>Recursos Humanos</title>
    </head>
    <body>
        <style>
            .card-header h3 {
                color: tomato;
            }
            .card-text{
                color: white;
            }
        </style>
        <img class="rounded " src="Imagenes/logo2-removebg-preview.png"  alt="LogoCogescorp">   
        <div class="container h-75"> 
            <div class="d-flex justify-content-center h-75">
                <div class="row">
                    <div class="col-sm-6">
                        <div class="card">
                            <div class="card-header">
                                <h3>Registrar Usuarios</h3>         
                            </div>
                            <div class="card-body">
                                <p class="card-text">Registra los usuarios que van a realizar el Test de personalidad 16PF.</p>
                                <a href="RegistroUsuarios.jsp" class="btn login_btn">Registrar</a>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-6">
                        <div class="card">
                            <div class="card-header">
                                <h3>Reporte Test</h3>         
                            </div>
                            <div class="card-body">
                                <p class="card-text">Listado de Usuarios que realizaron el Test de personalidad 16PF</p>
                                <a href="ReporteEncuestaRealizada_Servlet" class="btn login_btn">Ver Reporte</a>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-6">
                        <div class="card">
                            <div class="card-header">
                                <h3>Reporte Usuarios</h3>         
                            </div>
                            <div class="card-body">
                                <p class="card-text">Listado de usuarios registrados.</p>
                                <a href="ReporteReUsuario_servlet" class="btn login_btn">Ver Reporte</a>
                            </div>
                        </div>
                    </div>
                      <div class="col-sm-6">
                        <div class="card">
                            <div class="card-header">
                                <h3>Salir del Sistema</h3>         
                            </div>
                            <div class="card-body">
                                <p class="card-text">Regresa a la página de Login.</p>
                                <a href="Login.jsp" class="btn login_btn">Salir</a>
                            </div>
                        </div>
                    </div>
                </div>               
            </div>
        </div>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>       
    </body>
</html>
<%
  } else {
%>
   No se puede acceder a la información si no ingresa al sistema
<%
   }
%>