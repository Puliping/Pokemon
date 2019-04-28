package pokemon;

import pokemon.Move.Category;
import pokemon.Pokemon.Type;

class Pound extends Move{
	public Pound() {
		int power = 40;
		type = type.NORMAL;
		Category category = Category.PHYSICAL;
	}
}
class KarateChop extends Move{
	public KarateChop() {
		int power = 50;
		type = type.FIGHT;
		Category category = Category.PHYSICAL;
	}
}