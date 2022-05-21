//Funcion para comprobar que la contraseña coincide con la contraseña del usuario

function login(){ 
    var usuario = document.getElementById("usuario").value; 
    var password = document.getElementById("contraseña").value; 
    if (usuario=="aaa" && password=="bbb") { 
    location.replace("perfil.html");
    }  

    if (usuario!="aaa" && password!="bbb") { 
        alert("Usuario o contraseña incorrectos.")
        }

    if (usuario=="" && password=="") { 
    alert("Por favor, introduce usuario y contraseña.")
    } 
} 


//Funcion que envia el usuario a la base de datos
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


//Comprobar que no existe ese usuario/esa contraseña
function comprobarUsuario(){
    var usuario=document.getElementById("usuario").value;
    var dni=document.getElementById("correo").value;

    if(XPathResult.length==0){
        enviarUsuario();
    }

    var http;
    http = new XMLHttpRequest;

        //???? que ponemos e divTaula?
    http.onreadystatechange = function(){
        if (http.readyState==4 && http.status==200){
            document.getElementById("divTaula").innerHTML=http.responseText;
        }
    }

    http.open("GET","jdbc:mysql://192.168.56.50/urbex"+document.getElementById("usuario").value, true);
    http.open("GET","jdbc:mysql://192.168.56.50/urbex"+document.getElementById("correo").value, true);
    http.send();
}

//Buscar usuario 2
 var usuario=document.getElementById("inputUser").value;
    var dni=document.getElementById("inputDni").value;
    oAjax.open('GET','php/comprobarUsuario.php?NOMBRE='+usuario+'&DNI='+dni,true);
    oAjax.send();
    oAjax.onreadystatechange=respuestaComprobarUsuario;


//Comparar contraseñas registro (sean iguales)

function compararContraseña(obj){
    contraseña1 = document.getElementById("contraseña1");
    contraseña2 = document.getElementById("contraseña2");

    if (contraseña1 === contraseña2){
        document.forms["formRegistro"].submit();
    }
}

//Extraer lista lugares

function pintarListaLugares(){

}