package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableColumnModel;

import org.jfree.data.category.CategoryDataset;
import org.jfree.data.jdbc.JDBCCategoryDataset;

import net.proteanit.sql.DbUtils;

/**
 * Start BudgetFix:
 * 
 * Willkommen im Hauptfenster des BudgetFix!  Hier hat man nun die M�glichkeit eine �bersicht �ber die Einnahmen & Ausgaben zu haben.
 * Desweiteren kann man:
 * 		> Kategorien anlegen
 * 		> Transaktionen nach einen bestimmten Zeitraum abfragen
 * 		> Einnahmen & Ausgaben hinzuf�gen sowie bearbeiten oder l�schen
 * 
 * Auf der linken Seite befindet sich das Men�:
 * 		> via Icon-Klick gelangt man zu:
 * 				Wiederholung
 * 				Charts
 * 				Sparziele (work in process)
 * 				Tools				
 * 				Einstellungen
 * 
 * 
 * 
 * @author Zusammenarbeit: Que Ly Dong & Patric Kleine
 * 
 */


public class Start extends JFrame {

	/**
	 * Damit id nur f�r den Benutzer ge�ffnet wird! Und um die anderen Fenster
	 * auch �ffnen zu k�nnen
	 */
	private static final long serialVersionUID = 1L;
	
	Connection connection = null;
	Connection connec = null;
	Connection conne = null;
	Connection conn = null;
	Connection con = null;
	static int id;

	private JPanel contentPane;
	private JTable tableEinnahmen;
	private JTable tableAusgaben;
	private JTextField txtEinnahmenSumme;
	private JTextField txtAusgabenSumme;
	private JTextField txtGesamtbilanz;
	private JTextField txtJahr;
	private JTextField txtGesamt;
	private JTextField txtVormonat;
	private JTextField txtMonat;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Start frame = new Start(id);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Visualisierungsfenster
	 */
	public Start(int id) {

		this.id = id;
		// Verbindung zur BPDatenbank - Ertr�ge und Aufwendungen
		connection = BPDatenbank.dbCon();
		connec = BPDatenbank.dbCon();
		conne = BPDatenbank.dbCon();
		conn = BPDatenbank.dbCon();
		con = BPDatenbank.dbCon();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1338, 713);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		// Button Schliessen
		final JLabel btnSchliessen = new JLabel();
		btnSchliessen.setBounds(1280, 15, 40, 40);
		btnSchliessen.addMouseListener(new MouseAdapter() {
			@Override
			// Schliessenbutton in grau
			public void mouseEntered(MouseEvent arg0) {
				btnSchliessen.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("/Design/schliessengross2.png")));
			}

			// Schliessenbutton ist blau
			@Override
			public void mouseExited(MouseEvent arg0) {
				btnSchliessen.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("/Design/schliessengross.png")));
			}

			// Schliesst das Fenster
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
		});
		contentPane.setLayout(null);
		btnSchliessen.setIcon(new ImageIcon(Start.class
				.getResource("/Design/schliessengross.png")));
		contentPane.add(btnSchliessen);

		// Button Menue
		JLabel btnMenue = new JLabel();
		btnMenue.setBounds(50, 150, 66, 75);
		btnMenue.setIcon(new ImageIcon(Start.class
				.getResource("/Design/Men\u00FC.png")));
		contentPane.add(btnMenue);

		// lblMenue
		JLabel Menue = new JLabel("Men\u00FC");
		Menue.setBounds(130, 170, 150, 34);
		Menue.setFont(new Font("Tahoma", Font.BOLD, 34));
		Menue.setForeground(Color.WHITE);
		contentPane.add(Menue);
		
		// btnStart
		JLabel btnStart = new JLabel();
		btnStart.setBounds(60, 255, 50, 50);
		btnStart.setIcon(new ImageIcon(Start.class
				.getResource("/Design/StartBlau.png")));
		contentPane.add(btnStart);

		// lblStart
		JLabel lblStart = new JLabel("Start");
		lblStart.setBounds(120, 267, 80, 25);
		lblStart.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblStart.setForeground(Color.BLUE);
		contentPane.add(lblStart);

		// Button Wiederholung
		JLabel btnWiederholung = new JLabel();
		btnWiederholung.setBounds(60, 315, 50, 50);
		btnWiederholung.addMouseListener(new MouseAdapter() {
			@Override
			// Wiederholung �ffnet sich Bild
			public void mouseClicked(MouseEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Wiederholung frame = new Wiederholung(Start.id);
							frame.setVisible(true);
							dispose();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}

			// Wiederholung-Icon ist blau bei dr�bergehen der Maus
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnWiederholung.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("/Design/WiederholungenBlau.png")));
			}

			// Wiederholung-Icon ist gelb
			@Override
			public void mouseExited(MouseEvent arg0) {
				btnWiederholung.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("/Design/wiederholung.png")));
			}

		});
		btnWiederholung.setIcon(new ImageIcon(Start.class
				.getResource("/Design/wiederholung.png")));
		contentPane.add(btnWiederholung);

		// lblWiederholung f�r fixe Betr�ge
		JLabel lblWiederholung = new JLabel("Wiederholung");
		lblWiederholung.setBounds(120, 327, 174, 25);
		lblWiederholung.setForeground(Color.WHITE);
		lblWiederholung.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblWiederholung);

		// Button Charts
		JLabel btnCharts = new JLabel();
		btnCharts.setBounds(60, 375, 50, 50);
		btnCharts.addMouseListener(new MouseAdapter() {
			@Override
			// Charts �ffnet sich
			public void mouseClicked(MouseEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Charts frame = new Charts(id);
							frame.setVisible(true);
							dispose();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}

			// Charts-Icon wird blau bei dr�bergehen der Maus
			@Override
			public void mouseEntered(MouseEvent e) {
				btnCharts.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("/Design/ChartsBlau.png")));
			}

			// Charts-Icon ist gelb
			@Override
			public void mouseExited(MouseEvent arg0) {
				btnCharts.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("/Design/Charts.png")));
			}
		});
		btnCharts.setIcon(new ImageIcon(Start.class
				.getResource("/Design/Charts.png")));
		contentPane.add(btnCharts);

		// lblCharts
		JLabel lblCharts = new JLabel("Charts");
		lblCharts.setBounds(120, 387, 174, 25);
		lblCharts.setForeground(Color.WHITE);
		lblCharts.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblCharts);

		// Button Sparziele
		JLabel btnSparziele = new JLabel();
		btnSparziele.setBounds(60, 435, 50, 50);
		btnSparziele.addMouseListener(new MouseAdapter() {
			// Sparziele �ffnet sich
			@Override
			public void mouseClicked(MouseEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Sparziele frame = new Sparziele();
							frame.setVisible(true);
							dispose();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}

			// Sparziele-Icon wird blau bei dr�bergehen der Maus
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSparziele.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("/Design/SparzieleBlau.png")));
			}

			// Sparziele-Icon ist gelb
			@Override
			public void mouseExited(MouseEvent arg0) {
				btnSparziele.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("/Design/Sparziele.png")));
			}
		});
		btnSparziele.setIcon(new ImageIcon(Start.class
				.getResource("/Design/Sparziele.png")));
		contentPane.add(btnSparziele);

		// lblSparziele
		JLabel lblSparziele = new JLabel("Sparziele");
		lblSparziele.setBounds(120, 447, 174, 25);
		lblSparziele.setForeground(Color.WHITE);
		lblSparziele.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblSparziele);

		// Button Tools
		JLabel btnTools = new JLabel("New label");
		btnTools.setBounds(60, 495, 50, 50);
		btnTools.addMouseListener(new MouseAdapter() {
			@Override
			// Tools �ffnet sich Bild
			public void mouseClicked(MouseEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Tools frame = new Tools(Tools.id);
							frame.setVisible(true);
							dispose();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}

			// Tools-Icon wird blau bei dr�bergehen der Maus
			@Override
			public void mouseEntered(MouseEvent e) {
				btnTools.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("/Design/ToolsBlau.png")));
			}

			// Tools-Icon ist gelb
			@Override
			public void mouseExited(MouseEvent arg0) {
				btnTools.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("/Design/Tools.png")));
			}
		});
		btnTools.setIcon(new ImageIcon(Start.class
				.getResource("/Design/Tools.png")));
		contentPane.add(btnTools);

		// lblTools
		JLabel lblTools = new JLabel("Tools");
		lblTools.setBounds(120, 507, 174, 25);
		lblTools.setForeground(Color.WHITE);
		lblTools.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblTools);

		// Button Einstellungen
		JLabel btnEinstellungen = new JLabel();
		btnEinstellungen.setBounds(60, 555, 50, 50);
		btnEinstellungen.addMouseListener(new MouseAdapter() {
			@Override
			// Einstellungen �ffnet sich Bild
			public void mouseClicked(MouseEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Einstellungen frame = new Einstellungen(Einstellungen.id);
							frame.setVisible(true);
							dispose();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}

			// Einstellungen-Icon wird blau bei dr�bergehen der Maus
			@Override
			public void mouseEntered(MouseEvent e) {
				btnEinstellungen.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("/Design/EinstellungenBlau.png")));
			}

			// Einstellungen-Icon ist gelb
			@Override
			public void mouseExited(MouseEvent arg0) {
				btnEinstellungen.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("/Design/Einstellungen.png")));
			}
		});
		btnEinstellungen.setIcon(new ImageIcon(Start.class
				.getResource("/Design/Einstellungen.png")));
		contentPane.add(btnEinstellungen);

		// lblEinstellungen
		JLabel lblEinstellungen = new JLabel("Einstellungen");
		lblEinstellungen.setBounds(120, 567, 174, 25);
		lblEinstellungen.setIcon(null);
		lblEinstellungen.setForeground(Color.WHITE);
		lblEinstellungen.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblEinstellungen);

		// Haupt"klasse"-Start
		JLabel lblHauptStart = new JLabel("<html><u>START</u><HTML>");
		lblHauptStart.setBounds(510, 50, 150, 34);
		lblHauptStart.setForeground(Color.WHITE);
		lblHauptStart.setFont(new Font("Tahoma", Font.BOLD, 34));
		contentPane.add(lblHauptStart);

		// Haupt"klasse" Button Start
		JLabel btnHauptStart = new JLabel();
		btnHauptStart.setBounds(430, 30, 66, 75);
		btnHauptStart.setIcon(new ImageIcon(Start.class
				.getResource("/Design/Startgross.png")));
		contentPane.add(btnHauptStart);

		// Neue Kategorie Text
		JLabel txtNeueKategorie = new JLabel("Neue Kategorie");
		txtNeueKategorie.setBounds(490, 130, 117, 34);
		txtNeueKategorie.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(txtNeueKategorie);

		// Button um "Neue Kategorie"-Fenster zu �ffnen
		JLabel btnNeueKategorie = new JLabel();
		btnNeueKategorie.setBounds(460, 135, 25, 25);
		btnNeueKategorie.addMouseListener(new MouseAdapter() {
			@Override
			// Plusbutton wird grau bei dr�bergehen der Maus
			public void mouseEntered(MouseEvent arg0) {
				btnNeueKategorie.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("/Design/Plus2.png")));
			}

			// Plusbutton ist blau
			@Override
			public void mouseExited(MouseEvent arg0) {
				btnNeueKategorie.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("/Design/Plus.png")));
			}

			// �ffnet Fenster Anlegen
			@Override
			public void mouseClicked(MouseEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							KategorieAnlegen frame = new KategorieAnlegen();
							frame.setVisible(true);
							dispose();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnNeueKategorie.setIcon(new ImageIcon(Start.class
				.getResource("/Design/Plus.png")));
		contentPane.add(btnNeueKategorie);

		// Neue Kategorie Label
		JLabel lblNeueKategorie = new JLabel();
		lblNeueKategorie.setBounds(440, 130, 170, 34);
		lblNeueKategorie.setIcon(new ImageIcon(Start.class
				.getResource("/Design/Textfeldgross2.png")));
		contentPane.add(lblNeueKategorie);

		// Transaktionsliste
		JLabel txtKBearbeiten = new JLabel("Kategorie bearbeiten");
		txtKBearbeiten.setBounds(660, 130, 142, 34);
		txtKBearbeiten.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(txtKBearbeiten);

		// btnTransaktionsliste
		JLabel btnKBearbeiten = new JLabel();
		btnKBearbeiten.setBounds(630, 135, 25, 25);
		btnKBearbeiten.addMouseListener(new MouseAdapter() {
			@Override
			// Plusbutton wird grau bei dr�bergehen der Maus
			public void mouseEntered(MouseEvent arg0) {
				btnKBearbeiten.setIcon(new javax.swing.ImageIcon(
						getClass().getResource("/Design/Plus2.png")));
			}

			// Plusbutton ist blau
			@Override
			public void mouseExited(MouseEvent arg0) {
				btnKBearbeiten.setIcon(new javax.swing.ImageIcon(
						getClass().getResource("/Design/Plus.png")));
			}

			// �ffnet Fenster Transaktionsliste
			@Override
			public void mouseClicked(MouseEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							KategorieBearbeiten frame = new KategorieBearbeiten();
							frame.setVisible(true);
							dispose();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnKBearbeiten.setIcon(new ImageIcon(Start.class
				.getResource("/Design/Plus.png")));
		contentPane.add(btnKBearbeiten);

		// lblTransaktionsliste
		JLabel lblKBearbeiten = new JLabel();
		lblKBearbeiten.setBounds(622, 130, 170, 34);
		lblKBearbeiten.setIcon(new ImageIcon(Start.class
				.getResource("/Design/Textfeldgross2.png")));
		contentPane.add(lblKBearbeiten);

		// Gesamtbilanz
		JLabel Gesamtbilanz = new JLabel("Gesamtbilanz:");
		Gesamtbilanz.setBounds(900, 130, 117, 34);
		Gesamtbilanz.setForeground(Color.WHITE);
		Gesamtbilanz.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(Gesamtbilanz);

		txtGesamtbilanz = new JTextField();
		// txtGesamtbilanz.setText("<dynamic>\u20AC");
		txtGesamtbilanz.setHorizontalAlignment(SwingConstants.CENTER);
		txtGesamtbilanz.setForeground(Color.GRAY);
		txtGesamtbilanz.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtGesamtbilanz.setColumns(10);
		txtGesamtbilanz.setBorder(null);
		txtGesamtbilanz.setBackground(SystemColor.menu);
		txtGesamtbilanz.setBounds(997, 130, 264, 34);
		contentPane.add(txtGesamtbilanz);

		// lblGesamtbilanz
		JLabel lblGesamtbilanz = new JLabel();
		lblGesamtbilanz.setBounds(997, 130, 253, 34);
		lblGesamtbilanz.setIcon(new ImageIcon(Start.class
				.getResource("/Design/Textfeldgross3.png")));
		contentPane.add(lblGesamtbilanz);

		// Ausgaben
		JLabel Ausgaben = new JLabel("Ausgaben:");
		Ausgaben.setForeground(Color.WHITE);
		Ausgaben.setFont(new Font("Tahoma", Font.BOLD, 14));
		Ausgaben.setBounds(440, 210, 117, 34);
		contentPane.add(Ausgaben);

		txtAusgabenSumme = new JTextField();
		txtAusgabenSumme.setBorder(null);
		// txtAusgabenSumme.setText("<dynamic>");
		txtAusgabenSumme.setBackground(new Color(240, 240, 240));
		txtAusgabenSumme.setHorizontalAlignment(SwingConstants.CENTER);
		txtAusgabenSumme.setForeground(Color.GRAY);
		txtAusgabenSumme.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtAusgabenSumme.setColumns(10);
		txtAusgabenSumme.setBounds(528, 210, 264, 34);
		contentPane.add(txtAusgabenSumme);

		// lblAusgaben
		JLabel lblAusgaben = new JLabel();
		lblAusgaben.setIcon(new ImageIcon(Start.class
				.getResource("/Design/Textfeldgross3.png")));
		lblAusgaben.setBounds(528, 210, 125, 34);
		contentPane.add(lblAusgaben);

		// Ausgaben hinzuf�gem
		JLabel lblHinzufgen = new JLabel("Hinzuf\u00FCgen");
		lblHinzufgen.setHorizontalAlignment(SwingConstants.CENTER);
		lblHinzufgen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHinzufgen.setBounds(555, 270, 103, 34);
		contentPane.add(lblHinzufgen);

		// Button Ausgaben hinzuf�gen
		JLabel btnHinzuA = new JLabel();
		btnHinzuA.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnHinzuA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Design/Plus2.png")));
			}

			// Plusbutton ist blau
			@Override
			public void mouseExited(MouseEvent arg0) {
				btnHinzuA.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("/Design/Plus.png")));
			}

			// Beim Klicken �ffnet sich HinzufuegenAusgaben-Fenster
			@Override
			public void mouseClicked(MouseEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							HinzufuegenAusgaben frame = new HinzufuegenAusgaben(
									id);
							frame.setVisible(true);
							dispose();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnHinzuA.setIcon(new ImageIcon(Start.class
				.getResource("/Design/Plus.png")));
		btnHinzuA.setBounds(540, 275, 25, 25);
		contentPane.add(btnHinzuA);

		// lblHinzuA
		JLabel lblHinzuA = new JLabel();
		lblHinzuA.setIcon(new ImageIcon(Start.class
				.getResource("/Design/Textfeldgross.png")));
		lblHinzuA.setBounds(528, 270, 125, 34);
		contentPane.add(lblHinzuA);

		JScrollPane scrollPane_TabelleAusgaben = new JScrollPane();
		scrollPane_TabelleAusgaben.setForeground(Color.GRAY);
		scrollPane_TabelleAusgaben.setBorder(null);
		scrollPane_TabelleAusgaben.setBounds(440, 350, 352, 290);
		scrollPane_TabelleAusgaben.getViewport().setBackground(new Color(27, 109, 220));
		
//Bearbeiten		
		JLabel lblBearbeiten = new JLabel("Bearbeiten");
		lblBearbeiten.setHorizontalAlignment(SwingConstants.CENTER);
		lblBearbeiten.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBearbeiten.setBounds(692, 270, 103, 34);
		contentPane.add(lblBearbeiten);	
		
//Button f�r bearbeiten von Ausgaben		
		JLabel btnBearbeitenA = new JLabel();
		btnBearbeitenA.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnBearbeitenA.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("/Design/Plus2.png")));
			}

			// Plusbutton ist blau
			@Override
			public void mouseExited(MouseEvent arg0) {
				btnBearbeitenA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Design/Plus.png")));
			}
			
			// �ffnet BearbeitenAusgaben-Fenster
						@Override
						public void mouseClicked(MouseEvent e) {
							EventQueue.invokeLater(new Runnable() {
								public void run() {
									try {
										BearbeitenAusgaben frame = new BearbeitenAusgaben(id);
										frame.setVisible(true);
										dispose();
									} catch (Exception e) {
										e.printStackTrace();
									}
								}
							});
						}
		});
		btnBearbeitenA.setIcon(new ImageIcon(Start.class.getResource("/Design/Plus.png")));
		btnBearbeitenA.setBounds(678, 275, 25, 25);
		contentPane.add(btnBearbeitenA);
		
//lblBearbeiten
		JLabel lblBearbeitenA = new JLabel();
		lblBearbeitenA.setIcon(new ImageIcon(Start.class.getResource("/Design/Textfeldgross.png")));
		lblBearbeitenA.setBounds(667, 270, 125, 34);
		contentPane.add(lblBearbeitenA);
		contentPane.add(scrollPane_TabelleAusgaben);

// Tabelle Ausgaben �bersicht
		tableAusgaben = new JTable();
		tableAusgaben.setFont(new Font("Tahoma", Font.BOLD, 11));
		tableAusgaben.setForeground(Color.WHITE);
		tableAusgaben.setBackground(new Color(27, 109, 220));
		scrollPane_TabelleAusgaben.setViewportView(tableAusgaben);

// Einnahmen
		JLabel Einnahmen = new JLabel("Einnahmen:");
		Einnahmen.setForeground(Color.WHITE);
		Einnahmen.setFont(new Font("Tahoma", Font.BOLD, 14));
		Einnahmen.setBounds(900, 210, 87, 34);
		contentPane.add(Einnahmen);

		txtEinnahmenSumme = new JTextField();
		txtEinnahmenSumme.setBorder(null);
		txtEinnahmenSumme.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtEinnahmenSumme.setForeground(Color.GRAY);
		txtEinnahmenSumme.setHorizontalAlignment(SwingConstants.CENTER);
		txtEinnahmenSumme.setBackground(new Color(240, 240, 240));
		txtEinnahmenSumme.setBounds(997, 210, 264, 34);
		contentPane.add(txtEinnahmenSumme);
		txtEinnahmenSumme.setColumns(10);
		// txtEinnahmenSumme.setText(sum);

		// lblEinnahmen
		JLabel lblEinnahmen = new JLabel();
		lblEinnahmen.setIcon(new ImageIcon(Start.class
				.getResource("/Design/Textfeldgross3.png")));
		lblEinnahmen.setBounds(997, 210, 125, 34);
		contentPane.add(lblEinnahmen);

		// Einnahmen hinzuf�gen
		JLabel lblHinzufuegen = new JLabel("Hinzuf\u00FCgen");
		lblHinzufuegen.setHorizontalAlignment(SwingConstants.CENTER);
		lblHinzufuegen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHinzufuegen.setBounds(1024, 270, 103, 34);
		contentPane.add(lblHinzufuegen);

		// Button f�r hinzuf�gen der Einnahmen
		JLabel btnHinzuE = new JLabel();
		btnHinzuE.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnHinzuE.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("/Design/Plus2.png")));
			}

			// Plusbutton ist blau
			@Override
			public void mouseExited(MouseEvent arg0) {
				btnHinzuE.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("/Design/Plus.png")));
			}

			// �ffnet HinzufuegenEinnahmen-Fenster
			@Override
			public void mouseClicked(MouseEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							HinzufuegenEinnahmen frame = new HinzufuegenEinnahmen(id);
							frame.setVisible(true);
							dispose();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnHinzuE.setIcon(new ImageIcon(Start.class
				.getResource("/Design/Plus.png")));
		btnHinzuE.setBounds(1010, 275, 25, 25);
		contentPane.add(btnHinzuE);

		// lblHinzuE
		JLabel lblHinzuE = new JLabel();
		lblHinzuE.setIcon(new ImageIcon(Start.class
				.getResource("/Design/Textfeldgross.png")));
		lblHinzuE.setBounds(997, 270, 125, 34);
		contentPane.add(lblHinzuE);

		JScrollPane scrollPane_TabelleEinnahmen = new JScrollPane();
		scrollPane_TabelleEinnahmen.setForeground(Color.GRAY);
		scrollPane_TabelleEinnahmen.setBorder(null);
		scrollPane_TabelleEinnahmen.setBounds(900, 350, 352, 290);
		scrollPane_TabelleEinnahmen.getViewport().setBackground(new Color(27, 109, 220));
		
//Button Bearbeiten f�r Einnahmen		
		JLabel btnBearbeitenE = new JLabel();
		btnBearbeitenE.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBearbeitenE.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("/Design/Plus2.png")));
			}

			// Plusbutton ist blau
			@Override
			public void mouseExited(MouseEvent arg0) {
				btnBearbeitenE.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("/Design/Plus.png")));
			}
			
			// �ffnet BearbeitenEinnahmen-Fenster
						@Override
						public void mouseClicked(MouseEvent e) {
							EventQueue.invokeLater(new Runnable() {
								public void run() {
									try {
										BearbeitenEinnahmen frame = new BearbeitenEinnahmen(id);
										frame.setVisible(true);
										dispose();
									} catch (Exception e) {
										e.printStackTrace();
									}
								}
							});
						}
		});
		btnBearbeitenE.setIcon(new ImageIcon(Start.class.getResource("/Design/Plus.png")));
		btnBearbeitenE.setBounds(1150, 275, 25, 25);
		contentPane.add(btnBearbeitenE);
		
		JLabel BearbeitenE = new JLabel("Bearbeiten");
		BearbeitenE.setHorizontalAlignment(SwingConstants.CENTER);
		BearbeitenE.setFont(new Font("Tahoma", Font.PLAIN, 14));
		BearbeitenE.setBounds(1163, 270, 103, 34);
		contentPane.add(BearbeitenE);
		
		JLabel lblBearbeitenE = new JLabel();
		lblBearbeitenE.setIcon(new ImageIcon(Start.class.getResource("/Design/Textfeldgross.png")));
		lblBearbeitenE.setBounds(1137, 270, 125, 34);
		contentPane.add(lblBearbeitenE);
		contentPane.add(scrollPane_TabelleEinnahmen);

		// Einnahmen Tabellen�bersicht
		tableEinnahmen = new JTable();
		tableEinnahmen.setFont(new Font("Tahoma", Font.BOLD, 11));
		tableEinnahmen.setForeground(Color.WHITE);
		tableEinnahmen.setBackground(new Color(27, 109, 220));
		scrollPane_TabelleEinnahmen.setViewportView(tableEinnahmen);

		// Hintergrund
		JLabel Hintergrund = new JLabel();
		Hintergrund.setBounds(-11, -57, 1378, 820);
		Hintergrund.setIcon(new ImageIcon(Start.class
				.getResource("/Design/GUI7.png")));
		contentPane.add(Hintergrund);

		// Deaktivieren des Standard-JFrame Design und lege die Lage in Mitten
		// des Bildschirms
		setUndecorated(true);
		setLocationRelativeTo(null);
		
		

		// Einnahmen und Ausgaben Tabelle
		try {
			String sqlQuery = "SELECT Datum,Bezeichnung,Kategorie,Art,Betrag FROM BenutzerErtr�ge  WHERE (BenutzerID='"
					+ this.id + "') ";
			String sqlQuery2 = "SELECT Datum,Bezeichnung,Kategorie,Art,Betrag FROM BenutzerAufwendungen WHERE (BenutzerID='"
					+ this.id + "')  ";
			PreparedStatement stm = connection.prepareStatement(sqlQuery);
			PreparedStatement pstmt = connec.prepareStatement(sqlQuery2);
			ResultSet result = stm.executeQuery();
			ResultSet rs = pstmt.executeQuery();
			tableEinnahmen.setModel(DbUtils.resultSetToTableModel(result));
			tableAusgaben.setModel(DbUtils.resultSetToTableModel(rs));
			result.close();
			stm.close();
			rs.close();
			pstmt.close();
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		
		
		// Einnahmen und Ausgaben Summe
		try {
			String sqlQuery3 = "SELECT ROUND(SUM(Betrag), 2)  FROM BenutzerErtr�ge  WHERE (BenutzerID='"
					+ this.id + "') ";
			String sqlQuery4 = "SELECT ROUND(SUM(Betrag), 2)  FROM BenutzerAufwendungen  WHERE (BenutzerID='"
					+ this.id + "') ";
			PreparedStatement pst = conn.prepareStatement(sqlQuery3);
			PreparedStatement pstm = con.prepareStatement(sqlQuery4);
			ResultSet res = pst.executeQuery();
			ResultSet resSet = pstm.executeQuery();
			// Einnahmensumme
			res.next();
			String summe1 = res.getString(1);
			System.out.println(summe1);
			txtEinnahmenSumme.setText(summe1 + "�");
			// Ausgabensumme
			resSet.next();
			String summe2 = resSet.getString(1);
			System.out.println(summe2);
			txtAusgabenSumme.setText(summe2 + "�");
			
			// Gesamtbilanz
			double summe3 = Double.parseDouble(summe1);
			double summe4 = Double.parseDouble(summe2);
			double gesamtbilanz;
			gesamtbilanz = summe3 - summe4;
			txtGesamtbilanz.setText(gesamtbilanz + "�");
			res.close();
			pst.close();
			resSet.close();
			pstm.close();
		} catch (Exception ex) {
			ex.printStackTrace();

		}	
	}
	
}
