<?php
require_once('db_connect.php');
$db_handle = db_connect();
$user = isset($_POST['user']) ? stripslashes($_POST['user']) : '';
$pass = isset($_POST['pass']) ? stripslashes($_POST['pass']) : '';

$query = "SELECT email FROM users WHERE email='$user'"
         . " AND password='$pass'";
echo "<br/>$query<br/>";
$result = $db_handle->query($query);
$num_rows = mysqli_num_rows($result);
if(mysqli_num_rows($result)){
    session_start();
    header('Location: login_success.html');
}
else header('Location: login_fail.html');
?>
