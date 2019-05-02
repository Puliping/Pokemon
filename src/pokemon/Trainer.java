package pokemon;

import java.util.LinkedList;

public class Trainer {
	protected int active;
	protected String name;
	protected LinkedList<Pokemon> team = new LinkedList<Pokemon>();
	
	public Trainer(String name, int... ids) {
		this.name = name;
		for (int i : ids) {
			addToTeam(i);
		}
		if (team.peekFirst() != null)
			active = 0;
	}
	
	private Pokemon getGenIPokemon(int id) {
		Pokemon pkmn = null;
		switch (id) {
		case 0:
			pkmn = new MissingNo();
			break;
		case 1:
			pkmn = new Bulbasaur();
			break;
		case 2:
			pkmn = new Ivysaur();
			break;
		case 3:
			pkmn = new Venusaur();
			break;
		case 4:
			pkmn = new Charmander();
			break;
		case 5:
			pkmn = new Charmeleon();
			break;
		case 6:
			pkmn = new Charizard();
			break;
		case 7:
			pkmn = new Squirtle();
			break;
		case 8:
			pkmn = new Wartortle();
			break;
		case 9:
			pkmn = new Blastoise();
			break;
		case 10:
			pkmn = new Caterpie();
			break;
		case 11:
			pkmn = new Metapod();
			break;
		case 12:
			pkmn = new Butterfree();
			break;
		case 13:
			pkmn = new Weedle();
			break;
		case 14:
			pkmn = new Kakuna();
			break;
		case 15:
			pkmn = new Beedrill();
			break;
		case 16:
			pkmn = new Pidgey();
			break;
		case 17:
			pkmn = new Pidgeotto();
			break;
		case 18:
			pkmn = new Pidgeot();
			break;
		case 19:
			pkmn = new Ratata();
			break;
		case 20:
			pkmn = new Raticate();
			break;
		}
		return pkmn;
	}
	
	private Move getGenIMove(String id) {
		Move move = null;
		switch (id) {
		case "Pound":
			move = new Pound();
			break;
		case "Karate Chop":
			move = new Karate_Chop();
			break;
		case "Mega Punch":
			move = new Mega_Punch();
			break;
		case "Fire Punch":
			move = new Fire_Punch();
			break;
		case "Ice Punch":
			move = new Ice_Punch();
			break;
		case "Thunder Punch":
			move = new Thunder_Punch();
			break;
		
		case "Razor Wind":
			move = new Razor_Wind();
			break;
		case "Gust":
			move = new Gust();
			break;
		case "Wing Attack":
			move = new Wing_Attack();
			break;
		case "Vine Whip":
			move = new Vine_Whip();
			break;
		case "Flamethrower":
			move = new Flamethrower();
			break;
		case "Hydro Pump":
			move = new Hydro_Pump();
			break;
		case "Surf":
			move = new Surf();
			break;
		case "Quick Attack":
			move = new Quick_Attack();
			break;
		}
		return move;
	}
	
	public void addToTeam(int... ids) {
		for (int i = 0; i < ids.length; i++) {
			Pokemon pkmn = getGenIPokemon(ids[i]);
			if (pkmn != null)
				team.add(pkmn);
			if (team.size() == 6)
				break;
		}
	}
	
	public void removeFromTeam(int num) {
		if (num >= 0 && num < team.size()) {
			team.remove(num);
		}
	}
	
	public Pokemon getTeam(int num) {
		return team.get(num);
	}
	
	public int getActive() {
		return active;
	}
	
	public void setActive(int num) {
		active = num;
	}
	
	public LinkedList<Pokemon> getTeam() {
		return team;
	}
	
	public void setMove(int pkmn, int num, String id) {
		Move move = getGenIMove(id);
		if (move != null) {
			switch (num) {
			case 1:
				team.get(pkmn).move1 = move;
				break;
			case 2:
				team.get(pkmn).move2 = move;
				break;
			case 3:
				team.get(pkmn).move3 = move;
				break;
			case 4:
				team.get(pkmn).move4 = move;
				break;
			}
		}
	}
	
	public Move getMove(int num) {
		switch (num) {
		case 1:
			return team.get(active).getMove1();
		case 2:
			return team.get(active).getMove2();
		case 3:
			return team.get(active).getMove3();
		case 4:
			return team.get(active).getMove4();
		}
		return null;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
	// Battle functions
	public void shift(int num) {
		if (num >= 0 && num < team.size())
			active = num;
	}
	
	public int useItem(int id) {
		switch (id) {
		case 1: // Potion
			return Math.min((team.get(active).getMaxHP() - team.get(active).getHP()), 20);
		case 2: // Super Potion
			return Math.min((team.get(active).getMaxHP() - team.get(active).getHP()), 20);
		case 3: // Hyper Potion
			return Math.min((team.get(active).getMaxHP() - team.get(active).getHP()), 20);
		case 4: // Max Potion
			return Math.min((team.get(active).getMaxHP() - team.get(active).getHP()), 20);
		}
		return -1;
	}
	
	public void heal(int heal) {
		team.get(active).hp += heal;
		if (team.get(active).hp > team.get(active).maxHP)
			team.get(active).hp = team.get(active).maxHP;
		
	}
	
	public int takeDamage(int dmg) {
		int hp = team.get(active).hp;
		team.get(active).hp -= dmg;
		if (team.get(active).hp <= 0)
			return hp;
		else
			return dmg;
	}
	
	public static void main(String[] args) {
		Trainer trnr = new Trainer("Gabriel");
		System.out.println(trnr);
		System.out.println(trnr.getTeam());
		System.out.println(trnr.getMove(1));
	}
}
