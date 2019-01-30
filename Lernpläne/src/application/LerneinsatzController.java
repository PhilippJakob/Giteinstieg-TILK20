/*
 * erstellt: Hr. Jakob 20.9.18   Sie legen Ihren Lerneinsatz fest und erstellen so Ihren eigenen Lernplan.
 */
package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LerneinsatzController 
{

   
   
   //Eingesetzte Arbeitsstunden

   @FXML
   private Label 	 lbJavaGrundlagenStunden;

   @FXML
   private TextField tfJavaGrundlagenStunden;

   @FXML
   private Label 	 lbJavaFXGrundlagenStunden;
   
   @FXML
   private TextField tfJavaFXGrundlagenStunden;
   
   @FXML
   private Label 	 lbJavaFXSpielereienStunden;
   
   @FXML
   private TextField tfJavaFXSpielereienStunden;


   //Wichtigkeit

   @FXML
   private TextField tfJavaGrundlagenWichtigkeit;
   
   @FXML
   private TextField tfJavaFXGrundlagenWichtigkeit;

   @FXML
   private TextField tfJavaFXSpielereienWichtigkeit;
   
   
   //Motivationsförderung
   
   @FXML
   private TextField tfJavaGrundlagenMotivationsförderung;
   
   @FXML
   private TextField tfJavaFXGrundlagenMotivationsförderung;

   @FXML
   private TextField tfJavaFXSpielereienMotivationsförderung;
   
   
   //Erreichte Punkte
   @FXML
   private TextField tfJavaGrundlagenPunkte;
   
   @FXML
   private TextField tfJavaFXGrundlagenPunkte;
   
   @FXML
   private TextField tfJavaFXSpielereienPunkte;
   
   @FXML
   private TextField tfPunktesumme;
   
   //Sonstiges
   
   @FXML
   private TextField tfFehlermeldung;

   @FXML
   private Button btBerechnen;
     
   @FXML
   private TextField tfMotivsationspunkte;
   
 
   @FXML
   void berechnenLernerfolg(ActionEvent event) 
   {
	  int lJavaGrundlagenPunkte    = 0;
	  int lJavaFXGrundlagenPunkte  = 0;
	  int lJavaFXSpielereienPunkte = 0;
	  
	  if (!prüfenMotivationAusreichend())
	  {
		 tfFehlermeldung.setText("Sie muten sich zuviel zu. Verringern Sie Ihren Einsatz und planen Sie realistisch.");
	  }
	  else
	  {

		//Ergänzen Sie hier Ihre Berechnungen der erreichten Lernpunkte(Felder ganz rechts).
   	     tfPunktesumme.setText(String.valueOf(42)); //Nur zum abgucken wie Sie aus einer Zahl einen String machen.
	     tfFehlermeldung.clear();
	  }
   }

   @FXML
   private void initialize()
   {

   }
   
   
   /**
    * Diese Methode prüft, ob die Anzahl der eingesetzten Stunden mehr Motivation erfordert als vorhanden ist.
    */
   private boolean prüfenMotivationAusreichend()
   {
	  int     lAnzahlStundenGesamt     = Integer.parseInt(tfJavaGrundlagenStunden.getText())+Integer.parseInt(tfJavaFXGrundlagenStunden.getText())+Integer.parseInt(tfJavaFXSpielereienStunden.getText());

	  int     lMotivationspunkteGesamt = Integer.parseInt(tfMotivsationspunkte.getText());
	  //+..+..+ hier fehlt noch die hinzukommende Motivation
	  
	  return (lAnzahlStundenGesamt*10<=lMotivationspunkteGesamt);
	  
   }



}
