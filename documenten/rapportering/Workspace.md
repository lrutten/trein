De Workspace
------------

In de workspace kan de gebruiker de schakeling aanmaken die hij later
wil simuleren. Hierbij is het mogelijk in meerdere workspaces tegelijk
te werken. Het programma houdt hiervoor bij welke workspace het laatst
actief is. Ook voorziet het programma knoppen om lijnen te tekenen en
verwijderen, modules te verwijderen en een stopknop om alle acties te
stoppen. Een ander manier om alle acties te stoppen, is eender waar in
de workspace met de rechtermuisknop klikken. In iedere workspace is een
trein getekend die niet verwijderd kan worden omdat in iedere schakeling
een trein aanwezig moet zijn. Figuur 1 geeft een voorbeeld van hoe een
workspace er uitziet.

![](Pictures/10000000000002A40000026B87265AC4460B7A31.jpg){width="14.915cm"
height="13.658cm"}

Figuur 1: Voorbeeld van een workspace

De gebruiker kan een module selecteren uit een apart venster, waarin de
configuratiemodules ingelezen zijn. Een tijdelijke afbeelding van de
module volgt hierbij de cursor tot de module wordt toegevoegd aan de
workspace door een muisklik. Hierbij maakt het programma de module aan
en plaatst de in- en uitgangen en voegt de nodige *listeners* toe. Men
kan een module ook verwijderen. De module zal dan transparant worden
indien de cursor over de module beweegt. Dit is om duidelijk aan te
geven dat er interactie mogelijk is met de module. Bij het verwijderen
van een module, verwijdert het programma ook automatisch alle lijnen die
met deze module verbonden zijn.

De gebruiker kan modules verbinden door een lijn te tekenen tussen de
in- of uitgangen van twee modules. Hierbij licht de connectie op
afhankelijk van of er een lijn getekend mag worden in de connectie.
Indien het toegelaten is een lijn te tekenen, zal de connectie groen
oplichten als de cursor erover beweegt. Als de gebruiker een foute
verbinding wil maken zoals 2 uitgangen met elkaar verbinden, zal de
connectie rood oplichten. Tekent hij de lijn toch, dan geeft het
programma een foutmelding. Dit is om zoveel mogelijk fouten bij de
simulatie eruit te halen. Bijlage geeft een overzicht van welke
mogelijke fouten het programma kan detecteren.

Het is ook mogelijk lijnen te verwijderen. Net zoals bij het verwijderen
van een module, wordt een lijn transparant indien de cursor erover
beweegt en de verbonden connecties lichten op. Indien de cursor echter
over een connectie gaat waar een lijn aan verbonden is, zal de connectie
oplichten. Ook hier wordt de lijn transparant en licht de verbonden
connectie op. Na een muisklik op de lijn of een van de verbonden
connecties, verwijdert het programma de lijn.

Alle modules en verbindingen worden bijgehouden per workspace. Zo is er
een duidelijke structuur aanwezig van modules en verbindingen. Dit is
nodig zodat de simulatie later eenvoudig de nodige modules en
verbindingen kan ophalen.


