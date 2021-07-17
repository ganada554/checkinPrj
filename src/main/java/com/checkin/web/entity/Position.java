package com.checkin.web.entity;

public class Position {
	private Integer id;
	private Integer name;
	

	public Position() {}


	public Position(int id, int name) {
		super();
		this.id = id;
		this.name = name;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getName() {
		return name;
	}


	public void setName(int name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "Position [id=" + id + ", name=" + name + "]";
	}
	
	
}
