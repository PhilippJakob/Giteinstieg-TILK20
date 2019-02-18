package vergleichSortieralgorithmen;
// Naasner 9.1.16
// wichtig vorher Treiber: java-connector in das Projekt einbinden, wenn er nicht unter JRE System Library eingetragen ist:
// DBTest2--> Properties-->Java Build Path -->Add External Jar's-->mysql-connector-java-5.1.38-bin.jar
/* Jakob 27.06 An Namenskonventionen angepasst
 *
 */
import java.sql.*;

public class DBVerbindung {
static Connection connection;

public boolean verbinden(String pHostrechner, String pDatenbank, String pBenutzer, String pPasswort){
 // erstellet Verbindung ind legt sie in der Instanzvariablen connection ab.
	try{
	 Class.forName("com.mysql.jdbc.Driver").newInstance(); // neue Instanz des Treibers holen
	 String connectionCommand = "jdbc:mysql://"+pHostrechner+":3306/"+pDatenbank+"?user="+pBenutzer+"&password="+pPasswort;
     connection = DriverManager.getConnection(connectionCommand);
     return true;

    }catch (Exception ex)
	  {				//Fehlerbehandlung
	    System.out.println("Fehler");
	    return false;
      }
}



//public static void main(String[] args) {
//	// TODO Auto-generated method stub
// DBVerbindung dbVerbindung = new DBVerbindung();
// if (dbVerbindung.verbinden("dbserver", "windkraftanlage", "dbuser", "benutzer")== false)
//	 {return;}
//     Bestellung.auslesen(2).ausgeben();
//	}

public static Connection holenConnection()
{
	return connection;
}

public void setzenConnection(Connection pConnection)
{
	connection = pConnection;
}

}
