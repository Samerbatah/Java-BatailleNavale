package batailleNavale;

public class GrilleNavale {
	// DEFINITION DES ATTRIBUTS
	private Navire[] navires;
	private int nbNavires;
	private int taille;
	private Coordonnee[] tirsRecus;
	private int nbTirsRecus;

	// DEFINITION DES CONSTRUCTEURS

	public GrilleNavale(int taille, int[] taillesNavires) {
		// Trouver le tableau taillesNavires qui a la taille maximale
		int max = taillesNavires[0];
		for (int i = 1; i < taillesNavires.length; i++) {
			if (taillesNavires[i] > taillesNavires[i - 1])
				max = taillesNavires[i];
		}
		// condition 1 (taille de grille entre 1 a 25)
		if (taille > 26 || taille <= 0)
			throw new IllegalArgumentException("taille depasse limite (0 < taille <= 26)");
		else if (taille < max)
			throw new IllegalArgumentException(
					"La taille de grille doit être supérieure ou égale à la taille maximale des tailles de navires");
		else
			this.taille = taille;

		// condition 2 (taille des navires (entre 2 a 5)
		boolean TN = true;
		for (int i = 0; i < taillesNavires.length; i++) {
			if ((taillesNavires[i] < 2) && (taillesNavires[i] > 5))
				TN = false;
		}
		if ((taillesNavires.length < 2) || (taillesNavires.length > 5)) {

			throw new IllegalArgumentException("La taille d'un navire doit être entre 2 et 5");
		}

		nbNavires = 0;
		navires = new Navire[taillesNavires.length];
		nbTirsRecus = 0;
		tirsRecus = new Coordonnee[taille * taille];
		placementAuto(taillesNavires);
	}

	// 2eme constructeur

	public GrilleNavale(int taille, int nbNavires) {
		if (taille > 26 || taille <= 0)
			throw new IllegalArgumentException("taille depasse les limite (0 < taille < 26");
		this.taille = taille;
		if (nbNavires <= 0)
			throw new IllegalArgumentException("afin de pouvoir jouer faut plus de 0 navire");
		this.nbNavires = 0;

		nbTirsRecus = 0;
		navires = new Navire[nbNavires];
		tirsRecus = new Coordonnee[taille * taille];

	}

	// DEFINITION DE LA METHODE toString

	public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append("   ");
		for (int i = 0; i < taille; i++) {
			sb.append("  ");

			sb.append((char) ('A' + i));
		}
		sb.append('\n');
		for (int i = 0; i < taille; i++) {
			if (i + 1 < 10) {
				sb.append("  ");

			} else {
				sb.append(' ');
			}
			sb.append(i + 1);
			for (int j = 0; j < taille; j++) {
				sb.append("  ");

				Coordonnee c = new Coordonnee(i, j);
				if (estTouche(c)) {
					sb.append('x');
				} else if (estALEau(c)) {
					sb.append('0');
				} else {
					boolean dansNavire = false;
					for (int k = 0; k < nbNavires; k++) {
						if (navires[k].contient(c)) {
							dansNavire = true;
							break;
						}
					}
					if (dansNavire) {
						sb.append("#");
					} else {
						sb.append('.');
					}
				}
			}
			sb.append('\n');
		}

		return sb.toString();
	}

	public int getTaille() {
		return taille;
	}

	// AJOUTE NAVIRE
	public boolean ajouteNavire(Navire n) {

		if (!estDansGrille(n.getFin())|| !estDansGrille(n.getDebut()) )
			return false;

		for (int i = 0; i < nbNavires; i++) {
			if (navires[i].touche(n) || navires[i].chevauche(n)) {
				return false;
			}
		}

		navires[nbNavires] = n;
		nbNavires++;
		return true;
	}

	// CREATION D'UNE METHODE ANNEXE A APPELER DANS PLACEMENT AUTO
	public Coordonnee creeRandomCoordonnee() {
		return new Coordonnee((int) (Math.random() * this.taille), (int) (Math.random() * this.taille));
	}

	// PLACEMENT AUTOMATIQUE
	public void placementAuto(int[] taillesNavires) {

		Coordonnee randomCoord1 = creeRandomCoordonnee();
		Coordonnee randomCoord = randomCoord1;
		for (int i = 0; i < taillesNavires.length; i++) {
			Navire n;
			// essayer 50 fois sinon
			int compteur = 0;
			while (compteur < 50) {
				boolean randomPosition = (Math.random() < 0.5);
				randomCoord = creeRandomCoordonnee();
				n = new Navire(randomCoord, taillesNavires[i], randomPosition);
				if (this.ajouteNavire(n)) {
					break;
				}
				compteur += 1;
				if (compteur >= 50) {
					throw new IllegalArgumentException("navire " + i + " impossible a ajouter");
				}
			}
		}
	}
	
	
	private boolean estDansGrille(Coordonnee c) {
		return (c.getLigne() + 1 <= this.taille && c.getColonne() + 1 <= this.taille);

	}
	
	// EST DANS TIRS RECUS
		private boolean estDansTirsRecus(Coordonnee c) {
			for (int i = 0; i <= nbTirsRecus; i++) {
				if (c.equals(tirsRecus[i])) {
					return true;
				}
			}

			return false;
		}
		
		
		// AJOUTER DANS TIRS RECUS

		private boolean ajouteDansTirsRecus(Coordonnee c) {
			boolean ajoutOk = false;
			if (estDansGrille(c) && !estDansTirsRecus(c)) {
				tirsRecus[nbTirsRecus] = c;
				nbTirsRecus += 1;
				ajoutOk = true;
			}
			return (ajoutOk);
		}
		
		
		public boolean recoitTir(Coordonnee c) {

			if (ajouteDansTirsRecus(c)) {
				// le tir n'est pas dans tirsRecus[] et un des navires contient la coordonnee c
				for (int i = 0; i < nbNavires; i++)
					if (navires[i].recoitTir(c))// actualise partie du navire touchee
						return true;
			}
			return false;
		}



	public boolean estTouche(Coordonnee c) {
		boolean var = false;
		for (int i = 0; i < this.navires.length; i++) {
			if (this.navires[i] != null && this.navires[i].contient(c) && estDansTirsRecus(c)) {
				var = true;
			}
		}
		return var;
	}

	

	// EST DANS L'EAU

	public boolean estALEau(Coordonnee c) {
		return (estDansTirsRecus(c) && ! estTouche(c));

	}
	
	
	// EST COULE

		public boolean estCoule(Coordonnee c) {

			boolean couler = false;
			for (int i = 0; i < this.navires.length; i++) {
				if (this.navires[i] != null && this.navires[i].estTouche(c) && this.navires[i].estCoule()) {
					couler = true;
					break;
				}
			}
			return couler;
		}
		

	

	public boolean perdu() {
		boolean perdre = true;
		for (int i = 0; i < nbNavires; i++)
			if (!navires[i].estCoule()) {
				perdre = false;
			} else {
				perdre = true;
			}
		return perdre;
	}

	
	

	public static void main(String[] args) {

		int[] t = { 3, 2, 4, 2, 5 };
		Coordonnee debut = new Coordonnee("c4");
		
		Coordonnee debut1 = new Coordonnee("a2");
		Coordonnee debut2 = new Coordonnee("B2");

//		System.out.println(debut.getLigne() + ":" + debut.getColonne());
//		System.out.println(debut1.getLigne() + ":" + debut1.getColonne());

		Navire n = new Navire(debut1, 4, true);
		
//		System.out.println(n1.getFin());
//
		GrilleNavale grille = new GrilleNavale(10, 6);
		System.out.println(grille);

//
		grille.ajouteNavire(n);
		grille.placementAuto(t);
		grille.recoitTir(debut1);
		System.out.println(grille.recoitTir(debut2));
		System.out.println(grille);
	
		System.out.println(grille);
		

	}
}
