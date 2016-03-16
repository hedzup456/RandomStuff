package dailyProgrammer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

/**
 * 
 * @author 		Richard Henry (richardhenry602@gmail.com)
 * @version 	0.2
 * @since		2016-03-16
 */
public class challenge258 {
	//	User info
	private static String nick = "hedzup456_bot";	// My name, but I'm  a bot
	private static String user = nick + " 0 * :" + nick;	// ain't none of y'all getting my real name 
	//	Server Info
	private static String server = "chat.freenode.net"; 
	private static int serverPort = 6667;
	private static String channel = "#reddit-dailyprogrammer";
	
	//	Input/Output
	//	Declared now, filled later to allow multi-method access
	private static DataInputStream inStrm;
	private static DataOutputStream outStrm;
	private static Socket socket;
	
	private static final String eln =  "\r\n";	// IRC Endline. eln is easier to remember than \r\n. I guarantee I'd forget \r\n.
	
	/**
	 * Simple method to connect from to the server at the given address and port.
	 * Outputs to standard out the status of some stuff.
	 * 
	 * @param server	The server to connect to
	 * @param port		The port to connect over.
	 * 
	 * @return Boolean to say whether the method has connected.
	 */
	private static boolean connect(String server, int port){
		System.out.println("Proceeding to open a socket and data streams.");
		try{
			socket = new Socket(server, port);
			inStrm = new DataInputStream(socket.getInputStream());
			outStrm = new DataOutputStream(socket.getOutputStream());
			
			System.out.println("Sockets created.");
			return true;
		} catch (SocketException e){
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * Method to connect using nick and user data defined in global variables above.
	 * 
	 * @since 2016-03-16
	 * @return void
	 */
	private static void joinServerAndChannel(){
		try{
			outStrm.writeBytes("NICK " + nick + eln);	// NICK connection
			outStrm.writeBytes("USER " + user + eln);	// USER connection message
			outStrm.writeBytes("JOIN " + channel + eln);	// Join channel	
		} catch (IOException e){
			e.printStackTrace();
		}
	}
	/**
	 * Method to quit, disconnecting each of the streams and so on.
	 * <p>
	 * The idea behind this is that it makes disconnecting from a server much neater; call a method
	 * and that's it. None of this ugly force-killing of tasks or whatever.
	 * 
	 * @since 2016-03-16
	 * @return void
	 */
	private static void quit(){
		// Each thing is in it's own try/catch because I want to be sure each thing gets closed properly.
		// Nothing in catches - I'm not too fussed if an exception doesn't get handled at this point.
		try{	// Actually try to disconnect from any server - neatly.
			outStrm.writeBytes("QUIT" + eln);
		} catch (NullPointerException e){
		}catch (IOException e){}
		try{	// Stab it through the ears
			inStrm.close();
		} catch (Exception e) {}
		try{	// Cut out it's tongue
			outStrm.close();
		} catch (Exception e) {}
		try{	// Murder it in cold blood
			socket.close();
		} catch (Exception e) {}
	}
	/**
	 * Method to parse a command received by a user with !hedzbot
	 * <p>
	 * Method only really looks in the message for certain keywords.
	 *   
	 * @param rawCommand
	 * @return void
	 */
	private static void parseCommand(String rawCommand){
		if (rawCommand.contains("disconnect") || rawCommand.contains("quit") || rawCommand.contains("kill") || rawCommand.contains("seppuku")){
			quit();
		}
	}
	/**
	 * Method to strip out unnecessary text from messages - ultimately there should just be the username and their message.
	 * 
	 * @param rough A line of raw text from the server.
	 * @return a neatened version of the entered text.
	 */
	private static String neaten(String rough){
		try{
			if (rough.contains("@")){	// String is likely a user if it contains '@'.
				String[] parts = rough.split(" ");
				if(parts.length > 3){
					parts[0] = parts[0].substring(0, parts[0].indexOf('!'));	// Drop the hostname and other boring stuff like that
					parts[3] = parts[3].substring(1);	//	Drop the colon before the actual message
					String neat = parts[0] + ": ";
					for(int i = 3; i < parts.length; i++)	neat = neat + parts[i] + " ";	// Add the rest of the message. Because the whole point of it is to output the message.
					return neat;
				} else return rough;
			} else return rough;	// Might be important
		} catch (StringIndexOutOfBoundsException e){
			return rough;	// Something fucked up. I can't be bothered to work out what.
		}
	}
	
	@SuppressWarnings("deprecation")	//	DataInputStream readLine is depreciated. I might even fix it at some point.
	public static void main(String[] args) {
		try{
			connect(server, serverPort);	
			Scanner sc = new Scanner(System.in);
			
			joinServerAndChannel();

			String incoming = "";
			while ((incoming = inStrm.readLine()) != null) {	// While we get things
				//	From server
				if(incoming.contains("!hedzbot")){
					parseCommand(incoming);
				} else if(incoming.contains("PING :")){	// Deal with PING keepalives
					incoming = incoming.substring(6);	// Ignore the "PING :" bit
					outStrm.writeBytes("PONG :" + incoming + eln);
					System.out.println("Just got pinged. Dealt with it, though");
				} else System.out.println(neaten(incoming.substring(1)));
			}
			quit();	// Disconnect from the server.
			sc.close();
		} catch (IOException e){
			e.printStackTrace();
		}
	}
}
