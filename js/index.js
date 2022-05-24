//Funcion para comprobar que la contraseña coincide con la contraseña del usuario

function login(){ 
    var usuario = document.getElementById("usuario").value; 
    var password = document.getElementById("contraseña").value;
    
    //Extraer 
    //extraer contraseña de db y meterla en una 
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
    http.send("usuario="+document.getElementById("usuario").value+"&&correo="+document.getElementById("correo").value+"&&contraseña="+document.getElementById("contraseña1").value);

    alert(document.getElementById("usuario"));

}


//Comprobar que no existe ese usuario/esa contraseña
function comprobarUsuario(){
    var usuario=document.getElementById("usuario").value;
    var correo=document.getElementById("correo").value;


    //Obtener dos listas q me pinten usuarios con ese nombre 
    //y correo con ese nombre
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
//Funciones para registro

function funcionesRegistro(){
    enviarUsuario();


}


/*Buscar usuario 2
 var usuario=document.getElementById("usuario").value;
    var dni=document.getElementById("inputDni").value;
    oAjax.open('GET','php/comprobarUsuario.php?NOMBRE='+usuario+'&DNI='+dni,true);
    oAjax.send();
    oAjax.onreadystatechange=respuestaComprobarUsuario;*/


//Comparar contraseñas registro (sean iguales)

function repetirContra(obj){
    contraseña1 = document.getElementById("contraseña1");
    contraseña2 = document.getElementById("contraseña2");

    if (contraseña1 == contraseña2){
        alert("si")
        return true;
    } else {
        alert("no");
        return false;
    }
}






// Variables
const baseDeDatos = [
    {
        id: 1,
        title: 'Uno',
        description: 'Asdasdasdbalblablabal',
        localization_id: 'asdsad'
    },
    {
        id: 2,
        title: 'Dos',
        description: 'eeeeeeeeeeeeee',
        localization_id: 'asdsad'
    },
    {
        id: 3,
        title: 'Tres',
        description: 'iiiiiiiiiiiiiiii',
        localization_id: 'asdsad'
    },
    {
        id: 4,
        title: 'Cuatro',
        description: 'pppppppppppppp',
        localization_id: 'asdsad'
    }

];

//Extraer lista lugares

//RENDERIZAR INDFORMACION
function pintarListaLugares(){
    //extraer cantidad de lugares
        console.log(Object.values(baseDeDatos))
            baseDeDatos.forEach((baseDeDatos) => {
                // Estructura
                const nodo = document.createElement('div');
                nodo.innerHTML="Object.values(baseDeDatos[i])"

                // Titulo
                const nodoTitle = document.createElement('h5');
                nodoTitle.classList.add('title');
                nodoTitle.textContent = baseDeDatos.title;

                // Id
                const nodoId = document.createElement('h1');
                nodoId.classList.add('id');
                nodoId.textContent = baseDeDatos.id;

                // Descripcion
                const nodoDesc = document.createElement('h5');
                nodoDesc.classList.add('description');
                nodoDesc.textContent = baseDeDatos.description;

                // Localizacion
                const nodoLoc = document.createElement('h5');
                nodoLoc.classList.add('localization');
                nodoLoc.textContent = baseDeDatos.localization_id;
                
                // Insertamos
                nodo.appendChild(nodoTitle);
                nodo.appendChild(nodoId);
                nodo.appendChild(nodoDesc);
                nodo.appendChild(nodoLoc);

                listaLugares = document.getElementById("listaLugares");
                listaLugares.appendChild(nodo);
            });
        
 
}
