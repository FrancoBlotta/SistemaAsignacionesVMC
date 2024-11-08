package com.SistemaAsignacionesVMC.domain.converter.history.task;

import com.SistemaAsignacionesVMC.domain.converter.collaborator.CollaboratorDtoConverter;
import com.SistemaAsignacionesVMC.domain.converter.task.TaskDtoConverter;
import com.SistemaAsignacionesVMC.domain.dtos.TaskHistoryDTO;
import com.SistemaAsignacionesVMC.domain.payload.TaskHistory;

public class TaskHistoryDtoConverter {
  public static TaskHistoryDTO convert(TaskHistory taskHistory) {
    return TaskHistoryDTO.builder()
      .id(taskHistory.getId())
      .collaborator(CollaboratorDtoConverter.convert(taskHistory.getCollaborator()))
      .task(TaskDtoConverter.convert(taskHistory.getTask()))
      .eventId(taskHistory.getEventId())
      .build();
  }
}
