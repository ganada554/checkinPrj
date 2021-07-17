package com.checkin.web.entity;

import java.beans.Transient;

public class BookStoreView {
	
	private Integer id;
	private String bgImg; 
	private String logoImg;
	private String address;
	private String instagramUrl;
	private Integer memberId;
	private String name;
	private String operatingTime;
	private String guName;
	private Double latitude;
	private Double longitude;
	private Integer hashtagId;
	private String hashtagName;
	
	public BookStoreView() {
		// TODO Auto-generated constructor stub
	}

	public BookStoreView(Integer id, String bgImg, String logoImg, String address, String instagramUrl,
			Integer memberId, String name, String operatingTime, String guName, Double latitude, Double longitude,
			Integer hashtagId, String hashtagName) {
		super();
		this.id = id;
		this.bgImg = bgImg;
		this.logoImg = logoImg;
		this.address = address;
		this.instagramUrl = instagramUrl;
		this.memberId = memberId;
		this.name = name;
		this.operatingTime = operatingTime;
		this.guName = guName;
		this.latitude = latitude;
		this.longitude = longitude;
		this.hashtagId = hashtagId;
		this.hashtagName = hashtagName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBgImg() {
		return bgImg;
	}

	public void setBgImg(String bgImg) {
		this.bgImg = bgImg;
	}
	
   @Transient
	public String getBgImagePath() {
		if(bgImg == null)
			return null;
		
		return "/upload/bookstore/" + bgImg;
	}

	public String getLogoImg() {
		return logoImg;
	}

	public void setLogoImg(String logoImg) {
		this.logoImg = logoImg;
	}

   @Transient
   public String getLogoImagePath() {
		if(logoImg == null)
			return null;
		
		return "/upload/bookstore/" + logoImg;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getInstagramUrl() {
		return instagramUrl;
	}

	public void setInstagramUrl(String instagramUrl) {
		this.instagramUrl = instagramUrl;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOperatingTime() {
		return operatingTime;
	}

	public void setOperatingTime(String operatingTime) {
		this.operatingTime = operatingTime;
	}

	public String getGuName() {
		return guName;
	}

	public void setGuName(String guName) {
		this.guName = guName;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Integer getHashtagId() {
		return hashtagId;
	}

	public void setHashtagId(Integer hashtagId) {
		this.hashtagId = hashtagId;
	}

	public String getHashtagName() {
		return hashtagName;
	}

	public void setHashtagName(String hashtagName) {
		this.hashtagName = hashtagName;
	}

	@Override
	public String toString() {
		return "BookStoreView [id=" + id + ", bgImg=" + bgImg + ", logoImg=" + logoImg + ", address=" + address
				+ ", instagramUrl=" + instagramUrl + ", memberId=" + memberId + ", name=" + name + ", operatingTime="
				+ operatingTime + ", guName=" + guName + ", latitude=" + latitude + ", longitude=" + longitude
				+ ", hashtagId=" + hashtagId + ", hashtagName=" + hashtagName + "]";
	}
	
}
