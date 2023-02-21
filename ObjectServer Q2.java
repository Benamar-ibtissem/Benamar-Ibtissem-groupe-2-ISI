package TPReseau;
import java.io.*;
import java.net.*;
public class ObjectServer {
	
	   
		//Question2 Object

		  public static void main(String[] args) throws ClassNotFoundException {
			    try {
			      ServerSocket server = new ServerSocket(12266);

			      System.out.println("Serveur en attente");

			      while (true) {
			        Socket socket = server.accept();
			        //l@ du client
			        InetAddress clientAddress = socket.getInetAddress();
		            
		            
		            //les flux d'entree et de sortie
			        ObjectInputStream inserv = new ObjectInputStream(socket.getInputStream());
			        ObjectOutputStream tocli = new ObjectOutputStream(socket.getOutputStream());
			        
		            //lire les 2mots recus
			        String line =(String) inserv.readObject();
			        String line2 = (String)inserv.readObject();
			        
			  
		            //verifier 
			        if (line.contains(line2)) {
			        	tocli.writeObject(line + " contient " + line2);
			        } else {
			          tocli.writeObject(line + " ne contient pas " + line2);
			        }
			      
		            
			        tocli.writeObject(" message reçu du client de l@ "+ clientAddress.getHostAddress()+" est : "+line+ " et " +line2);
			      }
			    } catch (IOException e) {
			      e.printStackTrace();
			    }
			  }
			}