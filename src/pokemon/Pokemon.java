package pokemon;

public class Pokemon {
	protected int max_hp;
	protected int Attack;
	protected int Defense;
	protected int SpAtk;
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

class Bulbassauro extends Pokemon {
	protected int max_hp = 294;
	protected int Attack = 216;
	protected int Defense = 216;
	protected int SpAtk = 251;
	protected int SpDef = 251;
	protected int Speed = 207;
	Type tp=Type.grass;
	Type ts=Type.poison;
}
class Ivysauro extends Pokemon{
	protected int max_hp = 324;
	protected int Attack = 245;
	protected int Defense = 247;
	protected int SpAtk = 284;
	protected int SpDef = 284;
	protected int Speed = 240;
	Type tp=Type.poison;
	Type ts=Type.grass;
}
class Venusaur extends Pokemon{
	protected int max_hp = 364;
	protected int Attack = 289;
	protected int Defense = 291;
	protected int SpAtk = 328;
	protected int SpDef = 328;
	protected int Speed = 284;
	Type tp=Type.grass;
	Type ts=Type.poison;
}
class Charmander extends Pokemon{
	protected int max_hp = 282;
	protected int Attack = 223;
	protected int Defense = 203;
	protected int SpAtk = 240;
	protected int SpDef = 218;
	protected int Speed = 251;
	Type tp=Type.fire;
	Type ts=Type.fire;
}
class Charmeleon  extends Pokemon{
	protected int max_hp = 320;
	protected int Attack = 249;
	protected int Defense = 236;
	protected int SpAtk = 284;
	protected int SpDef = 251;
	protected int Speed = 284;
	Type tp=Type.fire;
	Type ts=Type.fire;
}
class Charizard extends Pokemon{
	protected int max_hp = 360;
	protected int Attack = 293;
	protected int Defense = 280;
	protected int SpAtk = 348;
	protected int SpDef = 295;
	protected int Speed = 328;
	Type tp=Type.fire;
	Type ts=Type.flying;
}

