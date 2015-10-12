package dndMiscResources;

import java.util.Scanner;

public class MainMenu {
	private static void savePC(PlayerCharacter pc){
		FileOperations fo = new FileOperations();
		String pN = pc.getPlayerName();
		if (fo.pcExists(pN)) fo.writePCToFile(pc);
		else{
			fo.createFile(pN);
			fo.writePCToFile(pc);
		}
	}
	
	private static PlayerCharacter loadPC(String pN) {
		FileOperations fo = new FileOperations();
		PlayerCharacter toReturn;
		if (fo.pcExists(pN)) toReturn = fo.readPCFromFile(pN);
		else{
			System.out.println("Character not found.");
			toReturn = new PlayerCharacter();
		}
		return toReturn;
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); // Declare one scanner used by all sections
		PlayerCharacter jiminy = new PlayerCharacter("Jiminy Cricket"); // Create new PlayerCharacter with PlayerName "Jiminy Cricket"
		
		// Set several variables about the character
		jiminy.rollCoreStats(sc);
		jiminy.setName("Harry the Psychopath");
		jiminy.setAlignment("CE"); // Alignment, either in form LG/NG/CG/LN/TN/CN/LE/NE/CE or as words (i.e "Chaotic Evil")
		jiminy.setPCClass("Warrior-noob"); // Class, as a string
		jiminy.setRace("Human-poop"); // Race, as a string
		
		// Save to file
		savePC(jiminy);
		
		PlayerCharacter dave = loadPC("Jiminy Cricket");
		// Check retrieval works
		System.out.println(dave.getName() + ": Race - " + dave.getRace() + " Class - " + dave.getPCClass());
		System.out.println("Str: " + dave.getStrength() + " Dexterity: " + dave.getDexterity() + " etc");
	}

}
