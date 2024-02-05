package chess;

public class Queen extends Piece{
	private PieceColour colour;
	private String symbol;

	public Queen(PieceColour pc){
		if (pc.equals(PieceColour.WHITE)){
			this.colour=PieceColour.WHITE;
			this.symbol="♕";
		}
		else if (pc.equals(PieceColour.BLACK)){
			this.colour=PieceColour.BLACK;
			this.symbol="♛";
		}
	}

	public String getSymbol(){
		return symbol;
	}
	public PieceColour getColour(){
		return colour;
	}

    @Override
    public boolean isLegitMove(int i0, int j0, int i1, int j1) {

	int move_i = Math.abs(i0 - i1);

	int move_j = Math.abs(j0 - j1);

	boolean legal_for_piece_type = false;

	boolean no_obstacles = true;

	boolean target_valid = this.deduce_target_validity(i1, j1);

	//  Set variable if final target legal for this piece type.

	if ( (move_i > 0 && move_j == 0) ||
	     (move_j > 0 && move_i == 0) ||
	     (move_i == move_j) ) {

	    legal_for_piece_type = true;

	}

	//  Step towards final target, check for obstacles.

	if ( legal_for_piece_type == true ) {

	    int step_i = Integer.signum(i1 - i0);
	    int step_j = Integer.signum(j1 - j0);

	    int chk_sq_i = i0 + step_i;
	    int chk_sq_j = j0 + step_j;

	    while ( chk_sq_i != i1 && chk_sq_j != j1 ) {

		if ( Board.hasPiece(chk_sq_i, chk_sq_j) == true ) {

		    no_obstacles = false;

		}

		chk_sq_i += step_i;
		chk_sq_j += step_j;

	    }

	}

	//  Make deductions based on facts available, return result.

	if ( legal_for_piece_type == true &&
	     no_obstacles == true &&
	     target_valid == true ) {

	    return true;

	} else {

	    return false;

	}


    }
    
}
