package com.SistemaAsignacionesVMC.infrastructure.adapter.out.database.entities.converter;

import com.SistemaAsignacionesVMC.domain.dtos.CollaboratorDTO;
import com.SistemaAsignacionesVMC.domain.dtos.TaskDTO;
import com.SistemaAsignacionesVMC.domain.dtos.TaskHistoryDTO;
import com.SistemaAsignacionesVMC.infrastructure.adapter.out.database.entities.TaskHistoryEntity;

public class TaskHistoryEntityConverter {
  public static TaskHistoryEntity convert(TaskHistoryDTO taskHistory) {
    return TaskHistoryEntity.builder()
      .collaboratorId(taskHistory.getCollaborator().getId())
      .taskId(taskHistory.getTask().getId())
      .eventId(taskHistory.getEventId())
      .build();
  }

  public static TaskHistoryDTO convert(TaskHistoryEntity taskHistory) {
    return TaskHistoryDTO.builder()
      .collaborator(CollaboratorDTO.builder()
        .id(taskHistory.getCollaboratorId())
        .build())
      .task(TaskDTO.builder()
        .id(taskHistory.getTaskId())
        .build())
      .eventId(taskHistory.getEventId())
      .build();
  }
}
