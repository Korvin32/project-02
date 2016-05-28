package data;

import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="bean")
@SessionScoped
public class TestInputDateComponentBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private long date1 = System.currentTimeMillis();
	private Date date2 = new Date();
	private Date date3 = new Date();
	
	public void submit() {
		System.out.println("Date submited!");
	}
	
	public long getDate1() {
		return date1;
	}
	public void setDate1(long date1) {
		this.date1 = date1;
	}
	public Date getDate2() {
		return date2;
	}
	public void setDate2(Date date2) {
		this.date2 = date2;
	}
	public Date getDate3() {
		return date3;
	}
	public void setDate3(Date date3) {
		this.date3 = date3;
	}

	
	
}
