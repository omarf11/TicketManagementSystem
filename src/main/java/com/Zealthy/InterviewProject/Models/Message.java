package com.Zealthy.InterviewProject.Models;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Message {
    
    private String messageId;
    private String senderId;
    private String dateSent;
    private String content;
}
