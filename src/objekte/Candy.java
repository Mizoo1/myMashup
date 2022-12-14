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
