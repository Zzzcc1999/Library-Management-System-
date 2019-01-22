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



public class StudAdd extends JInternalFrame implements ActionListener{
	JLabel l1,l2,l3,l4,l5,l6,l7,l8;
	JTextField j1,j2,j3,j4,j5,j6,j7;
	JRadioButton rb1,rb2;
	JButton jb1,jb2;
	ButtonGroup bg1;

	public StudAdd() {
		l1=new JLabel("学号:");
		l2=new JLabel("姓名:");
		l3=new JLabel("性别:");
		l4=new JLabel("民族:");
		l5=new JLabel("专业:");
		l6=new JLabel("班级:");
		l7=new JLabel("家庭住址:");
		rb1=new JRadioButton("          男    ");
		rb2=new JRadioButton("     女   ");
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
		jb1=new JButton("确定");
		jb2=new JButton("取消");
		this.setTitle("添加学生");
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
		jb1.addActionListener(this);
		this.setSize(230,300);
		this.setClosable(true);

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(jb1)) {
			Studao d = new Studao();
			Student s1 = new Student();
			s1.setSid(j1.getText());
			s1.setSname(j2.getText());
			if(rb1.isSelected()) {
				s1.setSsex("男");
			}else {
				s1.setSsex("女");
			}
			s1.setSmz(j4.getText());
			s1.setSdept(j5.getText());
			s1.setSclass(j6.getText());
			s1.setSdz(j7.getText());
			
			
			try {
					int n = d.addStu(s1);
				if(n == 1) {
					JOptionPane.showMessageDialog(this,"添加成功");
				}else {
					JOptionPane.showMessageDialog(this,"失败");
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
}
