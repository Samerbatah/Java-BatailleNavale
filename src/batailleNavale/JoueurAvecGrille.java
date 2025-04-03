package batailleNavale;

public abstract class JoueurAvecGrille extends Joueur {

	private GrilleNavale grille;

	public JoueurAvecGrille(GrilleNavale g, String nom) {
		super(g.getTaille(),nom);
		this.grille = g;

	}

	public JoueurAvecGrille(GrilleNavale g) {
		this(g, "joueur");

	}


	public GrilleNavale getGrille() {
		return grille;
	}

	public int defendre(Coordonnee c) {
		grille.recoitTir(c);
		if (grille.estTouche(c)) {
			return Joueur.TOUCHE;
		}
		if (grille.estCoule(c)) {
			return Joueur.COULE;
		}
		if (grille.perdu()) {
			return Joueur.GAMEOVER;
		} else {
			return Joueur.A_L_EAU;
		}
	}
}