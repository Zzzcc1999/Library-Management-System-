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
		f = new JFrame("ͼ�����ϵͳ");
		f.setVisible(true);
		mStudent = new JMenu("ѧ������");
		mCourse = new JMenu("ͼ�����");
		mGrade = new JMenu("���Ĺ���");
		mInformation = new JMenu("��Ϣ��ѯ");
		
		//���
		b = new JMenuBar();
		b.add(mStudent);
		b.add(mCourse);
		b.add(mGrade);
		b.add(mInformation);
		
		/************************/
		iStuAdd = new JMenuItem("���ѧ��");
		iStuEdit = new JMenuItem("�޸�ѧ��");
		iStuDel = new JMenuItem("ɾ��ѧ��");
		mStudent.add(iStuAdd);
		mStudent.add(iStuEdit);
		mStudent.add(iStuDel);
		
		/************************/
		
		iCouAdd = new JMenuItem("�鱾���");
		iCouEdit = new JMenuItem("�鱾�޸�");
		iCouDel = new JMenuItem("�鱾ɾ��");
		mCourse.add(iCouAdd);
		mCourse.add(iCouEdit);
		mCourse.add(iCouDel);
		
		/************************/
		
		iGraAdd = new JMenuItem("�������");
		iGraEdit = new JMenuItem("�����޸�");
		mGrade.add(iGraAdd);
		mGrade.add(iGraEdit);
		
		/************************/
		iInXscx = new JMenu("ѧ����ѯ");
		iInKccx = new JMenu("�鱾��ѯ");
		iInCjcx = new JMenu("���Ĳ�ѯ");
		mInformation.add(iInXscx);
		mInformation.add(iInKccx);
		mInformation.add(iInCjcx);
		
		
		iAxh = new JMenuItem("��ѧ�Ų�ѯ");
		iAxsxm = new JMenuItem("��ѧ��������ѯ");
		iAzy = new JMenuItem("��רҵ��ѯ");
		iInXscx.add(iAxh);
		iInXscx.add(iAxsxm);
		iInXscx.add(iAzy);
		
		/************************/
		iAkcmc = new JMenuItem("���鱾�Ų�ѯ");
		iAskjs = new JMenuItem("���鱾���Ʋ�ѯ");
		iInKccx.add(iAkcmc);
		iInKccx.add(iAskjs);
		
		/************************/
		iCxsykm = new JMenuItem("�����ı�Ų�ѯ");
		iJxh = new JMenuItem("��ѧ�Ų�ѯ");
		iJbook = new JMenuItem("���鱾�Ų�ѯ");
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
			//�������
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
