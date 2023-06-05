package com.frame.dao;

import java.util.List;
import com.frame.business.entity.Status;

public interface StatusDao {

	List<Status> getLoadStatusList();

	Status searchStatusById(int parseInt);

	Status searchStatusByStatusName(String description);
	
}
