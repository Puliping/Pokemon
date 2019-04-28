package pokemon;

public class Pokemon {
	static enum Type {
		NORMAL, FIGHT, FLYING, POISON, GROUND, ROCK, BUG, GHOST, FIRE, WATER, GRASS, ELECTR, PSYCHC, ICE, DRAGON;
	}
	
	protected int id, hp, maxHP, attack, defense, spAtk, spDef, speed;
	protected Type type1, type2;
	protected Move move1 = new Pound(), move2 = new Pound(), move3 = new Pound(), move4 = new Pound();
	
	public int getID() {
		return id;
	}
	
	public int getHP() {
		return hp;
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
	
	public String getMove1() {
		return move1.toString();
	}
	
	public String getMove2() {
		return move1.toString();
	}
	
	public String getMove3() {
		return move1.toString();
	}
	
	public String getMove4() {
		return move1.toString();
	}
	
	@Override
	public String toString() {
		String str = this.getClass().getSimpleName();
		str = str.replace("_", " ");
		return str;
	}
	
	public boolean heal(int heal) {
		if (hp == 0 || hp == maxHP)
			return false;
		hp += heal;
		return true;
	}
	
	public boolean takeDamage(int dmg) {
		hp -= dmg;
		if (hp <= 0)
			return true;
		else
			return false;
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
