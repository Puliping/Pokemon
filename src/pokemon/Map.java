package pokemon;

import java.util.Scanner;

public class Map {
	static Scanner scan = new Scanner(System.in);
	static char[][] m_atual = { 
			{' ',' ',' ',' ',' '},
			{' ',' ',' ',' ',' '},			
			{' ',' ',' ',' ',' '},
			{' ',' ',' ',' ',' '},			
			{' ',' ',' ',' ',' '},
			};
	static final char[][] m1 = { 
			{'p','u','u','u','p'},
			{'p','*','.','*','r'},
			{'p','*','.','*','r'},
			{'p','*','.','*','r'},
			{'p','p','p','p','p'},
			};
	static final char[][] m2 = { 
			{'p','u','u','u','p'},
			{'l','*','.','*','r'},
			{'l','.','.','.','r'},
			{'l','*','*','*','r'},
			{'p','p','p','p','p'},
			};
	static final char[][] m3 = { 
		    {'p','u','u','u','p'},
			{'l','*','*','.','p'},
			{'l','.','.','.','p'},
			{'l','*','*','*','p'},
			{'p','p','p','p','p'},
			};
	static final char[][] m4 = { 
			{'p','u','u','u','p'},
			{'p','*','*','*','r'},
			{'p','*','.','.','r'},
			{'p','*','.','*','r'},
			{'d','d','d','d','p'}
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
			{'p','*','g','*','r'},
			{'p','*','*','*','r'},
			{'p','d','d','d','p'}
			};
	static final char[][] m8 = { 
			{'p','p','p','p','p'},
			{'l','*','*','*','r'},
			{'l','*','i','.','r'},
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
	public static boolean wildpkmn(char[][][][] map,int i , int j,int m,int n) {
		if(map[m][n][i][j]=='*') {
			if(Math.random()>=0.8) {
				System.out.println("Um pokemon selvagem apareceu");
				return true;
			}
			return false;
		}
		return false;
	}
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
	public static void copia(char[][][][] map,char[][] m_atual,int m, int n) {
		System.out.println();
		for(int i=0;i<=4;i++) {
			for(int j=0;j<=4;j++)  {
				m_atual[i][j]=map[m][n][i][j];
			}
		}
	}
	public static String move_map(char[][] map) {
		int continua=0,i=3,j=2,m=2,n=0;
		String move = " ";
		copia(mm,map,m,n);
		map[i][j]='T';
		while(continua==0) {
			imprime(map);
			wildpkmn(mm,i ,j,m,n);
			System.out.println("Escolha a sua direcao: ");
			move = scan.nextLine();
			switch(move) {
				case "u":
					if(verifica(i-1,j,m,n)) {
						if(mm[m][n][i-1][j]=='p') {
							continua=0;
						}
						else {
							map[3][j]='T';
							m--;
							i=3;
							continua=0;
						}
					}
					else { 
						map[i-1][j]=map[i][j];
						map[i][j]=mm[m][n][i][j];
						i--;
						continua=0;				
					}
					break;
				case "r":
					if(verifica(i,j+1,m,n)) {
						if(mm[m][n][i][j+1]=='p') {
							continua=0;
						}
						else {
							map[i][1]='T';
							n++;
							j=1;
							continua=0;
						}
					}
					else {
						map[i][j+1]=map[i][j];
						map[i][j]=mm[m][n][i][j];
						j++;
						continua=0;
					}
					break;
				case "l":
					if(verifica(i,j-1,m,n)) {
						if(mm[m][n][i][j-1]=='p') {
							continua=0;
						}
						else {
							map[i][3]='T';
							n--;
							j=3;
							continua=0;
						}
					}
					else {
						map[i][j-1]=map[i][j];
						map[i][j]=mm[m][n][i][j];
						j--;
						continua=0;
					}
					break;
				case "d":
					if(verifica(i+1,j,m,n)) {
						if(mm[m][n][i+1][j]=='p') {
							continua=0;
						}
						else {
							map[1][j]='T';
							m++;
							i=1;
							continua=0;
						}
					}
					else {
						map[i+1][j]=map[i][j];
						map[i][j]=mm[m][n][i][j];
						i++;
						continua=0;
					}
					break;
			}
		}
		return move;
	}
	public static boolean verifica(int i, int j,int m,int n) {
		switch(m_atual[i][j]) {
		case 'u':
			copia(mm,m_atual,m-1,n);
			return true;
		case 'r':
			copia(mm,m_atual,m,n+1);
			return true;
		case 'l':
			copia(mm,m_atual,m,n-1);
			return true;
		case 'd':
			copia(mm,m_atual,m+1,n);
			return true;
		case 'p':
			System.out.println("Nao e posivel ir por esse caminho escolha outra opcao");
			return true;
	}
		return false;
	}
	public static void main(String[] args) {
		move_map(m_atual);
	}
}