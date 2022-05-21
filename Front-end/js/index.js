//Funcion para comprobar que la contraseña coincide con la contraseña del usuario

function login(){ 
    var usuario = document.getElementById("usuario").value; 
    var password = document.getElementById("contraseña").value; 
    if (usuario=="aaa" && password=="bbb") { 
    window.location='..\html\inicio\perfil\01.html';
    }  
    if (usuario=="" && password=="") { 
    alert("Por favor, introduce usuario y contraseña.")
    } else{
        alert("Usuario o contraseña incorrectas.")
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
    http.open("POST","jdbc:mysql://192.168.56.50/urbex", true);
    http.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    http.send("usuario="+document.getElementById("usuario").value+"&&correo="+document.getElementById("correo").value+"&&contraseña="+document.getElementById("contraseña").value);
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

    http.open("GET","jdbc:mysql://192.168.56.50/urbex"+document.getElementById("selector").value, true);
    http.send();
}




// CARRUSEL LOGICA


//Comparar contraseñas registro (sean iguales)

function compararContraseña(obj){
    contraseña1 = document.getElementById("contraseña1");
    contraseña2 = document.getElementById("contraseña2");

    if (contraseña1 === contraseña2){
        document.forms["formRegistro"].submit();
    }
}