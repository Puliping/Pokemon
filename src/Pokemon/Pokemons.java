package Pokemon;

public class Pokemons {
	private int max_hp;
	private int Attack;
	private int Defense;
	private int SpAtk;
	private int SpDef;
	private int Speed;

	enum Type {
		normal, fight, flying, poison, ground, rock, bug, 
		ghost, fire, water, grass, electr, psychc, ice, dragon
	}

	public int gethp_max() {
		return max_hp;
	}

	public int getattack() {
		return Attack;
	}

	public int getdefense() {
		return Defense;
	}

	public int getspdef() {
		return SpDef;
	}

	public int getspatk() {
		return SpAtk;
	}

	public int getspeed() {
		return Speed;
	}
}
