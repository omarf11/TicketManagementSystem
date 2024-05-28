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
import com.Zealthy.InterviewProject.Models.Message;
import com.Zealthy.InterviewProject.Models.Ticket;
import com.Zealthy.InterviewProject.Models.Enums.TicketStatus;
import com.Zealthy.InterviewProject.Services.TicketService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/tickets")
public class TicketController {

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

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ErrorMessage
                    .builder()
                    .message(e.getMessage())
                    .build());
        }
    }

    @GetMapping
    public ResponseEntity<List<Ticket>> getAllTickets() {
        List<Ticket> tickets = ticketService.getAllTickets();
        return ResponseEntity.ok(tickets);
    }

    @GetMapping("/{ticketId}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable String ticketId) {
        Optional<Ticket> optionalTicket = ticketService.getTicketById(ticketId);
        return optionalTicket.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{ticketId}/status")
    public ResponseEntity<ApiResponse> updateTicketStatus(
            @PathVariable String ticketId,
            @RequestParam TicketStatus newStatus) {

        try {
            return ResponseEntity.ok(ticketService.updateTicketStatus(ticketId, newStatus));

        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ErrorMessage
                            .builder()
                            .message(e.getMessage())
                            .build());
        }
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Ticket>> getAllTicketsByUserId(@PathVariable String userId) {
        Optional<List<Ticket>> optionalTickets = ticketService.getAllTicketsByUserId(userId);
        return optionalTickets.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{ticketId}/assign")
    public ResponseEntity<ApiResponse> assignTicketToEngineer(
            @PathVariable String ticketId,
            @RequestParam String engineerId) {
        try {
            return ResponseEntity.ok(ticketService.assignTicketToEngineer(ticketId, engineerId));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ErrorMessage
                            .builder()
                            .message(e.getMessage())
                            .build());
        }
    }
    @PutMapping("/addMessage/{ticketId}")
    public ResponseEntity<ApiResponse> addMessageToTicket(
            @PathVariable String ticketId,
            @RequestBody Message message) {
        try {
            return ResponseEntity.ok(ticketService.addMessage(ticketId, message));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ErrorMessage
                            .builder()
                            .message(e.getMessage())
                            .build());
        }
    }
}
