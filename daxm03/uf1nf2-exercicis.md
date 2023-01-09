# Exercicis d'estructures de dades

[Enunciats dels exercicis](assets/1.2/dam-m03-exerc-estruct_dades.pdf)

## Exemples de solucions als exercicis d'arrays unidimensionals

```java
import java.util.Scanner;

/**
 * Programa que entra dos valors i crea un array amb tots els valors enters
 * compresos entre els dos valors entrats (ambdós inclosos)
 *
 * @author Jose
 */
public class Ex05 {

    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        //llegir el nombre de números a entrar
        System.out.print("Entra el primer valor: ");
        int primer = lector.nextInt();
        //llegir el valor a posar a l'array
        System.out.print("Entra el segon valor: ");
        int segon = lector.nextInt();
        if (primer < segon) {  //comprovar que els valors entrats estan ordenats
            //calcular longitud requerida per a l'array
            int longitud = segon - primer + 1;
            //declarar i instanciar array
            int[] dades = new int[longitud];
            //inicialitzar l'array amb enters entre el primer i el segon número
            for (int i = 0; i < dades.length; i++) {
                dades[i] = primer + i;
            }
            //mostrar l'array
            for (int i = 0; i < dades.length; i++) {
                System.out.format("dades[%d]=%d\n", i, dades[i]);
            }
        } else {  //informar error números no correctament ordenats
            System.out.println("El primer ha de ser menor que el segon");
        }

    }

}
```


```java
import java.util.Random;
import java.util.Scanner;

/**
 * Programa per crear un array de longitud donada, inicialitzar-lo amb dades
 * aleatòries menors que un enter donat, mostrar l'array resultant, demanar un
 * número a l'usuari i comptar i mostrar quants elements de l'array són menors
 * al número introduït.
 *
 * @author Jose
 */
public class Ex06 {

    public static void main(String[] args) {
        //número d'elements de l'array (longitud)
        final int NUM_ELEMS = 100;
        //valor màxim a generar aleatòriament
        final int MAX_VALOR = 1000;
        Scanner lector = new Scanner(System.in);
        //declarar i instanciar array
        int[] dades = new int[NUM_ELEMS];
        //omplir array amb dades aleatòries
        ompleArrayAmbNombresAleatoris(dades, MAX_VALOR);
        //imprimir l'array
        String stringArray = arrayToString(dades);
        System.out.println(stringArray);
        //llegir el valor
        System.out.print("Entra el valor: ");
        int valor = lector.nextInt();
        //comptar els que són menors que el valor introduït
        int comptadorMenors = comptarMenors(dades, valor);
        //mostrar comptador
        System.out.format("El nombre d'elements menors que %d és %d\n",
                valor, comptadorMenors);
    } //fi main()

    /**
     * omple un array amb dades aleatòries amb el valor màxim indicat
     *
     * @param arr l'array a omplir
     * @param maxim el valor màxim a generar aleatòriament
     */
    private static void ompleArrayAmbNombresAleatoris(int[] arr, int maxim) {
        Random rnd = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rnd.nextInt(maxim);
        }
    }

    /**
     * converteix array en String
     *
     * @param arr l'array a convertir
     * @return format string de l'array
     */
    private static String arrayToString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < arr.length - 1; i++) {
            sb.append(arr[i]);
            sb.append(",");
        }
        sb.append(arr[arr.length - 1]);
        sb.append("]");
        return sb.toString();
    }

    /**
     * compta els elements de 'dades' menors que 'valor'
     *
     * @param dades l'array amb els elements a comptar
     * @param valor el valor límit per comptar
     * @return el nombre d'elements menors que el valor
     */
    private static int comptarMenors(int[] dades, int valor) {
        int comptador = 0;
        for (int i = 0; i < dades.length; i++) {
            if (dades[i] < valor) {
                comptador++;
            }
        }
        return comptador;
    }

}
```
Observeu que es poden modificar els valors d'un array passat a un mètode. Tot i que el mètode rep una còpia de la referència a l'array, a través d'aquesta referència pot accedir als seus elements i modificar-los. El que no es pot es modificar la referència original a l'array (la del mètode main que s'ha passat com a argument).

### Mètodes i arrays: creació i retorn des del mètode versus pas com a paràmetre

```java
import java.util.Scanner;

/**
 * Crear array amb dades de progressió aritmètica
 * Creem l'array i l'inicialitzem amb les dades de la progressió,
 * tot dintre d'una funció, la qual retorna l'array.
 * @author José
 */
public class Ex07 {

    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        //llegir dades
        //llegir el nombre d'elements de la progressió
        System.out.print("Entra la longitud: ");
        int longitud = lector.nextInt();
        //llegir el primer element
        System.out.print("Entra el primer element: ");
        double primer = lector.nextDouble();
        //llegir la diferència
        System.out.print("Entra la diferència: ");
        double diferencia = lector.nextDouble();      
        //generar progressió aritmètica
        double [] progrArit = generarProgAritm(longitud, primer, diferencia);
        //mostrar progressió aritmètica
        imprimirProgressio(progrArit);
    }
    
    /**
     * instancia un array de la longitud especificada.
     * i l'omple amb les dades d'una progressió aritmètica
     * de valor inicial 'a0' i diferència 'dif'
     * @param longitud el nombre d'elements a generar
     * @param a0 el primer element
     * @param dif la diferència
     * @return array amb la progressió aritmètica
     */
    private static double [] generarProgAritm(int longitud, double a0, double dif) {
        double [] pa = new double[longitud];
        for (int i = 0; i < pa.length; i++) {
            pa[i] = a0 + i*dif;
        }
        return pa;
    }
    
    /**
     * imprimeix una progressió
     * @param dades la progressió a imprimir
     */
    private static void imprimirProgressio(double [] dades) {
        for (int i = 0; i < dades.length; i++) {
            System.out.format(" %.2f",dades[i]);
        }
        System.out.println("");
    }
    
}
```

```java
import java.util.Scanner;

/**
 * Crear array amb dades de progressió aritmètica
 * Passem l'array a una funció (còpia de la referència)
 * i omplir l'array amb les dades de la progressió a la funció
 * @author José
 */
public class Ex07b {

    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        //llegir dades
        //llegir el nombre d'elements de la progressió
        System.out.print("Entra la longitud: ");
        int longitud = lector.nextInt();
        //llegir el primer element
        System.out.print("Entra el primer element: ");
        double primer = lector.nextDouble();
        //llegir la diferència
        System.out.print("Entra la diferència: ");
        double diferencia = lector.nextDouble();      
        //generar progressió aritmètica
        //crear array
        double [] progrArit = new double[longitud];
        omplirProgAritm(progrArit, primer, diferencia);
        //mostrar progressió aritmètica
        imprimirProgressio(progrArit);
    }
    
    /**
     * omple un array amb les dades d'una progressió aritmètica
     * de valor inicial 'a0' i diferència 'dif'
     * @param pa array a omplir
     * @param a0 el primer element
     * @param dif la diferència
     */
    private static void omplirProgAritm(double [] pa, double a0, double dif) {
        for (int i = 0; i < pa.length; i++) {
            pa[i] = a0 + i*dif;
        }
    }
    
    /**
     * imprimeix una progressió
     * @param dades la progressió a imprimir
     */
    private static void imprimirProgressio(double [] dades) {
        for (int i = 0; i < dades.length; i++) {
            System.out.format(" %.2f",dades[i]);
        }
        System.out.println("");
    }
    
}
```
El mètode ```void omplirProgAritm(double [] pa, double a0, double dif)``` rep al paràmetre ```double [] pa``` una còpia de la referència de l'array instanciat al main ```double [] progrArit```. Amb aquesta referència pot accedir a l'array i modificar els seus elements. El que no es pot modificar és la referència original progrArit, ja que el mètode només en té una còpia (el pas de paràmetres és per valor).


## Exemples de solucions als exercicis d'arrays bidimensionals

```java
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Jose
 */
public class Matrius {

    public static void main(String[] args) {
        //declarar matriu i generar-la i inicialitzar-la amb un mètode
        int [][] matriu = generarMatriuAleatoria(3, 4);
        //   mostrar matriu en format unilínia
        System.out.println(matrixToString(matriu));
        //declarar i instanciar matriu i inicialitzar-la amb un mètode
        int [][] matriu2 = new int [3][4];
        inicialitzarMatriuAleatoria(matriu2);
        //   mostrar matriu en format unilínia
        System.out.println(matrixToString(matriu2));
        //mostrar matriu en format taula
        System.out.println(matrixToTable(matriu));
    }
    
    /**
     * declara, instancia i inicialitza amb dades aleatòries
     * una matriu amb les files i columnes especificades
     * @param files el número de files de la matriu
     * @param columnes el número de columnes de la matriu
     * @return la matriu amb les dades
     */
    public static int [][] generarMatriuAleatoria(int files, int columnes) {
        int [][] dades = new int[files][columnes];
        final int MAX_VALOR = 100;
        Random rnd = new Random();
        for (int i = 0; i < dades.length; i++) {
            for (int j = 0; j < dades[i].length; j++) {
                dades[i][j] = rnd.nextInt(MAX_VALOR);
            }
        }
        return dades;
    }
    
    /**
     * inicialitza una matriu amb dades aleatòries
     * com que el paràmetre 'dades' és una referència,
     * es pot usar per accedir als elements de la matriu 
     * i canviar els seus valors.
     * @param dades la matriu a omplir
     */
    public static void inicialitzarMatriuAleatoria(int [][] dades) {
        final int MAX_VALOR = 100;
        Random rnd = new Random();
        for (int i = 0; i < dades.length; i++) {
            for (int j = 0; j < dades[i].length; j++) {
                dades[i][j] = rnd.nextInt(MAX_VALOR);
            }
        }        
    }
    
    /**
     * genera un format String unilínia de la matriu
     * @param dades la matriu a representar
     * @return String amb la matriu en format unilínia
     */
    public static String matrixToString(int [][] dades) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < dades.length; i++) {
            sb.append(Arrays.toString(dades[i]));
            if (i<dades.length-1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * genera un format tabular per a una matriu
     * @param dades la matriu a tabular
     * @return format String tabular de la matriu
     */
    public static String matrixToTable(int [][] dades) {
        StringBuilder sb = new StringBuilder();
        //sb.append("[");
        for (int i = 0; i < dades.length; i++) {
            for (int j = 0; j < dades[i].length; j++) {
                sb.append(dades[i][j]);
                if (j<dades[i].length-1) sb.append("\t");
            }
            if (i<dades.length-1) sb.append("\n");
        }
        //sb.append("]");
        return sb.toString();
    }
 
}
```

