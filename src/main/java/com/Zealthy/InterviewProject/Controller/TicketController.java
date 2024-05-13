package com.Zealthy.InterviewProject.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Zealthy.InterviewProject.Models.ApiResponse;
import com.Zealthy.InterviewProject.Models.ErrorMessage;
import com.Zealthy.InterviewProject.Models.Ticket;
import com.Zealthy.InterviewProject.Models.Enums.TicketStatus;
import com.Zealthy.InterviewProject.Services.TicketService;

@CrossOrigin(origins = "*") 
@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    // create ticket

    // get all tickets
    // update ticket status
    // get all tickets by user ID
    // get all tickets by support engineer ID
    // assign ticket to engineer
    // remove engineer from ticket
    // add response to ticket

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse> createTicket(@RequestBody Ticket ticket) {

        try {
            Ticket createdTicket = ticketService.createTicket(ticket);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdTicket);

        } catch (Exception e) {

            System.out.println(e.getMessage());
            e.printStackTrace();
            ErrorMessage errorMessage = ErrorMessage
                    .builder()
                    .message(e.getMessage())
                    .build();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(errorMessage);
        }
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
    public ResponseEntity<ApiResponse> updateTicketStatus(
            @PathVariable Integer ticketId,
            @RequestParam TicketStatus newStatus) {

        try {
            return ResponseEntity.ok(ticketService.updateTicketStatus(ticketId, newStatus));

        } catch (Exception e) {

            System.out.println(e.getMessage());
            e.printStackTrace();
            ErrorMessage errorMessage = ErrorMessage
                    .builder()
                    .message(e.getMessage())
                    .build();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(errorMessage);
        }
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Ticket>> getAllTicketsByUserId(@PathVariable Integer userId) {
        Optional<List<Ticket>> optionalTickets = ticketService.getAllTicketsByUserId(userId);
        return optionalTickets.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/engineer/{engineerId}")
    public ResponseEntity<List<Ticket>> getAllTicketsByEngineerId(@PathVariable Integer engineerId) {

        Optional<List<Ticket>> optionalTickets = ticketService.getAllTicketsByEngineerId(engineerId);
        return optionalTickets.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

    }

    @PutMapping("/{ticketId}/assign")
    public ResponseEntity<ApiResponse> assignTicketToEngineer(
            @PathVariable Integer ticketId,
            @RequestParam Integer engineerId) {
        try {
            return ResponseEntity.ok(ticketService.assignTicketToEngineer(ticketId, engineerId));

        } catch (Exception e) {

            System.out.println(e.getMessage());
            e.printStackTrace();
            ErrorMessage errorMessage = ErrorMessage
                    .builder()
                    .message(e.getMessage())
                    .build();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(errorMessage);
        }
    }

    @PutMapping("/{ticketId}/remove-engineer")
    public ResponseEntity<ApiResponse> removeEngineerFromTicket(@PathVariable Integer ticketId) {
        try {
            return ResponseEntity.ok(ticketService.removeEngineerFromTicket(ticketId));

        } catch (Exception e) {

            System.out.println(e.getMessage());
            e.printStackTrace();
            ErrorMessage errorMessage = ErrorMessage
                    .builder()
                    .message(e.getMessage())
                    .build();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(errorMessage);
        }
    }
}
