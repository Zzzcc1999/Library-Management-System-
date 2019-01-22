package Gongl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Neirong.Student;



public class SelStu extends JInternalFrame implements ActionListener{
	JComboBox<String> box;
	JTextField t1;
	JButton jb1;
	JPanel pan;
	JTable jt;
	DefaultTableModel dtm;
	
	public SelStu() {
		box = new JComboBox<String>();
		box.addItem("ѧ��");
		box.addItem("����");
		box.addItem("�Ա�");
		box.addItem("����");
		box.addItem("רҵ");
		box.addItem("�༶");
		box.addItem("��ַ");
		t1 = new JTextField(10);
		jb1 = new JButton("��ѯ");
		pan = new JPanel();
		pan.add(box);
		pan.add(t1);
		pan.add(jb1);
		String[] cName = {"ѧ��","����","�Ա�","����","רҵ","�༶","��ַ"};
		dtm = new DefaultTableModel(cName,6);
		jt = new JTable(dtm);
		JScrollPane sp = new JScrollPane(jt);
		this.add(sp, "Center");
		this.setTitle("��ѯѧ��");
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
			Studao d = new Studao();
			String name="";
			if(box.getSelectedItem().equals("ѧ��")) {
				name = "sid";
			}else if(box.getSelectedItem().equals("����")) {
				name = "sname";
			}else if(box.getSelectedItem().equals("�Ա�")) {
				name = "ssex";
			}else if(box.getSelectedItem().equals("����")) {
				name = "smz";
			}else if(box.getSelectedItem().equals("רҵ")) {
				name = "sdept";
			}else if(box.getSelectedItem().equals("�༶")) {
				name = "sclass";
			}else if(box.getSelectedItem().equals("��ַ")) {
				name = "sdz";
			}
			try {
				List<Student> stu = d.findByField(name, t1.getText());
				while(dtm.getRowCount()>0) {
					dtm.removeRow(0);
				}
				for(Student s: stu) {
					String[] c = new String[7];
					c[0] = s.getSid();
					c[1] = s.getSname();
					c[2] = s.getSsex();
					c[3] = s.getSmz();
					c[4] = s.getSdept();
					c[5] = s.getSclass();
					c[6] = s.getSdz();
					//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					dtm.addRow(c);
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
}
