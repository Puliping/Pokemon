package pokemon;

import java.util.Scanner;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Wild {
	private static final int MAXPKMN = 65;
	static Scanner scan = new Scanner(System.in);

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
//			TimeUnit.SECONDS.sleep(5);
//			System.out.println("\n\n\n\n\n\n\n\n\n\n");
//			System.out.println("Olá! Bem-vindo ao mundo de POKéMON!");
//			TimeUnit.SECONDS.sleep(2);
//			System.out.println("Meu nome é OAK! As pessoas me chamam de prof. POKéMON!");
//			TimeUnit.SECONDS.sleep(2);
//			System.out.println("Esse mundo é habitado por criaturas chamadas POKéMON!");
//			TimeUnit.SECONDS.sleep(2);
//			System.out.println("Para algumas pessoas, POKéMONs são pets. Outros, os usam em lutas.");
//			TimeUnit.SECONDS.sleep(2);
//			System.out.println("Já eu... Eu estudo POKéMONs como profissão.");
//			TimeUnit.SECONDS.sleep(2);
			System.out.println("Primeiramente, qual seu nome?");
			String name = scan.nextLine().toUpperCase();
			Trainer trnr = new Trainer(name);
			System.out.println("Certo! Então seu nome é " + name + ".");
//			TimeUnit.SECONDS.sleep(2);
//			System.out.println(".");
//			TimeUnit.SECONDS.sleep(2);
//			System.out.println("..");
//			TimeUnit.SECONDS.sleep(2);
//			System.out.println("...");
//			TimeUnit.SECONDS.sleep(2);
//			System.out.println(name + "!");
//			TimeUnit.SECONDS.sleep(2);
//			System.out.println("Sua própria lenda POKéMON está prestes a começar!");
//			TimeUnit.SECONDS.sleep(2);
//			System.out.println("Um mundo de sonhos e aventuras com POKéMON espera! Vamos lá!");
//			TimeUnit.SECONDS.sleep(2);
			System.out.println("Escolha seu POKéMON iniciante!");
			TimeUnit.SECONDS.sleep(1);
			int r1, r2, r3;
			Random rand = new Random();
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
			System.out.println("Certo! Você escolheu " + trnr.getTeam(0).toString().toUpperCase() + ".");
			
		} catch (Exception e) {
		}
	}
}
