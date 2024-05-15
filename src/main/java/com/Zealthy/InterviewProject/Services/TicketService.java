package com.Zealthy.InterviewProject.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Zealthy.InterviewProject.Models.Ticket;
import com.Zealthy.InterviewProject.Models.Enums.TicketStatus;
import com.Zealthy.InterviewProject.Repositories.TicketRepository;

@Service
public class TicketService {
    
     private final TicketRepository ticketRepository;

   
    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public Ticket createTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    public Optional<Ticket> getTicketById(String ticketId) {
        return ticketRepository.findById(ticketId);
    }

    public Ticket updateTicketStatus(String ticketId, TicketStatus newStatus) {
        Optional<Ticket> optionalTicket = ticketRepository.findById(ticketId);
         optionalTicket.ifPresent(ticket -> {
            ticket.setTicketStatus(newStatus);
            ticketRepository.save(ticket);
        });

        return optionalTicket.get();
    }

    public Optional<List<Ticket>> getAllTicketsByUserId(String userId) {
        return ticketRepository.findByUserId(userId);
    }
    

    public  Optional<List<Ticket>> getAllTicketsByEngineerId(String engineerId) {
        return ticketRepository.findByEngineerId(engineerId);
    }

    public Ticket assignTicketToEngineer(String ticketId, String engineerId) {
        Optional<Ticket> optionalTicket = ticketRepository.findById(ticketId);
        optionalTicket.ifPresent(ticket -> {
            ticket.setEngineerId(engineerId);
            ticketRepository.save(ticket);
        });

        return optionalTicket.get();
    }

    public Ticket removeEngineerFromTicket(String ticketId) {
        Optional<Ticket> optionalTicket = ticketRepository.findById(ticketId);
        optionalTicket.ifPresent(ticket -> {
            ticket.setEngineerId(null);
            ticketRepository.save(ticket);
        });

        return optionalTicket.get();
    }
}
