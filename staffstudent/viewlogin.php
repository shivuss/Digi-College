<?php

    mysql_connect("localhost","root",""); // host, username, password...
    mysql_select_db("staffstudent"); // db name...
      
    $q=mysql_query("SELECT * FROM login");
    while($row=mysql_fetch_assoc($q))
            $json_output[]=$row;
      
    print(json_encode($json_output));
      
    mysql_close();
     
?>


