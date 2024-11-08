package com.SistemaAsignacionesVMC.infrastructure.adapter.out.database.entities.converter;

import com.SistemaAsignacionesVMC.domain.dtos.CollaboratorCapacityDTO;
import com.SistemaAsignacionesVMC.infrastructure.adapter.out.database.entities.CollaboratorCapacityEntity;

public class CollabCapacityEntityConverter {
  public static CollaboratorCapacityDTO convert(CollaboratorCapacityEntity collabCapacity) {
    return CollaboratorCapacityDTO.builder()
      .id(collabCapacity.getId())
      .collaboratorId(collabCapacity.getCollaboratorId())
      .taskId(collabCapacity.getTaskId())
      .build();
  }

  public static CollaboratorCapacityEntity convert(CollaboratorCapacityDTO collabCapacity) {
    return CollaboratorCapacityEntity.builder()
      .id(collabCapacity.getId())
      .collaboratorId(collabCapacity.getCollaboratorId())
      .taskId(collabCapacity.getTaskId())
      .build();
  }
}
