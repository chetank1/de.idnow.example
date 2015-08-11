package models;

import java.util.HashMap;
import java.util.Map;

public class Company {
	public static Map<Integer, Company> COMPANY_MAP =
			new HashMap<Integer, Company> ();
	
	private int id;
	private String name;
	private int SLA_time;
	private float SLA_percentage;
	private float Current_SLA_percentage;
	private float sla_delta;
	public Company(int id, String name, int sLA_time, float sLA_percentage,
			float current_SLA_percentage) {
		super();
		this.id = id;
		this.name = name;
		SLA_time = sLA_time;
		SLA_percentage = sLA_percentage;
		Current_SLA_percentage = current_SLA_percentage;
		sla_delta = Current_SLA_percentage - SLA_percentage;
	}
	public float getSla_delta() {
		return sla_delta;
	}
	public void setSla_delta(float sla_delta) {
		this.sla_delta = sla_delta;
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
	public int getSLA_time() {
		return SLA_time;
	}
	public void setSLA_time(int sLA_time) {
		SLA_time = sLA_time;
	}
	public float getSLA_percentage() {
		return SLA_percentage;
	}
	public void setSLA_percentage(float sLA_percentage) {
		SLA_percentage = sLA_percentage;
	}
	public float getCurrent_SLA_percentage() {
		return Current_SLA_percentage;
	}
	public void setCurrent_SLA_percentage(float current_SLA_percentage) {
		Current_SLA_percentage = current_SLA_percentage;
	}

}
