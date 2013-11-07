<?php
require_once('db_connect.php');
$db_handle = db_connect();

$query = "SELECT * FROM questions"
         . " LEFT JOIN subsubtopics"
         . " ON subsubtopics.id=questions.subsubtopic_id"
         . " WHERE subsubtopic='free software'"
         . " ORDER BY RAND() LIMIT 0,1";

$result = mysqli_query($db_handle, $query);
$row = $result->fetch_array(MYSQLI_ASSOC);
$question = $row['question'];
$correct_answer = $row['correct_answer'];
$answer1 = $row['answer1'];
$answer2 = $row['answer2'];
$answer3 = $row['answer3'];
?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"> 

<head>
<title>Siquoia login mockup</title>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<link rel="stylesheet" href="style.css" type="text/css" media="handheld,all" />
<style>
.answer {
    text-indent:-24px;
    margin-left:24px;
}
</style>
</head>

<body>
<div id="wallpaper">

<div id="logo">
<a style="text-decoration:none;" href="./">
<span class="green glow">S</span>
<span class="blue glow">i</span>
<span class="red glow">q</span>
<span class="orange glow">u</span>
<span class="red glow">o</span>
<span class="blue glow">i</span>
<span class="green glow">a</span>
</a>
</div> <!-- END logo -->

<form action="random_quiz_question.php">
<div style="font-size:18px; text-align:left; width:512px; margin:0 auto;
            box-shadow:#000 0 0 16px inset; padding:16px;
            border-radius:8px;">
<p><?php echo $question; ?></p>
<p class="answer"><input type="radio" name="answer"/>
    <?php echo "$correct_answer"; ?></p>
<p class="answer"><input type="radio" name="answer"/>
    <?php echo $answer1; ?></p>
<p class="answer"><input type="radio" name="answer"/>
    <?php echo $answer2; ?></p>
<p class="answer"><input type="radio" name="answer"/>
    <?php echo $answer3; ?></p>
</div>
<center>
<input id="button" type="submit" value="Submit" name="submit" 
       style="width:256px; margin:16px 0;"/>
</center>
</form>


</div> <!-- END wallpaper -->
</body>

</html>

