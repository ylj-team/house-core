package house.domain.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import house.domain.UserSubscribedProperty;

public interface UserSubscribedPropertyMapper {

	public List<UserSubscribedProperty> querySubscriptionOfAccount(@Param("account") String account);
	
	public void insertSubscriptions(List<UserSubscribedProperty> subscriptions);
	
	public void deleteSubscriptions(@Param("account") String account,@Param("propertyId") String propertyId);
}
