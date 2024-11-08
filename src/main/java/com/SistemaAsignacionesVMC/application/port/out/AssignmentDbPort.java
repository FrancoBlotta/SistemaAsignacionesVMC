package com.SistemaAsignacionesVMC.application.port.out;

import com.SistemaAsignacionesVMC.domain.dtos.AssignmentDTO;

import java.util.List;
import java.util.Optional;

public interface AssignmentDbPort {
  void deleteAssignmentById(Long assignmentId);

  Optional<AssignmentDTO> findAssignmentById(Long assignmentId);

  List<AssignmentDTO> getAllAssignments();

  void saveAssignment(AssignmentDTO assignment);

  void updateAssignment(AssignmentDTO assignment);
}
