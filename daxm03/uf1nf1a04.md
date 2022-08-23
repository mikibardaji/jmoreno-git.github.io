# Estructures condicionals

## Introducció

[Eina per fer diagrames de flux: diagrams](https://app.diagrams.net/)

Les sentències condicionals contenen instruccions que es poden executar o no en funció del valor d'una condició.

En funció del nombre de branques de codi, es poden classificar en:

* condicional simple
* condicional doble
* condicional múltiple

## Condicional simple

Només una branca de codi amb execució opcional. Si es compleix la condició, s'executa el bloc de codi, si no es compleix, no s'executa cap instrucció del condicional i el control passa a la instrucció que segueix l'estructura. 

Es un cas simplificat del condicional doble.

L'expressió de la condició pot utilitzar els operadors relacionals i lògics.

**Operadors relacionals**

>		Major que
<		Menor que
=		Igual a
≥		Major que o igual a
≤		Menor que o igual a
≠		Diferent de

**Operadores lògics**

AND (Y), OR (O), NOT (NO)

## Condicional doble

La part lògica de l'ALU (la unitat aritmètico-lògica del processador) dota l'ordinador de la capacitat de prendre decisions. Això s'implementa en llenguatge algorísmic mitjançant la contrucció **si-llavors-sinó**. La decisió s'especifica en una expressió lògica, la qual ha d'avaluar a cert (*true*) o fals (*false*).

![Representació gràfica del condicional doble](assets/1.1/diag_flux-if_else.jpg)

```
si		"condició"
llavors	"alternativa certa"
[sino	"alternativa falsa"]
[fi_si]
```
Les estructures condicionals es poden **enniuar**, es a dir, que una de les branques pot contenir una altra estructura condicionals si és necessari.

![Representació gràfica de l'enniuament de condicionals](assets/1.1/diag_flux-if_else-enniuat.jpg)

## Condicional múltiple

Quan la condició a avaluar pot prendre més de dos valors, s'utilitza el condicional múltiple.

![Representació gràfica del condicional múltiple](assets/1.1/diag_flux-switch_case.png)
