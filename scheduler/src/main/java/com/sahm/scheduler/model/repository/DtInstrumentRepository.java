package com.sahm.scheduler.model.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import com.sahm.scheduler.model.entity.DtInstrument;

public interface DtInstrumentRepository extends CrudRepository<DtInstrument, Integer>{
	DtInstrument findByInstrument(String Instrument);
	
	DtInstrument findByInstrumentid(int instrumentid);
}
