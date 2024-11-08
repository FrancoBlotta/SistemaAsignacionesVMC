package com.SistemaAsignacionesVMC.domain.converter.history.assignment;

import com.SistemaAsignacionesVMC.domain.converter.assignment.AssignmentConverter;
import com.SistemaAsignacionesVMC.domain.converter.collaborator.CollaboratorConverter;
import com.SistemaAsignacionesVMC.domain.dtos.AssignmentHistoryDTO;
import com.SistemaAsignacionesVMC.domain.payload.AssignmentHistory;

public class AssignHistoryConverter {
  public static AssignmentHistory convert(AssignmentHistoryDTO assignmentHistory) {
    return AssignmentHistory.builder()
      .id(assignmentHistory.getId())
      .eventId(assignmentHistory.getEventId())
      .collaborator(CollaboratorConverter.convert(assignmentHistory.getCollaborator()))
      .isAssistant(assignmentHistory.getIsAssistant())
      .assignment(AssignmentConverter.convert(assignmentHistory.getAssignment()))
      .build();
  }
}
