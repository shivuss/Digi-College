<?php

    mysql_connect("localhost","root",""); // host, username, password...
    mysql_select_db("staffstudent"); // db name...


    $s1=$_REQUEST["s1"];
    $s2=$_REQUEST["s2"];

    $q="SELECT * FROM login where username='$s1' and password='$s2' ";
     $result=mysql_query($q);
    while($row=mysql_fetch_assoc($result))
     {
		$type=$row['type'];
		echo $type;

}
     
?>


