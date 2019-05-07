import java.io.*;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.*;
import java.util.Iterator;
import java.awt.*;
import javax.swing.*;


public class updateExcel extends JFrame {

	 int excelIndex = DodP.excelIndex;
     String excelProdukt = DodP.excelProdukt;
     double excelB = DodP.excelB;
	 double excelT = DodP.excelT;
	 double excelW = DodP.excelW;

	public void update() throws IOException  {
		FileInputStream fsIP= new FileInputStream(new File("tabela.xls")); //Otworzenie pliku
        
        Workbook wb = new HSSFWorkbook(fsIP); 
          
        Sheet worksheet = wb.getSheetAt(0); //Dostêp do arkusza
          
                          //tworzenie wiersza
       Row row = worksheet.createRow(excelIndex);
      
                         //tworzenie komórek
       Cell cellID = row.createCell(0);
       Cell cellNazwa = row.createCell(1);
       Cell cellB = row.createCell(2);
       Cell cellT = row.createCell(3);
       Cell cellW = row.createCell(4);
        
                         //add some content to that cell
       cellID.setCellValue(excelIndex);
       cellNazwa.setCellValue(excelProdukt);
       cellB.setCellValue(excelB);
       cellT.setCellValue(excelT);
       cellW.setCellValue(excelW);
        
      	
         

        try {
          	 System.out.println(excelIndex);
       	 System.out.println(excelProdukt);
       	 System.out.println(excelB);
       	 System.out.println(excelT);
       	 System.out.println(excelW);
       	 
       	 FileOutputStream output_file =new FileOutputStream(new File("tabela.xls")); //otwarcie strumienia
            wb.write(output_file); //Zapis zmian
            output_file.close();  //zamkniêcie strumienia
    } catch(Exception e) {
            e.printStackTrace();
    }
			
	}
	
	public updateExcel() throws IOException{
		update();
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(600,700);
		setVisible(true);
		setLayout(null);
		JLabel ety1 = new JLabel(" Dodano produkt ");
		add(ety1);
		ety1.setBounds(220, 10, 150, 50);
	}
	
	
	public static void main(String[] args)  {
		 SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				try {
					new updateExcel();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
				
			}
		});
	}

}
