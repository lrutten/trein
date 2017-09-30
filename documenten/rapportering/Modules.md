***Overzicht modules***

+-------------+-------------+-------------+-------------+-------------+
|             | Naam        | Symbool     | Schema      | Werking     |
+-------------+-------------+-------------+-------------+-------------+
|             | drukknop    | ![](Picture | ![](Picture | Bij het     |
|             |             | s/100000000 | s/100000000 | indrukken   |
|             |             | 00000A20000 | 00000400000 | van de      |
|             |             | 003DF3EF380 | 00A13376CCE | drukknop    |
|             |             | E34EDCEE6.p | E50A5D0A7.p | verschijnt  |
|             |             | ng){width=" | ng){width=" | een 1 aan   |
|             |             | 4.286cm"    | 1.693cm"    | de uitgang. |
|             |             | height="1.6 | height="4.2 | Wanneer de  |
|             |             | 14cm"}      | 6cm"}       | drukknop    |
|             |             |             |             | niet is     |
|             |             |             |             | ingedrukt   |
|             |             |             |             | is de       |
|             |             |             |             | uitgang 0.  |
+-------------+-------------+-------------+-------------+-------------+
| schakelaar  | ![](Picture | ![](Picture | De          |
|             | s/100000000 | s/100000000 | schakelaar  |
|             | 000006F0000 | 00000490000 | heeft aan   |
|             | 00348D16F7D | 00BD3AE8C0D | de uitgang  |
|             | 1137394F2.p | 32BA178AC.p | een 1 of    |
|             | ng){width=" | ng){width=" | een 0,      |
|             | 2.937cm"    | 1.764cm"    | afhankelijk |
|             | height="1.3 | height="4.5 | van zijn    |
|             | 76cm"}      | 4cm"}       | stand, en   |
|             |             |             | houdt deze  |
|             |             |             | uitgang tot |
|             |             |             | we de       |
|             |             |             | schakelaar  |
|             |             |             | omschakelen |
|             |             |             | .           |
+-------------+-------------+-------------+-------------+-------------+
| Logische    | NIET-poort  | ![](Picture | ![](Picture | De          |
| poorten     |             | s/100000000 | s/100000000 | NIET-poort  |
|             |             | 000007E0000 | 00000490000 | het signaal |
|             |             | 0067B1B8422 | 00C088DAD33 | aan zijn    |
|             |             | 26346F1AC.p | B29A0075C.p | ingang      |
|             |             | ng){width=" | ng){width=" | omdraaien   |
|             |             | 3.334cm"    | 1.764cm"    | (inverteren |
|             |             | height="2.7 | height="4.6 | ).          |
|             |             | 25cm"}      | 43cm"}      |             |
+-------------+-------------+-------------+-------------+-------------+
| EN-poort    | ![](Picture | ![](Picture | De EN-poort |
|             | s/100000000 | s/100000000 | heeft enkel |
|             | 00000990000 | 000004A0000 | een 1 aan   |
|             | 005CE9B5903 | 00C18E549B7 | zijn        |
|             | 31EE1184A.p | 89AEBA3D2.p | uitgang     |
|             | ng){width=" | ng){width=" | wanneer     |
|             | 4.048cm"    | 1.79cm"     | beide       |
|             | height="2.4 | height="4.6 | ingangen 1  |
|             | 34cm"}      | 71cm"}      | zijn.       |
+-------------+-------------+-------------+-------------+-------------+
| OF-poort    | ![](Picture | ![](Picture | Aan de      |
|             | s/100000000 | s/100000000 | uitgang van |
|             | 000008F0000 | 000004B0000 | de OF-poort |
|             | 005B8A75714 | 00BB016A4F1 | verschijnt  |
|             | 2AAEE3C50.p | 7FA85E213.p | een 1 als   |
|             | ng){width=" | ng){width=" | minstens    |
|             | 3.784cm"    | 1.863cm"    | één van de  |
|             | height="2.4 | height="4.6 | ingangen 1  |
|             | 08cm"}      | 44cm"}      | is.         |
+-------------+-------------+-------------+-------------+-------------+
| sensoren    | lichtsensor | ![](Picture | ![](Picture | De uitgang  |
|             | (LDR)       | s/100000000 | s/100000000 | wordt 1     |
|             |             | 00000A70000 | 000004D0000 | wanneer er  |
|             |             | 004B10B544B | 00C17BC974E | voldoende   |
|             |             | D95E7FBD7.p | 27499BFBE.p | licht       |
|             |             | ng){width=" | ng){width=" | invalt op   |
|             |             | 4.419cm"    | 1.923cm"    | de sensor.  |
|             |             | height="1.9 | height="4.8 |             |
|             |             | 84cm"}      | 14cm"}      |             |
+-------------+-------------+-------------+-------------+-------------+
| magneetscha | ![](Picture | ![](Picture | Wanneer de  |
| kelaar      | s/100000000 | s/100000000 | sensor in   |
| (reed-switc | 000009C0000 | 000004D0000 | de buurt    |
| h)          | 0028BE5E2DD | 00BB6FBB63C | komt van de |
|             | 0597186B3.p | 2468FFE8A.p | magneet,    |
|             | ng){width=" | ng){width=" | zal er een  |
|             | 4.128cm"    | 1.951cm"    | 1 aan de    |
|             | height="1.0 | height="4.7 | uitgang     |
|             | 58cm"}      | 4cm"}       | komen.      |
+-------------+-------------+-------------+-------------+-------------+
| botsingssen | ![](Picture | ![](Picture | De uitgang  |
| sor         | s/100000000 | s/100000000 | zal 1       |
|             | 00000190000 | 000005D0000 | worden      |
|             | 00194EFA14F | 00EDCEB504B | wanneer de  |
|             | 01D1A4873.j | 3C02E3457.p | trein een   |
|             | pg){width=" | ng){width=" | vooraf      |
|             | 0.882cm"    | 2.155cm"    | ingestelde  |
|             | height="0.8 | height="5.4 | afstand tot |
|             | 82cm"}      | 8cm"}       | een         |
|             |             |             | voorwerp    |
|             |             |             | bereikt.    |
+-------------+-------------+-------------+-------------+-------------+
|             | wachtmodule | ![](Picture | ![](Picture | Vertragings |
|             |             | s/100000000 | s/100000000 | component:  |
|             |             | 000003F0000 | 00000510000 | de ingang   |
|             |             | 003B49BB385 | 00C09DC3BF9 | zal met een |
|             |             | 0E89A9C6E.j | CE6D731A8.p | vertraging  |
|             |             | pg){width=" | ng){width=" | aan de      |
|             |             | 2.223cm"    | 2.143cm"    | uitgang     |
|             |             | height="2.0 | height="5.0 | verschijnen |
|             |             | 81cm"}      | 8cm"}       | .           |
+-------------+-------------+-------------+-------------+-------------+
| **uitvoersi | zoemer      | ![](Picture | ![](Picture | Als er een  |
| gnalen**    |             | s/100000000 | s/100000000 | 1 wordt     |
|             |             | 000005E0000 | 000004E0000 | aangelegd   |
|             |             | 0071439171B | 00BEF120CD0 | aan de      |
|             |             | 54CF9FEB4.p | 55037BF7E.j | zoemer zal  |
|             |             | ng){width=" | pg){width=" | er een      |
|             |             | 2.487cm"    | 2.233cm"    | geluid te   |
|             |             | height="2.9 | height="5.3 | horen zijn. |
|             |             | 9cm"}       | 96cm"}      | Bij de      |
|             |             |             |             | simulator   |
|             |             |             |             | zal enkel   |
|             |             |             |             | zijn LED    |
|             |             |             |             | gaan        |
|             |             |             |             | branden.    |
+-------------+-------------+-------------+-------------+-------------+
|             | flip-flop   | ![](Picture | ![](Picture | De uitgang  |
|             |             | s/100000000 | s/100000000 | wordt:\     |
|             |             | 000003B0000 | 00000530000 |             |
|             |             | 003DA33E3FA | 00BB234CBC3 |             |
|             |             | 17AC581FB.j | 25BAE62B4.j |             |
|             |             | pg){width=" | pg){width=" |             |
|             |             | 2.081cm"    | 2.131cm"    |             |
|             |             | height="2.1 | height="4.7 |             |
|             |             | 52cm"}      | 63cm"}      |             |
+-------------+-------------+-------------+-------------+-------------+
|             | trein       | ![](Picture |             | De trein    |
|             |             | s/100000000 |             | heeft 3     |
|             |             | 00001300000 |             | ingangen    |
|             |             | 005FF4F021D |             | die zijn    |
|             |             | C6880C550.j |             | gedrag      |
|             |             | pg){width=" |             | beïnvloeden |
|             |             | 4.374cm"    |             | :           |
|             |             | height="1.3 |             |             |
|             |             | 67cm"}      |             | Een vierde  |
|             |             |             |             | ingang, aan |
|             |             |             |             | de voorkant |
|             |             |             |             | van de      |
|             |             |             |             | trein, laat |
|             |             |             |             | een lampje  |
|             |             |             |             | branden.    |
+-------------+-------------+-------------+-------------+-------------+


