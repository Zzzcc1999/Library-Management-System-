package Jm;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;

import Dl.EditMm;
import Dl.Lj;

public class Dl1 implements ActionListener{
	JFrame f;
	JLabel tl1,tl2,tl3;
	JTextArea ta1;
	JPasswordField m1;
	JButton Aa,Bb,Cc;
	public Dl1(){
		f = new JFrame("图书管理系统登录");
		f.setVisible(true);
		f.setLayout(null);
		tl1 = new JLabel("管理员登录");
		tl1.setFont(new Font("宋体", 1, 30));//设置JLable中字体的大小
		tl1.setBounds(170, 130, 200, 50);
		tl2 = new JLabel("账号:");
		tl3 = new JLabel("密码:");
		tl2.setBounds(120, 180, 100, 50);
		tl3.setBounds(120, 220, 100, 50);
		ta1 = new JTextArea();
		ta1.setBounds(150, 195, 200, 20);
		m1 = new JPasswordField();
		m1.setBounds(150, 235, 200, 20);
		Aa = new JButton("登录");
		Aa.setFont(new Font("宋体", 1, 15));
		Aa.setBounds(100, 260, 70,30);
		Bb = new JButton("取消");
		Bb.setFont(new Font("宋体", 1, 15));
		Bb.setBounds(180, 260, 70, 30);
		Cc = new JButton("忘记密码?");
		Cc.setFont(new Font("宋体", 1, 15));
		Cc.setBounds(260, 260, 120, 30);
		f.add(ta1);
		f.add(m1);
		f.add(tl2);
		f.add(tl3);
		f.add(tl1);
		f.add(Aa);
		f.add(Bb);
		f.add(Cc);
		Aa.addActionListener(this);
		Bb.addActionListener(this);
		Cc.addActionListener(this);
		f.setSize(500, 600);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		 new Dl1();
		
	}
	//登录的方法
	public void Dll() throws SQLException {
		Connection c = Lj.getCon();
		String i = "select * from GLY where GID=? and GPASSWORD=?";
		PreparedStatement ps = c.prepareStatement(i);
		ps.setString(1, ta1.getText());
		ps.setString(2, new String(m1.getPassword()));
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			new Tsgljm();
			f.dispose();
		}else {
			JOptionPane.showMessageDialog(f, "用户名或者密码有误");
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(Aa)) {
			try {
				Dll();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(e.getSource().equals(Bb)) {
			f.dispose();
		}
		if(e.getSource().equals(Cc)) {
			new EditMm();
			f.dispose();
		}
	}
}
