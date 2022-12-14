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
