import java.io.File;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

class CreateExcel {
	public void readexcel(){
        try {
            // 打开文件

            WritableWorkbook book = Workbook.createWorkbook(new File("info.xls"));
            // 生成名为“第一页”的工作表，参数0表示这是第一页
            WritableSheet sheet1 = book.createSheet("Sheet", 0);
            // 在Label对象的构造子中指名单元格位置是第一列第一行(0,0)

            Label label1=new Label(0,0,"姓名");

            Label label2=new Label(1,0,"密码");
            Label label3=new Label(2,0,"性别");
            Label label4=new Label(3,0,"国家");
            
            Label label5=new Label(4,0,"省份");
            Label label6=new Label(5,0,"兴趣爱好");
            Label label7=new Label(6,0,"个人简介");
            
            sheet1.addCell(label1);
            sheet1.addCell(label2);
            sheet1.addCell(label3);
            sheet1.addCell(label4);
            sheet1.addCell(label5);
            sheet1.addCell(label6);
            sheet1.addCell(label7);

            // 写入数据并关闭文件
            book.write();
            book.close();
            System.out.println("Excel已生成！");
        } catch (Exception e) {
            System.out.println(e);
        }
}
}