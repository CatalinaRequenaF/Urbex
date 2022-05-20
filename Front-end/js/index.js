//Funcion para comprobar que la contraseña coincide con la contraseña del usuario
function login(){ 
    var usuario = document.getElementById("usuario").value; 
    var password = document.getElementById("contraseña").value; 
    if (usuario=="USUARIO1" && password=="CONTRASEÑA1") { 
    window.location="TU_PAGINA_WEB.HTML"; 
    } 
    if (usuario=="USUARIO2" && password=="CONTRASEÑA2") { 
    window.location="TU_PAGINA_WEB.HTML"; 
    } 
    if (usuario=="" && password=="") { 
    window.location="errorpopup.html"; 
    } 
    } 


function enviarUsuario(){
    var http;
    http = new XMLHttpRequest;

    http.onreadystatechange = function(){
        if (http.readyState==4 && http.status==200){
            getSelector();
        }
    }
    //Poner el servidor que toca
    http.open("POST","http://localhost:7070/DAWUsuaris/Usuaris", true);
    http.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    http.send("nombre="+document.getElementById("nombre").value+"&&correo="+document.getElementById("correo").value+"&&contraseña="+document.getElementById("contraseña").value);
}


//GET DESDE NUESTRA DB

function buscarUsuario(){
    var http;
    http = new XMLHttpRequest;

        //???? que ponemos e divTaula?
    http.onreadystatechange = function(){
        if (http.readyState==4 && http.status==200){
            document.getElementById("divTaula").innerHTML=http.responseText;
        }
    }

    http.open("GET","http://localhost:7070/DAWUsuaris/Usuaris?pais="+document.getElementById("selector").value, true);
    http.send();
}




// CARRUSEL LOGICA
