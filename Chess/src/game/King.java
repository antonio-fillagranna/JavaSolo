package game;

public class King extends Piece { 
	private boolean castlingDone = false; 

	public King(boolean white) 
	{ 
		super(white); 
	} 

	public boolean isCastlingDone() 
	{ 
		return this.castlingDone; 
	} 

	public void setCastlingDone(boolean castlingDone) 
	{ 
		this.castlingDone = castlingDone; 
	} 

	@Override
	public boolean canMove(Board board, Spot start, Spot end) 
	{  
		if (end.getPiece().isWhite() == this.isWhite()) { 
			return false; 
		} 

		int x = Math.abs(start.getX() - end.getX()); 
		int y = Math.abs(start.getY() - end.getY()); 
		if (x + y == 1) { 
			return true; 
		} 

		return this.isValidCastling(board, start, end); 
	} 

	private boolean isValidCastling(Board board, Spot start, Spot end) 
	{ 
		if (this.isCastlingDone()) { 
			return false; 
		} 

	} 

	public boolean isCastlingMove(Spot start, Spot end) 
	{ 
	} 
} 
