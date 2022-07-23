package com.spring.mvc.dataTransfer.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.mvc.dataTransfer.dto.MemberDto;
import com.spring.mvc.dataTransfer.dto.OrderDto;
import com.spring.mvc.dataTransfer.dto.ProductDto;

@Repository
public class DataTransferDao {

	@Autowired
	private SqlSession sqlSession; //SqlSession 객체를 주입
	
	/*
	 * 
	 * # Mapper To Dao
	 * 
	 *  - 한개의 데이터를 조회할 경우       .selectOne() 메서드를 사용한다.
	 *  - 한개 이상의 데이터를 조회할 경우  .selectList() 메서드를 사용하며 반환데이터는 List로 처리할 수 있다.
	 *      주의) Mapper 파일에서 반환타입(resultType)이 List가 아니고
	 *            selectList() 메서드로 List를 처리한다.
	 *  
	 *  - insert쿼리를 사용할 경우 .insert() 메서드를 사용한다.
	 *  - update쿼리를 사용할 경우 .update() 메서드를 사용한다.
	 *  - delete쿼리를 사용할 경우 .delete() 메서드를 사용한다.
	 *  
	 * */
	
	public void selectData1() {
		
		int count = sqlSession.selectOne("dataTransfer.select1");
	
		System.out.println("\n selectData1 \n");
		System.out.println("count : " + count);
	
	}
	
	public void selectData2() {
		System.out.println("\n selectData2 \n");
		List<ProductDto> productList = sqlSession.selectList("dataTransfer.select2");
		for (ProductDto productDto : productList) {
			System.out.println(productDto);
		}
	}
	
	public void selectData3() {
		System.out.println("\n selectData3 \n");
		List<Map<String,Object>> productList = sqlSession.selectList("dataTransfer.select3");
		for (Map<String, Object> map : productList) {
			System.out.println(map);
		}
	}
	
	public void selectData4() {
		System.out.println("\n selectData4 \n");
		List<Map<String,Object>> productList = sqlSession.selectList("dataTransfer.select4");
		for (Map<String, Object> map : productList) {
			System.out.println(map);
		}
		
	}
	
	public void selectData5() {
		System.out.println("\n selectData5 \n");
		List<Map<String,Object>> productList = sqlSession.selectList("dataTransfer.select5");
		for (Map<String, Object> map : productList) {
			System.out.println(map);
		}
	}
	
	
	/*
	 * 
	 * # Dao To Mapper
	 * 
	 *  - 2개 이상의 파라미터를 Mapper로 전달할 수 없고 오직 1개의 파라미터만 전송이 가능하다.
	 *  - 2개 이상의 데이터는 Dto , Map형식으로 전송한다.
	 *  - 전송되는 복수의 데이터가 Dto의 멤버로 포함되어 있으면 일반적으로 Dto 전송 방식을 사용하고
	 *    전송되는 복수의 데이터가 Dto의 멤버에 포함되어 있지 않은 경우 Map 전송 방식을 사용한다.
	 * 
	 * */
	
	// 예시 1) 단일 데이터 전송
	public void memberInfo(String memberId) {
		MemberDto memberDto = sqlSession.selectOne("dataTransfer.memberInfo" , memberId);
		System.out.println(memberDto);
		//MemberDto [memberId=user7, memberName=스티븐워즈니악, 
		//memberGender=m, hp=010-7777-7777, email=stevenw@gmail.com, residence=경기]
	}
	
	// 예시 2) DTO 전송
	public void insertProduct(ProductDto productDto) {
		sqlSession.insert("dataTransfer.addProduct" , productDto); 
	}
	
	// 예시 3) Map 전송
	public void searchData1(Map<String, Object> orderMap ) {
		
		System.out.println("\n searchData1 \n");
		List<OrderDto> orderList = sqlSession.selectList("dataTransfer.searchData1" , orderMap);
		for (OrderDto orderDto : orderList) {
			System.out.println(orderDto);
			
//OrderDto [orderCode=order4, memberId=user5, productCode=product8, orderGoodsQty=2, deliveryMessage=배송전 연락 주세요., deliveryState=배송중, orderDate=Thu Apr 11 09:00:00 KST 2019]
//OrderDto [orderCode=order5, memberId=user6, productCode=product2, orderGoodsQty=2, deliveryMessage=배송전 연락 주세요., deliveryState=배송준비중, orderDate=Thu May 30 09:00:00 KST 2019]
//OrderDto [orderCode=order6, memberId=user3, productCode=product1, orderGoodsQty=1, deliveryMessage=배송전 연락 주세요., deliveryState=배송준비중, orderDate=Sat Jun 01 09:00:00 KST 2019]
//OrderDto [orderCode=order7, memberId=user2, productCode=product2, orderGoodsQty=2, deliveryMessage=배송전 연락 주세요., deliveryState=배송준비중, orderDate=Fri Jul 12 09:00:00 KST 2019]
//OrderDto [orderCode=order9, memberId=user9, productCode=product2, orderGoodsQty=2, deliveryMessage=문 앞에 놓고 벨 눌러주세요., deliveryState=배송중, orderDate=Tue Jan 07 09:00:00 KST 2020]

		}
		
	}
	
	public void searchData2(Map<String, Object> orderMap) {
		
		System.out.println("\n searchData2 \n");
		List<Map<String,Object>> orderList = sqlSession.selectList("dataTransfer.searchData2" , orderMap);
		for (Map<String, Object> map : orderList) {
			System.out.println(map);
		}
		
	}
	
	
	public void searchData3(Map<String, Object> orderMap) {
		
		System.out.println("\n searchData3 \n");
		int sumOrderGoodsQty = sqlSession.selectOne("dataTransfer.searchData3" , orderMap);
		System.out.println(sumOrderGoodsQty);
		
		// searchData3 
			//49
	}
	
}









