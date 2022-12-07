# Exercicis d'estructures de dades

[Enunciats dels exercicis](assets/1.2/dam-m03-exerc-estruct_dades.pdf)

## Exemples de solucions

<code java>
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
</code>
