package com.Zealthy.InterviewProject.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Zealthy.InterviewProject.Models.Ticket;
import com.Zealthy.InterviewProject.Models.Enums.TicketStatus;
import com.Zealthy.InterviewProject.Services.TicketService;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {
    
    //create ticket
    
    //get all tickets
    //update ticket status
    //get all tickets by user ID
    //get all tickets by support engineer ID
    //assign ticket to engineer
    //remove engineer from ticket
    //add response to ticket

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping
    public ResponseEntity<Ticket> createTicket(@RequestBody Ticket ticket) {
        Ticket createdTicket = ticketService.createTicket(ticket);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTicket);
    }

    @GetMapping
    public ResponseEntity<List<Ticket>> getAllTickets() {
        List<Ticket> tickets = ticketService.getAllTickets();
        return ResponseEntity.ok(tickets);
    }

    @GetMapping("/{ticketId}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable Integer ticketId) {
        Optional<Ticket> optionalTicket = ticketService.getTicketById(ticketId);
        return optionalTicket.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{ticketId}/status")
    public ResponseEntity<Ticket> updateTicketStatus(
            @PathVariable Integer ticketId,
            @RequestParam TicketStatus newStatus
    ) {

       return ResponseEntity.ok( ticketService.updateTicketStatus(ticketId, newStatus));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Ticket>> getAllTicketsByUserId(@PathVariable Integer userId) {
        Optional<List<Ticket>> optionalTickets = ticketService.getAllTicketsByUserId(userId);
        return optionalTickets.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/engineer/{engineerId}")
    public ResponseEntity<List<Ticket>> getAllTicketsByEngineerId(@PathVariable Integer engineerId) {
        Optional<List<Ticket>> optionalTickets =ticketService.getAllTicketsByEngineerId(engineerId);
        return optionalTickets.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{ticketId}/assign")
    public ResponseEntity<Ticket> assignTicketToEngineer(
            @PathVariable Integer ticketId,
            @RequestParam Integer engineerId
    ) {
       return ResponseEntity.ok( ticketService.assignTicketToEngineer(ticketId, engineerId));
    }

    @PutMapping("/{ticketId}/remove-engineer")
    public ResponseEntity<Ticket> removeEngineerFromTicket(@PathVariable Integer ticketId) {
       return ResponseEntity.ok( ticketService.removeEngineerFromTicket(ticketId));

    }
}
