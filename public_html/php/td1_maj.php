
<html>
<head>
corrig&eacute; TD 1 mise  &agrave; jour - fichier td1_maj.php
</head>
<body bgcolor = yellow >

<h2> Entreprise Aux p'tits cours</h2>

<p>
Voici le stock :
<?php
echo $_REQUEST['x'];
?>

<?php
$connection = ocilogon("namghar_a", "r4g1h3po", "dbinfo");
$querry = " insert into produit values ('grimpe',80, ".$_REQUEST['x'].")";
echo "(affichage pour v&eacute;rifier : ".$querry.")</br>";
$cursor = ociparse ($connection, $querry);
ociexecute($cursor);
ocilogoff($connection);
?>


</body>
</html>
