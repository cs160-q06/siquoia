<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"> 

<head>
<title>Siquoia login mockup</title>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<link rel="stylesheet" href="style.css" type="text/css" media="handheld,all" />
</head>

<body>
<div id="wallpaper">

<div id="logo">
<span class="green glow">S</span>
<span class="blue glow">i</span>
<span class="red glow">q</span>
<span class="orange glow">u</span>
<span class="red glow">o</span>
<span class="blue glow">i</span>
<span class="green glow">a</span>
</div> <!-- END logo -->

<div id="login">

<div class="small-link">
    <a href="signup.html">Create account</a>
</div>

<form class="loginfield" action="login.php" method="post">
<p>
<label for="username">Username:</label>
<input class="text" type="text" id="username" name="user" />

<label for="password">Password:</label>
<input class="text" type="password" id="password" name="pass" />

<input id="button" type="submit" value="Sign in" name="submit" />
</p>
<div class="small-link red">
    <a href="#">Guest sign-in</a>
</div>
</form>

</div> <!-- END login -->

</div> <!-- END wallpaper -->
</body>

</html>
