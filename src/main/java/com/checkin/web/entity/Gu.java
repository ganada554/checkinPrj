package com.checkin.web.entity;

public class Gu {

	private Integer id;
	private String name;
	private String img;
	private String longitude;
	private String latitude;
	
	
	public Gu(Integer id, String name, String img, String longitude, String latitude) {
		super();
		this.id = id;
		this.name = name;
		this.img = img;
		this.longitude = longitude;
		this.latitude = latitude;
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


	public String getImg() {
		return img;
	}


	public void setImg(String img) {
		this.img = img;
	}


	public String getLongitude() {
		return longitude;
	}


	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}


	public String getLatitude() {
		return latitude;
	}


	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}


	@Override
	public String toString() {
		return "Gu [id=" + id + ", name=" + name + ", img=" + img + ", longitude=" + longitude + ", latitude="
				+ latitude + "]";
	}

	
 


}