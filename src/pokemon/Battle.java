package pokemon;

import java.util.Scanner;

public class Battle {
	public static void main(String[] agrs) {
		int i;
		Scanner scan = new Scanner(System.in);
		System.out.println("Escolha o seu nome jogaor numero 1: ");
		String treinador= scan.nextLine();
		System.out.println("Seu nome é: " + treinador);
		System.out.println("Quantos pokemons vc vai ter :");
		int quantidade = Integer.parseInt(scan.nextLine());
		int ids[] = new int[quantidade];
		System.out.println("Escolha os ids dos seus pokemons :");
		for(i=0;i<quantidade;i++) {
			ids[i]= Integer.parseInt(scan.nextLine());
		}
		Trainer treinador1 = new Trainer(treinador,ids);
		System.out.println("Time do " + treinador +":" );
		System.out.println(treinador1.getTeam());
		
		
		
		
		System.out.println("Escolha o seu nome jogaor numero 2: ");
		treinador= scan.nextLine();
		System.out.println("Seu nome é: " + treinador);
		System.out.println("Quantos pokemons vc vai ter :");
		quantidade = Integer.parseInt(scan.nextLine());
		int ids2[] = new int[quantidade];
		System.out.println("Escolha os ids dos seus pokemons:");
		for(i=0;i<quantidade;i++) {
			ids2[i]= Integer.parseInt(scan.nextLine());
		}
		Trainer treinador2 = new Trainer(treinador,ids2);
		System.out.println("Time do " + treinador +":" );
		System.out.println(treinador2.getTeam());
		
		
	}

}
