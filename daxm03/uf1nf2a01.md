# Cadenes alfanumèriques i conversions de format

[Apunts de Strings en Java](assets/1.2/Strings_in_Java.pdf)

[Apunts d'Expresions regulars en Java](assets/1.2/Expressions_regulars_en_Java.pdf)

## Dates i temps

Convé utilitzar les classes del paquet **java.time**, les quals estan basades en el calendari ISO, el qual segueix les regles del calendari Gragoripa introduit l'any 1582.

```java
//obtenir la data d'avui
LocalDate today = LocalDate.now();
System.out.println(today);
```

```java
//obtenir l'hora d'ara
LocalTime now = LocalTime.now();
System.out.println(now);
```

```java
//obtenir la data i l'hora actuals
LocalDateTime todayNow = LocalDateTime.now();
System.out.println(todayNow);
//usar un formatador per convertir en string en un format específic
DateTimeFormatter dtFormat1 = DateTimeFormatter.ofPattern("EEEE yyyy/MMMM/dd, hh:mm:ss");
System.out.println(todayNow.format(dtFormat1));
```

```java
//obtenir data i hora actuals amb la zona horària
ZonedDateTime todayNowHere = ZonedDateTime.now();
DateTimeFormatter dtFormat2 = DateTimeFormatter
      .ofLocalizedDateTime(FormatStyle.FULL)  //format
      .withLocale(Locale.forLanguageTag("ca-ES"));  //locale
System.out.println(todayNowHere.format(dtFormat2));
//especificar format amb l'etiqueta de l'idioma
DateTimeFormatter dtFormat3 = DateTimeFormatter.ofPattern("EEEE yyyy/MMMM/dd, hh:mm:ss")
        .withLocale(Locale.forLanguageTag("ca-ES"));
System.out.println(todayNowHere.format(dtFormat3));
//especificar format amb les constants de DateTimeFormatter
System.out.println(todayNowHere.format(DateTimeFormatter.ISO_DATE_TIME));
```
