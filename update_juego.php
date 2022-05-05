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

$sql="UPDATE juego SET  nombre='$nombre',año='$año',protagonista='$protagonista',director='$director',productor='$productor',tecnologia='$tecnologia',precio='$precio' WHERE id='$id'";
$query=mysqli_query($con,$sql);

    if($query){
        Header("Location: juegos.php");
    }
?>