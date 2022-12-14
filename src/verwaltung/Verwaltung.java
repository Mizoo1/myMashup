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