package com.Zealthy.InterviewProject.Controller;

import com.Zealthy.InterviewProject.Models.SupportEngineer;
import com.Zealthy.InterviewProject.Services.SupportEngineerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/support-engineers")
public class SupportEngineerController {

    private final SupportEngineerService supportEngineerService;

    @Autowired
    public SupportEngineerController(SupportEngineerService supportEngineerService) {
        this.supportEngineerService = supportEngineerService;
    }

    @GetMapping
    public ResponseEntity<List<SupportEngineer>> getAllSupportEngineers() {
        List<SupportEngineer> supportEngineers = supportEngineerService.getAllSupportEngineers();
        return ResponseEntity.ok(supportEngineers);
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<SupportEngineer> getSupportEngineerById(@PathVariable Integer employeeId) {
        Optional<SupportEngineer> supportEngineer = supportEngineerService.getSupportEngineerById(employeeId);
        return supportEngineer.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
