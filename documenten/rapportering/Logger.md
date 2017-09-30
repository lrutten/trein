Logger
------

Een logger is een manier om de status van een programma of bepaalde
gebeurtenissen in een logbestand bij te houden. Zo kan een logger het
*debuggen *van een applicatie vereenvoudigen. Ook de juiste werking van
een applicatie kan zo nagegaan worden. Hierdoor is het eenvoudiger om de
juiste werking van de simulatie in ons programma na te gaan.

### Java Logging

In de standaardbibliotheek van Java zijn klassen voorzien om te kunnen
loggen. Deze logger schrijft de gebeurtenissen naar een *LogRecord*
object. Een filter haalt de berichten uit dit object aan de hand van een
vooropgesteld filterniveau. De filter stuurt deze gefilterde berichten
dan door naar een *Handler *object. Met dit Handler object is het
mogelijk de berichten via een *Formatter *naar het gewenste formaat om
te zetten. De logberichten kunnen zo naar een bestand weggeschreven
worden als tekst of al XML formaat. De gebruiker kan ook een eigen
Handler en Formatter schrijven indien de standaardklassen van Java niet
voldoen aan zijn vereisten.

### Log4j

Log4j is een logger van de Apache Software Foundation. Log4j kan de
uitvoer van de applicatie bijhouden in verschillende formaten zoals
onder andere HTML, XML en gewone tekst. Log4j bestaat uit 3
hoofdcomponenten: de logger zelf, de *appender* en de lay-out. De logger
houdt de logberichten bij en schrijft ze dan weg naar een appender
interface. Net zoals bij de logger van Java is bij Log4j mogelijk om een
niveau in te stellen bij ieder bericht. De lay-out bepaalt het formaat
van de berichten. Ook hier zijn verschillende formaten beschikbaar of
kan de gebruiker zelf een lay-out maken.

### Conclusie

Java Logging en Log4j tonen veel gelijkenissen in zowel gebruik als
structuur. Log4s bestaat al langer dan Java Logging en is *open source*.
Dit betekent dat iedere gebruiker de code kan bekijken en bewerken. Maar
Java Logging is voldoende uitgewerkt en wordt door Sun zelf ondersteund.
Omdat de functionaliteit van Java Logging voldoende is voor deze
masterproef, hebben we besloten deze logger te gebruiken. Ook moet er zo
geen extra bibliotheek toegevoegd worden.

Bronnen:

[**http://java.sun.com/j2se/1.4.2/docs/guide/util/logging/**](http://java.sun.com/j2se/1.4.2/docs/guide/util/logging/)

[**http://www.developer.com/open/article.php/3097221**](http://www.developer.com/open/article.php/3097221)

[**http://logging.apache.org/log4j/**](http://logging.apache.org/log4j/)


