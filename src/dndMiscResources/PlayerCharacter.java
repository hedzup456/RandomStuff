package dndMiscResources;

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
	
	public void setName(String name){
		this.name = name;
	}
	public void setClass(String pcClass){
		this.pcClass = pcClass;
	}
	public void setAlignment(String alignment){
		this.alignment = alignment;
	}
	
}
