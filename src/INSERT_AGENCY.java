import java.sql.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class INSERT_AGENCY extends JFrame implements ActionListener{
	JTextField txt1, txt2, txt3, txt4, txt5;
	
	public Statement s;
	public ResultSet r;
	
	private Vector<String> Head = new Vector<String>();
	
	private JTable table;
	private DefaultTableModel model;
	private int ID_COLUMN = 0;
	private int NAME_COLUMN = 0;
	private int NUMBER_COLUMN = 0;

	private RoundedButton Show_Button = new RoundedButton("����");
	private RoundedButton Insert_Button = new RoundedButton("���");
	Container me = this;
	
	JPanel panel;
	JScrollPane ScPane;
	int count = 0;

	
	public INSERT_AGENCY ( ){
		setTitle("��¿�Ź� DB Insert Agency Service");
		Color b=new Color(244,244,244);
		setBackground(b);
		setSize(700, 700);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setLocationRelativeTo(null);
		Font f1 = new Font("����ũ������",Font.PLAIN, 13);
			
		// ���̺� ����
		JLabel lbl1 = new JLabel("�ε��� id ");
		lbl1.setFont(f1);		
		JLabel lbl2 = new JLabel("�ε��� �̸�  ");
		lbl2.setFont(f1);		
		JLabel lbl3 = new JLabel("�ε��� ��ȭ��ȣ  ");
		lbl3.setFont(f1);		
		JLabel lbl4 = new JLabel("���� id");
		lbl4.setFont(f1);		
		JLabel lbl5 = new JLabel("�ε��� �� �ּ� ");
		lbl5.setFont(f1);
		
		
		// 20�ڸ� �ؽ�Ʈ �ʵ� ����
		txt1 = new JTextField("Aid000",6); 
		txt2 = new JTextField(20); 
		txt3 = new JTextField(20); 
		txt4 = new JTextField("Lid000",6); 
		txt5 = new JTextField(20); 


		JPanel ShowAllPanel = new JPanel();
		ShowAllPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		ShowAllPanel.add(Insert_Button);
		ShowAllPanel.add(Show_Button);

		
		JPanel UpdatePanel = new JPanel();
		UpdatePanel.setLayout(new GridLayout(5,3));
		UpdatePanel.add(lbl1);			UpdatePanel.add(txt1);
		UpdatePanel.add(lbl2);			UpdatePanel.add(txt2);
		UpdatePanel.add(lbl3);			UpdatePanel.add(txt3);
		UpdatePanel.add(lbl5);			UpdatePanel.add(txt5);
		UpdatePanel.add(lbl4);			UpdatePanel.add(txt4);

		
		Container contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
		contentPane.setBackground(new Color(244, 244, 244));
			
		contentPane.add(UpdatePanel);
		contentPane.add(ShowAllPanel);
		
		Show_Button.addActionListener(this);
		Insert_Button.addActionListener(this);

		
		setVisible(true);
	}

	 @Override
	public void actionPerformed(ActionEvent e) {
		 Connection conn = null;
	        
	     //JDBC ���� �κ�
	     try{
	    	 String url = "jdbc:mysql://localhost:3306/DB2022Team11";
	       	 
	        //Database user, password
	        String  user = "DB2022Team11";
	        String password ="DB2022Team11";
	        	
	        conn = DriverManager.getConnection(url, user, password);
	        System.out.println("Insert_AGENCY Successfully Connection!");	//���� Ȯ�� �޼���
	        conn.setAutoCommit(false);
	     }
	     catch(SQLException e1) {
	    	System.out.println("������ �� �����ϴ�.");
			e1.printStackTrace();
	     }
	     
			// --------- // 
			if(count==1) {
				me.remove(panel);
				revalidate();
			}
			
			
			 // ----------- AGENCY TABLE ���� ----------- //
			if(e.getSource() == Show_Button) {
				Head.clear();
				Head.add("agency_id");
				Head.add("agency_name");
				Head.add("agency_address");
				Head.add("agency_number");
				Head.add("area_id");
				
				String stmt = "SELECT * FROM DB2022_AGENCY";
				
				model = new DefaultTableModel(Head, 0) {
					@Override
					public boolean isCellEditable(int row, int column) {
						if(column > 0) {
							return false;
						} else {
							return true;
						}
					}
				};

				
				table = new JTable(model);
				
				try {
					count = 1;
					s = conn.createStatement();
					r = s.executeQuery(stmt);

					while(r.next()) {
						String[] input = new String[5];
						input[0] = r.getString("agency_id");
						input[1] = r.getString("agency_name");
						input[2] = r.getString("agency_address");
						input[3] = r.getString("agency_number");
						input[4] = r.getString("area_id");
						model.addRow(input);
					}
					
				} catch(SQLException ee) {
					System.out.println("actionPerformed err: " + ee);
					ee.printStackTrace();
				}
				
				panel = new JPanel();
				ScPane = new JScrollPane(table);
				ScPane.setPreferredSize(new Dimension(600, 500));
				panel.add(ScPane);
				add(panel,BorderLayout.CENTER);
				revalidate();
			}
			
			
			// ------------ INSERT �ε��� ---------------//
	        if(e.getSource() == Insert_Button) {
	        	 try{
	 	            String id_num = txt1.getText();
	 	            String name = txt2.getText();
	 	            String number = txt3.getText();
	 	            String area_id = txt4.getText();
	 	            String address = txt5.getText();

	 	            PreparedStatement pStmt = conn.prepareStatement(
	 	            		"insert into DB2022_AGENCY values(?,?,?,?,?)");

	 	            //ID ���ڸ� �̻� �Ұ���
		            if(id_num.length() > 6) {JOptionPane.showMessageDialog(null, "id�� ���ڸ����� �Է°����մϴ�.", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);}	            
		           	//ID null�� �Ұ���
	 	           	if(id_num.equals("Aid000") || id_num.isEmpty()) {                  
	 	            	JOptionPane.showMessageDialog(null, "�ε��� id��ȣ�� �Է����ּ���. \n", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE); 
	 	            }   
	 	           	else { pStmt.setString(1, id_num);}
	 	          	pStmt.setString(2, name);
	 	           	pStmt.setString(3, address);
	 	          	pStmt.setString(4, number);
	 	           	pStmt.setString(5, area_id);
	 	           	pStmt.executeUpdate();
	 	           	conn.commit();
	 	        	JOptionPane.showMessageDialog(null, "�Է��Ͻ� �ε����� ����Ͽ����ϴ�.");
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
	 	        	JOptionPane.showMessageDialog(null, "���ο� �ε��� ��Ͽ� �����߽��ϴ�. \n", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE); 
	 	        }
	        }
	 	}
	        
   
	public static void main(String args[]){
			new INSERT_AGENCY();
	}
}
