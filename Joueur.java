import java.awt.Color;
import java.util.Scanner;

import edu.princeton.cs.introcs.StdDraw;


public class Joueur {
	static Scanner sc= new Scanner (System.in);

	public int j;
	public int i;
	public String nom;

	// constructeur
	public Joueur(){
		nom = null;
		j = 0;
		i = 0;
	}

	public Joueur( int pj , int pi, String pnom){
		nom = pnom;
		j = pj;
		i = pi;
	}

	public Joueur( int pj , int pi){
		j = pj;
		i = pi;
	}

	// Les Acesseurs
	public int getI() {
		return i;
	}

	public int getJ() {
		return j;
	}

	public String getNom() {
		return nom;
	}






	public static String nomJoueur(Joueur joueur){
		System.out.print("entrez le nom du joueur");
		joueur.nom = sc.nextLine();
		return joueur.nom;
	}
	
	public static void nom(Joueur joueur){
		System.out.print(joueur.nom);
		System.out.println (" a toi de jouer");
	}


	public static void positionJoueur(char [] [] tab, Joueur a){
		if (tab[a.i][a.j]=='r'){
			tab[a.i][a.j] = 'R';
		}
		if (tab[a.i][a.j]=='b'){
			tab[a.i][a.j] = 'B';
		}
		if (tab[a.i][a.j]=='o'){
			tab[a.i][a.j] = 'O';
		}
		if (tab[a.i][a.j]=='j'){
			tab[a.i][a.j] = 'J';
		}
		if (tab[a.i][a.j]=='v'){
			tab[a.i][a.j] = 'V';
		}
		if (tab[a.i][a.j]=='i'){
			tab[a.i][a.j] = 'I';
		}
	}




	public static char choixJoueur(char tab[][], Joueur joueur){
		char choix = tab [joueur.i][joueur.j];
		System.out.print("choisi ta couleur r,o,j,v,b,i et differente de ton adversaire qui est ");
		System.out.println(choix);
		String couleur1 = sc.nextLine();
		char couleur = couleur1.charAt(0);
		couleur = Tableau.convertirMajuscule(couleur);
		if (couleur != 'R' && couleur != 'O' && couleur != 'J'&& couleur != 'V'
				&& couleur != 'B'&& couleur != 'I' ){
			System.out.println("tu as mal choisi tu n'as pas choisi de couleur");
			couleur = choixJoueur( tab,  joueur);
			return couleur;
		}
		if(couleur == choix){
			System.out.println("tu as mal choisi tu as choisi la meme couleur que ton adversaire");
			couleur = choixJoueur( tab,  joueur);
			return couleur;
		}
		else{
			return couleur;
		}
	}
	
	public static char choixAleatoire(char tab[][], Joueur joueur){
		char choix = tab [joueur.i][joueur.j];
		char couleur = Tableau.generateLettreAleatoire(1);
		couleur = Tableau.convertirMajuscule(couleur);
		if (couleur != 'R' && couleur != 'O' && couleur != 'J'&& couleur != 'V'
				&& couleur != 'B'&& couleur != 'I' ){
			couleur = choixJoueur( tab,  joueur);
			return couleur;
		}
		if(couleur == choix){
			couleur = choixJoueur( tab,  joueur);
			return couleur;
		}
		else{
			return couleur;
		}
	}
}

