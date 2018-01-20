import java.io.File;
import java.util.Scanner;
import java.util.jar.Attributes.Name;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableImage;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class UpdateExcel {
	private String strName = null;
	private String strPassword = null;
    public void updateexcel(String name,String password){
        try {
            // Excel获得文件
        
        	 this.strName = name;
        	 this.strPassword = password;

            Workbook wb = Workbook.getWorkbook(new File("info.xls"));
            // 打开一个文件的副本，并且指定数据写回到原文件
            WritableWorkbook book = Workbook.createWorkbook(new File("info.xls"),
                    wb);
            // 添加一个工作表

            WritableSheet sheet2 = book.getSheet(0);
            sheet2.addCell(new Label(0,sheet2.getRows()-1, strName));
            sheet2.addCell(new Label(1, sheet2.getRows()-1, strPassword));
	
            System.out.println("信息添加成功！");
            book.write();
            book.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void updateexcel(String sex){
        try {
            // Excel获得文件
        
        	String strSex = null;

        	strSex = sex;
            Workbook wb = Workbook.getWorkbook(new File("info.xls"));
            // 打开一个文件的副本，并且指定数据写回到原文件
            WritableWorkbook book = Workbook.createWorkbook(new File("info.xls"),
                    wb);
            // 添加一个工作表

            WritableSheet sheet2 = book.getSheet(0);
            sheet2.addCell(new Label(2,sheet2.getRows(), strSex));

            book.write();
            book.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void updatecountry(String country){
        try {
            // Excel获得文件
        
        	String strCountry = null;

        	strCountry = country;
            Workbook wb = Workbook.getWorkbook(new File("info.xls"));
            // 打开一个文件的副本，并且指定数据写回到原文件
            WritableWorkbook book = Workbook.createWorkbook(new File("info.xls"),
                    wb);
            // 添加一个工作表

            WritableSheet sheet2 = book.getSheet(0);
            sheet2.addCell(new Label(3,sheet2.getRows()-1, strCountry));

            book.write();
            book.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void updateprovince(String province){
        try {
            // Excel获得文件
        
        	String strProvince = null;

        	strProvince = province;
            Workbook wb = Workbook.getWorkbook(new File("info.xls"));
            // 打开一个文件的副本，并且指定数据写回到原文件
            WritableWorkbook book = Workbook.createWorkbook(new File("info.xls"),
                    wb);
            // 添加一个工作表

            WritableSheet sheet2 = book.getSheet(0);
            sheet2.addCell(new Label(4,sheet2.getRows()-1, strProvince));

            book.write();
            book.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void updatedance(String dance){
        try {
            // Excel获得文件
        
        	String strDance = null;

        	strDance = dance;
            Workbook wb = Workbook.getWorkbook(new File("info.xls"));
            // 打开一个文件的副本，并且指定数据写回到原文件
            WritableWorkbook book = Workbook.createWorkbook(new File("info.xls"),
                    wb);
            // 添加一个工作表

            WritableSheet sheet2 = book.getSheet(0);
            sheet2.addCell(new Label(5,sheet2.getRows()-1, strDance));

            book.write();
            book.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void updateself(String self){
        try {
            // Excel获得文件
        
        	String strSelf = null;

        	strSelf = self;
            Workbook wb = Workbook.getWorkbook(new File("info.xls"));
            // 打开一个文件的副本，并且指定数据写回到原文件
            WritableWorkbook book = Workbook.createWorkbook(new File("info.xls"),
                    wb);
            // 添加一个工作表

            WritableSheet sheet2 = book.getSheet(0);
            sheet2.addCell(new Label(6,sheet2.getRows()-1, strSelf));

            book.write();
            book.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}