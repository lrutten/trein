Tijdsafhankelijke modules
=========================

Voor de modules waar de tijd een belangrijke rol speelt, gelden
afwijkende regels. Het is niet mogelijk om deze modules op te bouwen op
dezelfde wijze als de andere modules. Voor de correcte verwerking bij de
simulatie is dan een nieuwe klasse aangemaakt. De klasse Wait zal een
vooraf bepaalde tijd wachten. Vervolgens ontvangt de klasse van de
module een signaal dat de tijd is verstreken. De uitgangen van de module
zullen zich dan aanpassen en indien nodig events versturen naar de
verbonden modules. Zowel de wachtmodule als de klok maken gebruik van
dit principe.

Figuur bevat de code van de Wait klasse. Het eerste attribuut (wait)
dient om de tijd aan te geven hoe lang er gewacht moet worden.
Vervolgens hebben we een verwijzing nodig van de module die de klasse
Wait oproept. Het laatste attribuut dat wordt gebruikt, is de status
waarin de uitgangen gewijzigd moet worden. Wanneer de klasse wordt
gestart, zal er voor de aangegeven tijd niets gebeuren. Daarna zorgt de
klasse voor het aanpassen van de uitgangen en het genereren van de
events. Bovendien moet het scherm opnieuw moeten hertekend om de
veranderingen zichtbaar te maken.

  ----------------------------------------------------------------------------
  **package** be.khlim.trein.modules;
  
  **import** java.io.Serializable;
  
  **public** **class** Wait **extends** Thread **implements** Serializable {
  
  **long** wait;
  
  Module module;
  
  **boolean** state;
  
  **public** Wait(**long** w, **boolean** st, Module mod){
  
  wait = w;
  
  module = mod;
  
  state = st;
  
  }
  
  **public** **void** run(){
  
  **try**{
  
  *sleep*(wait);
  
  module.writeOutputs(state,
  
  module.getOutputs().get(0).getSignal());
  
  module.colorNodes();
  
  module.simulate();
  
  module.sim().getLayer().repaint();
  
  }**catch**(InterruptedException e){ }
  
  }
  
  }
  ----------------------------------------------------------------------------

Om gebruik te maken van deze klasse Wait, zijn er slechts 2 regels code
nodig in de process methode. Eerst moet een object van de klasse Wait
worden aangemaakt. Om dit te realiseren dien je de tijd die gewacht moet
worden reeds te bepalen. Als nu de klasse wordt gestart, zal er een
nieuwe thread starten. Op deze manier is het wachten onafhankelijk van
het hoofdprogramma. De thread zal dan de ingestelde tijd stilgelegd
worden. Hierna worden de uitgangen veranderd en de events gegenereerd.
In het geval van de klok zal hierop volgend opnieuw de klasse Wait
worden aangesproken. Figuur geeft de code weer voor de process methode
in het geval van de wachtmodule.

  -----------------------------------------------------
  **public** **void** process(Event evt){
  
  **if**(! evt.getInput().getState() ==
  
  evt.getInput().mappedto().getState()){
  
  setInputs(evt.getInput());
  
  Wait wait = **new** Wait(outputs.get(0).getDelay(),
  
  evt.getInput().getState(), **this**);
  
  wait.start();
  
  }
  
  }
  -----------------------------------------------------


