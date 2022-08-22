# Funcions i procediments

L'ús de subalgorismes o subprogrames permet dividir problemes complexos en problemes més petits que es poden tratar millor de manera separada i que permet fer proves unitàries del seu funcionament amb independència de la resta del codi.

Han de tenir una interfície clara amb la resta del codi, és a dir, tenen un únic punt d'entrada, un únic punt de sortida, reben dades d'entrada preferiblement només com a paràmetres i poden retornar un valor.

El codi extern invoca les funcions i procediments utilitzant el seu nom (identificador) i passant-li els arguments d'entrada en forma de llista de paràmetres entre parèntesis.

Quan són invocats, s'executa el codi del seu cos. Un cop finalitzat, el control es retorna a la instrucció següent a la de la seva invocació.

En funció del retorn, alguns llenguatges els classifiquen en:

  - Funcions
  - Procediments

D'ara endavant en direm **mètodes** als dos tipus de subprogrames.

## Funcions

Retornen un valor i poden usar-se en expressions, ja que avaluen al valor retornat.

Exemple: funció que calcula i retorna el valor promig de tres valors.
```
//[tipus de retorn] [identificador] (paràmetres [tipus identificador])
float mitjana(float x, float y, float z) {
    //cos (body) de la funció
    float suma = x + y +z;
    return suma/3.0;  //instrucció de retorn amb el valor a retornar.
}
```

Per invocar aquest mètode des del programa principal:
```
// amb valors constants
float resultat1 = mitjana(2.0, 3.0, 5.0);
//amb valors provinents de variables o constants prèviament definides
float a = 2.0;
float b = 3.0;
float c = 5.0;
float resultat 2 = mitjana(a, b, c);
```

## Procediments

S'utilizen com les funcions però no es poden usar en expressions ja que no retornen cap valor.

## Pas de paràmetres

Els mètodes treballen amb els **paràmetres** com si fossin variables locals. Els valors passats a aquests paràmetres en el moment de la invocació es diuen **arguments**.

La correspondència entre paràmetres i arguments es pot establir de dues maneres:

  - Correspondència posicional: s'estableix tenint en compte l'ordre d'escriptura de paràmetres i arguments.
  - Correspondència per nom: en la invocació d'indica el nom del paràmetre i el seu valor (argument).

El sistema més extès en la majoria de llenguatge és el posicional.

Hi ha també diversos mètodes d'associació entre paràmetres i arguments:

  - **Pas per valor**: El valor de l'argument es copia directament al paràmetre (recordeu que els paràmetres funcionen com variables locals del mètode). El mètode no té, doncs, accés als arguments originals del subprograma invocant, sinó només a una còpia dels mateixos. Això implica que el mètode no pot modificar els valor de les variables usades com a arguments. Es diu que són **paràmetres d'entrada**, ja que només faciliten informació al mètode.
  - **Pas per referència**: Els paràmetres reben com a valor, no el valor dels arguments, sinó referències a les variables originals (una referència és un apuntador que permet accedir a la ubicació de la variable en memòria). Dintre del mètode, s'utilizen en general de la mateixa manera (pot dependre del llenguatge de programació), però cal tenir present que ara els canvis en els valor dels paràmetres afecten a les variables del programa principal usades com a arguments. En aquest cas, es diu que són **paràmetres d'entrara i sortida**.
