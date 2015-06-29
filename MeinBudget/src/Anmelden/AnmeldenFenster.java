package Anmelden;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AnmeldenFenster extends JFrame {
	
	Connection connect = null;
	
	private JPanel contentPane;
	private JTextField txtBenutzer;
	private JPasswordField txtPasswort;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnmeldenFenster frame = new AnmeldenFenster();
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
	public AnmeldenFenster() {
		
		connect = AnmeldeDatenbank.dbCon();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
//Button Schliessen		
		final JLabel btnSchliessen = new JLabel();
		btnSchliessen.addMouseListener(new MouseAdapter() {
			//Schliessenbutton ist grau
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnSchliessen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Design/schliessen_button2.png")));
			}
			
			//Schliessenbutton ist blau
			@Override
			public void mouseExited(MouseEvent arg0) {
				btnSchliessen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Design/Schliessen_Button.png")));
			}
			
			//Schlie�t das Fenster
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
			
		});
		
//Textfeld f�r Benutzereingabe		
		txtBenutzer = new JTextField();
		txtBenutzer.setBorder(null);
		txtBenutzer.setHorizontalAlignment(SwingConstants.CENTER);
		txtBenutzer.setForeground(Color.GRAY);
		txtBenutzer.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtBenutzer.setBounds(82, 125, 136, 20);
		contentPane.add(txtBenutzer);
		txtBenutzer.setColumns(10);
		
		txtPasswort = new JPasswordField();
		txtPasswort.setBorder(null);
		txtPasswort.setHorizontalAlignment(SwingConstants.CENTER);
		txtPasswort.setForeground(Color.GRAY);
		txtPasswort.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtPasswort.setBounds(82, 165, 136, 20);
		contentPane.add(txtPasswort);
		
		btnSchliessen.setIcon(new ImageIcon(AnmeldenFenster.class.getResource("/Design/Schliessen_Button.png")));
		btnSchliessen.setBounds(265, 10, 25, 25);
		contentPane.add(btnSchliessen);
		
//Textfeld Benutzername		
		JLabel lblBenutzer = new JLabel();
		lblBenutzer.setIcon(new ImageIcon(AnmeldenFenster.class.getResource("/Design/txtfeld.png")));
		lblBenutzer.setBounds(78, 120, 145, 30);
		contentPane.add(lblBenutzer);
		
//Textfeld Passwort		
		JLabel lblPasswort = new JLabel();
		lblPasswort.setIcon(new ImageIcon(AnmeldenFenster.class.getResource("/Design/txtfeld.png")));
		lblPasswort.setBounds(78, 160, 145, 30);
		contentPane.add(lblPasswort);
		
//Button Anmelden		
		JLabel btnAnmelden = new JLabel();
		btnAnmelden.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			
//SQL Abfrage	
				try{
				String sqlQuery = "SELECT * FROM Benutzer WHERE Benutzername=? and Passwortkombination=?";

//Passwort Char in String konvertieren					
				char[] passInput = txtPasswort.getPassword();
				String passString = new String(passInput);
				
//Benutzer Eingabe in der Console anzeigen
				System.out.println("USER INPUT - Benutzername " + txtBenutzer.getText().toLowerCase());
				System.out.println("USER INPUT - Passwort " + passString);
				
//Abfrage unterbrechen
				PreparedStatement stm = connect.prepareStatement(sqlQuery);
				stm.setString(1, txtBenutzer.getText().toLowerCase());
				stm.setString(2, passString);
				
				ResultSet result = stm.executeQuery();
				
//wenn das Resultat = null tu etwas sonst starte den Login
				
					if(!result.next()){
						System.out.println("�berpr�fe deinen Benutzernamen und dein Passwort!");
						JOptionPane.showMessageDialog(null, "�berpr�fe deinen Benutzernamen und dein Passwort!");
					}
					else{
						
						do{
							String Benutzer = result.getString("Benutzername");
							String Passwort = result.getString("Passwortkombination");
							System.out.println("Datebase data Benutzer: " + Benutzer);
							System.out.println("Datebase data Benutzer: " + Passwort);
							
							if (txtBenutzer.equals(Benutzer) || passString.equals(Passwort)){
								System.out.println("Anmeldung erfolgreich");
//Fenster verschwindet 									
								dispose();
								
								/*BudgetPlanModel budget = new BudgetPlanModel(); // Modell
								new BudgetPlanGUI(budget); // View und Controller*/
								
							}
							
						}while(result.next());
					}
				
				stm.close();
				result.close();
				
				
				
				
			}catch(Exception e){
				e.printStackTrace();
			}				
				
//Benutzer hat sich erfolgreich angemeldet und BudgetFix-Fenster �ffnet sich
			}
		});
		btnAnmelden.setIcon(new ImageIcon(AnmeldenFenster.class.getResource("/Design/Anmelden_Knopf.png")));
		btnAnmelden.setBounds(78, 200, 146, 38);
		contentPane.add(btnAnmelden);
		
//Button Registrieren		
		JLabel btnRegistrieren = new JLabel();
		btnRegistrieren.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Bei Mausklick RegisterFenster zum Registrieren anmelden
			}
		});
		btnRegistrieren.setIcon(new ImageIcon(AnmeldenFenster.class.getResource("/Design/Registrieren_Login.png")));
		btnRegistrieren.setBounds(78, 249, 145, 30);
		contentPane.add(btnRegistrieren);
		
//Hintergrund		
		JLabel Hintergrund = new JLabel();
		Hintergrund.setIcon(new ImageIcon(AnmeldenFenster.class.getResource("/Design/login.png")));
		Hintergrund.setBounds(0, 0, 300, 300);
		contentPane.add(Hintergrund);
		
//Deaktivieren des Standard-JFrame Design und lege die Lage in Mitten des Bildschirms
				setUndecorated(true);
				setLocationRelativeTo(null);
	}
}

