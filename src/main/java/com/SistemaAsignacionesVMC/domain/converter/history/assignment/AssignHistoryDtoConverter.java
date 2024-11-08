package com.SistemaAsignacionesVMC.domain.converter.history.assignment;

import com.SistemaAsignacionesVMC.domain.converter.assignment.AssignmentDtoConverter;
import com.SistemaAsignacionesVMC.domain.converter.collaborator.CollaboratorDtoConverter;
import com.SistemaAsignacionesVMC.domain.dtos.AssignmentHistoryDTO;
import com.SistemaAsignacionesVMC.domain.payload.AssignmentHistory;

public class AssignHistoryDtoConverter {
  public static AssignmentHistoryDTO convert(AssignmentHistory assignmentHistory) {
    return AssignmentHistoryDTO.builder()
      .id(assignmentHistory.getId())
      .eventId(assignmentHistory.getEventId())
      .collaborator(CollaboratorDtoConverter.convert(assignmentHistory.getCollaborator()))
      .isAssistant(assignmentHistory.getIsAssistant())
      .assignment(AssignmentDtoConverter.convert(assignmentHistory.getAssignment()))
      .build();
  }
}
