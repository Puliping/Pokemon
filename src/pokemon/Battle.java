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
		System.out.println("Escolha os golpes dos seus Pokémons:");
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
	
	public static void main(String[] agrs) {
		int i, j;
		Scanner scan = new Scanner(System.in);
		
		Trainer trnr1 = setTrainer(1);
		Trainer trnr2 = setTrainer(2);
		
		
		// BATALHA
		
		int active1 = 0, active2 = 0;
		System.out.println("Começa a batalha:");
		for (i = 1; trnr1.getTeam().size() > 0 && trnr2.getTeam().size() > 0; i++) {
			System.out.println("Turno " + i + ":");
			System.out.println(trnr1 + " jogou o " + trnr1.getTeam(active1));
			System.out.println(trnr2 + " jogou o " + trnr2.getTeam(active2));
			System.out.println(trnr1 + " faça a sua jogada ");
			System.out.println("1:atacar  2:trocar pokemon  3:usar item   4:fugir");
			int jogada1 = Integer.parseInt(scan.nextLine());
			
			switch (jogada1) {
			case 1:
				System.out.println("Escolha o seu ataque:");
				// mostrar para ele os ataques
				Move move = new Move();
				// enviar pokemon para o dano
				int damage1 = move.damage(trnr1.getTeam(active1), trnr2.getTeam(active2), move);
				break;
			case 2:
				System.out.println("Qual pokemon vc quer para substituir:");
				int sub = Integer.parseInt(scan.nextLine());
				trnr1.shift(sub);
				break;
			case 3:
				System.out.println("Qual pokemon item vc quer usar e em qual pokemon:");
				int item = Integer.parseInt(scan.nextLine());
				int pokemonItem = Integer.parseInt(scan.nextLine());
				trnr1.useItem(item, trnr1.getTeam(pokemonItem));
				break;
			case 4:
				System.out.println("Nao e possivel fuigr de uma batalha seu covarde! \\m/");
				// fazer um while
				break;
			}
			System.out.println(trnr2 + " faça a sua jogada ");
			System.out.println("1:atacar  2:trocar pokemon  3:usar item   4:fugir");
			int jogada2 = Integer.parseInt(scan.nextLine());
			
			switch (jogada2) {
			case 1:
				System.out.println("Escolha o seu ataque:");
				// mostrar para ele os ataques
				int moveAttack = Integer.parseInt(scan.nextLine());
				
				Move move = new Move();
				// enviar pokemon para o dano
				int damage1 = move.damage(trnr2.getTeam(active2), trnr1.getTeam(active1), move);
				break;
			case 2:
				System.out.println("Qual pokemon vc quer para substituir:");
				int sub = Integer.parseInt(scan.nextLine());
				trnr2.shift(sub);
				break;
			case 3:
				System.out.println("Qual pokemon item vc quer usar e em qual pokemon:");
				int item = Integer.parseInt(scan.nextLine());
				int pokemonItem = Integer.parseInt(scan.nextLine());
				trnr2.useItem(item, trnr1.getTeam(pokemonItem));
				break;
			case 4:
				System.out.println("Nao e possivel fuigr de uma batalha seu covarde! \\m/");
				// fazer um while
				break;
			}
		}
		
		scan.close();
	}
	
}
