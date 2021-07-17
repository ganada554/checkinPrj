package com.checkin.web.entity;

public class Rating {

	private Integer id;
	private String name;
	
	public Rating() {
		
	}

	public Rating(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Rating [id=" + id + ", name=" + name + "]";
	}

}
