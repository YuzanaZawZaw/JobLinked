package com.frame.business.entity;

import com.frame.business.entity.base.BasePartyGroupPosition;



public class PartyGroupPosition extends BasePartyGroupPosition {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public PartyGroupPosition () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public PartyGroupPosition (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public PartyGroupPosition (
		java.lang.Integer id,
		com.frame.business.entity.PartyGroup partyGroup,
		com.frame.business.entity.PartyGroupPositionType partyGroupPositionType) {

		super (
			id,
			partyGroup,
			partyGroupPositionType);
	}

/*[CONSTRUCTOR MARKER END]*/


}