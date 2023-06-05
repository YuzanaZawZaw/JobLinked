package com.frame.dao;

import java.util.List;

import com.frame.business.entity.PartyGroup;
/**
*
* @author Yuzana Zaw Zaw
*/
public interface PartyGroupDao {

	void savePartyGroup(PartyGroup partyGroup);

	List<PartyGroup> getLoadPartyGroupList();

	void deletePartyGroup(PartyGroup st);

	PartyGroup searchPartyGroupById(Integer partyGroupId);

}
