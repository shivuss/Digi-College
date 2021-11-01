<?php


$s1=$_REQUEST["s1"];
$s2=$_REQUEST["s2"];



$con=mysql_connect("localhost","root","");

mysql_select_db("staffstudent",$con);

$sql="insert into department values('$s1','$s2')";

mysql_query($sql);
echo "one rec inserted";




?>