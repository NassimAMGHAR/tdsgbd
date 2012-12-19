
<html>
<head>
Traitement 2 - fichier trait_2.php
</head>
<body bgcolor = gray >

<h1> Traitement 2 </h3>

<?php
	if (!($conn = ocilogon("namghar_a", "r4g1h3po", "dbinfo"))){
		echo "Connection Echec </br>";
	}
	$stmt = ociparse($conn, "begin traitement2(:idc , :ville, :jour ,:idv ,:ids , :activ ) ; end;");
	
	ocibindbyname($stmt, ':idc', $_REQUEST['idc']);
	ocibindbyname($stmt, ':ville', $_REQUEST['ville']);
	ocibindbyname($stmt, ':jour', $_REQUEST['jour']);

	ocibindbyname($stmt, ':idv', $idv ,-1,SQLT_INT);
	ocibindbyname($stmt, ':ids', $ids ,-1,SQLT_INT);
	ocibindbyname($stmt, ':activ', $activ, 100);

	ociexecute($stmt);
	echo "Retour ID village : $idv </br> ";
	echo "ID sejour : $ids </br>" ;
	echo "Activite : $activ </br>";
	ocilogoff($conn);
?>


</body>
</html>
