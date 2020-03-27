package com.sahm.scheduler.model.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.sahm.scheduler.model.entity.DtLessonTime;

public interface DtLessonTimeRepository extends CrudRepository<DtLessonTime, Integer>{

	List<DtLessonTime> findByDilessonid(int dilessonid);
	List<DtLessonTime> findAll();
}
