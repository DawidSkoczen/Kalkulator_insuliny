import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import jxl.Cell;
import jxl.CellType;
import jxl.NumberCell;
import jxl.Sheet;
import jxl.read.biff.BiffException;
import jxl.Workbook;

@SuppressWarnings("serial")

public class WyborP extends JFrame implements ActionListener {
	Workbook skoroszyt = Workbook.getWorkbook(new File("tabela.xls"));
	Sheet arkusz = skoroszyt.getSheet(0);
	JComboBox<String> lista1;
	JComboBox<String> lista2;
	JComboBox<String> lista3;
	JComboBox<String> lista4;
	String[] produkty = new String[arkusz.getRows()];
	double[] B = new double[arkusz.getRows()];
	double[] T = new double[arkusz.getRows()];
	double[] W = new double[arkusz.getRows()];
	
	public int id1;
	public int id2;
	public int id3;
	public int id4;
	
	public double waga1;
	public double waga2;
	public double waga3;
	public double waga4;
	 
	public static double bialka;
	public static double tluszcze;
	public static double weglowodany;
		
	
	
	// funkcja zape³niaj¹ca tablicê produktów
	public String[] prod() throws IOException, BiffException {

		for (int i = 0; i < arkusz.getRows(); i++) {

			Cell komorka = arkusz.getCell(1, i);
			String produkt = komorka.getContents();
			produkty[i] = produkt;

		}
		return produkty;
	}

	// funkcja zape³niaj¹ca tablice bia³ek
	public double[] bialka() throws IOException, BiffException {

		for (int i = 0; i < arkusz.getRows(); i++) {

			Cell komorka = arkusz.getCell(2, i);
			double bialko = 0;
			// zmiana typu danych pobieranych z komórki
			if (komorka.getType() == CellType.NUMBER) {
				NumberCell nc = (NumberCell) komorka;
				bialko = nc.getValue();
			}
			B[i] = bialko;
		}

		return B;
	}

	// funkcja zape³niaj¹ca tablice t³uszczy
	public double[] tluszcze() throws IOException, BiffException {

		for (int i = 0; i < arkusz.getRows(); i++) {

			Cell komorka = arkusz.getCell(3, i);
			double tluszcz = 0;
			// zmiana typu danych pobieranych z komórki
			if (komorka.getType() == CellType.NUMBER) {
				NumberCell nc = (NumberCell) komorka;
				tluszcz = nc.getValue();
			}
			T[i] = tluszcz;
		}

		return T;
	}

	// funkcja zape³niaj¹ca tablice weglowodanowe
	public double[] weglowodany() throws IOException, BiffException {

		for (int i = 0; i < arkusz.getRows(); i++) {

			Cell komorka = arkusz.getCell(4, i);
			double weglowodan = 0;
			// zmiana typu danych pobieranych z komórki
			if (komorka.getType() == CellType.NUMBER) {
				NumberCell nc = (NumberCell) komorka;
				weglowodan = nc.getValue();
			}
			W[i] = weglowodan;
		}

		return W;
	}

	// konstruktor

	public WyborP() throws BiffException, IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		prod();
		bialka();
		tluszcze();
		weglowodany(); // wywo³anie funkcji zape³niaj¹cych tablicê
		setVisible(true);
		setLayout(null);
		setSize(500, 600);
		// ustawienie koloru t³a
		setBackground(Color.lightGray);

		setTitle("Wybór produktów");

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

		JLabel ety1;
		JLabel ety2;
		JLabel ety3;
		JLabel ety4;
		JLabel ety5;
		JLabel ety6;
		JLabel ety7;
		JTextField arg1;
		JTextField arg2;
		JTextField arg3;
		JTextField arg4;

		JButton App1;
		JButton Exit;

		ety1 = new JLabel(" Kalkulator glikemiczny"); // etykieta tekstowa
		add(ety1);
		ety1.setBounds(150, 10, 150, 40);

		ety2 = new JLabel(" Wybierz produkty"); // etykieta tekstowa
		add(ety2);
		ety2.setBounds(50, 50, 150, 40);

		ety3 = new JLabel("Waga"); // etykieta tekstowa
		add(ety3);
		ety3.setBounds(350, 50, 150, 40);

		ety4 = new JLabel("g"); // etykieta tekstowa
		add(ety4);
		ety4.setBounds(400, 100, 50, 40);

		ety5 = new JLabel("g"); // etykieta tekstowa
		add(ety5);
		ety5.setBounds(400, 170, 50, 40);

		ety6 = new JLabel("g"); // etykieta tekstowa
		add(ety6);
		ety6.setBounds(400, 240, 50, 40);

		ety7 = new JLabel("g"); // etykieta tekstowa
		add(ety7);
		ety7.setBounds(400, 310, 50, 40);

		arg1 = new JTextField();
		add(arg1);
		arg1.setBounds(350, 100, 50, 40);
		arg1.setText("100");
		// etykieta tekstowa
		arg2 = new JTextField();
		add(arg2);
		arg2.setBounds(350, 170, 50, 40);
		arg2.setText("100");

		arg3 = new JTextField();
		add(arg3);
		arg3.setText("100");
		arg3.setBounds(350, 240, 50, 40);

		arg4 = new JTextField();
		add(arg4);
		arg4.setBounds(350, 310, 50, 40);
		arg4.setText("100");
		
		lista1 = new JComboBox<String>(produkty);
		add(lista1);
		lista1.setBounds(50, 100, 250, 40);
		

		lista2 = new JComboBox<String>(produkty);
		add(lista2);
		lista2.setBounds(50, 170, 250, 40);

		lista3 = new JComboBox<String>(produkty);
		add(lista3);
		lista3.setBounds(50, 240, 250, 40);

		lista4 = new JComboBox<String>(produkty);
		add(lista4);
		lista4.setBounds(50, 310, 250, 40);


		Exit = new JButton("Wstecz"); // zdef. obiektu odbieraj¹cego zdarz.
		Exit.addActionListener(this);
		add(Exit);
		Exit.setBounds(20, 440, 150, 30);

		App1 = new JButton("Dalej"); // zdef. obiektu odbieraj¹cego zdarz.
		
		App1.addActionListener(this);
		add(App1);
		App1.setBounds(300, 440, 150, 30);

		
		MouseMotionListener pozyskajId = new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent mouseEvent) {
				waga1 = Double.parseDouble(arg1.getText());
				waga2 = Double.parseDouble(arg2.getText());
				waga3 = Double.parseDouble(arg3.getText());
				waga4 = Double.parseDouble(arg4.getText());
				
			}
			
			@Override
			public void mouseDragged(MouseEvent mouseEvent) {
				waga1 = Double.parseDouble(arg1.getText());
				waga2 = Double.parseDouble(arg2.getText());
				waga3 = Double.parseDouble(arg3.getText());
				waga4 = Double.parseDouble(arg4.getText());
				
			}
		};
		
		// pozyskiwanie id z comboboxa i wagi z textFieldów
		ActionListener pozyskaj = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
		
				
				id1 = lista1.getSelectedIndex();
				id2 = lista2.getSelectedIndex();
				id3 = lista3.getSelectedIndex();
				id4 = lista4.getSelectedIndex();
				
				waga1 = Double.parseDouble(arg1.getText());
				waga2 = Integer.parseInt(arg2.getText());
				waga3 = Integer.parseInt(arg3.getText());
				waga4 = Integer.parseInt(arg4.getText());
				
			}
		
		};
		
		
		ActionListener action1 = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				dispose();
			}
		};

		ActionListener action2 = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				
			
				obliczenie();
				new App1();
				System.out.println(bialka);
				System.out.println(tluszcze);
				System.out.println(weglowodany);
			}
		};
		
		//ActionListener do czyszczenia okien
		ActionListener action4 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String label = e.getActionCommand();
				if (label.equals("Nowy")) {
					lista1.setSelectedIndex(0);
					lista2.setSelectedIndex(0);
					lista3.setSelectedIndex(0);
					lista4.setSelectedIndex(0);
					
					arg1.setText("0");
					arg2.setText("0");
					arg3.setText("0");
					arg4.setText("0");
					
				}
			}};
			//ActionListener do zamykania aplikacji
			ActionListener action5 = new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String label = e.getActionCommand();
					if (label.equals("Zamknij")) {
						System.exit(0);
						
					}
				}};
		

		
	Opcja1.addActionListener(action4);
	Opcja2.addActionListener(action5);
		
		arg1.addMouseMotionListener(pozyskajId);
		arg2.addMouseMotionListener(pozyskajId);
		arg3.addMouseMotionListener(pozyskajId);
		arg4.addMouseMotionListener(pozyskajId);
	
		
		lista1.addActionListener(pozyskaj);
		lista2.addActionListener(pozyskaj);
		lista3.addActionListener(pozyskaj);
		lista4.addActionListener(pozyskaj);

		
		Exit.addActionListener(action1);
		
		App1.addActionListener(action2);
		
		
	}

	// metoda main
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {

					
					new WyborP();
				} catch (BiffException | IOException e) {
					 e.printStackTrace();
				}
			}
		});

	}
	public void obliczenie() {
		bialka = ((B[id1]*(waga1/100))+(B[id2]*(waga2/100))+(B[id3]*(waga3/100))+(B[id4]*(waga4/100)));
		tluszcze =  ((T[id1]*(waga1/100))+(T[id2]*(waga2/100))+(T[id3]*(waga3/100))+(T[id4]*(waga4/100)));
		weglowodany = ((W[id1]*(waga1/100))+(W[id2]*(waga2/100))+(W[id3]*(waga3/100))+(W[id4]*(waga4/100)));
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}