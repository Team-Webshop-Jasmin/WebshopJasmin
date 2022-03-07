<html><body>
<?php
$db=mysql_connect("127.0.01","root","my-secret-pw");

$sqlab="insert personen"; $sqlab.="(Vorname,Nachname,Email-Adresse,Passwort) values";
$sqlab.="('$_POST[vn]','$_POST[nn]','$_POST[ea]','$_POST[pw]')";

mysql_db_query("JasminDATABASE",$sqlab);
?>
</body></html>