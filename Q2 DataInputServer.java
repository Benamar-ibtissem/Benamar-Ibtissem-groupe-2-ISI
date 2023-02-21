package TPReseau;
import java.io.*;
import java.net.*;
public class DataInputServer {
	
	//Question2 DataInput
	

		  public static void main(String[] args) {
		    try {
		      ServerSocket server = new ServerSocket(1323);

		      System.out.println("Serveur en attente");

		      while (true) {
		        Socket socket = server.accept();
		        InetAddress clientAddress = socket.getInetAddress();
		        DataInputStream inserv = new DataInputStream(socket.getInputStream());
		        DataOutputStream tocli = new DataOutputStream(socket.getOutputStream());
		        
	            //lire les 2mots recus
		        String line = inserv.readUTF();
		        String line2 = inserv.readUTF();
		      
		  
	            //verifier 
		        if (line.contains(line2)) {
		        	tocli.writeUTF(line + " contient " + line2);
		        } else {
		          tocli.writeUTF(line + " ne contient pas " + line2);
		        }
		        tocli.writeUTF(" message reçu du client de l@ "+ clientAddress.getHostAddress()+" etait : "+line+ " et " +line2);
	            //fermer
		        socket.close();
		      }
		    } catch (IOException e) {
		      e.printStackTrace();
		    }
		  }
		}