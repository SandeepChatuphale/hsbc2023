package in.co.hsbc.foodapp.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan("in.co.hsbc.foodapp")

//This is to tell name and location of property file
@PropertySource("classpath:application.properties")
public class RestaurantApplicationConfiguration {

	@Value("${spring.datasource.driver-class-name}")
	private String driverClassname;
	
	@Value("${spring.datasource.url}")
	private String url;
	
	@Value("${spring.datasource.username}")
	private String username;
	
	@Value("${spring.datasource.password}")
	private String password;
	
	
	
	
	//@Bean is used to register object of class as spring bean
	//Use case is - when we have third party class
				//(We don't have source code)
	//@Bean("ds") - here id is ds
	@Bean() //here id is methodName
	public DataSource getDataSource()
	{
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName(driverClassname);		
		ds.setUrl(url);
		ds.setUsername(username);
		ds.setPassword(password);
		return ds;
	}
	
	
	
}




