package com.frame.dao;

import java.util.List;

import com.frame.business.entity.PartyGroup;
import com.frame.business.entity.PartyGroupPosition;
import com.frame.business.entity.PartyGroupPositionType;
/**
*
* @author Yuzana Zaw Zaw
*/
public interface PartyGroupPositionDao {

	void savePartyGroupPosition(PartyGroupPosition partyGroupPositionId);

	List<PartyGroupPosition> getLoadPartyGroupPositionList();

	void deletePartyGroupPosition(PartyGroupPosition st);

	PartyGroupPosition searchPartyGroupPositionById(Integer partyGroupPositionId);

	PartyGroupPosition searchPartyGroupPositionByName(String string);

	List<PartyGroupPosition> getLoadPositionListByRecCompany(
			Integer id);

	List<PartyGroupPosition> getPartyGroupPositionListByPositionType(
			PartyGroupPositionType positionType);

	List<PartyGroupPosition> getPartyGroupPositionListByPartyGroup(
			PartyGroup partyGroup);

	PartyGroupPosition getPositionByPositionTypeAndCompanyName(
			PartyGroupPositionType positionType, PartyGroup partyGroup);


}
