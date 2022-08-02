package trip.dk.event;

import java.sql.Timestamp;

public class EventVo {
	
	
	
	public EventVo() {
		
	}
	public EventVo(int no, Timestamp startDate, Timestamp endDate) {
		
		this.no = no;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	private int no;
	private Timestamp startDate;
	private Timestamp endDate;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public Timestamp getStartDate() {
		return startDate;
	}
	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}
	public Timestamp getEndDate() {
		return endDate;
	}
	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}
	@Override
	public String toString() {
		return "EventVo [no=" + no + ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}
	
	
	
	

}
