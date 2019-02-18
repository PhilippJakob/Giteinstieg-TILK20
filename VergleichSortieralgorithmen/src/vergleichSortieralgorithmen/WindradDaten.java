/**
 * Für einen Laufzeitvergleich werden die gleichen Daten in unterschiedlichen Datenstrukturen abgelegt.
 * Wir verwenden als erstes eine ArrayList und eine LinkedList.
 * @author Hr. Jakob 27.06.2016 angelegt
 * überprüft 2.9.2017 auf geänderte Namenskonventionen
 * geändert 12.9.2017 Zwei Methodenrümpfe als Vorlagen angelegt
 */
package vergleichSortieralgorithmen;

import java.util.ArrayList;
import java.util.LinkedList;

import javafx.collections.ObservableList;

public class WindradDaten
{
    private ArrayList<WindradDatum>  windradDatenAL = new ArrayList<WindradDatum>();
    private LinkedList<WindradDatum> windradDatenLL = new LinkedList<WindradDatum>();

    /**
     * Die Windraddaten werden einmal in eine Arraylist und einmal in eine LinkedList geschrieben
     */
    WindradDaten(ObservableList<WindradDatum> pWindradDaten)
    {
        windradDatenAL.addAll(pWindradDaten);
        windradDatenLL.addAll(pWindradDaten);
    }

       
    /**
    * Sortiert die Liste mit dem Bubblesortalgorithmus - Basis ist eine ArrayList
    * @param  pUnsortierteListe
    * @return SortierteListe
    */
   public ArrayList<WindradDatum> sortierenBubbleStyle(ArrayList<WindradDatum> pUnsortierteListe)
   {
	  ArrayList<WindradDatum> lSortierteListe= new ArrayList<WindradDatum>();
	   // hier sind Sie gefragt
       return lSortierteListe;
   }
   /**
    * Sortiert die Liste mit dem Quicksortalgorithmus - Basis ist eine ArrayList
    * @param  pUnsortierteListe
    * @return SortierteListe
    */
   public ArrayList<WindradDatum> sortierenQuickStyle(ArrayList<WindradDatum> pUnsortierteListe)
   {
	   
	   ArrayList<WindradDatum> lSortierteListe = new ArrayList<WindradDatum>();
	  
       return lSortierteListe;
   }
   
   /**
    * Sortiert die Liste mit dem Mergesortalgorithmus - Basis ist eine ArrayList
    * @param  pUnsortierteListe
    * @return SortierteListe
    */
   public ArrayList<WindradDatum> sortierenMergeStyle(ArrayList<WindradDatum> pUnsortierteListe)
   {
	  
	   
	   ArrayList<WindradDatum> lSortierteListe = new ArrayList<WindradDatum>();
		  
       return lSortierteListe;
	}         
    
   /**
    * zusammenfügen gehört zu MergeSort (sortierenMergeStyle)
    * @param pLinkeListe
    * @param pRechteListe
    * @return
    */
   
  
   
   /**
    * Sortiert die Liste mit dem Bubblesortalgorithmus - Basis ist eine LinkedList
    * @param  pUnsortierteListe
    * @return SortierteListe
    */
   public LinkedList<WindradDatum> sortierenBubbleStyle(LinkedList<WindradDatum> pUnsortierteListe)
   {
      
	   LinkedList<WindradDatum> lSortierteListe = new LinkedList<WindradDatum>();
     
       return lSortierteListe;
   }

  
// Getter Setter - generiert, deshalb werden hier die Namenskonventionen nicht eingehalten.
/**
 * @return the windradDatenAL
 */
public ArrayList<WindradDatum> getWindradDatenAL() {
    return windradDatenAL;
}

/**
 * @param pWindradDatenAL the windradDatenAL to set
 */
public void setWindradDatenAL(ArrayList<WindradDatum> pWindradDatenAL) {
    windradDatenAL = pWindradDatenAL;
}

/**
 * @return the windradDatenLL
 */
public LinkedList<WindradDatum> getWindradDatenLL() {
    return windradDatenLL;
}

/**
 * @param pWindradDatenLL the windradDatenLL to set
 */
public void setWindradDatenLL(LinkedList<WindradDatum> pWindradDatenLL) {
    windradDatenLL = pWindradDatenLL;
}




}
