package starbucks; //�α���ȭ��
//���� ���� ��
//flag������ ���(flag) ��� �� ó�� ���¸� ����ϰ� ó�� �帧�� �����ϱ� ���� ����
//falg���� ����ϴ�����
//flag ������ ����ġ ������ �̸� true, false �� ���߿� �ϳ��� �־���� 
//� ���ǿ� �����ϸ� flag�� ���� ���� �ݴ�� �ٲ���
//���߿� �װ��� ���ؼ� true�� false�� ���� ó���� �޶���

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import dao.CafeMemberDAO;
import vo.CafeMemberVO;

public class LoginPage2 extends JFrame implements ActionListener, KeyListener{

	JLabel jlbId,jlbPw,jlbLogo;
	JButton jbtnHome, jbtnRegister, jbtnLogin;
	JTextField jtfId;
	JPasswordField jtfPw; 
	ImageIcon imghome = new ImageIcon("src/starbucksImages/home.png");
	ImageIcon imgLogo = new ImageIcon("src/starbucksImages/logo.png");
	boolean flag = false;
	
	
	LoginPage2(){
			
		setLayout(null);
		
		/* ����ϴ� ����Ϳ� ���� ��ġ ������ ���� ���� ���� */

		Toolkit tool = Toolkit.getDefaultToolkit();  
		Dimension d = tool.getScreenSize();   //ȭ��ũ�⸦ ���� �޼ҵ�

		int x = (int) (d.getWidth() - 800) / 2; //d.getWidth()�� ȭ���� �ʺ�
		int y = (int) (d.getHeight() - 1000) / 2; //d.getHeight()�� ȭ���� ����
		
		//������ ����
		getContentPane().setBackground(new Color(30, 57, 50));
		
		//������Ʈ �ʱ�ȭ
		jlbLogo = new JLabel(imgLogo);
		jlbId = new JLabel("ID");
		jlbPw = new JLabel("PW");
		jtfId = new JTextField();
		jtfPw = new JPasswordField();
		jbtnHome = new JButton(imghome); 
		jbtnRegister = new JButton("ȸ������");
		jbtnLogin = new JButton("�α���");
		
		Font f = new Font("",Font.BOLD,40);
		Font f2 = new Font("",Font.BOLD,25);
				
		//ID��
		jlbId.setBounds(80,630,60,60);
		jlbId.setFont(f);
		jlbId.setForeground(Color.white);
		//PW��
		jlbPw.setBounds(60,770,80,80);
		jlbPw.setFont(f);
		jlbPw.setForeground(Color.white);
		//ID�ؽ�Ʈ�ʵ�
		jtfId.setBounds(180,600,300,120);	
		jtfId.setFont(f);
		//PW�ؽ�Ʈ�ʵ�
		jtfPw.setBounds(180,770,300,120);
		jtfPw.setFont(f);
		//Ȩ��ư		
		jbtnHome.setBounds(50,50,50,50);
//		jbtnHome.setBorder(new RoundedBorder(10)); 
		jbtnHome.setContentAreaFilled(false);
		jbtnHome.setBorderPainted(false);
		jbtnHome.setBorder(new LineBorder(Color.WHITE,2));
		jbtnHome.setForeground(Color.white);		
		//ȸ������ ��ư
		jbtnRegister.setBounds(540,600,200,120);
//		jbtnRegister.setBorder(new RoundedBorder(10));
		jbtnRegister.setContentAreaFilled(false);
		jbtnRegister.setBorder(new LineBorder(Color.WHITE,2));
		jbtnRegister.setForeground(Color.white);
		jbtnRegister.setFont(f2);	
		//�α��� ��ư
		jbtnLogin.setBounds(540,770,200,120);	
//		jbtnLogin.setBorder(new RoundedBorder(10));
		jbtnLogin.setContentAreaFilled(false);
		jbtnLogin.setBorder(new LineBorder(Color.WHITE,2));
		jbtnLogin.setFont(f2);
		jbtnLogin.setForeground(Color.white);
		
		//�ΰ�
		jlbLogo.setBounds(50,100,700,400);

		//�̺�Ʈó��
		jbtnHome.addActionListener(this);
		jbtnRegister.addActionListener(this);
		jbtnLogin.addActionListener(this);	
		//�̺�Ʈó��
		jtfId.addKeyListener(this);
		jtfPw.addKeyListener(this);
		
		//��ư Ŭ�� focus false
		jbtnHome.setFocusable(false);
		jbtnRegister.setFocusable(false);
	    jbtnLogin.setFocusable(false);
	    
	    //�޴�â �׵θ� ��ȭ
	    jtfId.setBorder(null);
        jtfPw.setBorder(null);
        //
        jtfId.setBorder(BorderFactory.createEmptyBorder(0 , 10 , 0 , 0));
        jtfPw.setBorder(BorderFactory.createEmptyBorder(0 , 10 , 0 , 0));
		
		//����
		add(jlbLogo);
		add(jlbId);
		add(jlbPw);
		add(jtfId);
		add(jtfPw);
		add(jbtnHome);
		add(jbtnRegister);
		add(jbtnLogin);
		
		setSize(800,1000);
		setLocation(x, y);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("ȯ���մϴ�");
		setVisible(true);
			
	}
	public static void main(String[] args) {
		LoginPage2 p2 = new LoginPage2();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource(); //e.getSource() - �̺�Ʈ �߻� �� �ش�Ǵ� ������Ʈ�� ������ �ҷ��� ***
		if(obj == jbtnHome) {
			new HomePage1();
			this.dispose();
		
		}else if(obj == jbtnRegister) {
			new RegisterPage3();
			this.dispose();
		
			
		}else if(obj == jbtnLogin) {//�α���Ŭ����
			String id = jtfId.getText(); //id�ؽ�Ʈ�ʵ忡�� �ؽ�Ʈ�޾ƿ�(���ڿ��� �������?)
			String pw = jtfPw.getText(); //id�ؽ�Ʈ�ʵ忡�� �ؽ�Ʈ�޾ƿ�
	//		System.out.println(id); //Ȯ��
	//		System.out.println(pw); //Ȯ��		
			
			CafeMemberDAO dao = new CafeMemberDAO(); //CafeMemberDAO ��ü ���� /db����
			CafeMemberVO vo = dao.login(id, pw); //��ü?vo�� dao�� login�޼ҵ带 �����ϰ� ��ȯ���� ���� ����
			
			
			if (vo == null) { //�����Ͱ�(id,pw)�� ���°��
				flag = false; //flag = false
			} else if (vo != null) { //�����Ͱ��� �ִ°��
				flag = true; //flag = true
			}
			
			if(flag == false) { //��, �����Ͱ��� ���°��
				JOptionPane.showConfirmDialog(this,
						"�������� �ʴ� ���̵��̰ų� ��й�ȣ�� Ʋ�Ƚ��ϴ�. �ٽ� Ȯ�����ּ���.",
						"�α���",JOptionPane.PLAIN_MESSAGE);
				jtfId.setText(""); //id�ؽ�Ʈ�ʵ忡 ���� ���� ���ֱ�
				jtfPw.setText(""); //pw�ؽ�Ʈ�ʵ忡 ���� ���� ���ֱ�
				}else { 
				JOptionPane.showConfirmDialog(this, "ȯ���մϴ�!",
						"�α���",JOptionPane.PLAIN_MESSAGE);
				//(�޴�â���� �̵�)new ��Ʃâ�޼���();
				this.dispose();
				new MenuBoardPage4(id);
			}
			
		
		}
		
	}
	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyReleased(KeyEvent e) {}
	
	@Override
	public void keyPressed(KeyEvent e) {
		
		if (e.getKeyCode() == KeyEvent.VK_ENTER) { //����Ű �Է½�
			
			String id = jtfId.getText(); // ������Ʈ�� �ԷµǾ� �ִ� ���ڿ� �������� /��, id�ؽ�Ʈ�ʵ忡 �ԷµǾ� �ִ� ���ڿ� ��������
			String pw = jtfPw.getText(); //cf. ������Ʈ.setText();�� ������Ʈ�� ���ڿ� ����ϱ�

			CafeMemberDAO dao = new CafeMemberDAO(); //dao��ü ���� /db����
			CafeMemberVO vo = dao.login(id, pw); //dao�� login�޼ҵ� �����ϰ� ��ȯ���� ���� vo�� ����
			
			if (vo == null) { //�����Ͱ��� ���� ���
				flag = false; 
			} else if (vo != null) { //�����Ͱ��� �ִ� ���
				flag = true;
			}
			
			if(flag == false) { //��, �����Ͱ��� ���� ��� ���� ����
				JOptionPane.showConfirmDialog(this,
						"�������� �ʴ� ���̵��̰ų� ��й�ȣ�� Ʋ�Ƚ��ϴ�. �ٽ� Ȯ�����ּ���.",
						"�α���",JOptionPane.PLAIN_MESSAGE);
				jtfId.setText("");
				jtfPw.setText("");
			}else { // �����Ͱ��� �ִ� ��� ���� ����
				JOptionPane.showConfirmDialog(this, "ȯ���մϴ�!",
						"�α���",JOptionPane.PLAIN_MESSAGE);
				//(�޴�â���� �̵�)new ��Ʃâ�޼���();
				this.dispose();
				new MenuBoardPage4(id);
			}
			
		}
		
	}
	
	
	
}
