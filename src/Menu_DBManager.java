import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Menu_DBManager extends JFrame{
	String name[]={"신규 등록","정보 수정","정보 삭제"};
	JMenuItem mi_area[]=new JMenuItem[3], mi_agency[]=new JMenuItem[3], mi_owner[]=new JMenuItem[3],
			mi_building[]=new JMenuItem[3], mi_sale[]=new JMenuItem[3],	mi_view;
	
	public Menu_DBManager() {
		Color b=new Color(244,244,244);  
		Font f1 = new Font("아임크리수진", Font.PLAIN, 13);

		setTitle("어쩔매물 DB Manager Service");
		setSize(700, 700);
		setBackground(b);
		getContentPane().setLayout(null);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		JMenuBar m = new JMenuBar();
        setJMenuBar( m );
        

        JMenu m_agency = new JMenu("부동산 정보 관리");     
        JMenu m_owner = new JMenu("집주인 정보 관리");
        JMenu m_building = new JMenu("건물 정보 관리");     
        JMenu m_sale = new JMenu("매물 정보 관리");     
        m_agency.setFont(f1);	m.add(m_agency);
        m_owner.setFont(f1);	m.add(m_owner);		m_building.setFont(f1);		m.add(m_building);
        m_sale.setFont(f1);		m.add(m_sale);		

        
        for(int i=0; i< 3; i++) {
	        mi_agency[i]=new JMenuItem(name[i]);	mi_agency[i].addActionListener(new MyActionListener());    	m_agency.add(mi_agency[i]);
	        mi_owner[i]=new JMenuItem(name[i]);		mi_owner[i].addActionListener(new MyActionListener());    	m_owner.add(mi_owner[i]);
	        mi_building[i]=new JMenuItem(name[i]);	mi_building[i].addActionListener(new MyActionListener());   m_building.add(mi_building[i]);
	        mi_sale[i]=new JMenuItem(name[i]);		mi_sale[i].addActionListener(new MyActionListener());    	m_sale.add(mi_sale[i]);
        }
       
        
		f1 = new Font("아임크리수진",Font.PLAIN, 30);
		Font f2 = new Font("아임크리수진",Font.PLAIN, 20);
		
		
		JLabel lbl1 = new JLabel("~ DB 관리자용 화면입니다 ~");
		lbl1.setBounds(160, 230, 600, 50);
		lbl1.setFont(f1);	
		getContentPane().add(lbl1);
		
		JLabel lbl2 = new JLabel("상단에서 원하시는 메뉴를 선택해주세요");
		lbl2.setBounds(170, 330, 600, 50);
		lbl2.setFont(f2);	
		getContentPane().add(lbl2);

	}
	
	class MyActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
        	String cmd = ae.getActionCommand();
            JMenuItem item = (JMenuItem)ae.getSource();
            
            if(item==mi_agency[0]){
            	new INSERT_AGENCY();
            }
            else if(item==mi_agency[1]){
            	//부동산 수정
            }
            else if(item==mi_agency[2]){
            	//부동산 삭제
            }
            
            else if(item==mi_owner[0]){
            	new INSERT_OWNER();
            }
            else if(item==mi_owner[1]){
            	//집주인 수정
            }
            else if(item==mi_owner[2]){
            	//집주인 삭제
            }
            
            else if(item==mi_building[0]){
            	new INSERT_BUILDING();
            }
            else if(item==mi_building[1]){
            	//건물 수정
            }
            else if(item==mi_building[2]){
            	//건물 삭제
            }
            
            else if(item==mi_sale[0]){
            	new INSERT_SALE();
            }
            else if(item==mi_sale[1]){
            	//매물 수정
            }
            else if(item==mi_sale[2]){
            	//매물 삭제
            }
            
            else if(item==mi_view){
            	//매물 보기 
            }
        }
        
    }


}
