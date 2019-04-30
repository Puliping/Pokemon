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
				System.out.println("Escolha o " + i + " golpe do " + j + " pokemons :");
				String nameMove = scan.nextLine();
				treinador1.setMove(i, j, nameMove);
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
				System.out.println("Escolha o " + i + " golpe do " + j + " pokemons :");
				String nameMove = scan.nextLine();
				treinador2.setMove(i, j, nameMove);
			}
		}

	}

}
