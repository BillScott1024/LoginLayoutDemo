import java.io.File;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class LoginCheck {
	private String name;
	private String password;
	private int i = 0;
	private String[][] array;
//	private String strName;
//	private String strPass;
//	private Map<String, String> map;
	
public LoginCheck(String name,String password){
	this.name = name;
	this.password = password;
//	try {
//		readMapFromFile(map);
//	} catch (Exception e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
}


public boolean validate(){
	
//	try {
//		 Workbook book = Workbook.getWorkbook(new File("info.xls"));
		 
     // 获得第一个工作表对象
 //    Sheet sheet = book.getSheet(0);
     
//	  for(i=1;i<sheet.getRows();i++){
//		  
//		  Cell cell1 = sheet.getCell(i, 0);
//          array[i][0] = cell1.getContents();
//          
//          Cell cell2 = sheet.getCell(i, 1);
//          array[i][1] = cell2.getContents();
//		if(this.name.equals(array[i][0])&&this.password.equals(array[i][1])){
//		
//			return true;
//		}else{
//			
//			return false;
//		}
//	  }
//	  book.close();
//		
//} catch (BiffException e) {
//	// TODO Auto-generated catch block
//
//	e.printStackTrace();
//} catch (IOException e) {
//	// TODO Auto-generated catch block
//	
//	e.printStackTrace();
//}


    try {
        Workbook book = Workbook.getWorkbook(new File("info.xls"));
        // 获得第一个工作表对象
        Sheet sheet = book.getSheet(0);
        // 得到第一列第一行的单元格
        
//        Cell cell1 = sheet.getCell(0, 0);
//        array[i][0] = cell1.getContents();
//        Cell cell2 = sheet.getCell(1, 1);
//        array[i][1] = cell2.getContents();
        
//        System.out.println("SHUCHU "+cell1.getContents());
        
        for(i=0;i<sheet.getRows();i++){
  		  
  		    Cell cell1 = sheet.getCell(0, i);
     //       array[i][0] = cell1.getContents();
            Cell cell2 = sheet.getCell(1, i);
  //          array[i][1] = cell2.getContents();
            
  		if(this.name.equals(cell1.getContents())&&this.password.equals(cell2.getContents())){
  			 book.close();
  	        book.close();
  			return true;
  		}

  	  }
  	  book.close();
        book.close();
    } catch (Exception e) {
        System.out.println(e);
    }

//public void readMapFromFile(Map<String, String> map) throws Exception
//{
//	File f = new File("E:"+File.separator+"info.txt");
//	ObjectInputStream ois = null;
//	InputStream input = new FileInputStream(f);
//	ois = new ObjectInputStream(input);
////	Object obj = ois.readObject();
//	ois.close();
////	System.out.println(obj);
//}

	return false;
}
}
