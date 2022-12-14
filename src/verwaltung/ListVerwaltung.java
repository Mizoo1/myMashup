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

