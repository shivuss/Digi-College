<?php


$s1=$_REQUEST["s1"];
$s2=$_REQUEST["s2"];
$s3=$_REQUEST["s3"];

$s4=$_REQUEST["s4"];
$s5=$_REQUEST["s5"];
$s6=$_REQUEST["s6"];


$con=mysql_connect("localhost","root","");

mysql_select_db("staffstudent",$con);

$sql="insert into student_details values('$s1','$s2','$s3','$s4','$s5','$s6')";

mysql_query($sql);

$sql2="insert into login values('$s4','$s6','student')";
mysql_query($sql2);

echo "one rec inserted";




?>