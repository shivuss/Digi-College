<?php


$s1=$_REQUEST["s1"];





$con=mysql_connect("localhost","root","");

mysql_select_db("staffstudent",$con);

$sql="delete from  login where username='$s1' ";

mysql_query($sql);
echo "one rec inserted";




?>