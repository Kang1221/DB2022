import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class INSERT_SALE extends JFrame implements ActionListener{
	
	JTextField txt1, txt2, txt3, txt4, txt6, txt7,txt8,txt9;
	JRadioButton rd1, rd2, rd3;
	
	public INSERT_SALE ( ){
		setTitle("��¿�Ź� DB Insert Sale Service");
		Color b=new Color(244,244,244);
		setBackground(b);
		setSize(700, 700);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Font f1 = new Font("����ũ������",Font.PLAIN, 13);
		
		// ���̺� ����
		JLabel lbl1 = new JLabel("�Ź� id ");
		lbl1.setBounds(220, 50, 200, 20);
		lbl1.setFont(f1);
		
		JLabel lbl2 = new JLabel("�ε��� id  ");
		lbl2.setBounds(220, 100, 200, 20); 
		lbl2.setFont(f1);
		
		JLabel lbl3 = new JLabel("������ id ");
		lbl3.setBounds(220, 150, 200, 20);
		lbl3.setFont(f1);
		
		JLabel lbl4 = new JLabel("���� id ");
		lbl4.setBounds(220, 200, 200, 20);
		lbl4.setFont(f1);
		
		JLabel lbl5 = new JLabel("�Ź� ���� ");
		lbl5.setBounds(220, 250, 200, 20);
		lbl5.setFont(f1);
		
		JLabel lbl6 = new JLabel("�ŸŰ�/������                           ������ ");
		lbl6.setBounds(220, 300, 400, 20);
		lbl6.setFont(f1);
		
		JLabel lbl8 = new JLabel("�ǹ� id ");
		lbl8.setBounds(220, 350, 200, 20);
		lbl8.setFont(f1);
		
		JLabel lbl9 = new JLabel("�� �ּ�");
		lbl9.setBounds(220, 400, 200, 20);
		lbl9.setFont(f1);
		
		JLabel won1 = new JLabel("����");
		won1.setBounds(340, 320, 120, 20);
		won1.setFont(f1);
		JLabel won2 = new JLabel("����");
		won2.setBounds(520, 320, 120, 20);
		won2.setFont(f1);
		
		
		//�ؽ�Ʈ �ʵ� ����
		txt1 = new JTextField(5); 
		txt1.setBounds(220, 70, 100, 20);

		txt2 = new JTextField("Aid000", 20); 
		txt2.setBounds(220, 120, 100, 20);
		
		txt3 = new JTextField("Oid000", 20); 
		txt3.setBounds(220, 170, 100, 20);
		
		txt4 = new JTextField("Lid000", 20); 
		txt4.setBounds(220, 220, 100, 20);
		
		txt6 = new JTextField(20); //�ŸŰ�
		txt6.setBounds(220, 320, 120, 20);
		
		txt7 = new JTextField(20); //������
		txt7.setBounds(400, 320, 120, 20);
		
		txt8 = new JTextField("Bid000", 20); //�������̵�
		
		txt8.setBounds(220, 370, 100, 20);
		txt9 = new JTextField(20); //���ּ�
		txt9.setBounds(220, 420, 300, 50);

		getContentPane().add(lbl1);		getContentPane().add(txt1);
		getContentPane().add(lbl2);		getContentPane().add(txt2);
		getContentPane().add(lbl3);		getContentPane().add(txt3);
		getContentPane().add(lbl4);		getContentPane().add(txt4);
		getContentPane().add(lbl5);		getContentPane().add(lbl6);		
		getContentPane().add(txt6);  	getContentPane().add(won1);
		getContentPane().add(txt7); 	getContentPane().add(won2);
		getContentPane().add(lbl8);		getContentPane().add(txt8);
		getContentPane().add(lbl9);		getContentPane().add(txt9);
		
		rd1 = new JRadioButton("�Ÿ�"); 	rd1.setBounds(220, 270, 50, 20);
        rd2 = new JRadioButton("����");	rd2.setBounds(300, 270, 50, 20);
        rd3 = new JRadioButton("����");	rd3.setBounds(380, 270, 50, 20);

        // ���� ��ư�� �׷�ȭ �ϱ����� ��ü ����
        ButtonGroup groupRd = new ButtonGroup();
        groupRd.add(rd1);
        groupRd.add(rd2);
        groupRd.add(rd3);
        
        getContentPane().add(rd1);
        getContentPane().add(rd2);
        getContentPane().add(rd3);

        
        
		RoundedButton btn = new RoundedButton("���");
		btn.setBounds(400, 600, 70, 30);
		btn.setFont(f1);
		getContentPane().add(btn);
		
		btn.addActionListener(this);
		
		setVisible(true);
	}
	public static void main(String args[]){
		new INSERT_SALE();
   }
	
	 @Override
		public void actionPerformed(ActionEvent e) {
	        Connection conn = null;
	        String id = "";
	        try{
	            String url = "jdbc:mysql://localhost/DB2022Team11";
	 
	        	//Database user, password
	        	String  user = "testuser";
	        	String password ="1234";

	            conn = DriverManager.getConnection(url, user, password);
	            System.out.println("Insert_SALE Successfully Connection!");	//���� Ȯ�� �޼���
			

	            String id_num, agency_id, owner_id, area_id, rent_type, date, building_id , address;
	            int price, deposit;
	            id_num = txt1.getText();					
	            agency_id = txt2.getText(); 				owner_id = txt3.getText();   		   
	            area_id = txt4.getText();					rent_type = " ";			
	            price = Integer.parseInt(txt6.getText());	
	            deposit = Integer.parseInt(txt7.getText());				
	            building_id = txt8.getText();			address = txt9.getText();
	            
	            // ���� ��¥ ���ϱ�
	            LocalDate now = LocalDate.now();
	            date = now.toString();
	            
	            if(id_num.length() == 1) { id = "Pid00" + id_num; }
	            else if(id_num.length() == 2) {	id = "Pid0" + id_num; }       
	            else if(id_num.length() == 3) {id = "Pid" + id_num;}         	
	            else  {JOptionPane.showMessageDialog(null, "id�� ���ڸ����� �Է°����մϴ�.", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);}

	            if(rd1.isSelected())
	            	rent_type = rd1.getText();
	            else if(rd2.isSelected())
	            	rent_type = rd2.getText();
	            else if(rd3.isSelected())
	            	rent_type = rd3.getText();
	            else 
					System.out.println("�ǹ� ������ �������ּ���"); //�����ӿ� ����
	            
	            PreparedStatement pStmt = conn.prepareStatement(
	            		"insert into DB2022_SALE values(?,?,?,?,?,?,?,?,?,?)");
	            pStmt.setString(1, id);
	          	pStmt.setString(2, agency_id);
	           	pStmt.setString(3, owner_id);
	          	pStmt.setString(4, area_id);
	           	pStmt.setString(5, rent_type);
	          	pStmt.setInt(6, price);
	           	pStmt.setInt(7, deposit);
	          	pStmt.setString(8, date);
	           	pStmt.setString(9, building_id);
	           	pStmt.setString(10, address);
	           	pStmt.executeUpdate();
	        	JOptionPane.showMessageDialog(null, "�Է��Ͻ� �Ź��� ����Ͽ����ϴ�.");
	        }
	        catch (SQLException sqle) {
	        	System.out.println("SQLException : " + sqle);
	        	if(sqle.equals("java.sql.SQLIntegrityConstraintViolationException: Duplicate entry '"+ id +"' for key 'db2022_area.PRIMARY'"))
	        		JOptionPane.showMessageDialog(null, "���ο� �Ź� ��Ͽ� �����߽��ϴ�. \n �Է��Ͻ� id�� �̹� �����մϴ�.", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
	        	
	        	else 
	        		JOptionPane.showMessageDialog(null, "���ο� �Ź� ��Ͽ� �����߽��ϴ�. \n", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE); 
	        }
	
 }
}
