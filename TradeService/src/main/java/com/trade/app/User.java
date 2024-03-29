package com.trade.app;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="buy")
public class User {
	
	@Id
	int buyId;
	String userName;
	String stockName;
	int quantity;
	double price;
	double totalPrice;
	int brokerage;
	
	
	public int getBuyId() {
		return buyId;
	}
	public void setBuyId(int buyId) {
		this.buyId = buyId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getBrokerage() {
		return brokerage;
	}
	public void setBrokerage(int brokerage) {
		this.brokerage = brokerage;
	}
	
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	@Override
	public String toString() {
		return "User [buyId=" + buyId + ", user=" + userName + ", stockName=" + stockName + ", quantity=" + quantity
				+ ", price=" + price + ", brokerage=" + brokerage + "]";
	}
	
	
	

}
