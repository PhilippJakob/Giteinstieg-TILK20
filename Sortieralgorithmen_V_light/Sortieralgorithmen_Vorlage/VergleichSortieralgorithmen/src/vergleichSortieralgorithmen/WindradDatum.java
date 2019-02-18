/**
 * Als Einstieg in gemessene Werte an unserem Wirdrad verwenden wir erstmal nur einen Zeitstempel und die gemessene Windgeschwindigkeit.
 * Später werden wir weitere Größen ergänzen.
 * @author Hr. Jakob 27.06.2016 angelegt
 * 2.9.2017 auf geänderte Namenskonventionen überprüft
 */


package vergleichSortieralgorithmen;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.*;
import java.util.ArrayList;
import java.util.Comparator;

public class WindradDatum
{
  LocalDateTime zeitstempel;
  int    		geschwindigkeit;

/**
 * Konstruktoren
 */
public WindradDatum(LocalDateTime pZeitstempel,int pGeschwindigkeit)
  {
    super();
    this.setZeitstempel(pZeitstempel);
    this.setGeschwindigkeit(pGeschwindigkeit);
  }

public WindradDatum()
 {
	super();
 }
/**
 *  Liest zu allen Einträge der Tabelle kwkalog Zeit und Geschwindigkeit
 */
  public static ArrayList<WindradDatum> auslesenDB(Connection pConnection)
    {
      WindradDatum lWindradDatum;
      ArrayList<WindradDatum> lWindradDaten = new ArrayList<WindradDatum>();
      Statement lBefehl;
      ResultSet lErgebnis;

      try {
      lBefehl 	= pConnection.createStatement();
      lErgebnis = lBefehl.executeQuery("SELECT zeitstempel, round(windgeschwindigkeit*100) FROM windrad10000");
      lErgebnis.first();  //Zeigt auf den ersten Datensatz in lErgebnis

      while(! lErgebnis.isAfterLast())   //Solange das Ende nicht erreicht ist....
         {
           lWindradDatum = new WindradDatum(lErgebnis.getTimestamp(1).toLocalDateTime(),lErgebnis.getInt(2));
           lWindradDaten.add(lWindradDatum);
           lErgebnis.next();
         }
         } catch (Exception ex)
              {
                System.out.println("Fehler bei der Verarbeitung + " + "n" + ex.getMessage());
              }
      return lWindradDaten;
    }


  
//-------------------------------------------------------------------------------------------
// Get/Set Methoden
//-------------------------------------------------------------------------------------------
public LocalDateTime getZeitstempel()
  {
    return zeitstempel;
  }

public LocalDateTime getzeitstempel()
{
    return zeitstempel;
}

public void setZeitstempel(LocalDateTime pZeitstempel)
  {
    this.zeitstempel = pZeitstempel;
  }


public int getGeschwindigkeit()
  {
    return geschwindigkeit;
  }

public int getgeschwindigkeit()
{
    return geschwindigkeit;
}

public void setGeschwindigkeit(int pGeschwindigkeit)
  {
    this.geschwindigkeit = pGeschwindigkeit;
  }


}
