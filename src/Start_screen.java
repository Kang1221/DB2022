import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Start_screen extends JFrame {
	private Image background=new ImageIcon("src/image/first_image.png").getImage();//����̹���

	public Start_screen() {
		setTitle("��¿�Ź� DB Service");
		setSize(700, 700);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//DB ������ ����
		RoundedButton btnManager = new RoundedButton("������ �α���");
		btnManager.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//DB �����ڿ� ������ ��ü ����
				new Menu_DBManager();
				//ù ȭ���� ����
				setVisible(false);
			}
		});
		btnManager.setBounds(250, 400, 150, 50); //���� ���� �� ����
		getContentPane().add(btnManager);

		
		//������ ���� 
		RoundedButton btnCustomer = new RoundedButton("������ �α���");
		btnCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//�����ڿ� ������ ��ü ����
				new Menu_Customer();
				//ù ȭ���� ����
				setVisible(false);
				
			}
		});
		btnCustomer.setBounds(250, 475, 150, 50);
		getContentPane().add(btnCustomer);



		setVisible(true);
	}
	

	
	public void paint(Graphics g) {//�׸��� �Լ�
		g.drawImage(background, 0, 0, null);//background�� �׷���
	}
	 
	public static void main(String[] args) {
		new Start_screen();
	}


}
