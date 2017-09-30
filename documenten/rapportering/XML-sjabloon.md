XML-sjabloon
------------

Voor elk van de mogelijke modules is er een XML-bestand gemaakt. Hierin
kunnen alle gegevens worden opgeslagen op een overzichtelijke en
makkelijk leesbare manier. Op deze manier verkrijgen we eveneens een
structuur waarin eenvoudie aanpassingen kunnen doorgevoerd worden.
Bovendien moet het programma niet hercompileren nadat er wijzigingen
zijn aangebracht.

In onderstaand XML-sjabloon zien we een duidelijke hiërarchie die we
nader zullen uitleggen. Alle delen tussen de symbolen &lt; en &gt; zijn
zogenaamde *tags*. Het openen van een object gebeurt aan de hand van
deze tags. In deze tag wordt ook een naam gegeven aan een object. Het
einde van elk object wordt aangegeven met &lt;/ gevolgd door de
objectnaam en &gt;. Zoals je kunt zien in het sjabloon is een module
hiërarchisch opgebouwd uit verscheidene niveaus.

Op het hoogste niveau staat een tag voor de module, dit is altijd
‘module’ genaamd. Vervolgens komen dan de aansluitingen van de
uitgangen, verzameld in een groter geheel genaamd outputs. Elke uitgang,
aangegeven met de tag output, bevat dan nog enkele kenmerken. Zo zal een
uitgang een naam krijgen, en wordt zijn positie aangegeven relatief ten
opzichte van de linkerbovenhoek. Daarna moeten op dezelfde manier alle
ingangen worden opgesomd, met de verzamelnaam inputs. De volgende 3
kenmerken van de module zijn nodig voor het aangeven van de status met
behulp van de LED’s. Opnieuw zien we het aangeven van de posities waar
de LED is geplaatst. Tevens wordt ook vermeld als de LED al dan niet
horizontaal of verticaal staat. Dit wordt bereikt door de tag vertical,
met true indien het verticaal staat en false voor een horizontaal
geplaatste LED. Hierna volgt dan nog de plaats waar de afbeeldingen zijn
opgeslagen. De tag imageIcon duidt op de afbeelding die in de lijst zal
getoond worden. Terwijl de tag image aangeeft waar de afbeelding van de
module staat die gebruikt wordt bij het tekenen van de schakeling. En
als laatste kenmerk is er de naam van de module. Indien sommige
parameters niet nodig zijn voor een module, mogen deze altijd weggelaten
worden.

Het is belangrijk een juiste naam te geven aan de in- en uitgangen. Dit
is voor de foutdetectie bij het tekenen van een schakeling goed te laten
verlopen. Een ingang moet altijd met ‘ingang’ beginnen gevolgd door een
letter toegekend aan de ingang. Deze letter is de signaalnaam en geeft
aan om welke ingang van de module het gaat. Indien er meerdere
connecties per ingang mogelijk zijn, moet er achter de signaalnaam een
cijfer gezet worden. Dit om onderscheid te kunnen maken tussen
connecties met dezelfde signaalnaam. De naam van de uitgang is analoog
aan deze van de ingang. In tegenstelling tot de ingang moet de naam nu
natuurlijk met ‘uitgang’ beginnen gevolgd door de signaalnaam. Ook hier
moeten connecties met dezelfde signaalnaam gevolgd worden door een
nummer. Figuur 1 verduidelijkt dit voor een EN-poort.

![](Pictures/10000000000000AF000000B25FF6D96484F80BFE.jpg){width="4.438cm"
height="4.501cm"}

Figuur 1: benaming connecties

  ----------------------------------------------------------------
  &lt;module&gt;
  
   &lt;outputs&gt;
  
   &lt;output&gt;
  
   &lt;name&gt;uitgangC1&lt;/name&gt;
  
   &lt;posX&gt;26.5&lt;/posX&gt;
  
   &lt;posY&gt;39.5&lt;/posY&gt;
  
   &lt;/output&gt;
  
   &lt;output&gt;
  
   &lt;name&gt;uitgangC2&lt;/name&gt;
  
   &lt;posX&gt;26.5&lt;/posX&gt;
  
   &lt;posY&gt;59.5&lt;/posY&gt;
  
   &lt;/output&gt;
  
   &lt;/outputs&gt;
  
   &lt;inputs&gt;
  
   &lt;input&gt;
  
   &lt;name&gt;ingangA1&lt;/name&gt;
  
   &lt;posX&gt;7.5&lt;/posX&gt;
  
   &lt;posY&gt;121.5&lt;/posY&gt;
  
   &lt;/input&gt;
  
   &lt;input&gt;
  
   &lt;name&gt;ingangA2&lt;/name&gt;
  
   &lt;posX&gt;7.5&lt;/posX&gt;
  
   &lt;posY&gt;147.0&lt;/posY&gt;
  
   &lt;/input&gt;
  
   &lt;input&gt;
  
   &lt;name&gt;ingangB1&lt;/name&gt;
  
   &lt;posX&gt;46.0&lt;/posX&gt;
  
   &lt;posY&gt;121.5&lt;/posY&gt;
  
   &lt;/input&gt;
  
   &lt;input&gt;
  
   &lt;name&gt;ingangB2&lt;/name&gt;
  
   &lt;posX&gt;46.0&lt;/posX&gt;
  
   &lt;posY&gt;147.0&lt;/posY&gt;
  
   &lt;/input&gt;
  
   &lt;/inputs&gt;
  
   &lt;ledx&gt;42&lt;/ledx&gt;
  
   &lt;ledy&gt;48&lt;/ledy&gt;
  
   &lt;vertical&gt;true&lt;/vertical&gt;
  
   &lt;imageIcon&gt;figures/lijst/EN-poort.jpg&lt;/imageIcon&gt;
  
   &lt;image&gt;figures/workspace/EN-poort.jpg&lt;/image&gt;
  
   &lt;name&gt;EN-poort&lt;/name&gt;
  
  &lt;/module&gt;
  ----------------------------------------------------------------

Figuur 2: XML-bestand van EN-poort

Bij de simulatie is het mogelijk dat de gebruiker op de module moet
klikken om een event te starten. Zo zal de gebruiker bijvoorbeeld de
schakelaar aan of uit kunnen zetten. Indien dit het geval is, zijn er
nog een aantal extra parameters nodig in het XML-bestand. Deze zijn
eventX eventY, eventHeight en eventWidth. EventX en eventY zijn de x- en
y-coördinaten van het gebied dat men kan aanklikken, terwijl eventWidth
en eventHeight de breedte en hoogte zijn van het gebied. Figuur 2 geeft
als voorbeeld een schakelaar waar tijdens de simulatie een muisklik de
schakelaar kan verzetten.

![](Pictures/1000000000000043000000ACCBE242EC0E09B1DF.jpg){width="1.769cm"
height="4.507cm"}

Figuur 3: Afbeelding van een schakelaar

Figuur 4 geeft dan volgend XML-bestand voor deze schakelaar. Hierin is
te zien dat aaanklikbare gebied gelegen is op de coördinaten (22,119)
relatief ten opzichte van de linkerbovenhoek van de module. De breedte
is 23 en de hoogte 37.

  ------------------------------------------------------------------
  &lt;schakelaar&gt;
  
   &lt;outputs&gt;
  
   &lt;output&gt;
  
   &lt;name&gt;uitgangA1&lt;/name&gt;
  
   &lt;posX&gt;27.0&lt;/posX&gt;
  
   &lt;posY&gt;33.0&lt;/posY&gt;
  
   &lt;/output&gt;
  
   &lt;output&gt;
  
   &lt;name&gt;uitgangA2&lt;/name&gt;
  
   &lt;posX&gt;27.0&lt;/posX&gt;
  
   &lt;posY&gt;68.0&lt;/posY&gt;
  
   &lt;/output&gt;
  
   &lt;/outputs&gt;
  
   &lt;inputs&gt;
  
   &lt;/inputs&gt;
  
   &lt;ledx&gt;42&lt;/ledx&gt;
  
   &lt;ledy&gt;48&lt;/ledy&gt;
  
   &lt;vertical&gt;true&lt;/vertical&gt;
  
   &lt;eventX&gt;22&lt;/eventX&gt;
  
   &lt;eventY&gt;119&lt;/eventY&gt;
  
   &lt;eventWidth&gt;23&lt;/eventWidth&gt;
  
   &lt;eventHeight&gt;37&lt;/eventHeight&gt;
  
   &lt;imageIcon&gt;figures/lijst/schakelaar.jpg&lt;/imageIcon&gt;
  
   &lt;image&gt;figures/workspace/schakelaar.jpg&lt;/image&gt;
  
   &lt;name&gt;schakelaar&lt;/name&gt;
  
  &lt;/schakelaar&gt;
  
  ------------------------------------------------------------------

Figuur 4: XML-bestand van een schakelaar
