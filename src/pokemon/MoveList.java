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
class 	MegaPunch extends Move{
	public MegaPunch() {
		power = 80;
		type = Type.NORMAL;
		category = Category.PHYSICAL;
	}
}
class FirePunch extends Move{
	public FirePunch() {
		power = 75;
		type = Type.FIRE;
		category = Category.PHYSICAL;
	}
}
class 	IcePunch extends Move{
	public IcePunch() {
		power = 75;
		type = Type.ICE;
		category = Category.PHYSICAL;
	}
}
class ThunderPunch extends Move{
	public ThunderPunch() {
		power = 75;
		type = Type.ELECTR;
		category = Category.PHYSICAL;
	}
}
class RazorWind extends Move{
	public RazorWind() {
		power = 80;
		type = Type.NORMAL;
		category = Category.SPECIAL;
	}
}
class Gust extends Move{
	public Gust() {
		power = 40;
		type = Type.FLYING;
		category = Category.SPECIAL;
	}
}
class 	WingAttack extends Move{
	public WingAttack() {
		power = 60;
		type = Type.FIGHT;
		category = Category.PHYSICAL;
	}
}
class VineWhip extends Move{
	public VineWhip() {
		power = 45;
		type = Type.GRASS;
		category = Category.PHYSICAL;
	}
}
class 	Flamethrower extends Move{
	public 	Flamethrower() {
		power = 90;
		type = Type.FIRE;
		category = Category.SPECIAL;
	}
}
class 	HydroPump extends Move{
	public 	HydroPump() {
		power = 110;
		type = Type.WATER;
		category = Category.SPECIAL;
	}
}
class 	Surf extends Move{
	public 	Surf() {
		power = 90;
		type = Type.WATER;
		category = Category.SPECIAL;
	}
}

