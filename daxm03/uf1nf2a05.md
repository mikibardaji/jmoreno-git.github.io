# Estructura de la memòria de programa

Els tipus d'emmagatzematge de dades pot ser:
* Estàtic
* Automàtic
* Dinàmic

L'**emmagatazematge estàtic** es produeix a l'inici de l'execució del programa. El temps de vida de les dades estàtiques s'extén al llarg de tota l'execució del programa.

L'**emmagatzematge automàtic** el fa el compilador a mesura que gestiona la pila d'invocacions als diferents mètodes del programa. Cada vegada que s'entra en un mètode, es copien a la pila (*stack*) els arguments o paràmetres de la invocació i a continuació es fa el mateix amb les variables locals del mètode. Quan se surt del mètode (retorn), aquestes variables desapareixen i la pila queda igual que abans de la invocació.

L'**emmagatzematge dinàmic** es produeix segons les intruccions del programador. Els tipus de dades referencials (objectes) es declaren de forma automàtica, però en instanciar-los (amb l'operador *new*) es reserva memòria per a ells de manera dinàmica a una zona de memòria anomenada monticle (*heap*). Quan no es necessita més aquesta variable, el reciclador de memòria elimina de manera dinàmica la memòria reservada al *heap*, la qual cosa pot provocar espais buits de memòria en aquesta zona.

![java_references_explained](https://user-images.githubusercontent.com/36074660/207143743-9f913bed-2f76-4252-bf79-2c1fc4096805.png)

L'*stack* i el *heap* compareixen un mateix segment de memòria. Mentre que l'stack creix cap avall, el heap ho fa cap amunt.

![memory_stack](https://user-images.githubusercontent.com/36074660/207142668-af3af744-a575-4fdc-9ee0-a9b738ee5fa5.png)
![function_stack](https://user-images.githubusercontent.com/36074660/207143288-f19c0073-4606-4657-b86a-80f171bde05b.png)
![stack_versus_heap](https://user-images.githubusercontent.com/36074660/207143384-cc0c8926-2858-4729-bb78-6b5086bb7bd9.png)
