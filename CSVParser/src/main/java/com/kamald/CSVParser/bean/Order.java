package com.kamald.CSVParser.bean;

public class Order {
	private Long id;
	private Long orderId;
	private Double amount;
	private String comment;
	private String fileName;
	private Integer line;
	private String result;
	private String currency;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public Integer getLine() {
		return line;
	}
	public void setLine(Integer line) {
		this.line = line;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	
	@Override
	public String toString() {
		return "Order [id=" + id + ", orderId=" + orderId + ", amount=" + amount + ", comment=" + comment
				+ ", fileName=" + fileName + ", line=" + line + ", result=" + result + "]";
	}
}
