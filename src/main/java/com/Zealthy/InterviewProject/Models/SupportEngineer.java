package com.Zealthy.InterviewProject.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class SupportEngineer {
    
    private Integer employeeId;
    private String firstName;
    private String lastName;
}
