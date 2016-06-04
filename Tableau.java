import java.awt.Color;
import java.util.Random;

import edu.princeton.cs.introcs.StdDraw;



public class Tableau {

	public static char convertirMinuscule(char choix){
		if (choix=='R'){
			choix = 'r';
		}
		if (choix=='B'){
			choix = 'b';
		}
		if (choix=='O'){
			choix = 'o';
		}
		if (choix=='J'){
			choix = 'j';
		}
		if (choix=='V'){
			choix = 'v';

		}
		if (choix=='I'){
			choix = 'i';

		}
		return choix;
	}

	public static char convertirMajuscule( char choix ){
		if (choix=='r'){
			choix = 'R';
		}
		if (choix=='b'){
			choix = 'B';
		}
		if (choix=='o'){
			choix = 'O';
		}
		if (choix=='j'){
			choix = 'J';
		}
		if (choix=='v'){
			choix = 'V';

		}
		if (choix=='i'){
			choix = 'I';

		}
		return choix;
	}

	public static char[][] createTad(int tX, int tY, char defautChar) {
		char[][] tab = new char[tY][tX];

		for (int y = 0; y < tY; y++)
			for (int x = 0; x < tX; x++)
				tab[y][x] = defautChar;

		return tab;
	}


	public static void printTabConsole(char[][] tab) {
		for (int y = 0; y < tab.length; y++) {
			for (int x = 0; x < tab[y].length; x++) {
				System.out.print(tab[y][x]);
				System.out.print(" ");

			}
			System.out.println("");
		}
	}

	public static char generateLettreAleatoire(int length)
	{
		String chars = "rojvbi";
		char pass ='_';
		for(int x=0;x<length;x++)
		{
			int i = (int)(Math.random() * 6);
			pass = chars.charAt(i);
		}

		return pass;
	}

	public static void remplirTab(char [] [] tab, Joueur joueur1, Joueur joueur2){
		for (int y = 0; y < tab.length; y++) {
			for (int x = 0; x < tab[y].length; x++) {
				tab[y][x] = generateLettreAleatoire(1); 
				if (tab[joueur1.i][joueur1.j]==tab[joueur2.i][joueur2.j]){
					tab[y][x] = generateLettreAleatoire(1); 
				}
			}
		}
	}

	public static void print (char [][] tab) {
		float width = 0.01f;
		int X_MAX = tab.length-1;
		int Y_MAX =  tab.length-1;
		width = ((float)X_MAX*Y_MAX)/(2f*(float)(X_MAX*Y_MAX));
		StdDraw.setXscale(-width, X_MAX+width);
		StdDraw.setYscale(-width, Y_MAX+width);
		for (int i = 0; i <tab.length ; i++) {
			for (int j = 0 ; j < tab[i].length; j++) {
				if (tab[i][j]=='r' || tab[i][j]=='R' ){
					StdDraw.setPenColor(Color.RED);
				}
				if (tab[i][j]=='b'||tab[i][j]=='B' ){
					StdDraw.setPenColor(Color.BLUE);
				}
				if (tab[i][j]=='o' |tab[i][j]=='O'){
					StdDraw.setPenColor(Color.ORANGE);
				}
				if (tab[i][j]=='j'||tab[i][j]=='J'){
					StdDraw.setPenColor(Color.YELLOW);
				}
				if (tab[i][j]=='v'||tab[i][j]=='V'){
					StdDraw.setPenColor(Color.GREEN);
				}
				if (tab[i][j]=='i' ||tab[i][j]=='I'){
					StdDraw.setPenColor(Color.CYAN);
				}
				StdDraw.filledCircle(i, j, width);
			}
		}

	}

	public static void printSeparator() {
		System.out.println("\n\n---------------------------\n\n");
	}


}



