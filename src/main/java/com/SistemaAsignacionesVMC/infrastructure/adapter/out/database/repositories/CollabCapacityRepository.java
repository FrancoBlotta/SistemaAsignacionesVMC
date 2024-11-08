package com.SistemaAsignacionesVMC.infrastructure.adapter.out.database.repositories;

import com.SistemaAsignacionesVMC.infrastructure.adapter.out.database.entities.CollaboratorCapacityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface CollabCapacityRepository extends JpaRepository<CollaboratorCapacityEntity, Long> {
  void deleteAllByCollaboratorId(Long collaboratorId);

  Optional<CollaboratorCapacityEntity> findByCollaboratorId(Long collaboratorId);

  List<CollaboratorCapacityEntity> findAllByCollaboratorId(Long collaboratorId);
}
