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
		setTitle("��¿�Ź� DB Insert Owner Service");
		Color b=new Color(244,244,244);
		setBackground(b);
		setSize(700, 700);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Font f1 = new Font("����ũ������",Font.PLAIN, 13);
		
		// ���̺� ����
		JLabel lbl1 = new JLabel("id ");
		lbl1.setBounds(220, 50, 200, 20);
		lbl1.setFont(f1);
		
		JLabel lbl2 = new JLabel("������ �̸�  ");
		lbl2.setBounds(220, 120, 200, 20); 
		lbl2.setFont(f1);
		JLabel lbl3 = new JLabel("������ ��ȭ��ȣ  ");
		lbl3.setBounds(220, 190, 200, 20);
		lbl3.setFont(f1);
		
		// 20�ڸ� �ؽ�Ʈ �ʵ� ����
		txt1 = new JTextField(5); 
		txt1.setBounds(220, 80, 100, 20);

		txt2 = new JTextField(20); 
		txt2.setBounds(220, 150, 100, 20);

		txt3 = new JTextField(20); 
		txt3.setBounds(220, 220, 200, 20);


		getContentPane().add(lbl1);		getContentPane().add(txt1);
		getContentPane().add(lbl2);		getContentPane().add(txt2);
		getContentPane().add(lbl3);		getContentPane().add(txt3);
		
		
		RoundedButton btn = new RoundedButton("���");
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
	        String id="";
	        try{
	            String url = "jdbc:mysql://localhost:3306/db2022team11";
	       	 
	        	//Database user, password
	        	String  user = "DBTeam11";
	        	String password ="DBTeam11";

	            conn = DriverManager.getConnection(url, user, password);
	            System.out.println("Insert_OWNER Successfully Connection!");	//���� Ȯ�� �޼���
	            conn.setAutoCommit(false);

	            String id_num = txt1.getText();
	            String name = txt2.getText();
	            String number = txt3.getText();
			
	            if(id_num.length() <= 1) { id = "Oid00" + id_num; }
	            else if(id_num.length() == 2) {	id = "Oid0" + id_num; }       
	            else if(id_num.length() == 3) {id = "Oid" + id_num;}         	
	            else  {JOptionPane.showMessageDialog(null, "id�� ���ڸ����� �Է°����մϴ�.", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);}
	            
	            PreparedStatement pStmt = conn.prepareStatement(
	            		"insert into DB2022_OWNER values(?,?,?)");
	            
	          	pStmt.setString(2, name);
	           	pStmt.setString(3, number);
	           	
	           	//id�� not null
	           	if(id_num.isEmpty()) {                  
	            	JOptionPane.showMessageDialog(null, "������ id��ȣ�� �Է����ּ���. \n", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE); 
	            }   
	           	else {
	           		pStmt.setString(1, id);               
	           	}
	           	pStmt.executeUpdate(); 
	           	conn.commit();
	        	JOptionPane.showMessageDialog(null, "�Է��Ͻ� �������� ����Ͽ����ϴ�.");
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
	        	JOptionPane.showMessageDialog(null, "���ο� ������ ��Ͽ� �����߽��ϴ�. \n", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);  
	        } 
		}

}
