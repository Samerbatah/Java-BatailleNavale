package batailleNavale;
import java.awt.*;


public class GrilleNavaleGraphique extends GrilleNavale {
	private GrilleGraphique grille;
	
//definir les constructeurs
	
	//1er constructeurs (permis d'obtenir une grille de taille Grille)
	
public GrilleNavaleGraphique(int taille) {
	//si la taille de grille<5 on pourra avoir que 2 navire possible sur la grille
	//si la taille >=5 le nombre de navire sera egale a (taille/5)+2)
	//on prend 5 car: 2>=nombre navire <=5
	super(taille, ((taille/5)==0?2:taille/5+2));
	grille = new GrilleGraphique(taille);
	grille.setClicActive(false);
	}

public GrilleGraphique getGrilleGraphique() {
	return this.grille;
}

public boolean ajouteNavire(Navire n) {
	 if (super.ajouteNavire(n)) {
		 this.grille.colorie(n.getDebut(), n.getFin(), Color.GREEN);
		 return true;
	 }
		return false;
	}


	public boolean recoitTir(Coordonnee c) {
		if (super.recoitTir(c)) {
			this.grille.colorie(c, Color.RED); 
			return true;
		}
		else {
			this.grille.colorie(c, Color.BLUE); 
			return false; 
		}}
	}