package com.SistemaAsignacionesVMC.infrastructure.adapter.out.database;

import com.SistemaAsignacionesVMC.application.port.out.AssignmentDbPort;
import com.SistemaAsignacionesVMC.domain.dtos.AssignmentDTO;
import com.SistemaAsignacionesVMC.infrastructure.adapter.out.database.entities.AssignmentEntity;
import com.SistemaAsignacionesVMC.infrastructure.adapter.out.database.entities.converter.AssignmentEntityConverter;
import com.SistemaAsignacionesVMC.infrastructure.adapter.out.database.repositories.AssignmentRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor(staticName = "of")
public class AssignmentPostgresAdapter implements AssignmentDbPort {

  private final AssignmentRepository assignmentRepository;

  @Override
  public void deleteAssignmentById(Long assignmentId) {
    assignmentRepository.deleteById(assignmentId);
  }

  @Override
  public Optional<AssignmentDTO> findAssignmentById(Long assignmentId) {
    return assignmentRepository.findById(assignmentId)
      .map(AssignmentEntityConverter::convert);
  }

  @Override
  public List<AssignmentDTO> getAllAssignments() {
    return assignmentRepository.findAll()
      .stream()
      .map(AssignmentEntityConverter::convert)
      .collect(Collectors.toList());
  }

  @Override
  public void saveAssignment(AssignmentDTO assignment) {
    AssignmentEntity assignmentEntity = AssignmentEntityConverter.convert(assignment);
    assignmentRepository.save(assignmentEntity);
  }

  @Override
  public void updateAssignment(AssignmentDTO assignment) {
    saveAssignment(assignment);
  }
}
