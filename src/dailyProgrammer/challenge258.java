package dailyProgrammer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class challenge258 {
	public static String nick = "hedzup456_bot";	// My name, but I'm  a bot
	public static String user = nick + " 0 * :" + nick;	// ain't none of y'all getting my real name 
	public static String server = "chat.freenode.net"; 
	public static int serverPort = 6667;
	
	public static final String eln =  "\r\n";	// IRC Endline
	
	public static void main(String[] args) {
		try{
			Socket socket = new Socket(server, serverPort);
			DataInputStream inStrm = new DataInputStream(socket.getInputStream());
			DataOutputStream outStrm = new DataOutputStream(socket.getOutputStream());
			
			Scanner sc = new Scanner(System.in);
			
			outStrm.writeBytes("NICK " + nick + eln);	// NICK connection
			outStrm.writeBytes("USER " + user + eln);	// USER connection message
			
			String incoming = "";
			while ((incoming = inStrm.readLine()) != null) {
				//	From server
				if(incoming.contains("PING :")){	// Deal with PING keepalives
					incoming = incoming.substring(6);	// Ignore the "PING :" bit
					outStrm.writeBytes("PONG :" + incoming + eln);
				} else System.out.println(incoming);
				//	To Server
				if(sc.hasNextLine()){
					outStrm.writeBytes(sc.nextLine() + eln);
				}
			}
			sc.close();
			socket.close();
			inStrm.close();
			outStrm.close();
		} catch (Exception e){
			e.printStackTrace();
		}
		

	}

}
