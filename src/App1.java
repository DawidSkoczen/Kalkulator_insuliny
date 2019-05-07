import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.awt.*;
import java.awt.event.*;
import javax.swing.SwingUtilities;

import javafx.scene.layout.Background;


@SuppressWarnings("serial")
public class App1 extends JFrame implements ActionListener   {
	JTextField arg1;
	JTextField arg2;
	JTextField arg3;
	JLabel arg4;
	JLabel arg5;
	JLabel wynik;
	JLabel ety1;
	JLabel ety2;
	JLabel ety3;
	JLabel ety4;
	JLabel ety5;
	JLabel ety6;
	JButton licz;
	
	//przekazanie zmiennych z klasy Start
	double aktualneStezenieGlukozy = Start.aktualneStezenieGlukozy;
	double iloscJednostek = Start.iloscJednostek;
	double korekta = Start.korekta;
	
	//przekazanie zmiennych z klasy WyborP
	double weglowodany = WyborP.weglowodany;
	double bialka = WyborP.bialka;
	double tluszcze = WyborP.tluszcze;
	
	public App1() {
		 
	
		// ustawienie rozmiaru okna
		setSize(500, 600);
		// ustawienie rozk³adu
		setLayout(null);
		// ustawienie koloru t³a
		setBackground(Color.lightGray);
		setVisible(true);
		setTitle("Iloœæ potrzebnej insuliny:");

		ety1 = new JLabel(" Kalkulator glikemiczny"); // etykieta tekstowa
		add(ety1);
		ety1.setBounds(150, 10, 150, 50);

		ety2 = new JLabel("Wêglowodany    Bia³ka         T³uszcze "); // etykieta tekstowa
		add(ety2);
		ety2.setBounds(150, 50, 250, 50);

		arg1 = new JTextField();
		add(arg1);
		arg1.setBounds(165, 100, 50, 50);
		arg1.setText(String.valueOf(weglowodany));
		
		arg2 = new JTextField();
		add(arg2);
		arg2.setBounds(235, 100, 50, 50);
		arg2.setText(String.valueOf(bialka));
		
		arg3 = new JTextField();
		add(arg3);
		arg3.setBounds(305, 100, 50, 50);
		arg3.setText(String.valueOf(tluszcze));
		
		arg4 = new JLabel("0 j");
		add(arg4);
		arg4.setBounds(165, 180, 150, 50);
	
		arg5 = new JLabel("0 j");
		add(arg5);
		arg5.setBounds(165, 260, 150, 50);

		ety3 = new JLabel("Makro"); // etykieta tekstowa
		add(ety3);
		ety3.setBounds(100, 100, 200, 50);

		ety4 = new JLabel("Iloœæ ww"); // etykieta tekstowa
		add(ety4);
		ety4.setBounds(100, 180, 200, 50);

		ety5 = new JLabel("WBT"); // etykieta tekstowa
		add(ety5);
		ety5.setBounds(100, 250, 200, 50);
		// przycisk "Zamiana"
		licz = new JButton("Przelicz"); // zdef. obiektu odbieraj¹cego zdarz.
		licz.addActionListener(this);
		add(licz);
		licz.setBounds(150, 330, 200, 50);
		ety6 = new JLabel(" Iloœæ potrzebnej insuliny: "); // etykieta tekstowa
		add(ety6);
		ety6.setBounds(50, 400, 200, 100);

		wynik = new JLabel(" 0 j");
		add(wynik);
		wynik.setBounds(200, 400, 200, 100);

		// tworzenie menu
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

		// obs³uga zdarzenia (zamkniêcie okna)
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
				
			}
		});
	}

	// definicja metody obs³uguj¹cej zdarzenie (naciœniêcie przycisku)
	public void actionPerformed(ActionEvent e) {
		String label = e.getActionCommand();
		if (label.equals("Przelicz")) {
			try {
				System.out.println(iloscJednostek);
				System.out.println(aktualneStezenieGlukozy);
				System.out.println(korekta);
				Double w = ((Double.parseDouble(arg1.getText())));
				Double b = ((Double.parseDouble(arg2.getText())));
				Double t = ((Double.parseDouble(arg3.getText())));
				
				@SuppressWarnings("deprecation")
				double W = new BigDecimal(w).setScale(2, BigDecimal.ROUND_UP).doubleValue();
				@SuppressWarnings("deprecation")
				double B = new BigDecimal(b).setScale(2, BigDecimal.ROUND_UP).doubleValue();
				@SuppressWarnings("deprecation")
				double T = new BigDecimal(t).setScale(2, BigDecimal.ROUND_UP).doubleValue();

				Double ww = (W / 10);
				@SuppressWarnings("deprecation")
				double WW = new BigDecimal(ww).setScale(2, BigDecimal.ROUND_UP).doubleValue();
				arg4.setText(WW + "j");
				Double wbt = ((B * 4 + T * 9) / 100);
				@SuppressWarnings("deprecation")
				double WBT = new BigDecimal(wbt).setScale(2, BigDecimal.ROUND_UP).doubleValue();
				arg5.setText(WBT + "j");
				Double ins = (WW + WBT);
				@SuppressWarnings("deprecation")
				double INS = new BigDecimal(ins).setScale(2, BigDecimal.ROUND_UP).doubleValue();
				if (aktualneStezenieGlukozy > 160) {
					
				wynik.setText((iloscJednostek*INS)+((aktualneStezenieGlukozy-korekta)/100) + "j");
				}
				else if (aktualneStezenieGlukozy <= 160 & aktualneStezenieGlukozy >= 50) { 
					wynik.setText((iloscJednostek*INS + "j"));
				}
				else if (aktualneStezenieGlukozy<50) {
					wynik.setText((iloscJednostek*INS)-((aktualneStezenieGlukozy+korekta)/200) + "j");
				}
				else if ((iloscJednostek*INS)-((aktualneStezenieGlukozy+korekta)/100)<=0) {
					wynik.setText(0 + "j");
				}
				else {
					wynik.setText((iloscJednostek*INS)-((aktualneStezenieGlukozy+korekta)/100) + "j");
				}
				
				
			} catch (NumberFormatException ev) {
				System.out.println("Blad argumentow!? Wpisz poprawne wartosci!");
			}
		}

		if (label.equals("Nowy")) {
			arg1.setText(null);
			arg2.setText(null);
			arg3.setText(null);
			arg4.setText("0j");
			arg5.setText("0 j");
			wynik.setText("0 j");
		}
		{
			if (label.equals("Zamknij")) {

				JOptionPane.showMessageDialog(this, "wybrano opcjê: " + label, "Informacja",
						JOptionPane.INFORMATION_MESSAGE);
				// koniec okna dialogowego
				System.out.println(e.getActionCommand());
				if (e.getActionCommand().equals("Zamknij"))
					dispose();
			}
			;
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new App1();
			
			}
		});
	}

}
