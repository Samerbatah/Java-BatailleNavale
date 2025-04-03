package batailleNavale;


public class Coordonnee implements Comparable<Coordonnee> {

	private int ligne;
	private int colonne;
	
	
	public Coordonnee(int ligne, int colonne) {
		if (ligne < 0 || ligne > 25 || colonne < 0 || colonne > 25) 
																	
			throw new IllegalArgumentException("coordonnee dépasse limite (doit etre entre 0 et 25)");
		this.ligne = ligne;
		this.colonne = colonne;
	}

	
	public Coordonnee(String s) {
		//methde utilisé afin d'assurer que la lettre est en majuscule
		s = s.toUpperCase();
		
		//afin de pouvoir s'assurer que la ligne prend une valeur de 1 a 26(un seul chiffre ou deux)
		if (s.length() < 2 || s.length() > 3) {
			throw new IllegalArgumentException("coordonnee dépasse limite (elle doit prendre 2 ou 3 caracteres)");
		}
		
		
		if (s.charAt(0) < 'A' || s.charAt(0) > 'Z') { // verifier que le premier caractere est une lettre
			throw new IllegalArgumentException("coordonnee dépasse limite (doit etre entre une lettre)");
		}
		
		//levé l'exception "NumberFormatException" car on essaye de modifier la fin de la chaine en entier
		try {
			Integer.parseInt(s.substring(1)); 
		} catch (NumberFormatException e) { 
			throw new IllegalArgumentException("indice de ligne doit etre un NOMBRE de 1 a 26"); 
		}
		
		
		if (Integer.parseInt(s.substring(1)) < 1 // on teste le nombre en 2eme partie de la string: doit etre entre 1 et
				// 26
|| Integer.parseInt(s.substring(1)) > 26) {
throw new IllegalArgumentException("coordonnee dépasse limite (doit etre entre 1 a 26)");
}
		int lign = Integer.parseInt(s.substring(1)) - 1;
		int colon = s.charAt(0) - 65;
		this.ligne = lign ;
		this.colonne =  colon;
	    

	}
	
	
	public String toString() {
		char colonne = (char) ((this.colonne + 'A'));
				String uneCoordonnee = colonne + "" + (this.ligne+1 );
				
				return uneCoordonnee;
	}
	
	
	
	public int getLigne() {
		return this.ligne;
	}
	public int getColonne() {
		return this.colonne;
	}
	
	
	
	public boolean equals(Object obj) {
		if(obj!=null){
			Coordonnee c =(Coordonnee)obj;
			if((c.getLigne() == this.getLigne())&&(c.getColonne() == this.getColonne())){
				return true;
			}
		}
		return false;
	}
	
	
	public boolean voisine(Coordonnee c) {
		if(this.getColonne()==c.getColonne()){
			if((this.getLigne()+1==(c.getLigne()))||((this.getLigne()-1)==(c.getLigne()))){
				return true;
			}
			else{
				return false;
			}
		}
		if(this.getLigne()==c.getLigne()){
			if((this.getColonne()+1==(c.getColonne()))||((this.getColonne()-1)==(c.getColonne()))){
				return true;
			}
			else{
				return false;
			}
		}
		return false;
	}
	
	
	public int compareTo(Coordonnee c) {
		if (this.getLigne() > c.getLigne()){
			return +1;
		}
		else if(this.getLigne() == c.getLigne()){
			if(this.getColonne() > c.getColonne()){
				return +1;
			}
			else if(this.getColonne() < c.getColonne()){
				return -1;
			}		
			else{ 
				return 0;
			}
		}
		return -1;
	}
	
	
	public static void main(String[] args) {
		try {
		Coordonnee n1 = new Coordonnee(0,2);
		Coordonnee n2 = new Coordonnee("D7");
		System.out.println("n11111111111  "+n1);
		System.out.println("n22222222222  "+n2);
		System.out.println(n2.getColonne()+ "    ligne   " + n2.getLigne() );
		System.out.println(n1);
		
		
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
	}

	


}




   

