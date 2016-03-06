package house.domain.mapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.alibaba.fastjson.JSON;

import house.domain.PropertyDailySigned;
import house.domain.PropertyHouseSaleState;
import house.domain.mapper.PropertyHouseSaleStateMapper;

public class PropertyHouseSaleStateMapperTest {

	static SqlSessionFactory sqlSessionFactory;

	public static void testQueryHouseSaleStateByPropertyIdAndStateChangeTime() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 创建Usermapper对象，mybatis自动生成mapper代理对象
		PropertyHouseSaleStateMapper mapper = sqlSession.getMapper(PropertyHouseSaleStateMapper.class);

		// Map<String,String> argments=new HashMap<String,String>();
		// argments.put("district", district);
		// argments.put("signedDate", signedDate);

		String propertyId = "64897079";

		String stateChangeTimeBegin ="2016-03-04 00:00:00";
		String stateChangeTimeEnd   ="2016-03-05 24:00:00";
		List<PropertyHouseSaleState> propertyHouseSaleStates = mapper.queryHouseSaleStateByPropertyIdAndStateChangeTime(propertyId, stateChangeTimeBegin,
				stateChangeTimeEnd);
		System.out.println(JSON.toJSONString(propertyHouseSaleStates, true));

		System.out.println(propertyHouseSaleStates.size());

		sqlSession.close();
	}

	public static void main(String[] args) throws IOException {

		String resource = "mybatis/mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 创建SqlSessionFcatory
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		testQueryHouseSaleStateByPropertyIdAndStateChangeTime();
	}
}
