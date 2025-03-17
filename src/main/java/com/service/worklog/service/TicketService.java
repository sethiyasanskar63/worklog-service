package com.service.worklog.service;

import com.service.worklog.domain.Ticket;
import com.service.worklog.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class TicketService {

  private final TicketRepository ticketRepository;

  @Autowired
  public TicketService(TicketRepository ticketRepository) {
    this.ticketRepository = ticketRepository;
  }

  public Page<Ticket> getTickets(Specification<Ticket> specification, Pageable pageable) {
    return ticketRepository.findAll(specification, pageable);
  }

  public Ticket getTicket(Long id) {
    return ticketRepository.findById(id).orElse(null);
  }

  public Ticket saveTicket(Ticket ticket) {
    return ticketRepository.save(ticket);
  }

  public void deleteTicket(Long id) {
    ticketRepository.deleteById(id);
  }
}
