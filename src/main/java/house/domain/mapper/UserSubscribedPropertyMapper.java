package house.domain.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import house.domain.UserSubscribedProperty;

public interface UserSubscribedPropertyMapper {

	public List<UserSubscribedProperty> querySubscriptOfAccount(@Param("account") String account);
}
