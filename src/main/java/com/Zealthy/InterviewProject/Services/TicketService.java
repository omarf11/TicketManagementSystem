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

    public Optional<Ticket> getTicketById(Integer ticketId) {
        return ticketRepository.findById(ticketId);
    }

    public void updateTicketStatus(Integer ticketId, TicketStatus newStatus) {
        Optional<Ticket> optionalTicket = ticketRepository.findById(ticketId);
        optionalTicket.ifPresent(ticket -> {
            ticket.setTicketStatus(newStatus);
            ticketRepository.save(ticket);
        });
    }

    public Optional<List<Ticket>> getAllTicketsByUserId(Integer userId) {
        return ticketRepository.findByUserId(userId);
    }
    

    public  Optional<List<Ticket>> getAllTicketsByEngineerId(Integer engineerId) {
        return ticketRepository.findByEngineerId(engineerId);
    }

    public void assignTicketToEngineer(Integer ticketId, Integer engineerId) {
        Optional<Ticket> optionalTicket = ticketRepository.findById(ticketId);
        optionalTicket.ifPresent(ticket -> {
            ticket.setEngineerId(engineerId);
            ticketRepository.save(ticket);
        });
    }

    public void removeEngineerFromTicket(Integer ticketId) {
        Optional<Ticket> optionalTicket = ticketRepository.findById(ticketId);
        optionalTicket.ifPresent(ticket -> {
            ticket.setEngineerId(null);
            ticketRepository.save(ticket);
        });
    }
}
