package house.domain.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Param;



public interface SessionMapper {

	public void setSession(@Param("sessionId") String sessionId,@Param("vars")Map<String,byte[]> vars);
	public Map<String,byte[]> querySession(@Param("sessionId") String sessionId);	
	public int deleteSession(@Param("sessionId") String sessionId);
	
	public void setSessionVar(@Param("sessionId") String sessionId,@Param("varName") String varName,@Param("varValue") byte[] varValue);
	public byte[] querySessionVar(@Param("sessionId") String sessionId,@Param("varName") String varName);
	public int deleteSessionVar(@Param("sessionId") String sessionId,@Param("varName") String varName);
	
}
