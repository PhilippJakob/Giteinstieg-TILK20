/**
 * Controller für den Vergleich von drei unterschiedlichen Sortieralgorithmen auf zwei unterschiedlichen Listen.
 * @author Hr. Jakob 27.06.2016 angelegt
 * überprüft 2.9.2017 auf geänderte Namenskonventionen
 */

package vergleichSortieralgorithmen;

import javafx.application.Application;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ResourceBundle;
import java.lang.Integer;

public class VergleichSortieralgorithmenController
{
    public VergleichSortieralgorithmenÜbung aktuelleApplication;

    private static DBVerbindung         dbVerbindung = 		  new DBVerbindung();
   public ObservableList<WindradDatum> windradDatenOL = FXCollections.observableArrayList();
    private WindradDaten             windradDaten 	        = new WindradDaten(windradDatenOL)		;
    private ArrayList<WindradDatum>  windradDatenALSortiert = new ArrayList<WindradDatum>();
  
   
    @FXML
    public TextField tfAnzahlEintraege;
    
   
    @FXML
    private Label lbAnzahlEintraegeDB;

    @FXML
    private Label lbLaufzeitBubbleSortAL;
    
    @FXML
    private Label lbLaufzeitMergeSortLL;
    
    @FXML
    private Label lbLaufzeitQuickSortLL;
    
    @FXML
    private Label lbLaufzeitBubbleSortLL;

    @FXML
    private Label lbLaufzeitQuickSortAL;

    @FXML
    private Label lbLaufzeitMergeSortAL;

    @FXML
    private Button btBubbleSort;

    @FXML
    private Button btQuickSort;

    @FXML
    private Button btMergeSort;

    @FXML
    private TableColumn<WindradDatum,LocalDateTime>	tcZeitstempel;

    @FXML
    private TableColumn<WindradDatum,Integer>	   	tcGeschwindigkeit;

    @FXML
    private TableView<WindradDatum> 				tvWindDaten;

    @FXML
    void sortierenBubbleStyle(ActionEvent event)
      {
         // Zeitstempel davor danach -> Duration-> Laufzeitfeld setzen, Tabelle füllen

        Instant lEndZeitpunkt;
        Instant lStartZeitpunkt = Instant.now();
        // Wenn Sie Ihren Sortieralgorithmus in der Klasse WindradDaten fertig haben,
        // kommentieren Sie die bisherige nächste Zeile aus und entfernen Sie die Kommentarzeichen an der darauf folgenden.
        //windradDatenALSortiert.sort(WindradDatum.geschwindigkeitKleinerAls);
        windradDatenALSortiert = windradDaten.sortierenBubbleStyle(windradDaten.getWindradDatenAL());

        lEndZeitpunkt = Instant.now();
        //Dauer in Anzeigefeld schreiben
        lbLaufzeitBubbleSortAL.setText(String.valueOf(Duration.between( lStartZeitpunkt, lEndZeitpunkt ).toMillis()));

  
        windradDatenOL.clear();
        tvWindDaten.getItems().clear();
        windradDatenOL.addAll(windradDatenALSortiert);
        tvWindDaten.setItems(windradDatenOL);

      }
    @FXML
    void sortierenQuickStyle(ActionEvent event)
      {
    	Instant lEndZeitpunkt;
        Instant lStartZeitpunkt = Instant.now();
        // Wenn Sie Ihren Sortieralgorithmus in der Klasse WindradDaten fertig haben,
        // kommentieren Sie die bisherige nächste Zeile aus und entfernen Sie die Kommentarzeichen an der darauf folgenden.
        //windradDatenALSortiert.sort(WindradDatum.geschwindigkeitKleinerAls);
        windradDatenALSortiert = windradDaten.sortierenQuickStyle(windradDaten.getWindradDatenAL());


        lEndZeitpunkt = Instant.now();
        lbLaufzeitQuickSortAL.setText(String.valueOf(Duration.between( lStartZeitpunkt, lEndZeitpunkt ).toMillis()));
        windradDatenOL.clear();
        tvWindDaten.getItems().clear();
        windradDatenOL.addAll(windradDatenALSortiert);
        tvWindDaten.setItems(windradDatenOL);
      }
    @FXML
    void sortierenMergeStyle(ActionEvent event)
      {
    	Instant lEndZeitpunkt;
        Instant lStartZeitpunkt = Instant.now();
        // Wenn Sie Ihren Sortieralgorithmus in der Klasse WindradDaten fertig haben,
        // kommentieren Sie die bisherige nächste Zeile aus und entfernen Sie die Kommentarzeichen an der darauf folgenden.
        //windradDatenALSortiert.sort(WindradDatum.geschwindigkeitKleinerAls);
        windradDatenALSortiert = windradDaten.sortierenMergeStyle(windradDaten.getWindradDatenAL());


        lEndZeitpunkt = Instant.now();
        lbLaufzeitMergeSortAL.setText(String.valueOf(Duration.between( lStartZeitpunkt, lEndZeitpunkt ).toMillis()));
        windradDatenOL.clear();
        tvWindDaten.getItems().clear();
        windradDatenOL.addAll(windradDatenALSortiert);
        tvWindDaten.setItems(windradDatenOL);
      }

    

    
    
    @FXML
    public void initialize()
      {

  
        LinkedList<WindradDatum> lWindradDatenLL = new LinkedList<WindradDatum>();
    	if (dbVerbindung.verbinden("localhost", "db_windkraftanlage", "dbuser", "benutzer")== false)
        {return;}
        windradDaten.setWindradDatenAL(WindradDatum.auslesenDB(DBVerbindung.holenConnection()));
        // nun noch in die LL-Liste
        lWindradDatenLL.addAll(windradDaten.getWindradDatenAL());
        windradDaten.setWindradDatenLL(lWindradDatenLL);     
        
        
        windradDatenALSortiert.addAll(windradDaten.getWindradDatenAL());//wohl zu Anzeige

        lbAnzahlEintraegeDB.setText(String.valueOf( windradDaten.getWindradDatenAL().size()));
// Einschub
        windradDatenOL.clear();
        tvWindDaten.getItems().clear();
        windradDatenOL.addAll(windradDaten.getWindradDatenAL());
        tvWindDaten.setItems(windradDatenOL);
//EinschubEnde        
        tcZeitstempel.setCellValueFactory(new PropertyValueFactory<WindradDatum,LocalDateTime>("zeitstempel"));
        tcGeschwindigkeit.setCellValueFactory(new PropertyValueFactory<WindradDatum, Integer>("geschwindigkeit"));
      }

    public void setzenApplication(VergleichSortieralgorithmenÜbung pApplication)
      {
        this.aktuelleApplication = pApplication;
      }

}