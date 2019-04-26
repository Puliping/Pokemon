package pokemon;

public class Pokemon {
	static enum Type {
		NORMAL, FIGHT, FLYING, POISON, GROUND, ROCK, BUG, GHOST, FIRE, WATER, GRASS, ELECTR, PSYCHC, ICE, DRAGON
	}

	int maxHP, attack, defense, spAtk, spDef, speed;
	static Type type1, type2;

	public int getMaxHP() {
		return this.maxHP;
	}

	public int getAttack() {
		return this.attack;
	}

	public int getDefense() {
		return this.defense;
	}

	public int getSpDef() {
		return this.spDef;
	}

	public int getSpAtk() {
		return this.spAtk;
	}

	public int getSpeed() {
		return this.speed;
	}

	public String getType1() {
		return this.type1.toString();
	}
	
	public String getName() {
		String str = this.getClass().getName();
		str = str.replace("pokemon.", "");
		return str;
	}
	
	public static void main(String[] args) {
		Pokemon pkmn = new Bulbasaur();
		System.out.println(pkmn.getMaxHP());
		System.out.println(pkmn.getName());
	}
}
