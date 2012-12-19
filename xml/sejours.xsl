<?xml version="1.0" encoding= "ISO-8859-1"?>
<xsl:stylesheet version="1.0" 
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html"/>
<xsl:template match="/">
	<html>
		<head>			
		</head>	
			<style type="text/css">#block {
			 width = 500px;
    			 margin-left: auto;
       			 margin-right: auto;
    		         }	
			</style>
		<body bgcolor="lightgreen" >
		<div id = "block">
			<h1> <xsl:value-of select="//TRAVELAGENCY/NAME"/>
			</h1>
			<h2> <xsl:value-of select="//TRAVELAGENCY/MANAGER/NAME"/>
			</h2>
			<p>Voyages de Rita</p>
			<table border="1" width="300px" height="300px" >
			<!--Rita a fait plusieurs voyages, donc on a besoin d'un boucle pour parcourir ses voyages-->
				<tr>
					<td>Destination</td>
					<td>Activite </td>
				</tr>
				<xsl:for-each select ="//TRAVELAGENCY/CLIENTS/CLIENT[NAME='Rita']/TRAVEL">
				<tr>					
					<td> <xsl:value-of select="DESTINATION"/> </td>				
					<td><span> <blink> <xsl:value-of select="ACTIVITY"/> </blink> </span></td>
				</tr>
				</xsl:for-each>

			</table>
		</div>
		</body>
	</html>
</xsl:template>
</xsl:stylesheet>
