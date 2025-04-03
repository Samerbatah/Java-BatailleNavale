package batailleNavale;

public class TestNavire {

	public static void main(String[] args) {
		//
		Navire n1 = new Navire(new Coordonnee("B3"),5,false);
		System.out.println(n1.getDebut().equals(new Coordonnee("F3")));
		System.out.println(n1.estTouche()==false);
		
		
		for(int j=0; j<5; j++) {
			System.out.println(n1.contient(new Coordonnee(2,1+j)));
		}
		
		System.out.println(!n1.contient(new Coordonnee(1,0)));
		System.out.println(!n1.contient(new Coordonnee(2,6)));
		
		//N1 ET N2 SE TOUCHE une erreur
		Navire n2 = new Navire(new Coordonnee("F4"),5,false);
		System.out.println(!n1.touche(n2));
		
		//N1 ET N2 SE TOUCHE
				Navire n3 = new Navire(new Coordonnee("F3"),5,false);
				System.out.println(!n1.touche(n3));
				System.out.println(!n1.touche(n3));
				
		//ca doit donner true pas false		
		Navire n5 = new Navire(new Coordonnee("B2"),5,false);
		Navire n6 = new Navire(new Coordonnee("C2"),5,false);
		System.out.println(n5.touche(n6));
		
		
		Coordonnee c1 = new Coordonnee(5, 10);
		Navire n7 = new Navire(c1, 5, true);
		System.out.println(n7);

		System.out.println(n7.getDebut());
		System.out.println(n7.getFin());

		Coordonnee c2 = new Coordonnee(2, 10);
		System.out.println(n7.contient(c2));

//		Navire n2 = new Navire(c2,4,true);
//		System.out.println(n1.touche(n2));

//		Navire n2 = new Navire(c2,7,true);
//		System.out.println(n1.touche(n2));

//		Navire n2 = new Navire(c2, 2, false);
//		System.out.println(n1.touche(n2));

		Navire n8 = new Navire(c2, 3, true);
		System.out.println(n1.touche(n8));

		Coordonnee c3 = new Coordonnee(0, 1);
		Navire n9 = new Navire(c3, 3, true);
		Coordonnee c4 = new Coordonnee(0, 0);
		Navire n10 = new Navire(c4, 3, false);
		System.out.println(n9.chevauche(n10));
		
		
         //test recoiTir
		Coordonnee c5 = new Coordonnee("S3");
		Navire n11 = new Navire(c5, 5, true);
		Coordonnee c6 = new Coordonnee("S2");
		Coordonnee c8 = new Coordonnee("S3");
		Coordonnee c9 = new Coordonnee("S8");
		Coordonnee c10 = new Coordonnee("B9");
		Coordonnee c11 = new Coordonnee("B10");
		
		System.out.println(n11.recoitTir(c8));
		
		
	   }
	
    }
