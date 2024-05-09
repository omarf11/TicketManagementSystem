package com.Zealthy.InterviewProject.Repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.Zealthy.InterviewProject.Models.Ticket;

public interface TicketRepository extends MongoRepository<Ticket, Integer>{
    
}
