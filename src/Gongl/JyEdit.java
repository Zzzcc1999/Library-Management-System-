package Gongl;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


import Neirong.Jy;


public class JyEdit extends JInternalFrame implements ActionListener{
	//jid,sid,bid,jjcsj,jghsj
		JLabel l1,l2,l3,l4,l5;
		JTextField j1,j2,j3,j4,j5;
		JButton jb1,jb2,jb3;
		public JyEdit() {
			l1=new JLabel("���ı��:");
			l2=new JLabel("ѧ       ��:");
			l3=new JLabel("ͼ����:");
			l4=new JLabel("���ʱ��:");
			l5=new JLabel("�黹ʱ��:");
			j1=new JTextField(15);
			j2=new JTextField(15);
			j3=new JTextField(15);
			j4=new JTextField(15);
			j5=new JTextField(15);
			jb1=new JButton("ȷ��");
			jb2=new JButton("ȡ��");
			jb3=new JButton("��ѯ");
			this.setTitle("�����޸�");
			this.setVisible(true);
			this.setLayout(new FlowLayout());
			this.add(l1);
			this.add(j1);
			this.add(l2);
			this.add(j2);
			this.add(l3);
			this.add(j3);
			this.add(l4);
			this.add(j4);
			this.add(l5);
			this.add(j5);
			this.add(jb1);
			this.add(jb2);
			this.add(jb3);
			jb1.addActionListener(this);
			jb3.addActionListener(this);
			this.setSize(230,230);
			this.setClosable(true);
			
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource().equals(jb3)) {
				JyDao g=new JyDao();
				try {
					Jy j=g.findById(j1.getText());
					if(j==null) {
						JOptionPane.showMessageDialog(this, "��ѧ�Ų�����");
					}else {
						j2.setText(j.getSid());
						j3.setText(j.getBid());
						j4.setText(j.getJjcsj().toString());
						j5.setText(j.getJghsj().toString());
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			//ȷ��
			if(e.getSource().equals(jb1)) {
				JyDao dao=new JyDao();
				Jy j=new Jy();
				j.setJid(j1.getText());
				j.setSid(j2.getText());
				j.setBid(j3.getText());
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				try {
					java.util.Date d1 = sdf.parse(j4.getText());
					Date d2 = new Date(d1.getTime());
					j.setJjcsj(d2);
					java.util.Date d3 = sdf.parse(j5.getText());
					Date d4 = new Date(d3.getTime());
					j.setJghsj(d4);
					
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					int i=dao.updateJy(j);
					if(i == 1){
						JOptionPane.showMessageDialog(this,"�޸ĳɹ�");
					}else {
						JOptionPane.showMessageDialog(this,"�޸�ʧ��");
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		}
}
