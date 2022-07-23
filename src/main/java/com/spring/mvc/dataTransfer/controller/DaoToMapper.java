package com.spring.mvc.dataTransfer.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.mvc.dataTransfer.dao.DataTransferDao;
import com.spring.mvc.dataTransfer.dto.ProductDto;

@Controller
@RequestMapping("/daoToMapper")
public class DaoToMapper {

	//private DataTransferDao temp = new DataTransferDao();
	
	@Autowired
	private DataTransferDao dataTransferDao;
	
	// 예시 1) 단일 데이터 전송
	@RequestMapping(value="/getInfo" , method=RequestMethod.GET)
	public String getInfo() {
		dataTransferDao.memberInfo("user7");
		return "home";
	}
	
	// 예시 2) DTO 전송
	@RequestMapping(value="/addProduct" , method=RequestMethod.GET)
	public String addProduct() {
		
		ProductDto productDto = new ProductDto();
		productDto.setProductCode("newProduct300");
		productDto.setProductName("신상품3");
		productDto.setProductPrice(300000);
		productDto.setProductDeliveryPrice(0);
		
		dataTransferDao.insertProduct(productDto);
		
		return "home";
		
	}
	
	// 예시 3) Map 전송
	@RequestMapping(value="/searchData1" , method=RequestMethod.GET)
	public String searchData1() {
		
		Map<String, Object> orderMap = new HashMap<String, Object>();
		orderMap.put("orderGoodsQty", 3);
		orderMap.put("deliveryState", "배송완료");
		
		dataTransferDao.searchData1(orderMap);
		
		return "home";
		
	}
	
	@RequestMapping(value="/searchData2" , method=RequestMethod.GET)
	public String searchData2() {
		
		Map<String,Object> orderMap = new HashMap<String, Object>();
		orderMap.put("deliveryState" , "배송준비중");
		orderMap.put("productDeliveryPrice" , 0);
		
		dataTransferDao.searchData2(orderMap);
		return "home";
		
	}
	
	@RequestMapping(value="/searchData3" , method=RequestMethod.GET)
	public String searchData3() {

		Map<String,Object> orderMap = new HashMap<String, Object>();
		orderMap.put("startDate", "2020-01-01");
		orderMap.put("endDate", "2020-12-31");
		
		dataTransferDao.searchData3(orderMap);
		
		return "home";
		
	}
	
	
}







