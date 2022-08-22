# Àmbit, visibilitat i extensió de variables

## Pas de paràmetres a mètodes

El pas de paràmetres als mètodes es fa mitjançant el **pas per valor**. Els valors que s’utilitzen en la invocació al mètode s’anomenen **arguments**, mentre que els que utilitza el mètode són els **paràmetres** (també anomenats paràmetres formals). Java fa una còpia dels arguments en els paràmetres formals. 

_El comportament en la invocació és diferent segons que el paràmetre tingui un tipus primitiu o referenciat_. En el cas que els tipus del paràmetre sigui un tipus de dades **primitiu**, es passa una còpia del valor de l’argument. En canvi, si el tipus del paràmetre és un tipus de dades **referenciat**, el que es passa és una còpia d’una referència a l’objecte (apuntador).

Per il·lustrar aquesta qüestió, editem el programa PassTest.java i analitzem-ne la sortida.

```
/**
 * Classe PassTest: Comprovació que el pas de paràmetres és per valor
 */
public class PassTest {
	float ptValue;
	//Métodes per canviar els valors actuals
	public void changeInt(int value) {
		value = 55;
	}
	public void changeStr(String value) {
		value = new String("diferent");
	}
	public void changeObjValue(PassTest ref) {
		ref.ptValue = 99.0f;
	}
	public void changeObjValue2(PassTest ref) {
		PassTest ptTemp = new PassTest();
		ptTemp.ptValue = 34;
		ref = ptTemp;
	}
	public static void main (String args []) {
		String str;
		int val;
		//Crea una instància de la classe
		PassTest pt = new PassTest();
		//Assigna un enter
		val = 11;
		//intenta canviar-lo
		pt.changeInt(val);
		//Mostra valor actual
		System.out.println("El valor de val es: "+val);
		//Assigna cadena de text
		str = new String("Hola");
		//intenta canviar-la
		pt.changeStr(str);
		//Mostra valor actual
		System.out.println("El valor de str es: "+ str);
		//Prova de canvi del valor de String
		str = new String("Adéu"); 
		System.out.println("El valor de str es: "+ str);
		//Assigna valor a ptValue
		pt.ptValue = 101.01f;
		//canvar el valor, a travès del punter a objecte
		pt.changeObjValue(pt);
		//Mostra valor actual
		System.out.println("El valor de pt.ptValue es: "+ pt.ptValue);
		//Assigna valor a ptValue
		pt.ptValue = 101.01f;
		//s'intenta canviar el valor, reassignant el punter a objecte
		pt.changeObjValue2(pt);
		//Mostra valor actual
		//Es comprova que el valor no ha canviat, perquè no permet canviar
		//el valor del punter a l'objecte
		System.out.println("El valor de pt.ptValue es: "+ pt.ptValue);
	}// Fi main()
}//Fi class        
```
El mètode *main()* crea un tipus primitiu (*int val*), un tipus referenciat (*String str*) i una instància de la pròpia classe (*PassTest pt = new PassTest()*) per utilitzar-la com a mitjà per accedir a l’atribut *float ptValue*.

La sortida del programa és la següent:

  El valor de val es: 11
  El valor de str es: Hola
  El valor de str es: Adéu
  El valor de pt.ptValue es: 99.0
  El valor de pt.ptValue es: 101.01

Com veieu, val no es modifica amb *pt.changeInt(val)* perquè el mètode només pot accedir i modificar la còpia local del paràmetre (*value*).

Malgrat ser una referència, *str* tampoc no es modifica amb *pt.changeStr(str)* perquè el que fa el mètode és canviar la referència (posició a on apunta) la còpia local del paràmetre value. En canvi, sí que es modifica des del main quan es canvia directament.

A través de la invocació pt.changeObjValue(pt) es modifica l’atribut ptValue perquè el paràmetre és una referència a l’objecte. 

En canvi, quan fem la crida *pt.changeObjValue2(pt)*, l’atribut *ptValue* no es modifica perquè el mètode crea un nou objecte local *ptTemp* i després l’assigna al paràmetre. Amb això el que es fa és fer apuntar la còpia local del paràmetre *ref* al nou objecte local, però la referència original de la invocació no es veu afectada.

## Àmbit d'una variable

L'ambit de definició d'una variable és la part del codi des d'on la variable és accessible i pot ser utilitzada en una expressió a través de l'identificador amb què ha estat declarada.

L'àmbit de les variables va des del punt en què són declarades fins al final del bloc que les conté (el bloc ve delimitat pels símbols {}).

Els blocs interns de codi tenen accés a els variables dels blocs que els contenen, llevat que es tracti de mètodes.

Totes les variables declarades dintre de mètodes són locals als mètodes. Els paràmetres dels mètodes també són locals. Per tant, no es poden utilitzar fora del mètode.

Els atributs d'un objecte declarats publics poden ser accedits des de fora del bloc de la classe, sempre usant la variable de l'objecte com a referència. 

# Visibilitat d'una variable

La visibilitat d'una declaració de variable és la part del codi on la variable té àmbit i l'identificador referencia la variable. 

La visibilitat acostuma a coincidir amb l'àmbit, però hi ha casos en què una declaració en un bloc intern usant el mateix identificador fa invisible la declaració feta al bloc exterior. En aquest cas, preval la declaració interna, i l'externa perd visibilitat al bloc intern, tot i que es manté l'ambit.

# Extensió o temps de vida d'una variable

L'extensió d'una variable fa referència a la part de codi on la variable té assignat emmagtzemament en memòria. 

Les variables locals als mètodes i els seus paràmetres es creen en entrar al mètode i es destrueixen en sortir-ne. Per tant, la seva extensió és el cos del mètode.

Els atributs dels objectes tenen extensió mentre el té l'objecte i la perden quan l'objecte és destruït.