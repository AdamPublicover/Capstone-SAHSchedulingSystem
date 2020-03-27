package com.sahm.scheduler.model.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.sahm.scheduler.model.entity.DtLesson;

public interface DtLessonRepository extends CrudRepository<DtLesson, Integer>{

	List<DtLesson> findByDsteacheremail( String dsteacheremail );
	List<DtLesson> findByDsparentemail( String dsparentemail );
	DtLesson findTopByOrderByLessonidDesc();
}
