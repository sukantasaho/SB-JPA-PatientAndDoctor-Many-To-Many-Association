package com.main.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.main.entity.Patient;

public interface IPatientRepo extends JpaRepository<Patient, Integer>{

}
