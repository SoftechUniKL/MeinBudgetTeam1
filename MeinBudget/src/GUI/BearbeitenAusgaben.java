package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

import com.toedter.calendar.JDateChooser;

public class BearbeitenAusgaben extends JFrame {

	Connection connection = null;
	Connection conn = null;
	static int id;
	
	private JPanel contentPane;
	private JTextField txtBetrag;
	private JTextField txtBemerkung;
	private JTextField txtBezeichnung;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BearbeitenAusgaben frame = new BearbeitenAusgaben(id);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BearbeitenAusgaben(int id) {
		
		this.id = id;

		// Verbindung zur BPDatenbank - Ertr�ge und Aufwendungen
		connection = BPDatenbank.dbCon();
		// Verbindung zur BPDB - Kategorien
		conn = BPDatenbank.dbCon();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// btnSchliessen
				JLabel btnSchliessen = new JLabel();
				btnSchliessen.setIcon(new ImageIcon(BearbeitenAusgaben.class
						.getResource("/Design/Schliessen_Button.png")));
				btnSchliessen.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						btnSchliessen.setIcon(new javax.swing.ImageIcon(getClass()
								.getResource("/Design/schliessen_button2.png")));
					}

					// Schliessenbutton ist blau
					@Override
					public void mouseExited(MouseEvent arg0) {
						btnSchliessen.setIcon(new javax.swing.ImageIcon(getClass()
								.getResource("/Design/Schliessen_Button.png")));
					}

					// Schliesst das Fenster
					@Override
					public void mouseClicked(MouseEvent arg0) {
						System.exit(0);
					}
				});
				btnSchliessen.setIcon(new ImageIcon(BearbeitenAusgaben.class
						.getResource("/Design/Schliessen_Button.png")));
				btnSchliessen.setBounds(440, 15, 25, 25);
				contentPane.add(btnSchliessen);

		// �berschrift "Bearbeiten der Einnahmen"
				JLabel lblHinzuE = new JLabel(
						"<html><u>Ausgaben bearbeiten</u></html>");
				lblHinzuE.setForeground(Color.WHITE);
				lblHinzuE.setFont(new Font("Tahoma", Font.BOLD, 18));
				lblHinzuE.setHorizontalAlignment(SwingConstants.CENTER);
				lblHinzuE.setBounds(10, 11, 460, 38);
				contentPane.add(lblHinzuE);
				
				
				
				JLabel lblBezeichnung = new JLabel("Bezeichnung:");
				lblBezeichnung.setForeground(Color.WHITE);
				lblBezeichnung.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblBezeichnung.setBounds(100, 112, 118, 27);
				contentPane.add(lblBezeichnung);
				
				txtBezeichnung = new JTextField();
				txtBezeichnung.setHorizontalAlignment(SwingConstants.CENTER);
				txtBezeichnung.setForeground(Color.GRAY);
				txtBezeichnung.setFont(new Font("Tahoma", Font.BOLD, 11));
				txtBezeichnung.setColumns(10);
				txtBezeichnung.setBorder(null);
				txtBezeichnung.setBackground(Color.WHITE);
				txtBezeichnung.setBounds(222, 110, 144, 30);
				contentPane.add(txtBezeichnung);

		// Betrag
				JLabel lblBetrag = new JLabel("Betrag:");
				lblBetrag.setForeground(Color.WHITE);
				lblBetrag.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblBetrag.setBounds(100, 152, 86, 27);
				contentPane.add(lblBetrag);


		// txtBetrag		
				txtBetrag = new JTextField();
				txtBetrag.setHorizontalAlignment(SwingConstants.CENTER);
				txtBetrag.setBackground(Color.WHITE);
				txtBetrag.setFont(new Font("Tahoma", Font.BOLD, 11));
				txtBetrag.setForeground(Color.GRAY);
				txtBetrag.setBorder(null);
				txtBetrag.setBounds(222, 150, 144, 30);
				txtBetrag.setColumns(10);
				contentPane.add(txtBetrag);

				
		// Datum
				JLabel lblDatum = new JLabel("Datum:");
				lblDatum.setForeground(Color.WHITE);
				lblDatum.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblDatum.setBounds(100, 192, 81, 27);
				contentPane.add(lblDatum);

		// Datum ausw�hlen
				JDateChooser txt_Datum = new JDateChooser();
				txt_Datum.setDateFormatString("yyyy-MM-dd");
				txt_Datum.setForeground(Color.GRAY);
				txt_Datum.getCalendarButton().setForeground(Color.GRAY);
				txt_Datum.setBounds(222, 190, 145, 30);
				contentPane.add(txt_Datum);

		// Kategorie
				JLabel Kategorie = new JLabel("Kategorie:");
				Kategorie.setForeground(Color.WHITE);
				Kategorie.setFont(new Font("Tahoma", Font.BOLD, 14));
				Kategorie.setBounds(100, 232, 118, 27);
				contentPane.add(Kategorie);

		// Kategorie Combobox, die bereits angelegten Kategorien hier als
		// Auswahl w�hlen
		JComboBox cboKategorie = new JComboBox();
		cboKategorie.addPopupMenuListener(new PopupMenuListener() {
			public void popupMenuCanceled(PopupMenuEvent e) {
			}

			public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
				String selectedItem = (String) cboKategorie.getSelectedItem();
				System.out.println(selectedItem);
			}

			public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
			}
		});
		cboKategorie.setBounds(222, 250, 145, 30);
		contentPane.add(cboKategorie);

		try {
			String sql = "SELECT * FROM BenutzerKategorien WHERE Typ='Ausgaben' ";
			PreparedStatement stm = conn.prepareStatement(sql);
			ResultSet result = stm.executeQuery();

			while (result.next()) {
				String kategorie = result.getString("Kategorie");
				cboKategorie.addItem(kategorie);
			}
			result.close();
			stm.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
				cboKategorie.setBounds(222, 230, 145, 30);
				contentPane.add(cboKategorie);

		// Bemerkung
				JLabel lblBemerkung = new JLabel("Bemerkung:");
				lblBemerkung.setForeground(Color.WHITE);
				lblBemerkung.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblBemerkung.setBounds(100, 272, 118, 27);
				contentPane.add(lblBemerkung);

		// txtBemerkung
				txtBemerkung = new JTextField();
				txtBemerkung.setHorizontalAlignment(SwingConstants.CENTER);
				txtBemerkung.setForeground(Color.GRAY);
				txtBemerkung.setColumns(10);
				txtBemerkung.setBorder(null);
				txtBemerkung.setBackground(Color.WHITE);
				txtBemerkung.setBounds(222, 270, 144, 30);
				contentPane.add(txtBemerkung);
				
				// lblBezeichnung
				JLabel lblBearbeiten = new JLabel("Bearbeiten:");
				lblBearbeiten.setForeground(Color.WHITE);
				lblBearbeiten.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblBearbeiten.setBounds(100, 70, 118, 27);
				contentPane.add(lblBearbeiten);
		
		JComboBox cboBearbeiten = new JComboBox();
		try {
			String sql = "SELECT Datum,Bezeichnung,Betrag,Bemerkung FROM BenutzerAufwendungen WHERE (BenutzerID='"+ this.id + "') ";
			PreparedStatement stm = conn.prepareStatement(sql);
			ResultSet result = stm.executeQuery();

			while (result.next()) {
				Date add1 = result.getDate("Datum");
				txt_Datum.setDate(add1);
				String add2 = result.getString("Bezeichnung");
				txtBezeichnung.setText(add2);
				String add3 = result.getString("Betrag");
				txtBetrag.setText(add3);
				String add4 = result.getString("Bemerkung");
				txtBemerkung.setText(add4);
				
				String ausgaben = result.getString("Bezeichnung");
				cboBearbeiten.addItem(ausgaben);
			}
			result.close();
			stm.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		cboBearbeiten.addPopupMenuListener(new PopupMenuListener() {
			public void popupMenuCanceled(PopupMenuEvent e) {
			}
			public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
			}
			public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
			}
		});
		cboBearbeiten.setForeground(Color.GRAY);
		cboBearbeiten.setBounds(222, 70, 145, 30);
		contentPane.add(cboBearbeiten);

				// btnSpeichern
				JLabel btnSpeichern = new JLabel();
				btnSpeichern.addMouseListener(new MouseAdapter() {
					@Override
//speichern �ber click					
					public void mouseClicked(MouseEvent e) {
						try {

							String sqlQuery = "INSERT INTO BenutzerAufwendungen (Datum,Bezeichnung,Kategorie,Art,Betrag,BenutzerID,Bemerkung) VALUES(?,?,?,?,?,?,?) ";
							PreparedStatement pst = connection
									.prepareStatement(sqlQuery);

							// Datum
							pst.setString(1, ((JTextField) txt_Datum.getDateEditor()
									.getUiComponent()).getText());

							// Bezeichnung
							pst.setString(2, txtBezeichnung.getText());

							// Kategorie
							String ausgewaelteKategorie = cboKategorie
									.getSelectedItem().toString();										///hieeeer
							pst.setString(3, ausgewaelteKategorie);

							// Art
							pst.setString(4, "variabel");

							// Betrag
							pst.setString(5, txtBetrag.getText());

							// BenutzerID
							pst.setLong(6, id);

							// Bemerkung
							pst.setString(7, txtBemerkung.getText());

							pst.execute();

							JOptionPane.showMessageDialog(null,
									"Erfolgreich gespeichert!");

						} catch (Exception ex) {
							ex.printStackTrace();
						}

						
					}
				});
				btnSpeichern.setIcon(new ImageIcon(HinzufuegenEinnahmen.class
						.getResource("/Design/Speichern.png")));
				btnSpeichern.setBounds(175, 330, 144, 38);
				contentPane.add(btnSpeichern);

		// btnZurueck
				JLabel btnZurueck = new JLabel("<html><u>Zur\u00FCck</u></html>");
				btnZurueck.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
									Start frame = new Start(Start.id);
									frame.setVisible(true);
									dispose();
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						});
					}
				});
				
				JLabel btnLoeschen = new JLabel();
				btnLoeschen.addMouseListener(new MouseAdapter() {
//L�schen �ber click				
					@Override
					public void mouseClicked(MouseEvent e) {
						
					}
				});
				btnLoeschen.setIcon(new ImageIcon(BearbeitenEinnahmen.class.getResource("/Design/Loeschen.png")));
				btnLoeschen.setBounds(175, 379, 144, 38);
				contentPane.add(btnLoeschen);
				btnZurueck.setHorizontalAlignment(SwingConstants.CENTER);
				btnZurueck.setForeground(Color.WHITE);
				btnZurueck.setFont(new Font("Tahoma", Font.PLAIN, 12));
				btnZurueck.setBounds(170, 420, 144, 14);
				contentPane.add(btnZurueck);
				

		
// Hintergrund
		JLabel Hintergrund = new JLabel();
		Hintergrund.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Hintergrund.setHorizontalAlignment(SwingConstants.CENTER);
		Hintergrund.setForeground(Color.BLACK);
		Hintergrund.setIcon(new ImageIcon(HinzufuegenEinnahmen.class
				.getResource("/Design/GUI3.png")));
		Hintergrund.setBounds(0, 0, 480, 480);
		contentPane.add(Hintergrund);		
				
// Deaktivieren des Standard-JFrame Design und lege die Lage in Mitten
// des Bildschirms
		setUndecorated(true);
		setLocationRelativeTo(null);
	}

}
