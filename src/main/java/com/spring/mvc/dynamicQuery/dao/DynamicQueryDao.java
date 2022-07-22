package com.spring.mvc.dynamicQuery.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.mvc.dataTransfer.dto.ProductDto;

@Repository
public class DynamicQueryDao {

	@Autowired
	private SqlSession sqlSession;
	
	public List<Map<String,Object>> selectOrderList(){
		return sqlSession.selectList("dynamicQuery.list");
	}
	
	public List<Map<String,Object>> ifEx(Map<String,String> searchMap){
		return sqlSession.selectList("dynamicQuery.ifEx" , searchMap);
	}
	
	public List<Map<String,Object>> chooseEx01(Map<String,String> searchMap){
		return sqlSession.selectList("dynamicQuery.chooseEx01" , searchMap);
	}
	
	public List<Map<String,Object>> chooseEx02(String deliveryState){
		return sqlSession.selectList("dynamicQuery.chooseEx02" , deliveryState);
	}
	
	public void foreachEx01(List<ProductDto> productList) {
		sqlSession.insert("dynamicQuery.foreachEx01", productList);
	}
	
	public List<Map<String,Object>> foreachEx02(String[] memberIdList){
		return sqlSession.selectList("dynamicQuery.foreachEx02" , memberIdList);
	}
	
	
}




