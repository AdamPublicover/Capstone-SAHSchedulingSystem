package com.sahm.scheduler.model.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import com.sahm.scheduler.model.entity.DtPassword;

public interface DtPasswordRepository extends CrudRepository<DtPassword, Integer>{
	
	DtPassword findByEmail(String email);
	
}
