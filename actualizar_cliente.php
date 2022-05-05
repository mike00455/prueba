<?php include("cabecera.php");?>

<?php 
    include("conexion.php");
    $con=conectar();

    $id=$_GET['id'];

    $sql="SELECT * FROM cliente WHERE id='$id'";
    $query=mysqli_query($con,$sql);

    $row=mysqli_fetch_array($query);
?>

<div class="container mt-5">
    <form action="update_cliente.php" method="POST">
                    
        <input type="hidden" name="id" value="<?php echo $row['id']  ?>">
                                
        <input type="text" class="form-control mb-3" name="cedula" placeholder="Cedula" value="<?php echo $row['cedula']  ?>">
        <input type="text" class="form-control mb-3" name="nombres" placeholder="Nombres" value="<?php echo $row['nombres']  ?>">
        <input type="text" class="form-control mb-3" name="apellidos" placeholder="Apellidos" value="<?php echo $row['apellidos']  ?>">
        <input type="text" class="form-control mb-3" name="telefono" placeholder="Telefono" value="<?php echo $row['telefono']  ?>"> 
        <input type="text" class="form-control mb-3" name="correo" placeholder="Correo" value="<?php echo $row['correo']  ?>">
        <input type="text" class="form-control mb-3" name="direccion" placeholder="Direccion" value="<?php echo $row['direccion']  ?>">                   
        


        <input type="submit" class="btn btn-primary btn-block" value="Actualizar">
    </form>
                    
</div>

<?php include("pie.php");?>