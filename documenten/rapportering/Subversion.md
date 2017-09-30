Subversion
==========

Met het gebruik van Subversion kan er gemakkelijker met meerdere
personen en op verschillende plaatsen aan eenzelfde project worden
gewerkt. Het betreft een versiebeheersysteem. Hiermee staan al de
bestanden op een centrale plaats, in ons geval een server op de KHLim.
Eclipse heeft dan ook nog het grote voordeel dat subversion via een
plugin (nl. subclipse) kan geïntegreerd worden.

Wanneer iemand wil verderwerken aan het project, moet hij een ‘checkout’
doen. Dit houdt in dat de gegevens die op de server staan worden
gekopieerd naar zijn lokale harde schijf. Nu kunnen wijzigingen aan de
data doorgevoerd worden. Als alle nodige aanpassingen zijn gebeurd, moet
er een ‘commit’ gedaan worden. Met deze commit worden de veranderingen
opnieuw opgeslagen op de centrale ruimte, de server.

Zowel bij een ‘commit’ als een ‘checkout’ worden enkel de gewijzigde
gegevens of eventueel nieuwe bestanden doorgestuurd via internet. Dit
zorgt er dus voor dat het internetverkeer beperkt blijft. Aangezien we
een internet limiet hebben op kot, is deze optie een pluspunt. Dankzij
deze mogelijkheid ontstaat ook de mogelijkheid om beide tegelijkertijd
aan de masterproef te werken. Zolang we niet aan hetzelfde bestand
werken, zullen er dan geen conflicten optreden als we opnieuw een
‘commit’ uitvoeren.

Een andere handige functie van subversion is de mogelijkheid om terug te
grijpen naar een oudere versie. Wanneer achteraf blijkt dat
verschillende aanpassingen niet goed zijn, wordt er dus gewoon opnieuw
een oudere versie van de server afgehaald. Dit zorgt voor een
aanzienlijke vereenvoudiging voor het debuggen van het programma.


