# myMashup
Erzeuger_Verbraucher_Problem

**Anforderungen**

Bei diesem Programm sollen direkt nach dem Start 3 Argumente eingelesen werden.

• Anzahl der Produzenten

• Anzahl der Verbraucher

• ’sync’ Argument

Die Produzenten müssen Candy produzieren, und das produzierte auf einem Stack ablegen.

Währenddessen ziehen die Verbraucher die produzierten Candys vom Stack.

Am Ende sollen die produzierten und die verbrauchten Candys in der Konsole Ausgegeben werden.

Das Argument ’sync’ gibt an, ob der Stack synchronisiert werden soll. Ist ’sync’ größer als 0 Synchronisieren sich Verbraucher und Produzenten, sodass alle etwa gleich viel produzieren und verbrauchen.

Auf dem Stack müssen immer ’sync’-Candy-Objekte liegen.

```
1 class Candy
2 {
3 private int hell ;
4 private String hope ;
5 private int producerID ;
6 }
```
hell bezieht sich auf einer Zufallszahl zwischen -9999 und 9999.

hope bezieht sich auf einem Zufallsstring mit 20 Zeichen.

producerID bezieht sich auf den Wert der ID des Produzenten-Threads.

Wenn der Stack leer wird, beendet sich das Programm von selbst und gibt die Daten und die berechnete
Zeit an.

Wird die magische Zahl ’666’ eingegeben, stoppt das Programm und gibt die Daten und die
berechnete Zeit an.

**Vorgehensweise**

In der Main-Methode befindet sich ein Instanz von der Klasse Verwaltung, damit wird das Programm
gestartet.

Von der Klasse Verwaltung wird die Methode auswahl() aufgerufen.Das Programm befielt dem Benutzer
3 Argumente abzulesen.

• Die Anzahl der Produzenten

• Die Anzahl der Verbraucher 

• Das ’sync’ Argument

Danach werden Produzenten-Thread, Verbraucher-Thread und Magischzahl-Thread instanziert und die
Methode start() wird aufgerufen.

Die Zeit des Programms wird ab jetzt berechnet und Threads werden gestartet.

• Die Methode run() in der Produzenten Klasse überprüft in der Schleife, ob die Anzahl der Produzenten größer ist als 0, und dadurch die aktuelle Thread nicht gestört wird.
Danach die wird Candy ID erzeugt, und die Anzahl der Produzenten wird jedes mal um 1 reduziert.
In der inneren Schleife wird überprüft, ob ’sync’ gleich 0 ist, wenn das der Fall ist, wird Candy der
Liste hinzugefügt, ansonsten wird sie der Liste synchronized ergänzt.

• Die Methode run() in der Verbraucher Klasse überprüft in der äußeren Schleife, ob die aktuelle
Thread nicht gestört ist.
Die innere Schleife prüft, ob die Liste voll und die Anzahl der Verbraucher größer als 0 ist.
Wenn der ’sync’-Argument == 0 ist, werden die Candyobjekte aus der Liste gelöscht und die gelöschten Objekte werden zurückgegeben.
Wenn aber ’sync’-Argument != 0 ist, werden die Candyobjekte aus der Liste synchronized gelöscht
und die gelöschte Objekte werden zurückgegeben.
Die Anzahl der Verbraucher wird jedes mal um 1 in der Schleife reduziert.

Wird im laufe des Programms die Magische Zahl ’666’ angegeben, wird das Programm gestoppt, Daten
und verbrauchte Zeit werden ausgegeben und das Programm beendet sich.

Wenn die Anzahl der Produzenten == 0 ist, gibt das Programm die Daten und die verbrauchte Zeit
aus und beendet sich kontrolliert.

Der Prozess wird solange wiederholt, bis der Stack leer ist

![Screenshot 2022-07-12 210054](https://user-images.githubusercontent.com/57080354/207487204-72a1262f-7abc-4042-9249-56de5f2af034.jpg)
![Screenshot 2022-12-14 031013](https://user-images.githubusercontent.com/57080354/207488085-877b0c1d-ddcc-44c9-8b7b-079d35460565.jpg)

**Candy**

In der Klasse Candy befinden sich mehrere Attribute hell, hope und producerID mit verschiedenen
Methoden zur Erzeugung.
```
package objekte;

import java.util.Random;
import verwaltung.Konstante;
/**
 * Die Klasse Candy besitzt 3 Attribute hell,
 * hope und producerID.
 * hell entspricht einer 
 * Zufallszahl zwischen -9999 und 9999. 
 * hope entspricht einer Zufallstring mit 20 Zeichen. 
 * producerID gibt jedes erzeugte Candy einen ID.
 * @author Muaaz Bdear
 */
public final class Candy implements Konstante
{
    private int hell;
    private String hope;
    private int producerID;
    /**
     * Konstruktor, in dem der uebergebene Parameter dem 
     * entsprechneden Klassenattribut zugewiesen wird. 
     * @param producerID Der producerID
     */
    public  Candy(int producerID) 
    {
        this.producerID=producerID;
        /* (9999+9999=19998) erzeugt eine Zufallszahl zwischen
        -9999 und 9999*/
        this.hell= new Random().nextInt(GESAMT_HELL) + MIN_HELL;
        this.hope=randomHope();
    }
    @Override
    public String toString() 
    {
        return CANDY+"\n"+ HELL + " = " + hell + " \n"+ HOPE + " = " 
                    + hope + "\n"+ PRODUCER_ID + " = "
                    + producerID + "\n";
    }
    /**
     * Erzeugt einen Zufallsstring mit 20 Zeichnen.
     * @return Die zufaellige Zeichenfolge
     */
    private String randomHope() 
    {
        Random random= new Random();
      //StringBuilder benutzt um append() zu benutzen
        StringBuilder  builder = new StringBuilder(MAX_HOPE);
        for(int i=0 ; i<MAX_HOPE;i++ ) 
        {
            char kette;
            /* im ASCII tablle gibt andere zeichnungen
            zwischen die groesse und die kleine Buchstaben.*/
            if(random.nextInt(2)>0) 
            {
                kette = (char)(random.nextInt(ANZAHL_DER_BUCHSTABEN) + 'A');
            }else /*Die groesse und die kleine Buchtaben 
                sind verdeckt */
            {
                 kette = (char)(random.nextInt(ANZAHL_DER_BUCHSTABEN) + 'a');
            }
        builder.append(kette);
        }
        // Inhalt ausdrucken
        return builder.toString();
    }
    // getter und Setter
    public int getHell() 
    {
        return hell;
    }
    public void setHell(int hell) 
    {
        this.hell = hell;
    }
    public String getHope()
    {
        return hope;
    }
    public void setHope(String hope)
    {
        this.hope = hope;
    }
    public int getProducerID() 
    {
        return producerID;
    }	 
}

```

**Input**

In der Klasse Input befindet sich die Methode magisch(), die dazu dient den Input der Nutzer zurückzugeben.

```

package objekte;

import java.util.Scanner;
/**
 * Die klasse Input ist für die Eingabe 
 * der Magischer Zahl zuständig
 * @author Muaaz Bdear
 */
public final class Input 
{
    public int magisch()
    {
        Scanner sc= new Scanner(System.in);
        return sc.nextInt();
    }
}

```

**Produzenten**

Die Klasse Produzenten dient dazu, Candyobjekte zu produzieren und in der Liste hinzuzufügen.
```
package threads;

import objekte.Candy;
import verwaltung.ListVerwaltung;

/** Klasse, die das interface "Runnable" implementiert und
 * dient dazu, Candyobjekte zu produzieren.
 * @author Muaaz Bdear
 */
public final class Produzenten implements Runnable 
{
    private ListVerwaltung lw;
    private int sync;
    private int delay;
    private static int producerID;
    private Candy candy;
    
    /**Konstruktor der Klasse Produzenten, 
     * in dem der uebergebene Parameter dem 
     * entsprechneden Klassenattribut zugewiesen wird
     * @param lw Ist vom Typ ListVerwaltung und enthaelt
     * die Stack,auf der Objecte Produziert werden
     * @param delay Ist die Zeit, in der der Thread schlafen darf
     * @param syn sync
     */
    public Produzenten(ListVerwaltung lw,int delay,int syc) 
    {
        producerID = 0;
        this.sync=syc;
        this.delay=delay;
        this.lw = lw;
    }
    /** 
     * Die Methode erstellet einen Instanz von Candy, 
     * der die producerID als Paramenter erhaelt ,
     * dann fuegt die Candy Object in der Stack, 
     */
    @Override
    public void run() 
    {
        // Endlose Schleife
        while (lw.getAnzProduzenten() > 0 &&
                    !Thread.currentThread().isInterrupted()) 
        {
            try 
            {
                candy = new Candy(++producerID);
                
                if(sync<=0)
                {
                    lw.load(candy,0);
                }else
                {
                    lw.load(candy);
                }
                lw.anzProduzentenReduzieren();
                Thread.sleep(delay);
            } catch (InterruptedException e)
            {
                // Thread stop
                Thread.currentThread().interrupt();
            }
        } 
    }
}


```

**Verbraucher**
Die Klasse Verbraucher löscht die Elemente aus der Liste und gibt sie aus. Sobald die Anzahl der Produzenten in der Liste leer ist, beendet sich das Programm.
```
package threads;

import verwaltung.Verwaltung;
import objekte.Candy;
import verwaltung.ListVerwaltung;

/**
 * @author Muaaz Bdear
 */
public final class Verbraucher implements Runnable 
{
    private ListVerwaltung lVerwaltung;
    private int delay,syc;
    private Verwaltung verwaltung;
    private Candy candy;
    /**
     * Konstruktor, in dem der uebergebene Parameter dem 
     * entsprechneden Klassenattribut zugewiesen wird. 
     * @param lw
     * @param anzVerbraucher Die Anzahl der Verbraucher
     */
    public Verbraucher(ListVerwaltung lw,int delay,
                int syc,Verwaltung v) 
    {
        this.verwaltung=v;
        this.delay=delay;
        this.lVerwaltung = lw;
        this.syc=syc;
    }
    @Override
    public void run()
    {
        // Endlose Schleife
        while (!Thread.currentThread().isInterrupted()) 
        {
            try
            {
                // Es muss etwas exsitieren, damit etwas verbraucht wird.
                while (!lVerwaltung.isEmpty()&&lVerwaltung.getAnzVerbraucher()>0 ) 
                {
                    /*Wenn der gegebene Argument 'sync' kleiner gleich 0
                    wird die Methode withdraw() mit synchronisation aufgerufen,
                    aber wenn 'sync' groesser als 0 ist wird die Methode withdraw()
                    ohne sychronisation aufgerufen.*/
                    if(syc<=0){
                        candy = lVerwaltung.withdraw(1);
                        // Die Anzahl der Verbraucher reduzieren.
                        lVerwaltung.anzVerbraucherReduzieren();
                        // Daten werden ausgegeben.
                        System.out.println(candy.toString());                      
                    }else{
                        candy = lVerwaltung.withdraw();
                        lVerwaltung.anzVerbraucherReduzieren();
                        System.out.println(candy.toString());
                    }
                }
                // sobald die Liste leer ist, wird das Programm beendet
                if(lVerwaltung.getAnzProduzenten()==0){
                    verwaltung.beenden();
                    System.exit(0);
                }
                Thread.sleep(delay);
                
            } catch (InterruptedException e) 
            {
                Thread.currentThread().interrupt();
            }
        }
    }
}


```
**MagischZahl**
Die Klasse MagischZahl erbt von der Klasse Thread und dient dazu das Programm zu stoppen, sobald
man die Zahl ’666’ eingibt

```
package threads;

import verwaltung.Verwaltung;
import objekte.Input;
import verwaltung.Konstante;
/**
 * Die Klasse MagischZahl dient dazu, das Programm zu beenden,
 * sobald die magische Zahl '666' eingegeben wird
 * @author Muaaz Bdear
 */
public final class MagischZahl extends Thread implements Konstante
{
    private Input i = new Input();
    private Verwaltung verwaltung;
    /**
     * Konstruktor, in dem der uebergebene Parameter dem 
     * entsprechneden Klassenattribut zugewiesen wird. 
     * @param w 
     */
    public MagischZahl(Verwaltung w)
    {
        this.verwaltung= w;
    }
    public void run()
    {
        // Wenn das aktuele Thread nicht gestoert ist
        while(!Thread.currentThread().isInterrupted())
        {
            try{
                if(i.magisch()== MAGISCH){
                    verwaltung.beenden();
                }
                Thread.sleep(DEALY);
            } catch (InterruptedException e)// thread stop
            {
                Thread.currentThread().interrupt();
            }
        }
    }
}



```

**ListVerwaltung**
Die Klasse ListVerwaltung dient dazu, um Listen hinzuzufügen, zu löschen oder zu prüfen, ob die Liste
leer oder voll ist.

```
package verwaltung;

import java.util.Stack;
import objekte.Candy;
/**
 * Die Klasse ListVerwaltung ist, um die Stack 
 * zu verwalten.
 * @author Muaaz Bdear
 */
public final class ListVerwaltung 
{
    private Stack<Candy>liste;
    private int produzentenCandy;
    private int verbrauchteCandy;
    private int anzProduzenten;
    private int anzVerbraucher;

    /**
     * Konstruktor, in dem der uebergebene Parameter den Klassenattributen 
     * zugewiesen und liste als neue Stack definiert wird
     */
    public ListVerwaltung(int anzProduzenten,
                int anzVerbraucher ) 
    {
        this.liste=new Stack<Candy>();
        this.anzProduzenten=anzProduzenten;
        this.anzVerbraucher=anzVerbraucher;
    }
    /**
     * Diese Methode reduziert die
     * Anzahl der Produzierte Candy
     */
    public void anzProduzentenReduzieren()
    {
        anzProduzenten--;
    }
    /**
     * Diese Methode reduziert die 
     * Anzahl der Verbrauchten Candy
     */
    public void anzVerbraucherReduzieren()
    {
        anzVerbraucher--;
    }
    /**
     * Diese Methode erhoeht die 
     * Anzahl der Produzierte Candy
     */
    public void erhoeheProduzierteCandy()
    {
        produzentenCandy++;
    }
    /**
     * Diese Methode erhoeht die
     * Anzahl der Verbrauchten Candy
     */
    public void erhoeheVerbrauchteCandy()
    {
        verbrauchteCandy++;
    }
    /**
     * Diese Methode fuegt der Liste Elemente
     * synchronisiert hinzu
     * @param c Candy
     */
    public synchronized void load(Candy c) 
    {
        erhoeheProduzierteCandy();
        liste.add(c);
    }
    /**
     * 
     * @param c Candy
     * @param snc Das Sync Argument
     */
    public void load(Candy c,int snc) 
    {
        erhoeheProduzierteCandy();
        liste.add(c);
    }
    /**
     * Diese Methode loescht synchronisiert die CandyObject aus der Liste und 
     * gibt das CandyObject zurueck, das sie geloescht hat
     * @return Das geloeschte CandyObject
     */
    public synchronized Candy withdraw() 
    {
        erhoeheVerbrauchteCandy();
        // 0 damit der erste Argument in der liste geloescht wird.
        return liste.remove(0);
    }

    /**
     * Diese Methode loescht die CandyObject aus 
     * der Liste und gibt das CandyObject zurueck,
     * das sie geloescht hat
     * @return Das geloeschte CandyObject
     */
    public Candy withdraw(int snc) 
    {
        erhoeheVerbrauchteCandy();
        // 0 damit der erste Object in der liste geloescht wird.
        return liste.remove(0);
    }
    /**
     * Die Methode ueberprueft ob, die Liste leer ist
     * @return Boolischer Ausdruck
     */
    public boolean isEmpty()
    {
        return liste.isEmpty();
    }
    //Getter und Setter
    public int getSize()
    {
        return liste.size();
    }
    public int getProduzierteCandy() 
    {
        return produzentenCandy;
    }
    public int getVerbrauchteCandy()
    {
        return verbrauchteCandy;
    }
    public int getAnzProduzenten()
    {
        return anzProduzenten;
    }
    public int getAnzVerbraucher()
    {
        return anzVerbraucher;
    }
    public void setAnzProduzenten(int anzProduzenten)
    {
        this.anzProduzenten = anzProduzenten;
    }
    public void setAnzVerbraucher(int anzVerbraucher) 
    {
        this.anzVerbraucher = anzVerbraucher;
    }
}



```
**Verwaltung**

Die Klasse Verwaltung dient dazu, um am Anfang des Programms verschiedene Daten vom Benutzer
zu verwalten und Threads werden instanziert und gestartet.
Am Ende des Programms werden die Threads gestoppt und die Daten werden ausgegeben.


```
package verwaltung;

import threads.MagischZahl;
import threads.Produzenten;
import threads.Verbraucher;
import java.util.Scanner;
/**
 * Die Klasse Verwaltung 
 * @author Muaaz Bdear
 */
public final class Verwaltung implements Konstante
{
    private Scanner sc = new Scanner(System.in);
    private Thread t1,t2,t3;
    private int anzPro,anzVer,syn,magischerZahl;
    private long start,end;
    private ListVerwaltung lw= new ListVerwaltung(anzPro,anzVer);
    
    /** Konstruktor der klasse Verwaltung.
     * Die Methode auswahl() wird hier aufgerufen.
     */
     public Verwaltung() 
    {
      this.t3 = new MagischZahl(this);
      auswahl();  
    }
    /**
     * Diese Methode fragt den Benutzer, welche Elemente 
     * eingegeben werden sollen, und ruft die methode Start
     */
    public void auswahl()       
    {
        // 
        System.out.println(AUSWAHL);
        setAnzPro(sc.nextInt());
        lw.setAnzProduzenten(anzPro);
        setAnzVer(sc.nextInt());
        lw.setAnzVerbraucher(anzVer);
        setSyn(sc.nextInt());
        // Threads werden initialisiert
        this.t1 = new Thread(new Produzenten(lw,DEALY,getSyn()));
        this.t2 = new Thread(new Verbraucher(lw,DEALY,getSyn(),this));
        start();
    }
    /**
     * Diese Methode beendet alle Threads, und gibt 
     * die Daten und die Laufzeit aus.
     */
    public void beenden()
    {
        t1.interrupt();
        t2.interrupt();
        t3.interrupt();
        System.out.println( ENDE+VERBRAUCHTEN_CANDY
                        +getLw().getVerbrauchteCandy()
                        +PRODUZERTEN_CANDY
                        +getLw().getProduzierteCandy()
                        +CANDY_LAGER
                        +getLw().getSize());
        end=System.nanoTime();
        double laufzeit = (double) (end - start) / NANO;
        System.out.println(LAUFZEIT
                    +laufzeit+SEKUNDEN);
    }
    /**
     * Diese Methode laesst alle Threads 
     * starten und startet die berechnete Zeit 
     */
    public void start() 
    {
        start = System.nanoTime();
        t1.start();
        t2.start();
        t3.start();
    }
    //getter und setter
    public ListVerwaltung getLw()
    {
        return lw;
    }
    public int getMagischerZahl()
    {
        return magischerZahl;
    }
    public int getAnzVer() 
    {
        return anzVer;
    }
    public int getSyn() 
    {
        return syn;
    }
    public int getAnzPro()
    {
        return anzPro;
    }
    public void setSyn(int syn)
    {
        this.syn = syn;
    }  
    public void setAnzPro(int anzPro) 
    {
        this.anzPro = anzPro;
    }
    public void setAnzVer(int anzVer) 
    {
        this.anzVer = anzVer;
    }
    public void setMagischerZahl(int i)
    {
        this.magischerZahl = magischerZahl;
    }
}
```

**Konstante**

```
package verwaltung;
/**
 * @author Muaaz Bdear
 */
public interface Konstante 
{
    String AUSWAHL = """
                     Bitte geben Sie 3 Argumente in folgendes Format ein:
                     1-Anzahl der Produzenten (Enter)
                     2-Anzahl der Verbraucher (Enter)
                     3-Das sync-Argument (Enter)
                     """;
    
    String VERBRAUCHTEN_CANDY = "\nAnzahl der Verbrauchte Candys ist : ";
    
    String PRODUZERTEN_CANDY  ="\nAnzahl der produzierte Candys ist : ";
    
    String CANDY_LAGER = "\nAnzahl Candys noch im Lager ist : ";
    
    String LAUFZEIT = "\nDie Laufzeit betraegt: ";
    
    String ENDE = "Vorgang Abgeschlossen";
    
    String SEKUNDEN = " sec.";
    
    String CANDY = "Candy";
    
    String HELL = "Hell";
    
    String HOPE  = "Hope";
    
    String PRODUCER_ID = "ProducerID" ;
    
    int DEALY = 100;
    int NANO = 1000000000;
    int MAGISCH = 666;
    int MIN_HELL = -9999;
    int GESAMT_HELL = 19998;
    int MAX_HOPE = 20;
    int ANZAHL_DER_BUCHSTABEN =26;
}

```
**Main**

In der Main-Klasse wird das Programm gestartet.

```
package verwaltung;

/**
 * Main-Klasse mit der main Methode.
 * Von hier wird das Programm gestartet.
 * @author Muaaz Bdear
 */
public class Main 
{
    /**
     * In der main Methode wird ein Instanz
     * der Klasse verwaltung initialisiert und
     * mithilfe dieses Inatanzs startet das Programm
     * @param args 
     */
    public static void main(String[] args)
    {
        Verwaltung v= new Verwaltung();	
    }
}

```
