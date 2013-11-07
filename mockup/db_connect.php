<?php
function db_connect() {
    $server = "localhost";
    $database = "siquoia";
    $pass = "siquoia";
    $user = "siquoia";
    $db_handle = mysqli_connect($server, $user, $pass, $database);
    return $db_handle;
}
?>
