<?php
require_once('db_connect.php');
$db_handle = db_connect();
$user = isset($_POST['user']) ? stripslashes($_POST['user']) : '';
$pass = isset($_POST['pass']) ? stripslashes($_POST['pass']) : '';

$query = "SELECT email FROM users WHERE email='$user'";
echo "<br/>$query<br/>";
$result = $db_handle->query($query);
$num_rows = mysqli_num_rows($result);
if(mysqli_num_rows($result)) {
    header('Location: login_taken.html');
}
else {
    $query = "INSERT INTO users (email, password)"
             . " VALUES ('$user', SHA1('$pass'))";
    if (mysqli_query($db_handle, $query))
        header('Location: registration_success.html');
    else
        echo "Wait a second here. Somesing is a wrong!" . mysqli_error($db_handle);
}
?>
