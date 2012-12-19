<html>
<head>
Consultation de sejour - fichier consultation.php
</head>
<body bgcolor = gray >

<h1> Consultation de sejour </h3>

<?php
	$connection = ocilogon("namghar_a", "r4g1h3po", "dbinfo");
	$querry = " select * from sejour where idc  = ".$_REQUEST['x'];
	echo "(affichage pour v&eacute;rifier : ".$querry.")</br>";

	$cursor = ociparse ($connection, $querry);
	ociexecute($cursor);
	while (ocifetchinto($cursor, $ligne))
	{
		echo " IDS : ".$ligne[0];
		echo " IDC : ".$ligne[1];
		echo " IDV : ".$ligne[2];
		echo " Jour : ".$ligne[3]."</br>";
	}
	ocilogoff($connection);
	echo " Fin de table se jour ";
?>


</body>
</html>
