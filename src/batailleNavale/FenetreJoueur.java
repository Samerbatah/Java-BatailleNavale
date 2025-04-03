package batailleNavale;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Dimension;

public class FenetreJoueur extends JFrame {

	private JPanel contentPane;

	private GrilleGraphique grilleTirs;
	private GrilleNavaleGraphique grilleDefense;

	
	
	
	public FenetreJoueur() {
		this("Nom du joueur", 10);	
	}
	
	
	public FenetreJoueur(String nom, int taille) {
		this.grilleTirs = new GrilleGraphique(taille);
		this.grilleDefense = new GrilleNavaleGraphique(taille);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new GridLayout(1, 2));
		setContentPane(contentPane);
		
		JPanel panel1_grilleDeTir = new JPanel();
		panel1_grilleDeTir.setMinimumSize(new Dimension(0, 0));
		panel1_grilleDeTir.setOpaque(false);
		panel1_grilleDeTir.setAutoscrolls(true);
		panel1_grilleDeTir.setBorder(BorderFactory.createTitledBorder("Grille de tir"));
		contentPane.add(panel1_grilleDeTir);
		
		JPanel panel2_grilleDeTir = new JPanel();
		panel2_grilleDeTir.setMinimumSize(new Dimension(0, 0));
		panel2_grilleDeTir.setAutoscrolls(true);
		panel2_grilleDeTir.setBorder(BorderFactory.createTitledBorder("Grille de défense"));
		contentPane.add(panel2_grilleDeTir);
		
		

		panel1_grilleDeTir.add(getGrilleTirs());
		panel2_grilleDeTir.add(grilleDefense.getGrilleGraphique());
		

	}
	
	public GrilleGraphique getGrilleTirs() {
		return grilleTirs;
	}
	
	public GrilleNavaleGraphique getGrilleDefense() {
		return grilleDefense;
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
					FenetreJoueur frame = new FenetreJoueur("Joueur", 10);
					frame.pack();
					//frame.setSize(600,600);
					frame.setVisible(true);
			}
		});
	}

}