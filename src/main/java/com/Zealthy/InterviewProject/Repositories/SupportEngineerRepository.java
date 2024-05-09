package com.Zealthy.InterviewProject.Repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.Zealthy.InterviewProject.Models.SupportEngineer;

public interface SupportEngineerRepository extends MongoRepository<SupportEngineer,Integer>{
    
}
