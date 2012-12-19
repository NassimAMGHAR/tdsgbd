<html>
<head>
corrig&eacute; TD 1 - fichier td&.php
</head>
<body bgcolor = yellow >


<p>
Voici la liste des cours de prix inf&eacute;rieur ou &eavute;gal
<?php
echo $_REQUEST['x'];
?>

<?php
$connection = ocilogon("namghar_a", "r4g1h3po", "dbinfo");
$querry = " select nom from produit where prix < ".$_REQUEST['x'];
echo "(affichage pour v&eacute;rifier : ".$querry.")</br>";
$cursor = ociparse ($connection, $querry);
ociexecute($cursor);
while (ocifetchinto($cursor, $ligne))
	echo $ligne[0]."</br>";
ocilogoff($connection);
?>


</body>
</html>
