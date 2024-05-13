package com.Zealthy.InterviewProject.Models;

import com.Zealthy.InterviewProject.Models.Enums.UserTypes;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Message {
    
    private Integer messageId;
    private Integer senderId;
    private UserTypes usertype;
    private String dateSent;
    private String content;
    private Integer ticketId;
}
