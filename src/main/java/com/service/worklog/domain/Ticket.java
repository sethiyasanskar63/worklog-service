package com.service.worklog.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "ticket")
@Table(name = "ticket", uniqueConstraints = {
    @UniqueConstraint(name = "uc_ticket_ticketid_name", columnNames = {"ticketId", "name"})
})
public class Ticket {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long ticketId;

  private String name;

  private String description;

  @OneToMany(mappedBy = "ticket", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
  private List<TimeCard> timeCards;
}
