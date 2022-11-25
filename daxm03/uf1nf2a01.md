# Cadenes alfanumèriques i conversions de format

## Cadenes de caràcters (String)

[Apunts de Strings en Java](assets/1.2/Strings_in_Java.pdf)

[Classe String](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/String.html)

[Classe StringBuilder](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/StringBuilder.html)

[Apunts d'Expresions regulars en Java](assets/1.2/Expressions_regulars_en_Java.pdf)

```java
Scanner lector = new Scanner(System.in);
//declarar i instanciar String (són objectes, cal invocar el constructor)
String nom = new String("Lluis");
//instanciació i inicialització abreujada amb constant
String salutacio = "Hola";
//ús de l'operador de concatenació
String missatge = salutacio + " " + nom;
System.out.println(missatge);
//obtenir la longitud del string
System.out.println("La longitud del missatge és "+missatge.length());
//obtenir el caràcter en una posició
System.out.print("Quin índex? ");
int index = lector.nextInt();
try {
    char c = missatge.charAt(index);  //pot llançar StringIndexOutOfBoundsException si l'índex està fora de límits
    System.out.println("El caràcter a la posició "+index+" és "+ c);
} catch (StringIndexOutOfBoundsException e) {
    System.out.println("Índex incorrecte");
}
//comparar strings (negatiu, zero o positiu segons el resultat de la comparació)
int comp = "Hola".compareTo("Holo");
System.out.println(comp);
//ús del mètode concat() per concatenar String
System.out.println(salutacio.concat(nom));
//mètodes per analitzar el contingut
String frase = "En un lugar de la Mancha de cuyo nombre no quiero acordarme";
System.out.println("Comença per En? "+ frase.startsWith("En"));
System.out.println("Acaba per rme? "+ frase.endsWith("rme"));
//igualtat de strings
String a = "Taula";
String b = "taula";
System.out.println("Son iguals? "+ a.equals(b));
System.out.println("Son iguals (ignorant case)? "+ a.equalsIgnoreCase(b));
//ús del mètode format() per obtenir un string amb dades formatades
int edat = 22;
double salari = 1800.0;
String informacio = 
        String.format("%s tens %d anys i salari %.2f\n", 
                nom, edat, salari);
System.out.println(informacio);
//trobar la posició d'un caràcter o string (indexOf(), lastIndexOf)())
System.out.println("La primera 'u' és a l'índex: "+frase.indexOf('u'));
System.out.println("La darrera 'u' és a l'índex: "+frase.lastIndexOf('u'));
System.out.println("La primera 'de' és a l'índex: "+frase.indexOf("de"));
//ús del mètode replace()
System.out.println(frase.replace('e', '3'));
//extracció de fragments del string (mètodes substring())
System.out.println(frase.substring(4, 20));
//conversió a majusc/minusc
System.out.println(frase.toUpperCase());
System.out.println(frase.toLowerCase());
```

### Proposta d'exercici: El xifrat per desplaçament (xifrat Cèsar)

El xifrat utilitzat per Juli Cèsar per comunicar-se sense que els missatges puguessin ser llegits per l'enemic aplicava l'algorisme de xifrat per desplaçament.

Consulteu el seu funcionament [aquí](https://es.wikipedia.org/wiki/Cifrado_C%C3%A9sar).

Codifiqueu un programa que demani a l'usuari un missatge (String) i un desplaçament (enter), codifiqui el missatge, el mostri codificat, després el decodifiqui i el mostri decodificat.

Haurà de contenir dos mètodes: un per codificar i un altre per decodificar.

```java
/**
 * xifra el missatge amb l'algorisme de desplaçament
 * @param missatge el missatge a xifrar
 * @param desp el desplaçament a aplicar
 * @return el missatge xifrat
 */
public static String xifrarCesar(String missatge, int desp) {
    String result="";
    //TODO
    return result;
}

/**
 * desxifra el missatge amb l'algorisme de desplaçament
 * @param missatge el missatge a desxifrar
 * @param desp el desplaçament a aplicar
 * @return el missatge desxifrat
 */    
public static String desxifrarMissatge(String missatge, int desp) {
    String result="";
    //TODO
    return result;        
}
```

## Dates i temps

Convé utilitzar les classes del paquet **java.time**, les quals estan basades en el calendari ISO, el qual segueix les regles del calendari Gregorià introduit l'any 1582.

```java
//get current data
LocalDate today = LocalDate.now();
System.out.println(today);
//output: 2022-11-05
```

```java
//get current time
LocalTime now = LocalTime.now();
System.out.println(now);
//output: 18:35:38.330782700
```

```java
//obtenir la data i l'hora actuals
LocalDateTime todayNow = LocalDateTime.now();
System.out.println(todayNow);
//output: 2022-11-05T18:35:38.330782700
//use a formatter to convert into string with specific format
DateTimeFormatter dtFormat1 = DateTimeFormatter.ofPattern("EEEE yyyy/MMMM/dd, hh:mm:ss");
System.out.println(todayNow.format(dtFormat1));
//output: sábado 2022/noviembre/05, 06:35:38
```

```java
//get current date and time with time zone
ZonedDateTime todayNowHere = ZonedDateTime.now();
DateTimeFormatter dtFormat2 = DateTimeFormatter
      .ofLocalizedDateTime(FormatStyle.FULL)  //format
      .withLocale(Locale.forLanguageTag("ca-ES"));  //locale
System.out.println(todayNowHere.format(dtFormat2));
//output: dissabte, 5 de novembre de 2022, a les 18:35:38 (Hora estàndard del Centre d’Europa)
//especify format with language tag
DateTimeFormatter dtFormat3 = DateTimeFormatter.ofPattern("EEEE yyyy/MMMM/dd, hh:mm:ss")
        .withLocale(Locale.forLanguageTag("ca-ES"));
System.out.println(todayNowHere.format(dtFormat3));
//output: dissabte 2022/de novembre/05, 06:35:38
//especify format with DateTimeFormatter constants
System.out.println(todayNowHere.format(DateTimeFormatter.ISO_DATE_TIME));
//output: 2022-11-05T18:35:38.363622+01:00[Europe/Madrid]
```

```java
//determine is a year is leap year
int year = 2024, month=3, day=5;
LocalDate date = LocalDate.of(year, month, day);
System.out.format("Is %d leap year?: %s ", date.getYear(), date.isLeapYear()?"yes":"no");
```
