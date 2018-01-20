import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ActionHandle {
	private JFrame frame = new JFrame("欢迎登录");
	private JButton submit = new JButton("登录");
	private JButton reset = new JButton("注册");
	private JLabel nameLab = new JLabel("用户名：");
	private JLabel passLab = new JLabel("密    码：");
	private JLabel infoLab1 = new JLabel("用户登录系统");
	private JLabel infoLab2 = new JLabel("用户登录");
	private JTextField nameText = new JTextField();
	private JPasswordField passText = new JPasswordField();
	
	
	public ActionHandle(){
		
		Font fnt1 = new Font("Serief", Font.BOLD, 24);
		Font fnt2 = new Font("Serief", Font.BOLD, 12);
		infoLab2.setFont(fnt2);
		infoLab1.setFont(fnt1);

		submit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
	//			if(arg0.getSource() == submit){
					String tname = nameText.getText();
					String tpass = new String(passText.getPassword());

					LoginCheck log = new LoginCheck(tname,tpass);
					if(log.validate()){
						infoLab2.setText("登陆成功，欢迎！");
					}else {
						infoLab2.setText("登录失败，请检查用户名和密码！");
					}
//				}
		
			}
		});
		
		
		reset.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
			if(arg0.getSource() == reset){
				File file=new File("info.xls");    
				if(!file.exists())    
				{      
				    	CreateExcel createExcel = new CreateExcel();
						createExcel.readexcel();
				}    
				ZhuCe zhuCe = new ZhuCe();
				infoLab2.setText("用户注册！");
			}
			}
		});
		
		
		frame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent arg0){
				System.exit(1);
			}
		});
		
		frame.setLayout(null);
		
		nameLab.setBounds(55, 56, 60, 20);      //名字提示
		passLab.setBounds(55, 80, 60, 20);      //密码提示
		
		infoLab1.setBounds(65, 5, 220, 30);   //标题
		
		infoLab2.setBounds(5, 135, 220, 30);   //提示信息
		
		nameText.setBounds(115, 56, 100, 20);   //名字输入
		passText.setBounds(115, 80, 100, 20);  //密码输入
		
		submit.setBounds(55, 116, 60, 20);    //登录
		reset.setBounds(155, 116, 60, 20);     //注册
		
		frame.add(nameLab);
		frame.add(passLab);
		
		frame.add(infoLab1);
		frame.add(infoLab2);
		
		frame.add(nameText);
		frame.add(passText);
		frame.add(submit);
		frame.add(reset);
		
		frame.setBounds(200, 250, 300, 200);
		frame.setVisible(true);
		
	}

	

}
