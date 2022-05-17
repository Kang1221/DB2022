import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class INSERT_AGENCY extends JFrame implements ActionListener{
JTextField txt1, txt2, txt3, txt4, txt5;
	
	public INSERT_AGENCY ( ){
		setTitle("어쩔매물 DB Insert Agency Service");
		Color b=new Color(244,244,244);
		setBackground(b);
		setSize(700, 700);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Font f1 = new Font("아임크리수진",Font.PLAIN, 13);
		
		// 레이블 생성
		JLabel lbl1 = new JLabel("부동산 id ");
		lbl1.setBounds(220, 50, 200, 20);
		lbl1.setFont(f1);
		
		JLabel lbl2 = new JLabel("부동산 이름  ");
		lbl2.setBounds(220, 120, 200, 20); 
		lbl2.setFont(f1);
		
		JLabel lbl3 = new JLabel("부동산 전화번호  ");
		lbl3.setBounds(220, 190, 200, 20);
		lbl3.setFont(f1);
		
		JLabel lbl4 = new JLabel("지역 id");
		lbl4.setBounds(220, 260, 200, 20);
		lbl4.setFont(f1);
		
		JLabel lbl5 = new JLabel("부동산 상세 주소 ");
		lbl5.setBounds(220, 340, 200, 20);
		lbl5.setFont(f1);
		
		// 20자리 텍스트 필드 생성
		txt1 = new JTextField(5); 
		txt1.setBounds(220, 80, 100, 20);

		txt2 = new JTextField(20); 
		txt2.setBounds(220, 150, 100, 20);

		txt3 = new JTextField(20); 
		txt3.setBounds(220, 220, 100, 20);
		
		txt4 = new JTextField(20); 
		txt4.setBounds(220, 290, 100, 20);

		txt5 = new JTextField(20); 
		txt5.setBounds(220, 360, 250, 50);



		getContentPane().add(lbl1);		getContentPane().add(txt1);
		getContentPane().add(lbl2);		getContentPane().add(txt2);
		getContentPane().add(lbl3);		getContentPane().add(txt3);
		getContentPane().add(lbl4);		getContentPane().add(txt4);
		getContentPane().add(lbl5);		getContentPane().add(txt5);
		
		RoundedButton btn = new RoundedButton("등록");
		btn.setBounds(400, 450, 70, 30);
		btn.setFont(f1);
		getContentPane().add(btn);
		
		btn.addActionListener(this);
		
		setVisible(true);
	}
	public static void main(String args[]){
		new INSERT_AGENCY();
    }
	 @Override
		public void actionPerformed(ActionEvent e) {
	        Connection conn = null;
	        try{
	            String url = "jdbc:mysql://localhost/DB2022Team11";
	 
	        	//Database user, password
	        	String  user = "testuser";
	        	String password ="1234";

	            conn = DriverManager.getConnection(url, user, password);
	            System.out.println("Insert_AREA Successfully Connection!");	//연결 확인 메세지
			
	            String id_num = txt1.getText();
	            String id = "Aid00" + id_num;
	            String name = txt2.getText();
	            String number = txt3.getText();
	            String area_id = txt4.getText();
	            String address = txt5.getText();
			
	            PreparedStatement pStmt = conn.prepareStatement(
	            		"insert into DB2022_AGENCY values(?,?,?,?,?)");
	            pStmt.setString(1, id);
	          	pStmt.setString(2, name);
	           	pStmt.setString(3, address);
	          	pStmt.setString(4, number);
	           	pStmt.setString(5, area_id);
	           	pStmt.executeUpdate();;

	        }
	        catch (SQLException sqle) {
	        	System.out.println("SQLException : " + sqle);
	        }
	
    }
}
