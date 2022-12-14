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
