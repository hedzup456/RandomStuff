package dndMiscResources;

import java.util.Scanner;

public class MainMenu {

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); // Declare one scanner used by all sections
		PlayerCharacter jiminy = new PlayerCharacter("Jiminy Cricket"); // Create new PlayerCharacter with PlayerName "Jiminy Cricket"
		
		// Set several variables about the character
		jiminy.rollCoreStats(sc);
		jiminy.setName("Harry the Psychopath");
		jiminy.setAlignment("CE"); // Alignment, either in form LG/NG/CG/LN/TN/CN/LE/NE/CE or as words (i.e "Chaotic Evil")
		jiminy.setPCClass("Warrior-noob"); // Class, as a string
		jiminy.setRace("Human-poop"); // Race, as a string

		// Check retrieval works
		System.out.println(jiminy.getName() + ": Race - " + jiminy.getRace() + " Class - " + jiminy.getPCClass());
		System.out.println("Str: " + jiminy.getStrength() + " Dexterity: " + jiminy.getDexterity() + " etc");
		
		// Save to file
		FileOperations fs = new FileOperations();
		fs.writePCToFile(jiminy);
		
		// Read from file
		fs.readPCFromFile("Jiminy Cricket");
	}

}
