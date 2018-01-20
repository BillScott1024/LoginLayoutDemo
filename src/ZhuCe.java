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
//	private JFrame frame = new JFrame("��ӭע��");
//	public ZhuCe() {
//		// TODO Auto-generated constructor stub
//
//	JDialog dialog = new JDialog();
//    dialog.setBounds(500, 100, 800, 600);
//    dialog.setVisible(true);
//	}
	
	/* 
	 *      �û�ע�᡾����⡿
	 *   
	 *   �û�����     _____       �û�������Ϊ6-16λ��ĸ�����֣�|| ��ʾ1
	 *   ��   �룺      _____       ���벻��Ϊ��             ||��ʾ2
	 *   �����ظ��� ______      �����������һ��    ||��ʾ3
	 *   �Ա� ����ѡ��   ����ѡ��
	 *   ���ң� ��������     ʡ�ݣ���������
	 *   ��Ȥ���ã�����ѡ��  ����ѡ��  ����ѡ��  ����ѡ��
	 *   ���˼�飺    ���ı���
	 *   
	 *   
	 *   ע�᣺����ť��
	 * */
	
	private JFrame frame = new JFrame("��ӭע��");     //��������
	
	private JLabel infoLab1 = new JLabel("�û�ע��");   //����
	
	private JLabel infoLab2 = new JLabel("�û�������Ϊ6-16λ��ĸ������");    //��ʾһ
	private JLabel infoLab3 = new JLabel("���벻��Ϊ��");    //��ʾ��
	private JLabel infoLab4 = new JLabel("�����������һ��");    //��ʾ��
	private JLabel infoLab5 = new JLabel("ע��ɹ���");    //��ʾ��

	private JLabel infoLabname = new JLabel("�û�����");
	private JLabel infoLabpass = new JLabel("��    �룺");
	private JLabel infoLabpass2 = new JLabel("�����ظ���");
	private JLabel infoLabsex = new JLabel("��    ��");
	private JLabel infoLabcountry = new JLabel("��    �ң�");
	private JLabel infoLabprovince = new JLabel("ʡ    �ݣ�");
	private JLabel infoLabhabit = new JLabel("��Ȥ����:");
	private JLabel infoLabself = new JLabel("���˼��:");
	
	
	private JTextField nameText = new JTextField();
	private JPasswordField passText = new JPasswordField();
	private JPasswordField passText2 = new JPasswordField();
	private JTextArea self = new JTextArea();
	
	private String boypng = "boy.png";
	private String girlpng = "girl.png";
	private JRadioButton boy = new JRadioButton("��",new ImageIcon(boypng),true);     //��ѡ
	private JRadioButton girl = new JRadioButton("Ů",new ImageIcon(girlpng),false);
	
//	private JRadioButton boy = new JRadioButton("��");     //��ѡ
//	private JRadioButton girl = new JRadioButton("Ů");
//	
	private JComboBox jcbcountry = null;            //������
	private JComboBox jcbprovince = null;
	
	private JCheckBox jbdance = new JCheckBox("����");      //��ѡ
	private JCheckBox jbmusic = new JCheckBox("������");
	private JCheckBox jbswim = new JCheckBox("��Ӿ");
	private JCheckBox jbread = new JCheckBox("�Ķ�");
	
	private JButton regist = new JButton("ע           ��");
	
	int count1  = 0;
	public ZhuCe(){
		
		Font fnt1 = new Font("Serief", Font.BOLD, 24);
		Font fnt2 = new Font("Serief", Font.BOLD, 12);
		infoLab5.setFont(fnt2);
		infoLab1.setFont(fnt1);
		
		ButtonGroup group = new ButtonGroup();
		group.add(boy);
		group.add(girl);
		
		String nation[] = {"�й�","����","�ձ�","����","Ӣ��","����","..."};
		this.jcbcountry = new JComboBox(nation);
		String province[] = {"������","����ʡ","����ʡ","�㽭ʡ","�Ĵ�ʡ","����ʡ","..."};
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
						infoLab5.setText("ע��ɹ������¼��");
					}else {
						infoLab5.setText("��Ϣ����");
					}

		
			}
		});
		
		
		
		boy.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String sex = "��";
				UpdateExcel updateExcel= new UpdateExcel();
				updateExcel.updateexcel(sex);
			}
			});
		girl.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String sex = "Ů";
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
				String dance ="����";
				UpdateExcel updateExcel= new UpdateExcel();
				updateExcel.updatedance(dance);
			}
			});
		jbmusic.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String music = "������";
				UpdateExcel updateExcel= new UpdateExcel();
				updateExcel.updatedance(music);
			}
			});
		jbswim.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String dance ="��Ӿ";
				UpdateExcel updateExcel= new UpdateExcel();
				updateExcel.updatedance(dance);
			}
			});
		jbread.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String dance = "�Ķ�";
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
		
		infoLab1.setBounds(235, 20, 220, 30);   //�����
		infoLabname.setBounds(50, 56, 200, 20);   //�û�����
		infoLabpass.setBounds(50, 80, 200, 20);  //���룺
		infoLabpass2.setBounds(50, 104, 200, 20);   //�����ظ�
		infoLabsex.setBounds(50, 128, 200, 20);
		infoLabcountry.setBounds(50, 152, 60, 20);
		infoLabprovince.setBounds(220, 152, 60, 20);
		infoLabhabit.setBounds(50, 176, 200, 20);
		infoLabself.setBounds(50, 200, 200, 20);
		
		infoLab5.setBounds(10, 530, 220, 30);      //ע��ɹ�!
		
		infoLab3.setBounds(345, 80, 1000, 20);
		infoLab2.setBounds(345, 56, 1000, 20);   //�û�������Ϊ6-16λ��ĸ������
		
//		if (count1 ==1) {
			infoLab4.setBounds(345, 104, 1000, 20);
//		}
		infoLab4.setBounds(345, 104, 1000, 20);
		nameText.setBounds(115, 56, 200, 20);   //��������
		passText.setBounds(115, 80, 200, 20);  //��������
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
		
		frame.add(infoLab1);             //�����
		frame.add(infoLab2);        //�û�������Ϊ6-16λ��ĸ������
		
		frame.add(infoLab3);           //���벻��Ϊ��
		frame.add(infoLab4);             //�����������һ��
		frame.add(infoLab5);               //ע��ɹ���
		frame.add(infoLabcountry);        //��    �ң�
		frame.add(infoLabprovince);
		
		frame.add(jcbcountry);            //����ѡ��
		frame.add(jcbprovince);           //ʡ��ѡ��
		
		frame.add(infoLabhabit);        //��Ȥ����:
		
		frame.add(jbdance);      //����
		frame.add(jbmusic);      //����
		frame.add(jbswim);      //��Ӿ
		frame.add(jbread);      //�Ķ�
		
		
		frame.add(infoLabname);             //����:
		frame.add(infoLabpass);           //����:
		frame.add(infoLabpass2);          //�����ظ�:
		frame.add(infoLabprovince);      //ʡ��:
		frame.add(infoLabsex);       //�Ա�:
		frame.add(infoLabself);      //���˽���:
		
		frame.add(nameText);         //���ֿ�
		frame.add(passText);         //�����
		frame.add(passText2);         //�����ظ���
		frame.add(self);            //���˽��ܿ�
		frame.add(regist);         //ע�ᰴť
		frame.add(boy);
		frame.add(girl);
		
		frame.setBounds(500, 100, 600, 600);
		frame.setVisible(true);
		
	}
}
