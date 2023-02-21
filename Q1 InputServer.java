package TPReseau;
import java.io.*;
import java.net.*;
public class InputServer {
	
	
		public static void main(String[] args) 
		{
	//Question1
		try { int port=30362;
			// serveur positionne sa socket d'écoute
			ServerSocket ss = new ServerSocket(port);
			// se met en attente de connexion de la part d'un client
			System.out.println("Serveur en attente: ");
			Socket soc = ss.accept();
			 InetAddress clientAddress = soc.getInetAddress();
			//pour envoyer au client
			PrintWriter tocli = new PrintWriter ( soc . getOutputStream ());
			//recevoir du client
	        BufferedReader reader = new BufferedReader(new InputStreamReader(soc.getInputStream()));
	        
	        //lire from client 2 chaines et les stocker dans 2 var line et line2
			String line = reader.readLine ();
			 String line2 = reader.readLine();
			 System.out.println(" message reçu du client est : "+line+ " et " +line2);
			 
			 //verifier si la 1ere contient la 2eme
			 String rep = "";
	         if (line.contains(line2)) {
	             rep = line + " contient " + line2;
	         } else {
	            rep = line + " ne contient pas " + line2;
	         }
			 // envoyer la reponse au client 
	         tocli.println(rep);
	         tocli.println(" message reçu du client de l@ "+ clientAddress.getHostAddress()+" est : "+line+ " et " +line2);
	         tocli.flush();
	         
	         //fermer les scockets
	         ss.close();
	         soc.close();
		}
		catch (Exception e) {
			System.err.println("Erreur: "+e);}}


	}	
