package com.services;

import org.springframework.stereotype.Service;

@Service
public class LoginServiceStubImp implements LoginService {

	private String currentUserID;

	@Override
	public String getCurrentUserID() {
		return currentUserID;
	}

	@Override
	public void setCurrentUserID(String currentUserID) {
		this.currentUserID = currentUserID;
	}

}
