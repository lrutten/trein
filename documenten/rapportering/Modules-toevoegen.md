Modules toevoegen
-----------------

Een vereiste van het programma was dat er achteraf op een eenvoudige
manier modules toegevoegd konden worden. Daarom hebben we de
aanpassingen die nodig zijn tot een minimum proberen te houden. Om een
module toe te voegen zijn er enkele stappen nodig. Er zijn 2 bestanden
nodig voor een module, namelijk een XML-bestand en een Javabestanden.
Nadat deze aangemaakt zijn, is het nodig enkele regels Javacode toe te
voegen in het hoofdprogramma. Volgende paragrafen verduidelijkt deze
stappen.

### 1 Het XML-bestand

In het XML-bestand staat de configuratie van de module. Hierin staan de
in- en uitgangen met hun posities. Indien er geen in- of uitgangen
aanwezig zijn op de module, mogen deze worden weggelaten uit het
XML-bestand. Ook de positie van de led staat in dit bestand, met een
parameter die aangeeft of de led horizontaal of verticaal gericht is.
Verder staat in dit XML-bestand de naam van de modules en het pad naar
de afbeeldingen van de module. Het icoon wijst op de afbeelding van de
lijst waaruit de modules geselecteerd kunnen worden. De gewone
afbeelding wijst op de afbeelding die gebruikt wordt bij het tekenen.

Het kan zijn dat de gebruiker bij de simulatie bijvoorbeeld een knop op
de modules kan verzetten. In dit geval moeten er nog enkele parameters
toegevoegd worden aan het XML-bestand. Dit zijn de eigenschappen van het
gebied waarop men kan klikken. Deze parameters mogen weggelaten worden
indien er geen interactie nodig is bij de simulatie.

Een meer gedetailleerde uitleg over het XML-bestand en voorbeelden zijn
gegeven in bijlage.

Het programma leest de configuratie uit het XML-bestand in met behulp
van Xstream en plaatst ze in een configuratiemodule. Deze
configuratiemodule is gemeenschappelijk voor alle modules en dient niet
aangemaakt te worden. Voor meer informatie over het configuratie-bestand
verwijzen we naar bijlage.

### 2 De module

Een tweede bestand dat nodig is om een module aan te maken, is een
Javabestand voor de module zelf. Dit is het belangrijkste bestand want
hiermee maakt het programma de module aan en plaatst de in- en
uitgangen. Een methode moet altijd aanwezig zijn in dit bestand,
namelijk de methode process(Event evt). Dit is de methode die zorgt voor
de verwerking van de in- en uitgangen waar de parameter evt het
binnenkomende event is. De overige variabelen en methodes erft de module
over van een algemeen object.

Bij het XML-bestand en kunnen extra parameters meegegeven zijn voor
interactie bij de simulatie. Indien dit het geval is, moet er een extra
methode voorzien worden, namelijk addListeners(). Deze methode maakt het
aanklikbaar gebied aan. Ook wordt hier toegevoegd wat er moet gebeuren
als er bijvoorbeeld met een muis op dit gebied geklikt wordt

Verder kan het zijn dat ook de methode colorNodes() nodig is. Normaal
kleurt de module bij de simulatie zijn connecties aan de hand van hun
status. Ook kleurt hij de led aan de hand van de status van de uitgang.
Indien dit anders moet gebeuren bij een bepaalde module, zal deze een
eigen methode colorNodes() moeten hebben die de connecties en led
kleurt.

Indien de module zijn in- of uitgangen al moet wijzigen voor de
simulatie start, zal ook de methode initialize() aanwijzig moeten zijn.
Dit is bijvoorbeeld bij de NIET-poort het geval. Hier is immers voor de
simulatie start de uitgang al 1 als de ingang 0 is. Voor deze module zal
de methode initialize() de uitgangen dus al gaan aanpassen voor de
simulatie start.

Voor een module moeten dus enkele belangrijke modules voorzien worden.
De methode process(Event e) moet altijd aanwezig zijn. De methodes
addListeners(), colorNodes() en initialize() zijn optioneel. Indien een
van deze laatste drie methodes niet in de module aanwezig zijn, zal de
methode uit de algemene moduleklasse genomen worden. Meer uitleg en
voorbeelden over de module is te vinden in bijlage.

### 3 De code

Als de voorgaande 2 bestanden aangemaakt zijn, moeten deze nog in het
hoofdprogramma ingebracht worden. Hiervoor moeten in 2 bestanden een
kleine wijziging gebeuren, namelijk Simulator.java en Workspace.java.
Deze bestanden zijn terug te vinden in de package “be.khlim.trein.gui”.

Het eerste bestand dat gewijzigd moet worden, is Simulator.java. Hierin
moet in de methode makeModules() nog de link naar het XML-bestand staan.
Dit gebeurt door in deze methode de methode readConfModule(String
location, Xstream x) te plaatsen. Deze methode zorgt voor de aanmaak van
een configuratiemodule. De parameter location is het pad van het
XML-bestand en x is het Xstream object, in Simulator.java xstream
genaamd. Voor een module met een XML-bestand met de naam
‘modulenaam.xml’ wordt dit dan.

  ------------------------------------------------
  readConfModule("XML/modulenaam.xml", xstream);
  ------------------------------------------------

Hierna moet enkel nog Workspace.java gewijzigd worden. Het programma
vergelijkt in de methode readModule(ConfModule cmod, Point2D p, int ind)
op de namen van de doorgegeven configuratiemodule aan de hand van
if-else-lussen. Om een nieuwe module toe te voegen, volstaat het om een
nieuwe if lus toe te voegen die controleert op de naam van deze module.
De naam van de module is degene die in het XML-bestand is meegegeven. In
deze if-lus maakt het programma dan de juiste module aan. Voor een
module met naam ‘modulenaam’ en een modulebestand met naam
‘ModuleNaam.java’ wordt dit dan.

  -----------------------------------------------
  **else** **if** (name.matches("modulenaam")){
  
  mod = **new** ModuleNaam(cmod);
  
  }
  -----------------------------------------------

Zo maakt het programma de juiste modules aan. Verder zijn er geen
wijzigingen nodig.

### 4 Conclusie

Om te besluiten zetten we vatten we even kort de nodige stappen nog eens
samen.

1.  XML-bestand aanmaken
2.  Module aanmaken
3.  Aanmaken van het configuratiebestand toevoegen in Simulator.java
4.  Zorgen dat de juiste module wordt aangemaakt in Workspace.java

