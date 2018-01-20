import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.concurrent.CountDownLatch;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ZhuCe {
//	private JFrame frame = new JFrame("欢迎注册");
//	public ZhuCe() {
//		// TODO Auto-generated constructor stub
//
//	JDialog dialog = new JDialog();
//    dialog.setBounds(500, 100, 800, 600);
//    dialog.setVisible(true);
//	}
	
	/* 
	 *      用户注册【大标题】
	 *   
	 *   用户名：     _____       用户名必须为6-16位字母或数字！|| 提示1
	 *   密   码：      _____       密码不能为空             ||提示2
	 *   密码重复： ______      两次密码必须一致    ||提示3
	 *   性别： 【单选框】   【单选框】
	 *   国家： 【下拉框】     省份：【下拉框】
	 *   兴趣爱好：【复选框】  【复选框】  【复选框】  【复选框】
	 *   个人简介：    【文本框】
	 *   
	 *   
	 *   注册：【按钮】
	 * */
	
	private JFrame frame = new JFrame("欢迎注册");     //窗口名称
	
	private JLabel infoLab1 = new JLabel("用户注册");   //标题
	
	private JLabel infoLab2 = new JLabel("用户名必须为6-16位字母或数字");    //提示一
	private JLabel infoLab3 = new JLabel("密码不能为空");    //提示二
	private JLabel infoLab4 = new JLabel("两次密码必须一致");    //提示三
	private JLabel infoLab5 = new JLabel("注册成功！");    //提示四

	private JLabel infoLabname = new JLabel("用户名：");
	private JLabel infoLabpass = new JLabel("密    码：");
	private JLabel infoLabpass2 = new JLabel("密码重复：");
	private JLabel infoLabsex = new JLabel("性    别：");
	private JLabel infoLabcountry = new JLabel("国    家：");
	private JLabel infoLabprovince = new JLabel("省    份：");
	private JLabel infoLabhabit = new JLabel("兴趣爱好:");
	private JLabel infoLabself = new JLabel("个人简介:");
	
	
	private JTextField nameText = new JTextField();
	private JPasswordField passText = new JPasswordField();
	private JPasswordField passText2 = new JPasswordField();
	private JTextArea self = new JTextArea();
	
	private String boypng = "boy.png";
	private String girlpng = "girl.png";
	private JRadioButton boy = new JRadioButton("男",new ImageIcon(boypng),true);     //单选
	private JRadioButton girl = new JRadioButton("女",new ImageIcon(girlpng),false);
	
//	private JRadioButton boy = new JRadioButton("男");     //单选
//	private JRadioButton girl = new JRadioButton("女");
//	
	private JComboBox jcbcountry = null;            //下拉框
	private JComboBox jcbprovince = null;
	
	private JCheckBox jbdance = new JCheckBox("跳舞");      //复选
	private JCheckBox jbmusic = new JCheckBox("听音乐");
	private JCheckBox jbswim = new JCheckBox("游泳");
	private JCheckBox jbread = new JCheckBox("阅读");
	
	private JButton regist = new JButton("注           册");
	
	int count1  = 0;
	public ZhuCe(){
		
		Font fnt1 = new Font("Serief", Font.BOLD, 24);
		Font fnt2 = new Font("Serief", Font.BOLD, 12);
		infoLab5.setFont(fnt2);
		infoLab1.setFont(fnt1);
		
		ButtonGroup group = new ButtonGroup();
		group.add(boy);
		group.add(girl);
		
		String nation[] = {"中国","美国","日本","韩国","英国","法国","..."};
		this.jcbcountry = new JComboBox(nation);
		String province[] = {"北京市","湖北省","湖南省","浙江省","四川省","海南省","..."};
		this.jcbprovince = new JComboBox(province);
		
		regist.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
	
					String tname = nameText.getText();
					String tpass = new String(passText.getPassword());
					String tpass2 = new String(passText2.getPassword());
					ZhuCeCheck zhuce = new ZhuCeCheck(tname,tpass,tpass2);
					if(zhuce.validate()){
						String strself = self.getText();
						UpdateExcel updateExcel= new UpdateExcel();
						updateExcel.updateself(strself);
						infoLab5.setText("注册成功，请登录！");
					}else {
						infoLab5.setText("信息有误！");
					}

		
			}
		});
		
		
		
		boy.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String sex = "男";
				UpdateExcel updateExcel= new UpdateExcel();
				updateExcel.updateexcel(sex);
			}
			});
		girl.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String sex = "女";
				UpdateExcel updateExcel= new UpdateExcel();
				updateExcel.updateexcel(sex);
			}
			});
		jcbcountry.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String country = jcbcountry.getSelectedItem().toString();
				UpdateExcel updateExcel= new UpdateExcel();
				updateExcel.updatecountry(country);
			}
			});
		
		jcbprovince.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String province = jcbprovince.getSelectedItem().toString();
				UpdateExcel updateExcel= new UpdateExcel();
				updateExcel.updateprovince(province);
			}
			});
		
		
		jbdance.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String dance ="跳舞";
				UpdateExcel updateExcel= new UpdateExcel();
				updateExcel.updatedance(dance);
			}
			});
		jbmusic.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String music = "听音乐";
				UpdateExcel updateExcel= new UpdateExcel();
				updateExcel.updatedance(music);
			}
			});
		jbswim.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String dance ="游泳";
				UpdateExcel updateExcel= new UpdateExcel();
				updateExcel.updatedance(dance);
			}
			});
		jbread.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String dance = "阅读";
				UpdateExcel updateExcel= new UpdateExcel();
				updateExcel.updatedance(dance);
			}
			});
		
//		self.addFocusListener(new ActionListener(){
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
//				String strself = self.getText();
//				UpdateExcel updateExcel= new UpdateExcel();
//				updateExcel.updateself(strself);
//			}
//			});
		frame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent arg0){
			//	System.exit(1);
			}
		});
		
		frame.setLayout(null);
		
		infoLab1.setBounds(235, 20, 220, 30);   //大标题
		infoLabname.setBounds(50, 56, 200, 20);   //用户名：
		infoLabpass.setBounds(50, 80, 200, 20);  //密码：
		infoLabpass2.setBounds(50, 104, 200, 20);   //密码重复
		infoLabsex.setBounds(50, 128, 200, 20);
		infoLabcountry.setBounds(50, 152, 60, 20);
		infoLabprovince.setBounds(220, 152, 60, 20);
		infoLabhabit.setBounds(50, 176, 200, 20);
		infoLabself.setBounds(50, 200, 200, 20);
		
		infoLab5.setBounds(10, 530, 220, 30);      //注册成功!
		
		infoLab3.setBounds(345, 80, 1000, 20);
		infoLab2.setBounds(345, 56, 1000, 20);   //用户名必须为6-16位字母或数字
		
//		if (count1 ==1) {
			infoLab4.setBounds(345, 104, 1000, 20);
//		}
		infoLab4.setBounds(345, 104, 1000, 20);
		nameText.setBounds(115, 56, 200, 20);   //名字输入
		passText.setBounds(115, 80, 200, 20);  //密码输入
		passText2.setBounds(115, 104, 200, 20);
		
		boy.setBounds(120, 128, 100, 20);
		girl.setBounds(220, 128, 100, 20);
		
		jcbcountry.setBounds(128, 152, 80, 20);
		jcbprovince.setBounds(280, 152, 80, 20);
		
		jbdance.setBounds(120, 176, 60, 20);
		jbmusic.setBounds(180, 176, 80, 20);
		jbswim.setBounds(260, 176, 60, 20);
		jbread.setBounds(320, 176, 60, 20);
		
		self.setBounds(120, 210, 300, 300);
		
		regist.setBounds(200, 520, 160, 30);
		
		frame.add(infoLab1);             //大标题
		frame.add(infoLab2);        //用户名必须为6-16位字母或数字
		
		frame.add(infoLab3);           //密码不能为空
		frame.add(infoLab4);             //两次密码必须一致
		frame.add(infoLab5);               //注册成功！
		frame.add(infoLabcountry);        //国    家：
		frame.add(infoLabprovince);
		
		frame.add(jcbcountry);            //国家选项
		frame.add(jcbprovince);           //省份选项
		
		frame.add(infoLabhabit);        //兴趣爱好:
		
		frame.add(jbdance);      //跳舞
		frame.add(jbmusic);      //音乐
		frame.add(jbswim);      //游泳
		frame.add(jbread);      //阅读
		
		
		frame.add(infoLabname);             //姓名:
		frame.add(infoLabpass);           //密码:
		frame.add(infoLabpass2);          //密码重复:
		frame.add(infoLabprovince);      //省份:
		frame.add(infoLabsex);       //性别:
		frame.add(infoLabself);      //个人介绍:
		
		frame.add(nameText);         //名字框
		frame.add(passText);         //密码框
		frame.add(passText2);         //密码重复框
		frame.add(self);            //个人介绍框
		frame.add(regist);         //注册按钮
		frame.add(boy);
		frame.add(girl);
		
		frame.setBounds(500, 100, 600, 600);
		frame.setVisible(true);
		
	}
}
