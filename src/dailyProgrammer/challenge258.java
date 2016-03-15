package dailyProgrammer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.util.Random;
import java.util.Scanner;

public class challenge258 {
	public static String nick = "hedzup456_bot";	// My name, but I'm  a bot
	public static String user = nick + " 0 * :" + nick;	// ain't none of y'all getting my real name 
	public static String server = "chat.freenode.net"; 
	public static int serverPort = 6667;
	public static String channel = "#reddit-dailyprogrammer";
	
	public static DataInputStream inStrm;
	public static DataOutputStream outStrm;
	public static Socket socket;
	
	public static final String PrivKey = genPK();
	
	
	public static final String eln =  "\r\n";	// IRC Endline
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		try{
			boolean connectedToChannel = false;
			System.out.println("Creating Socket");
			socket = new Socket(server, serverPort);
			inStrm = new DataInputStream(socket.getInputStream());
			outStrm = new DataOutputStream(socket.getOutputStream());
			System.out.println("Socket and data streams created.");
			
			Scanner sc = new Scanner(System.in);
			
			outStrm.writeBytes("NICK " + nick + eln);	// NICK connection
			outStrm.writeBytes("USER " + user + eln);	// USER connection message
			outStrm.writeBytes("JOIN " + channel + eln);
			
			String incoming = "";
			while ((incoming = inStrm.readLine()) != null) {	// While we get things
				//	From server
				if(incoming.contains("hedzbot")){
					parseCommand(incoming, PrivKey);
				} else if(incoming.contains("PING :")){	// Deal with PING keepalives
					incoming = incoming.substring(6);	// Ignore the "PING :" bit
					outStrm.writeBytes("PONG :" + incoming + eln);
					System.out.println("Just got pinged. Dealt with it, though");
				} else System.out.println(neaten(incoming, connectedToChannel));
				connectedToChannel = (connectedToChannel || incoming.toLowerCase().contains("end of /names list"));
			}
			//	Close stuff off, just for neatness.
			sc.close();
			socket.close();
			inStrm.close();
			outStrm.close();
		} catch (SocketException e){
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		}
	}
	private static String genPK(){
		String k =Integer.toHexString(new Random().nextInt(100000));
		if (k.length() < 6){
			k = k + (6-k.length())*'1';
		}
		System.out.println("____PRIVATE KEY____");
		System.out.println(k);
		System.out.println();
		return k;		
	}
	private static void quit(){
		try{
			outStrm.writeBytes("QUIT" + eln);
		} catch (NullPointerException e){
			// Do nothing
		} catch (IOException e){}
		try{
			socket.close();
		} catch (Exception e) {}
		try{
			inStrm.close();
		} catch (Exception e) {}
		try{
			outStrm.close();
		} catch (Exception e) {}		
	}
	private static void parseCommand(String rawCommand, String privKey){
		if (rawCommand.contains("disconnect")){
			if (rawCommand.contains(privKey)) quit();
		}
	}
	private static String neaten(String rough, boolean ctc){
		if (rough.contains("@") && ctc){	// String is likely a user if it contains '@'. Must be connected to channel if you want formatting.
			StringBuilder neat = new StringBuilder(rough.substring(1));	// Noone wants the leading colon
			neat = neat.delete(neat.indexOf("!"), neat.indexOf(" "));	// Hopefully strips out the address/hostname.
			return neat.toString();
		} else return rough;	// Might be important 
	}
}
