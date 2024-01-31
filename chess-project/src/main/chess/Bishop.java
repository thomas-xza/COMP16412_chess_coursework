package chess;

class Bishop extends Piece{
	private PieceColour colour;
	private String symbol;

	Bishop(PieceColour pc){
		if (pc.equals(PieceColour.WHITE)){
			this.colour=PieceColour.WHITE;
			this.symbol="♗";
		}
		else if (pc.equals(PieceColour.BLACK)){
			this.colour=PieceColour.BLACK;
			this.symbol="♝";
		}
	}

	public String getSymbol(){
		return symbol;
	}
	public PieceColour getColour(){
		return colour;
	}


    //    isLegitMove needs to check that:
    //      - move is legal within rules of chess
    //      - move does not land on another piece
    //      - move is not zero


    
	@Override
	boolean isLegitMove(int i0, int j0, int i1, int j1) {

	    int move_i = Math.abs(i0 - i1);

	    int move_j = Math.abs(i0 - i1);

	    if ( (move_i + move_j != 0) &&
		 (move_i == move_j) &&
		 Board.hasPiece(i1, j1) == false
		 ) {
		
		return true;
		
	    } else {
		
		return false;
		
	    }
	    
	}
}
