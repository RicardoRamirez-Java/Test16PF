const getTime = dateTo => {
    let now = new Date(),
            time = (new Date(dateTo) - now + 1000) / 1000,
            seconds = ('0' + Math.floor(time % 60)).slice(-2),
            minutes = ('0' + Math.floor(time / 60 % 60)).slice(-2),
            hours = ('0' + Math.floor(time / 3600 % 24)).slice(-2),
            days = Math.floor(time / (3600 * 24));

    return {
        seconds,
        minutes,
        hours,
        days,
        time
    };
};

const countdown = (dateTo, element) => {
    const item = document.getElementById(element);

    const timerUpdate = setInterval(() => {
        let currenTime = getTime(dateTo);
        item.innerHTML = `
            <div class="row"> 
        <div class="col-12 countdown-container number float-left">                                     
                            ${currenTime.hours} : ${currenTime.minutes} : ${currenTime.seconds}                                                             
                </div>
                            `;

        if (currenTime.time <= 1) {
            clearInterval(timerUpdate);
            localStorage.removeItem('inicio');
            alert('Fin de la encuesta ' + element);
            document.test.submit();
            // alert('Fin de la encuesta '+ element);

        }

    }, 1000);
};
//metodo para empezar el reloj digital
function empezarTest() {
    // obtenemos la fecha actual
    var date = new Date();
    var new_date3 = new Date(date);
    //new_date3.setHours(date.getHours() + 2);
    new_date3.setMinutes(date.getMinutes() + 45);
    localStorage.setItem('inicio', new_date3);
    document.getElementById('new_date3').innerHTML = new_date3;
    countdown(new_date3, 'countdown3');

}

//metodo para validar la situacion cuando se carga la pagina 
window.onload = function ()
{
    const respuestaServlet = window.location.search;//se obtiene los parametros que manda el servlet por la url 
    const urlServlet = new URLSearchParams(respuestaServlet);// creamos la instancia para poder extrear los valores del parametro enviado por el servlet 
    const capturaRespuesta = urlServlet.get('msj');//accedemos a los valores (argumentos)
    if (capturaRespuesta !== null) { // condicionamos para mostrar el modal
        $('#staticBackdrop2').modal('toggle');
      //algoritmo para que el usuario al refrescar la pagina no reinicie el reloj digital  
    } else if (localStorage.getItem("inicio") !== null)//se valida si el reloj ya inicio 
    {      //localStorage.removeItem('inicio'); 
        // Si al iniciar el navegador, la variable inicio que se guarda
        // en la base de datos del navegador tiene valor, cargamos el valor
        // e iniciamos el proceso.
        document.getElementById('new_date3').innerHTML = localStorage.getItem('inicio');//si el reloj ya inicio se cargan los valores del mismo 
        countdown(localStorage.getItem('inicio'), 'countdown3');
    } else {
        //disparamos el modal
        $('#staticBackdrop').modal('toggle');
    }  
};
//metodo para el autoscroling (recorre cada elemento despues de seleccionar una respuesta)
function siguiente(element) {
    let item = document.getElementById(element); // se ccaptura el elemento enviado como argumento desde el jsp
    let body = $('body'); // se captura el elemento bodi
    let item2 = $('header', body);// se captura el elemento header junto con el body 
    let espacio = 20;//se asigana un espacio entre los elementos 
    $('html,body,header').animate({
        scrollTop: $(item).offset().top - item2.outerHeight() - espacio // auto scroll haciendo referencia al header fijo y un espacio
    });
}


