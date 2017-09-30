Foutmeldingen
-------------

Het programma is in staat om enkele fouten detecteren en signaleren. Zo
zal de gebruiker geen 2 uitgangen met elkaar kunnen verbinden omdat dit
in de realiteit ook niet is toegelaten. In werkelijkheid kan op één
connectie geen 2 draden geplaatst worden terwijl dit bij de grafische
gebruikersinterface wel mogelijk zou zijn. Het programma moet dus ook
controleren of de gebruiker in een connectie 2 lijnen wil tekenen.
Hieronder volgt een overzicht van de mogelijke fouten die het programma
zal signaleren.

### 1 Connectie met zichzelf verbinden

Het programma zal niet toelaten dat een connectie met zichzelf verbonden
is. Dit is namelijk nutteloos en in werkelijkheid is dit ook niet
mogelijk. Er kan namelijk maar een draad per connectie verbonden worden.
Figuur geeft een voorbeeld van de foutmelding. De connectie in het rood
is de connectie waarvan wordt getracht met zichzelf te verbinden.

![](Pictures/10000000000002BC000001F1B39669606A312462.jpg){width="16.002cm"
height="11.361cm"}

### 2 Meerdere lijnen per connectie tekenen

Het is niet mogelijk meerdere lijnen te tekenen in een connectie. Indien
dit toch gebeurt, zal het programma een foutmelding geven. Ook hier
licht de connectie waar de fout optreedt op. Figuur geeft hier een
voorbeeld van.

![](Pictures/10000000000002BE000001F4ABEDECC9FBB1685F.jpg){width="15.991cm"
height="11.389cm"}

### 3 Twee uitgangen met elkaar verbinden

Twee uitgangen mogen nooit met elkaar verbonden worden. Indien de
modules hier niet tegen beveiligd zijn, kan dit in werkelijkheid tot
beschadiging van de modules leiden. Daarom is het belangrijk deze fout
eruit te halen bij het tekenen van een schakeling. Figuur geeft een
voorbeeld van deze foutmelding. De uitgangen die met elkaar verbonden
zijn, zijn in het rood aangegeven.

![](Pictures/10000000000002B9000001F3732AE3E5419A6C29.jpg){width="15.988cm"
height="11.446cm"}

### 4 Twee uitgangen onrechtsreeks met elkaar verbinden

Twee uitgangen kunnen ook via andere connecties onrechtstreeks met
elkaar verbonden zijn. Het programma detecteert dit en laat het niet
toe. Figuur verduidelijkt deze fout. Hier is de uitgang van de
schakelaar verbonden met ingang A van de OF-poort. Deze ingang is via
zijn andere connectie verbonden met de uitgang van de lichtsensor.
Hierdoor is zijn de uitgangen van de schakelaar en de lichtsensor dus
onrechtstreeks met elkaar verbonden. Ook hier lichten de verbonden
uitgangen op.

![](Pictures/10000000000002BC000001F40B5195FFA72B4C5F.jpg){width="16.002cm"
height="11.43cm"}
