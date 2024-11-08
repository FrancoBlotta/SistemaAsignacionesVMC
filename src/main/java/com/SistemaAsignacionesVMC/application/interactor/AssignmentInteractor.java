package com.SistemaAsignacionesVMC.application.interactor;

import com.SistemaAsignacionesVMC.application.port.in.AssignmentUseCase;
import com.SistemaAsignacionesVMC.application.port.out.AssignmentDbPort;
import com.SistemaAsignacionesVMC.domain.dtos.AssignmentDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class AssignmentInteractor implements AssignmentUseCase {

  private final AssignmentDbPort assignmentDbPort;

  @Transactional(readOnly = true)
  @Override
  public AssignmentDTO findAssignmentById(Long assignmentId) {
    return assignmentDbPort.findAssignmentById(assignmentId)
      .orElseThrow(() -> new RuntimeException("Assignment with ID " + assignmentId + " does not exist"));
  }

  @Transactional(readOnly = true)
  @Override
  public List<AssignmentDTO> getAllAssignments() {
    return assignmentDbPort.getAllAssignments();
  }
}
