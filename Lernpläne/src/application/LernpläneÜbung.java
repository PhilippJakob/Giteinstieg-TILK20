/*
 * erstellt: Jakob 20.9.18    Für die erste Klassenarbeit im LK TI
 *                            Inhalt: Jeder erstellt sich einen Lernplan zu den
 *                                    aktuellen TI Themen. 
 */
package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LernpläneÜbung extends Application
{
    private Stage      grundStage;
    private AnchorPane grundPane;

    @Override
   public void start(Stage pPrimaryStage) throws IOException
   {
      Scene lScene;
      FXMLLoader lLoader = new FXMLLoader();

      grundStage = pPrimaryStage;

      lLoader.setLocation(LernpläneÜbung.class.getResource("LerneinsatzView.fxml"));
      grundPane = lLoader.load();

      lScene = new Scene(grundPane);
      grundStage.setScene(lScene);
      grundStage.show();
   }

   public static void main(String[] args) 
   {
      launch(args);
   }
}
