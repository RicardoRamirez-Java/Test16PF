<%-- 
    Document   : RegistroUsuarios
    Created on : 01/03/2021, 15:57:22
    Author     : User
--%>
<%@page import="Clases.BeanTipoUsuario"%>
<%@page import="ConexionesBD.RegistroUsuario_BD"%>
<%@page import="java.util.Vector"%>
<%
    String usuario = (String)session.getAttribute("usuario"); 
    String m = request.getParameter("msj");
    if (usuario!=null)
   {
    RegistroUsuario_BD obj = new RegistroUsuario_BD();
    Vector vr = obj.getTipoUsuario();//recupero ell vetor lleno con lso datos de la base de datos
%> 


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
         <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--Made with love by Mutiullah Samim -->
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <!--Bootsrap 4 CDN-->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <!--Fontawesome CDN-->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
        <!--Custom styles-->
        <link rel="stylesheet" type="text/css" href="estilosCss/registro.css">
        <title>Registro Usuarios</title>
    </head>
    <body>
        
          <!-- Modal -->
        
        <div class="modal fade" id="staticBackdrop" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="staticBackdropLabel">Mensaje..!</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <label id="mensaje"><%=m%></label>   
                    </div>
                    <div class="modal-footer">
                        <a id="enlace" href="#" type="button" class="btn btn-primary" onclick="redireccionar()">Aceptar</a>                
                    </div>
                </div>
            </div>
        </div> 
        <img class="rounded" src="Imagenes/logo2-removebg-preview.png"  alt="LogoCogescorp">
        <div class="container h-75">
            <div class="d-flex justify-content-center h-75">
                <div class="card"> 
                    <div class="card-header">
                        <h3>COGESCORP S.A</h3>          	
                    </div>
                    <div class="card-body">
                        <form action="RegistroUser_servlet">
                            <div class="input-group form-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text"><i class="fas fa-user"></i></span>
                                </div>
                                <input type="text" name="usuario" class="form-control" placeholder="usuario" required>

                            </div>
                            <div class="input-group form-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text"><i class="fas fa-user"></i></span>
                                </div>
                                <input type="text"  name="nombre" class="form-control" placeholder="Nombre" required>

                            </div>
                            <div class="input-group form-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text"><i class="fas fa-user"></i></span>
                                </div>
                                <input type="text" name="apellido" class="form-control" placeholder="Apellido" required>

                            </div>

                            <div class="input-group form-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text"><i class="fas fa-user"></i></span>
                                </div>						
                                <select name="tipoUser" class="form-control" required>                                  
                                    <option  value="">Tipo de Usuario</option>
                                    
                                     <%   for (int i = 0; i < vr.size(); i++) {
                                            BeanTipoUsuario re = (BeanTipoUsuario) vr.elementAt(i);// se recore el vector "v" y se va llenando la clase "Reporte"
                                      %> 
                                      
                                    <option value="<%=re.codigoTipo%>"><%=re.nombre%></option>
                                       <%    }%> 
                                </select>
                              
                            </div>

                            <div class="input-group form-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text"><i class="fas fa-key"></i></span>
                                </div>
                                <input type="password" name="contraseña" class="form-control" placeholder="Contraseña" required>
                            </div>	
                            <div class="input-group form-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text"><i class="fas fa-key"></i></span>
                                </div>
                                <input type="password" name="confirma" class="form-control" placeholder="Confirmar contraseña" required>
                            </div>					
                            <div class="form-group">
                                <input type="submit" value="Registrar" class="btn float-right login_btn">
                                <a href="Dashboard_RRHH.jsp"  class="btn float-left login_btn">Cancelar</a>												
                            </div>
                        </form>
                    </div>

                </div>

            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" ></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" ></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" ></script>
         <script>
            const respuestaServlet=window.location.search;//se obtiene los parametros que manda el servlet por la url 
            const urlServlet = new URLSearchParams(respuestaServlet);// creamos la instancia para poder extrear los valores del parametro enviado por el servlet 
            const capturaRespuesta =urlServlet.get('msj');//accedemos a los valores (argumentos)
            if(capturaRespuesta!==null){ // condicionamos para mostrar el modal
                $('#staticBackdrop').modal('toggle');
            }
             function redireccionar(){
                if((capturaRespuesta==="Claves no coinciden")||(capturaRespuesta==="Usuario Existe")){
                    document.getElementById("enlace").href="RegistroUsuarios.jsp";
                }else{
                    document.getElementById("enlace").href="Dashboard_RRHH.jsp";
                }
            }
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