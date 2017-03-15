package com.persons.service;

import com.common.service.BaseService;
import com.persons.model.Rasmessage;

public interface RasmessageService extends BaseService<Rasmessage> {
 
	public String getMessg(int id);
}
