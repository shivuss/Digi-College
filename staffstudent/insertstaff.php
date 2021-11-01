<?php


$s1=$_REQUEST["s1"];
$s2=$_REQUEST["s2"];
$s3=$_REQUEST["s3"];

$s4=$_REQUEST["s4"];
$s5=$_REQUEST["s5"];
$s6=$_REQUEST["s6"];

$s7=$_REQUEST["s7"];


$con=mysql_connect("localhost","root","");

mysql_select_db("staffstudent",$con);

$sql="insert into staff_details values('$s1','$s2','$s3','$s4','$s5','$s6','$s7')";

mysql_query($sql);

$sql1="insert into login values('$s6','$s7','staff')";

mysql_query($sql1);
echo "one rec inserted";




?>