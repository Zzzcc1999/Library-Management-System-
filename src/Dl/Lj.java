package Dl;

/**
 * 1.�Ҽ�project ѡ��Build Path ѡ���ұߵ�Configure Build Path
 * 2.���֮��Libraries ѡ��Modulepath 
 * 3.Ȼ�󵥻��ұ�Add External JARs�������
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
			System.out.println("�ɹ�");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("ʧ��");
		}
		return c;
	}
	public static void main(String[] args) {
		Lj i = new Lj();
		i.getCon();
	}
}
