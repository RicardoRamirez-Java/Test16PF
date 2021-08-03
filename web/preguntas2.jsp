<%@page import="Clases.BeanPreguntas"%>
<%@page import="java.util.Vector"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String usuario = (String) session.getAttribute("usuario");
    String m = request.getParameter("msj");
    if (usuario != null) {
        Vector vp = (Vector) session.getAttribute("vectorPreguntas");//recupero ell vetor lleno con lso datos de la base de datos
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="estilosCss/estiloPreguntas.css">
        <title>Preguntas</title>
    </head>
    <body>    
        <!-- Modal -->
        <div  class="modal fade" id="staticBackdrop" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="staticBackdropLabel">Atención</h5>                       
                    </div>
                    <div class="modal-body">
                        <p>
                            Por favor lea con atención las 187 preguntas de este test y escoja una de las 3 opciones que se presentan como alternativas de respuesta.
                            Recuerde contestar TODAS las preguntas de manera SINCERA.
                        </p>
                        <p> 
                            Si esta list@ por favor presione el botón "Comenzar el Test"
                        </p>
                    </div>
                    <div class="modal-footer">
                        <a href="Login.jsp" type="button" class="btn btn-primary">Cancelar</a>
                        <button type="button" class="btn btn-primary" data-dismiss="modal" onclick="empezarTest()">Comenzar el Test</button>

                    </div>
                </div>
            </div>
        </div>
        <div  class="modal fade" id="staticBackdrop2" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="staticBackdropLabel">Atención</h5>                       
                    </div>
                    <div class="modal-body">
                        <p>
                           Encuesta enviada.!
                        </p>                      
                    </div>
                    <div class="modal-footer">
                        <a href="https://www.google.com.mx/" type="button" class="btn btn-primary">Aceptar</a>                      
                    </div>
                </div>
            </div>
        </div>

        <header class="fixed-top " style="background:#FCEBDA;"  >
            <div class="container-fluid">
                <div class="row">
                    <div class="col-12 col-sm-12 col-md-8 mb-3">
                        <!-- 
                                mx-auto
                                rounded
                        -->
                        <img class="float-left " width="350" src="Imagenes/logo2.png" alt="">
                    </div>
                    <div class="col-12 col-sm-12 col-md-4 mb-3">
                        <h5>La Encuesta termina en:</h5>
                        <p>Fecha de fin: <span id="new_date3"></span></p>
                        <div id="countdown3"></div>                 
                    </div>
                </div>   
            </div>           
        </header> 
        <div class="container" style="width:70%;">          
            <div class="row ">
                <div class="col">
                    <form name="test" action="Guarda_Servlet">

                        <%
                            
                            for (int i = 0; i < vp.size(); i++) {
                                BeanPreguntas re = (BeanPreguntas) vp.elementAt(i);// se recore el vector "v" y se va llenando la clase "Reporte"
                               
                        %> 
                        <div id="<%=re.nPregunta%>" class="row contenedor " > 
                            <div class="col-12 col-md-12 ">
                                <p class="preguntas"><%=re.nPregunta%></p><p style="font-weight:700;"><%=re.pregunta%></p>
                            </div> 

                            <div  class="col-12 col-md-12 mb-3">                                 
                                <div class="form-check" >    
                                    <label class="form-check-label">
                                        <%=re.opcion1%><input type="radio" name="<%=re.nPregunta%>" value="A"  class="form-check-input mr-2  "  onclick="siguiente('<%=re.nPregunta+1%>')" required>
                                    </label>
                                </div>
                                <div class="form-check ">
                                    <label class="form-check-label">
                                        <%=re.opcion2%><input type="radio" name="<%=re.nPregunta%>" value="B"  class="form-check-input mr-2  " onclick="siguiente('<%=re.nPregunta+1%>')" required>
                                    </label>
                                </div>
                                <div class="form-check ">
                                    <label class="form-check-label">
                                        <%=re.opcion3%><input type="radio" name="<%=re.nPregunta%>"  value="C"  class="form-check-input mr-2 " onclick="siguiente('<%=re.nPregunta+1%>')" required>
                                    </label>
                                </div>                                   
                            </div>
                        </div>
                        <%    }%>  
                        <div class=" row row-cols-3" >
                            <input type="submit" class="btn btn-success btn-lg" onclick="javascript:localStorage.removeItem('inicio');" value="Enviar"> 
                        </div>
                    </form>
                </div>
            </div>
        </div> 
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>
        <script src="countdown.js"></script>       
      
    </body>
</html>
<%
} else {
%>
No se puede acceder a la información si no ingresa al sistema
<%
    }
%>