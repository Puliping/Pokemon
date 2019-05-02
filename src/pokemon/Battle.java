package pokemon;

import java.util.Scanner;

public class Battle {
	static Scanner scan = new Scanner(System.in);
	
	public static Trainer setTrainer(int num) {
		System.out.println("<< Treinador " + num + " >>");
		System.out.println("Qual seu nome?");
		String name = scan.nextLine();
		Trainer trnr = new Trainer(name);
		int[] results = {};
		for (boolean ok = false; !ok;) {
			System.out.println("Liste seus pokémons por # do Pokédex (máximo 6)");
			System.out.println("Ex.: \"3, 15\" para escolher \"Venusaur, Beedrill\"");
			String team = scan.nextLine();
			String[] items = team.replaceAll("\\s+", "").split(",");
			results = new int[items.length];
			for (int i = 0; i < items.length; i++) {
				try {
					ok = true;
					results[i] = Integer.parseInt(items[i]);
				} catch (NumberFormatException nfe) {
					System.out.println("Erro na leitura, tente novamente...");
					ok = false;
				}
			}
		}
		trnr.addToTeam(results);
		System.out.println(trnr.getTeam());
		System.out.println("Escolha os golpes dos seus Pokémons");
		System.out.println("Ex.: \"Pound\" ou \"Razor Whip\"");
		for (int i = 0; i < trnr.getTeam().size(); i++) {
			System.out.println((i + 1) + ". " + trnr.getTeam(i));
			for (int j = 1; j <= 4; j++) {
				System.out.print(" " + j + ".o golpe: ");
				String move = scan.nextLine();
				trnr.setMove(i, j, move);
			}
		}
		System.out.println();
		return trnr;
	}
	
	public static void battle(Trainer trnr1, Trainer trnr2) {
		int[] res1, res2;
		System.out.println("<< Batalha >>");
		for (int i = 1; trnr1.getTeam().size() > 0 && trnr2.getTeam().size() > 0; i++) {
			System.out.println("<< Turno " + i + " >>");
			System.out.println(turnString(trnr1));
			System.out.println(turnString(trnr2));
			System.out.println("<< " + trnr1 + " >>");
			res1 = turnChoice(trnr1, trnr2);
			System.out.println("<< " + trnr2 + " >>");
			res2 = turnChoice(trnr2, trnr1);
			
			// Controller?
			System.out.println("Resolvendo turno...");
			BattleRound be = new BattleRound(trnr1, res1, trnr2, res2);
			be.run();
			// Controller?
			if (trnr1.getTeam(trnr1.getActive()).getHP() <= 0)
				faint(trnr1);
			if (trnr2.getTeam(trnr2.getActive()).getHP() <= 0 && trnr2.getTeam().size() != 0)
				faint(trnr2);
		}
		System.out.println("<< Fim da Batalha >>");
		if (trnr1.getTeam().size() > 0) {
			System.out.println(trnr1 + " ganhou!");
		} else {
			System.out.println(trnr2 + " ganhou!");
		}
	}
	
	private static String turnString(Trainer trnr) {
		String str = trnr + ": " + trnr.getTeam(trnr.getActive());
		str += " (" + trnr.getTeam(trnr.getActive()).getHP() + "/" + trnr.getTeam(trnr.getActive()).getMaxHP() + ")";
		return str;
	}
	
	private static void faint(Trainer trnr) {
		trnr.removeFromTeam(trnr.getActive());
		if(trnr.getTeam().size() <= 0)
			return;
		for (boolean ok = false; !ok;) {
			printPokemon(trnr);
			int opt;
			try {
				opt = Integer.parseInt(scan.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Escolha inválida...");
				continue;
			}
			if (opt < 1 || opt > trnr.getTeam().size()) {
				System.out.println("Escolha inválida...");
				continue;
			}
			trnr.shift(opt - 1);
			ok = true;
		}
		
	}
	
	private static void printAction() {
		System.out.println("Escolha sua ação");
		System.out.println("[1] Lutar");
		System.out.println("[2] Itens");
		System.out.println("[3] Pokémon");
		System.out.println("[4] Fugir");
	}
	
	private static void printFight(Trainer trnr) {
		System.out.println("Escolha o ataque");
		System.out.println("[1] " + trnr.getMove(1));
		System.out.println("[2] " + trnr.getMove(2));
		System.out.println("[3] " + trnr.getMove(3));
		System.out.println("[4] " + trnr.getMove(4));
	}
	
	private static void printBag() {
		System.out.println("Escolha o item");
		System.out.println("[1] Potion");
		System.out.println("[2] Super Potion");
		System.out.println("[3] Hyper Potion");
		System.out.println("[4] Max Potion");
	}
	
	private static void printPokemon(Trainer trnr) {
		System.out.println("Escolha o Pokémon para substituir");
		for (int j = 0; j < trnr.getTeam().size(); j++) {
			System.out.print("[" + (j + 1) + "] " + trnr.getTeam(j));
			if (j == trnr.getActive())
				System.out.print("  <");
			System.out.println();
		}
	}
	
	private static int[] turnChoice(Trainer trnr, Trainer opp) {
		int[] res = new int[3];
		for (boolean ok = false; !ok;) {
			printAction();
			try {
				res[0] = Integer.parseInt(scan.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Escolha inválida...");
				continue;
			}
			switch (res[0]) {
			case 1:
				printFight(trnr);
				try {
					res[1] = Integer.parseInt(scan.nextLine());
				} catch (NumberFormatException e) {
					System.out.println("Escolha inválida...");
					break;
				}
				if (res[1] < 1 || res[1] > 4) {
					System.out.println("Escolha inválida...");
					break;
				}
				res[2] = trnr.getMove(res[1]).damage(trnr.getTeam(trnr.getActive()), opp.getTeam(opp.getActive()));
				ok = true;
				break;
			case 2:
				printBag();
				try {
					res[1] = Integer.parseInt(scan.nextLine());
				} catch (NumberFormatException e) {
					System.out.println("Escolha inválida...");
					break;
				}
				if (res[1] < 1 || res[1] > 4) {
					System.out.println("Escolha inválida...");
					break;
				}
				res[2] = trnr.useItem(res[1]);
				ok = true;
				break;
			case 3:
				printPokemon(trnr);
				try {
					res[1] = Integer.parseInt(scan.nextLine());
				} catch (NumberFormatException e) {
					System.out.println("Escolha inválida...");
					break;
				}
				if (res[1] == trnr.getActive() + 1) {
					System.out.println("Este Pokémon já está ativo!");
					break;
				}
				if (res[1] < 1 || res[1] > trnr.getTeam().size()) {
					System.out.println("Escolha inválida...");
					break;
				}
				ok = true;
				break;
			case 4:
				System.out.println("É impossível fugir da batalha!");
			}
		}
		return res;
	}
	
	public static void main(String[] agrs) {
		Trainer trnr1 = setTrainer(1);
		Trainer trnr2 = setTrainer(2);
		
		battle(trnr1, trnr2);
		scan.close();
	}
	
}
