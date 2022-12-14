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

