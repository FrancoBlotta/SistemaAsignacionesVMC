package com.SistemaAsignacionesVMC.domain.converter.assignment;

import com.SistemaAsignacionesVMC.domain.dtos.AssignmentDTO;
import com.SistemaAsignacionesVMC.domain.payload.Assignment;

public class AssignmentDtoConverter {
  public static AssignmentDTO convert(Assignment assignment) {
    return AssignmentDTO.builder()
      .id(assignment.getId())
      .assignmentName(assignment.getAssignmentName())
      .build();
  }
}
