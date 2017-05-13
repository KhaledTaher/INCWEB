package com.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.models.Progress;
import com.models.ProgressComposite;

public interface ProgressRepository extends CrudRepository<Progress, ProgressComposite> {
	List<Progress> findByStudentUsername(String username);
}
