package pokemon;

import pokemon.Pokemon.Type;

public class Move {
	public static enum Category {
		PHYSICAL, SPECIAL, STATUS;
	}
	
	public static final double table_types[][] = {
			// @formatter:off
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
	    	// @formatter:on
	};
	
	protected int power, priority = 0;
	protected Type type;
	protected Category category;
	
	public double modifier(Pokemon target) {
		if (target.getType1().equals(target.getType2())) {
			return (table_types[type.ordinal()][target.type1.ordinal()]);
		} else {
			return (table_types[type.ordinal()][target.type1.ordinal()]
					* table_types[type.ordinal()][target.type2.ordinal()]);
		}
	}
	
	public int getPower() {
		return power;
	}
	
	public int getPriority() {
		return priority;
	}
	
	public String getType() {
		return type.toString();
	}
	
	public String getCategory() {
		return category.toString();
	}
	
	public void use() {
		
	}
	
	@Override
	public String toString() {
		String str = this.getClass().getSimpleName();
		str = str.replace("_", " ");
		return str;
	}
	
	public int damage(Pokemon pkmn, Pokemon target) {
		int dmg;
		if (category.equals(Category.PHYSICAL)) {
			dmg = (int) (((42.0 * getPower() * pkmn.getAttack() / target.getDefense() / 50) + 2) * modifier(target));
		} else {
			dmg = (int) (((42.0 * getPower() * pkmn.getSpAtk() / target.getSpDef() / 50) + 2) * modifier(target));
		}
		return dmg;
	}
	
}
