package house.domain.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import house.domain.PropertyDailySigned;

public interface PropertyDailySignedMapper {
	public List<PropertyDailySigned> queryPropertyDailySignedByDate(@Param("signedDate")String signedDate);
	public List<PropertyDailySigned> queryPropertyDailySignedByDatePropertyId(@Param("signedDate")String signedDate,@Param("propertyId")String propertyId);
	public List<PropertyDailySigned> queryPropertyDailySignedByDateDistrict(@Param("signedDate")String signedDate,@Param("district")String district);
}
