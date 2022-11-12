package starbucks; //ȸ������ ȭ��

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import dao.CafeMemberDAO;
import vo.CafeMemberVO;

public class RegisterPage3 extends JFrame implements ActionListener, KeyListener {

	JLabel jlbId, jlbPw, jlbName;
	JTextField jtfId, jtfName;
	JPasswordField jtfPw;
	JButton jbtnCheck, jbtnRegister, jbtnCancle;
	boolean flag;
	String gid;

	RegisterPage3() {

		/* ����ϴ� ����Ϳ� ���� ��ġ ������ ���� ���� ���� */

		Toolkit tool = Toolkit.getDefaultToolkit(); // 
		Dimension d = tool.getScreenSize(); //ȭ���� ũ�� ���� �޼ҵ� 

		int x = (int) (d.getWidth() - 800) / 2;
		int y = (int) (d.getHeight() - 1000) / 2;

		//��ġ������ ���X
		setLayout(null);
		//����
		getContentPane().setBackground(new Color(30, 57, 50));

		//������Ʈ �ʱ�ȭ
		jlbId = new JLabel("ID(��ȣ)");
		jlbPw = new JLabel("PW");
		jlbName = new JLabel("�̸�");
		Font f1 = new Font("", Font.BOLD, 25); // ID�� �۾�ũ��
		Font f2 = new Font("", Font.BOLD, 30); // �׿� �� & �α��� �� ȸ������ ��ư �۾�ũ��
		Font f3 = new Font("", Font.BOLD, 20); // �ߺ�Ȯ�� ��ưũ��

		// ���
		jlbId.setBounds(30, 130, 100, 50);
		jlbId.setForeground(Color.white);
		jlbId.setFont(f1);
		jlbPw.setBounds(50, 330, 70, 50);
		jlbPw.setForeground(Color.white);
		jlbPw.setFont(f2);
		jlbName.setBounds(50, 530, 70, 50);
		jlbName.setForeground(Color.white);
		jlbName.setFont(f2);

		add(jlbId);
		add(jlbPw);
		add(jlbName);

		// �ؽ�Ʈ�ʵ�
		jtfId = new JTextField();
		jtfPw = new JPasswordField();
		jtfName = new JTextField();

		jtfId.setBounds(150, 100, 350, 100);
		jtfId.setFont(f2);
		jtfId.addKeyListener(this); 
		jtfPw.setBounds(150, 300, 350, 100);
		jtfPw.setFont(f2);
		jtfPw.addKeyListener(this);
		jtfName.setBounds(150, 500, 350, 100);
		jtfName.setFont(f2);
		jtfName.addKeyListener(this);

		add(jtfId);
		add(jtfName);
		add(jtfPw);

		// ��ư
		jbtnCheck = new JButton("�ߺ�Ȯ��");
		jbtnRegister = new JButton("ȸ������");
		jbtnCancle = new JButton("���");

		jbtnCheck.setBounds(580, 100, 150, 100);
//		jbtnCheck.setBorder(new RoundedBorder(10));
		jbtnCheck.setContentAreaFilled(false);
		jbtnCheck.setBorder(new LineBorder(Color.WHITE, 2));
		jbtnCheck.setForeground(Color.white);
		jbtnCheck.setFont(f3);

		jbtnRegister.setBounds(80, 740, 250, 150);
//		jbtnRegister.setBorder(new RoundedBorder(10));
		jbtnRegister.setContentAreaFilled(false);
		jbtnRegister.setBorder(new LineBorder(Color.WHITE, 2));
		jbtnRegister.setForeground(Color.white);
		jbtnRegister.setFont(f2);

		jbtnCancle.setBounds(450, 740, 250, 150);
//		jbtnCancle.setBorder(new RoundedBorder(10));
		jbtnCancle.setContentAreaFilled(false);
		jbtnCancle.setBorder(new LineBorder(Color.WHITE, 2));
		jbtnCancle.setForeground(Color.white);
		jbtnCancle.setFont(f2);

		// ��ư Ŭ�� focus false
		jbtnRegister.setFocusable(false);
		jbtnCancle.setFocusable(false);
		jbtnCheck.setFocusable(false);

		// �޴�â �׵θ� �������
		jtfId.setBorder(null);
		jtfPw.setBorder(null);
		jtfName.setBorder(null);

		//�ؽ�Ʈ�ʵ� ���ʿ� ����
		jtfId.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
		jtfPw.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
		jtfName.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
		
		add(jbtnCheck);
		add(jbtnRegister);
		add(jbtnCancle);

		jbtnCheck.addActionListener(this);
		jbtnRegister.addActionListener(this);
		jbtnCancle.addActionListener(this);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800, 1000);
		setLocation(x, y);
		setTitle("ȸ������");
		setVisible(true);

	}

	public static void main(String[] args) {
		RegisterPage3 p3 = new RegisterPage3();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource(); 

		// �ߺ�Ȯ�ι�ư
		
		if (obj == jbtnCheck) { 

			overlap(); //overlap�޼ҵ� ����(�Ʒ��� ����)

			
			// ȸ�����Թ�ư

		} else if (obj == jbtnRegister) {

			register(); //register�޼ҵ� ����(�Ʒ��� ����)

		} else if (obj == jbtnCancle) {
			this.dispose();
			new LoginPage2();
		}

	} // ActionListener end

	
	
	@Override
	public void keyPressed(KeyEvent e) {

		
		//��!!! ����Ű ������ 2�������ݾ� 
		//�ߺ�Ȯ�ι�ư�� �����°�
		//ȸ�����Թ�ư�� �����°�
		
		
		// �ߺ�Ȯ�� ����
		
	   //***e.getSource() == jtfId �� ���ִ°�..�� => e.getSource�޼ҵ�� �̺�Ʈ�߻��� �ش� ������Ʈ ���� �ҷ����µ� �װ� jtfId ?
		if (e.getSource() == jtfId
				&& e.getKeyCode() == KeyEvent.VK_ENTER) { //����Ű�� ���� & jtfId �̸�
			
			overlap(); //overlap�޼ҵ� ����
	
			
			// ȸ������
						
		} else if ((e.getSource() == jtfPw || e.getSource() == jtfName) 
				&& e.getKeyCode() == KeyEvent.VK_ENTER) { 
			
			register(); // register�޼ҵ� ����(���� �ߺ�Ȯ�� �ϰԲ�)
		}
	}

	//�� �ǹ̴� �˰ڴµ� ����? ������ �𸣰ڴ� �����־���ϴ��� �Ʒ��� �־�� �ϴ���........***
	//ȸ������
	public void register() {
		//ȸ�������ϱ� ��, �ߺ�Ȯ�� overlap�޼ҵ� ������ => �̶� gid�� ����� ���� �Է��� id��
		if (gid != null) {  //������ ���� ���ٸ� ���� ����

			String id = jtfId.getText(); 

			if (flag == false && gid.equals(id) && jtfPw.getText().length() != 0 && jtfName.getText().length() != 0) {
				String pw = jtfPw.getText();
				String name = jtfName.getText();

				CafeMemberDAO dao = new CafeMemberDAO(); //dao��ü����
				CafeMemberVO vo = new CafeMemberVO(gid, name, pw); //vo��ü����
				dao.insertOne(vo);//dao�� inserOne�޼ҵ� ���� /insertOne(CafeMemberVO vo)/CafeMemberVO(String id, String name, String pw)
				JOptionPane.showMessageDialog(this, "������ �����մϴ�!", "ȸ�����Ե��", JOptionPane.PLAIN_MESSAGE);
				this.dispose();
				new LoginPage2();
		
			} else if (jtfPw.getText().length() == 0 || jtfName.getText().length() == 0) {
				JOptionPane.showMessageDialog(this, "��ĭ�� Ȯ�����ּ���", "�ߺ�Ȯ��", JOptionPane.PLAIN_MESSAGE);
			} else if (!gid.equals(id)) {
				JOptionPane.showMessageDialog(this, "�ߺ�Ȯ���� �������ּ���", "�ߺ�Ȯ��", JOptionPane.PLAIN_MESSAGE);

			}
		} else {//������ ���� �̹� db�� �ִٸ�(?)
			JOptionPane.showMessageDialog(this, "�ߺ�Ȯ���� �������ּ���", "�ߺ�Ȯ��", JOptionPane.PLAIN_MESSAGE);
		}
	} 

	
	//�ߺ�Ȯ��
	public void overlap() {
		String id = jtfId.getText(); //id�ؽ�Ʈ�ʵ忡�� ���ڿ� ������ ����id�� ����

		CafeMemberDAO dao = new CafeMemberDAO(); //dao��ü ���� / db����
		CafeMemberVO vo = dao.selectOne(id); //dao�� selectOne�޼ҵ� �����Ͽ� ��ȯ�Ǵ� ���� vo�� ����
		System.out.println(id+"�� �Է��Ͽ����ϴ�."); 

		
		try {//id�� ���ڷ� �Է�������

			long i = Long.parseLong(id); //���ڿ��� long���� ��ȯ => try/catch������(���ڷ� ���������ݾ�)

			if (vo == null) { //db�� �����Ͱ��� ������� 
				flag = false; //flag = false
			} else if (vo != null) { //�����Ͱ��� �������
				flag = true; //flag = true
			}

			if (id.length() == 0 || id.length() >= 12) { //idâ�� ��ĭ�̰ų� 12�ڸ� �̻��ϰ�� 
				JOptionPane.showMessageDialog(this, "id �Է�ĭ�� Ȯ�����ּ���.", "Ȯ��", JOptionPane.WARNING_MESSAGE);
				jtfId.setText("");
				jtfId.requestFocus();
			} else if (flag == false) {//�����Ͱ��� �������
				gid = id; //�Է���id�� gid�� ����
				JOptionPane.showMessageDialog(this, "��� �� �� �ִ� ���̵��Դϴ�.", "Ȯ��", JOptionPane.PLAIN_MESSAGE);
			} else {//�����Ͱ��� �������
				JOptionPane.showMessageDialog(this, "�̹� �����ϴ� ���̵��Դϴ�.", "Ȯ��", JOptionPane.WARNING_MESSAGE);
				jtfId.setText("");
				jtfId.requestFocus();
			}

			//����ó��- id�� ���ڷ� �Է¹޾�����
		} catch (NumberFormatException e1) {
			JOptionPane.showMessageDialog(this, "id �Է������� �ùٸ��� �ʽ��ϴ�.", "Ȯ��", JOptionPane.WARNING_MESSAGE);
			jtfId.setText("");
			jtfId.requestFocus();
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}
}
