package com.SistemaAsignacionesVMC.application.port.in;

import com.SistemaAsignacionesVMC.domain.dtos.CollaboratorCapacityDTO;

import java.util.List;

public interface CollabCapacityUseCase {
  void createCollabCapacity(CollaboratorCapacityDTO collaboratorCapacity);

  void deleteCollabCapacityById(Long collabCapacityId);

  CollaboratorCapacityDTO findCollabCapacityById(Long collabCapacityId);

  List<CollaboratorCapacityDTO> getAllCollabCapacities();

  void updateCollabCapacity(CollaboratorCapacityDTO collaboratorCapacity);
}
