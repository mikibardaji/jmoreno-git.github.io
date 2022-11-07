# Estructures unidimensionals

[Arrays en Java](https://www.geeksforgeeks.org/arrays-in-java/)

[Ús de la classe java.util.Arrays](https://www.geeksforgeeks.org/array-class-in-java/)

## Arrays en Java

Un *array* és un grup de variables del mateix tipus referides amb un nom comú.

Són objectes, és a dir, són de tipus referencial. Això implica que s'emmagatzemen de forma dinàmica i cal instanciar-los. Els elements de l'array s'emmagatzemen en memòria de forma consecutiva.

Com a objectes, tenen atributs i mètodes.

La seva longitud es pot llegir del seu atribut ***length***.

L'accés als seus elements es fa de manera directa utilitzant l'índex de la posició.

Un array pot contenir dades de qualsevol tipus primitiu o referencial, incloent-hi altres arrays.

### Declaració d'arrays

La declaració d'un array declara l'identificador i el tipus d'element que conté.

```java
type ident[];
type [] ident;
```

Exemples
```java
int intArray[];
int [] intArray[]:
float [] floatArray;
String [] stringArray;
```
La declaració no reserva espai en memòria per als elements de l'array. Com que l'array és un objecte, cal instanciar-lo definint a la vegada el nombre d'elements a emmagatzemar.

### Instanciació d'arrays

```java
ident = new type[size];
```

Exemples:
```java
int [] intArray; //declaració
intArray = new int[10];  //instanciació de l'array de 10 elements int.
```

Es pot combinar la declaració i la instanciació:
```java
int [] intArray = new int[10];
```
### Definició abreujada d'arrays amb constants

Es pot declara, instanciar i inicialitzar els elements d'un array amb la següent notació abreujada:

```java
int [] intArray = {10, 20, 30, 40, 50};  //array de 5 elements int
```

### Accés als elements d'un array

L'accés als elements d'un array es fa de manera indexada amb els operadors []. Cal tenir en compte que el primer element té índex 0 i el darrer length-1.

```java
int [] intArray = {10, 20, 30, 40, 50};  //array de 5 elements int
int valor = intArray[3];  //accés a l'element amb índex 3
System.out.prinln(valor);  //mostra 40
intArray[2]=31;   //canvia el valor de l'element amb índex 2 (el 30 ara és 31)
```

Podem utilitzar un bucle per recórrer els elements de l'array
```java
for (int i=0; i<intArray.length; i++) {
   System.out.println("Element amb índex "+i+": "+intArray[i]);
}
```

### ArrayIndexOutOfBounds

Quan s'intenta accedir a un elements fora de l'array, es genera l'excepció ArrayIndexOutOfBounds.

```java
int intArray = new int[5];
//...
intArray[7]   //llança excepció
```

### Arrays d'objectes

Quan els elements de l'array són objectes, la intanciació de l'array només crea espai per a les referències als objectes. 

Abans de llegir un element, cal instanciar l'objecte que conté.

```java
String [] names = new String[3];  //declaració de l'array de 5 elements String, els quals encara no s'ha creat (són nuls)
System.out.println(names[0]);  //NullPointerException
```

```java
String [] names = {"John", "Martha", "Louis"};   //declara, instancia i inicialitza
System.out.println(names[0]);  //mostra "John"
```

```java
String [] names = new String[3];  //declaració de l'array de 5 elements String, els quals encara no s'ha creat (són nuls)
names[0] = "John";  //instancia i inicialitza String i copia referència la primera posició de l'array
names[1] = "Martha";
names[2] = "Louis";
System.out.println(names[1]);  //mostra "Martha"
```

La sintaxi general per a qualsevol tipus d'objecte (substituir String pel nom de la classe):

```java
String [] names = new String[3];  //declaració de l'array de 5 elements String, els quals encara no s'ha creat (són nuls)
names[0] = new String("John");
names[2] = new String("Martha");
names[2] = new String("Louis");
```

També podem assignar a un element un objecte prèviament construit:

```java
String name = "Peter";  //o String name = new String("Peter");
names[1] = name;
```
