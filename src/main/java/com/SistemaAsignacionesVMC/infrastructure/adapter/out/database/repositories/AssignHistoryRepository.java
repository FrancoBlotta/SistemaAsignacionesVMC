package com.SistemaAsignacionesVMC.infrastructure.adapter.out.database.repositories;

import com.SistemaAsignacionesVMC.infrastructure.adapter.out.database.entities.AssignmentHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssignHistoryRepository extends JpaRepository<AssignmentHistoryEntity, Long> {
  void deleteAllByCollaboratorId(Long collaboratorId);

  List<AssignmentHistoryEntity> findAllByEventId(Long eventId);
}
