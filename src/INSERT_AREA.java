import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class INSERT_AREA extends JFrame implements ActionListener{

	JTextField txt1, txt2, txt3;
	
	public INSERT_AREA ( ){
		setTitle("��¿�Ź� DB Insert Area Service");
		Color b=new Color(244,244,244);
		setBackground(b);
		setSize(700, 700);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Font f1 = new Font("����ũ������",Font.PLAIN, 13);
		
		// ���̺� ����
		JLabel lbl1 = new JLabel("id (0�� ����� ���ڸ� ���ּ���)");
		lbl1.setBounds(220, 50, 200, 20);
		lbl1.setFont(f1);
		
		JLabel lbl2 = new JLabel("�� �̸�  ");
		lbl2.setBounds(220, 120, 200, 20); //��ġ�� 130,50
		lbl2.setFont(f1);
		JLabel lbl3 = new JLabel("�� �̸� ");
		lbl3.setBounds(220, 190, 200, 20);
		lbl3.setFont(f1);
		// 20�ڸ� �ؽ�Ʈ �ʵ� ����
		txt1 = new JTextField( 5); 
		txt1.setBounds(220, 80, 100, 20);

		txt2 = new JTextField(20); 
		txt2.setBounds(220, 150, 200, 20);

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
    	new INSERT_AREA();
    }
    
    @Override
	public void actionPerformed(ActionEvent e) {
        Connection conn = null;
        JOptionPane op = new JOptionPane();
        String id="";
        try{
            String url = "jdbc:mysql://localhost/DB2022Team11";
 
        	//Database user, password
        	String  user = "testuser";
        	String password ="1234";

            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Insert_AREA Successfully Connection!");	//���� Ȯ�� �޼���
		
            String id_num = txt1.getText();
            String gu = txt2.getText();
            String dong = txt3.getText();
            
            if(id_num.length() == 1) { id = "Lid00" + id_num; }
            else if(id_num.length() == 2) {	id = "Lid0" + id_num; }       
            else if(id_num.length() == 3) {id = "Lid" + id_num;}         	
            else  {op.showMessageDialog(null, "id�� ���ڸ����� �Է°����մϴ�.", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);}
	
            
            PreparedStatement pStmt = conn.prepareStatement(
         		"insert into DB2022_AREA values(?,?,?)");
            pStmt.setString(1, id);
            pStmt.setString(2, gu);
        	pStmt.setString(3, dong);
        	pStmt.executeUpdate();
        	op.showMessageDialog(null, "�Է��Ͻ� ������ ����Ͽ����ϴ�.");
        }
        catch (SQLException sqle) {
        	System.out.println("SQLException : " + sqle);

        	if(sqle.equals("java.sql.SQLIntegrityConstraintViolationException: Duplicate entry '"+ id +"' for key 'db2022_area.PRIMARY'"))
        		op.showMessageDialog(null, "���ο� ���� ��Ͽ� �����߽��ϴ�. \n �Է��Ͻ� id�� �̹� �����մϴ�.", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
        	
        	else 
        		op.showMessageDialog(null, "���ο� ���� ��Ͽ� �����߽��ϴ�. \n", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);  
        }
	}
}
