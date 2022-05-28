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
		setTitle("��¿�Ź� DB Insert Building Service");
		Color b=new Color(244,244,244);
		setBackground(b);
		setSize(700, 700);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Font f1 = new Font("����ũ������",Font.PLAIN, 13);
		
		// ���̺� ����
		JLabel lbl1 = new JLabel("�ǹ� id ");
		lbl1.setBounds(220, 50, 200, 20);
		lbl1.setFont(f1);
		
		JLabel lbl2 = new JLabel("�ǹ� �̸� : ");
		lbl2.setBounds(220, 120, 200, 20); 
		lbl2.setFont(f1);
		
		JLabel lbl3 = new JLabel("�ǹ� ����: ");
		lbl3.setBounds(220, 190, 200, 20);
		lbl3.setFont(f1);
		
		JLabel lbl4 = new JLabel("���� id: ");
		lbl4.setBounds(220, 260, 200, 20);
		lbl4.setFont(f1);
		
		// 20�ڸ� �ؽ�Ʈ �ʵ� ����
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
		
		rd1 = new JRadioButton("����Ʈ"); 	rd1.setBounds(220, 220, 70, 20);
        rd2 = new JRadioButton("�ܵ�����");	rd2.setBounds(290, 220, 90, 20);
        rd3 = new JRadioButton("����");		rd3.setBounds(380, 220, 50, 20);
        rd4 = new JRadioButton("���ǽ���");	rd4.setBounds(440, 220, 90, 20);
        // ���� ��ư�� �׷�ȭ �ϱ����� ��ü ����
        ButtonGroup groupRd = new ButtonGroup();
        groupRd.add(rd1);
        groupRd.add(rd2);
        groupRd.add(rd3);
        groupRd.add(rd4);
        
        getContentPane().add(rd1);
        getContentPane().add(rd2);
        getContentPane().add(rd3);
        getContentPane().add(rd4);
        
        
		RoundedButton btn = new RoundedButton("���");
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
	            System.out.println("Insert_AREA Successfully Connection!");	//���� Ȯ�� �޼���
	            conn.setAutoCommit(false);
	            
	            String id_num = txt1.getText();
	            String name = txt2.getText();
	            String type= " ";
	            String area_id = txt4.getText();
	        
	            if(id_num.length() <= 1) { id = "Bid00" + id_num; }
	            else if(id_num.length() == 2) {	id = "Bid0" + id_num; }       
	            else if(id_num.length() == 3) {id = "Bid" + id_num;}         	
	            else  {JOptionPane.showMessageDialog(null, "id�� ���ڸ����� �Է°����մϴ�.", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);}
	            
	            if(rd1.isSelected())
	            	 type = rd1.getText();
	            else if(rd2.isSelected())
	            	 type = rd2.getText();
	            else if(rd3.isSelected())
	            	 type = rd3.getText();
	            else if(rd4.isSelected())
	            	 type = rd4.getText();
	            else 
	            	JOptionPane.showMessageDialog(null, "�ǹ� ������ �������ּ���", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
				
	            	
	            System.out.println(type);
	            System.out.println(id + " "+ name + " " + type + " " + area_id);
	           PreparedStatement pStmt = conn.prepareStatement(
	            		"insert into DB2022_BUILDING values(?,?,?,?)");
	           
	           	if(id_num.isEmpty()) { //id�� not null
	            	JOptionPane.showMessageDialog(null, "�ǹ� id��ȣ�� �Է����ּ���. \n", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE); 
	            }   
	           	else { pStmt.setString(1, id);}
	          	pStmt.setString(2, name);
	           	pStmt.setString(3, type);
	          	pStmt.setString(4, area_id);
	           	pStmt.executeUpdate();
	           	conn.commit();
	           	
	        	JOptionPane.showMessageDialog(null, "�Է��Ͻ� �ǹ������� ����Ͽ����ϴ�.");
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
	        	JOptionPane.showMessageDialog(null, "���ο� �ǹ� ��Ͽ� �����߽��ϴ�. \n", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE); 
	        }
	
    }
}
