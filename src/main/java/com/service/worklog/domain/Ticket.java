package com.service.worklog.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
