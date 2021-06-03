package network_exam.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("network_exam.mapper")
public class ContextSqlSession {
	
	@Autowired
	ApplicationContext applicationContext;	
	
	@Bean
	public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource) throws Exception {
	SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
	factoryBean.setDataSource(dataSource);
	factoryBean.setConfigLocation(applicationContext.getResource("classpath:/mybatis_config.xml"));
	//첫 테스트할때는 주석
	factoryBean.setMapperLocations(applicationContext.getResources("classpath:mappers/*Mapper.xml"));
	return factoryBean;
	}
	
	@Bean
	public SqlSessionTemplate sqlSession(SqlSessionFactory sqlSessionFactory) {
	return new SqlSessionTemplate(sqlSessionFactory);
	}
	
}
