package pokemon;

import pokemon.Pokemon.Type;

class Pound extends Move {
	public Pound() {
		power = 40;
		type = Type.NORMAL;
		category = Category.PHYSICAL;
	}
}
class KarateChop extends Move{
	public KarateChop() {
		power = 50;
		type = Type.FIGHT;
		category = Category.PHYSICAL;
	}
}

