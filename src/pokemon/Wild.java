package pokemon;

import java.util.Scanner;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Wild {
	static final int MAXPKMN = 65; // Numero de pokemons programados
	static Scanner scan = new Scanner(System.in);
	static Random rand = new Random();
	static int c = 0;
	
	static int caught(int id, Pokemon pkmn) {
		int m, f, ball = 12;
		switch (id) {
		case 2:
			ball = 8;
		case 4:
			return 1;
		}
		m = rand.nextInt(256);
		f = (pkmn.maxHP * 255 * 4) / (pkmn.hp * ball);
		if (f >= m)
			return 1;
		else
			return 0;
	}
	
	static int escape(Trainer trnr, Trainer wild) {
		int f, b;
		c++;
		b = (int) ((wild.getTeam(0).speed / 4.0) % 256);
		if (b == 0) {
			c = 0;
			return 1;
		}
		f = (trnr.getTeam(trnr.getActive()).speed * 32) / b + 30 * c;
		if (f > rand.nextInt(256)) {
			c = 0;
			return 1;
		}
		return 0;
	}
	
	public static void battle(Trainer trnr, Trainer wild) {
		int[] resT, resW;
		System.out.println("<< Batalha >>");
		for (int i = 1; trnr.getTeam().size() > 0 && wild.getTeam().size() > 0; i++) {
			System.out.println("<< Turno " + i + " >>");
			System.out.println(turnString(trnr));
			System.out.println(turnString(wild));
			System.out.println("<< " + trnr + " >>");
			resT = turnChoice(trnr, wild);
			resW = wildChoice(wild, trnr);
			System.out.println("Resolvendo turno...");
			
			BattleRound be = new BattleRound(trnr, resT, wild, resW);
			be.run();
			
			if (trnr.getTeam(trnr.getActive()).getHP() <= 0 && trnr.getTeam().size() != 0)
				Versus.faint(trnr);
			if(wild.getTeam(0).hp <= 0) {
				wild.removeFromTeam(0);
				break;
			}
		}
		System.out.println("<< Fim da Batalha >>");
	}
	
	static void printAction() {
		System.out.println("Escolha sua acao");
		System.out.println("[1] Lutar");
		System.out.println("[2] Itens");
		System.out.println("[3] Pokemon");
		System.out.println("[4] Fugir");
	}
	
	static void printFight(Trainer trnr) {
		System.out.println("Escolha o ataque");
		System.out.println("[1] " + trnr.getMove(1));
		System.out.println("[2] " + trnr.getMove(2));
		System.out.println("[3] " + trnr.getMove(3));
		System.out.println("[4] " + trnr.getMove(4));
	}
	
	static void printBag(Trainer trnr) {
		System.out.println("Escolha o item");
		if (trnr.potQty[0] > 0)
			System.out.println("[1] Potion (" + trnr.potQty[0] + ")");
		if (trnr.potQty[1] > 0)
			System.out.println("[2] Super Potion (" + trnr.potQty[1] + ")");
		if (trnr.potQty[2] > 0)
			System.out.println("[3] Hyper Potion (" + trnr.potQty[2] + ")");
		if (trnr.potQty[3] > 0)
			System.out.println("[4] Max Potion (" + trnr.potQty[3] + ")");
		if (trnr.ballQty[0] > 0)
			System.out.println("[5] POKe Ball (" + trnr.ballQty[0] + ")");
		if (trnr.ballQty[1] > 0)
			System.out.println("[6] Great Ball (" + trnr.ballQty[1] + ")");
		if (trnr.ballQty[2] > 0)
			System.out.println("[7] Ultra Ball (" + trnr.ballQty[2] + ")");
		if (trnr.ballQty[3] > 0)
			System.out.println("[8] Master Ball (" + trnr.ballQty[3] + ")");
	}
	
	static void printPokemon(Trainer trnr) {
		System.out.println("Escolha o Pokemon para substituir");
		for (int j = 0; j < trnr.getTeam().size(); j++) {
			System.out.print("[" + (j + 1) + "] " + trnr.getTeam(j));
			if (j == trnr.getActive())
				System.out.print("  <");
			System.out.println();
		}
	}
	
	static int[] turnChoice(Trainer trnr, Trainer opp) {
		int[] res = new int[3];
		for (boolean ok = false; !ok;) {
			printAction();
			try {
				res[0] = Integer.parseInt(scan.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Escolha invalida...");
				continue;
			}
			switch (res[0]) {
			case 1:
				printFight(trnr);
				try {
					res[1] = Integer.parseInt(scan.nextLine());
				} catch (NumberFormatException e) {
					System.out.println("Escolha invalida...");
					break;
				}
				if (res[1] < 1 || res[1] > 4) {
					System.out.println("Escolha invalida...");
					break;
				}
				res[2] = trnr.getMove(res[1]).damage(trnr.getTeam(trnr.getActive()), opp.getTeam(opp.getActive()));
				ok = true;
				break;
			case 2:
				printBag(trnr);
				try {
					res[1] = Integer.parseInt(scan.nextLine());
				} catch (NumberFormatException e) {
					System.out.println("Escolha invalida...");
					break;
				}
				if (res[1] < 1 || res[1] > 8 || (res[1] < 5 && trnr.potQty[res[1] - 1] < 1)
						|| (res[1] > 4 && trnr.ballQty[res[1] - 5] < 1)) {
					System.out.println("Escolha invalida...");
					break;
				}
				if (res[1] > 4) {
					res[0] = 5;
					res[2] = caught(res[1] - 4, opp.getTeam(opp.getActive()));
				} else {
					res[2] = trnr.useItem(res[1]);
				}
				ok = true;
				break;
			case 3:
				printPokemon(trnr);
				try {
					res[1] = Integer.parseInt(scan.nextLine());
				} catch (NumberFormatException e) {
					System.out.println("Escolha invalida...");
					break;
				}
				if (res[1] == trnr.getActive() + 1) {
					System.out.println("Este Pokemon ja esta ativo!");
					break;
				}
				if (res[1] < 1 || res[1] > trnr.getTeam().size()) {
					System.out.println("Escolha invalida...");
					break;
				}
				ok = true;
				break;
			case 4:
				res[1] = escape(trnr, opp);
				ok = true;
				break;
			}
		}
		return res;
	}
	
	static int[] wildChoice(Trainer wild, Trainer trnr) {
		int[] res = new int[3];
		if (rand.nextInt(256) == 255) {
			res[0] = 4;
			res[1] = 1;
		} else {
			res[0] = 1;
			res[1] = rand.nextInt(4) + 1;
			res[2] = wild.getMove(res[1]).damage(wild.getTeam(wild.getActive()), trnr.getTeam(trnr.getActive()));
		}
		return res;
	}
	
	private static String turnString(Trainer trnr) {
		String str = trnr + ": " + trnr.getTeam(trnr.getActive());
		str += " (" + trnr.getTeam(trnr.getActive()).getHP() + "/" + trnr.getTeam(trnr.getActive()).getMaxHP() + ")";
		return str;
	}
	
	public static void main(String[] args) {
		try {
			System.out.println("                                  ,'\\ \n"
					+ "    _.----.        ____         ,'  _\\   ___    ___     ____ \n"
					+ "_,-'       `.     |    |  /`.   \\,-'    |   \\  /   |   |    \\  |`. \n"
					+ "\\      __    \\    '-.  | /   `.  ___    |    \\/    |   '-.   \\ |  | \n"
					+ " \\.    \\ \\   |  __  |  |/    ,','_  `.  |          | __  |    \\|  | \n"
					+ "   \\    \\/   /,' _`.|      ,' / / / /   |          ,' _`.|     |  | \n"
					+ "    \\     ,-'/  /   \\    ,'   | \\/ / ,`.|         /  /   \\  |     | \n"
					+ "     \\    \\ |   \\_/  |   `-.  \\    `'  /|  |    ||   \\_/  | |\\    | \n"
					+ "      \\    \\ \\      /       `-.`.___,-' |  |\\  /| \\      /  | |   | \n"
					+ "       \\    \\ `.__,'|  |`-._    `|      |__| \\/ |  `.__,'|  | |   | \n"
					+ "        \\_.-'       |__|    `-._ |              '-.|     '-.| |   | \n"
					+ "                                `'                            '-._|");
			TimeUnit.SECONDS.sleep(5);
			System.out.println("\n=================================================================== \n");
			System.out.println("Ola! Bem-vindo ao mundo de POKeMON!");
			TimeUnit.SECONDS.sleep(2);
			System.out.println("Meu nome e OAK! As pessoas me chamam de prof. POKeMON!");
			TimeUnit.SECONDS.sleep(2);
			System.out.println("Esse mundo e habitado por criaturas chamadas POKeMON!");
			TimeUnit.SECONDS.sleep(2);
			System.out.println("Para algumas pessoas, POKeMONs sao pets. Outros, os usam em lutas.");
			TimeUnit.SECONDS.sleep(2);
			System.out.println("Ja eu... Estudar POKeMONs e minha profissao.");
			TimeUnit.SECONDS.sleep(2);
			System.out.println("Primeiramente, qual seu nome?");
			String name = scan.nextLine().toUpperCase();
			Trainer trnr = new Trainer(name);
			System.out.println("Certo! Entao seu nome e " + name + ".");
			TimeUnit.SECONDS.sleep(2);
			for (int i = 0; i < 5; i++) {
				System.out.print(".");
				TimeUnit.SECONDS.sleep(1);
			}
			System.out.println("\n" + name + "!");
			TimeUnit.SECONDS.sleep(2);
			System.out.println("Sua propria lenda POKeMON esta prestes a comecar!");
			TimeUnit.SECONDS.sleep(2);
			System.out.println("Um mundo de sonhos e aventuras com POKeMON espera! Vamos la!");
			TimeUnit.SECONDS.sleep(2);
			System.out.println("Escolha seu POKeMON iniciante!");
			TimeUnit.SECONDS.sleep(1);
			int r1, r2, r3;
			r1 = rand.nextInt(MAXPKMN) + 1;
			do {
				r2 = rand.nextInt(MAXPKMN) + 1;
			} while (r2 == r1);
			do {
				r3 = rand.nextInt(MAXPKMN) + 1;
			} while (r3 == r1 || r3 == r2);
			Trainer starter = new Trainer("");
			starter.addToTeam(r1, r2, r3);
			System.out.println("[1] " + starter.getTeam(0));
			System.out.println("[2] " + starter.getTeam(1));
			System.out.println("[3] " + starter.getTeam(2));
			int choice;
			for (;;) {
				try {
					choice = Integer.parseInt(scan.nextLine());
					if (choice < 1 || choice > 3) {
						System.out.println("Escolha invalida...");
						continue;
					}
					break;
				} catch (NumberFormatException e) {
					System.out.println("Escolha invalida...");
				}
			}
			trnr.addToTeam(starter.getTeam(choice - 1).id);
			System.out.println("Certo! Voce escolheu " + trnr.getTeam(0).toString().toUpperCase() + ".");
			TimeUnit.SECONDS.sleep(2);
			System.out.println("Escolha os ataques do seu POKeMON!");
			TimeUnit.SECONDS.sleep(1);
			String move;
			for(int i = 1; i <= 4; i++) {
				System.out.print(i + ". ");
				move = scan.nextLine();
				trnr.setMove(0, i, move);
			}
			System.out.println("Lembre-se! POKeMONs podem te atacar na grama alta [*], mas nao na estrada [.]");
			TimeUnit.SECONDS.sleep(2);
			System.out.println("É possível mudar de mapa, mas apenas em algumas direções!");
			TimeUnit.SECONDS.sleep(2);
			System.out.println("Use suas POKeBALLs para captura-los!");
			TimeUnit.SECONDS.sleep(2);
			System.out.println("Quanto mais dano tiverem tomado, mais facil sera.");
			TimeUnit.SECONDS.sleep(2);
			System.out.println("Prepare-se para iniciar sua aventura!");
			TimeUnit.SECONDS.sleep(2);
			System.out.println();
			// Chamada para o Mapa
			Map.move_map(Map.m_atual, trnr);
		} catch (Exception e) {
		}
	}
}
