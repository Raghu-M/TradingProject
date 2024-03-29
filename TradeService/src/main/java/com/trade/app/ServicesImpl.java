package com.trade.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ServicesImpl implements Services{
	
	@Autowired
	UserRepository userrepo;
	
	@Autowired
	StockRepository stockrep;

	@Override
	public List<User> getUserList(String userName) {
		return userrepo.findAllByUserName(userName);
	}

	@Override
	public Iterable<Stock> getStockList() {
		return stockrep.findAll();
	}

	@Override
	public boolean buyStock(Stock stock, String userName) {
		Stock nStock = new Stock();
		User user = new User();
		nStock = stockrep.findById(stock.getStockId()).get();
		if(nStock.getQuantity() != 0) {
			
			nStock.setQuantity(nStock.getQuantity() - 1);
			stockrep.save(nStock);
			user.setUserName(userName);
			user.setBrokerage(nStock.getBrokerage());
			user.setStockName(nStock.getName());
			user.setPrice(nStock.getPrice());
			user.setQuantity(1);
			user.setTotalPrice(nStock.getPrice()+(nStock.getPrice()*nStock.getBrokerage()/100));
			userrepo.save(user);
			
			return true;
			
		} else {
			
			return false;
			
		}
	}

	

}
