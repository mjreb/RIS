//http://localhost:8080/RESTSERVER/rest/USRSesionRST/login
var host = "http://" + location.host+"/RISSERVER/";
var FSM2;

function agregarPreloader(servicio) {
    $('#loader' + servicio).show();
    $('#fade' + servicio).show();
    //document.getElementById('loader'+servicio).style.display = 'block';
    //document.getElementById('fade'+servicio).style.display = 'block';
}

function removerPreloader(servicio) {
    $('#loader' + servicio).hide();
    $('#fade' + servicio).hide();
    //document.getElementById('loader'+servicio).style.display = 'none';
    //document.getElementById('fade'+servicio).style.display = 'none';
} 
//mover a clase de vista general (paquete vista)
function nobackbutton() {
    window.location.hash = "no-back-button";
    window.location.hash = "Again-No-back-button";
    window.onhashchange = function () {
        window.location.hash = "no-back-button";
    };
}

//mover a clase de servicios ajax (paquete controlador)
function getServicio(uriServ,tipohttp) {
    return $.ajax({
        url: uriServ,
        type: tipohttp,// 'get', // Tipo de envio 
        dataType: 'json' //Tipo de Respuesta

    }).fail(function (jqXHR, textStatus, errorThrown) {
        alert("No hay datos" + errorThrown);
    }).always(function (jqXHROrData, textStatus, jqXHROrErrorThrown) {
        //console.log(jqXHROrData);
    });
}  

//vista particular
function activamodal(str, form) {
    switch (str) {
        case "Cancelar":
            document.getElementById("formulario").reset(); //limpiar forma de login
            var dialogomodal = document.querySelector(".modal"+form.id);
            dialogomodal.style.display = "none";
            $.ajax({
                url: '/RISSERVER/rest/USRSesionRST/logout',
                type: 'GET', // Tipo de envio 
                dataType: 'json', //Tipo de Respuesta
                error: function (err) {
                    window.location = host + 'login.html';
                }
            });
            break;
         case "Ingresar": 
            var rolselected=getSelectedIndex(document.getElementById("perf2"));
            //console.log(rolselected);
            if(rolselected!=="0"){
                //Ejecutar carga de FSM de acuerdo al perfil y redireccionar pagina
                var llamadaFSM=getServicio("/RISSERVER/rest/RISFSM/fsm2/"+rolselected,"GET");
                $.when(llamadaFSM.done(function (ajaxFSMResults) {                                
                    console.log(ajaxFSMResults); 
                    FSM2= new  FSM(ajaxFSMResults);//creación de objeto FSMcon el json proveniente del back end
                    //edokparticular=FSM2.getFSMStateById("INGRESAR");
                    var edokparticular=FSM2.getFSMStateById(str.toUpperCase()); //en mayusculas: "nextState": "INGRESAR"
                    //concatenar: ""perfiles/"+rolselected+"/"+edokparticular.estado[0].vista
                    window.location = host +"vistas/perfiles/"+rolselected+"/"+edokparticular.estado[0].vista; //redireccionar a pagina de perfil particular
                }));                             
                var dialogomodal = document.querySelector(".modal"+form.id);
                dialogomodal.style.display = "none";                          
            }
            break;
    }    
}

//funcion para insertar opciones de selección en un listbox
function UpdateListBox(ref,jsonarray){
    var listbox = document.getElementById(ref);
    //var listbox = document.createElement(ref);
    listbox.options.length=1; //borra contenido del listbox
    for (var i = 0; i < jsonarray.length; i++) {
          var optionelem = document.createElement('option');
          optionelem.setAttribute('value', jsonarray[i]); //Definicion de valor para tabla dinamica
          optionelem.innerHTML=jsonarray[i];
          listbox.appendChild(optionelem);
    } 
}

//funcion para obtener la opción seleccionada de un listbox
function getSelectedIndex(refselid) {
    for (var i = 0; i < refselid.options.length; i++) {
        if (refselid.options[i].selected === true) {
            return refselid.options[i].value;
        }
    }
}

//Método para controlar la opción de ingreso al sistema (boton Ingresar)
function logIn(estado,e){
    agregarPreloader("login");  // Método propio de esta clase que lanza la ruedita de espera 
    var mesnajeinicial=e.target.value;// e.target: Hace referencia al elemento HTML que originó el evento (en este caso, el valor del botón "Ingresar")
        var edok=FSM2.getFSMStateById(estado);// Lo anterior era solo el servicio, este ya es el objeto correpondiente a este estado
        //---------- No se usan para nada ---------------//
        var mensajek=FSM2.getFSMStateMessageById(edok, mesnajeinicial); // Esto no se usa para nada
        var restservice=mensajek.accion; // No se usa para nada 
        // ---------------nada---------------------------------
        // $() es un selector jQuery, .val()  // Obtiene el valor actual del elemento (lo que el usuario escribió)
        var username = $('#uname').val(); // Selecciona el elemento con id="uname" 
        var password = $('#psw').val();
        // # indica que se está seleccionando por ID
        
        /*/ Sin jQuery
        var username = document.getElementById('uname').value;
        var password = document.getElementById('psw').value;
         * 
         * @type type*
         */
        ////////Bloque para integrar la funcionalidad de JSON Web Token desde el Front - end //////////
        var rsaKeyPair = KEYUTIL.generateKeypair("RSA", 2048);// Se crean el par de llaves con KEYUTIL.generateKeypair: Función de la librería jsrsasign
        // RSA es el algoritmo de cifrado y 2048 es la longitus estandar en bits 
        // rsaKeyPair es un objeto con dos claves 
        // "PKCS8PRV": Formato específico para la clave privada
        var privateKey = KEYUTIL.getPEM(rsaKeyPair.prvKeyObj,"PKCS8PRV");// Se obtiene la llave privada
        // KEYUTIL.getPEM: Convierte las claves a formato PEM (estándar para intercambio)
        var publicKey = KEYUTIL.getPEM(rsaKeyPair.pubKeyObj);//Se obtiene la llave pública
        console.log(publicKey);
        
        // 1ra parte de JWT: contiene el algoritmo y el tipo de token.
        var header ={ alg: "RS256", typ: "JWT"};// Se declara la cabecera del JWT 
        var base64 = btoa(username + ":" + password); // Se codifica en base 64 el usuario y la contraseña
        //  btoa(): Función nativa de JavaScript para codificación Base64 
        //var payload = {"usuario":username,"contrasena":password};
            var payload = {"base64":base64}; 
            
         // Tercera parte: firma 
         // KJUR.jws.JWS.sign es una función de firma de jwt de jsrasign
        var JSONToken = KJUR.jws.JWS.sign("RS256", JSON.stringify(header), JSON.stringify(payload), privateKey);// Se crea el JWT
        console.log(JSONToken);
        // {String} KJUR.jws.JWS.sign(alg, spHead, spPayload, key, pass)
        // JSON.stringify es para pasar una cadena a formato JSON 
        var informacionJSON = {"token":JSONToken, "llavepublica":publicKey};

        //Función ajax para mandar el JWT y la llave privada al Backend
        // Para una petición asíncrona de ajax al servidor 
        // No sé para qué es esta petición si no hay servicioseguridad en el orquestador 
        $.ajax({
            url: '/RISSERVER/rest/USRSesionRST/servicioseguridad',  // URL del servicio
            type: 'POST',  // Método POST
            contentType: 'application/x-www-form-urlencoded', // Tipo de contenido que estás enviando y este es por defecto pero para json 'application/json' 
            dataType: 'text',  // Indicamos que esperamos recibir JSON. Pero aquí indica text 
            data: informacionJSON,  // Convertimos el objeto a JSON ¿POR QUÉ ESTO ES VÁLIDO?
        beforeSend: function () {
            console.log('Enviando datos...');
        },
        success: function (response) {
            console.log('Respuesta del servidor:', response);
            
            $.ajax({
            url: '/RISSERVER/rest/USRSesionRST/login',
            type: 'GET', // Tipo de servicio 
            dataType: 'json', //Tipo de datos
            beforeSend: function () {
                agregarPreloader("login"); // ACTIVAR INDICADOR DE ESPERA
            }
            }).done(function (data, textStatus, jqXHR) {
                //Si en java se cifra, es necesario descifrarlo.
                var datosjson = data; // Contiene la respuesta JSON del servidor con la llave publico y el JWT 
                var keypub = datosjson["llavepublica"];// Se obtiene la llave pública del objeto JSON
                console.log(datosjson["JWT"]);
                //console.log(datosjson["llavepublica"]);
                
                var isValid = KJUR.jws.JWS.verifyJWT(datosjson["JWT"], keypub, { alg: ['RS256'] });v//erifyJWT: Verifica que: correctamente firmado (con la clave pública)
                
                if (isValid) {
                  console.log('El token es válido.');
                  // Analizar el JWT para obtener los claims
                  var parsed = KJUR.jws.JWS.parse(datosjson["JWT"]); // parse: Decodifica el token JWT
                  var payload = parsed.payloadObj; // Se obtiene la carga útil del JWT. payloadObj: Contiene los datos del usuario (claims)
                  var subject = payload.sub; // subject (sub): Datos principales del usuario en formato JSON string
                  var access_data = JSON.parse(subject);
                  console.log(access_data);
                  var usuario=access_data.Nombre+" "+access_data.Apaterno+" "+access_data.Amaterno; //nombre del usuario
                  var arregloPeril=JSON.parse(access_data.perfil); //arreglo de perfiles
                  //console.log(arregloPeril.length);
                  //alert(arregloPeril);
                  var fsmparticular=arregloPeril[0]; //seleccioando el elemento 0 del perfil OJO hacer un dialogo para preguntar perfil de ingreso
                  console.log(fsmparticular);
                  if(arregloPeril.length>1){
                    UpdateListBox("perf2",arregloPeril);
                    var dialogoMODAL = document.querySelector(".modalUSUARIOS");
                    dialogoMODAL.style.display = "block";//activar dialogo modal   
                    document.getElementById("usuarioactivo").innerHTML = "Bienvenido: "+usuario; //NOMBRE DEL USUARIO QUE DESEA INGRESAR
                  }else{
                    var llamadaFSM=getServicio("/RISSERVER/rest/RISFSM/fsm2/"+fsmparticular,"GET");
                    $.when(llamadaFSM.done(function (ajaxFSMResults) {
                        //console.log(ajaxFSMResults); 
                        //edokparticular=FSM2.getFSMStateById("INGRESAR");
                        FSM2= new  FSM(ajaxFSMResults);//creación de objeto FSM con el json proveniente del back end
                        var edokparticular=FSM2.getFSMStateById(mesnajeinicial.toUpperCase()); //en mayusculas: "nextState": "INGRESAR"
                        //concatenar: "perfiles/"+fsmparticular+"/"+edokparticular.estado[0].vista
                        window.location = host + "vistas/perfiles/"+fsmparticular+"/"+edokparticular.estado[0].vista; //redireccionar a pagina de perfil particular
                    }));                                 
                  }
                  
                } 
                /*
                var access_data=JSON.parse(data);
                console.log(access_data);
                var usuario=access_data.Nombre+" "+access_data.Apaterno+" "+access_data.Amaterno; //nombre del usuario
                var arregloPeril=JSON.parse(access_data.perfil); //arreglo de perfiles
                //console.log(arregloPeril.length);
                //alert(arregloPeril);
                var fsmparticular=arregloPeril[0]; //seleccioando el elemento 0 del perfil OJO hacer un dialogo para preguntar perfil de ingreso
                console.log(fsmparticular);  
                if(arregloPeril.length>1){
                    UpdateListBox("perf2",arregloPeril);
                    var dialogoMODAL = document.querySelector(".modalUSUARIOS");
                    dialogoMODAL.style.display = "block";//activar dialogo modal   
                    document.getElementById("usuarioactivo").innerHTML = "Bienvenido: "+usuario; //NOMBRE DEL USUARIO QUE DESEA INGRESAR
                }else{
                    var llamadaFSM=getServicio("/RISSERVER/rest/RISFSM/fsm2/"+fsmparticular,"GET");
                    $.when(llamadaFSM.done(function (ajaxFSMResults) {
                        //console.log(ajaxFSMResults); 
                        //edokparticular=FSM2.getFSMStateById("INGRESAR");
                        FSM2= new  FSM(ajaxFSMResults);//creación de objeto FSM con el json proveniente del back end
                        var edokparticular=FSM2.getFSMStateById(mesnajeinicial.toUpperCase()); //en mayusculas: "nextState": "INGRESAR"
                        //concatenar: "perfiles/"+fsmparticular+"/"+edokparticular.estado[0].vista
                        window.location = host + "vistas/perfiles/"+fsmparticular+"/"+edokparticular.estado[0].vista; //redireccionar a pagina de perfil particular
                    }));                                 
                }
                */
            }).fail(function (jqXHR, textStatus, errorThrown) {
                alert(textStatus+': Usuario invalido ');                        
            }).always(function (jqXHROrData, textStatus, jqXHROrErrorThrown) {
                removerPreloader("login"); // REMOVER INDICADOR DE ESPERA
                document.getElementById("formulario").reset(); //limpiar campos de la forma                            
            });
            
        },
        error: function (xhr, textStatus, errorThrown) {
            console.log('AYUDAAAAAAAAAAAA:', textStatus, errorThrown);
        }
        });
        
        
        //console.log(username);
        //console.log(password);
        
        /*
        $.ajax({
            url: '/RISSERVER/rest/USRSesionRST/login',
            type: 'GET', // Tipo de servicio 
            dataType: 'html', //Tipo de datos
            headers : {
              'Authorization': "Basic " + btoa(username + ":" + password)
              
              
            },
            beforeSend: function () {
                agregarPreloader("login"); // ACTIVAR INDICADOR DE ESPERA
            }
        }).done(function (data, textStatus, jqXHR) {
                //Si en java se cifra, es necesario descifrarlo.
                var access_data=JSON.parse(data);
                console.log(access_data);
                var usuario=access_data.Nombre+" "+access_data.Apaterno+" "+access_data.Amaterno; //nombre del usuario
                var arregloPeril=JSON.parse(access_data.perfil); //arreglo de perfiles
                //console.log(arregloPeril.length);
                //alert(arregloPeril);
                var fsmparticular=arregloPeril[0]; //seleccioando el elemento 0 del perfil OJO hacer un dialogo para preguntar perfil de ingreso
                console.log(fsmparticular);  
                if(arregloPeril.length>1){
                    UpdateListBox("perf2",arregloPeril);
                    var dialogoMODAL = document.querySelector(".modalUSUARIOS");
                    dialogoMODAL.style.display = "block";//activar dialogo modal   
                    document.getElementById("usuarioactivo").innerHTML = "Bienvenido: "+usuario; //NOMBRE DEL USUARIO QUE DESEA INGRESAR
                }else{
                    var llamadaFSM=getServicio("/RISSERVER/rest/RISFSM/fsm2/"+fsmparticular,"GET");
                    $.when(llamadaFSM.done(function (ajaxFSMResults) {
                        //console.log(ajaxFSMResults); 
                        //edokparticular=FSM2.getFSMStateById("INGRESAR");
                        FSM2= new  FSM(ajaxFSMResults);//creación de objeto FSM con el json proveniente del back end
                        var edokparticular=FSM2.getFSMStateById(mesnajeinicial.toUpperCase()); //en mayusculas: "nextState": "INGRESAR"
                        //concatenar: "perfiles/"+fsmparticular+"/"+edokparticular.estado[0].vista
                        window.location = host + "vistas/perfiles/"+fsmparticular+"/"+edokparticular.estado[0].vista; //redireccionar a pagina de perfil particular
                    }));                                 
                }
        }).fail(function (jqXHR, textStatus, errorThrown) {
                alert(textStatus+': Usuario invalido ');                        
        }).always(function (jqXHROrData, textStatus, jqXHROrErrorThrown) {
                removerPreloader("login"); // REMOVER INDICADOR DE ESPERA
                document.getElementById("formulario").reset(); //limpiar campos de la forma                            
        });  
        */
}

$(document).ready(function () {
    var llamadaFSM=getServicio("/RISSERVER/rest/RISFSM/fsm2/General","GET");// cargar FSM general..
    $.when(llamadaFSM.done(function (ajaxFSMResults) {
        FSM2= new  FSM(ajaxFSMResults);//creación de objeto FSM con el json proveniente del back-end
        //console.log(FSM2);
    })); 
});

