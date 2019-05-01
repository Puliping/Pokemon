package pokemon;

import java.util.Collections;
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
			move = new KarateChop();
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
		if (num >= 0 && num < team.size())
			team.remove(num);
	}
	public String getTeam(int num) {
		return team.get(num).toString();
	}
	public String getTeam() {
		return team.toString();
	}
	
	public void swapTeam(int num1, int num2) {
		Collections.swap(team, num1, num2);
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
	
	public void setMove(int num, String id) {
		this.setMove(active, num, id);
	}
	
	public String getMove1(int pkmn) {
		return team.get(pkmn).getMove1();
	}
	
	public String getMove1() {
		return this.getMove1(active);
	}
	
	public String getMove2(int pkmn) {
		return team.get(pkmn).getMove2();
	}
	
	public String getMove2() {
		return this.getMove1(active);
	}
	
	public String getMove3(int pkmn) {
		return team.get(pkmn).getMove3();
	}
	
	public String getMove3() {
		return this.getMove3(active);
	}
	
	public String getMove4(int pkmn) {
		return team.get(pkmn).getMove4();
	}
	
	public String getMove4() {
		return this.getMove4(active);
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
	
	public void useItem(String id, Pokemon pkmn) {
		useGenIItem(id, pkmn);
	}
	
	public void useItem(String id) {
		this.useItem(id, team.get(active));
	}
	
	private boolean useGenIItem(String id, Pokemon pkmn) {
		switch (id) {
		case "Potion":
			return pkmn.heal(20);
		case "Super Potion":
			return pkmn.heal(50);
		case "Hyper Potion":
			return pkmn.heal(200);
		case "Max Potion":
			return pkmn.heal(pkmn.getMaxHP());
		case "Full Restore":
			return pkmn.heal(pkmn.getMaxHP());
		}
		return false;
	}
	
	public static void main(String[] args) {
		Trainer trnr = new Trainer("Gabriel", 12, 6);
		System.out.println(trnr);
		System.out.println(trnr.getTeam());
		System.out.println(trnr.getMove1());
	}
}
