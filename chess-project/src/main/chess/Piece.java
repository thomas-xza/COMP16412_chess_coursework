package chess;

public abstract class Piece {
	private String symbol;
	protected PieceColour colour;

	abstract boolean isLegitMove(int i0, int j0, int i1, int j1);

	public String getSymbol(){
		return symbol;
	}

	public void setSymbol(String s){
		symbol=s;
	}

	public PieceColour getColour(){
		return colour;
	}

    protected boolean deduce_target_validity(int i1, int j1) {

        boolean target_exists = Board.hasPiece(i1, j1);

        boolean target_exists_opponent = false;

        //  Set variable if moving into opponent's piece.

        if (target_exists == true &&
            (this.getColour() !=
             Board.getPiece(i1,j1).getColour() ) ) {

            target_exists_opponent = true;

        }

	if (target_exists == false ||
	    target_exists_opponent == true) {

	    return true;

	}

	return false;
	
    }

}
