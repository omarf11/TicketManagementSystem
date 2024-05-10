package com.Zealthy.InterviewProject.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.Zealthy.InterviewProject.Models.Ticket;

public interface TicketRepository extends MongoRepository<Ticket, Integer> {
    Optional<List<Ticket>> findByUserId(Integer userId);

    Optional<List<Ticket>> findByEngineerId(Integer engineerId);
}
