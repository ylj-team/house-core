package house.domain.mapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.alibaba.fastjson.JSON;

import house.domain.UserSubscribedProperty;

public class UserSubscribedPropertyMapperTest {
public static void main(String[] args) throws IOException{
		
	    String resource = "mybatis/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 创建SqlSessionFcatory
        SqlSessionFactory  sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);    
        
		 SqlSession sqlSession = sqlSessionFactory.openSession();
	        // 创建Usermapper对象，mybatis自动生成mapper代理对象
		 UserSubscribedPropertyMapper mapper = sqlSession.getMapper(UserSubscribedPropertyMapper.class);
		 String account = "yanglujuncc@gmail.com";

		 
		 List<UserSubscribedProperty> subscribtions= mapper.querySubscriptOfAccount(account);
		 System.out.println(JSON.toJSONString(subscribtions, true));
		 System.out.println(subscribtions.size());
	     sqlSession.close();
	}
}
