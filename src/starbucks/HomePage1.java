package starbucks; //홈 화면

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

public class HomePage1 extends JFrame implements ActionListener {

	JButton jbtnManagerLogin, jbtnMember, jbtnNonMember;
	JLabel jlbLogo;
	ImageIcon imgLogo = new ImageIcon("src/starbucksImages/logo.png");

	public HomePage1() {

		// 배치관리자 설정X
		setLayout(null);

		/* 사용하는 모니터에 따른 위치 조절을 위한 변수 생성 */

		Toolkit tool = Toolkit.getDefaultToolkit();   
		Dimension d = tool.getScreenSize();           //화면크기를 얻어내는 메소드
 
		int x = (int) (d.getWidth() - 800) / 2;  //d.getWidth()는 화면크기의 넓이
		int y = (int) (d.getHeight() - 1000) / 2; //d.getHeight()는 화면크기의 높이  

		//프레임 배경색
		getContentPane().setBackground(new Color(30, 57, 50));

		// 컨포넌트 초기화
		jbtnManagerLogin = new JButton("관리자로그인");
		jbtnMember = new JButton("회원주문");
		jbtnNonMember = new JButton("비회원주문");
		jlbLogo = new JLabel(imgLogo);

		Font f = new Font("", Font.BOLD, 15);
		Font f2 = new Font("", Font.BOLD, 40); 

		
		// 버튼 위치, 크기, 글꼴세부사항 지정
		// 메니저로그인 버튼
		jbtnManagerLogin.setBounds(600, 50, 150, 50);
//		jbtnManagerLogin.setBorder(new RoundedBorder(10));
		jbtnManagerLogin.setContentAreaFilled(false); 
		jbtnManagerLogin.setBorder(new LineBorder(Color.WHITE, 2)); //버튼테두리 색 변경
		jbtnManagerLogin.setForeground(Color.white); //글자색 변경 //주체.setForeground(Color c);
		jbtnManagerLogin.setFont(f);                  
		jbtnManagerLogin.setFocusable(false); //setFocusable(boolean focusable) /마우스올릴때 네모난 표시 없어짐 => 포커스 가능 상태를 지정된 값으로 

		// 회원주문 버튼
		jbtnMember.setBounds(70, 700, 300, 200);
//		jbtnMember.setBorder(new RoundedBorder(10));
		jbtnMember.setContentAreaFilled(false);
		jbtnMember.setBorder(new LineBorder(Color.WHITE, 2));
		jbtnMember.setForeground(Color.white);
		jbtnMember.setFont(f2);
		jbtnMember.setFocusable(false);

		// 비회원주문 버튼
		jbtnNonMember.setBounds(420, 700, 300, 200);
//		jbtnNonMember.setBorder(new RoundedBorder(10));
		jbtnNonMember.setContentAreaFilled(false);
		jbtnNonMember.setBorder(new LineBorder(Color.WHITE, 2));
		jbtnNonMember.setForeground(Color.white);
		jbtnNonMember.setFont(f2);
		jbtnNonMember.setFocusable(false);

		// 로고
		jlbLogo.setBounds(50, 150, 700, 400);
		
		//이벤트소스인 버튼에 이벤트처리할 이벤트 리스너 객체 등록
		jbtnManagerLogin.addActionListener(this); 
		jbtnMember.addActionListener(this);
		jbtnNonMember.addActionListener(this);

		// 부착
		add(jlbLogo);
		add(jbtnManagerLogin);
		add(jbtnMember);
		add(jbtnNonMember);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800, 1000);
		setLocation(x, y); 
		setVisible(true);
		setTitle("환영합니다");
	}

	public static void main(String[] args) {
		HomePage1 p1 = new HomePage1(); 
	}

	//버튼이 클릭되면 호출되는 actionPerformed()메서드 오버라이딩
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource(); //obj객체 생성 후 클릭한 버튼의 객체를 전달 
		if (obj == jbtnManagerLogin) {//메니저로그인 버튼 클릭했을때
			this.dispose(); //현재프레임은 종료
			new OwnerLoginPage6();//6페이지로 이동
		} else if (obj == jbtnMember) { //jbtnMember(회원주문버튼) 클릭했을때 
			this.dispose(); //현재프레임은 종료
			new LoginPage2();//2페이지로 이동
		} else if (obj == jbtnNonMember) { //jbtnNonMember(비회원주문버튼)클릭했을때			
			this.dispose();//현재프레임은 종료
			new MenuBoardPage4(null);//id를 null값으로 받으며 4페이지로 이동
		}
	}
}
