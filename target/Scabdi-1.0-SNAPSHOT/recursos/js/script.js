var nom = document.getElementById("nombre");
var ape = document.getElementById("apellido");
var cic = document.getElementById("ciclo");
var escu = document.getElementById("escuela");
var telef = document.getElementById("telefono");
var email = document.getElementById("correo");
var i = 0;
var filita = "";
var estado = 0;
function registrar(){  
   
    if(estado==0){
        alert("save");
    var table = document.getElementById("table");
    var tbody = document.getElementById("tbd");
    var fila = document.createElement("tr");
    //celda del id
    var celda_id = document.createElement("td");
    celda_id.innerHTML=i+1;
    //celda del nombre
    var celda_nombre = document.createElement("td");
    celda_nombre.innerHTML=nom.value;
     //celda del apellido
     var celda_apellido = document.createElement("td");
     celda_apellido.innerHTML=ape.value;
     //celda del ciclo
     var celda_ciclo = document.createElement("td");
     celda_ciclo.innerHTML=cic.value;
     //celda del escuela
     var celda_escuela = document.createElement("td");
     celda_escuela.innerHTML=escu.value;
    //celda del telefono
    var celda_telefono = document.createElement("td");
    celda_telefono.innerHTML=telef.value;
    //celda del correo
    var celda_correo = document.createElement("td");
    celda_correo.innerHTML=email.value;
    //celda accion
    var celda_accion = document.createElement("td");
    celda_accion.classList.add("accion");
    celda_accion.innerHTML=
    "<a href='#' class='icono2' onclick='editar(this)'><i class='fa fa-pencil-square-o' aria-hidden='true'></i></a>"
    +"<a href='#' class='icono1' onclick='eliminar(this)'><i class='fa fa-trash' aria-hidden='true'></i></a>";

    fila.appendChild(celda_id);
    fila.appendChild(celda_nombre);
    fila.appendChild(celda_apellido);
    fila.appendChild(celda_ciclo);
    fila.appendChild(celda_escuela);
    fila.appendChild(celda_telefono);
    fila.appendChild(celda_correo);
    fila.appendChild(celda_accion);
    //Agregar fila al tbody
    tbody.appendChild(fila);
    //agregar tbody a la tabla
    table.appendChild(tbody);
    limpiar();
    i+=1;
    }else{
        alert("editar");
        filita.cells[1].innerHTML = nom.value;
        filita.cells[2].innerHTML = ape.value;
        filita.cells[3].innerHTML = cic.value;
        filita.cells[4].innerHTML = escu.value;
        filita.cells[5].innerHTML = telef.value;
        filita.cells[6].innerHTML = email.value;
        filita = "";
        limpiar();
        estado = 0;
    }

}
function limpiar(){
    nom.value="";
    ape.value="";
    cic.value="Ciclo";
    escu.value="Escuela";
    telef.value="";
    email.value="";
    nom.focus();
}
function editar(row){
    filita = row.parentNode.parentNode;  
    nom.value = filita.cells[1].innerHTML;
    ape.value = filita.cells[2].innerHTML;
    cic.value = filita.cells[3].innerHTML;
    escu.value = filita.cells[4].innerHTML;
    telef.value = filita.cells[5].innerHTML;
    email.value = filita.cells[6].innerHTML;
    estado = 1;
}
function eliminar(row){
    var fil = row.parentNode.parentNode;
    fil.parentNode.removeChild(fil);
}
function listar() {
    $.get("/Scabdi/producto",{"opc":1},function (data) {
        var x = JSON.parse(data);
        for (var i = 0; i < x.length; i++) {
            $("#tabla tbody tr").append();
        }
    })
}