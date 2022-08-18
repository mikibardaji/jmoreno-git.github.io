# Conceptes bàsics de programació estructurada

1. Programes i algorismes
2. Cicle de vida d'una aplicació
3. Elements d'un programa
4. Representació de programes

## Programes i algorismes

Un ordinador és una màquina electrònica dotada d'una memòria de gran capacitat i de mètodes de tractament de la informació, capaç de resoldre problemes matemàtics i lògics mitjançant la utilització automàtica de programes informàtics.

Els components principals d'un ordinador són el processador central, la memòria i els perifèrics. Entre els perifèrics destaquen el teclat, la pantalla i els discs d'emmagatzemament (dics durs).

El **processador central** és el cervell de l'ordinador i realitza operacions aritmètico-lògiques sobre la informació que recupera de la memòria.

Els components físics de l'ordinador són el **maquinari**. Les dades i els programes constitueixen el **programari**.

El sistema operatiu de l'ordinador és la capa de programari que s'encarrega de la gestió i control del maquinari i proporciona eines per gestionar la informació i els programes.

La programació d'ordinadors s'utilitza per resoldre problemes. Generalment, els problemes a resoldre consisteixen en processar informació i obtenir un resultat o prendre accions o decisions.

El procediment per resoldre un problema concret s'anomena [**algorisme**](https://es.wikipedia.org/wiki/Algoritmo)

Un algorisme consisteix en un conjunt ordenat d'operacions que permeten resoldre un problema en un nombre finit de passos i en un temps finit. Pot acceptar un conjunt de **dades d'entrada** i un conjunt de **dades de sortida**.

La codificació d'un algorisme en un ordinador s'anomena **programa**.

**Activitat**
Prova de programar el moviment per arribar a la destinació [Blockly:laberint](https://blockly.games/maze?lang=es)

## Cicle de vida d'una aplicació

El procés que se segueix des del plantejament d'un problema fins a tenir una solució instal·lada en la computadora, i en funcionament pels usuaris finals, es denomina **cicle de vida d'una aplicació informàtica**.

Les fases principals que es poden considerar són:

- Anàlisi
- Disseny
- Codificació
- Compilació
- Muntatge
- Prova i depuració
- Explotació i manteniment

L'anàlisi ha de permetre determinar quina informació ha de processar el programa, què ha de fer amb la informació, quin mecanismes de comunicació té amb els usuaris, etc.

Durant la fase de disseny s'han de modelar les dades i definir la solució al problema (algorisme) utilitzant diagrames gràfics o [pseudocodi](https://ca.wikipedia.org/wiki/Pseudocodi).

Els diagrames permeten una visualització gràfica de l'estructura del codi (**diagrama de flux**) o de les dades (**diagrama UML**).

La fase de codificació consisteix en transcriure l'algorisme utilitzant llenguatges de programació, com per exemple java, C#, php, python, ... El resultat és el **codi font** del programa.

Els llenguatges més propers a les característiques i arquitectura de l'ordinador es diuen **llenguatges de baix nivell**, com ara el *llenguatge màquina* i el *llenguatge assemblador*.

Els llenguatges més propers al programador, amb característiques més complexes s'anomenen **llenguatges d'alt nivell**, com per exemple, Fortran, C, Cobol, Pascal, Java, etc.

Per tal que l'ordinador pugui executar el programa, cal traduir el codi font al *codi màquina*, específic del sistema on s'ha d'executar. Això es realitza a les fases de compilació i muntatge.

Segons el tipus de traducció que es realitza, els llenguatges es classifiquen en interpretats i compilats.

Als llenguatges **interpretats**, cada instrucció es tradueix just abans de la seva execució. 

Als llenguatges **compilats**, en primer lloc un programa anomenat compilador fa la traducció completa del codi font. El resultat és el **codi objecte**, el qual encara s'ha d'enllaçar amb les biblioteques del llenguatge (**link**), obtenint al final el **codi executable**. Els llenguatges compilats proporcionen, en general, més velocitat d'execució.

Un tipus especial de llenguatges compilats són els que tenen un codi objecte intermig entre el codi font i el codi màquina. Aquests llenguatges necessiten una capa virtual que interpreti el codi intermig per executar-lo. Tot i que la velocitat no serà la mateixa que en el cas de codi objecte natiu, tenen com a avantatge que són multiplataforma, és a dir, que es poden executar un cop compilats en qualsevol sistema, ja que és aquesta capa virtual l'unica que cal instal·lar de forma específica a cada sistema. És el cas del llenguatge **java**.

A la fase de prova i depuració es verifica que el programa funciona d'acord amb les especificacions requerides i es corregeixen els errors que s'hi trobin.

A les fases d'explotació i manteniment, el programa és utilitzat pel usuaris finals i els programadors realitzen canvis, correccions i modificacions d'acord amb els requeriments dels usuaris.

### Errors d'un programa

Els errors són funcionaments anòmals o manca de funcionament absoluta del programa en determinades circumstàncies. Cal fer un procés de prova intensiu amb dades d'entrada prou diverses per detectar possibles errors i poder-los corregir.

Els errors es clasifiquen en:

- de compilació
- d'execució
- de lògica
- d'especificació

Els errors de compilació corresponen a incompliment de les regles de sintaxi del llenguatge i són generats pel compilador o intèrpret.

Els erros d'execució es produeixen quan alguna operació no es pot realitzar sobre les dades subministrades. Són més difícils de detectar, ja que es produeixen en temps d'execució i només en circumstàncies molt concretes, depenent de les dades d'entrada.

Els errors de lògica produeixen resultats no correctes. Per detectar-los cal usar un joc de dades d'entrada prou extens en realitzar les proves.

Els errors d'especificació es produeixen per deficiències de comunicació entre client i desenvolupador. El resultat és que el programa no respon a les especificacions demanades pel client i acostuma a obligar a refer gran part del programa.


## Elements d'un programa

En el codi d'un programa informàtic podem trobar diversos elements. El programa es divideix en **instruccions o sentències**, cada una de les quals realitza una acció concreta i definida. Segons el tipus de sentència, poden contenir diferents elements:

### Variables i constants

Serveixen per emmagatzemar **dades** dintre del programa.

Han de tenir un tipus (defineix el tipus de dada contindrà), un valor (la dada concreta emmagatzemada) i un identificador (el nom amb què ens referirem a la variable o constant dintre del programa).

En el cas de les constants, no es permet canviar el valor durant l'execució del programa.

### Operadors

Són connectors de dades que simbolitzen accions sobre les dades.

En funció del tipus de dades que connecten i de l'operació que representen poden ser numèrics, alfanumèrics, lògics, etc.

### Expressions

Són combinacions de dades i operadors que proporcionen un resultat.

A les expressions, els operadors s'avaluen aplicant els criteris de prioritat establerts pel llenguatge. Si tenen igual grup de prioritat, s'avaluen d'esquerra a dreta.

## Representació de programes

Una manera convenient de reprentar gràficament un algorisme o procés és el [diagrama de flux o ordinograma](https://es.wikipedia.org/wiki/Diagrama_de_flujo).

Un altre sistema per representar un algorisme és el [pseudocodi](https://ca.wikipedia.org/wiki/Pseudocodi). Consisteix en un llenguatge intermedi entre el llenguatge natural i el llenguatge de programació i permet definir l'estructura del codi i el processat de les dades sense entrar en els detalls del llenguatge de programació a utilitzar.

## Característiques del llenguatge Java

El llenguatge Java va ser creat l'any 1009 per l'empresa Sun Microsystems, la qual va ser comprada l'any 2009 per Oracle.

És un llenguatge compilat, d'alt nivell i amb sintaxi estricta. El compilador genera un codi intermig (bytecodes) que s'executa posteriorment sobre una entorn d'execució (màquina virtual). Aixó permet que sigui multiplataforma, ja que el codi compilat és el mateix per a totes les plataformes. Només cal tenir instal·lat l'entorn virtual (JRE: Java Runtime Environment) corresponent a la plataforma concreta.

Java és un llenguatge orientat a objectes. Això implica que les funcions (anomenades mètodes) del llenguatge es troben encapsulades dintre d'objectes contenidors. El paradigma de l'orientació a objectes facilita molt el disseny i la construcció d'aplicacions grans.

Es pot escriure un programa en Java amb qualsevol editor de text, tot i que un IDE (Integrated Development Environment) és convenient per disposar d'eines de compleció i evitar errors d'escriptura. Els fitxers de codi font porten l'extensió .java. el compilador genera fitxers en format bytecode amb extensió .class.

Tot programa en Java es compon d'un conjunt de classes, cadascuna de les quals acostuma a estar en un fitxer amb el mateix nom que la classe. La classe que es carrega primer quan s'executa el programa ha de contenir un mètode main().

Heus aquí un exemple d'aplicació petita en Java:

``` java
/**
 * Hola món
 * @author ProvenSoft
 */
public class HolaMon {
    public static void main(String[] args) {
        //imprimir missatge
        System.out.println("Hola món!");
    } 
}
```
El fitxer s'ha de dir *HolaMon.java*.

Els comentaris poden ser multilínia (/*  */) o unilínia (//).

La classe *HolaMon* conté un únic mètode *main*. Les claus {} encerclen blocs de codi, en aquest cas, el corresponent al mètode *main*. Conté una única instrucció, la qual usa el mètode **println** per mostrar una cadena de text ("Hola món!"). El mètode println pertany a un objecte (*out*), el qual está contingut a la classe *System*.

Per als noms s'utilitza la notació **CamelCase**:

  - Noms de classes: inicial en majúscules i majúscula la inicial de cada nova paraula.
  - Noms de mètodes i variables: inicial en minúscules i majúscula la inicial de cada nova paraula.
  - Noms de constants: tots els caràcters en majúscula i paraules separades per guions baixos.


