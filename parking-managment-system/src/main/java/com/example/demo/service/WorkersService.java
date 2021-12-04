package com.example.demo.service;

import java.util.List;
import com.example.demo.model.WorkerDetails;

public interface WorkersService {
	List<WorkerDetails> getAllWorkerDetailss();
	void saveWorkerDetails(WorkerDetails workerDetails);
	void deleteWorkerById(String Name);
}



	
	
	
