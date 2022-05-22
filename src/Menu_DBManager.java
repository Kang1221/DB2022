import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Menu_DBManager extends JFrame{
	String name[]={"�ű� ���","���� ����","���� ����"};
	JMenuItem mi_area[]=new JMenuItem[3], mi_agency[]=new JMenuItem[3], mi_owner[]=new JMenuItem[3],
			mi_building[]=new JMenuItem[3], mi_sale[]=new JMenuItem[3];
	
	public Menu_DBManager() {
		Color b=new Color(244,244,244);  
		Font f1 = new Font("����ũ������", Font.PLAIN, 13);

		setTitle("��¿�Ź� DB Manager Service");
		setSize(700, 700);
		setBackground(b);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		JMenuBar m = new JMenuBar();
        setJMenuBar( m );
        
        JMenu m_area = new JMenu("���� ���� ����");
        JMenu m_agency = new JMenu("�ε��� ���� ����");     
        JMenu m_owner = new JMenu("������ ���� ����");
        JMenu m_building = new JMenu("�ǹ� ���� ����");     
        JMenu m_sale = new JMenu("�Ź� ���� ����");     
        JMenu m_seeAll = new JMenu("DB ������ ����"); 
        m_area.setFont(f1);		m.add(m_area);		m_agency.setFont(f1);		m.add(m_agency);
        m_owner.setFont(f1);	m.add(m_owner);		m_building.setFont(f1);		m.add(m_building);
        m_sale.setFont(f1);		m.add(m_sale);		m_seeAll.setFont(f1);	
        //��� ������ ����� JMenuItem ����
        m_seeAll.addActionListener(new MyActionListener());
        m.add(m_seeAll);
        
        for(int i=0; i< 3; i++){
	        mi_area[i]=new JMenuItem(name[i]);		mi_area[i].addActionListener(new MyActionListener());    	m_area.add(mi_area[i]);
	        mi_agency[i]=new JMenuItem(name[i]);	mi_agency[i].addActionListener(new MyActionListener());    	m_agency.add(mi_agency[i]);
	        mi_owner[i]=new JMenuItem(name[i]);		mi_owner[i].addActionListener(new MyActionListener());    	m_owner.add(mi_owner[i]);
	        mi_building[i]=new JMenuItem(name[i]);	mi_building[i].addActionListener(new MyActionListener());   m_building.add(mi_building[i]);
	        mi_sale[i]=new JMenuItem(name[i]);		mi_sale[i].addActionListener(new MyActionListener());    	m_sale.add(mi_sale[i]);
        }


	}
	class MyActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
        	String cmd = ae.getActionCommand();
        	System.out.println(cmd);
            JMenuItem item = (JMenuItem)ae.getSource();
            System.out.println(item+" "+cmd);
            if(item == null) {
            	new INSERT_AREA();
            }
            
            else if(item==mi_area[0]){
               new INSERT_AREA();
            }
            else if(item==mi_area[1]){
            	//���� ����
            }
            else if(item==mi_area[2]){
            	//���� ����
            }
            
            else if(item==mi_agency[0]){
            	new INSERT_AGENCY();
            }
            else if(item==mi_agency[1]){
            	//�ε��� ����
            }
            else if(item==mi_agency[2]){
            	//�ε��� ����
            }
            
            else if(item==mi_owner[0]){
            	new INSERT_OWNER();
            }
            else if(item==mi_owner[1]){
            	//������ ����
            }
            else if(item==mi_owner[2]){
            	//������ ����
            }
            
            else if(item==mi_building[0]){
            	new INSERT_BUILDING();
            }
            else if(item==mi_building[1]){
            	//�ǹ� ����
            }
            else if(item==mi_building[2]){
            	//�ǹ� ����
            }
            
            else if(item==mi_sale[0]){
            	new INSERT_SALE();
            }
            else if(item==mi_sale[1]){
            	//�Ź� ����
            }
            else if(item==mi_sale[2]){
            	//�Ź� ����
            }
            	
        }
        
    }


}
