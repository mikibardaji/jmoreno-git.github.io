# Conceptes bàsics de programació estructurada

1. Programes i algorismes
2. Elements d'un programa
3. Representació de programes

## Programes i algorismes

La programació d'ordinadors s'utilitza per resoldre problemes. Generalment, els problemes a resoldre consisteixen en processar informació i obtenir un resultat o prendre accions o decisions.

El procediment per resoldre un problema concret s'anomena **algorisme**. 

Un algorisme consisteix en un conjunt ordenat d'operacions que permeten resoldre un problema en un nombre finit de passos i en un temps finit. Pot acceptar un conjunt de **dades d'entrada** i un conjunt de **dades de sortida**.

La codificació dún algorisme en un ordinador s'anomena **programa**.

El **cicle de vida d'un programa** és el conjunt de fases per les que passa el proceś de creació del programa. 

Les fases principals que es poden considerar són:

* Anàlisi de requisits
* Disseny i desenvolupament
* Documentació
* Prova

L'anàlisi de requisits ha de permetre determinar quina informació ha de processar el programa, què ha de fer amb la informació, quin mecanismes de comunicació té amb els usuaris, etc.

Durant la fase de disseny i desenvolupament s'han de modelar les dades, definir i documentar les estructures de dades i desenvolupar i documentar el codi necessari.

Les metodologies de desenvolupament actuals inclouen la documentació i prova dintre del propi procés de desenvolupament del codi.

El disseny utilitza diagrames gràfics i [pseudocodi](https://ca.wikipedia.org/wiki/Pseudocodi).

Els diagrames permeten una visualització gràfica de l'estructura del codi (**diagrama de flux**) o de les dades (**diagrama UML**).

Per codificar els programes s'utilitzen llenguatges de programació, com per exemple java, C#, php, python, ... El resultat és el **codi font** del programa.

Per tal que l'ordinador pugui executar el programa, cal traduir el codi font al *codi màquina*, específic del sistema on s'ha d'executar.

Segons el tipus de traducció que es realitza, els llenguatges es classifiquen en interpretats i compilats.

Als llenguatges **interpretats**, cada instrucció es tradueix just abans de la seva execució. 

Als llenguatges **compilats**, en primer lloc un programa anomenat compilador fa la traducció completa del codi font. El resultat és el **codi objecte**, el qual encara s'ha d'enllaçar amb les biblioteques del llenguatge (**link**), obtenint al final el **codi executable**. Els llenguatges compilats proporcionen, en general, més velocitat d'execució.

Un tipus especial de llenguatges compilats són els que tenen un codi objecte intermig entre el codi font i el codi màquina. Aquests llenguatges necessiten una capa virtual que interpreti el codi intermig per executar-lo. Tot i que la velocitat no serà la mateixa que en el cas de codi objecte natiu, tenen com a avantatge que són multiplataforma, és a dir, que es poden executar un cop compilats en qualsevol sistema, ja que és aquesta capa virtual l'unica que cal instal·lar de forma específica a cada sistema. És el cas del llenguatge **java**.

## Elements d'un programa

En un el codi d'un programa informàtic podem trobar aquests elements:

### Variables i constants

Serveixen per emmagatzemar dades dintre del programa.

Han de tenir un tipus (defineix el tipus de dada contindrà), un valor (la dada concreta emmagatzemada) i un identificador (el nom amb què ens referirem a la variable o constant dintre del programa).

En el cas de les constants, no es permet canviar el valor durant l'execució del programa.

### Operadors

Són connectors de dades que simbolitzen accions sobre les dades.

En funció del tipus de dades que connecten i de l'operació que representen poden ser numèrics, alfanumèrics, lògics, etc.

### Expressions

Són combinacions de dades i operadors que proporcionen un resultat.

A les expressions, els operadors s'avaluen aplicant els criteris de prioritat establerts pel llenguatge. Si tenen igual grup de prioritat, s'avaluen d'esquerra a dreta.

