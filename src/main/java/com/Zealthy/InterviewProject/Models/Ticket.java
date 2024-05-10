package com.Zealthy.InterviewProject.Models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.Zealthy.InterviewProject.Models.Enums.TicketStatus;
import com.mongodb.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
@Document("tickets")
public class Ticket {
    
    @Id
    private Integer ticketId;
    private Integer userId;

    @Nullable
    private Integer engineerId;
    private TicketStatus ticketStatus;
    private String description;
    private List<Message> messages;

}
