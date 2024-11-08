package com.SistemaAsignacionesVMC.infrastructure.adapter.out.database.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "collaborator_capacity")
public class CollaboratorCapacityEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  @Column(name = "collaborator_id", nullable = false)
  Long collaboratorId;

  @Column(name = "task_id", nullable = false)
  Long taskId;
}
