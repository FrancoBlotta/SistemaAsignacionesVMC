package com.SistemaAsignacionesVMC.application.interactor.assignment;

import com.SistemaAsignacionesVMC.application.port.out.AssignHistoryDbPort;
import com.SistemaAsignacionesVMC.application.port.out.AssignmentDbPort;
import com.SistemaAsignacionesVMC.application.port.out.CollaboratorDbPort;
import com.SistemaAsignacionesVMC.domain.dtos.AssignmentDTO;
import com.SistemaAsignacionesVMC.domain.dtos.AssignmentHistoryDTO;
import com.SistemaAsignacionesVMC.domain.dtos.CollaboratorDTO;
import com.SistemaAsignacionesVMC.domain.dtos.EventDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
public class AssignmentHistoryManager {

  private final AssignHistoryDbPort assignHistoryDbPort;

  private final CollaboratorDbPort collaboratorDbPort;

  private final AssignmentDbPort assignmentDbPort;

  /**
   * Fill assignment histories list with assignment and collaborator data.
   * @param event
   * @return
   */
  @Transactional(readOnly = true)
  public List<AssignmentHistoryDTO> fillAssignmentHistories(EventDTO event) {
    return assignHistoryDbPort.getAllAssignHistoriesByEventId(event.getId())
      .stream()
      .map(savedAssignmentHistory -> {
        AssignmentDTO savedAssignment = assignmentDbPort.findAssignmentById(savedAssignmentHistory.getAssignment().getId())
          .orElseThrow(() -> new RuntimeException("Assignment with ID " + savedAssignmentHistory.getAssignment().getId() + " does not exist"));
        CollaboratorDTO responsible = collaboratorDbPort.findCollaboratorById(savedAssignmentHistory.getCollaborator().getId())
          .orElseThrow(() -> new RuntimeException("Collaborator with ID " + savedAssignmentHistory.getCollaborator().getId() + " does not exist"));
        return savedAssignmentHistory.withAssignment(savedAssignment).withCollaborator(responsible);
      }).toList();
  }
}
