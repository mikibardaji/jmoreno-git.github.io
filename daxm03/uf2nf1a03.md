# Biblioteques de funcions i classes

Les funcions en llenguatge Java sempre pertanyen a alguna classe. 

Podem agrupar les funcions que anem programant i que ens seran d'utilitat en futurs programes dintre de classes.

De la mateixa manera, les classes s'organitzen en paquets (*package*) i es poden reutilitzar en futurs programes.

El disseny de les classes ha de permetre el seu ús el diversos programes sense necessitat de tocar el seu codi.

Per definir a quina classe pertany la classe que estem programant cal declarar-ho amb la paraula clau **package**.

```java
package cat.proven.store.model;
public class Product {
    //...
}
```
Els paquets poden contenir subpaquets al seu interior. Es declaren separant els noms amb punts. L'estructura de paquets i subpaquets es trasllada al disc amb la mateixa estructura de directoris i subdirectoris.

Per usar la classe abans definida cal importar la seva declaració especificant el paquet on es troba.

```java
import cat.proven.store.model.Product;
```

També es poden fer importacions conjuntes de totes les classes, interface, etc. d'un paquet.

```java
import cat.proven.store.model.*;
```

## Exemples

Classe auxiliar per a entrada i sortida estàndard i classe principal per provar el seu funcionament.

```java
import java.io.PrintStream;
import java.util.Scanner;
/**
 * Auxiliar class to perform standard input and output
 * @author Jose
 */
public class IOHelper {
    public static Scanner input = new Scanner(System.in);;
    public static PrintStream output = System.out;
}
```

```java
/**
 * Test input/output with IOHelper
 * @author Jose
 */
public class IOTest {
    public static void main(String[] args) {
        IOHelper.output.print("Input your name: ");
        String name = IOHelper.input.next();
        IOHelper.output.format("You wrote that your name was %s\n", name);
        IOHelper.output.print("Input your age: ");
        int age = IOHelper.input.nextInt();
        IOHelper.output.format("You wrote that your age was %d\n", age);
    }
}
```