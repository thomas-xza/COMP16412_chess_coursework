package chess;

public class CheckInput {

    private static boolean check_char_in_char_set(String char_set, char char_target) {

	int i;

	for (i = 0 ; i < char_set.length() ; i++ ) {

	    if ( char_set.charAt(i) == char_target ) {

		return true;

	    }

	}

	return false;

    }
	
    public static boolean checkCoordinateValidity(String input){

	//  Should really be array of chars but wanted the String methods.

	String n_set="01234567";

	String l_set="abcdefgh";

	boolean n_in_n_set = false;

	boolean l_in_l_set = false;

	if (input.length() == 2) {
	    
	    char n = input.charAt(0);

	    char l = input.charAt(1);

	    n_in_n_set = check_char_in_char_set(n_set, n);

	    l_in_l_set = check_char_in_char_set(l_set, l);
		
	}

	if (n_in_n_set == true && l_in_l_set == true) {

	    return true;

	}

	return false;

    }
    
}
