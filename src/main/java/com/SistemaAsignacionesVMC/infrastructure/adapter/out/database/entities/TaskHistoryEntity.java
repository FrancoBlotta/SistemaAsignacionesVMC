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
@Table(name = "task_history")
public class TaskHistoryEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  @Column(name = "collaborator_id", nullable = false)
  Long collaboratorId;

  @Column(name = "task_id", nullable = false)
  Long taskId;

  @Column(name = "event_id", nullable = false)
  Long eventId;
}
