package pokemon;

import java.util.Scanner;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Wild {
	private static final int MAXPKMN = 65; // Numero de pokemons programados
	static Scanner scan = new Scanner(System.in);
	static Random rand = new Random();
	static int[] potQty = { 5, 3, 2, 1 }; // Potion, Super, Hyper, Max
	static int[] ballQty = { 4, 3, 1, 0 }; // Pokeball, Great, Ultra, Master
	static int c = 0;
	
	static boolean caught(int id, Pokemon pkmn) {
		int m, f, ball = 12;
		switch (id) {
		case 2:
			ball = 8;
		case 4:
			return true;
		}
		m = rand.nextInt(256);
		f = (pkmn.maxHP * 255 * 4) / (pkmn.hp * ball);
		if (f >= m)
			return true;
		else
			return false;
	}
	
	static int escape(Trainer trnr, Pokemon pkmn) {
		int f, b;
		c++;
		b = (int) ((pkmn.speed / 4.0) % 256);
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
			System.out.println("Resolvendo turno...");
		}
		System.out.println("<< Fim da Batalha >>");
		if (trnr.getTeam().size() > 0) {
			System.out.println(trnr + " ganhou!");
		} else {
			System.out.println(wild + " ganhou!");
		}
		
	}
	
	static void printBag() {
		System.out.println("Escolha o item");
		if (potQty[0] > 0)
			System.out.println("[1] Potion (" + potQty[0] + ")");
		if (potQty[1] > 0)
			System.out.println("[2] Super Potion (" + potQty[1] + ")");
		if (potQty[2] > 0)
			System.out.println("[3] Hyper Potion (" + potQty[2] + ")");
		if (potQty[3] > 0)
			System.out.println("[4] Max Potion (" + potQty[3] + ")");
		if (ballQty[0] > 0)
			System.out.println("[5] Potion (" + ballQty[0] + ")");
		if (ballQty[1] > 0)
			System.out.println("[6] Super Potion (" + ballQty[1] + ")");
		if (ballQty[2] > 0)
			System.out.println("[7] Hyper Potion (" + ballQty[2] + ")");
		if (ballQty[3] > 0)
			System.out.println("[8] Max Potion (" + ballQty[3] + ")");
	}
	
	private static int[] turnChoice(Trainer trnr, Trainer opp) {
		int[] res = new int[3];
		for (boolean ok = false; !ok;) {
			Battle.printAction();
			try {
				res[0] = Integer.parseInt(scan.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Escolha invalida...");
				continue;
			}
			switch (res[0]) {
			case 1:
				Battle.printFight(trnr);
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
				printBag();
				try {
					res[1] = Integer.parseInt(scan.nextLine());
				} catch (NumberFormatException e) {
					System.out.println("Escolha invalida...");
					break;
				}
				if (res[1] < 1 || res[1] > 8 || (res[1] < 5 && potQty[res[1]] < 1)
						|| (res[1] > 4 && ballQty[res[1]] < 1)) {
					System.out.println("Escolha invalida...");
					break;
				}
				res[2] = trnr.useItem(res[1]);
				ok = true;
				break;
			case 3:
				Battle.printPokemon(trnr);
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
			}
		}
		return res;
	}
	
	private static int[] wildChoice(Trainer wild, Trainer trnr) {
		int[] res = new int[3];
		if (rand.nextInt(256) == 255)
			res[0] = 4;
		else {
			res[0] = 1;
			res[1] = rand.nextInt(4) + 1;
			res[2] = wild.getMove(res[1]).damage(wild.getTeam(wild.getActive()), trnr.getTeam(trnr.getActive()));
		}
		return res;
	}
	
	static Trainer setWild(int id) {
		Trainer wild = new Trainer("POKeMON selvagem");
		wild.addToTeam(id);
		return wild;
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
			System.out.println("Ja eu... Eu estudo POKeMONs como profissao.");
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
			for (;;)
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
			trnr.addToTeam(starter.getTeam(choice - 1).id);
			System.out.println("Certo! Voce escolheu " + trnr.getTeam(0).toString().toUpperCase() + ".");
			TimeUnit.SECONDS.sleep(2);
			System.out.println("Lembre-se! POKeMONs podem te atacar na grama alta (*), mas nao na estrada (.)");
			TimeUnit.SECONDS.sleep(2);
			System.out.println("Use suas POKeBALLs para captura-los! Quanto mais dano tiverem tomado, mais facil sera.");
			TimeUnit.SECONDS.sleep(2);
			System.out.println("Prepare-se para iniciar sua aventura!");
			TimeUnit.SECONDS.sleep(2);
			// Chamada pro mapa
		} catch (Exception e) {
		}
	}
}
