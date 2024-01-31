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


    //  isLegitMove needs to check that:
    //    - move is legal within rules of chess
    //    - move is not zero
    //    - move does not land on piece of same player
    //    - move does not attempt to jump over another piece

    //   The last condition is the hardest to check - it requires
    //   checking the largest quantity of squares, especially for long
    //   distance pieces with multiple potential directions.
    
    //   Note that some code may be reusable across piece types - put
    //   methods in Piece.java?

    
    @Override
    boolean isLegitMove(int i0, int j0, int i1, int j1) {

	int move_i = Math.abs(i0 - i1);

	int move_j = Math.abs(j0 - j1);

	boolean legal_for_piece_type = false;

	boolean target_exists = Board.hasPiece(i1, j1);

	boolean target_exists_opponent = false;

	boolean no_obstacles = true;

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

	if ( legal_for_piece_type == true ) {

	    int step_i = Integer.signum(i1 - i0);
	    int step_j = Integer.signum(j1 - j0);

	    //  NE =  1,  1
	    //  NW = -1,  1
	    //  SE =  1, -1
	    //  SE = -1, -1	    

	    int chk_sq_i = i0 + step_i;
	    int chk_sq_j = j0 + step_j;

	    while ( chk_sq_i != i1 ) {

		if ( board.hasPiece(chk_sq_i, chk_sq_j) == true ) {

		    no_obstacles = false;

		}

		chk_sq_i += step_i;
		chk_sq_j += step_j;

	    }

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
