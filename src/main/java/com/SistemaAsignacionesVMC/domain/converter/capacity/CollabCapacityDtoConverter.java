package com.SistemaAsignacionesVMC.domain.converter.capacity;

import com.SistemaAsignacionesVMC.domain.dtos.CollaboratorCapacityDTO;
import com.SistemaAsignacionesVMC.domain.payload.CollaboratorCapacity;

public class CollabCapacityDtoConverter {
  public static CollaboratorCapacityDTO convert(CollaboratorCapacity collaboratorCapacity) {
    return CollaboratorCapacityDTO.builder()
      .id(collaboratorCapacity.getId())
      .collaboratorId(collaboratorCapacity.getCollaboratorId())
      .taskId(collaboratorCapacity.getTaskId())
      .build();
  }
}
