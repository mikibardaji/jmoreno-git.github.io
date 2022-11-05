# Cadenes alfanumèriques i conversions de format

[Apunts de Strings en Java](assets/1.2/Strings_in_Java.pdf)

[Apunts d'Expresions regulars en Java](assets/1.2/Expressions_regulars_en_Java.pdf)

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
