package com.frame.dao;

import java.util.List;
import com.frame.business.entity.PartyGroupPositionType;

/**
*
* @author Yuzana Zaw Zaw
*/
public interface PositionTypeDao {

	void savePartyGroupPositionType(PartyGroupPositionType positionTypeId);

	List<PartyGroupPositionType> getLoadPartyGroupPositionTypeList();

	void deletePartyGroupPositionType(PartyGroupPositionType st);

	PartyGroupPositionType searchPartyGroupPositionTypeById(Integer positionTypeId);

	
}
