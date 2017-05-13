package com.services;
import java.util.*;
import com.models.*;

public interface QuestionService {

	   List<Question> findAll(String gamename);
	   Question findByName(String name);
	   void add (Question question);
	}

