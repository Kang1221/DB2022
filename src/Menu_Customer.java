import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Menu_Customer extends JFrame{
	public Menu_Customer() {
		Color b=new Color(244,244,244); 
		Color lb=new Color(34,54,77);
		
		setTitle("��¿�Ź� DB Customer Service");
		setSize(700, 700);
		setBackground(b);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Font f1 = new Font("����ũ������",Font.PLAIN, 30);
		Font f2 = new Font("����ũ������",Font.PLAIN, 20);
		
		
		JLabel lbl1 = new JLabel("~��¿ �ε���DB�� ���� ���� ȯ���մϴ�~");
		lbl1.setBounds(80, 150, 600, 50);
		lbl1.setFont(f1);	lbl1.setForeground(lb);
		getContentPane().add(lbl1);
		
		JLabel lbl2 = new JLabel("���Ͻô� �޴��� �������ּ���");
		lbl2.setBounds(200, 200, 600, 50);
		lbl2.setFont(f2);	lbl2.setForeground(lb);
		getContentPane().add(lbl2);

		//�˻� ��ư
		RoundedButton2 btnSearch = new RoundedButton2("1.  ���ϴ�  �Ź�  �˻��ϱ�");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//�˻� ��ü ����
				
				//ù ȭ���� ����
				setVisible(false);
			}
		});
		btnSearch.setBounds(90, 350, 500, 50); //���� ���� �� ����
		getContentPane().add(btnSearch);

		
		//DB ���� ���� ��ư
		RoundedButton2 btnCustomer = new RoundedButton2("2.  �Ź�  ����  ����       ");
		btnCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//���� ����  ��ü ����
				
				//ù ȭ���� ����
				setVisible(false);
				
			}
		});
		btnCustomer.setBounds(90, 425, 500, 50);
		getContentPane().add(btnCustomer);


		setVisible(true);
	}
}
