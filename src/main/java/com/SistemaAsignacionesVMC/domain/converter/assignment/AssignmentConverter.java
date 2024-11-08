package com.SistemaAsignacionesVMC.domain.converter.assignment;

import com.SistemaAsignacionesVMC.domain.dtos.AssignmentDTO;
import com.SistemaAsignacionesVMC.domain.payload.Assignment;

public class AssignmentConverter {
  public static Assignment convert(AssignmentDTO assignment) {
    return Assignment.builder()
      .id(assignment.getId())
      .assignmentName(assignment.getAssignmentName())
      .build();
  }
}
