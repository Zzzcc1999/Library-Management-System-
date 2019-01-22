package Gongl;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


import Neirong.Book;
import Gongl.*;

public class BookAdd extends JInternalFrame implements ActionListener{
	//定义变量
	JLabel l1,l2,l3,l4;
	JTextField j1,j2,j3,j4;
	JButton jb1,jb2;
	public BookAdd() {
		l1=new JLabel("书本编号:");
		l2=new JLabel("书本名称:");
		l3=new JLabel("是否借出:");
		l4=new JLabel("书本存入日期:");
		j1=new JTextField(15);
		j2=new JTextField(15);
		j3=new JTextField(15);
		j4=new JTextField(12);
		jb1=new JButton("确定");
		jb2=new JButton("取消");
		this.add(l1);
		this.add(j1);
		this.add(l2);
		this.add(j2);
		this.add(l3);
		this.add(j3);
		this.add(l4);
		this.add(j4);
		this.add(jb1);
		this.add(jb2);
		this.setTitle("书本添加");
		this.setVisible(true);
		this.setLayout(new FlowLayout());
		jb1.addActionListener(this);
		this.setSize(230,300);
		this.setClosable(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(jb1)) {
			BookDao d = new BookDao();
			Book b = new Book();
			b.setBid(j1.getText());
			b.setBname(j2.getText());
			b.setBboolean(j3.getText());
			//字符串转换成date
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {
				java.util.Date d1 = sdf.parse(j4.getText());
				Date d2 = new Date(d1.getTime());
				b.setbDate(d2);
				
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			try {
				int n = d.Bookadd(b);
				if(n == 1) {
					JOptionPane.showMessageDialog(this,"添加成功");
				}else {
					JOptionPane.showMessageDialog(this,"添加失败");
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
}
