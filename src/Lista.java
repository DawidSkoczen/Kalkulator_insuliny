import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;

import jxl.read.biff.BiffException;

//import bibliotek s�u��cych do budowy interfejsu graficznego

@SuppressWarnings("serial")
public class Lista extends JFrame {

	private JButton DodP, Exit, Start, Info;

	public Lista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 600);
		setVisible(true);
		setTitle("Okno g��wne");
		setLayout(null);

		JLabel ety1 = new JLabel("Wybierz co b�dziemy dzisiaj robi�");
		ety1.setBounds(110, 10, 200, 100);
		add(ety1);

		// deklaracja przycisk�w
		Start = new JButton("Rozpocznij");
		DodP = new JButton("Dodaj / Usu� produkt");
		Info = new JButton("Autorzy");
		Exit = new JButton("Wyj�cie");
		// pozycjonowanie przycisk�w
		Start.setBounds(100, 100, 200, 50);
		DodP.setBounds(100, 175, 200, 50);
		Info.setBounds(100, 250, 200, 50);
		Exit.setBounds(100, 325, 200, 50);
		// dodanie przycisk�w do okna aplikacji
		add(Start);
		add(DodP);
		add(Exit);
		add(Info);

		ActionListener action1 = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				dispose();
			}
		}; 

		ActionListener action2 = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				SwingUtilities.invokeLater(new Runnable() {
					
					@Override
					public void run() {
						try {
							new DodP();
						} catch (BiffException | IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
				});
					
					
					}
				
			
		};

		

		ActionListener action4 = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				new Info();
			}
		};

		ActionListener action5 = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				new Start();
			}
		};

		// obs�uga zdarzen zwi�zanych zprzyciskami
		Exit.addActionListener(action1);
		DodP.addActionListener(action2);
		Start.addActionListener(action5);
		Info.addActionListener(action4);

	};

	
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Lista();
				
			}
		});
	};

}
