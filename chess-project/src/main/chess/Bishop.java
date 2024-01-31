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
    //      - move is not zero
    //      - move does not land on piece of same player
    
    //    Note that some code may be reusable across piece types - put
    //    methods in Piece.java?

    
    @Override
    boolean isLegitMove(int i0, int j0, int i1, int j1) {

	int move_i = Math.abs(i0 - i1);

	int move_j = Math.abs(i0 - i1);

	boolean legal_for_piece_type = false;

	boolean target_exists = Board.hasPiece(i1, j1);

	boolean target_exists_opponent = false;

	//  Set variable if moving into opponent's piece.

	if (target_exists == true &&
	    (this.getColour() !=
	     Board.getPiece(i1,j1).getColour() ) ) {

	    target_exists_opponent = true;

	}

	//  Set variable if move legal for this piece type.

	if (move_i == move_j &&
	    move_i != 0 &&
	    move_j != 0) {

	    legal_for_piece_type = true;

	}

	//  Make deductions based on facts available, return result.

	if ( legal_for_piece_type == true &&
	     (target_exists == false ||
	      target_exists_opponent == true) ) {
		
	    return true;
		
	} else {
		
	    return false;
		     
	}
	    
	
    }
}
