package Gongl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Dl.Lj;
import Neirong.Student;



public class Studao {
	Connection cc;
	
	public Studao() {
		cc = Lj.getCon();
	}
	//查询所有学生
	public void findAll() throws SQLException {
		String sql = "select * from student";
		Statement st = cc.createStatement();
		ResultSet rs = st.executeQuery(sql);
		while(rs.next()) {
			System.out.print(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3));
		}
	}
	//添加学生
	public int addStu(Student s) throws SQLException {
		 String sql = "insert into student values(?,?,?,?,?,?,?)";
		PreparedStatement pst = cc.prepareStatement(sql);
		pst.setString(1, s.getSid());
		pst.setString(2, s.getSname());
		pst.setString(3, s.getSsex());
		pst.setString(4, s.getSdept());
		pst.setString(5, s.getSclass());
		pst.setString(6, s.getSmz());
		pst.setString(7, s.getSdz());
		int i = pst.executeUpdate();
		return i;
	}
	//查学生(按学号)
	public Student findById(String sid) throws SQLException {
		//sql语句
		String sql = "select * from student where sid = ?";
		PreparedStatement pst = cc.prepareStatement(sql);
		pst.setString(1, sid);
		Student s  = null;
		//执行sql语句
		ResultSet rs = pst.executeQuery();
		if(rs.next()) {
			s = new Student();
			s.setSid(rs.getString(1));
			s.setSname(rs.getString(2));
			s.setSsex(rs.getString(3));
			s.setSmz(rs.getString(4));
			s.setSdept(rs.getString(5));
			s.setSclass(rs.getString(6));
			s.setSdz(rs.getString(7));
		}
		rs.close();
		pst.close();
		cc.close();
		return s;
	}
	
	//修改学生
	public int updateStu(Student s) throws SQLException {
		//sql
		String sql = "update student set sname = ?,ssex = ?,sdept=?,sclass=?,smz=?,sdz=? where sid= ?";
		PreparedStatement pst = cc.prepareStatement(sql);
		pst.setString(1, s.getSname());
		pst.setString(2, s.getSsex());
		pst.setString(3, s.getSdept());
		pst.setString(4, s.getSclass());
		pst.setString(5, s.getSmz());
		pst.setString(6, s.getSdz());
		pst.setString(7, s.getSid());
		int i = pst.executeUpdate();
		pst.close();
		cc.close();
		return i;
	}
	//删除学生
	public int deleteStu(String sid) throws SQLException {
		String sql = "delete student where sid = ?";
		PreparedStatement pst = cc.prepareStatement(sql);
		pst.setString(1, sid);
		int i = pst.executeUpdate();
		pst.close();
		cc.close();
		return i;
	}
	
	//按字段名查询
		public List<Student> findByField(String fName,String fValue) throws SQLException{
			String sql = "select * from student where "+fName+" like '%"+fValue+"%'";
			PreparedStatement pst = cc.prepareStatement(sql);
			ResultSet rs  = pst.executeQuery();
			List<Student> lis = new ArrayList<>();
			while(rs.next()) {
				Student s = new Student();
				s.setSid(rs.getString(1));
				s.setSname(rs.getString(2));
				s.setSsex(rs.getString(3));
				s.setSmz(rs.getString(4));
				s.setSdept(rs.getString(5));
				s.setSclass(rs.getString(6));
				s.setSdz(rs.getString(7));
				lis.add(s);
			}
			return lis;
		}
	
	public static void main(String[] args) {
		Studao i = new Studao();
		try {
			i.findAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
