package test;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Test extends JFrame{

	JTable jtbList;
	JScrollPane jsplist;
	
	Test(){
		
		String header [] = {"name", "age", "adress","number"};
		String contents [][] = {
				{"tony","30","seoul","010"},
				{"mary","29","seoul","010"},
				{"mary","29","seoul","010"},
				{"mary","29","seoul","010"},
				{"mary","29","seoul","010"},
				{"mary","29","seoul","010"},
				{"mary","29","seoul","010"}
		};
		
		jtbList = new JTable(contents, header);
		jsplist = new JScrollPane(jtbList);
		jtbList.setFillsViewportHeight(true);
		add(jsplist);
	//	add(jtbList); => 이상하게 구현됨..
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(500,100, 500, 500);
		setVisible(true);
	}
	public static void main(String[] args) {
		Test t = new Test();
	}
}
