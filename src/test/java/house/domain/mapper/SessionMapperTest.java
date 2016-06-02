package house.domain.mapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.alibaba.fastjson.JSON;

import house.domain.Property;

public class SessionMapperTest {
public static void main(String[] args) throws IOException{
		
	    String resource = "mybatis/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 创建SqlSessionFcatory
        SqlSessionFactory  sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);    
        
		 SqlSession sqlSession = sqlSessionFactory.openSession();
	        // 创建Usermapper对象，mybatis自动生成mapper代理对象
		 SessionMapper mapper = sqlSession.getMapper(SessionMapper.class);
		 String sessionId="123456";
		 String varName="name_vvv";
		 byte[] varValue="hello2".getBytes();
		 
		// mapper.setSessionVar(sessionId, varName, varValue);
		// sqlSession.commit(true);
		// byte[] varValue2=mapper.getSessionVar(sessionId, varName);
		// System.out.println(new String(varValue2));
		 Map<String, byte[]> vars= mapper.getSession(sessionId);
		 System.out.println(vars.size());
		 for(Entry<String, byte[]> entry:vars.entrySet()){
			 System.out.println(entry.getKey()+":"+entry.getValue());
		 }
	
	}
}
