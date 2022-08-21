# Dades, operadors i expressions

## Dades i tipus de dades

El propòsit d'un programa és processar dades. Aquestes dades s'han d'emmagatzemar en memòria. Per accedir a les dades en memòria, els programes utilitzen el concepte de **variable**.

Una variable té un **identificador**, un **tipus** i un **valor**.

L'identificador és el nom que utilitzem al programa per distingir-la de les altres. El tipus indica el conjunt de valors vàlids que pot prendre i les transformacions que se li poden fer. El valor és el contingut emmagatzemat a la memòria.

Java té dues grans categories de tipus de dades:

- tipus primitius
- tipus referencials

Els **tipus primitius** estan incorporats dintre de la sintaxi del llenguatge de programació, i s'utilitzen per construir-ne d'altres més complexos. Les variables de tipus primitius es creen en memòria en definir-les i el seu valor és el de la dada emmagatzemada en memòria.

Els **tipus referencials** són tota la resta. Corresponen a estructures de dades més complexes i a objectes. El valor de la variable de tipus referencial no és el que està emmagatzemat en memòria, sinó una referència (un apuntador) al lloc on està emmagatzemat. Aquestes variables no s'inicialitzen en declarar-les, sinó que cal contruir els objectes amb un operador del llenguatge (***new***).

![](assets/1.1/tipos_datos_java.png)

## Operadors i expressions

Per realitzar transformacions i operacions amb les dades s'utilitzen els **operadors**.

Normalment, els operadors actuen sobre dades (**operands**) d'un mateix tipus.

Els operadors que actuen sobre un únic operand s'anomenen **unaris**. Els que actuen sobre dos operands s'anomenen **binaris**.

![](assets/1.1/java_operators.png)

Una **expressió** és una combinació qualsevol d'operadors i operands.

L'avaluació d'una expressió es realiza avaluant els parèntesis, començant pels més interns i aplicant als operadors la seva precedència.

![](assets/1.1/java_operator_precedence.png)

## Declaració de variables i constants

Tota variable ha d'estar declarada abans de ser usada dintre d'un programa.

La **declaració** consisteix en donar-li un **identificador** (el seu nom amb el qual serà coneguda dintre del programa) i un **tipus de dada**, el qual no podrà canviar durant tota la seva existència en memòria. Addicionament, es pot **inicializar** (donar-li un valor inicial).

El format de la declaració és:

```java
tipus identificador;
```

Exemples:

```java
int comptador;
char lletra;
float amplada;
double salari;
int repeticions = 4;
float area = 3.5f;
int a, b, c;
```

L'àmbit d'un identificador de variable és el context en què està declarada. Els idenficadors de variable es poden utilitzar només dintre del bloc de codi en què s'han declarat.

Si una dada no ha de ser modificada durant l'execució del programa, cal definir-la com a **constant**, utilitzant el modificador **final** a la seva definició. En aquest cas, cal inicialitzar-la en el moment de la declaració.

```java
final int NOMBRE_DE_COSTATS = 3;
```

## Conversió de tipus

La conversió de tipus consisteix en la transformació d'una dada d'un tipus a un altre.

La pot fer de forma **implícita** el propi compilador si es tracta de tipus i valor compatibles i es requereix per a l'avaluació d'una expressió.

```java
float a = 3.0;
int b = 2;
float suma = a + b;
```

També es pot expressar de forma **explícita** indicant el tipus entre parèntesis abans de la variable.

```java
int iVal = 3;
double dVal = (double) iVal;
```
