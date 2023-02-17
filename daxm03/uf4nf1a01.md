# Classes, objectes i encapsulació

## Continguts

1.  Definició de classes.
2.  Atributs o propietats.
3.  Mètodes: constructors i destructors, accessors de lectura i escriptura.
4.  Propietats i mètodes de classe i d'instància.
5.  Modificadors d'accés i visibilitat.

[Presentació Introducció a la POO: Objectes](assets/4.1/dam-m03-uf4nf1-introd_poo_objectes-presentacio.pdf)

[Presentació Introducció a la POO: classes](assets/4.1/dam-m03-uf4nf1-introd_poo_classes-presentacio.pdf)

[Apunts de classes, objectes i encapsulació](assets/4.1/dax2_m03-a412-Classes_i_encapsulacio.pdf)


## Videos d'introducció a la POO

* [Introducció a POO en Java](https://youtu.be/XmUz5WJmJVU)
* [Classes i objectes](https://youtu.be/ZY5pwm92cWQ)
* [Modularització i encapsulació](https://youtu.be/RZOSJ2zuxIs)
* [Getters i setters](https://youtu.be/7ALMZymOs_s)
* [Getters i setters: pas de paràmetres](https://youtu.be/YQinPQVpSd4)
* [Modificador static: variables i constants](https://youtu.be/QIV7FfXa-zY)
* [Modificador static: mètodes](https://youtu.be/V0wIZ-OglsY)
* [Sobrecàrrega de constructors](https://youtu.be/_ZWcobe9afw)

[Exemple de classe per representar un punt del pla](assets/4.1/Point.zip)

[Exemple de classe per representar un rectangle](assets/4.1/Rectangle.zip)

[Exemple de classe per representar una esfera](assets/4.1/Sphere.zip)

[Exemple de classe per representar un ordinador](assets/4.1/Computer.zip)

[Exemple de classe principal genèrica per a aplicacions senzilles amb menú](assets/4.1/AppTemplate.java)

## Els objectes

Un programa estarà compost per un conjunt d'objectes que interactuen entre ells, cadascun dels quals té una identitat pròpia, caracteritzada per les seves propietats (**atributs**) i el seu comportament (**mètodes**).

Un objecte ha de pertànyer a un tipus concret: la seva **classe**, i pot contenir altres objectes.

Una classe és l'especificació dels **atributs** i **mètodes** que són **membres** de la classe, els quals són compartits per tots els objectes que tenen aquesta classe. Per tant, tots els objectes d'una classe concreta tenen els mateixos atributs (tot i que amb valors, en principi, diferents) i els mateixos mètodes.

Els objectes són tipus de dades **referencials**. Això implica que la declaració només indica el tipus i el valor és una referència (apuntador a memòria) que indica la posició de l'objecte en memòria. Per inicialitzar la referència, cal crear l'objecte en memòria i assignar la referència a la seva posició en memòria a la variable de la seva declaració. Aquest procés de creació es denomina **instanciació**.

Quan un objecte deixa d'estar referenciat, és a dir, cap variable apunta a ell, és eliminat de la memòria. Aquesta operació és realitzada de forma automàtica pel reciclador de memòria (***garbage collector***) de la màquina virtual de Java.

## Les classes

La definició d'una classe té el següent format:

```java
public class LaMevaClasse {
    //atributs
    //...
    //constructors
    //...
    //accessors de lectura i escriptura
    //...
    //altres mètodes membres de la classe
    //...
}
```

El modificador ***public*** indica que la definició de la classe és visible fora del fitxer de codi font en què s'està definint. En absència d'aquest modificador, la classe només seria visible dintre del fitxer en què es troba.

A cada fitxer de codi font només hi pot haver una classe pública, el nom de la qual ha de coincidir amb el del fitxer que la conté.

A la declaració de la classe es poden utilitzar diversos **modificadors**:

* **public**: accessible arreu
* **final**: no pot tenir classes derivades (subclasses), és a dir, no es pot estendre.
* **abstract**: no se'n poden instanciar objectes, ja que és una plantilla per derivar
(estendre) altres classes.


Per instanciar un objecte, cal utilitzar l'operador **new** seguit del mètode constructor de la classe. Si no se n'ha definit cap, almenys disposarà del constructor per defecte, el qual no rep cap argument i crea un objecte sense cap inicialització.

```java
LaMevaClasse obj1 = new LaMevaClasse();
```

### Els atributs

Els atributs contenen informació (dades), i poden ser tipus primitius o altres tipus relacionals (String, arrays, objectes).

Exemples de declaració d'atributs:

```java
private int numberOfPlayers;
protected String name;
public double width;
```

Els modificadors d'accés indiquen si es pot accedir des d'altres classes a aquests atributs.

* **private**: accés restringit a la classe en què està declarat
* **protected**: accés restringit a la classe en què està declarat, a les subclasses d'aquesta i a les que pertanyen al mateix paquet (package).
* **public**: accés no restringit. És accessible des de qualsevol classe

També es pot aplicar el modificador **final**, el qual indica que l'atribut no pot ser modificat un cop inicialitzat (és una constant).

```java
private final int MAX_PLAYERS = 10;
```

Aquests atributs són diferents per a cada instància. És a dir, cada objecte creat d'aquesta classe té una còpia diferent dels atributs amb valors eventualment diferents. S'anomenen per aquest motiu **atributs d'instància**.

Es poden definir atributs de classe, dels quals només existeix una còpia en memòria per a tots els objectes de la classe. Per tant, tots els objectes d'aquesta classe tindran el mateix valor d'aquest atribut. Es declaren amb el modificador **static**.

```java
public static int NUMBER_OF_ELEMENTS;
```

Els atributs es poden inicialitzar utilitzant constructors segons convingui.

## Els mètodes

Les classes també contenen mètodes (funcions) que realitzen accions.

Els mètodes es defineixen especificant el modificador d'accés, el tipus de retorn, el nom del mètode i, finalment, entre parèntesis, la relació de paràmetres (tipus i nom) que rebrà el mètode en ser invocat.

```java
public int sum(int x, int y) {
    int r = x+y;
    return r;
}
```

```java
public void greet(String name) {
    System.out.println("hello "+name);
}
```

## Primer exemple de classe

Anem a definir una classe per representar un quadrat.

```java
public class Quadrat {
    //atribut 'costat'
    public double costat;
    //constructor per inicialitzar l'atribut
    public Quadrat(double costat) {
        this.costat = costat;
    }
    //mètode per obtenir l'àrea del quadrat
    public double area() {
        return costat*costat;
    }
}
```

