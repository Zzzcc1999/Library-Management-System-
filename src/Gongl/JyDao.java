package Gongl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dl.Lj;
import Neirong.Book;
import Neirong.Jy;


public class JyDao {
	Connection cc;
	
	 public JyDao() {
		cc = Lj.getCon();
	}
	//添加借阅信息  jid,sid,bid,jjcsj,jghsj
			public int Jyadd(Jy j) throws SQLException {
				String sql = "insert into Jy values(?,?,?,?,?)";
				PreparedStatement pst = cc.prepareStatement(sql);
				pst.setString(1, j.getJid());
				pst.setString(2, j.getSid());
				pst.setString(3, j.getBid());
				pst.setDate(4, j.getJjcsj());
				pst.setDate(5, j.getJghsj());
				int i = pst.executeUpdate();
				return i;
			}
				
			
			
			//查询借阅信息
			public Jy findById(String jid) throws SQLException {
				String sql = "select * from Jy where jid = ?";
				PreparedStatement pst = cc.prepareStatement(sql);
				pst.setString(1, jid);
				Jy j  = null;
				ResultSet rs = pst.executeQuery();
				if(rs.next()) {
					j = new Jy();
					j.setJid(rs.getString(1));
					j.setSid(rs.getString(2));
					j.setBid(rs.getString(3));
					j.setJjcsj(rs.getDate(4));
					j.setJghsj(rs.getDate(5));
				}
				rs.close();
				pst.close();
				cc.close();
				return j;
			}
			
			//修改借阅信息
			public int updateJy(Jy j) throws SQLException {
				String sql = "update Jy set jjcsj = ?,jghsj = ? where jid= ? and sid = ? and bid = ?";
				PreparedStatement pst = cc.prepareStatement(sql);
				pst.setDate(1, j.getJjcsj());
				pst.setDate(2, j.getJghsj());
				pst.setString(3, j.getJid());
				pst.setString(4, j.getSid());
				pst.setString(5, j.getBid());
				int i = pst.executeUpdate();
				pst.close();
				cc.close();
				return i;
			}
			public List<Jy> findByField(String fName,String fValue) throws SQLException{
				String sql = "select * from jy where "+fName+" like '%"+fValue+"%'";
				PreparedStatement pst = cc.prepareStatement(sql);
				ResultSet rs  = pst.executeQuery();
				List<Jy> lis = new ArrayList<>();
				while(rs.next()) {
					Jy c = new Jy();
					c.setJid(rs.getString(1));
					c.setSid(rs.getString(2));
					c.setBid(rs.getString(3));
					c.setJjcsj(rs.getDate(4));
					c.setJghsj(rs.getDate(5));
					lis.add(c);
				}
				return lis;
			}

}
