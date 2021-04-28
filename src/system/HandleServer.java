package system;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import utilities.Utilitie;

public class HandleServer implements Runnable {
	private Socket clientSocket;
	private ObjectOutputStream objectOutputStream = null;
	private ObjectInputStream objectInputStream = null;
	private byte[] image; 
	
	public HandleServer(Socket clientSocket) {
		this.clientSocket = clientSocket;
		try {
        	objectOutputStream = new ObjectOutputStream(this.clientSocket.getOutputStream());
        	objectInputStream = new ObjectInputStream(this.clientSocket.getInputStream());
		} catch (IOException e) {
			Utilitie.error(HandleServer.class.getName(), e);
		}
	}

	@Override
	public void run() {
		boolean closeConnexion = false;
		while(!clientSocket.isClosed()) {
			
			 Handler<?> request = read();

             switch (request.getAction()) {
                 case success:
                	 System.out.println("Le serveur a répondu avec une erreur: "+request.getData().toString());
                     break;
                 case error:
                	 System.out.println("Le serveur a répondu avec un succès: "+request.getData().toString());
                	 break;
                 case image:
                	 image = (byte[]) request.getData();
                 default:
                     //toSend = new Handler();
                     break;
             }

             if (closeConnexion) {
                 close();
                 break;
             }
		}
	}
	
	public Handler<?> read() {
        try {
			return (Handler<?>) objectInputStream.readObject();
		} catch (ClassNotFoundException | IOException e) {
			Utilitie.error(HandleServer.class.getName(), e);
		}
        return null;
    }
	
	public void write(Handler<?> request) {
        //On envoie la commande au serveur
        try {
			objectOutputStream.writeObject(request);
			//TOUJOURS UTILISER flush() POUR ENVOYER RÉELLEMENT DES INFOS AU SERVEUR
	        objectOutputStream.flush();
		} catch (IOException e) {
			Utilitie.error(HandleServer.class.getName(), e);
		}

    }
	
	public void close() {
		System.err.println("Fermeture de la connexion au serveur ! ");
        objectOutputStream = null;
        objectInputStream = null;
        try {
			clientSocket.close();
		} catch (IOException e) {
			Utilitie.error(HandleServer.class.getName(), e);
		}
	}

	public byte[] getImage() {
		return image;
	}

}
