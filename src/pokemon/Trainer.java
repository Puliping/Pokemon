package pokemon;

import java.util.LinkedList;

public class Trainer {
	String name;
	LinkedList<Pokemon> team = new LinkedList<Pokemon>();

	public Trainer(String name) {
		this.name = name;
	}

	private Pokemon getGenI(int id) {
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

	public void addToTeam(int id) {
		Pokemon pkmn = getGenI(id);
		if (pkmn != null)
			team.add(pkmn);
	}

	public void setAttack(Pokemon pkmn,int num, String name) {
		Move move = null;
		switch (name) {
		case "Pound":
			move = new Pound();
			break;
		case "KarateChop":
			move = new KarateChop();
			break;
		}
		switch (num) {
		case 1:
			pkmn.move1 = move;
			break;
		case 2:
			pkmn.move2 = move;
			break;
		case 3:
			pkmn.move3 = move;
			break;
		case 4:
			pkmn.move4 = move;
			break;
		}
	}

	public String getTeam() {
		return team.toString();
	}

	@Override
	public String toString() {
		return name;
	}

	public static void main(String[] args) {
		Trainer trnr = new Trainer("Gabriel");
		trnr.addToTeam(12);
		trnr.addToTeam(6);
		System.out.println(trnr);
		System.out.println(trnr.getTeam());
		System.out.println(trnr.team.get(0).move1);
	}
}
