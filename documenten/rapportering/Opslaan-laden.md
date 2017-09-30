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
aan. Figuur 1 geeft een voorbeeld van een schakeling

![](Pictures/10000000000002BF000001F778521A1DC844249B.jpg){width="16.515cm"
height="11.83cm"}

Figuur 1: Opgeslagen workspace

Het opgeslagen tekstbestand horend bij figuur 1 geeft:

  -----------------------------------
  trein 0 3.0 3.0
  
  OF-poort 1 255.0 68.0
  
  NIET-poort 2 389.0 70.0
  
  schakelaar 3 95.0 195.0
  
  lichtsensor 4 539.0 177.0
  
  links
  
  ingangC\_traag\_snel 0 uitgangD 1
  
  uitgangA 3 ingangA2 1
  
  ingangB2 1 uitgangB 2
  
  ingangA2 2 uitgangA 4
  
  end
  -----------------------------------

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
