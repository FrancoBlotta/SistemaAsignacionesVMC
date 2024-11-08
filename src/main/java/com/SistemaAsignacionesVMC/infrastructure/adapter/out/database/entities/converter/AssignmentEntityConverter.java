package com.SistemaAsignacionesVMC.infrastructure.adapter.out.database.entities.converter;

import com.SistemaAsignacionesVMC.domain.dtos.AssignmentDTO;
import com.SistemaAsignacionesVMC.infrastructure.adapter.out.database.entities.AssignmentEntity;

public class AssignmentEntityConverter {
  public static AssignmentDTO convert(AssignmentEntity assignment) {
    return AssignmentDTO.builder()
      .id(assignment.getId())
      .assignmentName(assignment.getAssignmentName())
      .build();
  }

  public static AssignmentEntity convert(AssignmentDTO assignment) {
    return AssignmentEntity.builder()
      .id(assignment.getId())
      .assignmentName(assignment.getAssignmentName())
      .build();
  }
}
