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

BRONNEN

Wikipedia

Handboek: The Java language specification (third edition)
