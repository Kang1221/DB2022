import java.sql.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class updateBuilding extends JFrame implements ActionListener{
	public Connection conn;
	public Statement s;
	public ResultSet r;
	
	private Vector<String> Head = new Vector<String>();
	
	private JTable table;
	private DefaultTableModel model;
	private static final int BOOLEAN_COLUMN = 0;
	private int ID_COLUMN = 0;
	private int NAME_COLUMN = 0;
	private int NUMBER_COLUMN = 0;
	
	// ���� & ���� ��ư
	private RoundedButton Show_Button = new RoundedButton("����");
	private RoundedButton Update_Button = new RoundedButton("����");
	Container me = this;
	
	JPanel panel;
	JScrollPane ScPane;
	private JLabel Setlabel_1 = new JLabel("���ο� �̸�: ");
	private JLabel Setlabel_2 = new JLabel("���ο� �ǹ� ����: ");
	private JTextField setName = new JTextField(10);
	private JRadioButton rd1, rd2, rd3, rd4;
	int count = 0;
	
	public updateBuilding() {
		Font f1 = new Font("����ũ������",Font.PLAIN, 13);
		Setlabel_1.setFont(f1);
		Setlabel_2.setFont(f1);
		
		rd1 = new JRadioButton("����Ʈ"); 	
        rd2 = new JRadioButton("�ܵ�����");	
        rd3 = new JRadioButton("����");		
        rd4 = new JRadioButton("���ǽ���");	
        // ���� ��ư�� �׷�ȭ �ϱ����� ��ü ����
        ButtonGroup groupRd = new ButtonGroup();
        groupRd.add(rd1);
        groupRd.add(rd2);
        groupRd.add(rd3);
        groupRd.add(rd4);
        
		// ��ư �г�
		JPanel ShowAllPanel = new JPanel();
		ShowAllPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		ShowAllPanel.add(Update_Button);
		ShowAllPanel.add(Show_Button);
		
		// ���� update �г�
		JPanel UpdatePanel = new JPanel();
		UpdatePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		UpdatePanel.add(Setlabel_1);
		UpdatePanel.add(setName);
		UpdatePanel.add(new JLabel("  "));
		UpdatePanel.add(Setlabel_2);
		UpdatePanel.add(rd1);	UpdatePanel.add(rd2);	UpdatePanel.add(rd3);	UpdatePanel.add(rd4);

		Container contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
		contentPane.setBackground(new Color(244, 244, 244));
			
		contentPane.add(UpdatePanel);
		contentPane.add(ShowAllPanel);
	
		
		Show_Button.addActionListener(this);
		Update_Button.addActionListener(this);
		
		setTitle("�ε��� ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700, 700);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		// DB ����
		try {
			Class.forName("com.mysql.jdbc.Driver");  // JDBC ����̹� ����
			
			String user = "DB2022Team11";
			String pwd = "DB2022Team11";
			String url = "jdbc:mysql://localhost:3306/db2022team11";
					
			conn = DriverManager.getConnection(url, user, pwd);
			System.out.println("���������� ����Ǿ����ϴ�.");
		} catch(SQLException e1) {
			System.out.println("������ �� �����ϴ�.");
			e1.printStackTrace();
		} catch(ClassNotFoundException e1) {
			System.out.println("����̹��� �ε��� �� �����ϴ�.");
			e1.printStackTrace();
		}
		
		// --------- // 
		if(count==1) {
			me.remove(panel);
			revalidate();
		}
		
		// table ����
		if(e.getSource() == Show_Button) {
			Head.clear();
			Head.add("����");
			Head.add("building_id");
			Head.add("building_name");
			Head.add("building_type");
		 
			// select������ DB2022_AGENCY ���̺� ��ü ����
			String stmt = "SELECT * FROM DB2022_BUILDING";
			
			// DefaultTablemodel �� JTable ����(update ���� �ش� �� ����)
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
			for(int i=0; i<Head.size(); i++) {
				if(Head.get(i) == "building_id") {
					ID_COLUMN = i;
				}
				else if(Head.get(i) == "building_name") {
					NAME_COLUMN = i;
				} else if(Head.get(i) == "building_type") {
					NUMBER_COLUMN = i;
				}
			}
			// JTable�� ���� 1���� Boolean ���� '����'������ üũ�ڽ��� ��Ÿ���� ���� Boolean.class ��ȯ
			table = new JTable(model) {
				@Override
				public Class getColumnClass(int column) {
					if(column == 0) {
						return Boolean.class;  // ���� üũ�ڽ�
					} else
						return String.class;
				}
			};
			
			try {
				count = 1;
				s = conn.createStatement();
				r = s.executeQuery(stmt);

				while(r.next()) {
					String[] input = new String[5];
					input[1] = r.getString("building_id");
					input[2] = r.getString("building_name");
					input[3] = r.getString("building_type");
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
		
		
		// UPDATE
		// for, if���� ���� '����' üũ�ڽ��� üũ�� ���� agency_id�� vector�� ����
		if(e.getSource() == Update_Button) {
			Vector<String> update_agency_id = new Vector<String>();
			try {
				String columnName_1 = model.getColumnName(2);  // �ǹ� �̸�
				String columnName_2 = model.getColumnName(3);  // �ǹ�����
				if(columnName_1 == "building_name" && columnName_2 == "building_type") {
					for(int i=0; i<table.getRowCount();i++){
						// '����' üũ�ڽ��� üũ�Ǿ��� ��� �÷� �� ������
						if(table.getValueAt(i, 0) == Boolean.TRUE) {
							update_agency_id.add((String) table.getValueAt(i, 1));
							String updateName = setName.getText();
							String updateType = ""; 
							if(rd1.isSelected())
								updateType = rd1.getText();
				            else if(rd2.isSelected())
				            	updateType = rd2.getText();
				            else if(rd3.isSelected())
				            	updateType = rd3.getText();
				            else if(rd4.isSelected())
				            	updateType = rd4.getText();

							table.setValueAt(updateName,  i,  NAME_COLUMN);
							table.setValueAt(updateType,  i,  NUMBER_COLUMN);
						}
					}
					for(int i=0; i<update_agency_id.size(); i++) {
						// update��
						String updateStmt = "UPDATE DB2022_AGENCY SET agency_name = ?, agency_number = ? WHERE agency_id = ?";
						PreparedStatement p = conn.prepareStatement(updateStmt);
						p.clearParameters();
						conn.setAutoCommit(false);  // Ʈ�����
						String updateName = setName.getText();
						String updateType = " "; 
						if(rd1.isSelected())
							updateType = rd1.getText();
			            else if(rd2.isSelected())
			            	updateType = rd2.getText();
			            else if(rd3.isSelected())
			            	updateType = rd3.getText();
			            else if(rd4.isSelected())
			            	updateType = rd4.getText();
						p.setString(1, updateName);
						p.setString(2, updateType);
						p.setString(3, String.valueOf(update_agency_id.get(i)));
						p.executeUpdate();
						conn.commit();
					}
				} 

				
			} catch(SQLException sqle) {
				sqle.printStackTrace();
					try {
						if(conn!=null)
							conn.rollback();
					}catch (SQLException e1) {
						e1.printStackTrace();
					}
				System.out.println("actionPerformed err: " + sqle);	
		}
			panel = new JPanel();
			ScPane = new JScrollPane(table);
			ScPane.setPreferredSize(new Dimension(600, 500));
			panel.add(ScPane);
			add(panel,BorderLayout.CENTER);
			revalidate();
		}  // UPDATE ��
	}	
	
	public static void main(String[] args) {
		new updateBuilding();
	}
}