<?php
include("conexion.php");
$con=conectar();

$id=$_POST['id'];
$nombre=$_POST['nombre'];
$año=$_POST['año'];
$protagonista=$_POST['protagonista'];
$director=$_POST['director'];
$productor=$_POST['productor'];
$tecnologia=$_POST['tecnologia'];
$precio=$_POST['precio'];


$sql="INSERT INTO juego VALUES('$id','$nombre','$año','$protagonista','$director','$productor','$tecnologia','$precio')";
$query= mysqli_query($con,$sql);

if($query){
    Header("Location: juegos.php");
    
}else {
}
?>