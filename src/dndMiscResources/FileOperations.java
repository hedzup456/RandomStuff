package dndMiscResources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileOperations {
	
	public void writePCToFile(PlayerCharacter pc){
		String fileName = ".\\src\\dndMiscResources\\Characters\\" + pc.getPlayerName() + ".ser";
		try{
			FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(pc);
			oos.close();
		} catch (FileNotFoundException ex){
			ex.printStackTrace();
		} catch (IOException ex){
			ex.printStackTrace();
		}
	}
	
	public boolean pcExists(String playerName){
		String path = ".\\src\\dndMiscResources\\Characters\\" + playerName + ".ser";
		File fileToCheck = new File(path);
		return fileToCheck.exists();
	}
	
	public PlayerCharacter readPCFromFile(String playerName){
		String fileName = ".\\src\\dndMiscResources\\Characters\\" + playerName + ".ser";
		PlayerCharacter toRet = new PlayerCharacter();
		try{
			FileInputStream fis = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(fis);
			PlayerCharacter ret = (PlayerCharacter) ois.readObject();
			ois.close();
			
			System.out.println(ret.getName() + " " + ret.getPlayerName());
			toRet = ret;
		} catch (FileNotFoundException ex){
			ex.printStackTrace();
		} catch (IOException ex){
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		return toRet;
	}
}
