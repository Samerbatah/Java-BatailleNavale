package batailleNavale;

public class Navire {

	private Coordonnee debut;
	private Coordonnee fin;
	private Coordonnee[] partiesTouchees;
	private int nbTouchees;

	// constructeur

	public Navire(Coordonnee debut, int longueur, boolean estVertical) {

		if (longueur > 26 || longueur <= 0) {
			throw new IllegalArgumentException(" longueur du Navire ne doit etre: 0 < longeur <= 26");
		}

		this.debut = debut;

		if (estVertical) {

			fin = new Coordonnee((debut.getLigne() + longueur - 1), debut.getColonne());
		} else {
			fin = new Coordonnee(debut.getLigne(), (debut.getColonne() + longueur - 1));
		}

		partiesTouchees = new Coordonnee[longueur];
		nbTouchees = 0;

	}

	// methodes

	public String toString() {
		String position;
		int longueur;
		if (this.debut.getLigne() == this.fin.getLigne()) {
			position = "horizontal";
			longueur = this.fin.getColonne() - this.debut.getColonne() + 1;
		} else {
			position = "vertical";
			longueur = this.fin.getLigne() - this.debut.getLigne() + 1;
		}
		return "\"Navire(" + this.debut.toString() + ", " + longueur + ", " + position + ")\"";
	}

	public Coordonnee getDebut() {
		return debut;
	}

	public Coordonnee getFin() {
		return fin;
	}

	public boolean contient(Coordonnee c) {
		int cL = c.getLigne();
		int cC = c.getColonne();
		int thisLd = this.debut.getLigne();
		int thisLf = this.fin.getLigne();
		int thisCd = this.debut.getColonne();
		int thisCf = this.fin.getColonne();
		if (((cL >= thisLd) && (cL <= thisLf)) && ((cC >= thisCd) && (cC <= thisCf)))
			return true;
		else {
			return false;
		}
	}

	public boolean touche(Navire n) {

		int nLd = n.debut.getLigne();
		int nLf = n.fin.getLigne();
		int nCd = n.debut.getColonne();
		int nCf = n.fin.getColonne();
		int thisLd = this.debut.getLigne();
		int thisLf = this.fin.getLigne();
		int thisCd = this.debut.getColonne();
		int thisCf = this.fin.getColonne();

		boolean toucheEnLigne = ((thisLd == nLf + 1) || (thisLf == nLd - 1) || (nLd == thisLf + 1)
				|| (nLf == thisLd - 1));
		boolean toucheColonne = ((thisCf == nCd - 1) || (thisCd == nCf + 1) || (nCf == thisCd - 1)
				|| (nCd == thisCf + 1));
		boolean colonneEnCommune = (((thisCd >= nCd) && (thisCd <= nCf)) || ((thisCf >= nCd) && (thisCf <= nCf))
				|| ((nCd >= thisCd) && (nCd <= thisCf)) || ((nCf >= thisCd) && (nCf <= thisCf)));
		boolean ligneEnCommune = (((thisLd >= nLd) && (thisLd <= nLf)) || ((thisLd >= nLd) && (thisLd < nLf))
				|| ((nLd >= thisLd) && (nLd <= thisLf)) || ((nLf >= thisLd) && (nLf <= thisLf)));

		if ((toucheEnLigne && colonneEnCommune) || (toucheColonne && ligneEnCommune)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean chevauche(Navire n) {
		if ((n.debut.getLigne() <= this.debut.getLigne() && n.fin.getLigne() >= this.debut.getLigne()
				&& n.debut.getColonne() >= this.debut.getColonne() && n.debut.getColonne() <= this.fin.getColonne())

				|| (this.debut.getLigne() <= n.debut.getLigne() && this.fin.getLigne() >= n.debut.getLigne()
						&& this.debut.getColonne() >= n.debut.getColonne()
						&& this.debut.getColonne() <= n.fin.getColonne()))
			return true;
		else {
			return false;
		}
	}

	public boolean recoitTir(Coordonnee c) {
		/*
		 * on doit dabord verifier que la coordonnée n'existe pas deja dans le tableau
		 * partiesTouchees
		 */
		boolean existe = false;
		for (int i = 0; i < partiesTouchees.length; i++) {
			if (partiesTouchees[i] != null && partiesTouchees[i].equals(c)) {
				existe = true;
				break;
			}
		}
		if (existe == false && this.contient(c)) {
			partiesTouchees[nbTouchees] = c;
			nbTouchees = nbTouchees + 1;
			return true;
		} else {
			return false;
		}
	}

	public boolean estTouche(Coordonnee c) {
		for (int i = 0; i < partiesTouchees.length; i++) {
			if (this.partiesTouchees[i] != null && this.partiesTouchees[i].equals(c))
				return true;
		}
		return false;
	}

	public boolean estTouche() {
		if (this.nbTouchees > 0) {
			return true;
		}
		return false;
	}

	public boolean estCoule() {

		if (this.partiesTouchees.length == this.nbTouchees)
			return true;
		else {
			return false;
		}
	}

	public static void main(String[] args) {
		
		  //test recoiTir
		
				Coordonnee c5 = new Coordonnee("B2");
				Navire n11 = new Navire(c5, 2, true);
				Coordonnee c6 = new Coordonnee("S2");
				Coordonnee c8 = new Coordonnee("S3");
				Coordonnee c9 = new Coordonnee("S8");
				Coordonnee c10 = new Coordonnee("B9");
				Coordonnee c11 = new Coordonnee("B10");
	
			
				Coordonnee[] partiesTouchees = {c6, c8 , c10} ;
				System.out.println(n11.recoitTir(c9));
					

		

   }
}
