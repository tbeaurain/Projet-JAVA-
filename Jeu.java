import java.awt.Color;
import java.awt.Font;
import java.util.Scanner;

import edu.princeton.cs.introcs.StdDraw;

public class Jeu {
	static Scanner sc= new Scanner (System.in);

	public static char [][] changementChoix(char tab[][], Joueur joueur, char choix, char position){
		char valeur = tab[joueur.i][joueur.j];
		for (int y = 0; y < tab.length; y++) {
			for (int x = 0; x < tab[y].length; x++) {
				if (tab[y][x]==valeur && tab [y][x] != position){
					tab[y][x]=choix;
				}
			}
		}
		return tab;
	}

	public static  char[][] avancementCaseParCase(char tab [] [], Joueur joueur, char choix, int x, int y){
		if (x >=0 && x< tab.length){
			if (y-1 >=0 && y< tab[x].length  ){
				if( Tableau.convertirMinuscule(tab[x][y-1])== choix && tab[x][y-1] != Tableau.convertirMajuscule(tab[x][y-1])){
					tab[x][y-1]= choix ;
					tab[x][y-1]= Tableau.convertirMajuscule(tab[x][y-1]);
					avancementCaseParCase( tab ,  joueur,  choix, x,  y-1);
				}
			}
		}
		if (x >=0 && x< tab.length ){
			if (y >=0 && y < tab[x].length-1){
				if( Tableau.convertirMinuscule(tab[x][y+1])== choix && tab[x][y+1] != Tableau.convertirMajuscule(tab[x][y+1])  ){
					tab[x][y+1]= choix;
					tab[x][y+1]= Tableau.convertirMajuscule(tab[x][y+1]);
					avancementCaseParCase( tab ,  joueur,  choix, x,  y+1);
				}
			}
		}
		if (x >=0 && x< tab.length-1){
			if (y >=0 && y< tab[x].length){
				if( Tableau.convertirMinuscule(tab[x+1][y])== choix && tab[x+1][y] != Tableau.convertirMajuscule(tab[x+1][y]) ){
					tab[x+1][y]= choix;
					tab[x+1][y]= Tableau.convertirMajuscule(tab[x+1][y]);
					avancementCaseParCase( tab ,  joueur,  choix, x+1,  y);
				}
			}
		}
		if (x-1 >=0 && x< tab.length){
			if (y >=0 && y< tab[x].length){
				if( Tableau.convertirMinuscule(tab[x-1][y])== choix && tab[x-1][y] != Tableau.convertirMajuscule(tab[x-1][y]) ){
					tab[x-1][y]= choix;
					tab[x-1][y]= Tableau.convertirMajuscule(tab[x-1][y]);
					avancementCaseParCase( tab ,  joueur,  choix, x-1,  y);
				}
			}
		}
		return tab;

	}

	public static char[][] avancementJoueur(char tab [] [], Joueur joueur, char choix, char position){
		choix = Tableau.convertirMinuscule(choix);
		tab=changementChoix(tab, joueur,choix, position);
		int x=joueur.i;
		int y=joueur.j;

		if (x >=0 && x< tab.length){
			if (y-1 >=0 && y< tab[x].length){
				if( Tableau.convertirMinuscule(tab[x][y-1])== choix && tab[x][y-1] != Tableau.convertirMajuscule(tab[x][y-1]) ){
					tab[x][y-1]= choix ;
					tab[x][y-1]= Tableau.convertirMajuscule(tab[x][y-1]);
					avancementCaseParCase( tab ,  joueur,  choix, x,  y-1);
				}
			}
		}
		if (x >=0 && x< tab.length){
			if (y >=0 && y< tab[x].length-1){
				if( Tableau.convertirMinuscule(tab[x][y+1])== choix && tab[x][y+1] != Tableau.convertirMajuscule(tab[x][y+1]) ){
					tab[x][y+1]= choix;
					tab[x][y+1]= Tableau.convertirMajuscule(tab[x][y+1]);
					avancementCaseParCase( tab ,  joueur,  choix, x,  y+1);
				}
			}
		}
		if (x >=0 && x< tab.length -1){
			if (y >=0 && y< tab[x].length){
				if( Tableau.convertirMinuscule(tab[x+1][y])== choix && tab[x+1][y] != Tableau.convertirMajuscule(tab[x+1][y]) ){
					tab[x+1][y]= choix;
					tab[x+1][y]= Tableau.convertirMajuscule(tab[x+1][y]);
					avancementCaseParCase( tab ,  joueur,  choix, x+1,  y);
				}
			}
		}
		if (x-1 >=0 && x< tab.length){
			if (y >=0 && y< tab[x].length){
				if( Tableau.convertirMinuscule(tab[x-1][y])== choix && tab[x-1][y] != Tableau.convertirMajuscule(tab[x-1][y])){
					tab[x-1][y]= choix;
					tab[x-1][y]= Tableau.convertirMajuscule(tab[x-1][y]);
					avancementCaseParCase( tab ,  joueur,  choix, x-1,  y);
				}
			}
		}
		choix = Tableau.convertirMajuscule(choix);
		tab[joueur.i][joueur.j]= choix;
		return tab;

	}

	public static boolean gagner(char [][] tab, boolean victoire, char choix){
		int longueur = tab.length*tab.length ;
		int test = 0;
		for (int y = 0; y < tab.length; y++) {
			for (int x = 0; x < tab[y].length; x++) {
				if (tab[y][x]==choix){
					test++;
				}
			}
		}
		if(test > Math.ceil(longueur/2)){
			victoire = true;
			System.out.println("tu as gagné");
		}
		return victoire;
	}

	public static boolean joueur1VSjoueur2(char [][] tab, boolean victoire, Joueur joueur1, Joueur joueur2){
		int i =0;
		Tableau.remplirTab(tab, joueur1, joueur2);
		Joueur.positionJoueur(tab, joueur1);
		Joueur.positionJoueur(tab, joueur2);
		while(victoire==false){
			if ( i%2==0){
				Tableau.printSeparator();
				Tableau.printTabConsole( tab);
				Tableau.print(tab);

				Joueur.nom(joueur1);
				char position= tab[joueur2.i][joueur2.j] ;
				position = Tableau.convertirMinuscule(position);

				char choix = Joueur.choixJoueur(tab, joueur2);
				tab = avancementJoueur(tab, joueur1, choix, position);

				victoire=gagner(tab, victoire, choix);

			}
			if ( i%2==1){
				Tableau.printSeparator();
				Tableau.printTabConsole( tab);		
				Tableau.print(tab);
				
				Joueur.nom(joueur2);
				char position= tab[joueur1.i][joueur2.j] ;

				char choix = Joueur.choixJoueur(tab, joueur1);
				tab = avancementJoueur(tab, joueur2, choix, position);

				victoire=gagner(tab, victoire, choix);
			}
			i++;

		}
		return victoire;
	}
	
	public static boolean joueurVSia(char [][] tab, boolean victoire, Joueur joueur1, Joueur joueur2){
		int i =0;
		Tableau.remplirTab(tab, joueur1, joueur2);
		Joueur.positionJoueur(tab, joueur1);
		Joueur.positionJoueur(tab, joueur2);
		while(victoire==false){
			if ( i%2==0){
				Joueur.nom(joueur1);
				Joueur.positionJoueur(tab, joueur1);

				Tableau.printSeparator();
				Tableau.printTabConsole( tab);

				char position= tab[joueur2.i][joueur2.j] ;
				position = Tableau.convertirMinuscule(position);

				char choix = Joueur.choixJoueur(tab, joueur2);
				tab = avancementJoueur(tab, joueur1, choix, position);

				victoire=gagner(tab, victoire, choix);

			}
			if ( i%2==1){
				
				Joueur.positionJoueur(tab, joueur2);

				Tableau.printSeparator();
				Tableau.printTabConsole( tab);		

				char position= tab[joueur1.i][joueur2.j] ;
				System.out.println("l'ordinateur a jouer");
				char choix = Joueur.choixAleatoire(tab, joueur1);
				tab = avancementJoueur(tab, joueur2, choix, position);

				victoire=gagner(tab, victoire, choix);
				
			}
			i++;

		}
		return victoire;
	}


	public static void main (String [] agrs){ 
		System.out.println("Choisi la taille de ton carré");
		int x = sc.nextInt();
		int y = x;
		char defaut = '-' ;
		char [] [] tab  = Tableau.createTad(x , y, defaut );
		
		boolean victoire = false;
		
		Joueur numero1 = new Joueur(0, tab.length-1);
		Joueur numero2  = new Joueur(tab.length-1, 0 );
		Joueur numero3 = new Joueur(tab.length-1, tab.length-1);
		Joueur numero4  = new Joueur(0, 0 );

		System.out.println("Joueur contre ordinateur taper 0");
		System.out.println("Joueur contre ami taper 1");
		int choix = sc.nextInt();

		while( victoire == false){
			
			if (choix ==1){
				numero1.nom=Joueur.nomJoueur(numero1 );
				numero2.nom=Joueur.nomJoueur(numero2 );
			victoire =joueur1VSjoueur2(tab,victoire, numero1, numero2);
			}
			
			if (choix ==0){
				numero1.nom=Joueur.nomJoueur(numero1 );
				numero2.nom="ordinateur";
				victoire = joueurVSia(tab,victoire, numero1, numero2);
			}

			if (victoire==true){
				System.out.println("La grille finalle");
				Tableau.printSeparator();
				Tableau.printTabConsole( tab);
				Tableau.print(tab);

			}
		}

	}
}