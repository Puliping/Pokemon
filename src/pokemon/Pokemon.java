package pokemon;

public class Pokemon {
	protected int max_hp;
	protected int Attack;
	protected int defense;
	protected int spAtk;
	protected int SpDef;
	protected int Speed;

	enum Type {
		normal, fight, flying, poison, ground, rock, bug, ghost, fire, water, grass, electr, psychc, ice, dragon
	}

	protected Type tp, ts;

	public int gethp_max() {
		return max_hp;
	}

	public int getattack() {
		return Attack;
	}

	public int getdefense() {
		return defense;
	}

	public int getspdef() {
		return SpDef;
	}

	public int getspatk() {
		return spAtk;
	}

	public int getspeed() {
		return Speed;
	}
}

class Bulbassauro extends Pokemon {
	protected int max_hp = 294;
	protected int Attack = 216;
	protected int Defense = 216;
	protected int SpAtk = 251;
	protected int SpDef = 251;
	protected int Speed = 207;
	Type tp = Type.grass;
	Type ts = Type.poison;
}

class Ivysauro extends Pokemon {
	protected int max_hp = 324;
	protected int Attack = 245;
	protected int Defense = 247;
	protected int SpAtk = 284;
	protected int SpDef = 284;
	protected int Speed = 240;
	Type tp = Type.poison;
	Type ts = Type.grass;
}

class Venusaur extends Pokemon {
	protected int max_hp = 364;
	protected int Attack = 289;
	protected int Defense = 291;
	protected int SpAtk = 328;
	protected int SpDef = 328;
	protected int Speed = 284;
	Type tp = Type.grass;
	Type ts = Type.poison;
}

class Charmander extends Pokemon {
	protected int max_hp = 282;
	protected int Attack = 223;
	protected int Defense = 203;
	protected int SpAtk = 240;
	protected int SpDef = 218;
	protected int Speed = 251;
	Type tp = Type.fire;
	Type ts = Type.fire;
}

class Charmeleon extends Pokemon {
	protected int max_hp = 320;
	protected int Attack = 249;
	protected int Defense = 236;
	protected int SpAtk = 284;
	protected int SpDef = 251;
	protected int Speed = 284;
	Type tp = Type.fire;
	Type ts = Type.fire;
}

class Charizard extends Pokemon {
	protected int max_hp = 360;
	protected int Attack = 293;
	protected int Defense = 280;
	protected int SpAtk = 348;
	protected int SpDef = 295;
	protected int Speed = 328;
	Type tp = Type.fire;
	Type ts = Type.flying;
}

class Squirtle extends Pokemon {
	int maxHP = 292, atk = 214, def = 251, spatk = 218, spdef = 249, speed = 203;
	Type tp = ts = Type.water;
}

class Wartortle extends Pokemon {
	int maxHP = 322, atk = 247, def = 284, spatk = 251, spdef = 284, speed = 236;
	Type tp = ts = Type.water;
}

class Blastoise extends Pokemon {
	int maxHP = 362, atk = 291, def = 328, spatk = 295, spdef = 339, speed = 280;
	Type tp = ts = Type.water;
}

class Caterpie extends Pokemon {
	int maxHP = 294, atk = 174, def = 185, spatk = 152, spdef = 152, speed = 207;
	Type tp = ts = Type.bug;
}

class Metapod extends Pokemon {
	int maxHP = 304, atk = 152, def = 229, spatk = 163, spdef = 163, speed = 174;
	Type tp = ts = Type.bug;
}

class Butterfree extends Pokemon {
	int maxHP = 324, atk = 207, def = 218, spatk = 284, spdef = 284, speed = 262;
	Type tp = Type.bug, ts = Type.flying;
}
