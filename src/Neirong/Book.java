package Neirong;

import java.sql.Date;

public class Book {
	String bid,bname,bboolean;
	Date bDate;
	public String getBid() {
		return bid;
	}

	public void setBid(String bid) {
		this.bid = bid;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getBboolean() {
		return bboolean;
	}

	public void setBboolean(String bboolean) {
		this.bboolean = bboolean;
	}

	public Date getbDate() {
		return bDate;
	}

	public void setbDate(Date bDate) {
		this.bDate = bDate;
	}
	
}
