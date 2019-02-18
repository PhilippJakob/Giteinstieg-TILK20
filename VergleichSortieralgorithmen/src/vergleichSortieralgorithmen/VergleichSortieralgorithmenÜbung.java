/**
 * @author Hr. Jakob 27.06.2016 angelegt
 * 2.9.2017 auf geänderte Namenskonventionen überprüft
 *
 * In dieser Übung soll die Geschwindigkeit von Sortieralgorithmen verglichen werden.
 * Die gleichen Daten aus einer Datenbank sollen in zwei unterschiedliche Datenstrukturen: Linked List und Arraylist gelesen werden.
 * Auf diesen beiden Datenstrukturen sollen unterschiedliche selbstprogrammierte Sortieralgorithmen eingesetzt werden.
 */
package vergleichSortieralgorithmen;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import java.io.IOException;
import java.util.ArrayList;

public class VergleichSortieralgorithmenÜbung extends Application {

    private Stage grundStage;
    private AnchorPane grundPane;

    @Override
    public void start(Stage pPrimaryStage) throws IOException
    {
        this.grundStage = pPrimaryStage;
        FXMLLoader lLoader = new FXMLLoader();
        lLoader.setLocation(VergleichSortieralgorithmenÜbung.class.getResource("VergleichSortieralgorithmenView.fxml"));
        grundPane = lLoader.load();

        VergleichSortieralgorithmenController lSortieralgorithmenController = lLoader.getController();
        lSortieralgorithmenController.setzenApplication(this);

        Scene lScene = new Scene(grundPane);
        grundStage.setScene(lScene);
        grundStage.show();
    }

    public static void main(String[] args)
      {

       launch(args);

      }
}
