UML
===

UML staat voor Unified Modelling Language. Het betreft een
gestandardiseerde, visuele taal voor het weergeven van objectmodellen.
Het resultaat is een grafische weergave van het systeem, of eventueel
slechts een deel ervan. Hiermee wordt het geheel voorgesteld op een
begrijpbare wijze. Op deze manier kan men zich een beeld vormen van de
interne structuur van het programma. Het voordeel is dat er geen kennis
nodig is van de interne werking van de programmacode. Zelfs mensen
zonder ervaring met de programmeertaal kunnen een duidelijk beeld
krijgen van de werking van het programma.

Figuur 0 is een eenvoudig voorbeeld hoe een programma grafisch kan
worden voorgesteld. Elke klasse wordt weergegeven door middel van een
rechthoek. Wanneer een klasse abstract is, zal de naam van de klasse
cursief geschreven zijn. Dit is het geval voor Superklasse in figuur 0.
Een abstracte klasse is een klasse waarvan men geen objecten kan
aanmaken. De overerving van een klasse wordt aangegeven door een pijl
met een driehoek als pijlpunt. In figuur 0 erft de klasse Subklasse over
van Superklasse. Bij overerving worden methodes en attributen van de
superklasse beschikbaar voor alle subklasses.

Elke klasse van het model kan voorzien worden van attributen en
methodes. Voor elk attribuut en methode staat een symbool om zijn
toegankelijkheid weer te geven. De klasse Superklasse heeft 3 attributen
en 3 methodes. Attribuut1 en methode1() zijn beide public, dit wil
zeggen toegankelijk vanuit elke plaats in de code. Attribuut2 en
methode2() daarentegen zijn private, enkel de code van deze Superklasse
kan hiervan gebruik maken. Ten slotte kunnen attributen en methodes ook
protected zijn. In dit geval is het attribuut of de methode enkel
bereikbaar voor de code van de klasse en voor elke subklasse die ervan
overerft. In de figuur is dit zo voor attribuut3 en methode3().

Om aan te geven dat een klasse gebruik maakt van een andere klasse of
package zal bij de pijl de vermelding &lt;&lt;use&gt;&gt; staan.
Anderzijds is het ook mogelijk dat een bepaalde klasse een object in
bezit heeft van een andere klasse. Dit wordt aangeduid met een pijl van
de klasse die het object bezit naar de andere klasse. In figuur 0 is de
Superklasse in bezit van een object van de ObjectKlasse met als naam
object. Wanneer aan het begin van de pijl de vermelding ArrayList staat,
wil dit zeggen dat de klasse een ArrayList van objecten bezit.

![](Pictures/10000000000002770000017EF37F874D46B9E8AF.jpg){width="16.494cm"
height="9.985cm"}


