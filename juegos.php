<?php include("cabecera.php");?>

    <?php
        include("conexion.php");
        $con=conectar();
    
        $sql="SELECT *  FROM juego";
        $query=mysqli_query($con,$sql);   
    ?>

    <div class="container mt-5">
        <div class="row"> 
                        
            <div class="col-md-3">
                <h1>Resgistra un juego</h1>
                    <form action="insertar_juego.php" method="POST">

                        <input type="text" class="form-control mb-3" name="nombre" placeholder="Nombre">
                        <input type="text" class="form-control mb-3" name="año" placeholder="Año">
                        <input type="text" class="form-control mb-3" name="protagonista" placeholder="Protagonista">
                        <input type="text" class="form-control mb-3" name="director" placeholder="Director">
                        <input type="text" class="form-control mb-3" name="productor" placeholder="Productor">
                        <input type="text" class="form-control mb-3" name="tecnologia" placeholder="Tecnologia">
                        <input type="text" class="form-control mb-3" name="precio" placeholder="Precio">

                        <input type="submit" class="btn btn-primary" value="Guardar">
                    </form>
            </div>

            <div class="col-md-8">
                <table class="table" >
                    <thead class="table-success table-striped" >
                        <tr>
                            <th>ID</th>
                            <th>Nombre</th>
                            <th>Año</th>
                            <th>Protagonista</th>
                            <th>Director</th>
                            <th>Productor</th>
                            <th>Tecnologia</th>
                            <th>Precio</th>
                        </tr>
                    </thead>

                    <tbody>
                        <?php
                            while($row=mysqli_fetch_array($query)){
                                ?>
                                <tr>
                                    <th><?php  echo $row['id']?></th>
                                    <th><?php  echo $row['nombre']?></th>
                                    <th><?php  echo $row['año']?></th>
                                    <th><?php  echo $row['protagonista']?></th>
                                    <th><?php  echo $row['director']?></th>  
                                    <th><?php  echo $row['productor']?></th>   
                                    <th><?php  echo $row['tecnologia']?></th> 
                                    <th><?php  echo $row['precio']?></th> 
                                    <th><a href="actualizar_juego.php?id=<?php echo $row['id'] ?>" class="btn btn-success">Editar</a></th>
                                                                         
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