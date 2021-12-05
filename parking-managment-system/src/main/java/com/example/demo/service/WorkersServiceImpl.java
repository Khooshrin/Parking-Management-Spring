package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.BookingDetails;
import com.example.demo.model.WorkerDetails;
import com.example.demo.repository.WorkersRepository;


@Service
public class WorkersServiceImpl implements WorkersService{

	@Autowired
	private WorkersRepository workersRepository;
	@Override
	public List<WorkerDetails> getAllWorkerDetailss() {
		return workersRepository.findAll();
	}
	
	@Override
	public void saveWorkerDetails(WorkerDetails workerDetails) {
		this.workersRepository.save(workerDetails);
		
	}

	@Override
	public void deleteWorkerById(String Name) {
		this.workersRepository.deleteById(Name);
	}
	
	@Override
	public WorkerDetails getWorkerDetailsById(String Name) {
		Optional<WorkerDetails> optional=workersRepository.findById(Name);
		WorkerDetails workerDetails=null;
		if(optional.isPresent())
			workerDetails=optional.get();
		else
			throw new RuntimeException("Booking Details Not Found for Name :: "+Name);
		return workerDetails;
	}

	
}
