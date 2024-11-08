package com.SistemaAsignacionesVMC.infrastructure.adapter.out.database.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "assignment_history")
public class AssignmentHistoryEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  @Column(name = "event_id", nullable = false)
  Long eventId;

  @Column(name = "assignment_id", nullable = false)
  Long assignmentId;

  @Column(name = "collaborator_id", nullable = false)
  Long collaboratorId;

  @Column(name = "is_assistant", nullable = false)
  Boolean isAssistant;
}
