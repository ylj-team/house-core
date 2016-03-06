package house.domain.mapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.alibaba.fastjson.JSON;

import house.domain.UserSubscribedProperty;

public class UserSubscribedPropertyMapperTest {
	static SqlSessionFactory  sqlSessionFactory ;
	public static void testQuerySubscriptionOfAccount() {
		 SqlSession sqlSession = sqlSessionFactory.openSession();
	        // 创建Usermapper对象，mybatis自动生成mapper代理对象
		 UserSubscribedPropertyMapper mapper = sqlSession.getMapper(UserSubscribedPropertyMapper.class);
		 String account = "test";

		 
		 List<UserSubscribedProperty> subscribtions= mapper.querySubscriptionOfAccount(account);
		 System.out.println(JSON.toJSONString(subscribtions, true));
		 System.out.println(subscribtions.size());
	     sqlSession.close();
	}
	
	public static void testInsertSubscriptions() {
		 SqlSession sqlSession = sqlSessionFactory.openSession();
	        // 创建Usermapper对象，mybatis自动生成mapper代理对象
		 UserSubscribedPropertyMapper mapper = sqlSession.getMapper(UserSubscribedPropertyMapper.class);
	//	 String account = "yanglujuncc@gmail.com";

		 
		 List<UserSubscribedProperty> subscribtions= new LinkedList<UserSubscribedProperty>();
		 
		 UserSubscribedProperty aUserSubscribedProperty=new UserSubscribedProperty();
		 aUserSubscribedProperty.account="test";
		 aUserSubscribedProperty.propertyId="test";
		 aUserSubscribedProperty.propertyName="test";
		 aUserSubscribedProperty.subscriptTime=System.currentTimeMillis();
		 
		 
		 UserSubscribedProperty bUserSubscribedProperty=new UserSubscribedProperty();
		 bUserSubscribedProperty.account="test";
		 bUserSubscribedProperty.propertyId="test2";
		 bUserSubscribedProperty.propertyName="test2";
		 bUserSubscribedProperty.subscriptTime=System.currentTimeMillis();
		 
		 
		 subscribtions.add(aUserSubscribedProperty);
		 subscribtions.add(bUserSubscribedProperty);
		 
		 mapper.insertSubscriptions(subscribtions);
		
		 System.out.println(JSON.toJSONString(subscribtions, true));
		 System.out.println(subscribtions.size());
	     sqlSession.close();
	}
	
	public static void testDeleteSubscriptions() {
		 SqlSession sqlSession = sqlSessionFactory.openSession();
	        // 创建Usermapper对象，mybatis自动生成mapper代理对象
		 UserSubscribedPropertyMapper mapper = sqlSession.getMapper(UserSubscribedPropertyMapper.class);
		 String account = "test";
		 String propertyId="test";
		 mapper.deleteSubscriptions(account, propertyId);
	     sqlSession.close();
	}
	
public static void main(String[] args) throws IOException{
		
	    String resource = "mybatis/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 创建SqlSessionFcatory
          sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);    
        
          
        //  testInsertSubscriptions();
          testQuerySubscriptionOfAccount();
          testDeleteSubscriptions() ;
          testQuerySubscriptionOfAccount();
          
	}
}
