<html><body>
<?php
$db=mysql_connect("localhost","root","");

$sqlab="insert personen"; $sqlab.="(Vorname,Nachname,Email-Adresse,Passwort) values";
$sqlab.="('$_POST[vn]','$_POST[nn]','$_POST[ea]','$_POST[pw]')";

mysql_db_query("webshop-jasmin-mysql",$sqlab);
?>
</body></html>