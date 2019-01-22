package Dl;

/**
 * 1.右键project 选择Build Path 选择右边的Configure Build Path
 * 2.点击之后Libraries 选择Modulepath 
 * 3.然后单击右边Add External JARs进行添加
 * 
 */

import java.sql.Connection;
import java.sql.DriverManager;


public class Lj {
	static String driver="oracle.jdbc.driver.OracleDriver";
	static String url="jdbc:oracle:thin:@localhost:1521:orcl";
	static String user="c##tsglxt";
	static String password = "jason";
	static Connection c;
	
	public static Connection getCon() {
		try {
			Class.forName(driver);
			c=DriverManager.getConnection(url, user, password);
			System.out.println("成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("失败");
		}
		return c;
	}
	public static void main(String[] args) {
		Lj i = new Lj();
		i.getCon();
	}
}
