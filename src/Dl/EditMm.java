package Dl;

import java.awt.FlowLayout;
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
import javax.swing.JTextField;

import Jm.Dl1;
import Neirong.Gly;

public class EditMm implements ActionListener{
	JFrame f;
	JLabel l1,l2,l3;
	JPasswordField j2;
	JTextField j1,j3;
	JButton jb1,jb2;
	public EditMm() {
		f = new JFrame("��������");
		l1 = new JLabel("�˺�:");
		l2 = new JLabel("����:");
		l3 = new JLabel("�û���:");
		j1 = new JTextField(15);
		j2 = new JPasswordField(15);
		j3 = new JTextField(15);
		jb1 = new JButton("ȷ��");
		jb2 = new JButton("ȡ��");
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		f.setLayout(new FlowLayout());
		f.setVisible(true);
		f.add(l3);
		f.add(j3);
		f.add(l1);
		f.add(j1);
		f.add(l2);
		f.add(j2);
		f.add(jb1);
		f.add(jb2);
		f.setSize(240, 200);
	}
	public void xg() throws SQLException {
		Connection c = Lj.getCon();
		String sql = "update gly set gpassword = ? where gid= ? and glname = ?";
		PreparedStatement pst = c.prepareStatement(sql);
		pst.setString(1, new String(j2.getPassword()));
		pst.setString(3, j3.getText());
		pst.setString(2, j1.getText());
		ResultSet rs = pst.executeQuery();
		if(rs.next()) {
			JOptionPane.showMessageDialog(f, "�������޸�");
			new Dl1();
		}else {
			JOptionPane.showMessageDialog(f, "�����޸�ʧ�ܻ��û�������");
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(jb1)) {
			try {
				xg();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}	
		}
		if(e.getSource().equals(jb2)) {
			new Dl1();
			f.dispose();
		}
	}
}
