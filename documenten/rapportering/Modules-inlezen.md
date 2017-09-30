3.2 Modules inlezen
-------------------

### ****3.2.1 Programma-architectuur****

********

Figuur 0 geeft een UML-schema over de manier waarop de
configuratiemodules worden aangemaakt. De Simulatorklasse leest de
informatie uit de XML-bestanden door gebruik te maken van de bibliotheek
Xstream. Aan de hand van de gegevens uit de XML-bestanden worden
configuratieobjecten aangemaakt. De zo verkregen objecten komen in de
Simulatorklasse terecht een een ArrayList. Vervolgens wordt in de code
van de Simulatorklasse een lijst opgesteld en getoond op het scherm,
zodat een selectie van de modules mogelijk is. Op deze manier bekomen we
een basis voor de verdere werking van het programma.

![](Pictures/10000000000001C7000000AA17198010C2A6A711.png){width="16.05cm"
height="5.997cm"}

### ****3.2.2 Modules aanmaken****

********

Bij het opstarten van de simulator dient er een controle plaats te
vinden. Hierbij zal worden gecontroleerd welke modules ter beschikking
zijn voor het maken van een schakeling. De bestaande modules worden
beschreven in een extern XML-bestand. Voor een goede werking te
verzekeren, dienen enkele eigenschappen van de modules gekend te zijn in
de programmacode. Deze nodige data is gestructureerd terug te vinden in
de XML-code van de betreffende module. Deze architectuur zorgt voor een
geheel waarin eenvoudig aanpassingen kunnen doorgevoerd worden.

Vooraleer de beschikbare modules ter beschikking zijn in de code, moeten
de gegevens uit de XML gehaald worden. Om dit te verwezenlijken maken we
gebruik van de gratis bibliotheek Xstream. Door middel van pull parsing
zal de nodige data voor elke module worden ingelezen. Voor elke module
verkrijgen we een object. Dankzij deze objecten worden alle gegevens van
de module beschikbaar in code.

De aangemaakt objecten van de modules worden getoond in een lijst op het
scherm. In de lijst is de module voorgesteld door zowel zijn naam als
een icoon weer te geven, zoals aangegeven in figuur 0. Hierdoor kan de
gebruiker een module selecteren die nodig is voor de te maken
schakeling. De enige ontbrekende modules in de lijst zijn de trein en de
module voor voeding en grond. Deze weglating wordt doorgevoerd omdat
beide modules altijd ter beschikking zijn, en slechts éénmaal kunnen
voorkomen in de schakeling.

![](Pictures/10000000000000C8000001F3EDF5AB9CB7AC8416.jpg){width="4.473cm"
height="11.107cm"}

Figuur 0: lijst van beschikbare modules

De twee eerder vernoemde programmadelen, nl. het inlezen van de XML en
het tekenen van een schakeling, moesten worden samengevoegd. Dit proces
heeft echter enkele conflicten veroorzaakt. De twee gebruikte externe
bibliotheken, Xstream en Piccolo, kunnen niet zonder problemen
gecombineerd worden. Objecten, aangemaakt vanuit XML door Xstream, zijn
niet bruikbaar bij het tekenen van een schakeling met behulp van
Piccolo. Een oplossing hiervoor is het splitsen van de objecten in twee
objecten. Eén van de objecten dient om de gegevens vanuit XML in de
programmacode te zetten via Xstream. De bekomen objecten krijgen de
benaming configuratieobjecten. Voor het tekenen verkrijgen we dan een
ander object van de module. Deze objecten kunnen echter wel de data
halen uit de eerder aangemaakte configuratieobjecten.

### ****3.2.3 Configuratiemodules****

********

Zoals eerder al vermeld, dienen de configuratiebestanden voor het
vermijden van conflicten. Bij het opstarten van het programma, wordt
voor elke beschikbare module een object gemaakt. Deze zogenaamde
configuratieobjecten dienen enkel als tussenstap tussen het inlezen van
de gegevens vanuit XML en het eigenlijke tekenen van een schakeling.
Voor elke module zal de data vanuit de XML-bestanden geplaatst worden in
deze configuratieobjecten. Op deze manier is de nodige data eenvoudig
beschikbaar in de programma code. Bovendien verkrijgen we door deze
manier van werken een hiërarchie waarbij eenvoudig de modules kunnen
worden aangepast, zonder hercompilatie van de code. De enige vereiste
ingreep is dan een herstart van het programma om de gewijzigde data in
te lezen.

De gebruikte structuur voor de configuratiemodules in het programma is
getoond in figuur 0. Elke module wordt opgevat als een
configuratiemodule. Elk object van de klasse ConfModule bevat de nodige
gegevens voor de verwerking in het programma. De objecten die zijn
aangemaakt bij het uitlezen van de XML-bestanden dienen enkel om de
gegevens beschikbaar te maken in de code. Enkel bij een selectie wordt
een eigenlijk object aangemaakt van de module.

![](Pictures/100000000000024E0000013E554DCBE80E6685A6.png){width="16.482cm"
height="8.883cm"}

### ****3.2.4 Modules****

Bij iedere selectie van een module, wordt een nieuw object aangemaakt.
Dit object zal dan de nodige informatie halen uit de reeds aangemaakte
configuratieobjecten. Zo zullen er bijvoorbeeld kopies worden aangemaakt
van de ArrayLists van alle in- en uitgangen. De gegevens van de
configuratiebestanden zullen nu verder aangevuld worden, zodat de
modules kunnen bewerkt worden. De zo ontstane objecten worden gebruikt
om zowel het tekenen als het simuleren van de schakeling te realiseren.

Voor elke beschikbare module is er een aparte klasse voorzien, zoals
getoond in figuur. Alle klassen voor de modules hebben echter een
gemeenschappelijke klasse waarvan ze overerven. Deze gemeenschappelijke
klasse is de abstracte klasse Module. Het merendeel van de attributen en
methoden zijn algemeen voor elke module en kunnen dus geplaatst worden
in de klasse Module. Module voorziet tevens een abstracte methode
process. Dit verplicht elke module klasse een eigen verwerking aan te
maken voor deze methode. In process worden de binnenkomende signalen
verwerkt en de uitgangen aangepast.

Een opvallende uitbreiding t.o.v. de configuratieobjecten, is dat de
Input en Output klassen overerven van de klasse Connection. Hierdoor kan
de code beperkter blijven, aangezien de Input en Output klassen hier
aanvullende functies bezit die gedeeltelijk identiek zijn. Een verdere
toevoeging zijn de klassen Link en Linkset. Deze zorgen voor een goede
verwerking tijdens de simulatie. Bovendien wordt het tekenen van een
schakeling en de controle op mogelijke fouten in de schakeling
eenvoudiger.

![](Pictures/10000000000003400000024310A8620A9383D3B1.png){width="16.492cm"
height="11.478cm"}


