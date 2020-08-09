package com.rupali.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rupali.entities.SsnMasterEntity;
import com.rupali.model.SsnEnrollmentRequest;
import com.rupali.repository.SsnMasterRepository;
import com.rupali.repository.StatesMasterRepository;


@Service
public class SsaServiceImpl implements SsaService {

	@Autowired
	private StatesMasterRepository statesRepo;
	@Autowired
	private SsnMasterRepository ssnRepo;
	
	@Override
	public List<String> getAllStateNames(){
		return statesRepo.findStateNames();
	}
		@Override
		public Long ssnEnrollment(SsnEnrollmentRequest req) {
		  SsnMasterEntity entity = new SsnMasterEntity();
		  BeanUtils.copyProperties(req, entity);
			
		  SsnMasterEntity savedEntity= new SsnMasterEntity();
		  if(savedEntity!=null) {
			  return savedEntity.getSsn();
		  }
			return null;	
		}
		@Override
		public String checkEnrollment(Long ssn, String stateName) {
			SsnMasterEntity entity= ssnRepo.findBySsnAndStateName(ssn, stateName);
			if(entity!=null) {
				return "VALID";
			}
			return "IN-VALID";
		}
	}
	
