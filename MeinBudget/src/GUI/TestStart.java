package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;

import java.awt.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.Box;

//import Anmelden.AnmeldeDatenbank;

import javax.swing.JScrollPane;
import javax.swing.JButton;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TestStart extends JFrame {
	
	Connection connection = null;

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestStart frame = new TestStart();
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
	public TestStart() {
		
		connection = BPDatenbank.dbCon();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1378, 745);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
//Button Schliessen		
				final JLabel btnSchliessen = new JLabel();
				btnSchliessen.addMouseListener(new MouseAdapter() {
					@Override
					//Schliessenbutton in grau
					public void mouseEntered(MouseEvent arg0) {
						btnSchliessen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Design/schliessengross2.png")));
					}
					
					//Schliessenbutton ist blau
					@Override
					public void mouseExited(MouseEvent arg0) {
						btnSchliessen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Design/schliessengross.png")));
					}
					
					//Schliesst das Fenster
					@Override
					public void mouseClicked(MouseEvent arg0) {
						System.exit(0);
					}
				});
				btnSchliessen.setIcon(new ImageIcon(Start.class.getResource("/Design/schliessengross.png")));
				btnSchliessen.setBounds(1305, 21, 40, 40);
				contentPane.add(btnSchliessen);
		
//Button Menue		
				JLabel btnMenue = new JLabel();
				btnMenue.setIcon(new ImageIcon(Start.class.getResource("/Design/Men\u00FC.png")));
				btnMenue.setBounds(50, 30, 66, 75);
				contentPane.add(btnMenue);
				
//lblMenue		
				JLabel txtMenue = new JLabel("Men\u00FC");
				txtMenue.setFont(new Font("Tahoma", Font.BOLD, 34));
				txtMenue.setForeground(Color.WHITE);
				txtMenue.setBounds(130, 50, 150, 34);
				contentPane.add(txtMenue);
				
//Tabelle f�r Gesamt�bersicht		
				JTable tableGesamt = new JTable();			
				tableGesamt.setBounds(50, 116, 200, 200);
				contentPane.add(tableGesamt);
				
//btnStart		
				JLabel btnStart = new JLabel();
				btnStart.setIcon(new ImageIcon(Start.class.getResource("/Design/StartBlau.png")));
				btnStart.setBounds(50, 340, 50, 50);
				contentPane.add(btnStart);
				
//lblStart
				JLabel lblStart = new JLabel("Start");
				lblStart.setFont(new Font("Tahoma", Font.BOLD, 22));
				lblStart.setForeground(Color.BLUE);
				lblStart.setBounds(110, 352, 80, 25);
				contentPane.add(lblStart);
				
//Button Wiederholung		
				JLabel btnWiederholung = new JLabel();
				btnWiederholung.addMouseListener(new MouseAdapter() {
					@Override
					//Wiederholung �ffnet sich	Bild			
					public void mouseClicked(MouseEvent e) {
						EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
									Wiederholung frame = new Wiederholung();
									frame.setVisible(true);
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						});
					}
					//Wiederholung-Icon ist blau bei dr�bergehen der Maus
					@Override
					public void mouseEntered(MouseEvent arg0) {
						btnWiederholung.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Design/WiederholungenBlau.png")));
					}
					
					//Wiederholung-Icon ist gelb
					@Override
					public void mouseExited(MouseEvent arg0) {
						btnWiederholung.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Design/wiederholung.png")));
					}

				});
				btnWiederholung.setIcon(new ImageIcon(Start.class.getResource("/Design/wiederholung.png")));
				btnWiederholung.setBounds(50, 410, 50, 50);
				contentPane.add(btnWiederholung);
				
//lblWiederholung f�r fixe Betr�ge		
				JLabel lblWiederholung = new JLabel("Wiederholung");
				lblWiederholung.setForeground(Color.WHITE);
				lblWiederholung.setFont(new Font("Tahoma", Font.BOLD, 20));
				lblWiederholung.setBounds(110, 422, 174, 25);
				contentPane.add(lblWiederholung);
				
//Button Charts		
				JLabel btnCharts = new JLabel();
				btnCharts.addMouseListener(new MouseAdapter() {
					@Override
					//Charts �ffnet sich
					public void mouseClicked(MouseEvent e) {
						EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
									Charts frame = new Charts();
									frame.setVisible(true);
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						});
					}					
					//Charts-Icon wird blau bei dr�bergehen der Maus
					@Override
					public void mouseEntered(MouseEvent e) {
						btnCharts.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Design/ChartsBlau.png")));
					}
					//Charts-Icon ist gelb
					@Override
					public void mouseExited(MouseEvent arg0) {
						btnCharts.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Design/Charts.png")));
					}
				});
				btnCharts.setIcon(new ImageIcon(Start.class.getResource("/Design/Charts.png")));
				btnCharts.setBounds(50, 480, 50, 50);
				contentPane.add(btnCharts);
				
//lblCharts		
				JLabel lblCharts = new JLabel("Charts");
				lblCharts.setForeground(Color.WHITE);
				lblCharts.setFont(new Font("Tahoma", Font.BOLD, 20));
				lblCharts.setBounds(110, 492, 174, 25);
				contentPane.add(lblCharts);
				
//Button Sparziele		
				JLabel btnSparziele = new JLabel();
				btnSparziele.addMouseListener(new MouseAdapter() {
					//Sparziele �ffnet sich
					@Override
					public void mouseClicked(MouseEvent e) {
						EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
									Sparziele frame = new Sparziele();
									frame.setVisible(true);
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						});
					}
					//Sparziele-Icon wird blau bei dr�bergehen der Maus
					@Override
					public void mouseEntered(MouseEvent e) {
						btnSparziele.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Design/SparzieleBlau.png")));
					}
					//Sparziele-Icon ist gelb
					@Override
					public void mouseExited(MouseEvent arg0) {
						btnSparziele.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Design/Sparziele.png")));
					}
				});
				btnSparziele.setIcon(new ImageIcon(Start.class.getResource("/Design/Sparziele.png")));
				btnSparziele.setBounds(50, 550, 50, 50);
				contentPane.add(btnSparziele);
				
//lblSparziele		
				JLabel lblSparziele = new JLabel("Sparziele");
				lblSparziele.setForeground(Color.WHITE);
				lblSparziele.setFont(new Font("Tahoma", Font.BOLD, 20));
				lblSparziele.setBounds(110, 562, 174, 25);
				contentPane.add(lblSparziele);
				
//Button Tools		
				JLabel btnTools = new JLabel("New label");
				btnTools.addMouseListener(new MouseAdapter() {
					@Override
					//Tools �ffnet sich	Bild			
					public void mouseClicked(MouseEvent e) {
						EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
									Tools frame = new Tools();
									frame.setVisible(true);
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						});
					}
					//Tools-Icon wird blau bei dr�bergehen der Maus
					@Override
					public void mouseEntered(MouseEvent e) {
						btnTools.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Design/ToolsBlau.png")));
					}
					//Tools-Icon ist gelb
					@Override
					public void mouseExited(MouseEvent arg0) {
						btnTools.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Design/Tools.png")));
					}
				});
				btnTools.setIcon(new ImageIcon(Start.class.getResource("/Design/Tools.png")));
				btnTools.setBounds(50, 620, 50, 50);
				contentPane.add(btnTools);
				
//lblTools		
				JLabel lblTools = new JLabel("Tools");
				lblTools.setForeground(Color.WHITE);
				lblTools.setFont(new Font("Tahoma", Font.BOLD, 20));
				lblTools.setBounds(110, 631, 174, 25);
				contentPane.add(lblTools);
				
//Button Einstellungen		
				JLabel btnEinstellungen = new JLabel();
				btnEinstellungen.addMouseListener(new MouseAdapter() {
					@Override
					//Einstellungen �ffnet sich	Bild			
					public void mouseClicked(MouseEvent e) {
						EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
									Einstellungen frame = new Einstellungen();
									frame.setVisible(true);
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						});
					}
					//Einstellungen-Icon wird blau bei dr�bergehen der Maus			
					@Override
					public void mouseEntered(MouseEvent e) {
						btnEinstellungen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Design/EinstellungenBlau.png")));
					}
					//Einstellungen-Icon ist gelb
					@Override
					public void mouseExited(MouseEvent arg0) {
						btnEinstellungen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Design/Einstellungen.png")));
					}
				});
				btnEinstellungen.setIcon(new ImageIcon(Start.class.getResource("/Design/Einstellungen.png")));
				btnEinstellungen.setBounds(50, 690, 50, 50);
				contentPane.add(btnEinstellungen);
				
//lblEinstellungen		
				JLabel lblEinstellungen = new JLabel("Einstellungen");
				lblEinstellungen.addMouseListener(new MouseAdapter() {
					@Override
					//Einstellungen �ffnen					
					public void mouseClicked(MouseEvent e) {
						EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
									Einstellungen frame = new Einstellungen();
									frame.setVisible(true);
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						});
					}
				});
				lblEinstellungen.setIcon(null);
				lblEinstellungen.setForeground(Color.WHITE);
				lblEinstellungen.setFont(new Font("Tahoma", Font.BOLD, 20));
				lblEinstellungen.setBounds(110, 700, 174, 25);
				contentPane.add(lblEinstellungen);
				
//Haupt"klasse"-Start		
				JLabel lblHauptStart = new JLabel("<html><u>START</u><HTML>");
				lblHauptStart.setForeground(Color.WHITE);
				lblHauptStart.setFont(new Font("Tahoma", Font.BOLD, 34));
				lblHauptStart.setBounds(510, 50, 150, 34);
				contentPane.add(lblHauptStart);
				
//Haupt"klasse" Button Start		
				JLabel btnHauptStart = new JLabel();
				btnHauptStart.setIcon(new ImageIcon(Start.class.getResource("/Design/Startgross.png")));
				btnHauptStart.setBounds(430, 30, 66, 75);
				contentPane.add(btnHauptStart);
				
				JButton btnLadeEinnahmen = new JButton("Lade Einnahmen");
				btnLadeEinnahmen.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						Budgedtabelle();
					}
				});
				btnLadeEinnahmen.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						Budgedtabelle();
					}
				});
				btnLadeEinnahmen.setBounds(499, 224, 134, 23);
				contentPane.add(btnLadeEinnahmen);
				
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(400, 305, 968, 459);
				contentPane.add(scrollPane);
				
				table = new JTable();
				scrollPane.setViewportView(table);

				
				
//Fullscreen Bildschirm
				setExtendedState(Frame.MAXIMIZED_BOTH);
//Deaktivieren des Standard-JFrame Design und lege die Lage in Mitten des Bildschirms
				setUndecorated(true);
				setLocationRelativeTo(null);		

	}
	
	
//Verbindung zur BPDatenbank
	private void Budgedtabelle(){
		try{
			String sqlQuery = "SELECT Datum,Bezeichnung,Kategorie,Art,Betrag FROM BenutzerErtr�ge WHERE (BenutzerID='2')  ";
			PreparedStatement stm = connection.prepareStatement(sqlQuery);
			ResultSet result = stm.executeQuery();
			
			table.setModel(DbUtils.resultSetToTableModel(result));
	
	
	}catch(Exception exc){
		exc.printStackTrace();
}	
}
}