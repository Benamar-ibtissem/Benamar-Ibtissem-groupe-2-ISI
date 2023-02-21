package TPReseau;
import java.io.*;
import java.net.*;
import java.util.Scanner;
public class DataInputClient {
	
	//Question2 DataInput
	
		public static void main(String[] args) throws IOException {
			
			Socket socket = new Socket("localhost", 1323);
		    Scanner scan = new Scanner(System.in);//lire
		    DataOutputStream toserv = new DataOutputStream(socket.getOutputStream());//envoyer
		    DataInputStream inserv = new DataInputStream(socket.getInputStream());//recevoir
		    
		    //lire les 2mots
		    System.out.println("Entrer le 1er mot : ");
		    String line = scan.nextLine();
		    System.out.println("Entrer le 2eme mot : ");
		    String line2 = scan.nextLine();
		    System.out.println("Les chaines envoyées sont "+line+" et "+line2);
		    
		    //les envoyer au serveur
		    toserv.writeUTF(line);
		    toserv.writeUTF(line2);
		    
		    //lire la rep du server
		    String rep = inserv.readUTF();
		    String rep2 = inserv.readUTF();
		    //affichage
		    System.out.println("mon Adresse client : " + socket.getLocalAddress() + " : " + socket.getLocalPort());
		    System.out.println("mon serveur : " + socket.getInetAddress() + " : " + socket.getPort());
		    System.out.println("Réponse du serveur : \n " + rep);
		    System.out.println(rep2);
		    //fermer
		    socket.close();
		    
		  }
		}  