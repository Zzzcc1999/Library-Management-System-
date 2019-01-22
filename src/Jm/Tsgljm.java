package Jm;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import Gongl.BookAdd;
import Gongl.BookDel;
import Gongl.BookEdit;
import Gongl.JyAdd;
import Gongl.JyEdit;
import Gongl.SelBook;
import Gongl.SelJy;
import Gongl.SelStu;
import Gongl.StudAdd;
import Gongl.Studel;
import Gongl.Stuedit;

public class Tsgljm implements ActionListener{
	JFrame f;
	JMenu mSystem,mStudent,mCourse,mGrade,mInformation;
	JMenuItem iStuAdd,iStuEdit,iStuDel,iStuChoose;
	JMenuItem iCouAdd,iCouEdit,iCouDel;
	JMenuItem iGraAdd,iGraEdit;
	JMenu iInXscx,iInKccx,iInCjcx;
	JMenuItem iAxh,iAxsxm,iAxsxb,iAzy,iAxy;
	JMenuItem iAkcmc,iAskjs;
	JMenuItem iCxsykm,iJxh,iJbook;
	JMenuBar b;
	public Tsgljm() {
		f = new JFrame("图书管理系统");
		f.setVisible(true);
		mStudent = new JMenu("学生管理");
		mCourse = new JMenu("图书管理");
		mGrade = new JMenu("借阅管理");
		mInformation = new JMenu("信息查询");
		
		//添加
		b = new JMenuBar();
		b.add(mStudent);
		b.add(mCourse);
		b.add(mGrade);
		b.add(mInformation);
		
		/************************/
		iStuAdd = new JMenuItem("添加学生");
		iStuEdit = new JMenuItem("修改学生");
		iStuDel = new JMenuItem("删除学生");
		mStudent.add(iStuAdd);
		mStudent.add(iStuEdit);
		mStudent.add(iStuDel);
		
		/************************/
		
		iCouAdd = new JMenuItem("书本添加");
		iCouEdit = new JMenuItem("书本修改");
		iCouDel = new JMenuItem("书本删除");
		mCourse.add(iCouAdd);
		mCourse.add(iCouEdit);
		mCourse.add(iCouDel);
		
		/************************/
		
		iGraAdd = new JMenuItem("借阅添加");
		iGraEdit = new JMenuItem("借阅修改");
		mGrade.add(iGraAdd);
		mGrade.add(iGraEdit);
		
		/************************/
		iInXscx = new JMenu("学生查询");
		iInKccx = new JMenu("书本查询");
		iInCjcx = new JMenu("借阅查询");
		mInformation.add(iInXscx);
		mInformation.add(iInKccx);
		mInformation.add(iInCjcx);
		
		
		iAxh = new JMenuItem("按学号查询");
		iAxsxm = new JMenuItem("按学生姓名查询");
		iAzy = new JMenuItem("按专业查询");
		iInXscx.add(iAxh);
		iInXscx.add(iAxsxm);
		iInXscx.add(iAzy);
		
		/************************/
		iAkcmc = new JMenuItem("按书本号查询");
		iAskjs = new JMenuItem("按书本名称查询");
		iInKccx.add(iAkcmc);
		iInKccx.add(iAskjs);
		
		/************************/
		iCxsykm = new JMenuItem("按借阅编号查询");
		iJxh = new JMenuItem("按学号查询");
		iJbook = new JMenuItem("按书本号查询");
		iInCjcx.add(iCxsykm);
		iInCjcx.add(iJxh);
		iInCjcx.add(iJbook);
		
		iStuAdd.addActionListener(this);
		iStuEdit.addActionListener(this);
		iStuDel.addActionListener(this);
		iCouAdd.addActionListener(this);
		iCouEdit.addActionListener(this);
		iCouDel.addActionListener(this);
		iGraAdd.addActionListener(this);
		iGraEdit.addActionListener(this);
		iAxh.addActionListener(this);
		iAxsxm.addActionListener(this);
		iAzy.addActionListener(this);
		iAkcmc.addActionListener(this);
		iAskjs.addActionListener(this);
		iCxsykm.addActionListener(this);
		iJxh.addActionListener(this);
		iJbook.addActionListener(this);
		
		f.setJMenuBar(b);
		f.setSize(400, 500);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new Tsgljm();
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(iStuAdd)) {
			JDesktopPane pane = new JDesktopPane();
			StudAdd add = new StudAdd();
			pane.add(add);
			f.setContentPane(pane);
		}
		if(e.getSource().equals(iStuEdit)) {
			JDesktopPane pane = new JDesktopPane();
			Stuedit edit = new Stuedit();
			pane.add(edit);
			f.setContentPane(pane);
		}
		if(e.getSource().equals(iStuDel)) {
			//桌面面板
			JDesktopPane pane = new JDesktopPane();
			Studel sd = new Studel();
			pane.add(sd);
			f.setContentPane(pane);
		}
		if(e.getSource().equals(iCouAdd)) {
			JDesktopPane pane = new JDesktopPane();
			BookAdd add = new BookAdd();
			pane.add(add);
			f.setContentPane(pane);
		}
		if(e.getSource().equals(iCouEdit)) {
			JDesktopPane pane = new JDesktopPane();
			BookEdit be = new BookEdit();
			pane.add(be);
			f.setContentPane(pane);
		}
		if(e.getSource().equals(iCouDel)) {
			JDesktopPane pane = new JDesktopPane();
			BookDel bd= new BookDel();
			pane.add(bd);
			f.setContentPane(pane);
		}
		if(e.getSource().equals(iGraAdd)) {
			JDesktopPane pane = new JDesktopPane();
			JyAdd ja= new JyAdd();
			pane.add(ja);
			f.setContentPane(pane);
		}
		if(e.getSource().equals(iGraEdit)) {
			JDesktopPane pane = new JDesktopPane();
			JyEdit je= new JyEdit();
			pane.add(je);
			f.setContentPane(pane);
		}
		if(e.getSource().equals(iAxh)) {
			JDesktopPane pane = new JDesktopPane();
			SelStu je= new SelStu();
			pane.add(je);
			f.setContentPane(pane);
		}
		if(e.getSource().equals(iAkcmc)) {
			JDesktopPane pane = new JDesktopPane();
			SelBook je= new SelBook();
			pane.add(je);
			f.setContentPane(pane);
		}
		if(e.getSource().equals(iCxsykm)) {
			JDesktopPane pane = new JDesktopPane();
			SelJy j= new SelJy();
			pane.add(j);
			f.setContentPane(pane);
		}
		
	}
}
