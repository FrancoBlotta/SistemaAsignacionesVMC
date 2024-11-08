package com.SistemaAsignacionesVMC.domain.converter.history.task;

import com.SistemaAsignacionesVMC.domain.converter.collaborator.CollaboratorConverter;
import com.SistemaAsignacionesVMC.domain.converter.task.TaskConverter;
import com.SistemaAsignacionesVMC.domain.dtos.TaskHistoryDTO;
import com.SistemaAsignacionesVMC.domain.payload.TaskHistory;

public class TaskHistoryConverter {
  public static TaskHistory convert(TaskHistoryDTO taskHistory) {
    return TaskHistory.builder()
      .id(taskHistory.getId())
      .collaborator(CollaboratorConverter.convert(taskHistory.getCollaborator()))
      .task(TaskConverter.convert(taskHistory.getTask()))
      .eventId(taskHistory.getEventId())
      .build();
  }
}
