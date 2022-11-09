# Taules i estructures multidimensionals

## Arrays amb dimensions fixes

Els arrays multidimensionals en Java consisteixen en arrays d'arrays, és a dir, arrays on cada element és a la seva vegada un array.

Ens centrarem en aquest apartat sobretot en arrays bidimensionals, també anomenats taules o matrius.

```java
//Two dimensional array (10x20 elements):
int[][] arr2D = new int[10][20];

//Three dimensional array (10x15x5 elements):
int[][][] arr3D = new int[10][15][5];
```

![](assets/1.2/matriu3x4.png)

El nombre d'elements emmagatzemats en un array multidimensional s'obté fent el producte de totes les seves longituds.

![](assets/1.2/n-dim_array.jpg)

L'accés als elements es fa amb els índexs de cada dimensió (en ordre). En el cas d'arrays bidimensionals podem imaginar-los com taules o matrius organitzats en files (primer índex) i columnes (segon índex).

```java
int[][] arr2D = new int[3][2];
arr2D[0][1] = 3; //element a la primera fila, segona columna.
```

Es poden inicialitzar amb la notació abreujada {}.

```java
int[][] arr2D = { {1, 2}, {3, 4}, {5, 6} };
for (int i=0; i<3; i++) {  //i recorre les files (primera dimensió)
    for (int j=0; j<2; j++) {  //j recorre les columnes (segona dimensió)
        System.out.format("arr[%d][%d]=%d", i, j, arr[i][j]);
    }
}
```

O també es poden inicialitzar en qualsevol lloc del codi instanciant un array per a l'element corresponent.

```java
int [][] arr3x2 = new int[3][2];
int [] arr1x2 = new int[2];
arr1x2[0] = 1;
arr1x2[1] = 2;
arr2D[0][0] = arr1x2;
//el mateix amb les altres files (1 i 2)
```

o també
```java
int [][] arr3x2 = new int[3][2];
int [] arr1x2 = {1, 2};
arr2D[0][0] = arr1x2;
//el mateix amb les altres files (1 i 2)
```

## Arrays amb diferents dimensions (arrays en dent de serra)

Com que cada element d'un array bidimensional és a la seva vegada un altre array, pot passar que cada array-element tingui diferent nombre d'elements, és a dir, que cada fila tingui un nombre de columnes diferent.

```java
int[][] arr_name = {
    {10, 20, 30},
    {40, 50, 60, 70, 80},
    {90, 100}
};
```

Per recórrer aquests arrays podem fer servir l'atribut length de cada element array.

```java
// declaració d'un array 2D amb 2 files
int arr[][] = new int[2][];
//declarar primera fila amb 3 elements
arr[0] = new int[3];
//declarar segona fila amb 2 elements 
arr[1] = new int[2];
//inicialitzar l'array amb valor seqüencials a cada element
int value = 0;
for (int i=0; i<arr.length; i++)
    for (int j=0; j<arr[i].length; j++) {
        arr[i][j] = value++;
    }
}
//mostrar els elements de l'array
System.out.println("Contingut de l'array");
for (int i = 0; i<arr.length; i++) {
    for (int j=0; j<arr[i].length; j++) {
        System.out.print(arr[i][j] + " ");
    }
    System.out.println();
}
```