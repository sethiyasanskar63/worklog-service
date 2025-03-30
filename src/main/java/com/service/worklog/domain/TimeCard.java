package com.service.worklog.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "time_card")
public class TimeCard {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long timeCardId;

  @ManyToOne
  @JoinColumn(name = "ticket_id", referencedColumnName = "ticketId", nullable = false)
  private Ticket ticket;

  @Column(nullable = false)
  private LocalDate date;

  @Column(nullable = false)
  private Double timeSpent;
}
