package chess;

public class Pawn extends Piece{
	private PieceColour colour;
	private String symbol;

	public Pawn(PieceColour pc){
		if (pc.equals(PieceColour.WHITE)){
			this.colour=PieceColour.WHITE;
			this.symbol="♙";
		}
		else if (pc.equals(PieceColour.BLACK)){
			this.colour=PieceColour.BLACK;
			this.symbol="♟";
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

	//  Yikes, pawn moves in quirky ways. Tried to avoid checking
	//  the piece colour and doing direction checking, instead
	//  opted for some quick hacks.

	int move_i = Math.abs(i0 - i1);

	int move_j = Math.abs(j0 - j1);

	boolean legal_for_piece_type = false;

        boolean target_exists = Board.hasPiece(i1, j1);

        boolean target_exists_opponent = false;

        //  Set variable if moving into opponent's piece.

        if (target_exists == true &&
            ( this.getColour() !=
             Board.getPiece(i1,j1).getColour() ) ) {

            target_exists_opponent = true;

        }

	//  Set variable if final target legal for this piece type.

	if (target_exists_opponent == true &&
	    move_i == 1 && move_j == 1) {
	    
	    //  Warning: this logic allows backwards diagonal moves...

	    legal_for_piece_type = true;

	} else if ( target_exists_opponent == false &&
		    target_exists == false &&
		    (
		     (move_i == 1 && move_j == 0)  //  This will allow backwards moves...
		     ||
		     ( i0 == 1 && move_i == 2 && Board.hasPiece(2, j0) == false )  //  This permits an edge case where opponent can make a double move towards end.
		     ||
		     ( i0 == 6 && move_i == 2 && Board.hasPiece(5, j0) == false ) ) )
	    {

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
