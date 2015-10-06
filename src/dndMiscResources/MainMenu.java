package dndMiscResources;

import java.util.Scanner;

public class MainMenu {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); // Declare one scanner used by all sections
		PlayerCharacter jiminy = new PlayerCharacter("Jiminy Cricket"); // Create new PlayerCharacter with PlayerName "Jiminy Cricket"
		
		// Set several variables about the character
		jiminy.rollCoreStats(sc);
		jiminy.setPlayerName("Harry the Fucking Psychopath");
		jiminy.setAlignment("CE");
		jiminy.setPCClass("Warrior-noob");
		jiminy.setRace("Human-poop");
		
		// Check retrieval works
		System.out.println(jiminy.getName() + ": Race - " + jiminy.getRace() + " Class - " + jiminy.getPCClass());
		System.out.println("Str: " + jiminy.getStrength() + " Dexterity: " + jiminy.getDexterity() + " etc");
	}

}
