package pokemon;

import java.util.Scanner;

public class Map {
	static Scanner scan = new Scanner(System.in);
	static final char[][] m_atual = { 
			{' ',' ',' ',' ',' '},
			{' ',' ',' ',' ',' '},			
			{' ',' ',' ',' ',' '},
			{' ',' ',' ',' ',' '},			
			{' ',' ',' ',' ',' '},
			};
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
	public static void copia(char[][][][] map,char[][] m_atual,int m, int n) {
		System.out.println();
		for(int i=0;i<=4;i++) {
			for(int j=0;j<=4;j++)  {
				m_atual[i][j]=map[m][n][i][j];
			}
		}
	}
	public static String move_map() {
		int continua=0,i=3,j=2,m=2,n=0;
		String move = " ";
		copia(mm,m_atual,m,n);
		while(continua==0) {
			imprime(m_atual);
			System.out.println("Escolha a sua direcao: ");
			move = scan.nextLine();
			switch(move) {
				case "u":
					if(verifica(i+1,j,m,n)) {
						if(m_atual[i+1][j]=='p') {
							continua=0;
							break;
						}
						else {
							m_atual[3][j]='T';
							m++;
							i=3;
							continua=0;
						}
					}
					else { 
						m_atual[i+1][j]=m_atual[i][j];
						m_atual[i][j]=mm[m][n][i][j];
						i++;
						continua=0;
					}
				case "r":
					if(verifica(i,j+1,m,n)) {
						if(m_atual[i][j+1]=='p') {
							continua=0;
							break;
						}
						else {
							m_atual[i][1]='T';
							n++;
							j=1;
							continua=0;
						}
					}
					else {
						m_atual[i][j+1]=m_atual[i][j];
						m_atual[i][j]=mm[m][n][i][j];
						j++;
						continua=0;
					}
				case "l":
					if(verifica(i,j-1,m,n)) {
						if(m_atual[i][j-1]=='p') {
							continua=0;
							break;
						}
						else {
							m_atual[i][3]='T';
							n--;
							j=3;
							continua=0;
						}
					}
					else {
						m_atual[i][j-1]=m_atual[i][j];
						m_atual[i][j]=mm[m][n][i][j];
						j--;
						continua=1;
					}
				case "d":
					if(verifica(i-1,j,m,n)) {
						if(m_atual[i-1][j]=='p') {
							continua=0;
							break;
						}
						else {
							m_atual[1][j]='T';
							m--;
							i=1;
							continua=0;
						}
					}
					else {
						m_atual[i-1][j]=m_atual[i][j];
						m_atual[i][j]=mm[m][n][i][j];
						i--;
						continua=0;
					}
				case "s":
					System.out.println("A aventura acabou!");
					continua=1;
			}
		}
		return move;
	}
	public static boolean verifica(int i, int j,int m,int n) {
		switch(m_atual[i][j]) {
		case 'u':
			copia(mm,m_atual,m+1,n);
			return true;
		case 'r':
			copia(mm,m_atual,m,n+1);
			return true;
		case 'l':
			copia(mm,m_atual,m,n-1);
			return true;
		case 'd':
			copia(mm,m_atual,m-1,n);
			return true;
		case 'p':
			System.out.println("Nao e posivel ir por esse caminho escoha outra opcao");
			return true;
	}
		return false;
	}
	public static void main(String[] args) {
		move_map();
	}
}
