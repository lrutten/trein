simulatie
=========

1 Programma architectuur
------------------------

Figuur verduidelijkt de gebruikte structuur bij het simuleren van een
schakeling. Gedurende de simulatie zal de volledige coördinering vanuit
de klasse Run plaatsvinden. Om een overzicht te verkrijgen van de te
simuleren schakeling, wordt de Arraylist van modules bijgehouden. De
manier waarop de modules dan met elkaar zijn verbonden is terug te
vinden via de klasse Connection. Bovendien bezit de klasse Run een
variabele om de tijd bij te houden, nl. het attribuut time.

![](Pictures/10000000000001FE000002472B4D046D74F1D399.png){width="15.686cm"
height="17.953cm"}

Aan iedere module wordt een vertraging toegewezen. Dit zorgt voor een
meer realistischere benadering van de werkelijkheid. Om dit fenomeen in
praktijk uit te voeren wordt de event met een vertraging doorgestuurd
naar de volgende module. De enige uitzonderingen op deze regel zijn de
events afkomstig van een ingang. Deze genereert een event met als
vertraging 0. In werkelijk heeft het doorgeven van een signaal via een
verbinding eveneens slechts een verwaarloosbare tijd nodig.

2 Bediening
-----------

Bij aanvang van de simulatie zullen reeds de nodige aanpassingen worden
doorgevoerd. Deze initialisatie procedure verloopt eveneens door middel
van de generatie en verwerking van events. Tijdens de simulatie is het
echter niet mogelijk om te werken met realistische sensoren. Vandaar dat
deze modules manueel kunnen aangepast worden door middel van de muis.
Ook de schakelaar en de drukknop kunnen op deze manier bediend worden.
Hierdoor blijft de bediening eenvoudig. Zo verkrijgen we een simulatie
die de realiteit nabootst, en waarbij de gebruiker de werking van de
schakeling kan beïnvloeden. Bovendien blijft de simulator
gebruiksvriendelijk, waardoor kinderen van 13 jaar geen moeite
ondervinden bij het gebruik van het programma.

3 Grafische weergave
--------------------

Dsdfdf

4 Verwerking met events
-----------------------

De procedure van het simuleren is gebaseerd op het genereren en
verwerken van events. Wanneer een wijziging optreedt bij één van de
modules, zal er een event gegenereerd worden. Door middel van dit event
weten alle modules die verbonden zijn dat er een wijziging heeft
plaatsgevonden. Deze wijziging zal dan worden verwerkt. Indien dit
opnieuw zorgt voor een wijziging van de uitgang van deze module, zal een
nieuw event gegenereerd worden. Dit proces zal zich blijven herhalen tot
alle modules, waarop de wijziging effect heeft, zijn aangepast. Enige
uitzondering op dit principe is de wachtmodule. Meer uitleg over de
werking van deze wachtmodule is terug te vinden in bijlage ZZ.

5 Logboek
---------

Om een goed zicht te krijgen op de simulatie van een schakeling is de
grafische weergave onvoldoende. Er wordt niet getoond wanneer er al of
niet events worden gegenereerd. Om toch een beeld te krijgen van de
verwerking is het mogelijk om gebruik te maken van een logbestand.
Hiermee bekomen we een overzichtelijk tekstbestand waarmee we kunnen
volgen wanneer en waar een event wordt aangemaakt. Dit principe is in
onze masterproef aangewend tijdens het debuggen van de code. Debuggen
betekent het zoeken van mogelijke fouten in de gebruikte code of
algoritmes van het programma. Op deze manier is bijvoorbeeld ontdekt dat
aanvankelijk geen event op een ingang gestuurd werd indien hij was
verbonden met een andere ingang. Na het oplossen van alle fouten worden
de methodes voor de logger er opnieuw uit verwijderd, aangezien deze
enkel nodig waren tijdens het debuggen. Zo blijft de snelheid van het
programma optimaal.
