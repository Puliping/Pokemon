package pokemon;

import pokemon.Pokemon.Type;

public class Move {
	public static enum Category {
		PHYSICAL, SPECIAL, STATUS
	}
	
	public static final double table_types[][] = {
    	{ 1,   1,   1,   1,   1, 0.5,   1,   0,   1,   1,   1,   1,   1,   1,   1 },
    	{ 2,   1, 0.5, 0.5,   1,   2, 0.5,   0,   1,   1,   1,   1, 0.5,   2,   1 },
    	{ 1,   2,   1,   1,   1, 0.5,   2,   1,   1,   1,   2, 0.5,   1,   1,   1 },
    	{ 1,   1,   1, 0.5, 0.5, 0.5,   2, 0.5,   1,   1,   2,   1,   1,   1,   1 },
    	{ 1,   1,   0,   2,   1,   2, 0.5,   1,   2,   1, 0.5,   2,   1,   1,   1 },
    	{ 1, 0.5,   2,   1, 0.5,   1,   2,   1,   2,   1,   1,   1,   1,   2,   1 },
    	{ 1, 0.5, 0.5,   2,   1,   1,   1, 0.5, 0.5,   1,   2,   1,   2,   1,   1 },
    	{ 0,   1,   1,   1,   1,   1,   1,   2,   1,   1,   1,   1,   0,   1,   1 },
    	{ 1,   1,   1,   1,   1, 0.5,   2,   1, 0.5, 0.5,   2,   1,   1,   2, 0.5 },
    	{ 1,   1,   1,   1 ,  2,   2,   1,   1,   2, 0.5, 0.5,   1,   1,   1, 0.5 },
    	{ 1,   1, 0.5, 0.5,   2,   2, 0.5,   1, 0.5,   2, 0.5,   1,   1,   1, 0.5 },
    	{ 1,   1,   2,   1,   0,   1,   1,   1,   1,   2, 0.5, 0.5,   1,   1, 0.5 },
    	{ 1,   2,   1,   2,   1,   1,   1,   1,   1,   1,   1,   1, 0.5,   1,   1 },
    	{ 1,   1,   2,   1,   2,   1,   1,   1,   1, 0.5,   2,   1,   1, 0.5,   2 },
    	{ 1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   2 }
    };
	
	protected int power, priority;
	protected Type type;
	protected Category category;
	
	public double modifier(Move move, Pokemon target) {
		if (target.getType1().equals(target.getType2())) {
			return (table_types[move.type.ordinal()][target.type1.ordinal()]);
		}
		else {
			return (table_types[move.type.ordinal()][target.type1.ordinal()]
					* table_types[move.type.ordinal()][target.type2.ordinal()]);
		}
	}
}
