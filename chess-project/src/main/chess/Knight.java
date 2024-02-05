package chess;

public class Knight extends Piece{
    private PieceColour colour;
    private String symbol;

    public Knight(PieceColour pc){
	if (pc.equals(PieceColour.WHITE)){
	    this.colour=PieceColour.WHITE;
	    this.symbol="♘";
	}
	else if (pc.equals(PieceColour.BLACK)){
	    this.colour=PieceColour.BLACK;
	    this.symbol="♞";
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

	boolean target_valid = this.deduce_target_validity(i1, j1);

	//  Set variable if final target legal for this piece type.

	if ( (move_i == 2 && move_j == 1) ||
	     (move_j == 2 && move_i == 1) ) {

	    legal_for_piece_type = true;

	}

	//  Make deductions based on facts available, return result.

	if ( legal_for_piece_type == true &&
	     target_valid == true ) {

	    return true;

	} else {

	    return false;

	}

    }	    

}
