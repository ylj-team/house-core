package house.domain.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import house.domain.PropertyHouseSaleState;

public interface PropertyHouseSaleStateMapper {
	
	public List<PropertyHouseSaleState> queryHouseSaleStateByPropertyIdAndStateChangeTime(@Param("propertyId")String propertyId,@Param("stateChangeTimeBegin")String stateChangeTimeBegin,@Param("stateChangeTimeEnd")String stateChangeTimeEnd);

}