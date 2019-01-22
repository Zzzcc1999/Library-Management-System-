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


public class SelBook extends JInternalFrame implements ActionListener{
	JComboBox<String> box;
	JTextField t1;
	JButton jb1;
	JPanel pan;
	JTable jt;
	DefaultTableModel dtm;
	public SelBook() {
		box = new JComboBox<String>();
		box.addItem("�鱾��");
		box.addItem("�鱾����");
		t1 = new JTextField(10);
		jb1 = new JButton("��ѯ");
		pan = new JPanel();
		pan.add(box);
		pan.add(t1);
		pan.add(jb1);
		String[] cName = {"�鱾��","�鱾����","�Ƿ񱻽��","����ʱ��"};
		dtm = new DefaultTableModel(cName,6);
		jt = new JTable(dtm);
		JScrollPane sp = new JScrollPane(jt);
		this.add(sp, "Center");
		this.setTitle("��ѯ�γ�");
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
			BookDao d = new BookDao();
			String name="";
			if(box.getSelectedItem().equals("�鱾��")) {
				name = "bid";
			}else if(box.getSelectedItem().equals("�鱾����")) {
				name = "bname";
			}
			try {
				List<Book> cou = d.findByField(name, t1.getText());
				while(dtm.getRowCount()>0) {
					dtm.removeRow(0);
				}
				for(Book c: cou) {
					String[] k = new String[4];
					k[0] = c.getBid();
					k[1] = c.getBname();
					k[2] = c.getBboolean();
					k[3] = c.getbDate().toString();
					dtm.addRow(k);
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
	
}
