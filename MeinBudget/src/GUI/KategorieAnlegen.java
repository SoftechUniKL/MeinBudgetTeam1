package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import java.awt.List;

public class KategorieAnlegen extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KategorieAnlegen frame = new KategorieAnlegen();
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
	public KategorieAnlegen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

//Schliessenbutton		
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
					
			//Schliesst das Fenster
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
					
			});
			
//�berschrift "Kategorie Anlegen"			
			JLabel lblKategorienAnlegen = new JLabel("Kategorien Anlegen");
			lblKategorienAnlegen.setForeground(Color.WHITE);
			lblKategorienAnlegen.setFont(new Font("Tahoma", Font.BOLD, 18));
			lblKategorienAnlegen.setHorizontalAlignment(SwingConstants.CENTER);
			lblKategorienAnlegen.setBounds(10, 15, 460, 38);
			contentPane.add(lblKategorienAnlegen);
			btnSchliessen.setIcon(new ImageIcon(KategorieAnlegen.class.getResource("/Design/Schliessen_Button.png")));
			btnSchliessen.setBounds(440, 15, 25, 25);
			contentPane.add(btnSchliessen);
		
//Kategorie		
		JLabel lblKategorie = new JLabel();
		lblKategorie.setIcon(new ImageIcon(KategorieAnlegen.class.getResource("/Design/Textfeldgross.png")));
		lblKategorie.setBounds(222, 105, 145, 30);
		contentPane.add(lblKategorie);
		
//Typ f�r Kategorie		
		JLabel Kategorie = new JLabel("Kategorie:");
		Kategorie.setForeground(Color.WHITE);
		Kategorie.setFont(new Font("Tahoma", Font.BOLD, 14));
		Kategorie.setBounds(100, 105, 91, 27);
		contentPane.add(Kategorie);
		
//Typ f�r Ausgaben oder Einnahmen		
		JLabel Typ = new JLabel("Typ:");
		Typ.setForeground(Color.WHITE);
		Typ.setFont(new Font("Tahoma", Font.BOLD, 14));
		Typ.setBounds(100, 170, 91, 27);
		contentPane.add(Typ);
		
//Auswahl Ausgaben		
		JRadioButton rdbtnAusgaben = new JRadioButton("Ausgaben");
		rdbtnAusgaben.setBounds(222, 174, 145, 30);
		contentPane.add(rdbtnAusgaben);
		
//Auswahl Einnahmen		
		JRadioButton rdbtnEinnahmen = new JRadioButton("Einnahmen");
		rdbtnEinnahmen.setBounds(222, 207, 145, 30);
		contentPane.add(rdbtnEinnahmen);
		
//Button Auswahl f�r Icons		
		JLabel lblIcon = new JLabel("Icon:");
		lblIcon.setForeground(Color.WHITE);
		lblIcon.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblIcon.setBounds(100, 274, 91, 27);
		contentPane.add(lblIcon);
		
		JLabel lblAuswahl = new JLabel("Auswahl");
		lblAuswahl.setIcon(new ImageIcon(KategorieAnlegen.class.getResource("/Design/txtfeld.png")));
		lblAuswahl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		
		JLabel Auswahl = new JLabel("Auswahl");
		Auswahl.setHorizontalAlignment(SwingConstants.CENTER);
		Auswahl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Auswahl.setBounds(222, 272, 124, 30);
		contentPane.add(Auswahl);
		lblAuswahl.setHorizontalAlignment(SwingConstants.CENTER);
		lblAuswahl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAuswahl.setBounds(222, 272, 124, 30);
		contentPane.add(lblAuswahl);


		
//Button Speichern		
		JLabel btnSpeichern = new JLabel();
		btnSpeichern.setIcon(new ImageIcon(KategorieAnlegen.class.getResource("/Design/Speichern.png")));
		btnSpeichern.setBounds(148, 372, 188, 38);
		contentPane.add(btnSpeichern);
		
//Combobox Auswahl der Icons		
			JComboBox<Object> cboAuswahl = new JComboBox<Object>();
			cboAuswahl.addItem(new ImageIcon(KategorieAnlegen.class.getResource("/Icons/backpack.png")));
			cboAuswahl.addItem(new ImageIcon(KategorieAnlegen.class.getResource("/Icons/bomb.png")));
			cboAuswahl.addItem(new ImageIcon(KategorieAnlegen.class.getResource("/Icons/book.png")));
			cboAuswahl.addItem(new ImageIcon(KategorieAnlegen.class.getResource("/Icons/briefcase.png")));
			cboAuswahl.addItem(new ImageIcon(KategorieAnlegen.class.getResource("/Icons/bubble-chat.png")));
			cboAuswahl.addItem(new ImageIcon(KategorieAnlegen.class.getResource("/Icons/bubble-heart.png")));
			cboAuswahl.addItem(new ImageIcon(KategorieAnlegen.class.getResource("/Icons/camera-photo.png")));
			cboAuswahl.addItem(new ImageIcon(KategorieAnlegen.class.getResource("/Icons/camera-polaroid.png")));
			cboAuswahl.addItem(new ImageIcon(KategorieAnlegen.class.getResource("/Icons/camera-video.png")));
			cboAuswahl.addItem(new ImageIcon(KategorieAnlegen.class.getResource("/Icons/cassette-player.png")));
			cboAuswahl.addItem(new ImageIcon(KategorieAnlegen.class.getResource("/Icons/charlie-chaplin.png")));
			cboAuswahl.addItem(new ImageIcon(KategorieAnlegen.class.getResource("/Icons/chef-hat.png")));
			cboAuswahl.addItem(new ImageIcon(KategorieAnlegen.class.getResource("/Icons/clock.png")));
			cboAuswahl.addItem(new ImageIcon(KategorieAnlegen.class.getResource("/Icons/coffee-machine.png")));
			cboAuswahl.addItem(new ImageIcon(KategorieAnlegen.class.getResource("/Icons/cog.png")));
			cboAuswahl.addItem(new ImageIcon(KategorieAnlegen.class.getResource("/Icons/computer-imac.png")));
			cboAuswahl.addItem(new ImageIcon(KategorieAnlegen.class.getResource("/Icons/computer-network.png")));
			cboAuswahl.addItem(new ImageIcon(KategorieAnlegen.class.getResource("/Icons/computer-pc.png")));
			cboAuswahl.addItem(new ImageIcon(KategorieAnlegen.class.getResource("/Icons/computer-screen-1.png")));
			cboAuswahl.addItem(new ImageIcon(KategorieAnlegen.class.getResource("/Icons/contact-book.png")));
			cboAuswahl.addItem(new ImageIcon(KategorieAnlegen.class.getResource("/Icons/content-download.png")));
			cboAuswahl.addItem(new ImageIcon(KategorieAnlegen.class.getResource("/Icons/cooking-pot.png")));
			cboAuswahl.addItem(new ImageIcon(KategorieAnlegen.class.getResource("/Icons/crop.png")));
			cboAuswahl.addItem(new ImageIcon(KategorieAnlegen.class.getResource("/Icons/crown.png")));
			cboAuswahl.addItem(new ImageIcon(KategorieAnlegen.class.getResource("/Icons/designer-cup.png")));
			cboAuswahl.addItem(new ImageIcon(KategorieAnlegen.class.getResource("/Icons/diving-gear.png")));
			cboAuswahl.addItem(new ImageIcon(KategorieAnlegen.class.getResource("/Icons/drink-cocktail.png")));
			cboAuswahl.addItem(new ImageIcon(KategorieAnlegen.class.getResource("/Icons/drink-coffee.png")));
			cboAuswahl.addItem(new ImageIcon(KategorieAnlegen.class.getResource("/Icons/e-mail.png")));
			cboAuswahl.addItem(new ImageIcon(KategorieAnlegen.class.getResource("/Icons/envelope.png")));
			cboAuswahl.addItem(new ImageIcon(KategorieAnlegen.class.getResource("/Icons/eyedropper.png")));
			cboAuswahl.addItem(new ImageIcon(KategorieAnlegen.class.getResource("/Icons/fork-knife.png")));
			cboAuswahl.addItem(new ImageIcon(KategorieAnlegen.class.getResource("/Icons/forklift.png")));
			cboAuswahl.addItem(new ImageIcon(KategorieAnlegen.class.getResource("/Icons/fountain-pen-head-1.png")));
			cboAuswahl.addItem(new ImageIcon(KategorieAnlegen.class.getResource("/Icons/gauge.png")));
			cboAuswahl.addItem(new ImageIcon(KategorieAnlegen.class.getResource("/Icons/globe.png")));
			cboAuswahl.addItem(new ImageIcon(KategorieAnlegen.class.getResource("/Icons/grid.png")));
			cboAuswahl.addItem(new ImageIcon(KategorieAnlegen.class.getResource("/Icons/griller.png")));
			cboAuswahl.addItem(new ImageIcon(KategorieAnlegen.class.getResource("/Icons/handbag.png")));
			cboAuswahl.addItem(new ImageIcon(KategorieAnlegen.class.getResource("/Icons/headphone.png")));
			cboAuswahl.addItem(new ImageIcon(KategorieAnlegen.class.getResource("/Icons/heart.png")));
			cboAuswahl.addItem(new ImageIcon(KategorieAnlegen.class.getResource("/Icons/home.png")));
			cboAuswahl.addItem(new ImageIcon(KategorieAnlegen.class.getResource("/Icons/hotdog.png")));
			cboAuswahl.addItem(new ImageIcon(KategorieAnlegen.class.getResource("/Icons/icecream.png")));
			cboAuswahl.addItem(new ImageIcon(KategorieAnlegen.class.getResource("/Icons/image.png")));
			cboAuswahl.addItem(new ImageIcon(KategorieAnlegen.class.getResource("/Icons/iphone.png")));
			cboAuswahl.addItem(new ImageIcon(KategorieAnlegen.class.getResource("/Icons/ipod.png")));
			cboAuswahl.addItem(new ImageIcon(KategorieAnlegen.class.getResource("/Icons/layers-image.png")));
			cboAuswahl.addItem(new ImageIcon(KategorieAnlegen.class.getResource("/Icons/layers.png")));
			cboAuswahl.addItem(new ImageIcon(KategorieAnlegen.class.getResource("/Icons/link.png")));
			cboAuswahl.addItem(new ImageIcon(KategorieAnlegen.class.getResource("/Icons/location-pin.png")));
			cboAuswahl.addItem(new ImageIcon(KategorieAnlegen.class.getResource("/Icons/location-user.png")));
			cboAuswahl.addItem(new ImageIcon(KategorieAnlegen.class.getResource("/Icons/lock-locked.png")));
			cboAuswahl.addItem(new ImageIcon(KategorieAnlegen.class.getResource("/Icons/lock-unlocked.png")));
			cboAuswahl.addItem(new ImageIcon(KategorieAnlegen.class.getResource("/Icons/magic-wand.png")));
			cboAuswahl.addItem(new ImageIcon(KategorieAnlegen.class.getResource("/Icons/magnet.png")));
			cboAuswahl.addItem(new ImageIcon(KategorieAnlegen.class.getResource("/Icons/microphone.png")));
			cboAuswahl.addItem(new ImageIcon(KategorieAnlegen.class.getResource("/Icons/monocle.png")));
			cboAuswahl.addItem(new ImageIcon(KategorieAnlegen.class.getResource("/Icons/mp3-player.png")));
			cboAuswahl.addItem(new ImageIcon(KategorieAnlegen.class.getResource("/Icons/music-note.png")));
			cboAuswahl.addItem(new ImageIcon(KategorieAnlegen.class.getResource("/Icons/notebook-2.png")));
			cboAuswahl.addItem(new ImageIcon(KategorieAnlegen.class.getResource("/Icons/paint-brush.png")));
			cboAuswahl.addItem(new ImageIcon(KategorieAnlegen.class.getResource("/Icons/paint-bucket.png")));
			cboAuswahl.addItem(new ImageIcon(KategorieAnlegen.class.getResource("/Icons/paint-roller.png")));
			cboAuswahl.addItem(new ImageIcon(KategorieAnlegen.class.getResource("/Icons/pen-fountain.png")));
			cboAuswahl.addItem(new ImageIcon(KategorieAnlegen.class.getResource("/Icons/pen-point-tip.png")));
			cboAuswahl.addItem(new ImageIcon(KategorieAnlegen.class.getResource("/Icons/pencil-ruler.png")));
			cboAuswahl.addItem(new ImageIcon(KategorieAnlegen.class.getResource("/Icons/picture-frame.png")));
			cboAuswahl.addItem(new ImageIcon(KategorieAnlegen.class.getResource("/Icons/quill-ink.png")));
			cboAuswahl.addItem(new ImageIcon(KategorieAnlegen.class.getResource("/Icons/refresh.png")));
			cboAuswahl.addItem(new ImageIcon(KategorieAnlegen.class.getResource("/Icons/remote-control-hand.png")));
			cboAuswahl.addItem(new ImageIcon(KategorieAnlegen.class.getResource("/Icons/remote-control-screen.png")));
			cboAuswahl.addItem(new ImageIcon(KategorieAnlegen.class.getResource("/Icons/script.png")));
			cboAuswahl.addItem(new ImageIcon(KategorieAnlegen.class.getResource("/Icons/server.png")));
			cboAuswahl.addItem(new ImageIcon(KategorieAnlegen.class.getResource("/Icons/settings.png")));
			cboAuswahl.addItem(new ImageIcon(KategorieAnlegen.class.getResource("/Icons/shield-cross.png")));
			cboAuswahl.addItem(new ImageIcon(KategorieAnlegen.class.getResource("/Icons/shopping-cart-add.png")));
			cboAuswahl.addItem(new ImageIcon(KategorieAnlegen.class.getResource("/Icons/shopping-cart-remove.png")));
			cboAuswahl.addItem(new ImageIcon(KategorieAnlegen.class.getResource("/Icons/skull.png")));
			cboAuswahl.addItem(new ImageIcon(KategorieAnlegen.class.getResource("/Icons/smart-device.png")));
			cboAuswahl.addItem(new ImageIcon(KategorieAnlegen.class.getResource("/Icons/smiley.png")));
			cboAuswahl.addItem(new ImageIcon(KategorieAnlegen.class.getResource("/Icons/sneakers.png")));
			cboAuswahl.addItem(new ImageIcon(KategorieAnlegen.class.getResource("/Icons/sofa.png")));
			cboAuswahl.addItem(new ImageIcon(KategorieAnlegen.class.getResource("/Icons/stamp.png")));
			cboAuswahl.addItem(new ImageIcon(KategorieAnlegen.class.getResource("/Icons/sub-woofer.png")));
			cboAuswahl.addItem(new ImageIcon(KategorieAnlegen.class.getResource("/Icons/syringe.png")));
			cboAuswahl.addItem(new ImageIcon(KategorieAnlegen.class.getResource("/Icons/target.png")));
			cboAuswahl.addItem(new ImageIcon(KategorieAnlegen.class.getResource("/Icons/teapot.png")));
			cboAuswahl.addItem(new ImageIcon(KategorieAnlegen.class.getResource("/Icons/trash-can.png")));
			cboAuswahl.addItem(new ImageIcon(KategorieAnlegen.class.getResource("/Icons/umbrella.png")));
			cboAuswahl.addItem(new ImageIcon(KategorieAnlegen.class.getResource("/Icons/user-chat.png")));
			cboAuswahl.addItem(new ImageIcon(KategorieAnlegen.class.getResource("/Icons/user.png")));
			cboAuswahl.addItem(new ImageIcon(KategorieAnlegen.class.getResource("/Icons/vector.png")));
			cboAuswahl.addItem(new ImageIcon(KategorieAnlegen.class.getResource("/Icons/windows.png")));
			cboAuswahl.addItem(new ImageIcon(KategorieAnlegen.class.getResource("/Icons/wrenches.png")));
			cboAuswahl.addItem(new ImageIcon(KategorieAnlegen.class.getResource("/Icons/write.png")));
			cboAuswahl.setBounds(222, 272, 145, 30);
			contentPane.add(cboAuswahl);
				
//Hintergrund		
		JLabel Hintergrund = new JLabel();
		Hintergrund.setIcon(new ImageIcon(KategorieAnlegen.class.getResource("/Design/GUI3.png")));
		Hintergrund.setBounds(0, 0, 480, 480);
		contentPane.add(Hintergrund);
				
//Deaktivieren des Standard-JFrame Design und lege die Lage in Mitten des Bildschirms
		setUndecorated(true);
		setLocationRelativeTo(null);	
		
	}
}
