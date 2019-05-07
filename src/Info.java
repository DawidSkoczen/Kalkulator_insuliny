
import java.awt.event.*;
import javax.swing.*;

public class Info extends JFrame implements ActionListener {
	public Info() {
		setSize(800, 600);
		setTitle("O Autorach");
		setVisible(true);
		// etykiety
		setLayout(null);
		// deklaracja obiektów
		JLabel ety1 = new JLabel("Kalkulator glikemiczny");
		ety1.setBounds(250, 40, 220, 20);
		add(ety1);
		JLabel ety2 = new JLabel("Jest to program umo¿lwiaj¹cy przeliczanie zapotrzebowania insuliny do posi³ków ");
		ety2.setBounds(100, 60, 500, 20);
		add(ety2);
		JLabel ety3 = new JLabel("Autorzy:");
		ety3.setBounds(20, 80, 220, 20);
		add(ety3);

		JLabel ety4 = new JLabel("* Matejek Micha³");
		ety4.setBounds(20, 120, 220, 20);
		add(ety4);

		JLabel ety5 = new JLabel("* Nowek Marcin");
		ety5.setBounds(20, 150, 220, 20);
		add(ety5);

		JLabel ety6 = new JLabel("* Sapiñski Karol");
		ety6.setBounds(20, 180, 220, 20);
		add(ety6);

		JLabel ety7 = new JLabel("* Skoczeñ Dawid");
		ety7.setBounds(20, 210, 220, 20);
		add(ety7);

		JLabel ety8 = new JLabel("* Tetkowska Oliwia");
		ety8.setBounds(20, 240, 220, 20);
		add(ety8);

		JButton Exit = new JButton("Wyjœæie");
		Exit.setBounds(300, 450, 100, 40);
		add(Exit);

		ImageIcon Img1 = new ImageIcon("KOT.jpg");
		final JLabel KOT = new JLabel();
		KOT.setIcon(Img1);
		KOT.setBounds(150, 40, 600, 600);
		add(KOT);
		KOT.setVisible(true);

		ActionListener action1 = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				dispose();
			}
		};
		Exit.addActionListener(action1);

	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Info(); 
			}
		});
	}

	private class Lista extends WindowAdapter {
		public void windowClosing(WindowEvent arg0) {
			dispose();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}