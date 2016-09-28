package house.domain.mapper;

import org.apache.ibatis.annotations.Param;

import house.domain.User;

public interface UserMapper {

	public User queryUserByAccount(@Param("account") String account);
	
}
