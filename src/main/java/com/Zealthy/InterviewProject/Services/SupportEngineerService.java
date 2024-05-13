package com.Zealthy.InterviewProject.Services;

import com.Zealthy.InterviewProject.Models.SupportEngineer;
import com.Zealthy.InterviewProject.Repositories.SupportEngineerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupportEngineerService {

    private final SupportEngineerRepository supportEngineerRepository;

    @Autowired
    public SupportEngineerService(SupportEngineerRepository supportEngineerRepository) {
        this.supportEngineerRepository = supportEngineerRepository;
    }

    public List<SupportEngineer> getAllSupportEngineers() {
        return supportEngineerRepository.findAll();
    }

    public Optional<SupportEngineer> getSupportEngineerById(Integer employeeId) {
        return supportEngineerRepository.findByEmployeeId(employeeId);
    }
}
