package com.trade.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;






@RestController
@RequestMapping("/")
public class Controller {
	
	@Autowired
	Services service;
	
	String gUserName;
	
	@GetMapping(value="/")
	public ModelAndView home(ModelAndView model){
		User user = new User();
		model.addObject("user",user);
		model.setViewName("Home");
		return model;
	}
	
	@PostMapping(path = "/userlist")
	public ModelAndView userList(@ModelAttribute User user, ModelAndView model) {
		List<User> list = service.getUserList(user.getUserName());
		this.gUserName = user.getUserName();
		if(list.size() == 0) {
			model.addObject("msg","No History Found");
		}
		model.addObject("list",list);
		model.addObject("userName",user.getUserName());
		model.setViewName("UserBuylist");
		return model;
	}
	
	@GetMapping("/stockList/")
	public ModelAndView userList( ModelAndView model){
		List<Stock> list = (List<Stock>) service.getStockList();
		model.addObject("list",list);
		model.addObject("userName",this.gUserName);
		model.setViewName("StockList");
		return model;
	}
	
	@GetMapping("/userBuy/{id}")
	public ModelAndView userBuy(@PathVariable("id") int id, ModelAndView model){
		Stock stock = new Stock();
		stock.setStockId(id);
		boolean flag = service.buyStock(stock, this.gUserName);
		if(flag) {
			List<User> list = service.getUserList(this.gUserName);
			model.addObject("list",list);
			model.setViewName("UserBuylist");
			return model;
		} else {
			
			List<Stock> list = (List<Stock>) service.getStockList();
			Stock stock1 = new Stock();
			model.addObject("stock",stock1);
			model.addObject("list",list);
			model.addObject("msg", "Stock Not Available");
			model.setViewName("StockList");
			return model;
		}
	}
	

}
