Logboek

8 juni

Eerste vergadering met Dhr Dehaene Wim. Voorstelling van de lego trein
en enkele van zijn mogelijkheden en een korte voorstelling wat de
opdracht inhoud.

Eind juni

Vergelijking van enkele mogelijke programmeertalen. Uiteindelijk
besloten om Java te gebruiken, zonder deze keuze te ondersteunen met de
nodige argumenten op papier.

9 juli

Schrijven van aanvaardingsbrief.

Juli en augustus

Zoeken naar documentatie over Java en leren van enkele mogelijkheden van
Java. Voornamelijk de klasse Swing voor het ontwerpen van de GUI werd
verder onderzocht.

7 september

Vergadering met Dhr Dehaene Wim, onze promotor Dhr Rutten Leo en Mevr
Mentens Nele. Concrete afspraken gemaakt over de vereisten waaraan het
programma moet voldoen en een eerste concrete opdracht vastgelegd.

De eerste opgave bestaat erin om te valideren als Java ook wel de
geschikte taal is voor dit eindwerk en een stappenplan uit te werken.

**10 september**

Uitschrijven van een verslag van de vergadering van vrijdag 7 september.

**11 september**

Op papier uit werken wat de voor - en nadelen zijn van mogelijke
programmeertalen voor het schrijven van het programma.\
Conclusie: beste mogelijkheden zijn Java of C\#. De keuze is gevallen op
Java, met als voornaamste argumentering onze al verworven voorkennis.

12 september

\* Overzicht gemaakt van alle beschikbare modules.\
\* Uitschrijven van situering voor in het eindverslag.

\* Werking van programma uitgewerkt en papier gezet.

\* Schema van programma gedeeltelijk uitgetekend.

14 september

Eerste mogelijke lay-out voor het programma uitgewerkt. De lay-out
uitgetekend op papier en al nagedacht over de implementatie.

19 september

\* Schema verder uitgewerkt voor de eerste mogelijke lay-out en op
papier gezet.

\* de lay-out uitgeschreven in java.

20 september

Opstellen van informatieblad.

24 september

\* Informatie zoeken van framework editors, gegeven door mr Rutten
(JHotDraw, Jung, prefuse)

\* Mogelijkheden zoeken voor maken GUI (JFrameBuilder, Java SWING
Components Library, netbeans, visual editor project, zelf GUI schrijven)

26 september

Andere mogelijke framework editors opzoeken (infovis, tulip, graphvis,
Jvider, piccolo, …). Onderzoek naar welke editors geschikt kunnen zijn.

1 oktober

\* Uitzoeken welke van de editors ook effectief in aanmerking komen om
te gebruiken voor ons eindwerk.

\* Uitzoeken hoe we best de GUI kunnen schrijven: met GUI builder of
zelf schrijven?

Best mogelijke opties: JHotDraw en Piccolo, en de frames zullen zelf
geschreven worden.

3 oktober

\* Afspraak met promotor: - uitleg over werking JHotDraw

- uitleg over subversion en hoe dit gebruiken in zowel

Windows als linux

- voor externe definities best gebruik maken van XML.

- het inlezen en wegschrijven van de definities via Xstream

\* Leren werken met JHotDraw en Piccolo.

Onze keuze voor verder gebruik in ons project: Piccolo

5 oktober

Nalezen van hoe we best communiceren, als voorbereiding op het schrijven
van de onderzoeksopzet.

**8 oktober**

Begonnen aan het uitschrijven van de onderzoeksopzet. Beknopt de
voornaamste zaken op papier zetten die in de onderzoeksopzet moet
opgenomen worden.

**9 oktober**

De onderzoeksopzet verder uitgeschreven.

**10 oktober**

Een eerste versie van het framework uitgeschreven als prototype.

17 oktober

Verder uitdiepen van Piccolo met onder andere de tutorial en
voorbeelden.

**24 oktober**

2^de^ vergadering met Dhr Dehaene en promotor Dhr Rutten.

Overlopen van de realisaties en evalueren van de gemaakte keuzes.

Conclusie:

-   Tegen volgende bijeenkomst (28 november):

    -    Een afgewerkt voorbeeld uitschrijven met piccolo, zodat de
        modules kunnen getekend en al verbonden worden.
    -   Zorgen dat de modules getoond worden in een lijst, en een
        selectie kan gemaakt worden. Modules staan beschreven in xml en
        worden ingelezen met Xstream.

-   Tegen kerstmis:

    -   Samenbrengen van de aparte deelprojecten, zodat een module wordt
        getekend afhankelijk van welke er geselecteerd werd.

30 oktober

-   Klasses zelf uitschrijven, inclusief de verwerking van de ingang.
    Zorgen dat alle modules getoond worden in een frame ( een kleine
    afbeelding wordt getoond, samen met de naam van de module)\
-   Piccolo: een eerste versie van de workspace klasse geschreven met
    modules die verbonden en verplaatsbaar zijn.

31 oktober

-   Modules zichtbaar maken:

    -   Alle klassen van modules in een package gezet.
    -   Zorgen dat er ook een selectie kan doorgegeven worden van welke
        module getekend moet worden.
    -   De werking van Xstream uitzoeken, en paar kleine toepassingen
        gemaakt om Xstream uit te testen.\

-   Piccolo: workspace uitgebreid met verbindingen die getekend kunnen
    worden en automatisch geüpdate worden.

1 november

Modules zichtbaar maken:

-   -   Vanuit xml alle modules uitgelezen en hiervan een object
        aangemaakt.\
        De modules worden getoond in een lijst, zowel afbeelding als
        naam. Een selectie van modules kan gedetecteerd en doorgegeven
        worden.
    -   Gezocht naar een oplossing zodat de werking van een module kan
        uitgelezen worden vanuit xml. Echter geen manier gevonden om dit
        te kunnen uitwerken.\

-   Piccolo: workspace afgewerkt: lijnen kunnen nu getekend en
    verwijderd worden en een eerste versie van een methode voorzien om
    modules in te lezen aan de hand van doorgegeven parameters.

7 november

Samenkomst met promotor Dhr Rutten om de gemaakte vooruitgang te
overlopen en indien nodig bij te sturen.

Conclusies:

-   UML opgesteld: de aanpassingen die hierdoor zullen doorgevoerd
    worden zorgen ervoor dat beide deelprojecten samen zullen moeten
    geïntegreerd worden.
-   Enkele tips om het beter uitschrijven van een Java programma:

    -   Gebruik anonieme classes, beter dan implementeren van een klasse
        zoals ActionListener.
    -   Relatieve paden verkiezen boven absolute paden om afbeeldingen
        of bestanden op te vragen
    -   Met Xstream een filter gebruiken om alle modules op te vragen,
        i.p.v. elke module zelf apart in te lezen.

-   Subversion gebruiken om versies bij te houden
-   De werking van modules kunnen niet extern gedefinieerd worden, maar
    zullen in Java moeten geschreven worden.

-   de paden allemaal verandert naar relatieve paden.
-   ActionListener geïmplementeerd als een anonieme klasse.

9 november

Laatste wijzigingen aanbrengen en verder uitschrijven van de
onderzoeksopzet.

**14 november**

eerste poging om de deelprojecten samen te voegen.

-   nog enkele errors bij het samenvoegen, waarvoor nog geen oplossingen
    is gevonden

16 november

oorzaak voor het probleem ontdekt, en gezocht naar eventueel mogelijke
oplossingen.

-   Oorzaak: een conflict tussen Xstream en piccolo
-   Oplossingen:

    -   -   Piccolo weglaten
        -   Xstream weglaten
        -   Java bestanden aanpassen (programma lichtjes herschrijven)

            -   -   Zonder overerving voor modules en Input / Output
                -   Extra files voor aanmaken conf. Bestanden.

**18 november**

Methode om modules te verwijderen afgewerkt.

19 november

-   *Conlusie:*

    -   Beste oplossing = configuratie-objecten aanmaken vanuit Xstream.
        En van daaruit de modules aanmaken voor de workspace.

21 november

-   Modules inlezen via xml verder uitgewerkt:

    -   Vanuit xml worden nu configuratie-objecten gemaakt
    -   Commentaar toegevoegd aan code
    -   Klassen voor aanmaaken van module-objecten aangemaakt, gegevens
        worden ui configuratie-objecten gehaald.

-   in orde brengen van subversion.

28 november

-   lijst van modules wordt nu getoond in het hoofdvenster, bovendien
    zal deze internalframe altijd op de voorgrond staan.
-   Beide deelprojecten samengevoegd.
-   confIput en confOutput aangemaakt
-   Connection klasse aangemaakt

4 december

Confmodules zijn bijgewerkt: overbodige data eruit gehaald,…

5 december

Modules worden nu ingelezen vanuit de klasse Simulator. Hierdoor wordt
voorkomen dat bij een selectie een static methode moet worden opgeroepen
uit de klasse Workspace.

Enkele kleine aanpassingen aan de klasse Simulator, zoals een ArrayList
voor de Workspace frames.

-   nog problemen: bij een selectie is workspace frame niet meer
    geselecteerd, en weten we niet welke frame actief was. En dus ook
    niet in welke frame er moet getekend worden.

Vergadering met promotoren.

Opmerkingen:

-   Tekenen van lijnen met rechte hoeken mogelijk?
-   Een ingang die niet is aangesloten komt overeen met de ingang aan de
    GND te hangen
-   Bij het runnen van de schakeling:

    -   Motor tekenen met 3 leds :

<!-- -->

-   -   -   1.  aan / uit
            2.  vooruit / achteruit
            3.  snel / traag

    -   Sensors moeten klikbaar zijn (andere kleur, zodat zien wat
        klikbaar is)

-   Doorsturen van werkende jar + link naar JRE

7 december

Gezocht naar een oplossing om bij een selectie van een module te weten
op welke workspace dit moet worden getekend.

*Mogelijke oplossing*: als frame gedeselecteerd wordt, wordt de frame
nummer hiervan bijgehouden.

**8 december**

De laatste module die geselecteerd wordt onthouden, en kan dus eventueel
meerde malen opnieuw worden getekend, zonder opnieuw een selectie te
moeten doen.

**12 december**

-   de geselecteerde module wordt getekend in de juiste workspace, bij
    een muisklik.
-   XML files in orde gebracht: alle posities van in- en uitgangen zijn
    aangevuld
-   Afbeeldingen worden allen op dezelfde grootte getekend.
-   Er is een grafische terugkoppeling toegevoegd.
-   Enkele kleine grafische aanpassingen

16 december

Grafische afwerkingen werden toegevoegd

**19 december**

-   fout (draghandler verdween) werd eruit gehaald.
-   Constructor van connections uitgewerkt, zodat de elke in- en uitgang
    een naam krijgen.
-   Controle toegevoegd op de verbinding van 2 uitgangen: een popup
    wordt getoond als 2 uitgangen worden verbonden.
-   Niet meer mogelijk om van 1 node meerdere verbindingen te maken.
-   Elke node kan niet meer met zichzelf worden verbonden.

5 februari

-   Overbodige code eruit gehaald
-   Imports apart gezet, ipv volledige swing en awt klasse te importeren
-   nieuw project aangemaakt, voor het uitzoeken van hoe de save functie
    te implementeren

> **19 februari**

-   oude code voorzien van de nodige commentaar, en de mogelijkheid
    voorzien tot het aanmaken van een API
-   overlopen hoe, wat en in welk formaat we willen opslaan en uitlezen

> **21 februari**

Bespreken van hoe we het programmeren van de simulator zullen aanpakken.

Voorbeeldprogramma gekregen van mijnheer Rutten.

**26 februari**

Begonnen met opstellen van het eindrapport. Al uitgeschreven:

1.  situering
2.  probleemstelling
3.  doelstelling
4.  methode
5.  overzicht modules (voor bijlage)

en dan gestart met schrijven deel over waarom de keuze voor java.

27 februari

Verder schrijven aan de keuze over java, vooral opzoekwerk over de
andere mogelijke kandidaten (VB.NET; C++, C\# ).

Gestart met schrijven waarom piccolo gekozen werd

**28 februari**

Keuze van java bijna af (enkel nog java zelf uitleggen + besluit)

Keuze van piccolo bijna af (enkel nog piccolo zelf + besluit)

Al afgewerkte delen:

1.  ontwikkelomgeving
2.  subversion

2 maart

deel verder afgewerkt

1.  Piccolo

5 maart

-   Nakijken van de test code voor het saven van workspaces + invoegen
    in simulator
-   Schrijven van het voortgangsrapport.
-   Verbeteren van onderzoeksopzet ( situering, probleemstelling,
    doelstelling, methode)

> **6 maart**

Aanpassen voortgangsrapport

**11 maart**

-   Methode om op te slaan afgewerkt
-   Methode toegevoegd voor opslaan als

<!-- -->

-   -   Alles wordt opgeslaan als txt (zonder extensie te hoeven typen)
    -   Filechooser heeft een filefilter zodat enkel txt bestanden
        worden getoond
    -   Enkel als de workspace nog niet is opgeslagen zal er een
        filechooser verschijnen (bij de oproep om te saven)

12 maart

Gestart met het invoegen van de mogelijkheid om een opgeslagen
schakeling te laden.

**13 maart**

-   De code aanpassen: Nederlandse termen en commentaar omzetten naar
    Engels. Zodat niet de 2 talen door elkaar wordt gebruikt.
-   Verder werken aan het laden.

> **14 maart**

-   Verder werken aan de methode om te laden.

<!-- -->

-   XML termen ook naar Engels omgezet.

**15 maart**

Laden van schakelingen voltooid.

**17 maart**

-   Code nu volledig in het Engels, met uitzondering van namen voor
    modules en tekst die aan gebruiker wordt getoond.
-   Aanmaken nieuw venster voor eigenlijke simulatie (problemen
    opgetreden bij het willen toevoegen van een nieuwe menubar met een
    ‘Run-knop’

> **18 maart**

-   probleem met ‘Run-knop’ opgelost
-   schakeling wordt getoond in het simulatie venster
-   trein toegevoegd om verbindingen mogelijk te maken. Trein wordt
    standaard getekend bij het openen van een nieuwe workspace + maar 1
    trein kan er worden geplaatst

> **24 maart**

-   aanpassen van de methode om te laden, zodat ook de trein en zijn
    verbindingen wordt ingelezen.
-   Trein kan niet meer worden verwijderd uit de workspace
-   Extra bestanden aangemaakt zodat de LED’s kunnen getekend worden en
    oplichten mogelijk.

**25 maart**

-   Zorgen dat de posities en de vorm van de LED’s wordt ingelezen
    vanuit de XML bestanden.
-   Connection, Input en Output klasses aangepast voor een betere
    verwerking van de modules.
-   De process methodes geschreven om van de gegeven uitgangen de
    uitgang te berekenen.

**26 maart**

-   Nieuwe package aangemaakt, voor de simulatie uit te voeren.
-   Raamwerk van de nodig geachte java-bestanden voor de simulatie.
-   Uitzoeken van hoe we een log bestand kunnen bijhouden via log4j,
    ontwikkeld onder het Jakarta Apache project, of met de log API van
    Sun zelf.

27 maart

-   Aanvullen van enkele java bestanden nodig voor de simulatie.
-   XML bestanden aangepast. De in- en uitgangen zullen nu een status
    false krijgen, zonder dit te vermelden in XML. Bij de start van de
    simulatie zal dan de juiste waarde worden ingevuld bij het
    initializeren.

31 maart

Eerste versie van het raamwerk voor het eindrapport aangemaakt

1 april

-   Uitschrijven van keuze Java afgewerkt
-   Uitschrijven van xml, de workspace, de API en javadoc
-   Verklarende woordenlijst toegevoegd
-   Raamwerk aangepast

> **2 april**

Aanvulling van de huidige afgewerkte delen voor eindwerk:

1.  waarom keuze voor java + vergelijken met andere talen
2.  API + javadoc
3.  de workspace

3 april

-   Toevoegen van een tekst over het gebruik van een logger bibliotheek.
-   Toevoegen van commentaar bij het gedeelte van de simulatie, met
    uitleg over wat de methodes zullen moeten uitvoeren.

> 9 april

Entity, outchannel en inchannel klasse verplaatst naar Module, Input,
Output en Connection

> **11 april**

Verwijderen van overbodige klasses, methodes en variabelen uit de SSF
API.

**13 april**

Run klasse aangepast, zodat er de schakelaar kan aan- of uitgezet kan
worden. Maar er trad een error op in de module klasse, nog geen
oplossing gevonden.

**14 april**

-   Het probleem met de module klasse is opgelost, door bij de process
    klasse implements serializable toe te voegen.
-   Afbeelding toegevoegd voor een schakelaar die in uitpositie staat.
-   De afbeelding van de zoemer is voorzien van een LED.
-   De schakelaar kan verschoven worden. Bovendien worden alle nodige
    gegevens uitgelezen vanuit XML.

**15 april**

-   Code herschrijven als voorbereiding op simulatie
-   Drukknop, magneetschakelaar, lichtsensor en botsingssensor kunnen
    van status veranderen door erop te klikken
-   Toevoeging van 2^de^ afbeelding voor magneetschakelaar en
    lichtsensor
-   Trein is bij simulatie voorzien van 3 LED’s en de status van de 3
    ingangen wordt weergegeven
-   Herschikken van code: simulation klasse verwijderd, en zijn methodes
    verplaatst naar run klasse

===&gt; code nu volledig voorzien om simulatie te starten

**16 april**

-   Resterende process methodes uitgeschreven
-   Mapping van connecties wordt aangemaakt bij het tekenen van lijnen
    en unmapped bij verwijderen van lijnen, de mapping wordt nu in de
    Connection klasse bijgehouden
-   Initialiseren van modules voor start simulatie geschreven
-   In module mùethode voorzien voor het detecteren van zwevende
    ingangen
-   Code iets herschreven voor events te verwerken.

**22 april**

-   Foutje in algoritme voor initialisering van modules eruit gehaald
-   De methode joinAll is hernoemd tot simulate
-   Logger toegevoegd
-   Fout door een typfout bij het inladen aangepast
-   Raamwerk aangevuld met al de reeds geschreven teksten + in orde
    maken van alle normen voor de deadline van communicatie

!!!! ERROR !!!!

Connection.mappedto().getParent() gaf null-verwijzing doordat bij het
opstarten van Run de modules gekopieerd werden en de verwijzingen van de
mapping niet meer klopte. Voorlopig verwijzing van modules gekopieerd in
Run, nog aanpassen zodat alles gekopieerd wordt.

> **23 april**

-   verwerking van processen en events aangepast + processState van de
    modules laten wijzigen op de gepaste plaatsen
-   alle sensors kunnen events genereren + hun output wordt geüpdate en
    de kleur van de node wordt aangepast
-   events worden gegenereerd in een arrayList van de hoofdklasse voor
    het simuleren
-   Logger.doc afgewerkt en opslaan/opslaan als en laden uitgeschreven

Nu ook afgewerkte delen van eindrapport:

1.  logboek bibliotheek
2.  opslaan / opslaan als
3.  laden

**29 april**

-   probleem bij de mapping in de connections is opgelost
-   bij het laden wordt nu de geopende workspace actief
-   abstract geschreven
-   simulatie afgewerkt

======&gt; Probleem opgetreden: wanneer sensor/schakelaar/...
rechtstreeks of via een wachtmodule naar de trein gaan, komen er geen
events aan op de trein ingangen !!!!

**30 april**

-   enkele foutjes uit het programma gehaald, nu hebben we een volledig
    werkende simulator.
-   Leds lichten ook op bij simulatie en de tekst verandert bij de trein
    als de ingang wijzigt
-   Titel van workspace is nu aangepast aan de filename, iconen
    aangepast van internal frames
-   controle toegevoegd of er een workspace aanwezig is voor module
    getekend kan worden.

> 1 mei

-   flipflop werkt nu ook. De gemapte connectie wordt nu bij process
    meegegeven. Door overriding wordt deze enkel bij de process van
    flipflop gebruikt.
-   Foutje bij inladen ivm index verwijderd
-   Scrollbars aan Run toegevoegd indien nodig
-   Oplichten van nodes bij verwijderen lijn aangepast

 3 mei

Processing anders geschreven. Reeds bij het oproepen wordt de juiste
processing gebruikt. Hierdoor moeten er minder methodes worden voorzien.

**5 mei**

-   Xstream verder uitgeschreven.
-   XML sjabloon voor in bijlagelijst, voorzien van de nodige uitleg.
-   Verbeteren van abstract en doorsturen naar docent communicatie

Afgewerkte delen:

1.   XML en Xstream
2.   XML sjabloon

6 mei

-   Een verwijzing toegevoegd bij connection, een verwijzing naar de
    link waartoe hij behoort

<!-- -->

-   Bij het simuleren worden de links opnieuw aangemaakt
-   De module (owner) wordt bijgehouden in een connectie. getParent()
    niet meer nodig, en dus ook geen typecasting.
-   De mapping is verwijdert. De methodes zijn echter gebleven, maar nu
    aan de hand van de bijgehouden link. Methodes zoals mappedto();
    unmap;…
-   Voor het verwerken van een module moet er een event worden
    meegegeven
-   Mouselisteners verplaatst naar de module

7 mei

-   Namen van connecties zijn aangepast in XML. Nu kan elke connectie
    een connectie van het zelfde signaal herkennen aan zijn naam.
-   ProcessState is verwijderd
-   In connection is er een methode getSignal toegevoegd. Hierin wordt
    aangegeven bij welk signaal een connectie hoort (wordt uit de naam
    van de connectie gefilterd).
-   getSignalInputs methode in connection gezet. Hiermee verkrijgen we
    een arrayList met alle inputs van een bepaald signaal (het nodige
    signaal moet als parameter worden meegegeven.
-   Enkele warnings verwijderd.
-   Het unmapping van een connectie aangepast.
-   Het initialiseren van alle modules gebeurt aan de hand van events.
-   Toevoegen van Linkset voor een eenvoudigere controle als 2 outputs
    zijn verbonden, eventueel onrechtstreeks.

    -   Linkset wordt aangemaakt bij het tekenen van een lijn
    -   Verwijderen bij verwijderen van een lijn

-   Event afhandeling aangepast
-   Inputs kunnen ook events genereren, met een delay van 0.
-   Een update, en licht herschrijven van alle process methodes van de
    modules

**9 mei**

-   Toevoegen van een controle bij het tekenen van lijnen. Aan de hand
    van linksets wordt gecontroleerd als 2 outputs worden verbonden,
    eventueel onrechtstreeks
-   Aanpassen kleuren van nodes bij het tekenen.

10 mei

-   Volledig uitschrijven van de inleiding voor het eerste hoofdstuk
    (ontwerptechnieken)
-   Aanpassen van het raamwerk

12 mei

-   de index van de modules wordt aangepast bij het verwijderen van een
    module. Zo wordt een out of bounds exception vermeden bij het
    simuleren.
-   Addlisteners en colornodes verplaats naar de modules. Hierdoor is er
    geen vergelijking meer nodig op de naam van modules.
-   Bij het verwijderen van een lijn, word de linkset opgesplitst indien
    nodig.
-   Toevoegen commentaar.

13 mei

-   Lussen worden voorkomen. Er worden enkel events gegenereert als er
    een wijziging optreedt aan de ingang.
-   Een workspace wordt geactiveerd bij het openen van een nieuw scherm.
-   Verwijderen enkele foutjes bij de process methode van een flip flop
-   Acties worden gestopt bij een rechtermuisklik
-   Inleiding toegevoegd voor eerste hoofdstuk

Afgewerkte delen:

19\. Inleiding ontwerptechnieken

14 mei

-   Methode containsSignal toegevoegd aan LinkSet
-   Structuiur LinkSet en Link aangepast
-   Oplossen van oneindige lussen

15 mei

-   Controles van connecties aangepast aan andere structuur
-   2 LinkSets worden samengevoegd indien ze gelinkd worden
-   Aparte popup voor als 2 uitgangen onrechtstreeks verbonden zijn
-   Kleuren van nodes bij simulatie gewijzigd
-   Abstract verbeterd na controle Lievens
-   Programma zoeken voor het maken van een UML-schema

16 mei

-   Knop schakelaar juist gezet
-   Foutje controle eruit gehaald

**18 mei**

-   Workspace.doc + OIpslaan-laden.doc aangepast
-   Xml sjabloon aangepast aan nieuwe namen connecties
-   Modules toevoegen.doc aangemaakt en deels uitgeschreven

**19 mei**

-   Samenbrengen van alle losse tekstdelen
-   Opgegeven layout toepassen op de samengebrachte tekst
-   Hoofdstukindeling en -nummering aangepast
-   Random toevoegen aan de events vanuit outputs (delay tussen 20
    en 30)
-   Aanpassen van trein afbeelding (toevoegen lampje + aansluiting)
-   Mogelijkheid tot oplichten van de lamp aan de voorkant van de trein
-   Flip-flop afbeelding geüpdate aan de nieuwe module
-   Foutje uit workspace verwijderd

**20 mei**

-   Signaalnamen voor eenzelfde uitgangssignaal gelijknamig gemaakt
-   Aanpassen van de controles bij het tekenen aan de nieuwe benamingen
-   Outputs van eenzelfde signaal krijgen allen dezelfde random delay
    toegewezen
-   Verbeteren van spellingsfouten in het eindrapport (verbeteringen
    door dhr. Creyns, dhr. Lievens en zelf enkele foutjes gevonden en
    verbeterd).
-   Tekst over het inlezen van modules gestart
-   Aanpassen van XML sjabloon en modules toevoegen.doc
-   Aanmaken confmodule sjabloon
-   Maken UML voor confModules, Modules en inlezen XML en voor het
    tekenen

**21 mei**

-   Tekst over UML + aanmaken fictief UML als voorbeeld
-   Module sjabloon aangemaakt
-   Aanpassingen confmodule sjabloon en modules toevoegen
-   Tekst programma architectuur van workspace aangevuld
-   Herschrijven van methode writeOutputs(). Nu moet aangegeven worden
    welk uitgangssignaal moet aangepast worden.
-   Schrappen overbodige code

**22 mei**

-   Maken van UML over werking van de simulatie
-   Figuur voor moederbord getekend met een voeding en grond
-   Uitschrijven van de programma architectuur voor het inlezen van de
    modules
-   Uitleggen van de structuur van de confModules a.h.v. UML
-   Toevoegen van tekst over de mogelijke foutmeldingen
-   Vereenvoudigen van de structuur van de ConfModules. Nu gemakkelijker
    een module toevoegen, en bovendien minder werk.
-   Methode setEventFrame toegevoegd: codebeperking en geen
    codeherhaling meer bij aanklikbare modules
-   vereenvoudiging voor inlezen van configuratiemodules via de methode
    readConfModule
-   aanpassen van sjablonen voor confmodule, module en XML
-   afronden van tekst voor toevoegen van modules
-   aanpassen van de readModule methoden
-   wachtmodule wacht effectief 10 sec vooraleer hij zijn uitgang
    aanpast en een event stuurt
-   bijhouden van referentie naar de simulator in de elke workspace
    (vermijden static)
-   afwerken van de tekst over het inlezen van de modules
-   programma architectuur voor de simulatie uitgelegd
-   methodes getDelay en setDelay verplaatst naar connection
-   knoppen in main window geplaatst in een werkbalk en toegevoegd aan
    het menu

