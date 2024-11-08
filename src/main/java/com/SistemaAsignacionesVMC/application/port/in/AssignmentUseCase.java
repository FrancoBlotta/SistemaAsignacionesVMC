package com.SistemaAsignacionesVMC.application.port.in;

import com.SistemaAsignacionesVMC.domain.dtos.AssignmentDTO;

import java.util.List;

public interface AssignmentUseCase {
  AssignmentDTO findAssignmentById(Long assignmentId);

  List<AssignmentDTO> getAllAssignments();
}
