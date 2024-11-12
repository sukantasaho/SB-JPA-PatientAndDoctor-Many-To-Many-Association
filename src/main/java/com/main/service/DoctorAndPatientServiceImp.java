package com.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.main.entity.Doctor;
import com.main.repo.IDoctorRepo;
import com.main.repo.IPatientRepo;

@Service
public class DoctorAndPatientServiceImp implements IDoctorAndPatientService {

	@Autowired
	private IDoctorRepo doctorRepo;
	@Autowired
	private IPatientRepo patientRepo;
	
	@Override
	public String addNewDoctorWithPatients(Doctor doctor) {
		doctorRepo.save(doctor);
		return "Doctor With associated patient records are saved successfully";
	}

	@Override
	public List<Doctor> fetchAllDoctors() {  
		return doctorRepo.findAll();
	}

	@Override
	public String removeDoctorWithItsPatients(Integer docId) {
		boolean isFound =  doctorRepo.existsById(docId);
		String message = null;
		if(isFound) {
			doctorRepo.deleteById(docId);
			message = "Doctor and associated patient records deleted successfully completed";
		}
		else
			message = "Sorry we are not found doctor with associated patient records";
		return message;
	}

	@Override
	public String removePatientById(Integer patientId) {
		 boolean isPatientFound = patientRepo.existsById(patientId);
		 String message = null;
		 if(isPatientFound) {
			 patientRepo.deleteById(patientId);
			 message = "Patient records is deleted successfully completed";
		 }
		 else
			 message = "Patient record not found";
		return message;
	}
    
	 

}
