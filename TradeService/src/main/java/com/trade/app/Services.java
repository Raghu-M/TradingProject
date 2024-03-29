package com.trade.app;

import java.util.List;

import org.springframework.stereotype.Service;



public interface Services {
	
	List<User> getUserList(String userName);
	Iterable<Stock> getStockList();
	boolean buyStock(Stock stock, String userName);

}
