import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Menu_DBManager extends JFrame{
	public Menu_DBManager() {
		Color b=new Color(244,244,244);  
		Font f1 = new Font("아임크리수진", Font.PLAIN, 13);

		setTitle("어쩔매물 DB Manager Service");
		setSize(700, 700);
		setBackground(b);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar m = new JMenuBar();
        setJMenuBar( m );
        
        JMenu m_area = new JMenu("지역 정보 관리");
        JMenu m_agency = new JMenu("부동산 정보 관리");     
        JMenu m_owner = new JMenu("집주인 정보 관리");
        JMenu m_building = new JMenu("건물 정보 관리");     
        JMenu m_sale = new JMenu("매물 관리");     
        JMenu m_seeAll = new JMenu("전체 매물 보기"); 
        m_area.setFont(f1);		m.add(m_area);		m_agency.setFont(f1);		m.add(m_agency);
        m_owner.setFont(f1);	m.add(m_owner);		m_building.setFont(f1);		m.add(m_building);
        m_sale.setFont(f1);		m.add(m_sale);		m_seeAll.setFont(f1);		m.add(m_seeAll);
        
        JMenuItem i_insert = new JMenuItem("신규 등록");
        JMenuItem i_modi = new JMenuItem("기존 정보 관리");     
        m_area.add(i_insert);
        m_area.add(i_modi);


		setVisible(true);
	}
}
