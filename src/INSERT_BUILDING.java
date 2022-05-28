import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class INSERT_BUILDING extends JFrame implements ActionListener{
	JTextField txt1, txt2, txt4;
	JRadioButton rd1, rd2, rd3, rd4;
	public INSERT_BUILDING ( ){
		setTitle("어쩔매물 DB Insert Building Service");
		Color b=new Color(244,244,244);
		setBackground(b);
		setSize(700, 700);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Font f1 = new Font("아임크리수진",Font.PLAIN, 13);
		
		// 레이블 생성
		JLabel lbl1 = new JLabel("건물 id ");
		lbl1.setBounds(220, 50, 200, 20);
		lbl1.setFont(f1);
		
		JLabel lbl2 = new JLabel("건물 이름 : ");
		lbl2.setBounds(220, 120, 200, 20); 
		lbl2.setFont(f1);
		
		JLabel lbl3 = new JLabel("건물 종류: ");
		lbl3.setBounds(220, 190, 200, 20);
		lbl3.setFont(f1);
		
		JLabel lbl4 = new JLabel("지역 id: ");
		lbl4.setBounds(220, 260, 200, 20);
		lbl4.setFont(f1);
		
		// 20자리 텍스트 필드 생성
		txt1 = new JTextField(5); 
		txt1.setBounds(220, 80, 100, 20);

		txt2 = new JTextField(20); 
		txt2.setBounds(220, 150, 100, 20);        
		
		txt4 = new JTextField("Lid000",20); 
		txt4.setBounds(220, 290, 200, 20);

		getContentPane().add(lbl1);		getContentPane().add(txt1);
		getContentPane().add(lbl2);		getContentPane().add(txt2);
		getContentPane().add(lbl3);		
		getContentPane().add(lbl4);		getContentPane().add(txt4);
		
		rd1 = new JRadioButton("아파트"); 	rd1.setBounds(220, 220, 70, 20);
        rd2 = new JRadioButton("단독주택");	rd2.setBounds(290, 220, 90, 20);
        rd3 = new JRadioButton("빌라");		rd3.setBounds(380, 220, 50, 20);
        rd4 = new JRadioButton("오피스텔");	rd4.setBounds(440, 220, 90, 20);
        // 라디오 버튼을 그룹화 하기위한 객체 생성
        ButtonGroup groupRd = new ButtonGroup();
        groupRd.add(rd1);
        groupRd.add(rd2);
        groupRd.add(rd3);
        groupRd.add(rd4);
        
        getContentPane().add(rd1);
        getContentPane().add(rd2);
        getContentPane().add(rd3);
        getContentPane().add(rd4);
        
        
		RoundedButton btn = new RoundedButton("등록");
		btn.setBounds(350, 340, 70, 30);
		btn.setFont(f1);
		getContentPane().add(btn);
		
		btn.addActionListener(this);
		
		setVisible(true);
	}
	
	
	public static void main(String args[]){
		new INSERT_BUILDING();
    }
	
	
	 @Override
		public void actionPerformed(ActionEvent e) {
	        Connection conn = null;
	        String id = "";
	        try{
	            String url = "jdbc:mysql://localhost:3306/db2022team11";
	       	 
	        	//Database user, password
	        	String  user = "DB2022Team11";
	        	String password ="DB2022Team11";

	            conn = DriverManager.getConnection(url, user, password);
	            System.out.println("Insert_AREA Successfully Connection!");	//연결 확인 메세지
	            conn.setAutoCommit(false);
	            
	            String id_num = txt1.getText();
	            String name = txt2.getText();
	            String type= " ";
	            String area_id = txt4.getText();
	        
	            if(id_num.length() <= 1) { id = "Bid00" + id_num; }
	            else if(id_num.length() == 2) {	id = "Bid0" + id_num; }       
	            else if(id_num.length() == 3) {id = "Bid" + id_num;}         	
	            else  {JOptionPane.showMessageDialog(null, "id는 세자리까지 입력가능합니다.", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);}
	            
	            if(rd1.isSelected())
	            	 type = rd1.getText();
	            else if(rd2.isSelected())
	            	 type = rd2.getText();
	            else if(rd3.isSelected())
	            	 type = rd3.getText();
	            else if(rd4.isSelected())
	            	 type = rd4.getText();
	            else 
	            	JOptionPane.showMessageDialog(null, "건물 종류를 선택해주세요", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
				
	            	
	            System.out.println(type);
	            System.out.println(id + " "+ name + " " + type + " " + area_id);
	           PreparedStatement pStmt = conn.prepareStatement(
	            		"insert into DB2022_BUILDING values(?,?,?,?)");
	           
	           	if(id_num.isEmpty()) { //id는 not null
	            	JOptionPane.showMessageDialog(null, "건물 id번호를 입력해주세요. \n", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE); 
	            }   
	           	else { pStmt.setString(1, id);}
	          	pStmt.setString(2, name);
	           	pStmt.setString(3, type);
	          	pStmt.setString(4, area_id);
	           	pStmt.executeUpdate();
	           	conn.commit();
	           	
	        	JOptionPane.showMessageDialog(null, "입력하신 건물정보를 등록하였습니다.");
	        }
	        catch (SQLException sqle) {
	        	sqle.printStackTrace();
				try {
					if(conn!=null)
						conn.rollback();
				}catch (SQLException e1) {
					e1.printStackTrace();
				}
	        	System.out.println("SQLException : " + sqle);
	        	JOptionPane.showMessageDialog(null, "새로운 건물 등록에 실패했습니다. \n", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE); 
	        }
	
    }
}
