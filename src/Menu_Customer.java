import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Menu_Customer extends JFrame{
	public Menu_Customer() {
		Color b=new Color(244,244,244);  
		
		setTitle("��¿�Ź� DB Manager Service");
		setSize(700, 700);
		setBackground(b);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar m = new JMenuBar();
        setJMenuBar( m );
            
        JMenu m_search = new JMenu("�Ź� �˻�");     
        JMenu m_seeAll = new JMenu("��ü �Ź� ����"); 
        m.add(m_search);		m.add(m_seeAll);
        
        JMenuItem i_area = new JMenuItem("������");
        JMenuItem i_type = new JMenuItem("������");
        JMenuItem i_price = new JMenuItem("��뺰");
        m_search.add(i_area);
        m_search.add(i_type);
        m_search.add(i_price);

		setVisible(true);
	}
}