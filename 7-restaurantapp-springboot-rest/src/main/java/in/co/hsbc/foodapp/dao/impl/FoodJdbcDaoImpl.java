package in.co.hsbc.foodapp.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PreDestroy;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import in.co.hsbc.foodapp.dao.FoodDao;
import in.co.hsbc.foodapp.model.FoodItem;

@Repository("dao")
public class FoodJdbcDaoImpl implements FoodDao{

	@Autowired
	private JdbcTemplate jt;
	
	@Value("${food.selectAll.query}")
	private String selectAllQuery;

	@Value("${food.insert.query}")
	private String insertFoodQuery;

	@Value("${food.delete.query}")
	private String deleteFoodQuery;
	
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
	
	//RowMapper is built-in interface 
	//given by Spring Jdbc
	//mapRow() is automatically invoked by spring
	class FoodItemRowMapper implements RowMapper<FoodItem>
	{
		@Override
		public FoodItem mapRow(ResultSet rs, int rowNum) throws SQLException {
			FoodItem f = new FoodItem(rs.getInt(1), 
									  rs.getString(2),
									  rs.getDouble(3));
			return f;
		}		
	}
	
	@Override
	public List<FoodItem> findAll() {
		
		//Prequery
		//firing query
		//postquery
	List<FoodItem> foods = jt.query(selectAllQuery, 
									new FoodItemRowMapper());		
		return foods;
	}

	@Override
	public FoodItem save(FoodItem food) {
		jt.update(insertFoodQuery, 
				food.getId(),food.getItem(),food.getPrice());
		return food;
	}
	
	@Override
	public void deleteById(int id) {
		jt.update(deleteFoodQuery, id);
	}
}










