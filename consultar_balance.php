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
                <h1>Busca por ID</h1>
                    <form action="" method="POST">

                        <input type="text" class="form-control mb-3" name="busqueda" placeholder="ID">

                        <input type="submit" class="btn btn-primary" value="Buscar" name="enviar">
                    </form>
            </div>

            <div class="col-md-8">
                <table class="table" >
                    <thead class="table-success table-striped" >
                        <tr>
                            <th>ID cliente</th>
                            <th>ID juego</th>
                            <th>Fecha entrega</th>
                        </tr>
                    </thead>

                    <tbody>
                        <?php

                            if(isset($_POST['enviar'])){

                                $busqueda=$_POST['busqueda'];

                                $consulta = $con -> query("SELECT * FROM alquilar WHERE fk_id_cliente = '$busqueda'");

                                while($row=$consulta->fetch_array()){
                                    ?>
                                <tr>
                                    <th><?php  echo $row['fk_id_cliente']?></th>
                                    <th><?php  echo $row['fk_id_juego']?></th>
                                    <th><?php  echo $row['fecha_entrega']?></th>   
                                                                         
                                </tr>
                                <?php 
                                }
                            }
                        ?>
                    </tbody>
                </table>
            </div>
        </div>  
    </div>

<?php include("pie.php");?>