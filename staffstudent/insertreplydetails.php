<?php


$s1=$_REQUEST["s1"];
$s2=$_REQUEST["s2"];
$s3=$_REQUEST["s3"];
$s4=$_REQUEST["s4"];




$con=mysql_connect("localhost","root","");

mysql_select_db("staffstudent",$con);

$sql="insert into reply_details values('$s1','$s2','$s3','$s4',curdate(),curtime())";

mysql_query($sql);
echo "one rec inserted";




?>