function actualitzar(){
    getSelector();
}

//querys y unión con metodos de buscar de .js
function getSelector(){
    var http;
    http = new XMLHttpRequest;

    http.onreadystatechange = function(){
        if (http.readyState==4 && http.status==200){
            document.getElementById("divSelector").innerHTML=http.responseText;
        }
    }

    http.open("GET","http://localhost:8080/Urbex/UsuarioServlet",true);
    http.send();
}

//Busca usuarios de la BD
function buscarUsuario(){
    var http;
    http = new XMLHttpRequest;

    http.onreadystatechange = function(){
        if (http.readyState==4 && http.status==200){
            document.getElementById("divTaula").innerHTML=http.responseText;
        }
    }

    http.open("GET","http://localhost:8080/Urbex/UsuarioServlet="+document.getElementById("selector").value, true);
    http.send();
}

//Busca publicaciones de la BD
function buscarPost(){
    var http;
    http = new XMLHttpRequest;

    http.onreadystatechange = function(){
        if (http.readyState==4 && http.status==200){
       
        }
    }

    http.open("GET","http://localhost:8080/Urbex/PostServlet="+document.getElementById("listaLugares").value, true);
    http.send();
}

//Funcion que envia el usuario a la base de datos y los guarda
function enviarUsuario(){
    var http;
    http = new XMLHttpRequest;

    http.onreadystatechange = function(){
        if (http.readyState==4 && http.status==200){
            getSelector();
            
        }

    }
    http.open("POST","http://localhost:8080/Urbex/UsuarioServlet", true);
    http.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    http.send("usuario="+document.getElementById("usuario").value+"&&email="+document.getElementById("correo").value+"&&contrasena="+document.getElementById("contraseña1").value);
}

//Comprueba usuario y conraseña para hacer el login
function comprobarUsuario(){
    var usuario = document.getElementById("usuario").value;
    var contraseña = document.getElementById("contraseña").value;
    if (usuario =="mod" && contraseña == "mod"){

        location.replace("logged/mod.html");
    }

    if (usuario =="admin" && contraseña == "admin"){
        location.replace("logged/admin.html");
    }

        //Usuario prueba
    if (usuario =="aaa" && contraseña == "bbb"){
        location.replace("logged/mapa.html");
    }

    var http;
    http = new XMLHttpRequest;

    http.onreadystatechange = function(){
        if (http.readyState==4 && http.status==200){
            getSelector();
            location.replace("/logged/mapa.html");
            iniciarSesion();
        }

    }
    http.open("POST","http://localhost:8080/Urbex/ComprobarUsuario", true);
    http.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    http.send("usuario="+document.getElementById("usuario").value+"&&contrasena="+document.getElementById("contraseña").value);
}

/*Iniciar y cerrar sesion*/
function iniciarSesion(){
    location.replace("../logged/mapa.html");

}

function cerrarSesion(){
    location.replace("../index.html");
}


/*SUBIR PUBLICACIÓN*/
function subirPost(){
    var http;
    http = new XMLHttpRequest;
    
    http.onreadystatechange = function(){
        if (http.readyState==4 && http.status==200){
            getSelector();
        }
    }
    http.open("POST","http://localhost:8080/Urbex/PostServlet", true);
    http.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    
    http.send("title="+document.getElementById("titulo").value+"&&description="+document.getElementById("descripcion").value+"&&lat="+document.getElementById("latitud").value+"&&lon="+document.getElementById("longitud").value);
    
    alert(document.getElementById("titulo").value);

}



//FUNCIONES DE REGISTRO------------------------------------------------------------------------------------------
//COMPROBAR DISPONIBILIDAD

function funcionesRegistro(){
    if (repetirContra()){
    enviarUsuario()};
    location.replace("login.html");
}

//Comparar contraseñas registro (sean iguales)

function repetirContra(obj){
    contraseña1 = document.getElementById("contraseña1").value;
    contraseña2 = document.getElementById("contraseña2").value;

    if (contraseña1==contraseña2){
        alert("Todo ha salido bien.")
        return true;
    } else {
        alert("Las contraseñas no coinciden.");
        return false;
    }
}

//PINTAR DATOS-------------------------------------------------------------------------------------------------
// Objetos "base de datos"
const baseDeDatos = [
    {
        id: 1,
        title: 'Uno',
        description: 'Asdasdasdbalblablabal',
        lat: 'localizacion',
        lon:'asfd',
        created_at:'20/20/2000'
    },
    {
        id: 2,
        title: 'Dos',
        description: 'eeeeeeeeeeeeee',
        lat: 'localizacion',
        lon:'asfd',
        created_at:'20/20/2000'
    },
    {
        id: 3,
        title: 'Tres',
        description: 'iiiiiiiiiiiiiiii',
        lat: 'localizacion',
        lon:'asfd',
        created_at:'20/20/2000'
    },
    {
        id: 4,
        title: 'Cuatro',
        description: 'descripcion',
        lat: 'localizacion',
        lon:'asfd',
        created_at:'20/20/2000'
    }

];


//PINTAR OBJETOS DE LA "BASE DE DATOS"-----------------------------------------------------------------------------
function pintarListaLugares(){
    //extraer cantidad de lugares
        console.log(Object.values(baseDeDatos))
            baseDeDatos.forEach((baseDeDatos) => {
                // CREAMOS NODO CONTENEDOR
                const nodo = document.createElement('div');

                 // NUMERO Id
                 const nodoId = document.createElement('h1');
                 nodoId.classList.add('id');
                 nodoId.textContent = baseDeDatos.id;

                // Titulo
                const nodoTitle = document.createElement('h5');
                nodoTitle.classList.add('title');
                nodoTitle.textContent = baseDeDatos.title;

                // Descripcion
                const nodoDesc = document.createElement('p');
                nodoDesc.classList.add('description');
                nodoDesc.textContent = baseDeDatos.description;

                // Lat
                const nodoLat = document.createElement('p');
                nodoLat.classList.add('lat');
                nodoLat.textContent = baseDeDatos.lat;

                 // Lon
                 const nodoLon = document.createElement('p');
                 nodoLon.classList.add('lon');
                 nodoLon.textContent = baseDeDatos.lon;

                  // Created_at
                const nodoCreated = document.createElement('p');
                nodoCreated.classList.add('created_at');
                nodoCreated.textContent = baseDeDatos.created_at;
                
                // INSERCIONES AL CONTENEDOR
                nodo.appendChild(nodoId);
                nodo.appendChild(nodoTitle);
                nodo.appendChild(nodoDesc);
                nodo.appendChild(nodoLat);
                nodo.appendChild(nodoLon);
                nodo.appendChild(nodoCreated);


                listaLugares = document.getElementById("listaLugares");
                listaLugares.appendChild(nodo);
            });
        
 
}


//Pintar report usuario

function reportes(){
    pintarUsuariosRep();
    pintarPublicacionesRep();
}

function pintarUsuariosRep(){
    //extraer cantidad de lugares
        console.log(Object.values(baseDeDatos))
            baseDeDatos.forEach((baseDeDatos) => {
                // CREAMOS NODO CONTENEDOR
                const nodo = document.createElement('div');

                 // NUMERO Id
                 const nodoUsername = document.createElement('h1');
                 nodoId.classList.add('username');
                 nodoId.textContent = baseDeDatos.username;
                
                // INSERCIONES AL CONTENEDOR
                nodo.appendChild(nodoUsername);
                nodo.appendChild(nodoCreated);


                listaLugares = document.getElementById("usuariosRep");
                listaLugares.appendChild(nodo);
            });
        
 
}



//Pintar report publicacion
function pintarPublicacionesRep(){
    //extraer cantidad de lugares
        console.log(Object.values(baseDeDatos))
            baseDeDatos.forEach((baseDeDatos) => {
                // CREAMOS NODO CONTENEDOR
                const nodo = document.createElement('div');

                 // NUMERO Id
                 const nodoUsername = document.createElement('h1');
                 nodoId.classList.add('id');
                 nodoId.textContent = baseDeDatos.username;
                
                // INSERCIONES AL CONTENEDOR
                nodo.appendChild(nodoUsername);
                nodo.appendChild(nodoCreated);


                listaLugares = document.getElementById("publicacionesRep");
                listaLugares.appendChild(nodo);
            });
        
 
}


/*ELIMINAR USUARIO*/

function eliminarUsuario(){
    var http;
    http = new XMLHttpRequest;

    http.onreadystatechange = function(){
        if (http.readyState==4 && http.status==200){
        }

    }
    http.open("POST","http://localhost:8080/Urbex/ComprobarUsuario", true);
    http.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    http.send("usuario="+document.getElementById("usuario").value);
}


/*Eliminar post */

function eliminarPost(){
    var http;
    http = new XMLHttpRequest;

    http.onreadystatechange = function(){
        if (http.readyState==4 && http.status==200){
        }

    }
    http.open("POST","http://localhost:8080/Urbex/ComprobarUsuario", true);
    http.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    http.send("id="+document.getElementById("idPost").value);
}