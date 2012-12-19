<?xml version="1.0" encoding= "ISO-8859-1"?>
<xsl:stylesheet version="1.0" 
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html"/>
<xsl:template match="/">
	<html>
		<head>
			<link rel="stylesheet" type="text/css" href="sejour.css"/>
		</head>
		<body>
			<h1> <xsl:value-of select="//TRAVELAGENCY/NAME"/>
			</h1>
			<h2> <xsl:value-of select="//TRAVELAGENCY/MANAGER/NAME"/>
			</h2>
			<p>Voyages de Rita</p>
			<table>
			<!--Rita a fait plusieurs voyages, donc on a besoin d'un boucle pour parcourir ses voyages-->
				<xsl:for-each select ="//TRAVELAGENCY/CLIENTS/CLIENT[NAME='Rita']/TRAVEL">
				<tr>
					<td>Destination:</td>
					<td> <xsl:value-of select="DESTINATION"/></td>
				</tr>
				<tr>
					<td>Activité: </td>
					<td><span class="clignoter"> <xsl:value-of select="ACTIVITY"/> </span></td>
				</tr>
				</xsl:for-each>

			</table>
		</body>
	</html>
</xsl:template>
</xsl:stylesheet>
