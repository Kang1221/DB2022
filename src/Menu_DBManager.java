import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Menu_DBManager extends JFrame{
	public Menu_DBManager() {
		Color b=new Color(244,244,244);  
		Font f1 = new Font("����ũ������", Font.PLAIN, 13);

		setTitle("��¿�Ź� DB Manager Service");
		setSize(700, 700);
		setBackground(b);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar m = new JMenuBar();
        setJMenuBar( m );
        
        JMenu m_area = new JMenu("���� ���� ����");
        JMenu m_agency = new JMenu("�ε��� ���� ����");     
        JMenu m_owner = new JMenu("������ ���� ����");
        JMenu m_building = new JMenu("�ǹ� ���� ����");     
        JMenu m_sale = new JMenu("�Ź� ����");     
        JMenu m_seeAll = new JMenu("��ü �Ź� ����"); 
        m_area.setFont(f1);		m.add(m_area);		m_agency.setFont(f1);		m.add(m_agency);
        m_owner.setFont(f1);	m.add(m_owner);		m_building.setFont(f1);		m.add(m_building);
        m_sale.setFont(f1);		m.add(m_sale);		m_seeAll.setFont(f1);		m.add(m_seeAll);
        
        JMenuItem i_insert = new JMenuItem("�ű� ���");
        JMenuItem i_modi = new JMenuItem("���� ���� ����");     
        m_area.add(i_insert);
        m_area.add(i_modi);


		setVisible(true);
	}
}