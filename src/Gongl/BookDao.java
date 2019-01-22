package Gongl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dl.Lj;
import Neirong.Book;



public class BookDao {
	Connection cc;
	
	public BookDao() {
		cc = Lj.getCon();
	}
	//添加书本
		public int Bookadd(Book c) throws SQLException {
			String sql = "insert into Book values(?,?,?,?)";
			PreparedStatement pst = cc.prepareStatement(sql);
			pst.setString(1, c.getBid());
			pst.setString(2, c.getBname());
			pst.setString(3, c.getBboolean());
			pst.setString(4, c.getbDate().toString());
			int i = pst.executeUpdate();
			return i;
		}
			
		//查询书本 按书本号查询
		public Book findById(String bid) throws SQLException {
			String sql = "select * from Book where bid = ?";
			PreparedStatement pst = cc.prepareStatement(sql);
			pst.setString(1, bid);
			Book b  = null;
			//执行sql语句
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				b = new Book();
				b.setBid(rs.getString(1));
				b.setBname(rs.getString(2));
				b.setBboolean(rs.getString(3));
				b.setbDate(rs.getDate(4));
			}
			rs.close();
			pst.close();
			cc.close();
			return b;
		}
		
		//修改书本
		public int updateBook(Book b) throws SQLException {
			String sql = "update Book set bname = ?, bboolean = ? ,bdate = ?where bid= ?";
			PreparedStatement pst = cc.prepareStatement(sql);
			pst.setString(1, b.getBname());
			pst.setString(2, b.getBboolean());
			pst.setDate(3, b.getbDate());
			pst.setString(4, b.getBid());			
			int i = pst.executeUpdate();
			pst.close();
			cc.close();
			return i;
		}
		
		//删除书本
		public int deleteBook(String sid) throws SQLException {
			String sql = "delete Book where sid = ?";
			PreparedStatement pst = cc.prepareStatement(sql);
			pst.setString(1, sid);
			int i = pst.executeUpdate();
			pst.close();
			cc.close();
			return i;
		}
		public List<Book> findByField(String fName,String fValue) throws SQLException{
			String sql = "select * from book where "+fName+" like '%"+fValue+"%'";
			PreparedStatement pst = cc.prepareStatement(sql);
			ResultSet rs  = pst.executeQuery();
			List<Book> lis = new ArrayList<>();
			while(rs.next()) {
				Book c = new Book();
				c.setBid(rs.getString(1));
				c.setBname(rs.getString(2));
				c.setBboolean(rs.getString(3));
				c.setbDate(rs.getDate(4));
				lis.add(c);
			}
			return lis;
		}


}
