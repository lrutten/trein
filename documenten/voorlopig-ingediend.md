  ---------------------------------------------------------------------------------------------- ------------------
  ![](Pictures/1000000000000116000000E6369AF69840DD914F.png){width="4.773cm" height="3.955cm"}   Vanhelden Mitch
                                                                                                 
                                                                                                 Rutten Wouter
                                                                                                 
                                                                                                 Master ELO – ICT
                                                                                                 
  ---------------------------------------------------------------------------------------------- ------------------

Simulator voor een legotrein, aangestuurd met een logische schakeling

**Opdrachtgever:** Prof. Dr. ir. W. Dehaene

**Promotor:** ing. L. Rutten

**Docent communicatie: **J. Lievens

Inhoudsopgave
=============

1)  Woord vooraf
2)  Inhoudsopgave
3)  Lijst van illustraties
4)  Verklarende woordenlijst
5)  Abstract
6)  inleiding

    a.  situering
    b.  probleemstelling
    c.  doelstelling
    d.  methode

7)  analyse van ontwerptechnieken

    a.  Inleiding
    b.  Programma voorstelling

        i.  API
        ii. javadoc

    c.  programmeertaal

        i.  high-level programmeertaal

            1.  visual basic .NET
            2.  C++
            3.  C\#
            4.  java
            5.  conclusie

    d.  ontwikkelomgeving
    e.  subversion
    f.  editorkits

        i.  JHotDraw
        ii. Jung
        iii. Grappa
        iv. Piccolo
        v.  Conclusie

    g.  XML

        i.  Parsers
        ii. Xstream

    h.  Logger bibliotheek

8)  Systeemontwerp

    a.  Inleiding
    b.  Inlezen van gegevens voor modules

        i.  Configuratie modules
        ii. Modules

    c.  Workspace voor het maken van een schakeling
    d.  De simulatie

        i.  Bediening
        ii. Grafische output
        iii. Verwerking via events
        iv. logboek

    e.  extra functionaliteiten

        i.  opslaan / opslaan als
        ii. laden
        iii. ….

9)  besluit
10) literatuur lijst
11) bijlagen

    a.  modules
    b.  schema van het programma
    c.  hoe een extra module toevoegen
    d.  sjabloon voor een XML bestand
    e.  screenshots
    f.  …

Verklarende woordenlijst
========================

API……………………….. Application Programming Interface

GUI………………………. Graphical user interface

XML……………………... eXtensible Markup Language

HTML……………………. HyperText Markup Language

DOM……………………... Document Object Model

SAX………………………. Simple API for XML

Abstract
--------

Het departement elektrotechniek (ESAT) van de KULeuven heeft een
project, genaamd “IR13: ingenieurs van 13 jaar”. Het doel van dit
project is om leerlingen van ongeveer 13 jaar ingenieursvaardigheden aan
te leren. Hierbij maken de leerlingen een schakeling met logische
modules, waarmee dan een legotrein wordt aangestuurd. De ontbrekende
stap in dit gebeuren, is het simuleren van de schakeling. Het doel van
deze masterproef is om een programma te ontwerpen waarin de leerlingen
de schakeling kunnen maken en simuleren.

De simulator is ontworpen in de programmeertaal Java en met behulp van
XML. Tevens maakt het programma gebruik van 2 externe bibliotheken. Een
eerste bibliotheek is Piccolo, deze zorgt voor de grafische voorstelling
van de schakelingen. Verder hebben we Xstream voor het inlezen van
gegevens uit XML-bestanden. Het systeem wordt stap voor stap opgebouwd,
waarbij alle tussenresultaten een werkend geheel vormen.

Het eindproduct is een grafische gebruikersinterface die gemakkelijk in
gebruik is. De grafische interactie bij de simulatie is zo dicht
mogelijk bij de realiteit gehouden zodat ze duidelijk is voor de
gebruiker. Bovendien worden enkele veel gemaakte fouten bij het maken
van een schakeling gedetecteerd en gesignaleerd. Hierdoor is de
simulator gebruiksvriendelijk voor leerlingen van 13 jaar. Door het
gebruik van XML kunnen eenvoudig aanpassingen worden doorgevoerd aan de
modules.

Situering

MICAS (Microelectronics and Sensors) is een afdeling van het departement
Elektrotechniek (ESAT) van de Katholieke Universiteit Leuven. De
afdeling geniet een wereldwijde internationale erkenning als
onderzoeksinstelling. MICAS houdt zich o.a. bezig met onderzoek over
geïntegreerde schakelingen en *sensor design* op het hoogst mogelijke
wetenschappelijke niveau. Tevens vervult MICAS een onderwijzende taak.

Eén van de lopende projecten is “IR 13: ingenieurs van 13 jaar”. Hierbij
wil men leerlingen van de eerste graad middelbaar onderwijs
ingenieursvaardigheden aanleren. Tijdens de lessen TO zullen de
leerlingen leren omgaan met technische problemen, aangepast aan hun
niveau en ervaring, zoals een ingenieur. Hiervoor werd lesmateriaal
ontworpen op basis van een lego trein. De trein kan dan aan de hand van
logische modules (logische poorten, flip flops, timers) en sensors
beïnvloed worden.

***Globale probleemstelling***

In de lessen technologische opvoeding van de eerste graad in het
secundair onderwijs leren de leerlingen elektronica. Dit gebeurt met
behulp van logische panelen zoals AND-, OR- en NOT-poorten. Volgens ESAT
zijn deze lessen niet voldoende om ingenieursvaardigheden aan te leren.
Daarom willen ze in samenwerking met RVO-Society, LEGO en het Actieplan
Wetenschapsinformatie en –Innovatie een nieuw lessenpakket ontwikkelen:
IR13, ingenieur vanaf 13.

Het project wil leerlingen van 13 jaar leren omgaan met technische
problemen aangepast aan hun niveau en de leerlingen warm maken voor
basiselektronica en technologie. Het pakket bestaat uit een legotrein
die kan worden aangestuurd met logische modules zoals AND en OR poorten,
flipflops, timers en sensoren. Zo kan de trein versnellen en vertragen,
stoppen bij obstakels, toeteren bij een seinhuis en de lichten aanzetten
als het donker is. Op een wagon van het treintje bevindt zich een
moederbord waarmee de leerlingen modules kunnen verbinden.

De leerlingen krijgen een cursus met verschillende opdrachten die ze
eerst op papier oplossen en daarna met het treintje kunnen uittesten. Zo
leren de kinderen als ingenieurs ontwerpen, modelleren, testen en
methodisch denken. De stap die ontbreekt om de ontwerpmethode zo
realistisch mogelijk te maken, is een simulator waar de modules
ingebracht kunnen worden. De leerlingen kunnen dan met behulp van een
grafische gebruikersinterface de modules oproepen en verbinden. Hierdoor
kunnen ze hun ontwerp simuleren en de fouten eruit halen alvorens het te
testen met het treintje. Op deze manier doorlopen de leerlingen alle
fases van een ontwerpproces en leren ze denken als ingenieurs.

***Doelstellingen***

Na afloop wil de opdrachtgever beschikken over een gebruiksvriendelijk
eindpakket voor het simuleren van de logische trein. Aangezien we werken
met een eigen ontwikkeling, kan deze volledig aangepast worden aan de
wensen en eisen van de opdrachtgever.

Een eerste parameter waarmee we rekening moeten houden, is dat de
eindgebruikers kinderen zijn van ongeveer dertien jaar. Dit betekent dat
de bediening van het programma zeer eenvoudig moet zijn. Concreet houdt
dit in dat alles zeer duidelijk en makkelijk herkenbaar weergegeven moet
worden. Zo zullen we bijvoorbeeld dezelfde afbeeldingen en namen voor de
modules gebruiken als deze in de cursus. Om de bediening eenvoudig te
houden, zal alles grafisch weergegeven worden. Tevens zal de bediening
zo veel mogelijk met de muis mogelijk zijn.

Daarnaast dient het programma om enkele mogelijke fouten in het ontwerp
te ontdekken. Het is echter onmogelijk te verzekeren dat de gemaakte
schakeling volledig correct is opgebouwd. We kunnen er wel voor zorgen
dat enkele vaak gemaakte fouten gedetecteerd kunnen worden. Zo mogen de
leerlingen bijvoorbeeld nooit twee uitgangen met elkaar verbinden. Door
het detecteren en het signaleren van deze fouten, maken we het programma
in zekere mate ‘foolproof’.

Anderzijds zullen we er voor moeten zorgen dat er achteraf eenvoudig
aanpassingen kunnen doorgevoerd worden. De opdrachtgever wil in het
bijzonder snel en eenvoudig nieuwe modules kunnen toevoegen. Bovendien
zal de verwerking van een ingang voor iedere module beschreven moeten
zijn met simpele instructies.

Om tot een goed eindresultaat te komen, zullen we dus rekening moeten
houden met zowel de eindgebruiker als de opdrachtgever. Aangezien de
eindgebruikers kinderen zijn, wordt het programma voorzien van een
duidelijke, grafische structuur en een eenvoudige bediening. Anderzijds
zal de achterliggende logica simpel worden gehouden. Hierdoor kunnen er
snel en zonder al te veel moeite aanpassingen aangebracht worden.

***Methode***

Voor een goed ontwerp is het noodzakelijk dat de ontwikkelaar een
grondige analyse en studie doorvoert alvorens het eigenlijke
programmeren. De ontwikkeling van software-applicaties verloopt dan
meestal ook in verscheidene stappen. In een eerste fase wordt het
probleemdomein vastgesteld. Dus voor het eigenlijke programmeren, voeren
we in samenspraak met de opdrachtgever een grondige studie en analyse
door. Hieruit volgt in welke omstandigheden het programma moet
functioneren en welke mogelijkheden geïmplementeerd moeten zijn.

Na deze fase zijn er duidelijke afspraken zoals welke programmeertaal,
programma’s of bibliotheken er gebruikt zullen worden bij het
programmeren. In de verdere ontwikkeling zullen we geen conflicten meer
mogen aantreffen. Indien dit toch zo is, zal het probleemdomein voor een
deel opnieuw geanalyseerd moeten worden.

In een volgende fase wordt de totale opdracht opgesplitst in meerdere
kleinere deelproblemen.

De masterproef beschrijft elk deelprobleem en zet het dan om naar code.
Dit geeft ons de mogelijkheid om elk aan een apart deelprobleem te
werken, wat de ontwikkelsnelheid ten goede komt. Elk van deze
deelproblemen heeft een testbaar geheel als eindresultaat.

Een volgende stap bestaat dan ook uit het testen van het deelprobleem.
Voldoet het aan alle regels? Is het gemakkelijk in gebruik? Loopt het
niet vast? Indien het programma hieraan voldoet, kunnen we verder met de
ontwikkeling van andere deelproblemen. Zoniet dienen we de nodige
aanpassingen door te voeren en opnieuw de testfase te doorlopen.

Zo krijgen we een steeds groeiende applicatie die meer en meer naar het
eindresultaat evolueert. Deze methode zorgt voor een zekerheid dat alle
deelproblemen op zich werken. Uiteindelijk zal het systeem in zijn
geheel nog uitgebreid getest moeten worden met alle functionaliteiten
die gelijktijdig kunnen lopen. Op deze manier ontstaat stapsgewijs een
robuust systeem dat aan de wensen van de opdrachtgever voldoet. Eenmaal
een werkend programma is bekomen, kunnen eventueel nog handige functies
toegevoegd worden. Dit zorgt voor een betere gebruiksvriendelijkheid of
een mooiere lay-out voor het programma.

Bij de eigenlijke ontwikkeling van een softwarepakket van zulke aard
moeten een aantal beslissingen genomen worden wat betreft gebruikte
technieken en technologieën. We moeten deze dus nader bekijken en
afwegen tegen elkaar. Omwille van het financiële aspect kunnen we echter
alle commerciële pakketten al meteen elimineren. Onderstaande opsomming
geeft een overzicht op welke deelaspecten van het project we een
duidelijke keuze hebben gemaakt:

-   Programmeertaal (Java),
-   editor kit (Piccolo),
-   in- en uitlezen definities (Xstream),
-   logger bibliotheek (Sun).

Programmavoorstelling
---------------------

### 1 API

API is de afkorting van *Application Programming Interface*. Dit is een
verzameling definities op basis waarvan een computerprogramma kan
communiceren met een ander programma of onderdeel. Een API vormt de
scheiding tussen verschillende lagen van abstractie, zodat programma’s
op een hoog niveau van abstractie kunnen werken en het lage abstractie
niveau kan uitbesteden aan API’s. Zo kan een programma gebruik maken van
een API voor te printen zonder te moeten weten hoe het printen werkt.
Het grote voordeel van een API is dan ook dat de programmeur de details
van de API niet hoeft te kennen. Hierdoor zijn er meerdere
implementaties mogelijk zolang deze voldoen aan de API.

De meest gebruikte API in deze masterproef is de API van Java zelf. Deze
is uitgebreid gedocumenteerd en terug te vinden op de website van Sun.
Verder maken we ook gebruik van de API’s van Piccolo en Xstream.

### 2 Javadoc

Javadoc is een *document generator* van Sun Microsytems. Javadoc
genereert documentatie in HTML formaat vanuit de Java code op een
eenvoudige manier. In de Java code is het mogelijk commentaar voor een
klasse, variabele of methode te voorzien met als beginteken /\*\* en als
eindteken \*/. Javadoc neemt de tekst tussen deze tekens op als
commentaar en zet ze als uitleg bij de bijhorende klasse, variabele of
methode in de documentatie. Het is ook mogelijk parameters zoals auteur,
methodeparameter of teruggegeven waarde van een methode…, in de
commentaar mee te geven. Javadoc creëert zo een overzichtelijke
documentatie van de verschillende klassen met hun verschillende
variabelen en methodes en uitleg bij hun werking. Hierdoor is het
makkelijker het programma te begrijpen zonder te veel de code te moeten
onderzoeken.

Programmeertaal
===============

Bij het begin van onze masterproef stoten we al meteen op een eerste
probleem. Namelijk met welke programmeertaal wordt het programma
geschreven? De programmeertalen kunnen onderverdeeld worden in 3
niveaus.

Een eerste mogelijkheid bestaat erin te schrijven met een zogenaamd
low-level programmeertaal, de machinetaal. Dit is de enige taal die de
CPU begrijpt. Hierbij worden alle instructies binair geschreven. Deze
manier van werken komt al niet in aanmerking voor onze masterproef. Eén
level hoger dan de machinetaal hebben we de assembleertaal. In deze vorm
worden de machine-instructies symbolisch opgeschreven. Er is echter wel
nog een assembler nodig om de code te vertalen voor de CPU. Hoewel het
al makkelijker te schrijven is dan de machinetaal, is de assembleertaal
toch niet geschikt voor het schrijven van complexe programma’s.

Op het hoogste niveau hebben we de high-level programmeertalen. Deze
zijn het meest geschikt bij het schrijven van programma’s, en dus ook
voor onze masterproef. Voor het uitvoeren van een high-level
programmeertaal, zullen we de code opnieuw eerst moeten vertalen.
Hiervoor maken we gebruik van een compiler. In deze groep kunnen we de
talen nog verder opsplitsen als procedurele talen en objectgeoriënteerde
talen. Bij procedurele talen zullen de programma-instructies worden
uitgevoerd in de volgorde zoals ze zijn geprogrammeerd. Een meer
gebruikt concept is deze van het objectgeoriënteerd programmeren.
Hierbij wordt de software opgebouwd als een verzameling van
samenwerkende objecten. Zulk een object bestaat uit data en methodes om
deze data te veranderen. Doordat de data enkel wordt aangepast via de
methodes van een object, verkrijgen we een vorm van afscherming en
beveiliging van de data. Bovendien kan de interne werking van een object
eenvoudig worden aangepast, zonder dat de omliggende programmastructuur
dit merkt.

Voor projecten van grotere omvang, zoals deze masterproef, verkiest men
een high-level programmeertaal. Er zal om precies te zijn, een
objectgeoriënteerde taal verkozen worden bij zulke projecten.

1 High-level programmeertalen
-----------------------------

Dat we het programma zullen schrijven met een high-level programmeertaal
was al meteen duidelijk. Maar in deze groep vinden we tientallen
mogelijke talen terug. Een eerste opgave was dan ook om in al de
verschillende mogelijkheden een geschikte programmeertaal te vinden. Om
dit te verwezenlijken hebben we een tiental mogelijke programmeertalen
onderzocht. Om niet te ver af te dwalen zullen we enkel de vier grootste
kanshebbers verder in detail uitwerken. Andere talen die werden
onderzocht, maar niet verder worden uitgelegd zijn o.a. Pascal, C,
Smalltalk, Visual Basic, Ruby, enz… .

Vooraleer we verder gaan, zullen we eerst de term garbage collection
uitleggen. Deze term heeft een belangrijke rol gespeeld bij de keuze van
een programmeertaal. Objectgeoriënteerde talen maken bij het uitvoeren
van een programma gebruik van objecten. Deze objecten staan in de
geheugenruimte die voor het programma is voorzien. Wanneer de objecten
niet meer actief zijn, dus niet meer gebruikt worden, kan het hiervoor
toegekende geheugen terug vrij gegeven worden. Deze geheugenruimte is
dan weer beschikbaar voor andere objecten of toepassingen van het
programma. De garbage collector zorgt er dus voor dat onnodig toegekende
ruimte wordt vrijgegeven.

De verder uitgewerkte talen zijn allemaal objectgeoriënteerd, en
bezitten een automatische garbage collector. De enige uitzondering op
deze regel is C++. Hier moet de garbage collecting manueel gebeuren,
maar kan door gebruik van de juiste bibliotheek ook automatisch
gebeuren.

**1.1 Visual Basic .NET**

****

Visual Basic .NET, of kortweg VB.NET, is de opvolger van Visual Basic.
Het verschil met Visual Basic is dat VB.NET is gebaseerd op de Microsoft
.NET Framework. Deze .NET Framework is een deel van het Microsoft
Windows operating system. Het voorziet voorgeprogrammeerde oplossingen
voor algemene programmavereisten.

Een groot nadeel van VB.NET is een gebrek aan voorkennis. Hoewel het een
vrij eenvoudige programmeertaal betreft, zullen we toch eerst de taal
moeten aanleren. Met behulp van onze reeds parate kennis van C++ en java
zou dit evenwel niet voor problemen mogen zorgen. Verder zijn de kosten
die verbonden zijn met het programmeren in VB.NET nadelig. In
vergelijking met andere talen, brengt VB.NET een relatief dure
ontwikkelomgeving met zich mee.

**1.2 C++**

****

C++ wordt ook wel een mid-level programmeertaal genoemd, omdat het zowel
hig-level als enkele low-level mogelijkheden combineert. C++ is een zeer
krachtige, maar een vrij complexe programmeertaal. Het geheugen kan zelf
beheerd worden, real-time programmering is mogelijk, gebruik van
pointers, enz… . Dit alles zorgt ervoor dat er krachtige programma’s
kunnen geschreven worden. Deze uitgebreide mogelijkheden zullen er
echter ook voor zorgen dat het schrijven relatief bemoeilijkt wordt.
Aangezien deze verregaande opties niet bruikbaar zijn voor deze
masterproef, kunnen we ons beperken tot een eenvoudigere
programmeertaal.

Een pluspunt van deze taal is dat programma’s meestal sneller zijn in
uitvoering. Hoewel dit verschil tegenwoordig steeds kleiner en kleiner
wordt. Langs de andere kant, zal code veel moeilijker te debuggen zijn.
Bovendien is het programma platformafhankelijk. Dit wil zeggen dat
eenzelfde code niet zonder problemen kan worden gebruikt op
verschillende besturingssystemen zoals Windows, Linux of Mac OS. Ten
slotte kunnen we ook nog opmerken dat met C++ het moeilijker is om alles
grafisch zichtbaar te maken.

****

**1.3 C\#**

****

C\#, uitgesproken als C-sharp, is gebaseerd op zowel C++ als Java en de
.NET Framework van Microsoft. Hierdoor verkrijgen we een programmeertaal
die gemakkelijk begrijpbaar is, en relatief eenvoudig aan te leren. Toch
blijft het krachtig genoeg om relatief complexe problemen op te lossen.
Bovendien biedt C\# nog enkele extra mogelijkheden die niet in C++ of
Java zijn geïntegreerd. Deze taal verleent zich daarom perfect als
vertrekpunt voor onze masterproef. Het enige echte nadeel is dat we nog
geen enkele ervaring hebben met het programmeren in C\#.

********

**1.4 Java**

Bij de ontwikkeling van Java baseerde men zich op de talen C en C++. De
grootste verschillen met de programmeertalen C en C++ is dat Java een
eenvoudiger object model heeft en minder low-level mogelijkheden.
Bovendien wordt Java niet gecompileerd naar machinecode, specifiek voor
een bepaalde computer architectuur. Na een compilatie zal er echter een
bytecode verkregen worden. Deze bytecode kan dan draaien op een
zogenaamde JVM (Java virtual machine), ongeacht de computer
architectuur. Dankzij deze mogelijkheid kunnen we eenzelfde broncode
zorgen dat het programma op elke pc kan werken. Hierdoor zijn de scholen
vrij om te kiezen met welk besturingssysteem ze willen werken.

Andere voordelen die we bekomen door te werken met Java zijn o.a. de
automatische garbage collector, de herbruikbaarheid van de code, enz. .
Verder is voor onze masterproef ook de mogelijkheid van multithreading
nuttig. Hiermee kunnen meerdere processen tegelijkertijd worden
uitgevoerd, wat nodig is bij de eigenlijke simulatie van een schakeling.
Aangezien Java een wereldwijd veelgebruikte taal is, zijn er talloze
bibliotheken beschikbaar die het programmeren vergemakkelijken.

Programma ’s in Java hebben anderzijds de eigenschap dat ze meer
geheugen verbruiken. Mede hierdoor zal het programma in het algemeen
langzamer zijn dan bij de meeste andere programmeertalen. Een ander
minpunt is dat bij het gebruik van java een JRE (Jave runtime
environment) geïnstalleerd moet zijn. Al deze negatieve eigenschappen
vormen echter geen bijkomende problemen voor onze masterproef.

**1.5 conclusie**

****

Wanneer we alle voor- en nadelen van de verschillende programmeertalen
naast elkaar zetten, kunnen we concluderen dat er voor onze masterproef
drie talen voldoen. Zowel C++ als C\# of Java verlenen zich goed om een
simulator uit te werken. Als eerste elimineren we C++, vanwege een
persoonlijke voorkeur voor de andere kandidaten. Onze uiteindelijke
keuze is dan toch gevallen om verder te werken met Java. De grotere
voorkennis ten opzichte van C\# is de voornaamste reden die heeft
gezorgd voor de doorslag.

Ontwikkelomgeving

Er zijn talrijke programma’s beschikbaar die bruikbaar zijn om
Java-programma’s te schrijven. Enkele voorbeelden zijn:

-   Eclipse
-   Netbeans
-   Jcreator
-   Kawa
-   jEdit
-   …

Programma’s zoals Eclipse en Netbeans zijn veel uitgebreider dan meer
eenvoudigere editors zoals bijvoorbeeld Kawa. Door middel van de extra
mogelijkheden van de eerstgenoemde programma’s is het eenvoudiger een
overzicht te houden over het project. Bovendien zijn er allerlei
functies voorzien om het compileren en debuggen gemakkelijker te laten
verlopen. Deze IDE’s (Integrated Development Environment) zijn meestal
ook voorzien van code voltooiing of code completion, wat het
programmeren enigszins vereenvoudigt. Al deze extra mogelijkheden zorgen
er wel voor dat de software veel zwaarder is.

Een andere extra mogelijkheid die Eclipse en Netbeans biedt, is het
eenvoudig aanmaken van een GUI (Graphical User Interface). We kunnen
hierbij de nodige componenten slepen en plaatsen in een grafische
omgeving. Het programma zal dan zelf de nodige code genereren. Deze
werkwijze lijkt misschien eenvoudiger en sneller dan het traditioneel
zelf uitschrijven van de GUI. Toch opteren we om zelf de code te
schrijven. Dit zorgt ervoor dat we zeker zijn van een zo compact
mogelijke code, en is het eenvoudiger om wijzigingen aan te brengen.

Subversion
==========

Met het gebruik van Subversion kan er gemakkelijker met meerdere
personen en op verschillende plaatsen aan eenzelfde project worden
gewerkt. Het betreft een versiebeheersysteem. Hiermee staan al de
bestanden op een centrale plaats, in ons geval een server op de KHLim.
Eclipse heeft dan ook nog het grote voordeel dat subversion via een
plugin (nl. subclipse) kan geïntegreerd worden.

Wanneer iemand wil verderwerken aan het project, moet hij een ‘checkout’
doen. Dit houdt in dat de gegevens die op de server staan worden
gekopieerd naar zijn lokale harde schijf. Nu kunnen wijzigingen aan de
data doorgevoerd worden. Als alle nodige aanpassingen zijn gebeurd, moet
er een ‘commit’ gedaan worden. Met deze commit worden de veranderingen
opnieuw opgeslagen op de centrale ruimte, de server.

Zowel bij een ‘commit’ als een ‘checkout’ worden enkel de gewijzigde
gegevens of eventueel nieuwe bestanden doorgestuurd via internet. Dit
zorgt er dus voor dat het internetverkeer beperkt blijft. Aangezien we
een internet limiet hebben op kot, is deze optie een pluspunt. Dankzij
deze mogelijkheid ontstaat ook de mogelijkheid om beide tegelijkertijd
aan de masterproef te werken. Zolang we niet aan hetzelfde bestand
werken, zullen er dan geen conflicten optreden als we opnieuw een
‘commit’ uitvoeren.

Een andere handige functie van subversion is de mogelijkheid om terug te
grijpen naar een oudere versie. Wanneer achteraf blijkt dat
verschillende aanpassingen niet goed zijn, wordt er dus gewoon opnieuw
een oudere versie van de server afgehaald. Dit zorgt voor een
aanzienlijke vereenvoudiging voor het debuggen van het programma.

2 Editorkit
===========

Het gebruik van een *editorkit* vereenvoudigt het maken van grafische
applicaties in Java. Een editorkit is een bibliotheek waarin
verschillende klassen voorzien zijn voor grafische toepassingen aan te
maken. Zo bespaart een editorkit heel wat programmeerwerk. Er zijn
verschillende editorkits voorhanden zoals JHotDraw, GraphViz, Jung,
Grappa, Piccolo, InfoVis, … In de volgende paragrafen bespreken we kort
de meest geschikte editorkits voor onze GUI (Grafische User Interface).

2.1 JHotDraw
------------

JHotDraw is een *framework* voor grafische toepassingen aan te maken.
Het ondersteunt geometrische en door de gebruiker aangemaakte vormen,
het wijzigen van deze vormen en animaties. Hiervoor bevat JHotDraw een
collectie van verschillende vormen die elk apart gewijzigd kunnen
worden. JHotDraw bevat twee verschillende klassen, namelijk de *Drawing*
klasse en de *DrawingView* klasse. De Drawing klasse is het model van de
applicatie terwijl DrawingView het voorkomen van de tekening in de GUI
bevat. Hierdoor vergroot de flexibiliteit van JHotDraw. Alle applicaties
in JHotDraw bestaan bijgevolg uit een tekenmodel, een tekenzicht, een
collectie van tekenvormen samen met een *tool*.

2.2 Jung
--------

Jung is een bibliotheek voor de modellering, analyse en visualisatie van
data. Jung ondersteunt verschillende voorstellingen van entiteiten en
mechanismen. Zo zijn er onder andere mechanismen aanwezig voor
optimalisatie en het aanpassen van diagrammen. Jung voorziet ook een
visualisatie framework wat het makkelijk maakt om tools aan te maken om
netwerkdata interactief te verkennen. Hiervoor kan de gebruiker zelf een
eigen lay-out aanmaken of gebruik maken van een van de lay-outs die door
Jung voorzien zijn.

2.3 Grappa
----------

Grappa is een tekenpakket voor diagrammen dat de weergave en manipulatie
van diagrammen vereenvoudigt bij Java applicaties en applets en is een
onderverzameling van GraphViz. Grappa bevat methoden om tekeningen in te
lezen en weg te schrijven met behulp van het dot tekst formaat. Dit is
een taal waarin een diagram volledig in tekst beschreven is die zowel
computer als mens kunnen gebruiken. Hierdoor biedt Grappa het voordeel
dat de gebruiker diagrammen eenvoudig kan beschrijven, maar een nadeel
is dat er een bijkomende taal gekend moet zijn.

2.4 Piccolo
-----------

Piccolo is een bibliotheek voor zowel Java als C\# voor het ontwikkelen
van gestructureerde grafische applicaties met effecten zoals inzoomen en
animaties. Piccolo bestaat uit een hiërarchische structuur van objecten
en camera’s, waardoor het mogelijk is om objecten te groeperen en
manipuleren. Piccolo is gebruikt de Java2D API (Application Programming
Interface) voor de grafische verwerking. Hierdoor moet er minder
rekening gehouden worden met de lagere niveau details van het
programmeren. De belangrijkste klasse in Piccolo is de PNode klasse,
waaruit de andere klassen afgeleid zijn. Zo is alles wat zichtbaar en
waar interactie met de gebruiker aan gekoppeld is, een PNode. Voor deze
interacties zijn er in Piccolo verschillende *event listeners *voorzien.

2.5 Uiteindelijke keuze
-----------------------

Na het bestuderen van de verschillende editorkits en de bijhorende
voorbeelden, is gebleken dat de beste keuze Piccolo is. Met Piccolo is
het namelijk duidelijk om PNodes aan elkaar te linken en zo een
duidelijke structuur te krijgen. Verschillende PNodes kunnen samen een
figuur voorstellen en kunnen elk een andere event listener krijgen
toegewezen. Dit is handig voor het aanmaken van de modules die nodig
zijn voor de trein aan te sturen. Zo kan er bijvoorbeeld aan elke in- of
uitgang een andere gebeurtenis worden toegewezen, terwijl ze een
onderdeel zijn van de module waartoe ze behoren. Een ander voordeel van
Piccolo is dat alles gemakkelijk geïntegreerd kan worden in Swing, de
standaardbibliotheek van Java voor grafische applicaties.

Voor Piccolo is er voldoende documentatie beschikbaar. Zo is de
volledige API beschikbaar op de webpagina van Piccolo. Ook staat er een
uitgebreide handleiding online, wat het aanleren van de bibliotheek
vergemakkelijkt. Er zijn voldoende voorbeelden beschikbaar gesteld door
de ontwikkelaars, waardoor de werking van Piccolo verduidelijkt.

XML
===

XML is de afkorting van eXtensible Markup Language. Het betreft een
formaat om gegevens gestructureerd vast te leggen. XML is in eerste
instantie ontworpen om het delen van de gegevens over verschillende
informatiesystemen te vereenvoudigen. Het grote voordeel is dat de
gestructureerde data behalve voor de machine, ook goed herkenbaar en
leesbaar blijft voor de gebruiker. Met behulp van deze XML kunnen we dan
verschillende richtingen uit. Het kan dienen om de inhoud om te zetten
naar een bepaald zoals bijvoorbeeld HTML met behulp van een zogenaamde
opmaaktaal. Of het kan ook dienen om de gegevens gemakkelijk en
gestructureerd te raadplegen.

Eén van de vereisten van onze opdrachtgever is dat de gegevens over alle
mogelijke modules in een extern bestand worden gedefinieerd. XML biedt
hiervoor een goede oplossing. Alle gegevens kunnen gestructureerd worden
voorgesteld, zodat ook alles duidelijk blijft voor de gebruiker. Dit
zorgt ervoor dat achteraf ook vrij eenvoudig wijzigingen kunnen
doorgevoerd worden, zonder dat er een kennis nodig is van de
programmeertaal. Bovendien moet het programma niet opnieuw gecompileerd
worden bij wijzigingen aan de gegevens. Al deze eigenschappen zorgen
voor een zeer goed gebruiksgemak. En nu zijn er geen moeilijke ingrepen
meer nodig om eventueel modules aan te passen.

Vanuit de XML bestanden kunnen we op een vrij eenvoudige wijze de
gegevens omzetten naar objecten in Java. Zo bekomen we dan objecten die
in het programma kunnen gebruikt worden, en waarop al de nodige
bewerkingen kunnen uitgevoerd worden. Het inlezen van de gegevens in de
programmacode, noemt men parsing. Om dit uit te voeren zijn er reeds
verschillende zogenaamde XML parsers ontworpen. De meest bekende, en ook
meest gebruikte parsers, zijn de DOM API en de SAX API. We zullen nu
verder ingaan op de werking van deze parsers.

### ***2 parsers***

Een eerste mogelijkheid om de gegevens vanuit XML bestanden te parsen is
door gebruik te maken van de DOM API. Dit is de afkorting voor Document
Object Model Application Programming Interface. Met behulp van deze DOM
API is het mogelijk om doorheen het volledige XML bestand te navigeren.
Het bestand wordt opgevat als een boomstructuur volgens de aanwezige
elementen, waarin dan de nodige gegevens wordt uitgefilterd. Doordat het
volledige document moet ingeladen in het geheugen, is deze manier van
werken iets tijdrovender.

Een andere veel gebruikte manier om XML te parsen met behulp van de SAX.
Dit is de afkorting voor Simple API for XML. Hiermee bekomen we een
event-gestuurde API voor het inlezen van XML bestanden. Elk XML bestand
wordt dan serieel ingelezen, waardoor we een sequentiële gegevensstroom
verkrijgen. Hierdoor hebben we een snelle en efficiënte manier om de
gegevens uit te lezen. Nadelig is echter dat we hierdoor moeilijker
willekeurig data uit het XML bestand kunnen halen.

Ten slotte zijn er ook nog de minder gebruikte methodes pull parsing en
data binding. Bij pull parsing wordt het document behandeld als reeks
objecten. Het uitlezen gebeurt dan door middel van een iteratief
patroon. Terwijl bij data binding de gegevens worden aangeboden als een
zelf bepaalde gegevensstructuur van een programmeertaal .

Logger
------

Een logger is een manier om de status van een programma of bepaalde
gebeurtenissen in een logbestand bij te houden. Zo kan een logger het
*debuggen *van een applicatie vereenvoudigen. Ook de juiste werking van
een applicatie kan zo nagegaan worden. Hierdoor is het eenvoudiger om de
juiste werking van de simulatie in ons programma na te gaan.

### Java Logging

In de standaardbibliotheek van Java zijn klassen voorzien om te kunnen
loggen. Deze logger schrijft de gebeurtenissen naar een *LogRecord*
object. Een filter haalt de berichten uit dit object aan de hand van een
vooropgesteld filterniveau. De filter stuurt deze gefilterde berichten
dan door naar een *Handler *object. Met dit Handler object is het
mogelijk de berichten via een *Formatter *naar het gewenste formaat om
te zetten. De logberichten kunnen zo naar een bestand weggeschreven
worden als tekst of al XML formaat. De gebruiker kan ook een eigen
Handler en Formatter schrijven indien de standaardklassen van Java niet
voldoen aan zijn vereisten.

### Log4j

Log4j is een logger van de Apache Software Foundation. Log4j kan de
uitvoer van de applicatie bijhouden in verschillende formaten zoals
onder andere HTML, XML en gewone tekst. Log4j bestaat uit 3
hoofdcomponenten: de logger zelf, de *appender* en de lay-out. De logger
houdt de logberichten bij en schrijft ze dan weg naar een appender
interface. Net zoals bij de logger van Java is bij Log4j mogelijk om een
niveau in te stellen bij ieder bericht. De lay-out bepaalt het formaat
van de berichten. Ook hier zijn verschillende formaten beschikbaar of
kan de gebruiker zelf een lay-out maken.

### Conclusie

Java Logging en Log4j tonen veel gelijkenissen in zowel gebruik als
structuur. Log4s bestaat al langer dan Java Logging en is *open source*.
Dit betekent dat iedere gebruiker de code kan bekijken en bewerken. Maar
Java Logging is voldoende uitgewerkt en wordt door Sun zelf ondersteund.
Omdat de functionaliteit van Java Logging voldoende is voor deze
masterproef, hebben we besloten deze logger te gebruiken. Ook moet er zo
geen extra bibliotheek toegevoegd worden.

De Workspace
------------

In de workspace is het mogelijk de schakeling aan te maken die later
gesimuleerd zal worden. Het is mogelijk in meerdere workspaces tegelijk
te werken. Het programma houdt hiervoor bij welke workspace het laatst
actief is. Het programma voorziet ook knoppen om lijnen te tekenen en
verwijderen, modules te verwijderen en een stopknop om alle acties te
stoppen. In iedere workspace is een trein getekend die niet verwijderd
kan worden omdat in iedere schakeling een trein aanwezig moet zijn.

De gebruiker kan een module selecteren van een apart venster, waarin de
configuratiemodules ingelezen zijn. Een tijdelijke afbeelding van de
module volgt de cursor tot de module wordt toegevoegd door een muisklik.
Hierbij maakt het programma de module aan en plaatst de in- en uitgangen
en voegt de nodige *listeners* toe. Men kan een module ook verwijderen.
De module zal dan transparant worden indien de cursor over de module
beweegt. Dit is om duidelijk aan te geven dat er interactie mogelijk is
met de module. Bij het verwijderen van een module, verwijdert het
programma ook automatisch alle lijnen die met deze module verbonden
zijn.

De gebruiker kan modules verbinden door een lijn te tekenen tussen de
in- of uitgangen van twee modules. Hierbij licht de connectie op
afhankelijk van of er een lijn getekend mag worden in de connectie.
Indien het toegelaten is een lijn te tekenen, zal de connectie groen
oplichten als de cursor erover beweegt. Als de gebruiker een foute
verbinding wil maken zoals 2 uitgangen met elkaar verbinden, zal de
connectie rood oplichten. Tekent hij de lijn toch, dan geeft het
programma een foutmelding. Dit is om zoveel mogelijk fouten bij de
simulatie eruit te halen.

Het is ook mogelijk lijnen te verwijderen. Net zoals bij het verwijderen
van een module, wordt een lijn transparant indien de cursor erover
beweegt en de verbonden connecties lichten op. Indien de cursor echter
over een connectie gaat waar een lijn aan verbonden is, zal de connectie
oplichten. Ook hier wordt de lijn transparant en licht de verbonden
connectie op. Na een muisklik op de lijn of een van de verbonden
connecties, verwijdert het programma de lijn.

Alle modules en verbindingen worden bijgehouden per workspace zodat het
programma ze achteraf makkelijk terug kan ophalen. Zo is er een
duidelijke structuur aanwezig van modules en verbindingen wat nodig is
voor de simulatie.

Opslaan/opslaan als
-------------------

Als een gebruiker een schakeling aan het tekenen is, kan het dat hij
door bijvoorbeeld tijdgebrek niet meer kan verder werken. Hiervoor is
een functie voorzien om een schakeling op te slaan. Het programma
schrijft hiervoor de noodzakelijke gegevens die nodig zijn om de
schakeling terug te kunnen inladen, weg in een tekstbestand. Indien de
schakeling voor de eerste keer wordt opgeslagen, roept het programma de
functie “opslaan als” op. Hierbij opent de verkenner en kan de gebruiker
de locatie en de naam van het bestand kiezen. Het programma houdt de
naam en locatie bij zodat de gebruiker ze niet steeds opnieuw moet
ingeven. Dit is wel mogelijk door “opslaan als” te kiezen.

Het programma slaat de namen van de modules en de index van de module.
Ook de positie van de module in de schakeling wordt opgeslagen. Daarna
volgen de 2 namen van connecties die verbonden zijn met elkaar en de
index van tot welke module ze behoren.De woorden ‘links’ en ‘end’ geven
respectievelijk het begin van de connecties en het einde van het bestand
aan. Hieronder volgt een voorbeeld met bijhorend tekstbestand.

![](Pictures/10000000000002BB000001F3E8AF6863A0B1EF2B.jpg){width="15.886cm"
height="11.367cm"}

Figuur 1: voorbeeld van een schakeling

Het opgeslagen tekstbestand horend bij figuur 1 geeft:

  ---------------------------
  trein 0 3.0 3.0
  
  lichtsensor 1 523.0 209.0
  
  schakelaar 2 133.0 213.0
  
  NIET-poort 3 410.0 37.0
  
  OF-poort 4 253.0 77.0
  
  links
  
  uitgang 1 ingang2 3
  
  uitgang1 3 ingang22 4
  
  uitgang1 2 ingang12 4
  
  uitgang2 4 traag\_snel 0
  
  end
  ---------------------------

Laden
-----

Een schakeling opslaan is natuurlijk nutteloos als hij niet terug
ingeladen kan worden. Daarom voorziet het programma ook een functie om
schakelingen in te laden. Net zoals bij “opslaan als” opent de verkenner
bij het laden, zodat de gebruiker het juiste bestand kan kiezen.

Het programma leest het tekstbestand regel per regel in. Eerst leest het
de namen van de modules in met bijhorende index en posities. Dit is
voldoende om de juiste module aan te maken, ze te indexeren en in een
nieuwe workspace te plaatsen. Daarna leest het programma de namen van de
connecties met de index in. Aan de hand van de naam en de index kan het
programma de juiste connectie op de juiste module zoeken. Tussen de 2
connecties op iedere regel van het tekstbestand, tekent het dan een lijn
en wijst de juiste *mapping* toe voor de simulatie.

Door dit systeem van opslaan en laden bekomen we een eenvoudige
voorstelling van een schakeling. De gegevens in het opgeslagen
tekstbestand zijn tot een minimum behouden, maar toch genoeg om de
schakeling te kunnen inladen. Zo neemt een opgeslagen schakeling niet
veel plaats in van de harde schijf of ander geheugen.

***Overzicht modules***

  --------------------------------- ---------------------------------------------------------------------------------------------- ---------------------------------------------------------------------------------------------- ---------------------------------------------------------------------------------------------------------------------------------------- ---------------------------------------------------------------------------------------------------------------------------
                                    Naam                                                                                           Symbool                                                                                        Schema                                                                                                                                   Werking
                                    drukknop                                                                                       ![](Pictures/10000000000000A20000003DF3EF380E34EDCEE6.png){width="4.286cm" height="1.614cm"}   ![](Pictures/1000000000000040000000A13376CCEE50A5D0A7.png){width="1.693cm" height="4.26cm"}                                              Bij het indrukken van de drukknop verschijnt een 1 aan de uitgang. Wanneer de drukknop niet is ingedrukt is de uitgang 0.
  schakelaar                        ![](Pictures/100000000000006F000000348D16F7D1137394F2.png){width="2.937cm" height="1.376cm"}   ![](Pictures/1000000000000049000000BD3AE8C0D32BA178AC.png){width="1.764cm" height="4.54cm"}    De schakelaar heeft aan de uitgang een 1 of een 0, afhankelijk van zijn stand, en houdt deze uitgang tot we de schakelaar omschakelen.
  Logische poorten                  NIET-poort                                                                                     ![](Pictures/100000000000007E00000067B1B842226346F1AC.png){width="3.334cm" height="2.725cm"}   ![](Pictures/1000000000000049000000C088DAD33B29A0075C.png){width="1.764cm" height="4.643cm"}                                             De NIET-poort het signaal aan zijn ingang omdraaien (inverteren).
  EN-poort                          ![](Pictures/10000000000000990000005CE9B590331EE1184A.png){width="4.048cm" height="2.434cm"}   ![](Pictures/100000000000004A000000C18E549B789AEBA3D2.png){width="1.79cm" height="4.671cm"}    De EN-poort heeft enkel een 1 aan zijn uit uitgang wanneer beide ingangen 1 zijn.
  OF-poort                          ![](Pictures/100000000000008F0000005B8A757142AAEE3C50.png){width="3.784cm" height="2.408cm"}   ![](Pictures/100000000000004B000000BB016A4F17FA85E213.png){width="1.863cm" height="4.644cm"}   Aan de uitgang van de OF-poort verschijnt een 1 als minstens één van de ingangen 1 is.
  sensoren                          lichtsensor (LDR)                                                                              ![](Pictures/10000000000000A70000004B10B544BD95E7FBD7.png){width="4.419cm" height="1.984cm"}   ![](Pictures/100000000000004D000000C17BC974E27499BFBE.png){width="1.923cm" height="4.814cm"}                                             De uitgang wordt 1 wanneer er voldoende licht invalt op de sensor.
  magneetschakelaar (reed-switch)   ![](Pictures/100000000000009C00000028BE5E2DD0597186B3.png){width="4.128cm" height="1.058cm"}   ![](Pictures/100000000000004D000000BB6FBB63C2468FFE8A.png){width="1.951cm" height="4.74cm"}    Wanneer de sensor in de buurt komt van de magneet, zal er een 1 aan de uitgang komen.
  botsingssensor                                                                                                                   ![](Pictures/100000000000005D000000EDCEB504B3C02E3457.png){width="2.155cm" height="5.48cm"}    De uitgang zal 1 worden wanneer de trein een vooraf ingestelde afstand tot een voorwerp bereikt.
                                    wachtmodule                                                                                                                                                                                   ![](Pictures/1000000000000051000000C09DC3BF9CE6D731A8.png){width="2.143cm" height="5.08cm"}                                              Vertragingscomponent: de ingang zal met een vertraging aan de uitgang verschijnen.
  uitvoersignalen                   zoemer                                                                                         ![](Pictures/100000000000005E00000071439171B54CF9FEB4.png){width="2.487cm" height="2.99cm"}    ![](Pictures/100000000000004E000000BEB40E750C107F4947.png){width="2.064cm" height="5.027cm"}                                             Als er een 1 wordt aangelegd aan de zoemer zal er een geluid te horen zijn.
                                    flip-flop                                                                                      ![](Pictures/100000000000004B0000004BE3DF38FD206A6FEF.jpg){width="2.646cm" height="2.646cm"}   ![](Pictures/1000000000000064000000E2EFF9AFAB2B43942C.jpg){width="2.191cm" height="4.949cm"}                                             De uitgang wordt:\
  --------------------------------- ---------------------------------------------------------------------------------------------- ---------------------------------------------------------------------------------------------- ---------------------------------------------------------------------------------------------------------------------------------------- ---------------------------------------------------------------------------------------------------------------------------


