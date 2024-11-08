package com.SistemaAsignacionesVMC.infrastructure.adapter.out.database.entities.converter;

import com.SistemaAsignacionesVMC.domain.dtos.AssignmentDTO;
import com.SistemaAsignacionesVMC.domain.dtos.AssignmentHistoryDTO;
import com.SistemaAsignacionesVMC.domain.dtos.CollaboratorDTO;
import com.SistemaAsignacionesVMC.infrastructure.adapter.out.database.entities.AssignmentHistoryEntity;

public class AssignHistoryEntityConverter {
  public static AssignmentHistoryDTO convert(AssignmentHistoryEntity assignmentHistory) {
    return AssignmentHistoryDTO.builder()
      .id(assignmentHistory.getId())
      .eventId(assignmentHistory.getEventId())
      .assignment(AssignmentDTO.builder()
        .id(assignmentHistory.getAssignmentId())
        .build())
      .collaborator(CollaboratorDTO.builder()
        .id(assignmentHistory.getCollaboratorId())
        .build())
      .isAssistant(assignmentHistory.getIsAssistant())
      .build();
  }

  public static AssignmentHistoryEntity convert(AssignmentHistoryDTO assignmentHistory) {
    return AssignmentHistoryEntity.builder()
      .id(assignmentHistory.getId())
      .eventId(assignmentHistory.getEventId())
      .assignmentId(assignmentHistory.getAssignment().getId())
      .collaboratorId(assignmentHistory.getCollaborator().getId())
      .isAssistant(assignmentHistory.getIsAssistant())
      .build();
  }
}
