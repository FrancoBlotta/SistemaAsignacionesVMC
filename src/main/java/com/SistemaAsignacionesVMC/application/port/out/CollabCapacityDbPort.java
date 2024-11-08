package com.SistemaAsignacionesVMC.application.port.out;

import com.SistemaAsignacionesVMC.domain.dtos.CollaboratorCapacityDTO;

import java.util.List;
import java.util.Optional;

public interface CollabCapacityDbPort {
  void saveCollabCapacity(CollaboratorCapacityDTO collaboratorCapacity);

  void deleteCollabCapacityById(Long collabCapacityId);

  void deleteAllByCollaboratorId(Long collaboratorId);

  Optional<CollaboratorCapacityDTO> findCollabCapacityById(Long collabCapacityId);

  Optional<CollaboratorCapacityDTO> findCollabCapacityByCollabId(Long collaboratorId);

  List<CollaboratorCapacityDTO> getAllCollabCapacities();

  List<CollaboratorCapacityDTO> getAllCollabCapacitiesByCollabId(Long collaboratorId);

  void updateCollabCapacity(CollaboratorCapacityDTO collaboratorCapacity);
}
