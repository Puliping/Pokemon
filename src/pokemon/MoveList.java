package pokemon;

import pokemon.Pokemon.Type;

class Pound extends Move {
	public Pound() {
		power = 40;
		type = Type.NORMAL;
		category = Category.PHYSICAL;
	}
}

class Karate_Chop extends Move {
	public Karate_Chop() {
		power = 50;
		type = Type.FIGHT;
		category = Category.PHYSICAL;
	}
}

class Mega_Punch extends Move {
	public Mega_Punch() {
		power = 80;
		type = Type.NORMAL;
		category = Category.PHYSICAL;
	}
}

class Fire_Punch extends Move {
	public Fire_Punch() {
		power = 75;
		type = Type.FIRE;
		category = Category.PHYSICAL;
	}
}

class Ice_Punch extends Move {
	public Ice_Punch() {
		power = 75;
		type = Type.ICE;
		category = Category.PHYSICAL;
	}
}

class Thunder_Punch extends Move {
	public Thunder_Punch() {
		power = 75;
		type = Type.ELECTR;
		category = Category.PHYSICAL;
	}
}

class Razor_Wind extends Move {
	public Razor_Wind() {
		power = 80;
		type = Type.NORMAL;
		category = Category.SPECIAL;
	}
}

class Gust extends Move {
	public Gust() {
		power = 40;
		type = Type.FLYING;
		category = Category.SPECIAL;
	}
}

class Wing_Attack extends Move {
	public Wing_Attack() {
		power = 60;
		type = Type.FIGHT;
		category = Category.PHYSICAL;
	}
}

class Vine_Whip extends Move {
	public Vine_Whip() {
		power = 45;
		type = Type.GRASS;
		category = Category.PHYSICAL;
	}
}

class Flamethrower extends Move {
	public Flamethrower() {
		power = 90;
		type = Type.FIRE;
		category = Category.SPECIAL;
	}
}

class Hydro_Pump extends Move {
	public Hydro_Pump() {
		power = 110;
		type = Type.WATER;
		category = Category.SPECIAL;
	}
}

class Surf extends Move {
	public Surf() {
		power = 90;
		type = Type.WATER;
		category = Category.SPECIAL;
	}
}

class Quick_Attack extends Move {
	public Quick_Attack() {
		power = 40;
		type = Type.NORMAL;
		category = Category.PHYSICAL;
		priority = 1;
	}
}
