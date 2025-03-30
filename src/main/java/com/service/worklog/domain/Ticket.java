package com.service.worklog.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ticket", uniqueConstraints = {
    @UniqueConstraint(name = "uc_ticket_name", columnNames = {"name"})
})
public class Ticket {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long ticketId;

  private String name;

  private String description;
}
