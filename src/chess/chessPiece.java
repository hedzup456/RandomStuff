package chess;

/**
 * @author 	Richard
 * @since	8 Jan 2016
 *
 */
public class chessPiece {
	private String piece = "";
	private int locX, locY;
	private boolean firstMove = false, isWhite;
	public static String[][] board = new String[8][8];
	/*	Black or white  | Piece (G=King)| Left or right starting pos for bishop	
	 *	WB 				| PRKBQG 		| LR 
	 */
	
	public void setPiece(String piece){
		this.piece = piece.toLowerCase();
	}
	public String getPiece(){ return piece; }
	public void setColour(String colour){
		isWhite = (colour.equalsIgnoreCase("white")) ? true:false;		
	}
	public void setColour(boolean isWhite){
		this.isWhite = isWhite;
	}
	public boolean getColourAsBoolean(){
		return isWhite;
	}
	public String getColourAsString(){
		return (isWhite) ? "white" : "black";
	}
	
	public boolean canMove(int destX, int destY, boolean attacking){
		switch (piece){
		case "Pawn":
			// Pawn can only move left/right if attacking, can only move forwards, if board is clear
			if (isWhite && attacking){	// Can move left or right one space
				return (destX-1 == locX || destX+1 == locX) && (destY == locY + 1) && !(board[destX][destY].charAt(0) == 'w');	
			} else if (attacking){	// Black and attack
				return (destX-1 == locX || destX+1 == locX) && (destY == locY - 1) && (board[destX][destY].charAt(0) == 'w');					
			} else if (isWhite && firstMove){	// First move has two possible locations
				return (destX == locX) && (destY == locY + 1 || destY == locY + 2) && (board[destX][destY].charAt(0) == '-');
			} else if (firstMove){	// Black and first move
				return (destX == locX) && (destY == locY - 1 || destY == locY - 2) && (board[destX][destY].charAt(0) == '-');
			} else if (isWhite && destY == locY + 1){	// White and just moving
				return (destX == locX) && (board[destX][destY].charAt(0) == '-');
			} else if (destY == locY - 1){	// Black and just moving
				return (destX == locX) && (board[destX][destY].charAt(0) == '-');
			} else return false;	// If nothing above is true, it's false.
		default:
			return false;
		} // End of switch
	}
}
