package pokemon;

import java.util.Random;
import java.util.Scanner;

public class Map {
	static Scanner scan = new Scanner(System.in);
	static Random rand = new Random();
	
	// @formatter:off
	static char[][] m_atual = {
			{' ',' ',' ',' ',' '},
			{' ',' ',' ',' ',' '},			
			{' ',' ',' ',' ',' '},
			{' ',' ',' ',' ',' '},			
			{' ',' ',' ',' ',' '}
			};
	static final char[][] m1 = { 
			{'p','u','u','u','p'},
			{'p','*','.','*','r'},
			{'p','*','.','*','r'},
			{'p','*','.','*','r'},
			{'p','p','p','p','p'}
			};
	static final char[][] m2 = { 
			{'p','u','u','u','p'},
			{'l','*','.','*','r'},
			{'l','.','.','.','r'},
			{'l','*','*','*','r'},
			{'p','p','p','p','p'}
			};
	static final char[][] m3 = { 
		    {'p','u','u','u','p'},
			{'l','*','*','.','p'},
			{'l','.','.','.','p'},
			{'l','*','*','*','p'},
			{'p','p','p','p','p'}
			};
	static final char[][] m4 = { 
			{'p','u','u','u','p'},
			{'p','*','*','*','r'},
			{'p','*','.','.','r'},
			{'p','*','.','*','r'},
			{'p','d','d','d','p'}
			};
	static final char[][] m5 = { 
			{'p','u','u','u','p'},
			{'l','*','*','*','r'},
			{'l','.','.','*','r'},
			{'l','*','.','*','r'},
			{'p','d','d','d','p'}
			};
	static final char[][] m6 = { 
			{'p','u','u','u','p'},
			{'l','*','.','*','p'},
			{'l','.','.','.','p'},
			{'l','.','*','.','p'},
			{'p','d','d','d','p'}
			};
	static final char[][] m7 = { 
			{'p','p','p','p','p'},
			{'p','*','*','*','r'},
			{'p','*','.','*','r'},
			{'p','*','*','*','r'},
			{'p','d','d','d','p'}
			};
	static final char[][] m8 = { 
			{'p','p','p','p','p'},
			{'l','*','*','*','r'},
			{'l','*','.','.','r'},
			{'l','*','*','*','r'},
			{'p','d','d','d','p'}
			};
	static final char[][] m9 = { 
			{'p','p','p','p','p'},
			{'l','*','*','*','p'},
			{'l','.','.','*','p'},
			{'l','*','.','*','p'},
			{'p','d','d','d','p'}
			};
	static final char[][][][] mm = {
			{m7,m8,m9},
			{m4,m5,m6},
			{m1,m2,m3}
			};
	// @formatter:on
	
	static String getAttackName(int n) {
		switch (n) {
		case 1:
			return "Pound";
		case 2:
			return "Karate Chop";
		case 3:
			return "Mega Punch";
		case 4:
			return "Fire Punch";
		case 5:
			return "Ice Punch";
		case 6:
			return "Thunder Punch";
		case 7:
			return "Razor Wind";
		case 8:
			return "Gust";
		case 9:
			return "Wing Attack";
		case 10:
			return "Vine Whip";
		case 11:
			return "Flamethrower";
		case 12:
			return "Hydro Pump";
		case 13:
			return "Surf";
		case 14:
			return "Quick Attack";
		case 15:
			return "Psybeam";
		case 16:
			return "Sludge";
		case 17:
			return "Earthquake";
		case 18:
			return "Rock Slide";
		case 19:
			return "Leech Life";
		case 20:
			return "Lick";
		case 21:
			return "Dragon Rage";
		default:
			return "Pound";
		}
	}
	
	public static void wildpkmn(char c, Trainer trnr) {
		if (c == '*') {
			if (rand.nextInt(256) > 200) {
				int id = rand.nextInt(Wild.MAXPKMN);
				Trainer wild = new Trainer("POKeMON selvagem");
				wild.addToTeam(id);
				for (int i = 1; i <= 4; i++) {
					String move = getAttackName(rand.nextInt(21) + 1);
					wild.setMove(0, i, move);
				}
				System.out.println("Um POKeMON selvagem apareceu!");
				Wild.battle(trnr, wild);
			}
		}
	}
	
	public static void imprime(char[][] map) {
		System.out.println();
		for (int i = 1; i <= 3; i++) {
			System.out.print("        |");
			for (int j = 1; j <= 3; j++) {
				System.out.print(map[i][j] + "|");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static void copia(char[][][][] map, char[][] m_atual, int m, int n) {
		for (int i = 0; i <= 4; i++) {
			for (int j = 0; j <= 4; j++) {
				m_atual[i][j] = map[m][n][i][j];
			}
		}
	}
	
	public static void move_map(char[][] map, Trainer trnr) {
		int continua = 0, i = 3, j = 2, m = 2, n = 0;
		String move;
		copia(mm, map, m, n);
		map[i][j] = 'T';
		System.out.println("W = cima; A = esquerda; S = baixo; D = direita; EXIT para sair.");
		while (continua == 0) {
			wildpkmn(mm[m][n][i][j], trnr);
			imprime(map);
			System.out.println("Escolha a sua direcao: ");
			move = scan.nextLine().toLowerCase();
			switch (move) {
			case "w":
				if (verifica(i - 1, j, m, n)) {
					if (mm[m][n][i - 1][j] == 'p') {
						continua = 0;
					} else {
						map[3][j] = 'T';
						m--;
						i = 3;
						continua = 0;
					}
				} else {
					map[i - 1][j] = map[i][j];
					map[i][j] = mm[m][n][i][j];
					i--;
					continua = 0;
				}
				break;
			case "d":
				if (verifica(i, j + 1, m, n)) {
					if (mm[m][n][i][j + 1] == 'p') {
						continua = 0;
					} else {
						map[i][1] = 'T';
						n++;
						j = 1;
						continua = 0;
					}
				} else {
					map[i][j + 1] = map[i][j];
					map[i][j] = mm[m][n][i][j];
					j++;
					continua = 0;
				}
				break;
			case "a":
				if (verifica(i, j - 1, m, n)) {
					if (mm[m][n][i][j - 1] == 'p') {
						continua = 0;
					} else {
						map[i][3] = 'T';
						n--;
						j = 3;
						continua = 0;
					}
				} else {
					map[i][j - 1] = map[i][j];
					map[i][j] = mm[m][n][i][j];
					j--;
					continua = 0;
				}
				break;
			case "s":
				if (verifica(i + 1, j, m, n)) {
					if (mm[m][n][i + 1][j] == 'p') {
						continua = 0;
					} else {
						map[1][j] = 'T';
						m++;
						i = 1;
						continua = 0;
					}
				} else {
					map[i + 1][j] = map[i][j];
					map[i][j] = mm[m][n][i][j];
					i++;
					continua = 0;
				}
				break;
			case "exit":
				System.out.println("Finalizando o jogo...");
				System.gc();
				return;
			}
		}
	}
	
	public static boolean verifica(int i, int j, int m, int n) {
		switch (m_atual[i][j]) {
		case 'u':
			copia(mm, m_atual, m - 1, n);
			return true;
		case 'r':
			copia(mm, m_atual, m, n + 1);
			return true;
		case 'l':
			copia(mm, m_atual, m, n - 1);
			return true;
		case 'd':
			copia(mm, m_atual, m + 1, n);
			return true;
		case 'p':
			System.out.println("Nao e posivel ir por esse caminho...");
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		Trainer trnr = new Trainer("Gabriel", 1);
		move_map(m_atual, trnr);
	}
}
