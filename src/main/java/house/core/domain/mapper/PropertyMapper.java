package house.domain.mapper;

import org.apache.ibatis.annotations.Param;

import house.domain.Property;

public interface PropertyMapper {

	public 	Property queryPropertyByPropertyId(@Param("propertyId") String propertyId);
}
