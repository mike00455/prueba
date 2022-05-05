<?php
include("conexion.php");
$con=conectar();

$id=$_POST['id'];
$id_cliente=$_POST['id_cliente'];
$id_juego=$_POST['id_juego'];
$fecha_alquiler=$_POST['fecha_alquiler'];
$fecha_entrega=$_POST['fecha_entrega'];



$sql="INSERT INTO alquilar VALUES('$id','$id_cliente','$id_juego','$fecha_alquiler','$fecha_entrega')";
$query= mysqli_query($con,$sql);

if($query){
    Header("Location: alquilar.php");
    
}else {
}
?>