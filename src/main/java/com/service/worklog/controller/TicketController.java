package com.service.worklog.controller;

import com.service.worklog.domain.Ticket;
import com.service.worklog.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/tickets")
@CrossOrigin(origins = "http://localhost:4200")
public class TicketController {

  private final TicketService ticketService;

  @Autowired
  public TicketController(TicketService ticketService) {
    this.ticketService = ticketService;
  }

  @GetMapping
  public Page<Ticket> findAll(Specification<Ticket> specification, Pageable pageable) {
    return ticketService.getTickets(specification, pageable);
  }

  @GetMapping("/{id}")
  public Ticket findById(@PathVariable Long id) {
    return ticketService.getTicket(id);
  }

  @PutMapping("/{id}")
  public Ticket update(@PathVariable Long id, @RequestBody Ticket ticket) {
    ticket.setTicketId(id);
    return ticketService.saveTicket(ticket);
  }

  @PostMapping
  public Ticket save(@RequestBody Ticket ticket) {
    return ticketService.saveTicket(ticket);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    ticketService.deleteTicket(id);
  }
}
