package batailleNavale;

public class JoueurAuto extends JoueurAvecGrille {

	public JoueurAuto(GrilleNavale g, String nom) {
		super(g, nom);
	}

	public JoueurAuto(GrilleNavale g) {
		super(g);

	}

	protected void retourAttaque(Coordonnee c, int etat) {
		String resultat = "";

		if (etat == Joueur.TOUCHE) {
			resultat = "Super, le navire est touché";
		} else if (etat == Joueur.COULE) {
			resultat = "Vous avez coulé un navire";
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
			resultat = "oups, le navire a étais touché";
		} else if (etat == Joueur.COULE) {
			resultat = "le navire est coulé";
		} else if (etat == Joueur.A_L_EAU) {
			resultat = "Youpi, c'est à l'eau";
		} else if (etat == Joueur.GAMEOVER) {
			resultat = "Vous avez gagné";
		}

		System.out.println("Attaque d'ennemi en " + c + ": " + resultat);

	}

	public Coordonnee choisirAttaque() {
		
		Coordonnee coordonneeAttaquee;
		int randomLigne = (int) (Math.random() * (this.getTailleGrille()));
		int randomColonne = (int) (Math.random() * (this.getTailleGrille()));
		coordonneeAttaquee = new Coordonnee(randomLigne, randomColonne);
		return coordonneeAttaquee;

		
	}
	
	

	public static void main(String[] args) {
	
		
	}
}
