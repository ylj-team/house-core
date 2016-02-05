package house.domain.mapper;

import java.io.IOException;
import java.io.InputStream;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.alibaba.fastjson.JSON;

import house.domain.Property;
import house.domain.mapper.PropertyMapper;



public class PropertyMapperTest {

	public static void main(String[] args) throws IOException{
		
	    String resource = "mybatis/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 创建SqlSessionFcatory
        SqlSessionFactory  sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);    
        
		 SqlSession sqlSession = sqlSessionFactory.openSession();
	        // 创建Usermapper对象，mybatis自动生成mapper代理对象
		 PropertyMapper mapper = sqlSession.getMapper(PropertyMapper.class);
		 
		 String propertyId="126135188";
		 Property property= mapper.queryPropertyByPropertyId(propertyId);
		 System.out.println(JSON.toJSONString(property, true));
	     sqlSession.close();
	}
}
