package com.Zealthy.InterviewProject.Models;

import java.util.Date;

import com.Zealthy.InterviewProject.Models.Enums.UserTypes;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Message {
    
    private Integer messageId;
    private Integer senderId;
    private UserTypes usertype;
    private Date dateSent;
    private String content;
    private Integer ticketId;
}
