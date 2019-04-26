package pokemon;

class Bulbasaur implements Pokemon {
	static final int id = 1, maxHP = 294, attack = 216, defense = 216, spAtk = 251, spDef = 251, speed = 207;
	static final Type type1 = Type.GRASS, type2 = Type.POISON;

	public int getID() {
		return id;
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

	public String getName() {
		String str = this.getClass().getName();
		str = str.replace("pokemon.", "");
		return str;
	}

}

class Ivysaur implements Pokemon {
	static final int id = 2, maxHP = 324, attack = 245, defense = 247, spAtk = 284, spDef = 284, speed = 240;
	static final Type type1 = Type.POISON, type2 = Type.GRASS;

	public int getID() {
		return id;
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

	public String getName() {
		String str = this.getClass().getName();
		str = str.replace("pokemon.", "");
		return str;
	}

}

class Venusaur implements Pokemon {
	static final int id = 3, maxHP = 364, attack = 289, defense = 291, spAtk = 328, spDef = 328, speed = 284;
	static final Type type1 = Type.GRASS, type2 = Type.POISON;

	public int getID() {
		return id;
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

	public String getName() {
		String str = this.getClass().getName();
		str = str.replace("pokemon.", "");
		return str;
	}

}

class Charmander implements Pokemon {
	static final int id = 4, maxHP = 282, attack = 223, defense = 203, spAtk = 240, spDef = 218, speed = 251;
	static final Type type1 = Type.FIRE, type2 = Type.FIRE;

	public int getID() {
		return id;
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

	public String getName() {
		String str = this.getClass().getName();
		str = str.replace("pokemon.", "");
		return str;
	}

}

class Charmeleon implements Pokemon {
	static final int id = 5, maxHP = 320, attack = 249, defense = 236, spAtk = 284, spDef = 251, speed = 284;
	static final Type type1 = Type.FIRE, type2 = Type.FIRE;

	public int getID() {
		return id;
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

	public String getName() {
		String str = this.getClass().getName();
		str = str.replace("pokemon.", "");
		return str;
	}

}

class Charizard implements Pokemon {
	static final int id = 6, maxHP = 360, attack = 293, defense = 280, spAtk = 348, spDef = 295, speed = 328;
	static final Type type1 = Type.FIRE, type2 = Type.FLYING;

	public int getID() {
		return id;
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

	public String getName() {
		String str = this.getClass().getName();
		str = str.replace("pokemon.", "");
		return str;
	}

}

class Squirtle implements Pokemon {
	static final int id = 7, maxHP = 292, attack = 214, defense = 251, spAtk = 218, spDef = 249, speed = 203;
	static final Type type1 = Type.WATER, type2 = Type.WATER;

	public int getID() {
		return id;
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

	public String getName() {
		String str = this.getClass().getName();
		str = str.replace("pokemon.", "");
		return str;
	}

}

class Wartortle implements Pokemon {
	static final int id = 8, maxHP = 322, attack = 247, defense = 284, spAtk = 251, spDef = 284, speed = 236;
	static final Type type1 = Type.WATER, type2 = Type.WATER;

	public int getID() {
		return id;
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

	public String getName() {
		String str = this.getClass().getName();
		str = str.replace("pokemon.", "");
		return str;
	}

}

class Blastoise implements Pokemon {
	static final int id = 9, maxHP = 362, attack = 291, defense = 328, spAtk = 295, spDef = 339, speed = 280;
	static final Type type1 = Type.BUG, type2 = Type.WATER;

	public int getID() {
		return id;
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

	public String getName() {
		String str = this.getClass().getName();
		str = str.replace("pokemon.", "");
		return str;
	}

}

class Caterpie implements Pokemon {
	static final int id = 10, maxHP = 294, attack = 174, defense = 185, spAtk = 152, spDef = 152, speed = 207;
	static final Type type1 = Type.BUG, type2 = Type.BUG;

	public int getID() {
		return id;
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

	public String getName() {
		String str = this.getClass().getName();
		str = str.replace("pokemon.", "");
		return str;
	}

}

class Metapod implements Pokemon {
	static final int id = 11, maxHP = 304, attack = 152, defense = 229, spAtk = 163, spDef = 163, speed = 174;
	static final Type type1 = Type.BUG, type2 = Type.BUG;

	public int getID() {
		return id;
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

	public String getName() {
		String str = this.getClass().getName();
		str = str.replace("pokemon.", "");
		return str;
	}

}

class Butterfree implements Pokemon {
	static final int id = 12, maxHP = 324, attack = 207, defense = 218, spAtk = 284, spDef = 284, speed = 262;
	static final Type type1 = Type.BUG, type2 = Type.FLYING;

	public int getID() {
		return id;
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

	public String getName() {
		String str = this.getClass().getName();
		str = str.replace("pokemon.", "");
		return str;
	}

}
