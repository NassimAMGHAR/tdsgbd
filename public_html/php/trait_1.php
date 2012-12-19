

<html>
<head>
Traitement 1 - fichier trait_1.php
</head>
<body bgcolor = gray >

<h1> Traitement 1 </h3>

<?php
	if (!($conn = ocilogon("namghar_a", "r4g1h3po", "dbinfo"))){
		echo "Connection Echec </br>";
	}
	$stmt = ociparse($conn, "begin :res := traitement1(:n , :a) ; end;");
	
	ocibindbyname($stmt, ':res', $res ,-1,SQLT_INT);
	ocibindbyname($stmt, ':n', $_REQUEST['nom']);
	ocibindbyname($stmt, ':a', $_REQUEST['age']);

	ociexecute($stmt);
	echo "Votre ID est : ". $res." </br>";
	ocilogoff($conn);
?>


</body>
</html>
