package com.sahm.scheduler.model.repository;

import org.springframework.data.repository.CrudRepository;
import com.sahm.scheduler.model.entity.DtParent;
import com.sahm.scheduler.model.entity.DtTeacher;

public interface DtParentRepository extends CrudRepository<DtParent, Integer>{

	DtParent findByDsEmail(String DsEmail);
}
