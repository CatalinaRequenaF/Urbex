//LOGIN--------------------------------------------------------------------------------------------------------------
//Funcion para comprobar que la contraseña coincide con la contraseña del usuario

function login(){ 
    var usuario = document.getElementById("usuario").value; 
    var password = document.getElementById("contraseña").value;
    var contraseñaDB = "";

    var http;
    http = new XMLHttpRequest;

    http.onreadystatechange = function(){
        if (http.readyState==4 && http.status==200){
            getSelector();
        }
    }
    //ENVIO USUARIO Y GUARDO SU CONTRASEÑA COMO RESULTADO (guardo en variable el resultado de la función).
    //-Si no existe, devuelve -1
    contraseñaDB= buscarUsuario(usuario);

    if (password==contraseñaDB) { 
    location.replace("perfil.html");
    }  

    if (password==-1) { 
        alert("El usuario no existe.")
    }

    if (usuario=="" && password=="") { 
    alert("Por favor, introduce usuario y contraseña.")
    } 
} 


//BUSCAR USUARIO----------------------------------------------------------------------------------------------------

function buscarUsuario(usuario){
    var http;
    http = new XMLHttpRequest;

    http.onreadystatechange = function(){
        if (http.readyState==4 && http.status==200){
            alert(http.responseText);
            return http.responseText;
        }
    }
    
    //ENVIO USUARIO 
        http.open("POST","jdbc:mysql://192.168.56.50/urbex", true);
        http.setRequestHeader("Content-type","application/x-www-form-urlencoded");
        http.send("usuario="+document.getElementById("usuario").value);
}



//ENVIAR USUARIO REGISTRADO A LA BASE DE DATOS-------------------------------------------------------------------------
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

}


//FUNCIONES DE REGISTRO------------------------------------------------------------------------------------------
//COMPROBAR DISPONIBILIDAD

function funcionesRegistro(){
    if (repetirContra()){
    enviarUsuario()};
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



/*SUBIR PUBLICACIÓN*/
function subirLugar(){
    var http;
    http = new XMLHttpRequest;

    http.onreadystatechange = function(){
        if (http.readyState==4 && http.status==200){
            getSelector();
        }
    }
    http.open("POST","jdbc:mysql://192.168.56.50/urbex", true);
    http.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    http.send("title="+document.getElementById("titulo").value+"&&description="+document.getElementById("descripcion").value+"&&lat="+document.getElementById("latitud").value+"&&lon="+document.getElementById("longitud").value);

    alert(document.getElementById("titulo").value);

}
