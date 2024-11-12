package com.main.test;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.main.entity.Doctor;
import com.main.entity.Patient;
import com.main.service.IDoctorAndPatientService;


@Component
public class TestApp implements CommandLineRunner {
	
	@Autowired
	IDoctorAndPatientService doctorAndPatientService;

	@Override
	public void run(String... args) throws Exception {
       
		Doctor doc = new Doctor();
		doc.setAddress("Bangalore");
		doc.setDepartment("IPD");
		doc.setDname("Sunil Berma");
		doc.setSalary(500000d);
		doc.setSpecialization("Brain Surgery");
		 //Patients info
		Patient p1 = new Patient();
		p1.setAddress("Bhadrak");
		p1.setDateOfBirth(LocalDateTime.of(2007, 5, 10, 12, 10));
		p1.setEmail("saroj@gmail.com");
		p1.setFirstName("Saroj");
		p1.setLastName("Jena");
		p1.setGender("Male");
		p1.setMobileNo(6993888833l);
		
		Patient p2 = new Patient();
		p2.setAddress("Jajpur");
		p2.setDateOfBirth(LocalDateTime.of(2012, 7, 10, 12, 10));
		p2.setEmail("anita@gmail.com");
		p2.setFirstName("Anita");
		p2.setLastName("Naidu");
		p2.setGender("Female");
		p2.setMobileNo(883899333l);
		 
		Set<Patient> patients = Set.of(p1,p2);
		doc.setPatients(patients);
		
		String res1 = doctorAndPatientService.addNewDoctorWithPatients(doc);
		System.out.println(res1);
		
		//Fetch all doctor and its associated all patient records
		/*List<Doctor> doctors =  doctorAndPatientService.fetchAllDoctors();
		doctors.forEach(doc->{
			   System.out.println("Doctor Details");
			   System.out.println("**************************************************");
			   System.out.println("Doctor ID:: " + doc.getDocID()+"Doctor Name::"+doc.getDname());
			
			Set<Patient> patients = doc.getPatients();
			patients.forEach(p->{
				System.out.println("Patient Details");
				System.out.println("**************************************************");
				System.out.println(p.getFirstName()+" "+p.getLastName()+" "+p.getGender()+" "+p.getPatientID());
			});
	    });*/
		//Remove doctor with associated patient records
		/*String res2 = doctorAndPatientService.removeDoctorWithItsPatients(50000);
		System.out.println(res2);*/
		
		//Remove only patient record
		/*String res3 = doctorAndPatientService.removePatientById(103);
		System.out.println(res3);*/
	}
}
		
		

	

