# Fluxos d'informació i XML

## Continguts

* Gestió del sistema de fitxers.
* Fluxos d'informació. Jerarquia de classes.
* Biblioteques de classes per a fitxers XML.

![](/images/disk_padre_usb.jpg)

[Apuns de fluxos d'informació](assets/5.1/5.1.3/dax2_m03-a513-Fluxos_informacio.pdf)

## Gestió del sistema de fitxers.

[Exemple de llistat del contingut d'un directori: DirList.java](assets/5.1/5.1.3/DirList.java)

[Exemple de llistat dels atributs d'un fitxer: FileAttributes.java](assets/5.1/5.1.3/FileAttributes.java)

Exercici proposat:
Programa que llisti els fitxers d'un diretori amb els seus atributs, segons els paràmetres entrat des del terminal.
Format d'execució:  dla -[params] [path]
on

* params pot ser '1' per llistar només noms en columna o 'a' per llistar tots els atributs possibles en una línia per a cada fitxer.
* path és la ruta al directoria a mostrar (pot ser relativa o absoluta)

## Fluxos d'informació. Jerarquia de classes.

Els programes poden enviar fluxos de dades (*streams*) o rebre'ls cap a o des de diferents orígens i destinacions. Ens centrarem bàsicament en *streams* per llegir i escriure fitxers.

Els *streams* es categoritzen en quatre grans blocs segons dues propietats:

* Direcció: entrada o sortida
* Codificació: orientats a byte o orientats a caràcter

Byte input streams ![Byte input streams](assets/5.1/5.1.3/inputstream.png)

Byte output streams ![Byte output streams](assets/5.1/5.1.3/outputstream.png)

Char input streams ![Char input streams](assets/5.1/5.1.3/reader.png)

Char output streams ![Char output streams](assets/5.1/5.1.3/writer.png)

Mètodes útils proporcionats per la classe ***InputStream***:

| mètode | descripció |
| ------ | ------ |
| public abstract int read() throws IOException     | llegeix i retorna el següent byte o -1 si ha arribat al final del fitxer    |
| public int available() throws IOException     |  retorna el nombre de bytes que queden per llegir    | 
| public void close() throws IOException     |  tanca el recurs    |
| public long skip(long n) throws IOException     | salta i descarta un nombre de bytes sense llegir i retorna el nombre realment saltat    |
| public int read(byte[] b) throws IOException     | llegeix array de bytes, retorna el nombre de bytes llegits o -1 si s'arriba al final del fitxer   |
| public byte[] readAllBytes() throws IOException     | llegeix tots els bytes restants    |
| public byte[] readANBytes(int len) throws IOException     | llegeix el nombre de bytes especificat    |
| public long transferTo(OutputStream out) throws IOException     | llegeix tots els bytes del stream i els escriu a l'especificat; retorna el nombre de bytes transferits  |

Mètodes útils proporcionats per la classe ***OutputStream***:

| mètode | descripció |
| ------ | ------ |
| public void write(int b) throws IOException     | escriu un byte   |
| public void write(byte[] b) throws IOException     | escriu un array de bytes   | 
| public void write(byte[] b, int off, int len) throws IOException     | escriu un array de bytes des de la posició 'off' amb longitud 'len'  | 
| public void flush() throws IOException     | descarrega el buffer del stream   |
| public void close()throws IOException     |  tanca el recurs    |

Mètodes útils proporcionats per la classe ***Reader***:

| mètode | descripció |
| ------ | ------ |
| public abstract int read() throws IOException     | llegeix i retorna el següent caràcter o -1 si ha arribat al final del fitxer    |
| public void close() throws IOException     |  tanca el recurs    |
| public long skip(long n) throws IOException     | salta i descasrta un nombre de bytes sense llegir i retorna el nombre realment saltat    |
| public int read(char[] b) throws IOException     | llegeix array de caràcters, retorna el nombre de caràcters llegits o -1 si s'arriba al final del fitxer   |
| public long transferTo(Writer out) throws IOException     | llegeix tots els caràcters del stream i els escriu a l'especificat; retorna el nombre de caràcters transferits  |

Mètodes útils proporcionats per la classe ***Writer***:

| mètode | descripció |
| ------ | ------ |
| public void write(int b) throws IOException     | escriu un byte   |
| public void write(byte[] b) throws IOException     | escriu un array de bytes   | 
| public void write(byte[] b, int off, int len) throws IOException     | escriu un array de bytes des de la posició 'off' amb longitud 'len'  | 
| public void flush() throws IOException     | descarrega el buffer del stream   |
| public void close()throws IOException     |  tanca el recurs    |


En primer lloc provem exemples d'escriptura i lectura senzilla de bytes i de caràcters. Més endavant provarem exemples per fer persistents dades primitives i objectes.

### Videos d'introducció a fitxers

(de Píldoras informáticas)

* [Lectura de text](https://youtu.be/etQN4EfYN7k)
* [Escriptura de text](https://youtu.be/E0H4OzW2_1Y)
* [Lectura i escriptura de text amb buffer](https://youtu.be/YCCE4sbmWrw)
* [Lectura binària](https://youtu.be/38YBRnJtQEw)
* [Escriptura binària](https://youtu.be/v6ctWhhTFrk)

### Byte output stream

```
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
/**
 * WriteBytes.java
 * Example writing bytes to a file
 * @author ProvenSoft
 */
public class WriteBytes {
	public static void main(String[] args) {
		byte [] list ={10, 15, 25, 30, 45};
		if(args.length == 1) {	 //check parameter length 
			File f = new File(args[0]);
			try{
				FileOutputStream fs = new FileOutputStream(f);
				for(int i = 0; i < list.length; i++){
					fs.write(list[i]);
				}
				fs.flush();
				fs.close();
			} catch(IOException e) {
				System.out.println("Input or output problem related to this exception:");
				e.printStackTrace();
			}
		}
		else {
			System.out.println("Usage: WriteBytes filename");
		}
	}
}
```

### Byte input stream

```
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
/**
 * ReadBytes.java
 * Example reading bytes from file
 * @author ProvenSoft
 */
public class ReadBytes {
	public static void main(String[] args) {
		if(args.length == 1) {	 //check parameter length 
			File f = new File(args[0]);
			int x=0; //byte llegit 
			try{
				FileInputStream fs = new FileInputStream(f);
				while ((x = fs.read()) != -1) { //while not end of file,  keep reading
					System.out.print(" "+(byte)x);
				}
				System.out.print("\n");
				fs.close();
			} catch(FileNotFoundException e){
				System.out.println("File not found. Exception info:");
				e.printStackTrace();
			} catch(IOException e) {
				System.out.println("Input or output problem related to this exception:");
				e.printStackTrace();
			}
		}
		else {
			System.out.println("Usage: ReadBytes filename");
		}
	}
}
```

### Char output stream

```
import java.io.*;
/**
 * WriteChars.java
 * Example writing characters to a file
 * @author ProvenSoft
 */
public class WriteChars {
	public static void main(String[] args) {
		char [] list = {'a', 'e', 'i', 'o', 'u'};
		if(args.length == 1) {	//check parameter length 
			try{
				FileWriter fs = new FileWriter(args[0]);
				//BufferedWriter fs = new BufferedWriter(new FileWriter(args[0]));
				for(int i = 0; i < list.length; i++){
					fs.write(list[i]);
				}
				fs.close();
			} catch(IOException e) {
				System.out.println("Input or output problem related to this exception:");
				e.printStackTrace();
			}
		}
		else {
			System.out.println("Usage: WriteChars filename");
		}
	}
}
```

### Char input stream

```
/**
 * ReadChars.java
 * Example reading characters from file
 * @author ProvenSoft
 */
public class ReadChars {
	public static void main(String[] args) {
		int c; //character read
		if(args.length == 1) {	//check parameter length
			try{
				FileReader fs = new FileReader(arg[0]);
				//BufferedReader fs = new BufferedReader(new FileReader(args[0]));
				while ((c=fs.read()) != -1) {
					System.out.print((char)c);
				}
				System.out.print("\n");
				fs.close();
			} catch (FileNotFoundException e){
				System.out.println ("File not found. Exception info:");
				e.printStackTrace();
			} catch(IOException e) {
				System.out.println("Input or output problem related to this exception:");
				e.printStackTrace();
			}
		}
		else {
			System.out.println("Usage: ReadChars filename");
		}
	}
}
```

### Seriació de tipus primitius

Utilitzem les classes [***DataInputStream***](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/io/DataInputStream.html) i [***DataOutStream***](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/io/DataOutputStream.html), les quals proveeixen mètodes per a la persistència de cada tipus primitiu.

La classe *DataInputStream* implementa l'interface [***DataInput***](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/io/DataInput.html), la qual defineix els següents mètodes:

```java
boolean readBoolean()
byte readByte()
char readChar()
double readDouble()
float readFloat()
void readFully(byte[] b)
void readFully(byte[] b, int off, int len)
int readInt()
String readLine()
long readLong()
short readShort()
int readUnsignedByte()
int readUnsignedShort()
String readUTF()
int skipBytes(int n)
```

La classe *DataOutputStream* implementa l'interface [***DataOutput***](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/io/DataOutput.html), la qual defineix els següents mètodes:

```java
void write(byte[] b)
void write(byte[] b, int off, int len)
void write(int b)
void writeBoolean(boolean v)
void writeByte(int v)
void writeBytes(String s)
void writeChar(int v)
void writeChars(String s)
void writeDouble(double v)
void writeFloat(float v)
void writeInt(int v)
void writeLong(long v)
void writeShort(int v)
void writeUTF(String s)
```

El següent exemple il·lustra com escriure i llegir dades primitives en fitxer. Per llegir, es pot usar el mètode ***available()*** per estimar el nombre de bytes restants per llegir al fitxer i saber si s'ha de continuar llegint dades. Tot i això, cal capturar l'exepció ***EOFException***, la qual es llança en arribar al final del fitxer per si malgrat quedar bytes per llegir, no siguin suficients per a la lectura del tipus de dada que hem demanat.

```
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Example of using DataInputStream and DataOutputStream.
 *
 * @author Jose
 */
public class DataStreamExample {

    public static void main(String[] args) {
        // write information to file.
        writeInfo();
        // read information from file.
        readAndShowInfo();
        // write array to file
        writeList();
        // read array from file
        readAndShowList();
    }

    private static void writeInfo() {
        int age = 30;
        double salary = 1000.0;
        String name = "Peter";
        System.out.println("Writing to file ...");
        try {
            DataOutputStream dos = new DataOutputStream(
                    new FileOutputStream("myData.txt")
            );
            // do some stuff with the file.
            dos.writeInt(age);
            dos.writeDouble(salary);
            dos.writeUTF(name);
            // close the file.
            dos.flush();
            dos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readAndShowInfo() {
        System.out.println("Reading from file ...");
        try {
            DataInputStream dis = new DataInputStream(
                    new FileInputStream("myData.txt")
            );
            // read data from file.
            int age = dis.readInt();
            double salary = dis.readDouble();
            String name = dis.readUTF();
            // show data to console.
            System.out.format("age=%d\n", age);
            System.out.format("salary=%f\n", salary);
            System.out.format("name=%s\n", name);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeList() {
        //generate test data
        List<Double> data = Stream
                .of(1.0, 2.0, 3.0, 4.0, 5.0)
                .toList();
        //write data
        try (DataOutputStream dos = new DataOutputStream(
                    new FileOutputStream("myData2.txt"))) {
            for (int i = 0; i < data.size(); i++) {
                dos.writeDouble(data.get(i));
            }            
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void readAndShowList() {
        List<Double> data = new ArrayList<>();
        //read data
        try (DataInputStream dis = new DataInputStream(
                new FileInputStream("myData2.txt"))) {
            while (dis.available() > 0) {                
                double d = dis.readDouble();
                data.add(d);
            }
        } catch (EOFException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //display read data
        for (Double elem : data) {
            System.out.println(elem);
        }
    }

}
```

### Seriació d'objectes

La **seriació** (*serialization*) és el procés d'escriure un objecte a un stream de bytes. És útil quan es vol fer persistent l'estat d'un programa a un fitxer per exemple. El procés invers s'anomena **deseriació** (*deserialization*).

Només els objectes que implementen l'interfície [***Serializable***](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/io/Serializable.html) poden ser desats i restaurats usant la serialització. Si una classe és serialitzable, totes les seves subclasses també ho són.

Nota: les variables ***transient*** i ***static*** no es guarden durant la serialització.
Usarem les **interfícies** ***ObjectOutput*** i ***ObjectInput***, i les **classes** ***ObjectOutputStream*** i ***ObjectInputStream***, que les implementen.

Nota: les interfícies *ObjectOutput* i *ObjectInput* estenen respectivament *DataOutput* i *DataInput*, per la qual cosa hereten tots els seus mètodes.

![](assets/5.1/5.1.3/object-serialization.png)

La interfície [***ObjectOutput***](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/io/ObjectOutput.html) extén les interfícies ***DataOutput*** i ***AutoCloseable*** i suporta serialització. Defineix els mètodes ***close()***, ***flush()***, ***write()*** i ***writeObject()***. Aquest últim s'invoca per serialitzar un objecte. Tots els mètodes llancen ***IOException*** si es produeix un error.

La interfície [***ObjectInput***](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/io/ObjectInput.html) extén les interfícies ***DataInput*** i ***AutoCloseable*** i suporta serialització. Defineix els mètodes ***close()***, ***available()***, ***read()*** i ***readObject()***. Aquest últim s'invoca per llegir un objecte serialitzat. Tots els mètodes llancen ***IOException*** si es produeix un error. El mètode ***readObject()*** pot llançar també l'excepció ***ClassNotFoundException***.

La classe [***ObjectOutputStream***](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/io/ObjectOutputStream.html) extén ***OutputStream*** i implementa la interfície ***ObjectOutput***. El seu constructor és: ***ObjectOutputStream(OutputStream outStream) throws IOException***
La classe [***ObjectInputStream***](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/io/ObjectInputStream.html) extén ***InputStream*** i implementa la interfície ***ObjectInput***. El seu constructor és: ***ObjectInputStream(InputStream inStream) throws IOException***.

Consulteu la documentació online de Java per a la llista de mètodes que implementen les dues classes anteriors.

[Exemple de seriació d'objectes a fitxer en binari](assets/5.1/5.1.3/exampleobjectstream.zip)

## Biblioteques de classes per a fitxers XML.

Per treballar amb fitxers en format [XML](https://en.wikipedia.org/wiki/XML), Java proporciona dues biblioteques:

* **SAX (Simple API for XML)**
* **DOM (Document Object Model)**

### SAX

[Manual de SAX](assets/5.1/5.1.3_xml/Simple_API_for_XML.pdf)

[Exemple de SAX parser sense i amb validació](assets/5.1/5.1.3_xml/sax_xml_parser.rar)

[Exemple de lectura XML i conversió a objectes: el banc](assets/5.1/5.1.3_xml/SaxParserBankAccount.zip)

### DOM

No el treballarem en aquest mòdul.
