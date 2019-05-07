import java.io.*;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.*;
import java.util.Iterator;
import java.awt.*;
import javax.swing.*;

public class UsuwanieExcel extends JFrame {
	int idUsuwania = DodP.idUsuwania;
	
	public void usuwanie() throws IOException  {
		FileInputStream fsIP= new FileInputStream(new File("tabela.xls")); 
        
        Workbook wb = new HSSFWorkbook(fsIP); 
          
        Sheet worksheet = wb.getSheetAt(0); 
         
        worksheet.removeRow(worksheet.getRow(idUsuwania));
                 

        try {
      
       	 
       	 FileOutputStream output_file =new FileOutputStream(new File("tabela.xls")); 
            wb.write(output_file);
            output_file.close();  
    } catch(Exception e) {
            e.printStackTrace();
    }
			
	}
	
	public UsuwanieExcel() throws IOException{
		usuwanie();
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(600,700);
		setVisible(true);
		setLayout(null);
		JLabel ety1 = new JLabel(" Usuniêto produkt ");
		add(ety1);
		ety1.setBounds(220, 10, 150, 50);
	}

	public static void main(String[] args) {
		 SwingUtilities.invokeLater(new Runnable() {
				
			@Override
			public void run() {
				try {
					new UsuwanieExcel();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
				
			}
		});

	}

}
