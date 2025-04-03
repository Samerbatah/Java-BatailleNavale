package batailleNavale;

	public abstract class Joueur {
		public final static int TOUCHE = 1;
		public final static int COULE = 2;
		public final static int A_L_EAU = 3;
		public final static int GAMEOVER = 4;
		private Joueur adversaire;
		private int tailleGrille;
		private String nom;
		
		//les constructeurs
		public Joueur(int tailleGrille, String nom) {
			if (tailleGrille > 26) {
				throw new IllegalArgumentException("tailleGrille doit etre entre 1 et 26");
			}
			if (nom==null) {
				throw new IllegalArgumentException("Le nom ne doit pas �tre null");
			}
			this.nom = nom;
			this.tailleGrille = tailleGrille;
			
		}
		
		
		public Joueur(int tailleGrille) {
			this.nom = "Joueur";
			this.tailleGrille = tailleGrille;
		}
		
		
		

	public int getTailleGrille() {
			return tailleGrille;
		}


		public String getNom() {
			return nom;
		}
		
	
		
		public void jouerAvec(Joueur j) {
			this.adversaire = j;
			j.adversaire = this;
			deroulementJeu(this, j);

			}
		
		private static void deroulementJeu(Joueur attaquant, Joueur defenseur) {
			int res = 0;
			while (res != GAMEOVER) {
			Coordonnee c = attaquant.choisirAttaque();
			res = defenseur.defendre(c);
			attaquant.retourAttaque(c, res);
			defenseur.retourDefense(c, res);
			Joueur x = attaquant;
			attaquant = defenseur;
			defenseur = x;
			}
			}
		protected abstract void retourAttaque(Coordonnee c, int etat);
		protected abstract void retourDefense(Coordonnee c, int etat);
		public abstract Coordonnee choisirAttaque();
		public abstract int defendre(Coordonnee c);
		



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] t = {4,2,3,5};
		GrilleNavale g1 = new GrilleNavale(10, t);
		GrilleNavale g2 = new GrilleNavale(10, t);
		System.out.println(g1);
		System.out.println(g2);
		JoueurTexte j1 = new JoueurTexte(g1, "joueur 1");
		JoueurAuto j2 = new JoueurAuto(g2, "joueur 2");
		j1.jouerAvec(j2);
		deroulementJeu(j1, j2);
	}

	

}
