package batailleNavale;

import java.util.Scanner;

public class JoueurTexte extends JoueurAvecGrille {

	private Scanner sc;

	public JoueurTexte(GrilleNavale g, String nom) {
		super(g, nom);
		sc = new Scanner(System.in);

	}

	public JoueurTexte(GrilleNavale g) {
		super(g);
		sc = new Scanner(System.in);
	}

	protected void retourAttaque(Coordonnee c, int etat) {
		String resultat = "";

		if (etat == Joueur.TOUCHE) {
			resultat = "Super, le navire est touch�";
		} else if (etat == Joueur.COULE) {
			resultat = "Vous avez coul� un navire";
		} else if (etat == Joueur.A_L_EAU) {
			resultat = "oups, c'est a l'eau";
		} else if (etat == Joueur.GAMEOVER) {
			resultat = "Vous avez perdu";
		}

		System.out.println("Attaque en " + c + ": " + resultat);

	}

	protected void retourDefense(Coordonnee c, int etat) {

		String resultat = "";

		if (etat == Joueur.TOUCHE) {
			resultat = "oups, le navire a �tais touch�";
		} else if (etat == Joueur.COULE) {
			resultat = "le navire est coul�";
		} else if (etat == Joueur.A_L_EAU) {
			resultat = "Youpi, c'est � l'eau";
		} else if (etat == Joueur.GAMEOVER) {
			resultat = "Vous avez gagn�";
		}

		System.out.println("Attaque d'ennemi en " + c + ": " + resultat);

	}

	public Coordonnee choisirAttaque() {

		System.out.println("Afin d'attaquer veuillez choisir une coordonn�e! exp: A3");
		String s = sc.nextLine();

		Coordonnee CoordonneeAttaque = new Coordonnee(s);

		return CoordonneeAttaque;
	}

	public static void main(String[] args) {

	}
}
