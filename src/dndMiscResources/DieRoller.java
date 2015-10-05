package dndMiscResources;

import java.util.Random;
import java.util.Scanner;

public class DieRoller {
	private static int rollDie(int sides){
		Random random = new Random();
		return random.nextInt(sides)+1;
	} // roolDie
	
	public int rollACoreStat(){
		int[] rolls = {rollDie(6), rollDie(6), rollDie(6), rollDie(6)};
		int smallest, smallestIndex = 100, total = 0;
		smallest = Integer.MAX_VALUE;
		for (int i = 0; i < 4; i++){
			if(rolls[i] < smallest){
				smallest = rolls[i];
				smallestIndex = i;
			} // if
		}
		
		for(int i = 0; i < 4; i++){
			if(i != smallestIndex) total += rolls[i];
		}
		return total;
	} // roll a core stat
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a die to roll in the form (number)D(sides): ");
		String dieCode = sc.nextLine();
		while(!dieCode.equals("quit")){ // Loop forever until given quit code
			if (dieCode.length() > 0){
				int dieSides, dieNum;
				String[] dieCodeSplit = dieCode.toUpperCase().split("D");
				dieNum = Integer.parseInt(dieCodeSplit[0]);
				dieSides = Integer.parseInt(dieCodeSplit[1]);
				
				if ((dieNum > 1 || dieSides > 1)){	
					int total = 0;
					for(; dieNum > 0; dieNum--){
						int r = rollDie(dieSides);
						total += r;
						
						if (dieNum != 1) System.out.print(r + " + ");
						else System.out.print(r);
						
					} // For
					System.out.println();
					System.out.println(dieCode + ": " + total);
				} // Megaif
			} //Gigaif
			else System.out.println("You failed.");
			System.out.print("Enter a die to roll in the form (number)D(sides): ");
			dieCode = sc.nextLine();			
		} // While
		sc.close();		
	} // Main
} // DieRoller
