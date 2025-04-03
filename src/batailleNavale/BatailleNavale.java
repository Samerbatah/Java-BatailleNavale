package batailleNavale;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.synth.SynthSpinnerUI;
import javax.swing.UIManager;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.BoxLayout;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BatailleNavale {
	private Joueur joueur1, joueur2;
	private int tailleGrille;
	private JFrame frmBatailleNavale;

	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private final ButtonGroup buttonGroup_Joueur1 = new ButtonGroup();
	private final ButtonGroup buttonGroup_Joueur2 = new ButtonGroup();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BatailleNavale window = new BatailleNavale();
					window.frmBatailleNavale.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void demarrerPartie() {
		new Thread() {
			public void run() {
				joueur1.jouerAvec(joueur2);
			}
		}.start();
	}

	public BatailleNavale() {
		initialize();
	}

	private void initialize() {
		frmBatailleNavale = new JFrame();
		frmBatailleNavale.setResizable(false);
		frmBatailleNavale.setTitle("Bataille Navale");
		frmBatailleNavale.setBounds(100, 100, 260, 440);
		frmBatailleNavale.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBatailleNavale.getContentPane().setLayout(null);

		JPanel panel1 = new JPanel();
		panel1.setBounds(0, 1, 250, 33);
		panel1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		frmBatailleNavale.getContentPane().add(panel1);
		panel1.setLayout(new BoxLayout(panel1, BoxLayout.X_AXIS));
		JLabel lblTailleDeGrille = new JLabel("Taille de grille : ");
		lblTailleDeGrille.setFont(new Font("Dialog", Font.BOLD, 13));
		panel1.add(lblTailleDeGrille);
		textField = new JTextField();
		panel1.add(textField);
		textField.setColumns(10);
		JPanel panel2 = new JPanel();
		panel2.setBounds(0, 41, 250, 320);
		frmBatailleNavale.getContentPane().add(panel2);
		panel2.setLayout(new GridLayout(2, 0, 0, 0));
		JPanel panel_Joueur1 = new JPanel();
		panel_Joueur1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Joueur 1",
				TitledBorder.LEADING, TitledBorder.TOP, null));
		panel2.add(panel_Joueur1);
		panel_Joueur1.setLayout(new GridLayout(5, 0, 0, 0));
		JPanel panel = new JPanel();
		panel_Joueur1.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		JLabel lblNom = new JLabel("Nom : ");
		lblNom.setFont(new Font("Dialog", Font.BOLD, 13));
		panel.add(lblNom);
		textField_1 = new JTextField();
		panel.add(textField_1);
		textField_1.setColumns(10);
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Joueur graphique");
		buttonGroup_Joueur1.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setFont(new Font("Dialog", Font.BOLD, 13));
		panel_Joueur1.add(rdbtnNewRadioButton);
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Joueur Texte");
		buttonGroup_Joueur1.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setFont(new Font("Dialog", Font.BOLD, 13));
		panel_Joueur1.add(rdbtnNewRadioButton_1);
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Joueur Auto");
		buttonGroup_Joueur1.add(rdbtnNewRadioButton_2);
		rdbtnNewRadioButton_2.setFont(new Font("Dialog", Font.BOLD, 13));
		panel_Joueur1.add(rdbtnNewRadioButton_2);
		JPanel panel_Joueur2 = new JPanel();
		panel_Joueur2.setBorder(BorderFactory.createTitledBorder("Joueur 2"));
		panel2.add(panel_Joueur2);
		panel_Joueur2.setLayout(new GridLayout(5, 0, 0, 0));
		JPanel panel_1 = new JPanel();
		panel_Joueur2.add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		JLabel lblNewLabel = new JLabel("Nom : ");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 13));
		panel_1.add(lblNewLabel);
		textField_2 = new JTextField();
		panel_1.add(textField_2);
		textField_2.setColumns(10);

		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Joueur graphique");
		rdbtnNewRadioButton_3.setFont(new Font("Dialog", Font.BOLD, 13));
		buttonGroup_Joueur2.add(rdbtnNewRadioButton_3);
		panel_Joueur2.add(rdbtnNewRadioButton_3);

		JRadioButton rdbtnNewRadioButton_5 = new JRadioButton("Joueur Auto");
		rdbtnNewRadioButton_5.setFont(new Font("Dialog", Font.BOLD, 13));
		buttonGroup_Joueur2.add(rdbtnNewRadioButton_5);
		panel_Joueur2.add(rdbtnNewRadioButton_5);

		JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("Joueur Texte");
		rdbtnNewRadioButton_4.setFont(new Font("Dialog", Font.BOLD, 13));
		buttonGroup_Joueur2.add(rdbtnNewRadioButton_4);
		panel_Joueur2.add(rdbtnNewRadioButton_4);

		JPanel panel3 = new JPanel();
		panel3.setBounds(20, 360, 280, 53);
		frmBatailleNavale.getContentPane().add(panel3);
		panel3.setLayout(null);
		JButton btnLancerLaPartie = new JButton("Lancer la partie");
		btnLancerLaPartie.addActionListener(new ActionListener() {

//////////  Debut Click Bouton 

			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						int[] tabNav = { 2, 3, 4 };
						tailleGrille = Integer.parseInt(textField.getText());


						if (rdbtnNewRadioButton.isSelected()) {

							FenetreJoueur fen = new FenetreJoueur(textField_1.getText(), tailleGrille);
							fen.getGrilleDefense().placementAuto(tabNav);
							fen.pack();
							fen.setTitle("Jeu Bataille Navale: " + textField_1.getText());
							fen.setVisible(true);
							joueur1 = new JoueurGraphique(fen.getGrilleDefense(), fen.getGrilleTirs(),
									textField_1.getText());
						}
						if (rdbtnNewRadioButton_1.isSelected()) {
// System.out.println("bouton Joueur text");
							GrilleNavale grilleJ1 = new GrilleNavale(tailleGrille, tabNav);
							grilleJ1.placementAuto(tabNav);
							joueur1 = new JoueurTexte(grilleJ1, textField_1.getText());
						}
// ################# JoueurAuto1 ####################################
						if (!rdbtnNewRadioButton_5.isSelected() && rdbtnNewRadioButton_2.isSelected()) {
							System.out.println("bouton Joueur auto");
							FenetreJoueur fen = new FenetreJoueur(textField_1.getText(), tailleGrille);
							fen.getGrilleDefense().placementAuto(tabNav);
							fen.pack();
							fen.setTitle("Jeu Bataille Navale: " + textField_1.getText());
							fen.setVisible(false);
							joueur1 = new JoueurAuto(fen.getGrilleDefense(), textField_1.getText());
						}
						if (rdbtnNewRadioButton_5.isSelected() && rdbtnNewRadioButton_2.isSelected()) {
							System.out.println("bouton Joueur auto");
							FenetreJoueur fen = new FenetreJoueur(textField_1.getText(), tailleGrille);
							fen.getGrilleDefense().placementAuto(tabNav);
							fen.pack();
							fen.setTitle("Jeu Bataille Navale: " + textField_1.getText());
							fen.setVisible(true);
							joueur1 = new JoueurAuto(fen.getGrilleDefense(), textField_1.getText());
						} ///////////////////
						if (rdbtnNewRadioButton_3.isSelected()) {
// System.out.println("bouton Joueur graphique1");
							FenetreJoueur fen2 = new FenetreJoueur(textField_2.getText(), tailleGrille);
							fen2.getGrilleDefense().placementAuto(tabNav);
							fen2.pack();
							fen2.setTitle("Jeu Bataille Navale: " + textField_2.getText());
							fen2.setVisible(true);
							joueur2 = new JoueurGraphique(fen2.getGrilleDefense(), fen2.getGrilleTirs(),
									textField_2.getText());
						}
						if (rdbtnNewRadioButton_4.isSelected()) {
// System.out.println("bouton Joueur text1");
							GrilleNavale grilleJ2 = new GrilleNavale(tailleGrille, tabNav);
							//grilleJ2.placementAuto(tabNav);
							joueur2 = new JoueurTexte(grilleJ2, textField_2.getText());
						}
// ################# JoueurAuto2 ####################################
						if (!rdbtnNewRadioButton_2.isSelected() && rdbtnNewRadioButton_5.isSelected()) {
// System.out.println("bouton Joueur auto1");
							FenetreJoueur fen2 = new FenetreJoueur(textField_2.getText(), tailleGrille);
							fen2.getGrilleDefense().placementAuto(tabNav);
							fen2.pack();
							fen2.setTitle("Jeu Bataille Navale: " + textField_2.getText());
							fen2.setVisible(false);
							joueur2 = new JoueurAuto(fen2.getGrilleDefense(), textField_2.getText());
						}
						if (rdbtnNewRadioButton_2.isSelected() && rdbtnNewRadioButton_5.isSelected()) {
// System.out.println("bouton Joueur auto1");
							FenetreJoueur fen2 = new FenetreJoueur(textField_2.getText(), tailleGrille);
							fen2.getGrilleDefense().placementAuto(tabNav);
							fen2.pack();
							fen2.setTitle("Jeu Bataille Navale: " + textField_2.getText());
							fen2.setVisible(true);
							joueur2 = new JoueurAuto(fen2.getGrilleDefense(), textField_2.getText());
						}
// ################################ DEMARRER PARTIE ############################
						demarrerPartie();
					}
				});
			}
		});
		btnLancerLaPartie.setFont(new Font("Dialog", Font.BOLD, 13));
		btnLancerLaPartie.setBounds(27, 12, 135, 27);
		panel3.add(btnLancerLaPartie);
	}
}