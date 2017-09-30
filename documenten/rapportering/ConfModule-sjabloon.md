Configuratiemodulesjabloon
--------------------------

De gegevens die het programma inleest van de XML-bestanden, plaatst het
in een configuratieobject. Dit object is algemeen voor alle modules en
is maar eenmaal nodig. Figuur geeft dit object weer. Hierin is te zien
dat alle parameters die terug te vinden zijn in het XML-bestand ook hier
zijn terug te vinden. Xstream plaatst ze namelijk in dit object bij het
inlezen. Ook alle methodes om deze variabelen op te vragen, zijn in dit
object voorzien.

In Figuur is ook te zien dat de variabelen eventX, eventY, eventWidth en
eventHeigth in deze ConfModule aanwezig zijn. Deze variabelen worden
echter enkel ingelezen als ze ook in het XML-bestand aanwezig zijn. Dus
ze krijgen enkel een waarde indien er interactie met de gebruiker
mogelijk is bij de simulatie.

  -----------------------------------------------------------------
  **package** be.khlim.trein.modules.conf;
  
  **import** java.util.ArrayList;
  
  **public** **class** ConfModule {
  
  **private** ArrayList&lt;ConfOutput&gt; outputs; // all outputs
  
  **private** ArrayList&lt;ConfInput&gt; inputs; // all inputs
  
  **private** **float** ledx, ledy;
  
  **private** String image, imageIcon, name;
  
  **private** **boolean** vertical;
  
  **private** **float** eventX, eventY, eventHeight, eventWidth;
  
  **public** ConfModule(){
  
  }
  
  **public** **void** addName(String nm){
  
  name = nm;
  
  }
  
  **public** **void** addImagePath(String im){
  
  image = im;
  
  }
  
  **public** **void** addImageIcon(String ic){
  
  imageIcon = ic;
  
  }
  
  **public** **void** addVertical(**boolean** vert){
  
  vertical = vert;
  
  }
  
  **public** ArrayList&lt;ConfOutput&gt; getOutputs(){
  
  **return** outputs;
  
  }
  
  **public** ArrayList&lt;ConfInput&gt; getInputs(){
  
  **return** inputs;
  
  }
  
  **public** String getImage(){
  
  **return** image;
  
  }
  
  **public** String getImageIcon(){
  
  **return** imageIcon;
  
  }
  
  **public** String getName(){
  
  **return** name;
  
  }
  
  **public** **float** getLedX(){
  
  **return** ledx;
  
  }
  
  **public** **float** getLedY(){
  
  **return** ledy;
  
  }
  
  **public** **boolean** getVertical(){
  
  **return** vertical;
  
  }
  
  **public** **void** setEventX(**float** x){
  
  eventX = x;
  
  }
  
  **public** **void** setEventY(**float** y){
  
  eventY = y;
  
  }
  
  **public** **void** setEventWidth(**float** w){
  
  eventWidth = w;
  
  }
  
  **public** **void** setEventHeight(**float** h){
  
  eventHeight = h;
  
  }
  
  **public** **float** getEventX(){
  
  **return** eventX;
  
  }
  
  **public** **float** getEventY(){
  
  **return** eventY;
  
  }
  
  **public** **float** getEventWidth(){
  
  **return** eventWidth;
  
  }
  
  **public** **float** getEventHeight(){
  
  **return** eventHeight;
  
  }
  
  }
  -----------------------------------------------------------------


