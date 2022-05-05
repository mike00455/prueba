<?php

include("conexion.php");
$con=conectar();

$id=$_POST['id'];
$cedula=$_POST['cedula'];
$nombres=$_POST['nombres'];
$apellidos=$_POST['apellidos'];
$telefono=$_POST['telefono'];
$correo=$_POST['correo'];
$direccion=$_POST['direccion'];

$sql="UPDATE cliente SET  cedula='$cedula',nombres='$nombres',apellidos='$apellidos',telefono='$telefono',correo='$correo',direccion='$direccion' WHERE id='$id'";
$query=mysqli_query($con,$sql);

    if($query){
        Header("Location: clientes.php");
    }
?>