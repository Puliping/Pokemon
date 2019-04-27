package pokemon;

class Pokemon {
	static enum Type {
		NORMAL, FIGHT, FLYING, POISON, GROUND, ROCK, BUG, GHOST, FIRE, WATER, GRASS, ELECTR, PSYCHC, ICE, DRAGON
	}

	int id, maxHP, attack, defense, spAtk, spDef, speed;
	Type type1, type2;

	public int getID() {
		return id;
	}

	public int getMaxHP() {
		return maxHP;
	}

	public int getAttack() {
		return attack;
	}

	public int getDefense() {
		return defense;
	}

	public int getSpDef() {
		return spDef;
	}

	public int getSpAtk() {
		return spAtk;
	}

	public int getSpeed() {
		return speed;
	}

	public String getType1() {
		return type1.toString();
	}

	public String getType2() {
		return type2.toString();
	}
	
	@Override
	public String toString() {
		String str = this.getClass().getSimpleName();
		str = str.replace("_", " ");
		return str;
	}

	public static void main(String[] args) {
		Pokemon pkmn1 = new Bulbasaur();
		Pokemon pkmn2 = new Blastoise();
		System.out.println(pkmn1);
		System.out.println(pkmn1.getMaxHP());
		System.out.println(pkmn1.getSpeed());
		System.out.println(pkmn2);
		System.out.println(pkmn2.getMaxHP());
		System.out.println(pkmn2.getSpeed());
	}

}
