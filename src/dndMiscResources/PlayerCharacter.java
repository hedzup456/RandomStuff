package dndMiscResources;

import java.util.Scanner;

public class PlayerCharacter {
	String name, race, pcClass, alignment, playerName;
	int strength, dexterity, intelligence, constitution, wisdom, charisma, speed;
	char size;
	
	// constructors
	public PlayerCharacter(){
		name = race = pcClass = alignment = "";
		strength = dexterity = intelligence = constitution = wisdom = charisma = speed = 0;
		size = 'M';
	}
	public PlayerCharacter(String playerName){
		this.playerName = playerName;
	}
	// end constructors
	
	// Setters
	public void setName(String name){
		this.name = name;
	}
	public void setPCClass(String pcClass){
		this.pcClass = pcClass;
	}
	public void setAlignment(String alignment){
		this.alignment = alignment;
	}
	public void setStrength(int strength){
		this.strength = strength;
	}
	public void setDexterity(int dex){
		this.dexterity = dex;
	}
	public void setIntelligence(int intelligence){
		this.intelligence = intelligence;
	}
	public void setConstitution(int con){
		this.constitution = con;
	}
	public void setWisom(int wis){
		this.wisdom = wis;
	}
	public void setCharisma(int charisma){
		this.charisma = charisma;
	}
	public void setSpeed(int speed){
		this.speed = speed;
	}
	public void setSize(char size){
		this.size = size;
	}
	// end setters
	
	// getters
	public String getName(){
		return this.name;
	}
	public String getPCClass(){
		return this.pcClass;
	}
	public String getAlignment(){
		return this.alignment;
	}
	public int getStrength(){
		return this.strength;
	}
	public int getDexterity(){
		return this.dexterity;
	}
	public int getIntelligence(){
		return this.intelligence;
	}
	public int getConstitution(){
		return this.constitution;
	}
	public int getWisom(){
		return this.wisdom;
	}
	public int getCharisma(){
		return this.charisma;
	}
	public int getSpeed(){
		return this.speed;
	}
	public char getSize(){
		return this.size;
	}
	// end getters
	
	public void rollCoreStats(){
		DieRoller roller = new DieRoller();
		Scanner sc = new Scanner(System.in);
		int[] rolls = {roller.rollACoreStat(),roller.rollACoreStat(),roller.rollACoreStat(),roller.rollACoreStat(),roller.rollACoreStat(),roller.rollACoreStat()};
		
		System.out.println("Your rolls are: 1." + rolls[0] + ", 2." + rolls[1] + ", 3." + rolls[2] + ", 4." + rolls[3] + ", 5." + rolls[4] + ", and 6." + rolls[5]);
		int str, dex, intel, cons, wis, cha;
		System.out.print("Choose Strength: ");
		str = sc.nextInt();
		System.out.print("Choose Dexterity: ");
		dex = sc.nextInt();
		System.out.print("Choose Intellegence: ");
		intel = sc.nextInt();
		System.out.print("Choose Constitution: ");
		cons = sc.nextInt();
		System.out.print("Choose Wisdom: ");
		wis = sc.nextInt();
		System.out.print("Choose Charisma: ");
		cha = sc.nextInt();
		
		setCharisma(rolls[cha-1]);
		setConstitution(rolls[cons-1]);
		setDexterity(rolls[dex-1]);
		setIntelligence(rolls[intel-1]);
		setStrength(rolls[str-1]);
		setWisom(rolls[wis-1]);
		
		sc.close();
	}
}
