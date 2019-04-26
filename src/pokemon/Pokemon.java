package pokemon;

interface Pokemon {
	static enum Type {
		NORMAL, FIGHT, FLYING, POISON, GROUND, ROCK, BUG, GHOST, FIRE, WATER, GRASS, ELECTR, PSYCHC, ICE, DRAGON
	}

	public int getID();

	public int getMaxHP();

	public int getAttack();

	public int getDefense();

	public int getSpDef();

	public int getSpAtk();

	public int getSpeed();

	public String getType1();

	public String getType2();

	public String getName();

	public static void main(String[] args) {
		Pokemon pkmn = new Bulbasaur();
		System.out.println(pkmn.getMaxHP());
		System.out.println(pkmn.getSpeed());
	}

}
