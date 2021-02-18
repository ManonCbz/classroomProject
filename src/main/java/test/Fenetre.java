package test;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.LineBorder;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;


public class Fenetre extends JFrame {

	private static final long serialVersionUID = 1L;
	
	JTextField eleveTxt;
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();
	JPanel panel4 = new JPanel();
	JPanel panel5 = new JPanel();
	JPanel panel6 = new JPanel();
	final JButton backButton = new JButton("Retour");
	
	public Fenetre() {
		
		// Gestion de la fenêtre
		super("Gestion des élèves");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 400);
		this.setLocationRelativeTo(null);
		
		// =========================== Panel1 (Accueil) ============================ //
		
		panel1.setLayout(null);
		JLabel menuLabel = new JLabel("MENU");
		JLabel rechercheLabel = new JLabel("Rechercher un élève : ");
		eleveTxt = new JTextField("Nom Prénom");
		JButton rechercheBouton = new JButton("Rechercher");
		JButton ajoutNotesBouton = new JButton("Ajouter une note");
		JButton voirClasseBouton = new JButton("Voir les classes");
		JButton ajoutELeve = new JButton("Ajouter un élève");
		
		menuLabel.setBounds(280, 30, 100, 30);
		rechercheLabel.setBounds(90, 100, 250, 30);
		eleveTxt.setBounds(90, 130, 250, 30);
		rechercheBouton.setBounds(370, 130, 120, 30);
		ajoutELeve.setBounds(340, 260, 150, 30);
		ajoutNotesBouton.setBounds(340, 300, 150, 30);
		voirClasseBouton.setBounds(40, 300, 150, 30);

		panel1.add(menuLabel);
		panel1.add(rechercheLabel);
		panel1.add(eleveTxt);
		panel1.add(rechercheBouton);
		panel1.add(ajoutNotesBouton);
		panel1.add(voirClasseBouton);
		panel1.add(ajoutELeve);

		panel2.setLayout(null);
		panel3.setLayout(null);
		panel4.setLayout(null);
		panel5.setLayout(null);

		backButton.setBounds(420, 300, 120, 30);
		
		this.setContentPane(this.panel1);
		
		
		// ----- Action Listener -> Bouton Recherche Ã‰leve ----- //
		
		rechercheBouton.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	            Fenetre.this.afficheMenuRechercheEleve();
	            rechercheEleve(null);
			}
		});
		
		// ----- Action Listener -> Bouton Ajouter Notes ----- //
		
		ajoutNotesBouton.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	            Fenetre.this.afficheMenuAjoutNote();
	            ajoutNote();
			}
		});
		
		// ----- Action Listener -> Bouton Voir Classes ----- //
		
		voirClasseBouton.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	            Fenetre.this.menuClasse();
	            voirClasse();
			}
		});
		
		// ----- Action Listener -> Bouton Voir Classes ----- //
		
		ajoutELeve.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuAjoutEleve();
				ajouterEleve();
			}
		});
		
		// ----- Action Listener -> Bouton Retour ----- //

		backButton.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	            Fenetre.this.retourAcceuil();
	            panel2.removeAll();
	    		panel3.removeAll();
	    		panel4.removeAll();
	    		panel5.removeAll();
	    		panel6.removeAll();
	    		eleveTxt.setBorder(new LineBorder(Color.LIGHT_GRAY, 1));
			}
		});
	}
	
	
	// ======================================= Main ======================================= //
	
	public static void main(String[] args) {

		// Ajoute un look
		try {
			UIManager.setLookAndFeel(new NimbusLookAndFeel());
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		// Appel de la fenÃªtre
		Fenetre fenetre = new Fenetre();
		fenetre.setVisible(true);
		
	}
	
	
	// ======================================================================================== //
	// ======================================= Fonction ======================================= //
	
	public class MyTableModel extends AbstractTableModel {

	      /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public boolean isCellEditable(int row, int column){  
	          return false;  
	      }

		public int getRowCount() {
			// TODO Auto-generated method stub
			return 0;
		}

		public int getColumnCount() {
			// TODO Auto-generated method stub
			return 0;
		}

		public Object getValueAt(int rowIndex, int columnIndex) {
			// TODO Auto-generated method stub
			return null;
		}

	}
	
	// ================= Action Listener -> Changement panel ==================== //
	
	public void retourAcceuil() {
		this.setContentPane(this.panel1);
		this.revalidate();
	}
	
	public void afficheMenuRechercheEleve() {
		this.setContentPane(this.panel2);
		this.revalidate();
	}
	
	public void afficheMenuAjoutNote() {
		this.setContentPane(this.panel3);
		this.revalidate();
	}
	
	public void menuClasse() {
		this.setContentPane(this.panel4);
		this.revalidate();
	}
	
	public void menuAjoutEleve() {
		this.setContentPane(this.panel5);
		this.revalidate();
	}
	
	public void menuModifEleve() {
		this.setContentPane(this.panel6);
		this.revalidate();
	}
	
	// =============================== Database ================================= //
	
	public void rechercheEleve(String nomPrenomEleveString) {
				
		Connection conn = null;
		
		try {

			// ==================== Connexion DB ==================== //

			Class.forName("org.postgresql.Driver");

			String url = "jdbc:postgresql://localhost:5432/classe";
			String user = "postgres";
			String passwd = "4991";
			
			conn = DriverManager.getConnection(url, user, passwd);
			
			Statement state = conn.createStatement();
			
			// ===================== Declaration d'elements ===================== //
			
			String query = "SELECT CONCAT(eleve.nom, ' ', eleve.prenom) FROM eleve;";
			ResultSet result = state.executeQuery(query);
			ResultSetMetaData resultMeta = result.getMetaData();
			
			while (result.next()) {
				
				if (result.getString("concat").equalsIgnoreCase(eleveTxt.getText().toString())) {
					nomPrenomEleveString = eleveTxt.getText().toString();
					break;
				}
			}
			
			String classeEleveString = chercheClasse(nomPrenomEleveString, state);
			String dateNaissance = dateNaissance(nomPrenomEleveString, state);
			String matieres = chercheMatiereString(nomPrenomEleveString, state);
			if (matieres.equalsIgnoreCase("</html>")) matieres = "";
			String moyennes = chercheMoyenne(nomPrenomEleveString, state);
			if (moyennes.equalsIgnoreCase("</html>")) moyennes = "";
			String moyenneGen = moyenneGen(nomPrenomEleveString, state);

			if (nomPrenomEleveString != null) {
				
				eleveTxt.setText("Nom Prénom");
				// ===================== Ajout elements panel2 ====================== //

				// ==== Nom Prenom
				JLabel nomPrenomEleve = new JLabel(nomPrenomEleveString.toUpperCase());
				nomPrenomEleve.setBounds(40, 40, 300, 20);
				panel2.add(nomPrenomEleve);
				
				// ==== Classe
				JLabel classeEleve = new JLabel(classeEleveString.toUpperCase());
				classeEleve.setBounds(500, 40, 50, 20);
				panel2.add(classeEleve);
				
				// ==== Date de naissance
				JLabel dateNaissanceEleve = new JLabel(dateNaissance);
				dateNaissanceEleve.setBounds(40, 60, 300, 30);
				panel2.add(dateNaissanceEleve);
				
				// ==== Bordure
				JLabel bordure = new JLabel("--------------------------------------------------------------------------------------------------------------------------");
				bordure.setBounds(40, 80, 520, 30);
				panel2.add(bordure);
				
				// ==== Moyennes par matieres
				JLabel noteLabel = new JLabel("<html><u>Moyennes par matières :</u></html>");
				noteLabel.setBounds(40, 110, 520, 30);
				panel2.add(noteLabel);
				// Liste des matieres
				JLabel labelMatieres = new JLabel(matieres);
				labelMatieres.setBounds(40, 140, 80, 150);
				panel2.add(labelMatieres);
				// Liste des notes
				JLabel labelMoyennesMatieres = new JLabel(moyennes);
				labelMoyennesMatieres.setBounds(125, 140, 80, 150);
				panel2.add(labelMoyennesMatieres);
				
				// ==== Moyenne Générale
				JLabel moyenneGenLabel = new JLabel("Moyenne générale : " + moyenneGen);
				moyenneGenLabel.setBounds(400, 110, 520, 30);
				panel2.add(moyenneGenLabel);
				
				// ==== Supprimer élève
				JButton suppr = new JButton("Supprimer l'élève");
				suppr.setBounds(40, 300, 150, 30);
				panel2.add(suppr);
				
				// ==== Modifier info élève
				JButton modif = new JButton("Modifier ses informations");
				modif.setBounds(205, 300, 200, 30);
				panel2.add(modif);
				
				// ==== Bouton Retour
				panel2.add(backButton);
					
				final String nom = nomPrenomEleveString;
				
				// ----- Action Listener -> Bouton Supprimer un élève ----- //

				suppr.addActionListener( new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							supprimerEleve(nom);
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
			            Fenetre.this.retourAcceuil();
			            panel2.removeAll();
			    		panel3.removeAll();
			    		panel4.removeAll();
			    		panel5.removeAll();
			    		panel6.removeAll();
			    		eleveTxt.setBorder(new LineBorder(Color.LIGHT_GRAY, 1));
					}
				});
				
				// ----- Action Listener -> Bouton Modifier un élève ----- //

				modif.addActionListener( new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							menuModifEleve();
							//modifierEleve();
					}
				});
			}
			else {
				eleveTxt.setBorder(new LineBorder(Color.RED, 2));
				Fenetre.this.retourAcceuil();
			}
			
			state.close();

		} catch (Exception e) {
				e.printStackTrace();
		}
				
	}
	
	public void ajoutNote() {
		
		// ======================= Affichage Panel ======================= //
		
		// ==== Nom Menu
		JLabel nomMenu = new JLabel("AJOUTER DES NOTES");
		nomMenu.setBounds(225, 40, 150, 30);
		panel3.add(nomMenu);
	
		// ========== Formulaire ========== //
		// ==== Label Formulaire
		JLabel labelFormNom = new JLabel("   Nom");
		JLabel labelFormPrenom = new JLabel("   Prénom");
		JLabel labelFormMatiere = new JLabel("   Matière");
		JLabel labelFormNote = new JLabel("   Note");

		labelFormNom.setBounds(40, 90, 140, 30);
		labelFormPrenom.setBounds(180, 90, 140, 30);
		labelFormMatiere.setBounds(320, 90, 140, 30);
		labelFormNote.setBounds(460, 90, 100, 30);

		panel3.add(labelFormNom);
		panel3.add(labelFormPrenom);
		panel3.add(labelFormMatiere);
		panel3.add(labelFormNote);
		
		// ==== JTextFiel Nom élève
		final JTextField nomEleve1 = new JTextField();
		nomEleve1.setBounds(40, 130, 120, 30);
		panel3.add(nomEleve1);
		
		// ==== JTextFiel Prénom
		final JTextField prenomEleve1 = new JTextField();
		prenomEleve1.setBounds(180, 130, 120, 30);
		panel3.add(prenomEleve1);
		
		// ==== JTextFiel Matière
		final JTextField matiere1 = new JTextField();
		matiere1.setBounds(320, 130, 120, 30);
		panel3.add(matiere1);
		
		// ==== JTextFiel Note
		final JTextField note1 = new JTextField();
		note1.setBounds(460, 130, 80, 30);
		panel3.add(note1);
		

		// ==== Bouton enregistré
		JButton boutonEnregistre = new JButton("Enregistrer");
		boutonEnregistre.setBounds(300, 300, 120, 30);
		panel3.add(boutonEnregistre);
		
		// ==== Bouton de retour
		panel3.add(backButton); 
		
		// ==== Message de Confirmation & Erreur (Visible après l'utilisation du bouton "Enregistrer")
		final JLabel confirmation = new JLabel("Ok \u2713");
		confirmation.setBounds(250, 300, 120, 30);
		panel3.add(confirmation);
		confirmation.setVisible(false);
		
		final JLabel erreur = new JLabel("Erreur \u274C");
		erreur.setBounds(230, 300, 120, 30);
		panel3.add(erreur);
		erreur.setVisible(false);
		

		// ------------ Action Listener -> Bouton Enregistre ------------ //

		boutonEnregistre.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {

				
				// Cache les messages d'erreur ou confirmation (si re-appuis sur le bouton)
				confirmation.setVisible(false);
				erreur.setVisible(false);

				// Remet les bordures des JTextfield neutre (si re-appuis sur le bouton)
				nomEleve1.setBorder(new LineBorder(Color.LIGHT_GRAY, 1));
				prenomEleve1.setBorder(new LineBorder(Color.LIGHT_GRAY, 1));
				matiere1.setBorder(new LineBorder(Color.LIGHT_GRAY, 1));
				note1.setBorder(new LineBorder(Color.LIGHT_GRAY, 1));
				
				// Recuperation des valeurs des JTextfield
				String nomValue = nomEleve1.getText().toString();
				String prenomValue = prenomEleve1.getText().toString();
				String matiereValue = matiere1.getText().toString();
				String noteValue = note1.getText().toString();
				int noteInt;				
				
				// Converti la valeur de la JTextfield note en INT, si ko : -1
				try {
					noteInt = Integer.parseInt(noteValue);
				}
				catch (final NumberFormatException exception) {
					noteInt = -1;
				}
				
				// Si toutes cases remplies && note entre 0 et 20
				if (!nomValue.equals("") && !prenomValue.equals("") && !matiereValue.equals("") && !noteValue.equals("") && noteInt >= 0 && noteInt <= 20){
					
					// Connexion Ã  la DB
					Connection conn = null;
					
					try {
						Class.forName("org.postgresql.Driver");

						String url = "jdbc:postgresql://localhost:5432/classe";
						String user = "postgres";
						String passwd = "4991";
						
						conn = DriverManager.getConnection(url, user, passwd);
						
						Statement state = conn.createStatement();
						String nomPrenomEleveString = nomValue + " " + prenomValue;
						
						// Liste qui récupère l'id de l'élève & l'id de la matière concerné
						ArrayList<Integer> ids = idsAjoutNote(state, nomPrenomEleveString, matiereValue);
						
						// Requête préparé --> Envoi des données dans la DB
						String query = "INSERT INTO note(note, id_eleve, id_matiere) VALUES(?, ?, ?)";

						PreparedStatement prepare = conn.prepareStatement(query);
						
						prepare.setInt(1, noteInt);
						prepare.setInt(2, ids.get(0));
						prepare.setInt(3,  ids.get(1));
						
						prepare.executeUpdate();
						
						state.close();
					
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					
					// Affiche le message de confirmation & Vide les JTextfield
					confirmation.setVisible(true);
					nomEleve1.setText("");
					prenomEleve1.setText("");
					matiere1.setText("");
					note1.setText("");
					
				}
				else {

					// Affiche le message d'erreur
					erreur.setVisible(true);
					
					// Pour chaque erreur, change la bordure du jtextfield concerné -> rouge
					if (nomValue.equals("")) nomEleve1.setBorder(new LineBorder(Color.RED, 2));
					if (prenomValue.equals("")) prenomEleve1.setBorder(new LineBorder(Color.RED, 2));
					if (matiereValue.equals("")) matiere1.setBorder(new LineBorder(Color.RED, 2));
					if (noteValue.equals("") || noteInt < 0 || noteInt > 20 ) note1.setBorder(new LineBorder(Color.RED, 2));
				}
			}
		});
		
	}
	 
	public void voirClasse() {
		
		// Déclaration
		
		int nombreLigneTab = 0;
		
		// ======================= Database ======================= //
		
		Connection conn = null;
		
		try {
			Class.forName("org.postgresql.Driver");

			String url = "jdbc:postgresql://localhost:5432/classe";
			String user = "postgres";
			String passwd = "4991";
			
			conn = DriverManager.getConnection(url, user, passwd);
			
			Statement state = conn.createStatement();
			
			// RequÃªte qui sélectionne l'id de l'élève renseigne
			Integer idEleve = null;

			ResultSet result = state.executeQuery("SELECT id_classe, COUNT(eleve.id) FROM eleve GROUP BY id_classe ORDER BY count DESC LIMIT 1;");
			ResultSetMetaData resultMeta = result.getMetaData();
			
			while (result.next()) {
				nombreLigneTab = result.getInt("count");
			}
						
			// ======================= éléments Panel ======================= //
			
	        String[] entetes = {"CP", "CE1", "CE2", "CM1", "CM2"};
	        String donnees[][] = new String[nombreLigneTab][5];

	        for (int i = 0; i < 5; i++) {
								
	        	String query2 = "SELECT CONCAT(eleve.nom, ' ', eleve.prenom), classe.nom FROM eleve, classe WHERE eleve.id_classe = classe.id_classe AND classe.nom = '" + entetes[i].toLowerCase() + "';";
	        	ResultSet result3 = state.executeQuery(query2);
				ResultSetMetaData resultMeta3 = result3.getMetaData();
				
				int count = 0;
				
				while (result3.next()) {
							
					donnees[count][i] = result3.getString("concat");
					count++;
					
				}
	        }
	        
		    JTable test = new JTable(donnees, entetes) {
		        private static final long serialVersionUID = 1L;

		        public boolean isCellEditable(int row, int column) {                
		                return false;               
		        };
		    };
			JScrollPane scrollPane = new JScrollPane(test);
			scrollPane.setColumnHeaderView(test.getTableHeader());
			scrollPane.setBounds(8, 70, 570, 200);
			panel4.add(scrollPane);
			
			test.addMouseListener(new MouseAdapter() {
				
				public void mouseClicked(MouseEvent e) {
					
					if (e.getClickCount() == 2) {
						JTable target = (JTable)e.getSource();
						int row = target.getSelectedRow();
						int column = target.getSelectedColumn();
						String recherche  = target.getValueAt(row, column).toString();
						
						afficheMenuRechercheEleve();
						rechercheEleve(recherche);
					}
				}
			});
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		JLabel nomCategorie = new JLabel("LISTE DES CLASSES");
		nomCategorie.setBounds(230, 20, 120, 30);
		panel4.add(nomCategorie);
		
		panel4.add(backButton);
		
	}
	
	public void ajouterEleve() {
		
		// ======================= Affichage Panel ======================= //
		
		// ==== Nom Menu
		JLabel nomMenu = new JLabel("AJOUTER UN ÉLÈVE");
		nomMenu.setBounds(225, 40, 150, 30);
		panel5.add(nomMenu);
	
		// ========== Formulaire ========== //
		// ==== Label Formulaire
		JLabel labelFormNom = new JLabel("   Nom");
		JLabel labelFormPrenom = new JLabel("   Prénom");
		JLabel labelFormMatiere = new JLabel("   Date de naissance");
		JLabel labelFormNote = new JLabel("   Classe");

		labelFormNom.setBounds(40, 90, 140, 30);
		labelFormPrenom.setBounds(180, 90, 140, 30);
		labelFormMatiere.setBounds(320, 90, 140, 30);
		labelFormNote.setBounds(460, 90, 100, 30);

		panel5.add(labelFormNom);
		panel5.add(labelFormPrenom);
		panel5.add(labelFormMatiere);
		panel5.add(labelFormNote);
		
		// ==== JTextFiel Nom élève
		final JTextField nomEleve1 = new JTextField();
		nomEleve1.setBounds(40, 130, 120, 30);
		panel5.add(nomEleve1);
		
		// ==== JTextFiel Prénom
		final JTextField prenomEleve1 = new JTextField();
		prenomEleve1.setBounds(180, 130, 120, 30);
		panel5.add(prenomEleve1);
		
		// ==== JTextFiel Date de naissance
		final JTextField dateNaissance = new JTextField();
		dateNaissance.setBounds(320, 130, 120, 30);
		panel5.add(dateNaissance);
		
		// ==== JTextFiel Classe
		final JTextField classe = new JTextField();
		classe.setBounds(460, 130, 80, 30);
		panel5.add(classe);
		

		// ==== Bouton enregistré
		JButton boutonEnregistre = new JButton("Enregistrer");
		boutonEnregistre.setBounds(300, 300, 120, 30);
		panel5.add(boutonEnregistre);
		panel5.add(backButton);
		
		// ==== Message de Confirmation & Erreur (Visible après l'utilisation du bouton "Enregistrer")
		final JLabel confirmation = new JLabel("Ok \u2713");
		confirmation.setBounds(250, 300, 120, 30);
		panel5.add(confirmation);
		confirmation.setVisible(false);
		
		final JLabel erreur = new JLabel("Erreur \u274C");
		erreur.setBounds(230, 300, 120, 30);
		panel5.add(erreur);
		erreur.setVisible(false);
		
		boutonEnregistre.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {

				// Cache les messages d'erreur ou confirmation (si re-appuis sur le bouton)
				confirmation.setVisible(false);
				erreur.setVisible(false);

				// Remet les bordures des JTextfield neutre (si re-appuis sur le bouton)
				nomEleve1.setBorder(new LineBorder(Color.LIGHT_GRAY, 1));
				prenomEleve1.setBorder(new LineBorder(Color.LIGHT_GRAY, 1));
				dateNaissance.setBorder(new LineBorder(Color.LIGHT_GRAY, 1));
				classe.setBorder(new LineBorder(Color.LIGHT_GRAY, 1));
				
				// Recuperation des valeurs des JTextfield
				String nomValue = nomEleve1.getText().toString();
				String prenomValue = prenomEleve1.getText().toString();
				String dateNaissanceValue = dateNaissance.getText().toString();
				String classeValue = classe.getText().toString().toLowerCase();
								
				// Converti la valeur du JTextfield en Date
				
				SimpleDateFormat formatDate = new SimpleDateFormat("YYYY-MM-DD");
				Date dateNaissanceDate;
				
				try {
					java.util.Date dateNaissanceDateUtil = formatDate.parse(dateNaissanceValue);
					dateNaissanceDate = new java.sql.Date(dateNaissanceDateUtil.getTime());
				} catch (ParseException e2) {
					dateNaissanceDate = null;
				}
 
				
				// Si toutes cases remplies
				if (!nomValue.equals("") && !prenomValue.equals("") && !dateNaissanceValue.equals("") && !classeValue.equals("") && dateNaissanceDate != null){
					
					// Connexion Ã  la DB
					Connection conn = null;
					
					try {
						Class.forName("org.postgresql.Driver");

						String url = "jdbc:postgresql://localhost:5432/classe";
						String user = "postgres";
						String passwd = "4991";
						
						conn = DriverManager.getConnection(url, user, passwd);
						
						Statement state = conn.createStatement();
						
						// RequÃªte prepare --> Envoi des données dans la DB
						String query = "INSERT INTO eleve(nom, prenom, date_naissance, id_classe) VALUES(?, ?, ?, ?)";

						PreparedStatement prepare = conn.prepareStatement(query);
						
						prepare.setString(1, nomValue);
						prepare.setString(2, prenomValue);
						prepare.setDate(3, dateNaissanceDate);
						
						int classeId = 0;
						if(classeValue.equals("cp")) classeId = 1;
						if(classeValue.equals("ce1")) classeId = 2;
						if(classeValue.equals("ce2")) classeId = 3;
						if(classeValue.equals("cm1")) classeId = 4;
						if(classeValue.equals("cm2")) classeId = 5;

						
						prepare.setInt(4, classeId);
						
						prepare.executeUpdate();
						
						state.close();
					
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					
					// Affiche le message de confirmation & Vide les JTextfield
					confirmation.setVisible(true);
					nomEleve1.setText("");
					prenomEleve1.setText("");
					dateNaissance.setText("");
					classe.setText("");
					
				}
				else {

					// Affiche le message d'erreur
					erreur.setVisible(true);
					
					// Pour chaque erreur, change la bordure du jtextfield concerne -> rouge
					if (nomValue.equals("")) nomEleve1.setBorder(new LineBorder(Color.RED, 2));
					if (prenomValue.equals("")) prenomEleve1.setBorder(new LineBorder(Color.RED, 2));
					if (dateNaissanceValue.equals("") || dateNaissanceDate == null) dateNaissance.setBorder(new LineBorder(Color.RED, 2));
					if (classeValue.equals("")) classe.setBorder(new LineBorder(Color.RED, 2));

				}
			}
		});
		
	}
	
	public void modifierEleve(String nomPrenomEleveString) {
		
		JLabel titre = new JLabel("INFORMATIONS ELEVE");
		titre.setBounds(225, 40, 150, 30);
		panel6.add(titre);
		
		JLabel nomLabel = new JLabel("  Nom");
		nomLabel.setBounds(40, 100, 150, 20);
		panel6.add(nomLabel);
	
		JTextField nom = new JTextField();
		nom.setBounds(40, 120, 150, 30);
		panel6.add(nom);
		
		JLabel prenomLabel = new JLabel("  Prénom");
		prenomLabel.setBounds(40, 180, 150, 20);
		panel6.add(prenomLabel);
	
		JTextField prenom = new JTextField();
		prenom.setBounds(40, 200, 150, 30);
		panel6.add(prenom);
		
		JLabel dateLabel = new JLabel("  Date de naissance");
		dateLabel.setBounds(40, 260, 150, 20);
		panel6.add(dateLabel);
	
		JTextField date = new JTextField();
		date.setBounds(40, 280, 150, 30);
		panel6.add(date);
		
		JLabel classeLabel = new JLabel("  Classe");
		classeLabel.setBounds(340, 100, 150, 20);
		panel6.add(classeLabel);
	
		JTextField classe = new JTextField();
		classe.setBounds(340, 120, 150, 30);
		panel6.add(classe);
		
		panel6.add(backButton);

		// Connexion Ã  la DB
		Connection conn = null;
		
		try {
			Class.forName("org.postgresql.Driver");

			String url = "jdbc:postgresql://localhost:5432/classe";
			String user = "postgres";
			String passwd = "4991";
				
			conn = DriverManager.getConnection(url, user, passwd);
				
			Statement state = conn.createStatement();

			// Requête préparé --> Envoi des données dans la DB
			String query = "UPDATE eleve SET nom = ?, prenom = ?, date_naissance = ?, id_classe = ?";

			PreparedStatement prepare = conn.prepareStatement(query);
			
			//prepare.setString(1, );
			//prepare.setString(2, );
			//prepare.setDate(3, );
				
			state.close();
			
		} catch (Exception e1) {
			e1.printStackTrace();		
		}
		
	}
	
	// =============================== Recherche Database ================================= //
	
	// Retourne une liste de deux chiffres id eleve(0) & id matiere(1) 
	public ArrayList<Integer> idsAjoutNote(Statement state, String nomPrenomEleveString, String matiere) throws SQLException{
		
		// Déclarations
		ArrayList<Integer> ids = new ArrayList<Integer>();

		// RequÃªte qui sélectionne l'id de l'élève renseigne
		ResultSet result = state.executeQuery("SELECT id FROM eleve WHERE CONCAT(eleve.nom, ' ', eleve.prenom) = '" + nomPrenomEleveString + "'");
		ResultSetMetaData resultMeta = result.getMetaData();
		// Ajoute Ã  la liste
		while (result.next()) {
			ids.add(result.getInt("id"));
		}
		
		// Requête qui sélectionne l'id de la matiere renseignee
		ResultSet result2 = state.executeQuery("SELECT id_matiere FROM matiere WHERE nom = '" + matiere.toLowerCase() + "'");
		ResultSetMetaData resultMeta2 = result.getMetaData();
		// Ajoute Ã  la liste
		while (result2.next()) {
			ids.add(result2.getInt("id_matiere"));
		}
		
		result.close();
		result2.close();
		return ids;
	}

	public String chercheClasse(String nomPrenomEleveString, Statement state) throws SQLException {
		
		// Déclaration
		String classeEleveString = "";
		
		// RequÃªte qui sélectionne la classe l'élève renseigne dans le jtextfield
		ResultSet result = state.executeQuery("SELECT eleve.*, classe.nom as classe FROM eleve, classe WHERE classe.id_classe = eleve.id_classe AND CONCAT(eleve.nom, ' ', prenom) LIKE '" + nomPrenomEleveString + "';" );
		ResultSetMetaData resultMeta = result.getMetaData();
	
		// Renvoi le résultat
		while (result.next()) {
			classeEleveString = result.getString("classe");
		}
		
		result.close();
		return classeEleveString;
	}

	public String dateNaissance(String nomPrenomEleveString, Statement state) throws SQLException {
		
		// Déclaration
		Date date = null;
		
		// RequÃªte qui sélectionne la classe l'élève renseigne dans le jtextfield
		ResultSet result = state.executeQuery("SELECT * FROM eleve, classe WHERE CONCAT(eleve.nom, ' ', prenom) LIKE '" + nomPrenomEleveString + "';" );
		ResultSetMetaData resultMeta = result.getMetaData();
	
		// Renvoi le résultat
		while (result.next()) {
			date = result.getDate("date_naissance");
		}
		
		String dateString = new SimpleDateFormat("dd/MM/yyyy").format(date);
		
		result.close();
		return dateString;
		
	}
	
	public String chercheMatiereString(String nomPrenomEleveString, Statement state) throws SQLException {
		
		// Déclaration
		ArrayList<String> listeMatiere = new ArrayList<String>();
			
		// RequÃªte qui sélectionne toutes les matières étudié par l'élève renseigné dans le jtextfield
		ResultSet result = state.executeQuery("SELECT DISTINCT(matiere.nom) as matiere FROM eleve INNER JOIN note ON eleve.id = note.id_eleve INNER JOIN matiere ON note.id_matiere = matiere.id_matiere AND CONCAT(eleve.nom, ' ', prenom) LIKE '" + nomPrenomEleveString + "';");
		ResultSetMetaData resultMeta = result.getMetaData();

		// Ajoute chaque nom dans la liste
		while (result.next()) {
			listeMatiere.add(result.getString("matiere"));
		}
		
		// Converti l'entièreté de la liste en chaine de caracteres
		String matieres = "";
		
		for (int i = 0; i < listeMatiere.size(); i++) {
			
			if (!matieres.contains(listeMatiere.get(i).toString())) {
			
					matieres += "<html>" + listeMatiere.get(i).toString() + "<br>";					

			}		
		}
		
		matieres += "</html>";
		
		result.close();
		return matieres;
	}
	
	// Appel dans la fonction chercheMoyenne()
	public ArrayList<String> chercheMatiereListe(String nomPrenomEleveString, Statement state) throws SQLException {
		
		// Declaration
		ArrayList<String> listeMatiere = new ArrayList<String>();
			
		// RequÃªte qui selectionne toutes les matieres etudie par l'eleve renseigne dans le jtextfield
		ResultSet result = state.executeQuery("SELECT DISTINCT(matiere.nom) as matiere FROM eleve INNER JOIN note ON eleve.id = note.id_eleve INNER JOIN matiere ON note.id_matiere = matiere.id_matiere AND CONCAT(eleve.nom, ' ', prenom) LIKE '" + nomPrenomEleveString + "';");
		ResultSetMetaData resultMeta = result.getMetaData();

		// Ajoute chaque nom dans la liste & return
		while (result.next()) {
			listeMatiere.add(result.getString("matiere"));
		}

		result.close();
		return listeMatiere;
	}
	
	public String chercheMoyenne(String nomPrenomEleveString, Statement state) throws SQLException {
		
		// Declaration
		String moyennes = "";
		
		// Recupere la liste des matieres suivi par l'eleve
		ArrayList<String> listeMatiere = chercheMatiereListe(nomPrenomEleveString, state);
		
		// Pour chaque matiere
		for (int i = 0; i < listeMatiere.size(); i++) {
		
			// Execute la requÃªte pour afficher les notes de cette matiere
			ResultSet result = state.executeQuery("SELECT note FROM eleve INNER JOIN note ON eleve.id = note.id_eleve INNER JOIN matiere ON note.id_matiere = matiere.id_matiere AND CONCAT(eleve.nom, ' ', prenom) LIKE '" + nomPrenomEleveString + "' AND matiere.nom = '" + listeMatiere.get(i) + "';");
			ResultSetMetaData resultMeta = result.getMetaData();

			// Ajoute chaque note au total et compte le nombre de note pour calculer la moyenne
			double totalNotes = 0;
			int nombreDeNote = 0;
			
			while (result.next()) {
				totalNotes += result.getFloat("note");
				nombreDeNote++;
			}
			
			double moyenne = (totalNotes/nombreDeNote);
			
			// Arrondi 2 chiffres apres la virgule (Le resultat est converti en String)
			DecimalFormat df = new DecimalFormat();
			df.setMaximumFractionDigits(2);
			
			// Ajoute le resultat converti + html (saut de ligne) au String renvoye
			moyennes += "<html>" + df.format(moyenne) + "<br>";
			
			result.close();
		}

		moyennes +=  "</html>";
		return moyennes;
	}
	
	public String moyenneGen(String nomPrenomEleveString, Statement state) throws SQLException {
	
		// Declaration
		String moyenne = "";
		String moyenneGen = "";
		int nbMoyennes = 0;
		
		ArrayList<Double> listeMoyenne = new ArrayList<Double>();
		
		// Recupere la liste des matieres suivi par l'eleve 
		ArrayList<String> listeMatiere = chercheMatiereListe(nomPrenomEleveString, state);
		
		// Pour chaque matiere
		for (int i = 0; i < listeMatiere.size(); i++) {
		
			// Execute la requÃªte pour afficher les notes de cette matiere
			ResultSet result = state.executeQuery("SELECT note FROM eleve INNER JOIN note ON eleve.id = note.id_eleve INNER JOIN matiere ON note.id_matiere = matiere.id_matiere AND CONCAT(eleve.nom, ' ', prenom) LIKE '" + nomPrenomEleveString + "' AND matiere.nom = '" + listeMatiere.get(i) + "';");
			ResultSetMetaData resultMeta = result.getMetaData();

			// Ajoute chaque note au total et compte le nombre de note pour calculer la moyenne
			double totalNotes = 0;
			int nombreDeNote = 0;
			
			while (result.next()) {
				totalNotes += result.getFloat("note");
				nombreDeNote++;
			}
			
			double moyenneCalcul = (totalNotes/nombreDeNote);
			
			// Arrondi 2 chiffres apres la virgule (Le resultat est converti en String)
			DecimalFormat df = new DecimalFormat();
			df.setMaximumFractionDigits(2);
			
			listeMoyenne.add(moyenneCalcul);
			
			nbMoyennes++;
			
			result.close();
		}
				
		double totalMoyennes = 0;
		
		for (int i = 0; i < listeMoyenne.size(); i++) {
			totalMoyennes += listeMoyenne.get(i);
		}
		
		double moyenneGenCalcul = (totalMoyennes/nbMoyennes);

		// Arrondi 2 chiffres apres la virgule (Le resultat est converti en String)
		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(2);
		
		// Ajoute le resultat converti + html (saut de ligne) au String renvoye
		moyenneGen = df.format(moyenneGenCalcul);
		
		return moyenneGen;
		
	}
	
	public void supprimerEleve(String nomPrenomEleveString) throws SQLException {
		
		Connection conn = null;
		
		try {
			Class.forName("org.postgresql.Driver");

			String url = "jdbc:postgresql://localhost:5432/classe";
			String user = "postgres";
			String passwd = "4991";
			
			conn = DriverManager.getConnection(url, user, passwd);
			
			Statement state = conn.createStatement();
			
			// RequÃªte qui selectionne l'id de l'eleve renseigne
			Integer idEleve = null;

			ResultSet result = state.executeQuery("SELECT id FROM eleve WHERE CONCAT(eleve.nom, ' ', prenom) LIKE '" + nomPrenomEleveString + "';");
			ResultSetMetaData resultMeta = result.getMetaData();
						
			while (result.next()) {
				idEleve = result.getInt("id");
			}

			// RequÃªte pour supprimer les notes & l'eleve
			String query1 = "DELETE FROM note WHERE id_eleve = " + idEleve + ";";
			state.executeUpdate(query1);
			
			String query2 = "DELETE FROM eleve WHERE id = " + idEleve + ";";
			state.executeUpdate(query2);
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

}