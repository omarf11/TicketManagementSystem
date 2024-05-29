package com.Zealthy.InterviewProject.Models;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.Zealthy.InterviewProject.Models.Enums.TicketStatus;
import com.mongodb.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document("tickets")
public class Ticket implements ApiResponse{
    
    @Id
    private String ticketId;
    private String userId;
    private String subject;
    @Nullable
    private String engineerId;
    private TicketStatus ticketStatus;
    private String description;

    @Builder.Default
    private List<Message> messages = new ArrayList<>();
    private String createdAt;

    public void addMessage(Message message) {
        this.messages.add(message);
    }

}
