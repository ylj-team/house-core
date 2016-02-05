package house.domain.mapper;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.alibaba.fastjson.JSON;

import house.domain.PropertyDailySigned;
import house.domain.mapper.PropertyDailySignedMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class PropertyDailySignedMapperTest {
	
	static	SqlSessionFactory  sqlSessionFactory;
	public static void testQueryPropertyDailySignedByDate(){
		 SqlSession sqlSession = sqlSessionFactory.openSession();
	        // 创建Usermapper对象，mybatis自动生成mapper代理对象
		 PropertyDailySignedMapper mapper = sqlSession.getMapper(PropertyDailySignedMapper.class);
		 
		 String signedDate="2016-01-31";
		 List<PropertyDailySigned> propertyDailySigneds= mapper.queryPropertyDailySignedByDate(signedDate);
		 System.out.println(JSON.toJSONString(propertyDailySigneds, true));
		 
		 
		 String district="余杭";
		 
		// Map<String,String> argments=new HashMap<String,String>();
	//	 argments.put("district", district);
		// argments.put("signedDate", signedDate);
			
		 List<PropertyDailySigned> districtPropertyDailySigneds=  mapper.queryPropertyDailySignedByDateDistrict(signedDate, district);
		 System.out.println(JSON.toJSONString(districtPropertyDailySigneds, true));
			
		 System.out.println(propertyDailySigneds.size());
		 System.out.println(districtPropertyDailySigneds.size());
			
		 
		 
	     sqlSession.close();
	}
	
	public static void testQueryPropertyDailySignedByDateDistrict(){
		
		 SqlSession sqlSession = sqlSessionFactory.openSession();
	        // 创建Usermapper对象，mybatis自动生成mapper代理对象
		 PropertyDailySignedMapper mapper = sqlSession.getMapper(PropertyDailySignedMapper.class);
		 
		 String signedDate="2016-01-31";
		 
		 String district="余杭";
		 
		// Map<String,String> argments=new HashMap<String,String>();
	//	 argments.put("district", district);
		// argments.put("signedDate", signedDate);
			
		 List<PropertyDailySigned> districtPropertyDailySigneds=  mapper.queryPropertyDailySignedByDateDistrict(signedDate, district);
		 System.out.println(JSON.toJSONString(districtPropertyDailySigneds, true));

		 System.out.println(districtPropertyDailySigneds.size());
	
		 
	     sqlSession.close();
	}
	public static void testQueryPropertyDailySignedByDatePropertyId(){
		
		 SqlSession sqlSession = sqlSessionFactory.openSession();
	        // 创建Usermapper对象，mybatis自动生成mapper代理对象
		 PropertyDailySignedMapper mapper = sqlSession.getMapper(PropertyDailySignedMapper.class);
		 
		 String signedDate="2016-01-31";	 
		 String propertyId="64897079";
		 
		// Map<String,String> argments=new HashMap<String,String>();
	//	 argments.put("district", district);
		// argments.put("signedDate", signedDate);
			
		 List<PropertyDailySigned> districtPropertyDailySigneds=  mapper.queryPropertyDailySignedByDatePropertyId(signedDate, propertyId);
		 System.out.println(JSON.toJSONString(districtPropertyDailySigneds, true));

		 System.out.println(districtPropertyDailySigneds.size());
	
		 
	     sqlSession.close();
	}
	
	
	
		
	
public static void main(String[] args) throws IOException{
		
	    String resource = "mybatis/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 创建SqlSessionFcatory
          sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);    
          testQueryPropertyDailySignedByDateDistrict();
         // testQueryPropertyDailySignedByDatePropertyId();
	}
}
