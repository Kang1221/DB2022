import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class INSERT_OWNER extends JFrame implements ActionListener{
	JTextField txt1, txt2, txt3;
	
	public INSERT_OWNER ( ){
		setTitle("어쩔매물 DB Insert Owner Service");
		Color b=new Color(244,244,244);
		setBackground(b);
		setSize(700, 700);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Font f1 = new Font("아임크리수진",Font.PLAIN, 13);
		
		// 레이블 생성
		JLabel lbl1 = new JLabel("id ");
		lbl1.setBounds(220, 50, 200, 20);
		lbl1.setFont(f1);
		
		JLabel lbl2 = new JLabel("집주인 이름  ");
		lbl2.setBounds(220, 120, 200, 20); 
		lbl2.setFont(f1);
		JLabel lbl3 = new JLabel("집주인 전화번호  ");
		lbl3.setBounds(220, 190, 200, 20);
		lbl3.setFont(f1);
		
		// 20자리 텍스트 필드 생성
		txt1 = new JTextField(5); 
		txt1.setBounds(220, 80, 100, 20);

		txt2 = new JTextField(20); 
		txt2.setBounds(220, 150, 100, 20);

		txt3 = new JTextField(20); 
		txt3.setBounds(220, 220, 200, 20);


		getContentPane().add(lbl1);		getContentPane().add(txt1);
		getContentPane().add(lbl2);		getContentPane().add(txt2);
		getContentPane().add(lbl3);		getContentPane().add(txt3);
		
		
		RoundedButton btn = new RoundedButton("등록");
		btn.setBounds(350, 270, 70, 30);
		btn.setFont(f1);
		getContentPane().add(btn);
		
		btn.addActionListener(this);
		
		setVisible(true);
	}
	public static void main(String args[]){
		new INSERT_OWNER();
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
	            String id = "Oid00" + id_num;
	            String name = txt2.getText();
	            String number = txt3.getText();
			
	            PreparedStatement pStmt = conn.prepareStatement(
	            		"insert into DB2022_OWNER values(?,?,?)");
	            pStmt.setString(1, id);
	          	pStmt.setString(2, name);
	           	pStmt.setString(3, number);
	           	pStmt.executeUpdate();

	        }
	        catch (SQLException sqle) {
	        	System.out.println("SQLException : " + sqle);
	        }
		}

}
