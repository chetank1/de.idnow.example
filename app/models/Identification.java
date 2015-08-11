package models;

public class Identification implements Comparable<Identification> {
	
	private int id;
	private String name;
	private int time;
	private int waiting_time;
	private int companyid;
	
	public Identification() {}
	
	public Identification(int id, String name, int time,
			int waiting_time, int companyid) {
		super();
		this.id = id;
		this.name = name;
		this.time = time;
		this.waiting_time = waiting_time;
		this.companyid = companyid;
	}
	
	public int getTime() {
		return time;
	}

	public void setTime(int unixtime) {
		this.time = unixtime;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getWaiting_time() {
		return waiting_time;
	}
	public void setWaiting_time(int waiting_time) {
		this.waiting_time = waiting_time;
	}
	public int getCompanyid() {
		return companyid;
	}
	public void setCompanyid(int companyid) {
		this.companyid = companyid;
	}

	@Override
	public int compareTo(Identification that) {
		// TODO Auto-generated method stub
		if (this.waiting_time == that.waiting_time)
		{
			return (int) (Company.COMPANY_MAP.get(that.getCompanyid()).getSla_delta() - Company.COMPANY_MAP.get(this.getCompanyid()).getSla_delta()); 
		}
		return that.waiting_time - this.waiting_time;
	}



}
