package com.SistemaAsignacionesVMC.domain.converter.capacity;

import com.SistemaAsignacionesVMC.domain.dtos.CollaboratorCapacityDTO;
import com.SistemaAsignacionesVMC.domain.payload.CollaboratorCapacity;

public class CollabCapacityConverter {
  public static CollaboratorCapacity convert(CollaboratorCapacityDTO collaboratorCapacity) {
    return CollaboratorCapacity.builder()
      .id(collaboratorCapacity.getId())
      .collaboratorId(collaboratorCapacity.getCollaboratorId())
      .taskId(collaboratorCapacity.getTaskId())
      .build();
  }
}
