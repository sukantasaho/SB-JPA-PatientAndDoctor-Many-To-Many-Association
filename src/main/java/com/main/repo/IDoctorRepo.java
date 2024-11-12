package com.main.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.main.entity.Doctor;

public interface IDoctorRepo extends JpaRepository<Doctor, Integer> {

}
