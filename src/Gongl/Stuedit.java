package Gongl;



import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import Neirong.Student;



public class Stuedit extends JInternalFrame implements ActionListener{
	JLabel l1,l2,l3,l4,l5,l6,l7;
	JTextField j1,j2,j3,j4,j5,j6,j7;
	JRadioButton rb1,rb2;
	JButton jb1,jb2,jb3;
	ButtonGroup bg1;

	public Stuedit() {
		l1=new JLabel("ѧ��:");
		l2=new JLabel("����:");
		l3=new JLabel("�Ա�:");
		l4=new JLabel("����:");
		l5=new JLabel("רҵ:");
		l6=new JLabel("�༶:");
		l7=new JLabel("��ͥסַ:");
		rb1=new JRadioButton("          ��    ");
		rb2=new JRadioButton("     Ů   ");
		bg1 = new ButtonGroup();
		bg1.add(rb1);
		bg1.add(rb2);
		j1=new JTextField(15);
		j2=new JTextField(15);
		j3=new JTextField(15);
		j4=new JTextField(15);
		j5=new JTextField(15);
		j6=new JTextField(15);
		j7=new JTextField(12);
		jb1=new JButton("ȷ��");
		jb2=new JButton("ȡ��");
		jb3=new JButton("��ѯ");
		this.setTitle("�޸�ѧ��");
		this.setVisible(true);
		this.setLayout(new FlowLayout());
		this.add(l1);
		this.add(j1);
		this.add(l2);
		this.add(j2);
		this.add(l3);
		this.add(rb1);
		this.add(rb2);
		this.add(l4);
		this.add(j4);
		this.add(l5);
		this.add(j5);
		this.add(l6);
		this.add(j6);
		this.add(l7);
		this.add(j7);
		
		this.add(jb1);
		this.add(jb2);
		this.add(jb3);
		jb1.addActionListener(this);
		jb3.addActionListener(this);
		this.setSize(230,300);
		this.setClosable(true);

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(jb1)) {
			Studao d = new Studao();
			Student s = new Student();
			s.setSid(j1.getText());
			s.setSname(j2.getText());
			if(rb1.isSelected()) {
				s.setSsex("��");
			}else {
				s.setSsex("Ů");
			}
			s.setSdept(j4.getText());
			s.setSclass(j5.getText());
			s.setSmz(j6.getText());
			s.setSdz(j7.getText());
			
			try {
				int i = d.updateStu(s);
				if(i == 1) {
					JOptionPane.showMessageDialog(this, "�޸ĳɹ�");
				}else {
					JOptionPane.showMessageDialog(this, "�޸�ʧ��");
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
			if(e.getSource().equals(jb3)) {
				Studao i = new Studao();
				 try {
					Student stu = i.findById(j1.getText());
					if(stu == null) {
						JOptionPane.showMessageDialog(this, "��ѧ��8����");
					}else {
						j2.setText(stu.getSname());
						if(stu.getSsex().equals("��")) {
							rb1.setSelected(true);
						}else {
							rb2.setSelected(true);
						}
						j4.setText(stu.getSmz());
						j5.setText(stu.getSdept());
						j6.setText(stu.getSclass());
						j7.setText(stu.getSdz());
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	}
}
	
	
}
