<%-- 
    Document   : Login
    Created on : 17-feb-2021, 22:02:22
    Author     : Ricardo Ramirez
--%>
<%

    session.setAttribute("usuario", null);// se testea la variables usuario DECLARADAS ANTERIORMENTE CON LA VARIBALE DE SESION 
    session.setAttribute("codigoU", null);// se testea el nombre del usuario
    String m = request.getParameter("msj"); //OBTIENE EL VALOR msj ENVIADO COMO PARAMETRO DEL REQUEST.RESPONSE QUE ENVIO EL SERVLET Y LO GUARDA EN LA VARIABLE  m 
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!--Made with love by Mutiullah Samim -->
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">               
        <!--Bootsrap 4 CDN-->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <!--Fontawesome CDN-->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
        <!--Custom styles-->
        <link rel="stylesheet" type="text/css" href="estilosCss/estilo.css">
        <title>Login Page</title>
    </head>
    <body>   
        <!-- Modal -->
        
        <div class="modal fade" id="staticBackdrop" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="staticBackdropLabel">Error..!</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <label id="mensaje"><%=m%></label>   
                    </div>
                    <div class="modal-footer">
                        <a href="Login.jsp" type="button" class="btn btn-primary">Aceptar</a>                
                    </div>
                </div>
            </div>
        </div>       
        <img class="rounded" src="Imagenes/logo2-removebg-preview.png"  alt="LogoCogescorp">   
        <div class="container h-75 ">
            <div class="d-flex justify-content-center h-75">
                <div class="card"> 
                    <div class="card-header">
                        <h3>COGESCORP S.A</h3>
                    </div>
                    <div class="card-body">
                        <form action="Logueo_Servlet">
                            <div class="input-group form-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text"><i class="fas fa-user"></i></span>
                                </div>
                                <input type="text" class="form-control" name="usuario" placeholder="username">

                            </div>
                            <div class="input-group form-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text"><i class="fas fa-key"></i></span>
                                </div>
                                <input type="password" class="form-control" name="contraseña" placeholder="password">
                            </div>					
                            <div class="form-group">
                                <input type="submit" value="Login" class="btn float-right login_btn">
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
        </script>
    </body>
</html>
