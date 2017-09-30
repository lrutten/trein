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
data binding. Bij pull parsing wordt het document behandeld als een
reeks objecten. Het uitlezen gebeurt dan door middel van een iteratief
patroon. Terwijl bij data binding de gegevens worden aangeboden als een
zelf bepaalde gegevensstructuur van een programmeertaal .

### ******3 Xstream******

Xstream is een gratis bibliotheek voor Java. Hiermee kunnen we dan op
een eenvoudige wijze objecten aanmaken door het inlezen vanuit
XML-bestanden. Een andere mogelijkheid van Xstream is het omzetten van
een object in Java naar XML. Dit is echter bij onze masterproef niet van
toepassing. Om deze functionaliteiten te realiseren maakt Xstream
gebruik van XPP3 (XML Pull Parser 3rd edition). Bij het converteren
tussen objecten en XML wordt dus gebruik gemaakt van een parser
gebaseerd op de pull parsing technologie.

Dankzij Xstream kunnen we op een snelle en eenvoudige manier al de
nodige gegevens van een module uitlezen vanuit een XML-bestand.
Bovendien kan met deze bibliotheek eenvoudig worden overgeschakeld naar
één van de andere mogelijke XML parser.

BRONNEN

Wikipedia

Cursus Leo Rutten inf8

http://xstream.codehaus.org/
