package batailleNavale;

public class TestCoordonnee {

	public static void testConstructeur() {
		System.out.println("=> On commence les tests sur les constructeurs" + "\n");
		System.out.println("=> tests sur le 1er constructeur (entiers comme paramétres)" + "\n");

		// dans le cas (0,0)
		Coordonnee C1 = new Coordonnee(0, 0);
		System.out.println(C1);
		// ca retourne A1 => c'est faux
		System.out.println("tester la coordonne (0,0)");
		if (C1.getLigne() == 0 && C1.getColonne() == 0)
			System.out.println("la coordonnée est incorrecte " + C1 + "\n");
		else if (!(C1.getLigne() == 0 && C1.getColonne() == 0))
			System.out.println("la coordonnée " + C1 + "est correcte" + "\n");

		// dans le cas (-1,0)
		System.out.println("tester la coordonnée (-1,0)");
		try {
			Coordonnee C2 = new Coordonnee(-1, 0);
			System.out.println("l'exception n'est pas levée" + "\n");
		} catch (IllegalArgumentException e) {
			System.out.println("l'exception est bien levée: " + e.getMessage() + "\n");
		}

		// dans le cas(0,-1)
		System.out.println("tester la coordonnée (-1,0)");
		try {
			Coordonnee C3 = new Coordonnee(0, -1);
			System.out.println("l'exception n'est pas levée" + "\n");
		} catch (IllegalArgumentException e) {
			System.out.println("l'exception est bien levée: " + e.getMessage() + "\n");

		}

		// dans le cas (-1,-1)
		System.out.println("tester la coordonnée (-1,-1)");
		try {
			Coordonnee C4 = new Coordonnee(-1, -1);
			System.out.println("l'exception n'est pas levée" + "\n");
		} catch (IllegalArgumentException e) {
			System.out.println("l'exception est bien pas levée: " + e.getMessage() + "\n");
		}

		// dans le cas (0,26)
		System.out.println("tester la coordonnée (0,26)");
		try {
			Coordonnee C5 = new Coordonnee(0, 26);
			System.out.println("l'exception n'est pas levée" + "\n");
		} catch (IllegalArgumentException e) {
			System.out.println("l'exception est bien pas levée: " + e.getMessage() + "\n");

		}

		// dans le cas (26,0)
		System.out.println("tester la coordonnée (26,0)");
		try {
			Coordonnee C6 = new Coordonnee(0, 26);
			System.out.println("l'exception n'est pas levée" + "\n");
		} catch (IllegalArgumentException e) {
			System.out.println("l'exception est bien pas levée: " + e.getMessage() + "\n");

		}

		// dans le cas (26,26)
		System.out.println("tester la coordonnée (26,26)");
		try {
			Coordonnee C5 = new Coordonnee(26, 26);
			System.out.println("l'exception n'est pas levée" + "\n");
		} catch (IllegalArgumentException e) {
			System.out.println("l'exception est bien pas levée: " + e.getMessage() + "\n");
		}

		System.out.println("=> tests sur le 2eme constructeur (String)" + "\n");
		// dans le cas AB
		System.out.println("tester la coordonnée (\"AA\")");
		try {
			Coordonnee C6 = new Coordonnee("AB");
			System.out.println("l'exception n'est pas levée" + "\n");
		} catch (IllegalArgumentException e) {
			System.out.println("l'exception est bien pas levée: " + e.getMessage() + "\n");
		}

		System.out.println("=> tests sur le 2eme constructeur (String)" + "\n");
		// dans le cas AB
		System.out.println("tester la coordonnée (\"AB\")");
		try {
			Coordonnee C6 = new Coordonnee("AB");
			System.out.println("l'exception n'est pas levée" + "\n");
		} catch (IllegalArgumentException e) {
			System.out.println("l'exception est bien pas levée: " + e.getMessage() + "\n");
		}

		// "1A"
		try {
			System.out.println("tester la coordonnée (\"1A\")");
			Coordonnee C7 = new Coordonnee("1A");
			System.out.println("l'exception n'est pas levée" + "\n");
		} catch (IllegalArgumentException e) {
			System.out.println("l'exception est bien pas levée: " + e.getMessage() + ")" + "\n");
		}

		// "22"
		try {
			System.out.println("tester la coordonnée (\"11\")");
			Coordonnee C8 = new Coordonnee("22");
			System.out.println("l'exception n'est pas levée" + "\n");
		} catch (IllegalArgumentException e) {
			System.out.println("l'exception est bien pas levée: " + e.getMessage() + ")" + "\n");
		}

		// "A22"
		try {
			System.out.println("tester la coordonnée (\"A27\")");
			Coordonnee C8 = new Coordonnee("A22");
			System.out.println("l'exception n'est pas levée" + "\n");
		} catch (IllegalArgumentException e) {
			System.out.println("l'exception est bien pas levée: " + e.getMessage() + ")" + "\n");
		}

		// "00"
		try {
			System.out.println("tester la coordonnée (\"00\")");
			Coordonnee C9 = new Coordonnee("00");
			System.out.println("l'exception n'est pas levée" + "\n");
		} catch (IllegalArgumentException e) {
			System.out.println("l'exception est bien pas levée: " + e.getMessage() + ")" + "\n");
		}

		// "A0"
		try {
			System.out.println("tester la coordonnée (\"A0\")");
			Coordonnee C10 = new Coordonnee("A0");
			System.out.println("l'exception n'est pas levée" + "\n");
		} catch (IllegalArgumentException e) {
			System.out.println("l'exception est bien pas levée: " + e.getMessage() + ")" + "\n");
		}

		// "0"
		try {
			System.out.println("tester la coordonnée (\"0\")");
			Coordonnee C11 = new Coordonnee("0");
			System.out.println("l'exception n'est pas levée" + "\n");
		} catch (IllegalArgumentException e) {
			System.out.println("l'exception est bien pas levée: " + e.getMessage() + ")" + "\n");
		}

		// "0A"
		try {
			System.out.println("tester la coordonnée (\"0A\")");
			Coordonnee C12 = new Coordonnee("0A");
			System.out.println("l'exception n'est pas levée" + "\n");
		} catch (IllegalArgumentException e) {
			System.out.println("l'exception est bien pas levée: " + e.getMessage() + ")" + "\n");
		}

		// "TOTO"
		try {
			System.out.println("tester la coordonnée (\"TOTO\")");
			Coordonnee C13 = new Coordonnee("TOTO");
			System.out.println("l'exception n'est pas levée" + "\n");
		} catch (IllegalArgumentException e) {
			System.out.println("l'exception est bien pas levée: " + e.getMessage() + ")" + "\n");
		}

		System.out.println("=>Fin des tests du constructeur \n");
	}

	
	
	
	public static void testMethode() {
		// toString()
		// (0, 0) -> 00 (faux)
		// -> A1 (vrai)
		System.out.println("=> ON Commence les test sur les methodes\n");
		Coordonnee C1 = new Coordonnee(0, 0);
		System.out.println("Test toString (0,0)");
		if (C1.toString() == "00")
			System.out.println("Erreur");
		else
			System.out.println("Pas d'erreur");

		// getLigne()
		// (0,0) -> 0
		Coordonnee C2 = new Coordonnee(0, 0);
		System.out.println("\nTest toString (0,0)");
		if (C2.getLigne() == 1)
			System.out.println("Erreur");
		else
			System.out.println("Pas d'erreur");
		
		// "A1" -> 0
		System.out.println("\nTest toString (A1)");
		Coordonnee C3 = new Coordonnee("A1");
		if (C3.getLigne() == 1)
			System.out.println("Erreur");
		else
			System.out.println("Pas d'erreur");
		
		
		// getColonne()
		// (0,0) -> 0 (vrai)
		// -> 1 (faux)
		System.out.println("\nTest getColonne(0,0)");
		Coordonnee C4 = new Coordonnee(0, 0);
		if (C4.getColonne() != 0)
			System.out.println("Erreur");
		else
			System.out.println("Pas d'erreur");
		
		
		// "A1" -> 0 (vrai)
		// sinon faux
		System.out.println("\nTest getColonne(A1)");
		Coordonnee C5 = new Coordonnee(0, 0);
		if (C5.getColonne() != 0)
			System.out.println("Erreur");
		else
			System.out.println("Pas d'erreur");
		
		
		// equals(Object obj)

		// voisine(Coordonnee c)
		// (1, 1) (0,0)
		System.out.println("\nTest (1,1) voisine (0,0)");
		Coordonnee C6 = new Coordonnee(1, 1);
		Coordonnee C7 = new Coordonnee(0, 0);
		if (C6.voisine(C7) == true)
			System.out.println("Erreur");
		else
			System.out.println("Pas d'erreur");
		

		// compareTo(Coordonnee c)
		System.out.println("\nTest (0,0) compareTo (0,0)");
		Coordonnee C8 = new Coordonnee(0, 0);
		Coordonnee C9 = new Coordonnee(0, 0);
		if (C8.compareTo(C9) != 0)
			System.out.println("Erreur");
		else
			System.out.println("Pas d'erreur");
		
		
		// (1,1) compareTo (0,0) >0
		System.out.println("\nTest (1,1) compareTo (0,0)");
		Coordonnee C10 = new Coordonnee(1, 1);
		Coordonnee C11 = new Coordonnee(0, 0);
		if (C10.compareTo(C11) <= 0) // test > test2
			System.out.println("Erreur");
		else
			System.out.println("Pas d'erreur");
		
		
		// (1,1) compareTo (2,2) <0
		System.out.println("\nTest (1,1) compareTo (2,2)");
		Coordonnee C12 = new Coordonnee(1, 1);
		Coordonnee C13 = new Coordonnee(2, 2);
		if (C12.compareTo(C13) >= 0) // C12 < C13
			System.out.println("Erreur");
		else
			System.out.println("Pas d'erreur");

		System.out.println("=>Fin des tests sur es methodes \n");

	}

	public static void main(String[] args) {

		testConstructeur();
		testMethode();

	}

}
