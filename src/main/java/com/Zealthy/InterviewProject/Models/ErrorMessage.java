package com.Zealthy.InterviewProject.Models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorMessage implements ApiResponse {
    String message;
}
