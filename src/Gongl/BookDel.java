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

import Neirong.Book;

public class BookDel extends JInternalFrame implements ActionListener{
	JLabel j1;
	JTextField jt1;
	JButton jb1,jb2;
	public BookDel(){
		j1 = new JLabel("输入删除的书本编号:");
		jt1 = new JTextField(12);
		jb1 = new JButton("确定");
		jb2 = new JButton("取消");
		this.setTitle("书本删除");
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
			BookDao s = new BookDao();
			try {
				int i = s.deleteBook(jt1.getText());
				if(i == 1) {
					JOptionPane.showMessageDialog(this, "删除成功");
				}else {
					JOptionPane.showMessageDialog(this, "删除失败");
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
