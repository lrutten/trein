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

[*http://www.jhotdraw.org/*](http://www.jhotdraw.org/)

[**http://softarch.cis.strath.ac.uk/PLJHD/Patterns/JHDDomainOverview.html**](http://softarch.cis.strath.ac.uk/PLJHD/Patterns/JHDDomainOverview.html)

[**http://jung.sourceforge.net/**](http://jung.sourceforge.net/)

[**http://www.datalab.uci.edu/papers/JUNG\_tech\_report.html**](http://www.datalab.uci.edu/papers/JUNG_tech_report.html)

[**http://www.research.att.com/\~john/Grappa/**](http://www.research.att.com/~john/Grappa/)

[**http://staff.aist.go.jp/y-ichisugi/mj/2003/mjGrappa/index.html**](http://staff.aist.go.jp/y-ichisugi/mj/2003/mjGrappa/index.html)

[**http://www.cs.umd.edu/hcil/jazz/**](http://www.cs.umd.edu/hcil/jazz/)


