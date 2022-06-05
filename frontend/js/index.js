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
            document.getElementById("divTaula").innerHTML=http.responseText;
        }
    }

    http.open("GET","http://localhost:8080/Urbex/PostServlet="+document.getElementById("selector").value, true);
    http.send();
}

//Funcion que envia el usuario a la base de datos y los guarda
function enviarUsuario(){
    var http;
    http = new XMLHttpRequest;

    http.onreadystatechange = function(){
        if (http.readyState==4 && http.status==200){
            getSelector();
            alert(http.responseText);
        }

    }
    http.open("POST","http://localhost:8080/Urbex/UsuarioServlet", true);
    http.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    http.send("usuario="+document.getElementById("usuario").value+"&&email="+document.getElementById("email").value+"&&contrasena="+document.getElementById("contraseña1").value);

    

}
//Comprueba usuario y conraseña para hacer el login
function comprobarUsuario(){
    var http;
    http = new XMLHttpRequest;

    http.onreadystatechange = function(){
        if (http.readyState==4 && http.status==200){
            getSelector();
            alert(http.responseText);
        }

    }
    http.open("POST","http://localhost:8080/Urbex/ComprobarUsuario", true);
    http.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    http.send("usuario="+document.getElementById("usuario").value+"&&contrasena="+document.getElementById("contrasena").value);
}

function funcionesRegistro(){
    enviarUsuario();
}

/*SUBIR PUBLICACIÓN*/
function subirLugar(){
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

//A partir de aquí no he tocado nada
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


