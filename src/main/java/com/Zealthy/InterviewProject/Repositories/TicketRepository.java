package com.Zealthy.InterviewProject.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.Zealthy.InterviewProject.Models.Ticket;

public interface TicketRepository extends MongoRepository<Ticket, String> {
    Optional<List<Ticket>> findByUserId(String userId);

    Optional<List<Ticket>> findByEngineerId(String engineerId);
}
