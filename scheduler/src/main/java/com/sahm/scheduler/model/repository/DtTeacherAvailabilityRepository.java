package com.sahm.scheduler.model.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sahm.scheduler.model.entity.DtTeacherAvailability;

public interface DtTeacherAvailabilityRepository extends CrudRepository<DtTeacherAvailability, Integer>{
	List<DtTeacherAvailability> findByDsteacheremail(String dsteacheremail);
}
