package com.services;

import java.util.List;

import com.models.Progress;

public interface ProgressService {

	void addProgress(int score, String username, String gameName);

	List<Progress> showProgress(String username);

}
