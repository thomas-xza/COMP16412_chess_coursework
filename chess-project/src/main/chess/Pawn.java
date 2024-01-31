package chess;

class Pawn extends Piece{
	private PieceColour colour;
	private String symbol;

	Pawn(PieceColour pc){
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
    boolean isLegitMove(int i0, int j0, int i1, int j1) {

	//  Yikes, pawn moves in quirky ways.

	int move_i = Math.abs(i0 - i1);

	int move_j = Math.abs(j0 - j1);

	boolean legal_for_piece_type = false;

	boolean no_obstacles = true;

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
	    move_j == 1 && move_i == 1) {

	    //  Warning: this logic allows backwards diagonal moves...

	    legal_for_piece_type = true;

	} else if ( target_exists_opponent == false &&
		    (
		     (move_j == 1)
		     ||
		     ( j0 == 1 && move_j == 2 && Board.hasPiece(i0, j0+1) == false )
		     ||
		     ( j0 == 6 && move_j == 2 && Board.hasPiece(i0, j0-1) == false ) ) )
	    {

		//  Again quite hacky, some backwards allowances.

	    legal_for_piece_type = true;
	    
	    }

	//  Make deductions based on facts available, return result.

	if ( legal_for_piece_type == true &&
	     no_obstacles == true &&
	     (target_exists == false ||
	      target_exists_opponent == true) ) {

	    return true;

	} else {

	    return false;

	}


    }
    
}
