package com.klu.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Events {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	
	private Long mid;
	private String mname;
	private int mcost;
	private int pqty;
	private String mimage;
	public Events() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Events(Long mid, String mname, int mcost, int pqty, String mimage) {
		super();
		this.mid = mid;
		this.mname = mname;
		this.mcost = mcost;
		this.pqty = pqty;
		this.mimage = mimage;
	}
	public Long getMid() {
		return mid;
	}
	public void setMid(Long mid) {
		this.mid = mid;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public int getMcost() {
		return mcost;
	}
	public void setMcost(int mcost) {
		this.mcost = mcost;
	}
	public int getPqty() {
		return pqty;
	}
	public void setPqty(int pqty) {
		this.pqty = pqty;
	}
	public String getMimage() {
		return mimage;
	}
	public void setMimage(String mimage) {
		this.mimage = mimage;
	}
	@Override
	public String toString() {
		return "Events [mid=" + mid + ", mname=" + mname + ", mcost=" + mcost + ", pqty=" + pqty + ", mimage=" + mimage
				+ "]";
	}
	
}
