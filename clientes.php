<?php include("cabecera.php");?>

    <?php
        include("conexion.php");
        $con=conectar();
    
        $sql="SELECT *  FROM cliente";
        $query=mysqli_query($con,$sql);   
    ?>

    <div class="container mt-5">
        <div class="row"> 
                        
            <div class="col-md-3">
                <h1>Registra un cliente</h1>
                    <form action="insertar_cliente.php" method="POST">

                        <input type="text" class="form-control mb-3" name="cedula" placeholder="Cedula">
                        <input type="text" class="form-control mb-3" name="nombres" placeholder="Nombres">
                        <input type="text" class="form-control mb-3" name="apellidos" placeholder="Apellidos">
                        <input type="text" class="form-control mb-3" name="telefono" placeholder="Telefono">
                        <input type="text" class="form-control mb-3" name="direccion" placeholder="Direccion">
                        <input type="text" class="form-control mb-3" name="correo" placeholder="Correo">

                        <input type="submit" class="btn btn-primary" value="Guardar">
                    </form>
            </div>

            <div class="col-md-8">
                <table class="table" >
                    <thead class="table-success table-striped" >
                        <tr>
                            <th>ID</th>
                            <th>Cedula</th>
                            <th>Nombres</th>
                            <th>Apellidos</th>
                            <th>Telefono</th>
                            <th>Correo</th>
                            <th>Direccion</th>
                        </tr>
                    </thead>

                    <tbody>
                        <?php
                            while($row=mysqli_fetch_array($query)){
                                ?>
                                <tr>
                                    <th><?php  echo $row['id']?></th>
                                    <th><?php  echo $row['cedula']?></th>
                                    <th><?php  echo $row['nombres']?></th>
                                    <th><?php  echo $row['apellidos']?></th>
                                    <th><?php  echo $row['telefono']?></th>  
                                    <th><?php  echo $row['correo']?></th>   
                                    <th><?php  echo $row['direccion']?></th> 
                                    <th><a href="actualizar_cliente.php?id=<?php echo $row['id'] ?>" class="btn btn-success">Editar</a></th>
                                                                          
                                </tr>
                                <?php 
                            }
                        ?>
                    </tbody>
                </table>
            </div>
        </div>  
    </div>

    
    
    
    

<?php include("pie.php");?>