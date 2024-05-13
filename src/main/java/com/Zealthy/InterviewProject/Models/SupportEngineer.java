package com.Zealthy.InterviewProject.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Document(collection = "engineers")
@Data
@Builder
@AllArgsConstructor
public class SupportEngineer implements ApiResponse{
    
    @Id
    private Integer employeeId;
    private String firstName;
    private String lastName;
}
