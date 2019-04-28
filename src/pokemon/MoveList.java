package pokemon;

import pokemon.Move.Category;
import pokemon.Pokemon.Type;

class Pound extends Move {
	public Pound() {
		type = type.NORMAL;
		category = Category.PHYSICAL;
		power = 40;
	}
}
class KarateChop extends Move{
	public KarateChop() {
		power = 50;
		type = type.FIGHT;
		category = Category.PHYSICAL;
	}
}

