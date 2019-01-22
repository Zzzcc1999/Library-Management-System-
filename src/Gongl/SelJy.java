package Gongl;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Neirong.Book;
import Neirong.Jy;


public class SelJy extends JInternalFrame implements ActionListener{
	JComboBox<String> box;
	JTextField t1;
	JButton jb1;
	JPanel pan;
	JTable jt;
	DefaultTableModel dtm;
	public SelJy() {
		box = new JComboBox<String>();
		box.addItem("借阅编号");
		box.addItem("学号");
		box.addItem("书本号");
		t1 = new JTextField(10);
		jb1 = new JButton("查询");
		pan = new JPanel();
		pan.add(box);
		pan.add(t1);
		pan.add(jb1);
		String[] cName = {"借阅编号","学号","书本号","借出时间","归还时间"};
		dtm = new DefaultTableModel(cName,6);
		jt = new JTable(dtm);
		JScrollPane sp = new JScrollPane(jt);
		this.add(sp, "Center");
		this.setTitle("查询课程");
		this.add(pan,"North");
		jb1.addActionListener(this);
		this.setVisible(true);
		this.setClosable(true);
		this.setResizable(true);
		this.setSize(300,300);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(jb1)) {
			JyDao d = new JyDao();
			String name="";
			if(box.getSelectedItem().equals("借阅编号")) {
				name = "jid";
			}else if(box.getSelectedItem().equals("学号")) {
				name = "sid";
			}else if(box.getSelectedItem().equals("书本号")) {
				name = "bid";
			}
			
			try {
				List<Jy> cou = d.findByField(name, t1.getText());
				while(dtm.getRowCount()>0) {
					dtm.removeRow(0);
				}
				for(Jy c: cou) {
					String[] k = new String[5];
					k[0] = c.getJid();
					k[1] = c.getSid();
					k[2] = c.getBid();
					k[3] = c.getJjcsj().toString();
					k[4] = c.getJghsj().toString();
					dtm.addRow(k);
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
	
}
