package Gongl;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class Studel extends JInternalFrame implements ActionListener{
	JLabel j1;
	JTextField jt1;
	JButton jb1,jb2;
	public Studel(){
		j1 = new JLabel("����ɾ����ѧ��:");
		jt1 = new JTextField(12);
		jb1 = new JButton("ȷ��");
		jb2 = new JButton("ȡ��");
		this.setTitle("ɾ��ѧ��");
		this.setVisible(true);
		this.setLayout(new FlowLayout());
		this.add(j1);
		this.add(jt1);
		this.add(jb1);
		this.add(jb2);
		jb1.addActionListener(this);
		this.setSize(150, 200);
		this.setClosable(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(jb1)) {
			Studao s = new Studao();
			try {
				int i = s.deleteStu(jt1.getText());
				if(i == 1) {
					JOptionPane.showMessageDialog(this, "ɾ���ɹ�");
				}else {
					JOptionPane.showMessageDialog(this, "ɾ��ʧ��");
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}	
