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
		case 21:
			pkmn = new Spearow();
			break;
		case 22:
			pkmn = new Fearow();
			break;
		case 23:
			pkmn = new Ekans();
			break;
		case 24:
			pkmn = new Arbok();
			break;
		case 25:
			pkmn = new Pikachu();
			break;
		case 26:
			pkmn = new Raichu();
			break;
		case 27:
			pkmn = new Sandshrew();
			break;
		case 28:
			pkmn = new Sandslash();
			break;
		case 29:
			pkmn = new Nidoran_F();
			break;
		case 30:
			pkmn = new Nidorina();
			break;
		case 31:
			pkmn = new Nidoqueen();
			break;
		case 32:
			pkmn = new Nidoran_M();
			break;
		case 33:
			pkmn = new Nidorino();
			break;
		case 34:
			pkmn = new Nidoking();
			break;
		case 35:
			pkmn = new Clefairy();
			break;
		case 36:
			pkmn = new Clefable();
			break;
		case 37:
			pkmn = new Vulpix();
			break;
		case 38:
			pkmn = new Ninetales();
			break;
		case 39:
			pkmn = new Jigglypuff();
			break;
		case 40:
			pkmn = new Wigglytuff();
			break;
		case 41:
			pkmn = new Zubat();
			break;
		case 42:
			pkmn = new Golbat();
			break;
		case 43:
			pkmn = new Oddish();
			break;
		case 44:
			pkmn = new Gloom();
			break;
		case 45:
			pkmn = new Vileplume();
			break;
		case 46:
			pkmn = new Paras();
			break;
		case 47:
			pkmn = new Parasect();
			break;
		case 48:
			pkmn = new Venonat();
			break;
		case 49:
			pkmn = new Venomoth();
			break;
		case 50:
			pkmn = new Diglett();
			break;
		case 51:
			pkmn = new Dugtrio();
			break;
		case 52:
			pkmn = new Meowth();
			break;
		case 53:
			pkmn = new Persian();
			break;
		case 54:
			pkmn = new Psyduck();
			break;
		case 55:
			pkmn = new Golduck();
			break;
		case 56:
			pkmn = new Mankey();
			break;
		case 57:
			pkmn = new Primeape();
			break;
		case 58:
			pkmn = new Growlithe();
			break;
		case 59:
			pkmn = new Arcanine();
			break;
		case 60:
			pkmn = new Poliwag();
			break;
		case 61:
			pkmn = new Poliwhirl();
			break;
		case 62:
			pkmn = new Poliwrath();
			break;
		case 63:
			pkmn = new Abra();
			break;
		case 64:
			pkmn = new Kadabra();
			break;
		case 65:
			pkmn = new Alakazam();
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
		case "Psybeam":
			move = new Psybeam();
			break;
		case "Sludge":
			move = new Sludge();
			break;
		case "Earthquake":
			move = new Earthquake();
			break;
		case "Rock Slide":
			move = new Rock_Slide();
			break;
		case "Leech Life":
			move = new Leech_Life();
			break;
		case "Lick":
			move = new Lick();
			break;
		case "Dragon Rage":
			move = new Dragon_Rage();
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
