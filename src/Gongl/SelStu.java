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
		box.addItem("学号");
		box.addItem("姓名");
		box.addItem("性别");
		box.addItem("民族");
		box.addItem("专业");
		box.addItem("班级");
		box.addItem("地址");
		t1 = new JTextField(10);
		jb1 = new JButton("查询");
		pan = new JPanel();
		pan.add(box);
		pan.add(t1);
		pan.add(jb1);
		String[] cName = {"学号","姓名","性别","民族","专业","班级","地址"};
		dtm = new DefaultTableModel(cName,6);
		jt = new JTable(dtm);
		JScrollPane sp = new JScrollPane(jt);
		this.add(sp, "Center");
		this.setTitle("查询学生");
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
			if(box.getSelectedItem().equals("学号")) {
				name = "sid";
			}else if(box.getSelectedItem().equals("姓名")) {
				name = "sname";
			}else if(box.getSelectedItem().equals("性别")) {
				name = "ssex";
			}else if(box.getSelectedItem().equals("民族")) {
				name = "smz";
			}else if(box.getSelectedItem().equals("专业")) {
				name = "sdept";
			}else if(box.getSelectedItem().equals("班级")) {
				name = "sclass";
			}else if(box.getSelectedItem().equals("地址")) {
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
