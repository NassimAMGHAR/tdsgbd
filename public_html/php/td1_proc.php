
<html>
<head>
	<title> Ajout </title>
</head>
<body>

<?php
	echo "<h1> fonction procedure stocke </h1>";
	if ($conn = ocilogon("namghar_a", "r4g1h3po", "dbinfo")){
		echo "Connection OK </br>";
	}
	$stmt = ociparse($conn, "begin :res := f(:x) ; end;");
	$x = 3;
	ocibindbyname($stmt, ':res', $res);
	ocibindbyname($stmt, ':x', $x);

	ociexecute($stmt);
	echo "f($x) = $res </br>";
	
	$stmt = ociparse($conn, "begin p(:x,:res) ; end;");
	$x = 7;

	ocibindbyname($stmt, ':res', $res);
	ocibindbyname($stmt, ':x', $x);

	ociexecute($stmt);
	echo "f($x, ... ) retourne $res </br>";
?>


</body>
</html>
