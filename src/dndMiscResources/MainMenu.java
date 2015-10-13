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
	
	private static PlayerCharacter createPC(Scanner sc, String pName){
		PlayerCharacter newPC = new PlayerCharacter(pName);
		System.out.print("Character name: ");
		newPC.setName(sc.nextLine());
		System.out.print("Character alignment: ");
		newPC.setAlignment(sc.nextLine());
		System.out.print("Character class: ");
		newPC.setPCClass(sc.nextLine());
		System.out.print("Character race: ");
		newPC.setRace(sc.nextLine());
		
		switch(newPC.getRace()){
		case "Gnome":
			newPC.setSpeed(20);
			break;
		case "Dwarf":
			newPC.setSpeed(20);
			break;
		case "Halfling":
			newPC.setSpeed(20);
			break;
		case "Human":
			newPC.setSpeed(30);
			break;
		case "Elf":
			newPC.setSpeed(30);
			break;
		case "Half-elf":
			newPC.setSpeed(30);
			break;
		case "Half-orc":
			newPC.setSpeed(30);
			break;
		}
		newPC.rollCoreStats(sc);
		
		return newPC;
	} // createPC
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); // Declare one scanner used by all sections
		System.out.println("1. Create new player.\n2. Load existing player.\n3. I don't fucking know yet");
		int menuChoice = sc.nextInt();
		sc.nextLine();
		while(menuChoice != 3){
			// TODO impliment stuff
		}
		
		System.out.println("Enter your player name: ");
		String playerName = "John";
		PlayerCharacter jiminy = createPC(sc, playerName);
		
		// Save to file
		savePC(jiminy);
		
		PlayerCharacter dave = loadPC(playerName);
	}

}
