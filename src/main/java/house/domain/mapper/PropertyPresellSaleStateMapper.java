package house.domain.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import house.domain.PropertyPresellSaleState;

public interface PropertyPresellSaleStateMapper {
	
	
	public List<PropertyPresellSaleState> queryPresellSaleStateByPropertyIdAndStateChangeTime(@Param("propertyId")String propertyId,@Param("presellId")String presellId,@Param("stateChangeTimeBegin")String stateChangeTimeBegin,@Param("stateChangeTimeEnd")String stateChangeTimeEnd);

}
