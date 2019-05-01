package pokemon;

import java.util.Scanner;

public class Battle {
	public static void main(String[] agrs) {
		int i, j;
		Scanner scan = new Scanner(System.in);
		System.out.println("Escolha o seu nome jogador numero 1: ");
		String treinador = scan.nextLine();
		System.out.println("Seu nome é: " + treinador);
		System.out.println("Quantos pokemons vc vai ter :");
		int quantidade = Integer.parseInt(scan.nextLine());
		int ids[] = new int[quantidade];
		System.out.println("Escolha os ids dos seus pokemons :");
		for (i = 0; i < quantidade; i++) {
			ids[i] = Integer.parseInt(scan.nextLine());
		}
		Trainer treinador1 = new Trainer(treinador, ids);
		System.out.println("Time do " + treinador + ":");
		System.out.println(treinador1.getTeam());
		for (i = 1; i <= quantidade; i++) {
			for (j = 1; j <= 4; j++) {
				System.out.println("Escolha o " + j + " golpe do " + i + " pokemons :");
				String nameMove = scan.nextLine();
				treinador1.setMove(i - 1, j, nameMove);
			}
		}

		System.out.println("Escolha o seu nome jogador numero 2: ");
		treinador = scan.nextLine();
		System.out.println("Seu nome é: " + treinador);
		System.out.println("Quantos pokemons vc vai ter :");
		quantidade = Integer.parseInt(scan.nextLine());
		int ids2[] = new int[quantidade];
		System.out.println("Escolha os ids dos seus pokemons:");
		for (i = 0; i < quantidade; i++) {
			ids2[i] = Integer.parseInt(scan.nextLine());
		}
		Trainer treinador2 = new Trainer(treinador, ids2);
		System.out.println("Time do " + treinador + ":");
		System.out.println(treinador2.getTeam());
		for (i = 1; i <= quantidade; i++) {
			for (j = 1; j <= 4; j++) {
				System.out.println("Escolha o " + j + " golpe do " + i + " pokemons :");
				String nameMove = scan.nextLine();
				treinador2.setMove(i - 1, j, nameMove);
			}
		}
		
		
		
		
		//BATALHA 
		
		System.out.println(treinador1 + " escolha o numero do pokemon para começar a batalha:");
		int active1 = Integer.parseInt(scan.nextLine())-1;
		System.out.println(treinador2 + " escolha o numero do pokemon para começar a batalha:");
		int active2 = Integer.parseInt(scan.nextLine())-1;
		System.out.println("Começa a batalha:");
		for (i = 1; treinador1.getTeam() != null || treinador2.getTeam() != null; i++) {
			System.out.println("Turno " + i + ":");
			System.out.println(treinador1+" jogou o " + treinador1.getTeam(active1));
			System.out.println(treinador2+" jogou o " + treinador2.getTeam(active2));
			System.out.println(treinador1+" faça a sua jogada " );
			System.out.println("1:atacar  2:trocar pokemon  3:usar item   4:fugir" );
			int jogada1 = Integer.parseInt(scan.nextLine());
			
			switch (jogada1) {
			case 1:
				System.out.println("Escolha o seu ataque:");
				//mostrar para ele os ataques
				Move move = new Move();
				//enviar pokemon para o dano
				int damage1 = move.damage( treinador1.getTeam(active1), treinador2.getTeam(active2), move);
				break;
			case 2:
				System.out.println("Qual pokemon vc quer para substituir:" );
				int sub = Integer.parseInt(scan.nextLine());
				treinador1.shift(sub);
				break;
			case 3:
				System.out.println("Qual pokemon item vc quer usar e em qual pokemon:" );
				String item = scan.nextLine();
				int pokemonItem = Integer.parseInt(scan.nextLine());
				treinador1.useItem(item, treinador1.getTeam(pokemonItem));
				break;
			case 4:
				System.out.println("Nao e possivel fuigr de uma batalha seu covarde! \\m/" );
				//fazer um while
				break;
			}
			System.out.println(treinador2+" faça a sua jogada " );
			System.out.println("1:atacar  2:trocar pokemon  3:usar item   4:fugir" );
			int jogada2 = Integer.parseInt(scan.nextLine());
			
			switch (jogada) {
			case 1:
				System.out.println("Escolha o seu ataque:");
				//mostrar para ele os ataques
				int moveAttack = Integer.parseInt(scan.nextLine());

				Move move = new Move();
				//enviar pokemon para o dano
				int damage1 = move.damage( treinador2.getTeam(active2), treinador1.getTeam(active1), move);
				break;
			case 2:
				System.out.println("Qual pokemon vc quer para substituir:" );
				int sub = Integer.parseInt(scan.nextLine());
				treinador2.shift(sub);
				break;
			case 3:
				System.out.println("Qual pokemon item vc quer usar e em qual pokemon:" );
				String item = scan.nextLine();
				int pokemonItem = Integer.parseInt(scan.nextLine());
				treinador2.useItem(item, treinador1.getTeam(pokemonItem));
				break;
			case 4:
				System.out.println("Nao e possivel fuigr de uma batalha seu covarde! \\m/" );
				//fazer um while
				break;
			}
		}

		scan.close();
	}

}
