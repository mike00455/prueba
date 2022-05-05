<?php include("cabecera.php");?>

    <?php
        include("conexion.php");
        $con=conectar();
    
        $sql="SELECT *  FROM alquilar";
        $query=mysqli_query($con,$sql);   
    ?>

    <div class="container mt-5">
        <div class="row"> 
                        
            <div class="col-md-3">
                <h1>Alquilar Juego</h1>
                    <form action="insertar_alquiler.php" method="POST">

                        <input type="text" class="form-control mb-3" name="id_cliente" placeholder="ID del cliente">
                        <input type="text" class="form-control mb-3" name="id_juego" placeholder="ID juego">
                        <input type="text" class="form-control mb-3" name="fecha_alquiler" placeholder="Fecha de alquiler">
                        <input type="text" class="form-control mb-3" name="fecha_entrega" placeholder="Fecha de entrega">

                        <input type="submit" class="btn btn-primary" value="Guardar">
                    </form>
            </div>

            <div class="col-md-8">
                <table class="table" >
                    <thead class="table-success table-striped" >
                        <tr>
                            <th>N°Alquiler</th>
                            <th>ID cliente</th>
                            <th>ID juego</th>
                            <th>Fecha alquiler</th>
                            <th>Fecha entrega</th>
                        </tr>
                    </thead>

                    <tbody>
                        <?php
                            while($row=mysqli_fetch_array($query)){
                                ?>
                                <tr>
                                    <th><?php  echo $row['id']?></th>
                                    <th><?php  echo $row['fk_id_cliente']?></th>
                                    <th><?php  echo $row['fk_id_juego']?></th>
                                    <th><?php  echo $row['fecha_alquiler']?></th>
                                    <th><?php  echo $row['fecha_entrega']?></th>                                        
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