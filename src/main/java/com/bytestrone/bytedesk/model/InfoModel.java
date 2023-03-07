package com.bytestrone.bytedesk.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "info_table")
public class InfoModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "info_id")
	private Long infoId;
	@Column(name = "admin_info")
	private String adminInfo;
	@Column(name = "user_info")
	private String userInfo;
	@Column(name = "request_id")
	private String requestId;

	public Long getInfoId() {
		return infoId;
	}

	public void setInfoId(Long infoId) {
		this.infoId = infoId;
	}

	public String getAdminInfo() {
		return adminInfo;
	}

	public void setAdminInfo(String adminInfo) {
		this.adminInfo = adminInfo;
	}

	public String getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(String userInfo) {
		this.userInfo = userInfo;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

}
