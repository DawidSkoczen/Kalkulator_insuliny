import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import jxl.read.biff.BiffException;

import java.awt.Color;

public class Start extends JFrame implements ActionListener {

	JButton dalej;
	JLabel ety1;
	JLabel ety2;
	JLabel ety3;
	JLabel ety4;
	JLabel ety5;
	JLabel ety6;
	JTextField arg1;
	JTextField arg2;
	@SuppressWarnings("rawtypes")
	JComboBox lista1;
	public static double aktualneStezenieGlukozy;
	public static double iloscJednostek;
	public static double korekta;

	private JButton Exit;

	public Start() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// ustawienie rozmiaru okna
		setSize(500, 600);
		// ustawienie rozk³adu
		setLayout(null);
		// ustawienie koloru t³a
		setBackground(Color.lightGray);
		setVisible(true);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		JMenu menu = new JMenu("Opcje");
		JMenuItem Opcja1 = new JMenuItem("Nowy");
		JMenuItem Opcja2 = new JMenuItem("Zamknij");
		menuBar.add(menu);
		menu.add(Opcja1);
		menu.add(Opcja2);
		menu.addActionListener(this);
		Opcja1.addActionListener(this);
		Opcja2.addActionListener(this);

		ety1 = new JLabel(" Kalkulator glikemiczny"); // etykieta tekstowa
		add(ety1);
		ety1.setBounds(150, 10, 150, 50);

		ety2 = new JLabel("Aktualne stê¿enie glukozy:"); // etykieta tekstowa
		add(ety2);
		ety2.setBounds(25, 100, 200, 50);

		arg1 = new JTextField();
		add(arg1);
		arg1.setBounds(225, 100, 75, 50);
		arg1.setText("0");

		ety3 = new JLabel("mg/dL"); // etykieta tekstowa
		add(ety3);
		ety3.setBounds(305, 100, 200, 50);

		String[] wart = { "0", "0.5", "1", "1.5", "2" };
		lista1 = new JComboBox();
		JComboBox lista1 = new JComboBox(wart);

		lista1.setSelectedIndex(0);
		add(lista1);
		lista1.setBounds(225, 180, 75, 50);

		;

		ety4 = new JLabel("Iloœæ jednostek insuliny na 1 ww:"); // etykieta tekstowa
		add(ety4);
		ety4.setBounds(25, 180, 200, 50);

		ety3 = new JLabel("j"); // etykieta tekstowa
		add(ety3);
		ety3.setBounds(305, 180, 200, 50);

		arg2 = new JTextField();
		add(arg2);
		arg2.setBounds(225, 260, 75, 50);
		arg2.setText("0");

		ety5 = new JLabel("Korekta:           		        1j na"); // etykieta tekstowa
		add(ety5);
		ety5.setBounds(50, 260, 200, 50);

		ety6 = new JLabel("mg/dL"); // etykieta tekstowa
		add(ety6);
		ety6.setBounds(305, 260, 200, 50);

		dalej = new JButton("Dalej"); // zdef. obiektu odbieraj¹cego zdarz.
		dalej.addActionListener(this);
		add(dalej);
		dalej.setBounds(300, 400, 150, 30);

		Exit = new JButton("Ekran g³ówny"); // zdef. obiektu odbieraj¹cego zdarz.
		Exit.addActionListener(this);
		add(Exit);
		Exit.setBounds(20, 400, 150, 30);

		ActionListener action1 = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				dispose();
			}
		};

		ActionListener action2 = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				try {
					korekta = Double.parseDouble(arg2.getText());
					String iJ = (String) lista1.getSelectedItem();
					iloscJednostek = Double.parseDouble(iJ);
					aktualneStezenieGlukozy = Double.parseDouble(arg1.getText());
					new WyborP();
				} catch (BiffException | IOException e) {

					e.printStackTrace();

				}
			}
		};

		// ActionListener do czyszczenia okien
		ActionListener action4 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String label = e.getActionCommand();
				if (label.equals("Nowy")) {
					lista1.setSelectedIndex(0);

					arg1.setText("0");
					arg2.setText("0");

				}
			}
		};
		// ActionListener do zamykania aplikacji
		ActionListener action5 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String label = e.getActionCommand();
				if (label.equals("Zamknij")) {
					System.exit(0);

				}
			}
		};

		Opcja1.addActionListener(action4);
		Opcja2.addActionListener(action5);

		Exit.addActionListener(action1);
		dalej.addActionListener(action2);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Start();

			}
		});

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

}
