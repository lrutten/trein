Modulesjabloon
--------------

De module is een Javaklasse waarin het gedrag en de eigenschappen van de
modules beschreven zijn. Deze klasse erft over van een algemene
moduleklasse genaamd Module.java. Deze klasse zorgt voor het aanmaken
van de in- en uitgangen en de juiste afbeeldingen. Ook de naam en de led
wordt hierbij aangemaakt. Hiervoor leest de module de juiste
configuratie uit de configuratiebestanden. Indien we dus een nieuwe
module willen toevoegen, moet deze overerven van Module.java. Hierbij
kan ook de constructor van deze klasse overgenomen worden. In het geval
van tijdsafhankelijke modules zoals de wachtmodule, is er een ander
principe van toepassing. Meer uitleg hierover staat in bijlage.

Afhankelijk van het gedrag van de module in de simulatie, is het nodig
enkele methodes die in Module.java voorzien zijn te *overriden*. Een
methode die altijd geïmplementeerd moet worden, is process(Event evt).
Deze methode zorgt immers voor de juiste verwerking van de module en
past indien nodig de in- en uitgangen aan. Andere mogelijke methodes om
toe te voegen zijn addListeners(), colorNodes() en initialize().
Hieronder bespreken we deze methodes verder.

### 1 De methode process(Event e)

De methode process(Event evt) is de belangrijkste methode van een
module. Het programma roept deze methode op als het bij de simulatie een
event doorstuurt naar een van de ingangen van de module. Dit event wordt
dan ook als parameter meegegeven. Figuur 1 geeft een voorbeeld van een
EN-poort. Bij deze module is het enkel nodig de methode process(Event
evt) toe te voegen. We leggen hieronder kort enkele methodes die veel
gebruikt worden in de verwerking van de meeste modules uit. Ook tonen we
aan hoe ze in de EN-poort gebruikt worden.

In de methode process(Event evt) is te zien dat er eerst gecontroleerd
wordt of het event wel een wijziging van de ingang doorvoert. Indien dit
niet het geval is, hoeft de verwerking niet te gebeuren. Dit gebeurt
door de volgende if-lus.

  -----------------------------------------------------------------------------
  **if**(! evt.getInput().getState() == evt.getInput().mappedto().getState())
  -----------------------------------------------------------------------------

Hierin is te zien dat het mogelijk is om uit het event de ingang waarop
het event binnenkomt, op te halen met getInput(). Vanuit deze ingang is
het mogelijk met mappedto() de connectie waarmee hij verbonden is te
verkrijgen. Met getState() wordt dan gecontroleerd of de status
gewijzigd is. Deze status is altijd true of false, overeenstemmend met 1
of 0.

Indien eenzelfde ingang meerdere connecties heeft, hebben deze
connecties dezelfde signaalnaam. Dit is een letter die toegekend wordt
aan elke in- of uitgang. Zo is het eenvoudig om de connecties horend bij
een bepaalde ingang van de module op te vragen. Een event binnenkomend
op een connectie van een ingang kan de waarde van deze ingang wijzigen
Hierbij moeten alle connecties van deze ingang op de nieuwe waarde gezet
worden. Dit gebeurt met de methode setInputs(Input in). Bij de EN-poort
gebeurt dit op de volgende manier.

  ----------------------------
  setInputs(evt.getInput());
  ----------------------------

De methode writeOutputs(boolean st, char sig) schrijft de meegegeven
waarde st naar alle connecties van de uitgang met de signaalnaam sig.
Indien een van deze uitgangen verbonden is met een ingang, zal deze
methode een nieuw event schrijven naar deze ingang. Zo is de verwerking
van deze module afgelopen. Als we opnieuw het voorbeeld van de EN-poort
bekijken, geeft dit de volgende regel.

  -------------------------------------------------------
  writeOutputs(inA && inB, outputs.get(0).getSignal());
  -------------------------------------------------------

Met getSignal() verkrijgt men de signaalnaam van een in- of uitgang. Een
EN-poort heeft maar een uitgang met twee connecties. Dus het is hierbij
voldoende om de signaalnaam van een van de twee connecties van de
uitgang mee te geven. Figuur 1 geeft dan de volledige klasse voor de
EN-poort EN-poort.java.

  ------------------------------------------------------------------------------
  **package** be.khlim.trein.modules;
  
  **import** be.khlim.trein.gui.Event;
  
  **import** be.khlim.trein.modules.conf.\*;
  
  **public** **class** EnPoort **extends** Module {
  
  **public** EnPoort(ConfModule cmod){
  
  **super**(cmod);
  
  }
  
  **public** **void** process(Event evt){
  
  **if**(! evt.getInput().getState() == evt.getInput().mappedto().getState()){
  
  setInputs(evt.getInput());
  
  **boolean** inA = **false**, inB = **false**;
  
  inA = evt.getInput().getState();
  
  **for**(Input in: inputs){
  
  **if**( !(evt.getInput().getSignal() == in.getSignal())){
  
  inB = in.getState();
  
  }
  
  }
  
  writeOutputs(inA && inB, outputs.get(0).getSignal());
  
  }
  
  }
  
  }
  ------------------------------------------------------------------------------

Figuur 1: Moduleklasse van een EN-poort

### 2 De methode addListeners()

Indien er bij de simulatie interactie mogelijk is met de gebruiker, moet
de methode addListeners() worden toegevoegd aan de moduleklasse. Ook de
constructor van de module verandert in dit geval. Nu moeten namelijk de
extra variabelen eventX, eventY, eventHeight, eventWidth ingelezen
worden uit de configuratiemodules. Dit gebeurt met de methode
setEventFrame(ConfModule cmod). Figuur geeft een voorbeeld van de
constructor voor een lichtsensor.

  ------------------------------------------
  **public** Lichtsensor(ConfModule cmod){
  
  **super**(cmod);
  
  **for**(Output out : getOutputs()){
  
  out.setDelay(0L);
  
  }
  
  setEventFrame(cmod);
  
  }
  ------------------------------------------

Hierin is ook te zien dat de methode setDelay(Long l) de vertraging van
de ingangen naar de uitgangen op nul zet. Dit is nodig omdat de
lichtsensor geen ingangen heeft en ze dus geen vertraging is. Deze
methode wordt meestal toegevoegdin de constructor indien de methode
addListeners aanwezig is in de module. Dit is omdat er meestal geen
ingangen aanwezig zijn als er gebruikersinteractie mogelijk is.

De methode addListeners() maakt het aanklikbaar gebied aan en voegt de
nodige listeners toe. Bij de lichtsensor is dit een listener voor als de
muisknop wordt ingeduwd. Aan de hand van de waarde van de uitgang past
deze listeners de afbeelding aan en voert de methode process(null) uit.
Ook de in- en uitgangen moeten opnieuw gekleurd worden. De methode
simulate() verwerkt de events die gegenereerd zijn in de methode
process().

  --------------------------------------------------------------
  **public** **void** addListeners(){
  
  PPath p = **new** PPath();
  
  p.setPathToEllipse(eventX, eventY, eventWidth, eventHeight);
  
  p.setPaint(Color.*white*);
  
  p.setTransparency(0);
  
  setImage(image.replaceAll(".j", "\_on.j"));
  
  setBounds(getX(),getY(),65,170);
  
  p.addInputEventListener(**new** PBasicInputEventHandler() {
  
  **public** **void** mousePressed(PInputEvent e){
  
  **if**(!outputs.get(0).getState()){
  
  setImage(image.replaceAll(".j", "\_on.j"));
  
  setBounds(getX(),getY(),65,170);
  
  }
  
  **else**{
  
  setImage(image);
  
  setBounds(getX(),getY(),65,170);
  
  }
  
  process(**null**);
  
  colorNodes();
  
  simulate();
  
  e.setHandled(**true**);
  
  }
  
  });
  
  addChild(p);
  
  }
  --------------------------------------------------------------

### 3 De methode initialize()

De methode initialize past de waardes van de uitgangen voor de simulatie
start. Bijvoorbeeld bij de lichtsensor is dit nodig. De uitgangen worden
hier immers op 1 gezet omdat er lichtinval is. De methode initialize()
voor de lichtsensor ziet er dan zo uit.

  -----------------------------------------------------
  **public** **void** initialize(){
  
  writeOutputs(**true**, outputs.get(0).getSignal());
  
  }
  -----------------------------------------------------

De methode writeOutputs() zet de uitgangen op 1 en schrijft een event
naar de ingangen die met deze uitgangen verbonden zijn. Deze events
worden dan verder afgehandeld zodat de schakeling volledig
geïnitialiseerd is.

### 4 De methode colorNodes()

Deze methode kleurt de in- en uitgangen aan de hand van hun waarde. De
led wordt standaard gekleurd aan de hand van de uitgang. Indien dit niet
het geval is, is het nodig om ook deze methode te voorzien in de module.
De zoemer bijvoorbeeld kleurt zijn led aan de hand van de waarde van
zijn ingang en wijkt hier af van de standaard. Voor de zoemer wordt deze
methode dan.

  -----------------------------------
  **public** **void** colorNodes(){
  
  **for**(Input in: inputs){
  
  **if**(in.getState()){
  
  in.setPaint(Color.*red*);
  
  led.setPaint(Color.*red*);
  
  }
  
  **else**{
  
  in.setPaint(Color.*black*);
  
  led.setPaint(Color.*black*);
  
  }
  
  }
  
  }
  -----------------------------------


