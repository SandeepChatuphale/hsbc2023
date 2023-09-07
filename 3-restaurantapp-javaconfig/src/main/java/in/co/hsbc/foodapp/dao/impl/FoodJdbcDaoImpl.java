package in.co.hsbc.foodapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PreDestroy;
import javax.sql.DataSource;
import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import in.co.hsbc.foodapp.dao.FoodDao;
import in.co.hsbc.foodapp.model.FoodItem;

@Repository
public class FoodJdbcDaoImpl implements FoodDao{

	@Autowired
	private DataSource dataSource;
	
	@Value("${food.selectAll.query}")
	private String selectAllQuery;
	
//	@Override
//	public List<FoodItem> findAll() {
//		
//		//Prequery
//		//firing query
//		//postquery
//		
//		List<FoodItem> foods = new ArrayList<>();
//		Connection con = dataSource.getConnection();
//		PreparedStatement pstmt = con.prepareStatement(selectAllQuery);
//		
//		ResultSet resultSet = pstmt.executeQuery();
//		
//		while(resultSet.next())
//		{
//			FoodItem f = new FoodItem(resultSet.getInt(1),
//					resultSet.getString(2), 
//					resultSet.getDouble(3));
//			foods.add(f);
//		}
//			
//		return foods;
//	}
	
	@Override
	public List<FoodItem> findAll() {
		
		//Prequery
		//firing query
		//postquery
		JdbcTemplate jt = new JdbcTemplate(dataSource);
		List<FoodItem> foods = jt.query(selectAllQuery, null);
		
		return foods;
	}

	@PreDestroy
	public void close()
	{
		
	}
	
}
