package com.Zealthy.InterviewProject.Repositories;

import com.Zealthy.InterviewProject.Models.SupportEngineer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface SupportEngineerRepository extends MongoRepository<SupportEngineer, Integer> {
    Optional<SupportEngineer> findByEmployeeId(Integer employeeId);
}
