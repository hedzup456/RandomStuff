/**
 * 
 */
package cardsAgainstHumanity;

/**
 * @author Richard
 *
 */
public class PlayerHand {
	String[] hand;
	String username;
	
	// Exciting constructor
	PlayerHand (String username,String w1, String w2, String w3, String w4, String w5, String w6, String w7){
		this.username = username;
		this.hand[0] = w1;
		this.hand[1] = w2;
		this.hand[2] = w3;
		this.hand[3] = w4;
		this.hand[4] = w5;
		this.hand[5] = w6;
		this.hand[6] = w7;
	}
	// Getters and setters, although I'm cheating a bit
	// Using indexes as opposed to the proper way
	public String getCard(int index){
		return this.hand[index];
	}
	public String getUser(){
		return this.username;
	}
	public void setCard (int index,String card){
		if (this.hand[index].equals("")) this.hand[index] = card;
		else throw 
	}
}
