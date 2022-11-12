package popup;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CouponUse extends JFrame implements ActionListener{
	JPanel jpn;
	JButton jbtnYes, jbtnNo;
	JLabel jlbText;
	
	CouponUse() {
		jpn = new JPanel();
		jbtnYes = new JButton("예");
		jbtnNo = new JButton("아니오");
		jlbText = new JLabel("정말 사용하시겠습니까?",JLabel.CENTER);
		jlbText.setOpaque(true);
		jlbText.setBackground(new Color(219, 230, 242));
		
		jpn.setLayout(null);
		jpn.setBackground(Color.white);
		
		jbtnYes.setBounds(50,120,80,50);
		jbtnNo.setBounds(160,120,80,50);
		jlbText.setBounds(50,50,190,50);
		
		//borderlayout 초기화
//		jbtnYes.setBorder(new RoundedBorder(10));
//		jbtnNo.setBorder(new RoundedBorder(10));
//		jlbText.setBorder(new RoundedBorder(10));
		
		jpn.add(jbtnYes);
		jpn.add(jbtnNo);
		jpn.add(jlbText);
		
		jbtnYes.addActionListener(this);
		jbtnNo.addActionListener(this);
		
		add(jpn);
		
		// 화면 가운데로 오기 위해 
		Toolkit tool = Toolkit.getDefaultToolkit();
		Dimension d = tool.getScreenSize();
				
		double width = d.getWidth();
		double height = d.getHeight();
				
		int x = (int)(width/2 - 300/2);
		int y = (int)(height/2 - 240/2);
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setBounds(x,y,300,240);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new CouponUse();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == jbtnYes) {
			dispose();
			
			
		} else if(obj == jbtnNo) {
			dispose();
		}
		
	}
}
