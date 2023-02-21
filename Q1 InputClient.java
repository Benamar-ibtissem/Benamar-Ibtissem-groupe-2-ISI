package TPReseau;
import java.io.*;
import java.io.Serializable;
import java.net.*;
public class InputClient {
	
	
		public static void main(String[] args) 
		{
	//Question1
		try { 
			// socket de communication avec le serveur
			Socket soc = new Socket("localhost", 30362); 
			// pour lire depuis le clavier
			 BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
			// pour recevoir du serveur
			 PrintWriter toserv = new PrintWriter(soc.getOutputStream()); 
			//pour envoyer au serveur
			 BufferedReader inserv = new BufferedReader(new InputStreamReader(soc.getInputStream()));
			 
			 //demander au client d'envoyer 2mots
			  System.out.print("Entrer le 1er mot: ");
		        String mot = scan.readLine();
		        System.out.print("Entrer le 2eme mot: ");
		        String mot2 = scan.readLine();
		        
		      //envoyer au serveur les 2 mot lus  
		        toserv.println(mot);
		        toserv.println(mot2);
		        toserv.flush();
		        toserv.flush();
		       //recevoir la reponse du serveur
		       String rep = inserv.readLine();
		       String rep2 = inserv.readLine();
			    System.out.println("Réponse du serveur : " + rep);
			    System.out.println(rep2);
		       
		       //affichage d'info sur le client
		       System.out.println(" mon adresse client"+soc.getLocalAddress()+"."+soc.getLocalPort());
		       System.out.println(" mon serveur est:"+soc.getInetAddress()+"."+soc.getPort());
		       soc.close();}
		       catch (Exception e) {
		       System.err.println("Erreur: "+e);}}}