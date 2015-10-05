package dndMiscResources;

import java.util.Scanner;

public class MainMenu {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PlayerCharacter willow = new PlayerCharacter("Willow");
		willow.rollCoreStats(sc);
		willow.setPlayerName("Totes Amaze xD");
		willow.setAlignment("LG");
		willow.setPCClass("Sorcerer");
		willow.setRace("Human");
		
		System.out.println(willow.getName() + ": Race - " + willow.getRace() + " Class  - " + willow.getPCClass());
		System.out.println("Str: " + willow.getStrength() + " Dexterity: " + willow.getDexterity() + " etc");
	}

}
