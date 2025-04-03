# BatailleNavaleJavaSE

Ce projet a été développé en Groupe de 5 lors d'un stage bloqué à l'Université Grenoble Alpes
Master 2 Mathématiques et informatique appliquées Aux SHS. A la fin de la semaine, nous avons 
présenté ce projet devant la promotion.

Les professeurs encandrants: Daniel Bardou et Jérome David

Les CONSIGNES DU PROJET

ÉTAPE 1

Dans cette première étape, il s'agit de mettre en place les classes permettant de créer 
ce qui correspond au matériel de jeu, c'est-à-dire les coordonnées, les navires et la grille de bataille navale.

1. Classe Coordonnee

Une instance de la classe Coordonnee représente une coordonnée dans une grille de bataille navale. 
Cette classe doit en particulier permettre de réaliser facilement des conversions entre le système de coordonnées utilisé dans la bataille navale,
où les colonnes sont notées par des lettres majuscules (de 'A' à 'Z') et les lignes par des nombres (de 1 à 26), et les indices utilisés en Java (de 0 à 25).


Définir les constructeurs suivants.
- public Coordonnee(int ligne, int colonne) permet d'obtenir une coordonnée de ligne i et de colonne j (indices Java).

- public Coordonnee(String s) permet d'obtenir une coordonnée d'après son expression donnée par s dans le système
de coordonnées de la bataille navale.

1.2 Définir les méthodes suivantes.

- public String toString() Retourne une String exprimant this dans le système de coordonnée de la bataille navale (exemple : "C6").

- public int getColonne() Accesseur en lecture pour l'indice de colonne.

- public int getLigne() Accesseur en lecture pour l'indice de ligne.

- public boolean equals(Object obj) Retourne true si et seulement si this est équivalent à obj.

- public boolean voisine(Coordonne c) Retourne true si et seulement si this est une coordonnée voisine (verticalement ou horizontalement) de c.

package batailleNavale;

public class Coordonnee implements Comparable<Coordonnee> {
  
private int ligne;

private int colonne;

public Coordonnee(int ligne, int colonne) {...}

public Coordonnee(String s) {...}

public String toString() {...}

public int getLigne() {...}

public int getColonne() {...}

public boolean equals(Object obj) {...}

public boolean voisine(Coordonnee c) {...}

public int compareTo(Coordonnee c) {...}

}
  
  
  
  1.1 Définir les constructeurs suivants.
  
- public Coordonnee(int ligne, int colonne) permet d'obtenir une coordonnée de ligne i et de colonne j (indices Java).

- public Coordonnee(String s) permet d'obtenir une coordonnée d'après son expression donnée par s dans le système de coordonnées de la bataille navale.

1.2 Définir les méthodes suivantes.

- public String toString() Retourne une String exprimant this dans le système de coordonnée de la bataille navale (exemple : "C6").

- public int getColonne() Accesseur en lecture pour l'indice de colonne.

- public int getLigne() Accesseur en lecture pour l'indice de ligne.

- public boolean equals(Object obj) Retourne true si et seulement si this est équivalent à obj.

- public boolean voisine(Coordonne c) Retourne true si et seulement si this est une coordonnée voisine (verticalement ou horizontalement) de c.

public int compareTo(Coordonne c) Retourne le résultat de la comparaison de this et de c.
Une coordonnée est considérée inférieure à une autre, si elle se trouve sur une ligne inférieure ou si elle se trouve
sur la même ligne mais sur une colonne inférieure.

2. Classe Navire

Les navires de la bataille navale sont représentés par des instances de la classe Navire. 
Les coordonnées debut et fin marquent l'emplacement du navire, on suppose que debut est toujours inférieure à fin.
partiesTouchees contient les coordonnées des parties du navire qui ont été touchées et nbTouchees indique combien de parties ont été touchées.


package batailleNavale;

public class Navire {

private Coordonnee debut;

private Coordonnee fin;

private Coordonnee[] partiesTouchees;

private int nbTouchees;

public Navire(Coordonnee debut, int longueur, boolean estVertical) {...}

public String toString() {...}

public Coordonnee getDebut() {...}

public Coordonnee getFin() {...}

public boolean contient(Coordonnee c) {...}

public boolean touche(Navire n) {...}

public boolean chevauche(Navire n) {...}

public boolean recoitTir(Coordonnee c) {...}

public boolean estTouche(Coordonnee c) {...}

public boolean estTouche() {...}

public boolean estCoule() {...}

}



2.1 Définir le constructeur suivant.

- public Navire(Coordonnee debut, int longueur, boolean estVertical) permet d'obtenir un navire débutant en debut et de taille longueur.
Ce navire est disposé verticalement si estVertical vaut true, horizontalement sinon.

2.2 Définir les méthodes suivantes.

-  public String toString() Retourne une String représentant this. 
On souhaite obtenir une représentation de la forme "Navire(B1, 4, horizontal)" (pour un navire de taille 4 placé horizontalement par exemple).

- public Coordonnee getDebut() Accesseur en lecture.

- public Coordonnee getFin() Accesseur en lecture.

- public boolean contient(Coordonnee c) Retourne true si et seulement si this occupe c.

- public boolean touche(Navire n) Retourne true si et seulement si this est adjacent à n. L'adjacence par la diagonale ne compte pas.




- public boolean chevauche(Navire n) Retourne true si et seulement si this chevauche n, c'est-à-dire que this et n occupent au moins une coordonnée en commun.

- public boolean recoitTir(Coordonnee c) Retourne true si et seulement si this contient c. Dans ce cas, c est ajoutée aux parties touchées si nécessaire.

- public boolean estTouche(Coordonnee c) Retourne true si et seulement si this a été touché par un tir en c.

- public boolean estTouche() Retourne true si et seulement si this a au moins une partie touchée.

- public boolean estCoule() Retourne true si et seulement si this est coulé, c'est-à-dire que toutes ses parties ont été touchées.

3. Classe GrilleNavale

La classe GrilleNavale représente une grille de bataille navale. Les attributs navires et nbNavires représentent
les navires placés sur la grille ainsi que leur nombre. L'attribut taille donne la taille de la grille (la grille est de forme carrée).
Les tirsRecus et nbTirsRecus référencent les coordonnées où des tirs ont été effectués ainsi que leur nombre.



package batailleNavale;

public class GrilleNavale {

private Navire[] navires;

private int nbNavires;

private int taille;

private Coordonnee[] tirsRecus;

private int nbTirsRecus;

public GrilleNavale(int taille, int[] taillesNavires) {...}

public GrilleNavale(int taille, int nbNavires) {...}

public String toString() {...}

public int getTaille() {...}

public boolean ajouteNavire(Navire n) {...}

public void placementAuto(int[] taillesNavires) {...}

private boolean estDansGrille(Coordonnee c) {...}

private boolean estDansTirsRecus(Coordonnee c) {...}

private boolean ajouteDansTirsRecus(Coordonnee c) {...}

public boolean recoitTir(Coordonnee c) {...}

public boolean estTouche(Coordonnee c) {...}

public boolean estALEau(Coordonnee c) {...}

public boolean estCoule(Coordonnee c) {...}

public boolean perdu() {...}

}



3.1 Définir les constructeurs suivants.

- public GrilleNavale(int taille, int[] taillesNavires) permet d'obtenir une grille navale de taille 
taille dans laquelle ont été placés automatiquement taillesNavires.length navires dont les tailles sont données dans taillesNavires.

-public GrilleNavale(int taille, int nbNavires) permet d'obtenir une grille navale vide de taille taille pouvant accueillir jusqu'à nbNavires.
3.2 Définir les méthodes suivantes.

- public String toString() Retourne une String représentant this.
On souhaite obtenir une représentation s'affichant sur la console de la façon suivante :

      A B C D E F G H I J 
      
    1 . . . . . . . . . . 
    
    2 . . . # # # . . . . 
    
    3 . . . . . . # X # .
    
    4 . . O . . . . O . . 
    
    5 . . . . . # . . . . 
    
    6 . . . O . # . . . . 
    
    7 . # # . . # . . . . 
    
    8 . . . . . # . . . . 
    
    9 . . . . . . . O . .
    
    10 . . . . . . . . . . 
    
    
    Un '.' dénote une case de la grille libre n'ayant reçu aucun tir, un '#' une case occupée par un navire, un 'O' une case libre ayant reçu un tir et un 'X' une partie touchée d'un navire.

-public int getTaille() Accesseur en lecture.
- public boolean ajouteNavire(Navire n) Retourne true après avoir ajouté n à this si cet ajout est possible.
L'ajout est impossible si n touche ou chevauche un navire déjà présent dans this, ou encore si n dépasse les limites de this.

- public void placementAuto(int[] taillesNavires) Place automatiquement et aléatoirement taillesNavires.length 
navires dont les tailles sont données dans taillesNavire.

- private boolean estDansGrille(Coordonnee c) Retourne true si et seulement si c est dans this.

- private boolean estDansTirsRecus(Coordonnee c) Retourne true si et seulement si c correspond à un tir reçu par this.

- private boolean ajouteDansTirsRecus(Coordonnee c) Ajoute c aux tirs reçus de this si nécessaire.
Retourne true si et seulement si this est modifié.

- public boolean recoitTir(Coordonnee c) Ajoute c aux tirs reçus de this si nécessaire. 
Retourne true si et seulement si c ne correspondait pas déjà à un tir reçu et a permis de toucher un navire de this.

- public boolean estTouche(Coordonnee c) Retourne true si et seulement si un des navires présents dans this a été touché en c.

- public boolean estALEau(Coordonnee c) Retourne true si et seulement si c correspond à un tir reçu dans l'eau par this.

- public boolean estCoule(Coordonnee c) Retourne true si et seulement si un des navires présents dans this a été touché en c et est coulé.

- public boolean perdu() Retourne true si et seulement si tous les navires de this ont été coulés.




ETAPE 2



Dans cette deuxième étape, nous nous intéressons au jeu proprement dit et nous ajoutons une hiérarchie de 
classes permettant de représenter les joueurs.

1. Classe Joueur

Joueur est une classe abstraite, c'est la super classe de toutes les classes de joueurs que nous allons concevoir.
Les attributs de classe de Joueur représentent les résultats possibles pour un tir effectué par un joueur lors d'une partie.
L'attribut adversaire est destiné à référencer le joueur adverse, il n'est pas initialisé 
dans le constructeur mais dans la méthode jouerAvec(Joueur j) qui sert à lancer une partie.
L'attribut tailleGrille donne la taille de la grille de jeu utilisée par le joueur, 
celle sur laquelle il place ses navires. nom est le nom du joueur.

package batailleNavale;

public abstract class Joueur {

public final static int TOUCHE = 1;

public final static int COULE = 2;

public final static int A_L_EAU = 3;

public final static int GAMEOVER = 4;

private Joueur adversaire;

private int tailleGrille;

private String nom;

public Joueur(int tailleGrille, String nom) {...}

public Joueur(int tailleGrille) {...}

public int getTailleGrille() {...}

public String getNom() {...}

public void jouerAvec(Joueur j) {

...
deroulementJeu(this, j);

}

private static void deroulementJeu(Joueur attaquant, Joueur defenseur) {

int res = 0;

while (res != GAMEOVER) {

Coordonnee c = attaquant.choixAttaque();

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

public abstract Coordonnee choixAttaque();

public abstract int defendre(Coordonnee c);

}


1.1 Définir les constructeurs suivants.

- public Joueur(int tailleGrille, String nom) permet d'obtenir un joueur de nom nom et jouant sur une grille de taille taillegrille.

- public Joueur(int tailleGrille) permet d'obtenir un joueur jouant sur une grille de taille taillegrille.

1.2 Définir les méthodes suivantes.

- public int getTailleGrille()

Accesseur en lecture pour tailleGrille.

- public String getNom()

Accesseur en lecture pour nom.

- public void jouerAvec(Joueur j) Démarre une partie contre j. Avant de lancer le déroulement du jeu, il faut veiller à établir le lien entre les 2 joueurs et bien entendu vérifier qu’il puisse être établi.

1.3 Explications pour les méthodes abstraites.

- protected abstract void retourAttaque(Coordonnee c, int etat)

Cette méthode est invoquée sur le joueur attaquant à la fin d’un tour de jeu. c est la coordonnée à laquelle le tir a eu lieu et etat le résultat de l'attaque. etat ne peut être que TOUCHE, COULE, A_L_EAU, ou GAMEOVER.

- protected abstract void retourDefense(Coordonnee c, int etat)

Cette méthode est invoquée sur le joueur défenseur à la fin d’un tour de jeu. c est la coordonnée à laquelle le tir a eu lieu et etat le résultat de ce tir. etat ne peut être que TOUCHE, COULE, A_L_EAU, ou GAMEOVER.

- public abstract Coordonnee choisirAttaque()

Cette méthode est invoquée sur le joueur attaquant au début d’un tour de jeu. Elle retourne la coordonnée cible du tir effectué par l’attaquant.

- public abstract int defendre(Coordonnee c)

Cette méthode est invoquée sur le joueur défenseur après le choix de l’attaquant, c est la coordonnée à laquelle l’attaquant
a choisi d’effectuer un tir. Elle retourne le résultat du tir qui ne peut être que TOUCHE, COULE, A_L_EAU, ou GAMEOVER.

2. Classe JoueurAvecGrille

La classe JoueurAvecGrille est une classe abstraite, sous-classe de Joueur, et super classe de nombreuses 
classes de joueurs. Par rapport à ce qui est hérité depuis la classe Joueur, on ajoute un attribut grille 
qui référence la grille utilisée par un joueur et on est donc en mesure de donner une définition pour la méthode defendre(Coordonee c).



package batailleNavale;

public abstract class JoueurAvecGrille extends Joueur {

private GrilleNavale grille;

public JoueurAvecGrille(GrilleNavale g, String nom) {...}

public JoueurAvecGrille(GrilleNavale g) {...}

public int defendre(Coordonnee c) {...}


}


2.1 Définir les constructeurs de JoueurAvecGrille.

2.2 Définir la méthode defendre(Coordonnee c) de JoueurAvecGrille.

3. Classe JoueurTexte

Une instance de JoueurTexte permet à un joueur humain de jouer à la bataille navale depuis la console 
en tapant les coordonnées de ses attaques. L'attribut scanner doit référencer un Scanner connecté à System.in.


package batailleNavale;

import java.util.Scanner;

public class JoueurTexte extends JoueurAvecGrille {

private Scanner sc;

public JoueurTexte(GrilleNavale g, String nom) {...}

public JoueurTexte(GrilleNavale g) {...}

protected void retourAttaque(Coordonnee c, int etat) {...}

protected void retourDefense(Coordonnee c, int etat) {...}

public Coordonnee choixAttaque() {...}

}

3.1 Définir les constructeurs de JoueurTexte.

3.2 Définir les méthodes de JoueurTexte.

Les méthodes retourAttaque(Coordonne c, int etat), et retourDefense(Coordonne c, int etat) doivent réaliser l'affichage à la 
console des étapes de jeu. La méthode choixAttaque() doit recueillir au clavier la saisie de la coordonnée à attaquer.

4. Classe JoueurAuto

Une instance de JoueurAuto représente un joueur non humain géré par le programme.
Définir le constructeur et les méthodes de la classe JoueurAuto.
Il est bien sûr possible de définir des attributs et méthodes supplémentaires si nécessaire.
On peut concevoir plusieurs types de joueurs gérés par le programme et donc remplacer cette classe par
une hiérarchie de plusieurs classes avec autant de stratégies de jeu différentes.


package batailleNavale;

public class JoueurAuto extends JoueurAvecGrille {

public JoueurAuto(GrilleNavale g, String nom) {...}

public JoueurAuto(GrilleNavale g) {...}

protected void retourAttaque(Coordonnee c, int etat) {...}

protected void retourDefense(Coordonnee c, int etat) {...}

public Coordonnee choixAttaque() {...}
}



ETAPE 3

Dans cette troisième étape, nous mettons en place une interface graphique. La classe GrilleGraphique est fournie,
elle est nécessaire à la réalisation de cette étape.

1. Classe GrilleNavaleGraphique

Une GrilleNavaleGraphique est une GrilleNavale dotée d'une grille graphique permettant de la visualiser.



package batailleNavale;

public class GrilleNavaleGraphique extends GrilleNavale {

private GrilleGraphique grille;

public GrilleNavaleGraphique(int taille) {...}

public GrilleGraphique getGrilleGraphique() {...}

public boolean ajouteNavire(Navire n) {...}

public boolean recoitTir(Coordonnee c) {...}

}


1.1 Définir le constructeur suivant.

- public GrilleNavaleGraphique(int taille) permet d'obtenir une grille de taille taille.

1.2 Définir les méthodes suivantes.

- public GrilleGraphique getGrilleGraphique()

Accesseur en lecture pour grille.

- public boolean ajouteNavire(Navire n)

Spécialisation de la méthode héritée de GrilleNavale. Les cases correspondant au navire ajouté doivent être coloriées en Color.GREEN.
public boolean recoitTir(Coordonnee c) Spécialisation de la méthode héritée de GrilleNavale. La case correspondant au tir doit 
être coloriée en Color.RED si le tir a touché un navire ou en Color.BLUE s'il est à l'eau.


2. Classe FenetreJoueur

Une instance de FenetreJoueur est une fenêtre graphique permettant à un joueur graphique de jouer à la bataille navale. 
Il est possible de la créer avec WindowBuilder en sélectionnant Swing/JFrame. La partie gauche de cette fenêtre correspond 
juste à une GrilleGraphique et la partie droite est la GrilleGraphique liée à une GrilleNavaleGraphique.



package batailleNavale;

public class FenetreJoueur extends JFrame {

private JPanel contentPane;

private GrilleGraphique grilleTirs;

private GrilleNavaleGraphique grilleDefense;

public FenetreJoueur() {

this("Nom du joueur", 10);

}
public FenetreJoueur(String nom, int taille) {...}

public GrilleGraphique getGrilleTirs() {...}

public GrilleNavaleGraphique getGrilleDefense() {...}

}



2.1 Définir le constructeur suivant.

- public FenetreJoueur(String nom, int taille) permet d'obtenir une fenêtre pour un joueur de nom nom 

avec des grilles de taille taille. Un placement de navires automatique sur grilleDefense peut être réalisé.

2.2 Définir les méthodes suivantes.

- public GrilleGraphique getGrilleTirs()

Accesseur en lecture pour grilleTirs.

- public GrilleNavaleGraphique getGrilleDefense()

Accesseur en lecture pour grilleDefense.

3. Classe JoueurGraphique

Une instance de JoueurGraphique permet à un joueur humain de jouer au travers d'une FenetreJoueur. 
L'attribut grilleTirs est lié à une GrilleGraphique sur laquelle le joueur clique pour effectuer des tirs.

package batailleNavale;

public class JoueurGraphique extends JoueurAvecGrille {

private GrilleGraphique grilleTirs;

public JoueurGraphique(GrilleNavaleGraphique grilleDefense,

GrilleGraphique grilleTirs, String nom) {...}

public JoueurGraphique(GrilleNavaleGraphique grilleDefense,

GrilleGraphique grilleTirs) {...}


public Coordonnee choisirAttaque() {...}

protected void retourDefense(Coordonnee c, int etat) {...}

protected void retourAttaque(Coordonnee c, int etat) {

Color couleur = etat == A_L_EAU ? Color.BLUE : Color.RED;

grilleTirs.colorie(c, couleur);

switch (etat) {

case TOUCHE:

JOptionPane.showMessageDialog(grilleTirs, "Vous avez touché un navire en " + c);

break;

case COULE:

JOptionPane.showMessageDialog(grilleTirs, "Vous avez coulé un navire en " + c);

break;

case GAMEOVER:

JOptionPane.showMessageDialog(grilleTirs, "Vous avez gagné!!!");

}

}

}

3.1 Définir les constructeurs suivants.


- public JoueurGraphique(GrilleNavaleGraphique grilleDefense,

GrilleGraphique grilleTirs, String nom) 

permet d'obtenir un joueur graphique de nom nom qui effectue des tirs en cliquant sur grilleTirs et dont la flotte est placée sur grilleDefense.

- public JoueurGraphique(GrilleNavaleGraphique grilleDefense, GrilleGraphique grilleTirs)

permet d'obtenir un joueur graphique qui effectue des tirs en cliquant sur grilleTirs et dont la flotte est placée sur grilleDefense.

3.2 Définir les méthodes suivantes.

- public Coordonnee choisirAttaque()

Consiste à récupérer la coordonnée choisie depuis grilleTirs.

- protected void retourDefense(Coordonnee c, int etat)

Affichage d'un JOptionPane lorsque le tir a touché ou coulé un navire, ou lorsque la partie est perdue.


4. Classe BatailleNavale

Créer la classe BatailleNavale qui correspond à une interface graphique.
Dans cette interface: on pourra écrire les noms des joueurs et choisir le type de joeur.
Cette interface graphique peut être créée à l'aide de WindowBuilder en sélectionnant, Swing/Application Window.



package batailleNavale;

public class BatailleNavale {

private Joueur joueur1, joueur2;

private int tailleGrille;

private void demarrerPartie() {

new Thread() {

public void run() {

joueur1.jouerAvec(joueur2);

}

}.start();

}

}


Prévoir dans cette classe 2 attributs de type Joueur et une méthode demarrerPartie() permettant de lancer la partie dans un nouveau thread.

