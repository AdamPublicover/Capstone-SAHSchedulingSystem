package com.sahm.scheduler.model.repository;

import org.springframework.data.repository.CrudRepository;
import com.sahm.scheduler.model.entity.DtTeacher;

public interface DtTeacherRepository extends CrudRepository<DtTeacher, Integer>{
	
	DtTeacher findByDsEmail(String DsEmail);
	
	
}
