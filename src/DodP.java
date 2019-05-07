import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

@SuppressWarnings("serial")
public class DodP extends JFrame implements ActionListener {

	JTextField arg1;
	JTextField arg2;
	JTextField arg3;
	JTextField arg4;
	JLabel ety1;
	JLabel ety2;
	JLabel ety3;
	JLabel ety4;
	JLabel ety5;
	JLabel ety6;
	JLabel ety7;
	JButton Exit;
	JButton WyborP;
	JButton dodaj;
	JComboBox lista;
	JButton usun;

	public static int excelIndex;
	public static String excelProdukt;
	public static double excelB;
	public static double excelT;
	public static double excelW;
	String[] produkty = new String[ID()];
	public static int idUsuwania;
	
	// funkcja zwracaj¹ca aktualn¹ liczbê wierszy "bazy danych" excel
	public int ID() throws BiffException, IOException {
		Workbook skoroszyt = Workbook.getWorkbook(new File("tabela.xls"));
		Sheet arkusz = skoroszyt.getSheet(0);
		excelIndex = arkusz.getRows();
		return excelIndex;
	}
	
	
	public String[] prod() throws IOException, BiffException {
		Workbook skoroszyt = Workbook.getWorkbook(new File("tabela.xls"));
		Sheet arkusz = skoroszyt.getSheet(0);
		for (int i = 0; i < arkusz.getRows(); i++) {

			Cell komorka = arkusz.getCell(1, i);
			String produkt = komorka.getContents();
			produkty[i] = produkt;
			
		}
		return produkty;
	}

	public DodP() throws BiffException, IOException {
		ID();
		prod();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 700);
		setLayout(null);
		setBackground(Color.lightGray);
		setVisible(true);
		setTitle("Dodawanie nowych produktów");

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

		ety1 = new JLabel(" Kalkulator glikemiczny");
		add(ety1);
		ety1.setBounds(220, 10, 150, 50);

		ety2 = new JLabel(" Uzupe³nij wartoœci dla 100g produktu");
		add(ety2);
		ety2.setBounds(50, 50, 250, 30);

		ety3 = new JLabel("Nazwa Produktu");
		add(ety3);
		ety3.setBounds(50, 100, 250, 40);

		arg1 = new JTextField();
		add(arg1);
		arg1.setBounds(160, 100, 300, 40);

		ety4 = new JLabel("Bia³ko");
		add(ety4);
		ety4.setBounds(50, 170, 200, 40);

		ety5 = new JLabel("T³uszcze");
		add(ety5);
		ety5.setBounds(50, 220, 200, 40);

		ety6 = new JLabel("Wêglowodany");
		add(ety6);
		ety6.setBounds(50, 270, 200, 40);

		arg2 = new JTextField();
		add(arg2);
		arg2.setBounds(160, 170, 80, 40);

		arg3 = new JTextField();
		add(arg3);
		arg3.setBounds(160, 220, 80, 40);

		arg4 = new JTextField();
		add(arg4);
		arg4.setBounds(160, 270, 80, 40);

		dodaj = new JButton("Dodaj produkt");
		dodaj.addActionListener(this);
		add(dodaj);
		dodaj.setBounds(360, 270, 150, 40);

		ety7 = new JLabel(" Wybierz z listy produkt, który chcesz usun¹æ");
		add(ety7);
		ety7.setBounds(50, 360, 400, 30);

		
		lista = new JComboBox();
		final JComboBox lista = new JComboBox(produkty);

		lista.setSelectedIndex(0);
		lista.addActionListener(this);
		add(lista);
		lista.setBounds(30, 420, 300, 40);

		usun = new JButton("Usuñ Produkt");
		usun.setBounds(360, 420, 150, 40);
		usun.addActionListener(this);
		add(usun);

		Exit = new JButton("Wyjœcie"); // zdef. obiektu odbieraj¹cego zdarz.
		Exit.addActionListener(this);
		add(Exit);
		Exit.setBounds(20, 540, 150, 40);

		ActionListener action1 = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				dispose();
			}
		};
		ActionListener pozyskaj = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				idUsuwania = lista.getSelectedIndex();
			}
		
		};
		lista.addActionListener(pozyskaj);

		ActionListener action2 = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				try {

					excelProdukt = arg1.getText();
					excelB = Double.parseDouble(arg2.getText());
					excelT = Double.parseDouble(arg3.getText());
					excelW = Double.parseDouble(arg4.getText());

					new updateExcel();

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		};
		ActionListener action3 = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				try {
					new UsuwanieExcel();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}};
			
			//ActionListener do czyszczenia okien
			ActionListener action4 = new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String label = e.getActionCommand();
					if (label.equals("Nowy")) {
						arg1.setText(null);
						arg2.setText(null);
						arg3.setText(null);
						arg4.setText(null);
						
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
		Exit.addActionListener(action1);
		dodaj.addActionListener(action2);
		usun.addActionListener(action3);
		
		
		
	}

	// metoda main
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
