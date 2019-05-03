package pokemon;

import java.util.Scanner;

public class Map {
	static Scanner scan = new Scanner(System.in);
	static final char[][] m1 = { 
			{'u','u','u','u','u'},
			{'p','*',' ','*','r'},
			{'p','*',' ','*','r'},
			{'p','*','T','*','r'},
			{'p','p','p','p','p'},
			};
	static final char[][] m2 = { 
			{'u','u','u','u','u'},
			{'l','*',' ','*','r'},
			{'l',' ',' ',' ','r'},
			{'l','*','*','*','r'},
			{'p','p','p','p','p'},
			};
	static final char[][] m3 = { 
		    {'u','u','u','u','u'},
			{'l','*','*',' ','p'},
			{'l',' ',' ',' ','p'},
			{'l','*','*','*','p'},
			{'p','p','p','p','p'},
			};
	static final char[][] m4 = { 
			{'u','u','u','u','u'},
			{'p','*','*','*','r'},
			{'p','*',' ',' ','r'},
			{'p','*',' ','*','r'},
			{'d','d','d','d','d'}
			};
	static final char[][] m5 = { 
			{'u','u','u','u','u'},
			{'l','*','*','*','r'},
			{'l',' ',' ','*','r'},
			{'l','*',' ','*','r'},
			{'d','d','d','d','d'}
			};
	static final char[][] m6 = { 
			{'u','u','u','u','u'},
			{'l','*',' ','*','p'},
			{'l',' ',' ',' ','p'},
			{'l',' ','*',' ','p'},
			{'d','d','d','d','d'}
			};
	static final char[][] m7 = { 
			{'p','p','p','p','p'},
			{'p','*','*','*','r'},
			{'p','*','g','*','r'},
			{'p','*','*','*','r'},
			{'d','d','d','d','d'}
			};
	static final char[][] m8 = { 
			{'p','p','p','p','p'},
			{'l','*','*','*','r'},
			{'l','*','i',' ','r'},
			{'l','*','*','*','r'},
			{'d','d','d','d','d'}
			};
	static final char[][] m9 = { 
			{'p','p','p','p','p'},
			{'l','*','*','*','p'},
			{'l',' ',' ','*','p'},
			{'l','*',' ','*','p'},
			{'d','d','d','d','d'}
			};
	static final char[][][][] mm = {
			{m7,m8,m9},
			{m4,m5,m6},
			{m1,m2,m3}
	};
	public static void imprime(char[][] map) {
		System.out.println();
		for(int i=1;i<=3;i++) {
			System.out.print("        |");
			for(int j=1;j<=3;j++)  {
				System.out.print(map[i][j]+"|");
			}
			System.out.println();
		}
		System.out.println();
	}
	public static void move(char[][][][] map,int i, int j,int m,int n) {
		int continua=0;
		while(continua==0) {
			String move = scan.nextLine();
			continua = 0;
			switch(move) {
				case "u":
					if(verifica(map,i,j+1,m,n)) {
						map[m][n][i][j]=map[m][n][i][j+1];
					}
					else
						break;
				case "r":
					if(verifica(map,i+1,j,m,n)) {
						map[m][n][i][j]=map[m][n][i+1][j];
						continua=1;
					}
					else
						break;
				case "l":
					if(verifica(map,i-1,j,m,n)) {
						map[m][n][i][j]=map[m][n][i-1][j];
						continua=1;
					}
					else
						break;
				case "d":
					if(verifica(map,i,j-1,m,n)) {
						map[m][n][i][j]=map[m][n][i][j-1];
						continua=1;
					}
					else
						break;
			}
		}
	}
	public static boolean verifica(char[][][][] map,int i, int j,int m,int n) {
		switch(map[m][n][i][j]) {
		case 'u':
			map[m][n][i][j]=map[m+1][n][i][j];
		case 'r':
			map[m][n][i][j]=map[m][n+1][i][j];
		case 'l':
			map[m][n][i][j]=map[m][n-1][i][j];
		case 'd':
			map[m][n][i][j]=map[m-1][n][i][j];
		case 'p':
			System.out.println("Nao é posivel ir por esse caminho escoha outra opcao");
			return false;
	}
		return true;
	}
	public static void main(String[] args) {
		imprime(m1);
	}
}
