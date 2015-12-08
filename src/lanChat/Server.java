/**
 * 
 */
package lanChat;

import java.awt.DisplayMode;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author Richard
 *
 */
public class Server {
	private static int uniqueId;
	private ArrayList<ClientThread> al;
	private ServerGUI sg;
	private SimpleDateFormat sdf;
	private int port;
	private boolean keepGoing;
	
	public Server(int port){
		this(port, null);
	}
	public Server(int port, ServerGUI sg){
		this.sg = sg;
		this.port = port;
		sdf = new SimpleDateFormat("HH:mm:ss");
		
		al = new ArrayList<ClientThread>();
	}
	public void start(){
		keepGoing = true;
		try{
			ServerSocket serverSocket = new ServerSocket(port);
			while(keepGoing) { // Infinite loop
				display("Server waiting for clients on port " + port + ".");
				
				Socket socket = serverSocket.accept();
				if(!keepGoing) break;
				ClientThread t = new ClientThread(socket);
				al.add(t);
				t.start;
			}
			try {
				serverSocket.close();
				for(int i = 0; i < al.size(); i++){
					ClientThread tc = al.get(i);
					try{
						tc.sInput.close();
						tc.sOutput.close();
						tc.socket.close();
					} catch (IOException ioE){}
				}
			} catch(Exception e){
				display("Exception closing the server and clients: " + e);
			}
		} catch(IOException e){
			String msg = sdf.format(new Date()) + " Exception on new ServerSocket: " + e + "\n";
			display(msg);
		}
	}
	protected void stop(){
		keepGoing = false;
		try {
			new Socket("localhost", port);
		} catch (Exception e){}
	}
	private void display(String msg){
		String time = sdf.format(new Date()) + " " + msg;
		if(sg == null) System.out.println(time);
		else sg.appendEvent(time + "\n");
	}
	private synchronized void broadcast(String message){
		String time = sdf.format(new Date());
		String messageLf = time + " " + message + "\n";
		if(sg == null) System.out.println(messageLf);
		else sg.appendRoom(messageLf);
		for(int i = al.size(); i-- >= 0;){
			ClientThread ct = al.get(i);
			if(!ct.writeMsg(messageLf)){
				al.remove(i);
				display("Disconnect Client " + ct.username + " removed from list.");
			}
		}
	}
	synchronized void remove(int id){
		for (int i = 0; i < al.size(); i++){
			ClientThread ct = al.get(i);
			if(ct.id == id){
				al.remove(i);
				return;
			}
		}
	}
	public static void main(String[] args){
		int portNumber = 1500;
		switch (args.length){
		case 1:
			try{
				portNumber = Integer.parseInt(args[0]);
			} catch (Exception e){
				System.out.println("Invalid port number");
				System.out.println("Usage is > java Server [portnumber]");
				return;
			}
		case 0:
			break;
		default:
			System.out.println("Usage is: >java Server [portnumber]");
		}
		Server server = new Server(portNumber);
	}
}
class ClientThread extends Thread{
	Socket socket;
	ObjectInputStream sInput;
	ObjectOutputStream sOutput;
	int id;
	String username;
	Message cm;
	String date;
	
	/**
	 * 
	 */
	public ClientThread(Socket socket) {
		id = uniqueId++;
		this.socket = socket;
		
		System.out.println("Thread creating IO streams");
		try {
			sOutput = new ObjectOutputStream(socket.getOutputStream());
			sInput = new ObjectInputStream(socket.getInputStream());
			username = (String)sInput.readObject();
			display(username + " just connected");
		} catch (IOException e){
			display("Exception creating IO streams " + e);
			return;
		}
	}
}