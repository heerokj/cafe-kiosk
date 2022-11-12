package starbucks; //회원가입 화면

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

		/* 사용하는 모니터에 따른 위치 조절을 위한 변수 생성 */

		Toolkit tool = Toolkit.getDefaultToolkit(); // 
		Dimension d = tool.getScreenSize(); //화면의 크기 얻어내는 메소드 

		int x = (int) (d.getWidth() - 800) / 2;
		int y = (int) (d.getHeight() - 1000) / 2;

		//배치관리자 사용X
		setLayout(null);
		//배경색
		getContentPane().setBackground(new Color(30, 57, 50));

		//컨포넌트 초기화
		jlbId = new JLabel("ID(번호)");
		jlbPw = new JLabel("PW");
		jlbName = new JLabel("이름");
		Font f1 = new Font("", Font.BOLD, 25); // ID라벨 글씨크시
		Font f2 = new Font("", Font.BOLD, 30); // 그외 라벨 & 로그인 및 회원가입 버튼 글씨크기
		Font f3 = new Font("", Font.BOLD, 20); // 중복확인 버튼크기

		// 라밸
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

		// 텍스트필드
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

		// 버튼
		jbtnCheck = new JButton("중복확인");
		jbtnRegister = new JButton("회원가입");
		jbtnCancle = new JButton("취소");

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

		// 버튼 클릭 focus false
		jbtnRegister.setFocusable(false);
		jbtnCancle.setFocusable(false);
		jbtnCheck.setFocusable(false);

		// 메뉴창 테두리 깔끔해짐
		jtfId.setBorder(null);
		jtfPw.setBorder(null);
		jtfName.setBorder(null);

		//텍스트필드 안쪽에 여백
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
		setTitle("회원가입");
		setVisible(true);

	}

	public static void main(String[] args) {
		RegisterPage3 p3 = new RegisterPage3();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource(); 

		// 중복확인버튼
		
		if (obj == jbtnCheck) { 

			overlap(); //overlap메소드 실행(아래에 있음)

			
			// 회원가입버튼

		} else if (obj == jbtnRegister) {

			register(); //register메소드 실행(아래에 있음)

		} else if (obj == jbtnCancle) {
			this.dispose();
			new LoginPage2();
		}

	} // ActionListener end

	
	
	@Override
	public void keyPressed(KeyEvent e) {

		
		//아!!! 엔터키 누를때 2가지있잖아 
		//중복확인버튼을 누르는거
		//회원가입버튼을 누르는거
		
		
		// 중복확인 구현
		
	   //***e.getSource() == jtfId 는 왜있는거..ㅠ => e.getSource메소드는 이벤트발생시 해당 컨포넌트 변수 불러오는데 그게 jtfId ?
		if (e.getSource() == jtfId
				&& e.getKeyCode() == KeyEvent.VK_ENTER) { //엔터키를 누름 & jtfId 이면
			
			overlap(); //overlap메소드 실행
	
			
			// 회원가입
						
		} else if ((e.getSource() == jtfPw || e.getSource() == jtfName) 
				&& e.getKeyCode() == KeyEvent.VK_ENTER) { 
			
			register(); // register메소드 실행(먼저 중복확인 하게끔)
		}
	}

	//하 의미는 알겠는데 로직? 순서를 모르겠다 위에넣어야하는지 아래에 넣어야 하는지........***
	//회원가입
	public void register() {
		//회원가입하기 전, 중복확인 overlap메소드 실행함 => 이때 gid에 저장된 값은 입력한 id임
		if (gid != null) {  //데이터 값이 없다면 이하 실행

			String id = jtfId.getText(); 

			if (flag == false && gid.equals(id) && jtfPw.getText().length() != 0 && jtfName.getText().length() != 0) {
				String pw = jtfPw.getText();
				String name = jtfName.getText();

				CafeMemberDAO dao = new CafeMemberDAO(); //dao객체생성
				CafeMemberVO vo = new CafeMemberVO(gid, name, pw); //vo객체생성
				dao.insertOne(vo);//dao의 inserOne메소드 실행 /insertOne(CafeMemberVO vo)/CafeMemberVO(String id, String name, String pw)
				JOptionPane.showMessageDialog(this, "가입을 축하합니다!", "회원가입등록", JOptionPane.PLAIN_MESSAGE);
				this.dispose();
				new LoginPage2();
		
			} else if (jtfPw.getText().length() == 0 || jtfName.getText().length() == 0) {
				JOptionPane.showMessageDialog(this, "빈칸을 확인해주세요", "중복확인", JOptionPane.PLAIN_MESSAGE);
			} else if (!gid.equals(id)) {
				JOptionPane.showMessageDialog(this, "중복확인을 실행해주세요", "중복확인", JOptionPane.PLAIN_MESSAGE);

			}
		} else {//데이터 값이 이미 db에 있다면(?)
			JOptionPane.showMessageDialog(this, "중복확인을 실행해주세요", "중복확인", JOptionPane.PLAIN_MESSAGE);
		}
	} 

	
	//중복확인
	public void overlap() {
		String id = jtfId.getText(); //id텍스트필드에서 문자열 가져와 변수id에 저장

		CafeMemberDAO dao = new CafeMemberDAO(); //dao객체 생성 / db연결
		CafeMemberVO vo = dao.selectOne(id); //dao의 selectOne메소드 실행하여 반환되는 값을 vo에 저장
		System.out.println(id+"를 입력하였습니다."); 

		
		try {//id를 숫자로 입력했을때

			long i = Long.parseLong(id); //문자열을 long으로 변환 => try/catch해주자(문자로 받을수있잖아)

			if (vo == null) { //db에 데이터값이 없을경우 
				flag = false; //flag = false
			} else if (vo != null) { //데이터값이 있을경우
				flag = true; //flag = true
			}

			if (id.length() == 0 || id.length() >= 12) { //id창에 빈칸이거나 12자리 이상일경우 
				JOptionPane.showMessageDialog(this, "id 입력칸을 확인해주세요.", "확인", JOptionPane.WARNING_MESSAGE);
				jtfId.setText("");
				jtfId.requestFocus();
			} else if (flag == false) {//데이터값이 없을경우
				gid = id; //입력한id가 gid에 저장
				JOptionPane.showMessageDialog(this, "사용 할 수 있는 아이디입니다.", "확인", JOptionPane.PLAIN_MESSAGE);
			} else {//데이터값이 있을경우
				JOptionPane.showMessageDialog(this, "이미 존재하는 아이디입니다.", "확인", JOptionPane.WARNING_MESSAGE);
				jtfId.setText("");
				jtfId.requestFocus();
			}

			//예외처리- id를 문자로 입력받았을때
		} catch (NumberFormatException e1) {
			JOptionPane.showMessageDialog(this, "id 입력형식이 올바르지 않습니다.", "확인", JOptionPane.WARNING_MESSAGE);
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
