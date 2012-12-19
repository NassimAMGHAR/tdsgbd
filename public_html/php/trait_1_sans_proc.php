    
<html>
<head>
Traitement 1 - fichier trait_1_sans_proc.php
</head>
<body bgcolor = gray >

<h1> Traitement 1 sans procedure </h3>

<?php
	$connection = ocilogon("namghar_a", "r4g1h3po", "dbinfo");

	$querry = " select seq_cl.nextval from  dual";

	echo "(affichage pour v&eacute;rifier : ".$querry.")</br>";

	$cursor = ociparse ($connection, $querry);
	ociexecute($cursor);


	$querry = " insert into clientss(idc, nom, age) values($i,".$_REQUEST['nom'].",".$_REQUEST['age'].")";

	echo "(affichage pour v&eacute;rifier : ".$querry.")</br>";

	$cursor = ociparse ($connection, $querry);
	ociexecute($cursor);

	ocilogoff($connection);
?>


</body>
</html>
