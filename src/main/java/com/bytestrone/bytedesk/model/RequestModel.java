package com.bytestrone.bytedesk.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "request_table")
public class RequestModel {
	@Id
	@Column(name = "request_id")
	private String requestId;
	@Column(name = "requested_date")
	private String requestedDate;
	@Column(name = "resolved_date")
	private LocalDate resolvedDate;
	@Column(name = "employee_id")
	private String employeeId;
	@Column(name = "employee_name")
	private String employeeName;
	@Column(name = "ticket_summary")
	private String ticketSummary;
	@Column(name = "ticket_description")
	private String ticketDescription;
	@Column(name = "ticket_status")
	private String ticketStatus;
	@Column(name = "department")
	private String department;
	@Column(name = "info")
	private String info;

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getRequestedDate() {
		return requestedDate;
	}

	public void setRequestedDate(String requestedDate) {
		this.requestedDate = requestedDate;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getTicketSummary() {
		return ticketSummary;
	}

	public void setTicketSummary(String ticketSummary) {
		this.ticketSummary = ticketSummary;
	}

	public String getTicketDescription() {
		return ticketDescription;
	}

	public void setTicketDescription(String ticketDescription) {
		this.ticketDescription = ticketDescription;
	}

	public String getTicketStatus() {
		return ticketStatus;
	}

	public void setTicketStatus(String ticketStatus) {
		this.ticketStatus = ticketStatus;
	}

	public LocalDate getResolvedDate() {
		return resolvedDate;
	}

	public void setResolvedDate(LocalDate localDate) {
		this.resolvedDate = localDate;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String resolution) {
		this.info = resolution;
	}

}
