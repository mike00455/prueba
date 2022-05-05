<?php include("cabecera.php");?>

<?php 
    include("conexion.php");
    $con=conectar();

    $id=$_GET['id'];

    $sql="SELECT * FROM juego WHERE id='$id'";
    $query=mysqli_query($con,$sql);

    $row=mysqli_fetch_array($query);
?>

<div class="container mt-5">
    <form action="update_juego.php" method="POST">
                    
        <input type="hidden" name="id" value="<?php echo $row['id']  ?>">
        <input type="text" class="form-control mb-3" name="nombre" placeholder="Nombre" value="<?php echo $row['nombre']  ?>">
        <input type="text" class="form-control mb-3" name="año" placeholder="año" value="<?php echo $row['año']  ?>">
        <input type="text" class="form-control mb-3" name="protagonista" placeholder="protagonista" value="<?php echo $row['protagonista']  ?>"> 
        <input type="text" class="form-control mb-3" name="director" placeholder="director" value="<?php echo $row['director']  ?>">
        <input type="text" class="form-control mb-3" name="productor" placeholder="productor" value="<?php echo $row['productor']  ?>">                   
        <input type="text" class="form-control mb-3" name="tecnologia" placeholder="tecnologia" value="<?php echo $row['tecnologia']  ?>">     
        <input type="text" class="form-control mb-3" name="precio" placeholder="precio" value="<?php echo $row['precio']  ?>">     

        <input type="submit" class="btn btn-primary btn-block" value="Actualizar">
    </form>
                    
</div>

<?php include("pie.php");?>