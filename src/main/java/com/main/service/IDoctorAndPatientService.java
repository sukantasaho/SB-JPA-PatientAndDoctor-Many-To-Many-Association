package com.main.service;

import java.util.List;

import com.main.entity.Doctor;

public interface IDoctorAndPatientService {
   public String addNewDoctorWithPatients(Doctor doctor);
   public List<Doctor> fetchAllDoctors();
   public String removeDoctorWithItsPatients(Integer docId);
   public String removePatientById(Integer patientId);
}
