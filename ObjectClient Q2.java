package TPReseau;
import java.io.*;
import java.net.*;
import java.util.Scanner;
public class ObjectClient {



	//Question2 Object
	public static void main(String[] args) throws IOException, ClassNotFoundException {
			
			Socket socket = new Socket("localhost", 12266);
			
		    Scanner scan = new Scanner(System.in);//lire
		    ObjectOutputStream toserv = new ObjectOutputStream(socket.getOutputStream());//envoyer
		    ObjectInputStream inserv = new ObjectInputStream(socket.getInputStream());//recevoir
		    
		    //lire les 2mots
		    System.out.println("Entrer le 1er mot : ");
		    String line = scan.nextLine();
		    System.out.println("Entrer le 2eme mot : ");
		    String line2 = scan.nextLine();
		    System.out.println("Les chaines envoyées sont "+line+" et "+line2);
		    
		    //les envoyer au serveur
		    toserv.writeObject(line);
		    toserv.writeObject(line2);
		    
		    //lire la rep du server
		    String rep = (String) inserv.readObject();
		    String rep2 = (String) inserv.readObject();
		    //affichage
		    System.out.println("mon Adresse client : " + socket.getLocalAddress() + " : " + socket.getLocalPort());
		    System.out.println("mon serveur : " + socket.getInetAddress() + " : " + socket.getPort());
		    System.out.println("la reponse du serveur \n"+rep);
		    System.out.println(rep2);
		 
			
		  }}

